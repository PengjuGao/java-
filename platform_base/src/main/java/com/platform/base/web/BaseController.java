package com.platform.base.web;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platform.base.common.page.PageBean;
import com.platform.base.service.BaseService;
import com.platform.base.utils.BeanFactory;
import com.platform.base.utils.ReflectUtils;
import com.platform.base.utils.StringEscapeEditor;
import com.platform.base.utils.StringUtils;


public abstract class BaseController<T,E> {
	
	/**
	 * po类
	 */
	private Class<T> entityClassT;
	
	/**
	 * 辅助类
	 */
	private Class<E> entityClassE;
	
	
	/**
	 * service 超类
	 */
	private BaseService<T, E> baseService;
	
	
	/**
	 * 组装条件vo需要用到
	 */
	public final static String SUFFIX = "ConditionVo";
	
	/**
	 * 条件vo所在的包
	 */
	public final static String PACKAGE_NAME = "com.platform.core.vo.condition";
	
	/**通过传入的po类依次找到其对应的辅助类，service，dao
	 * 1.命名规范：po- pfUser  vo  pfUserExample  service  pfUserService dao  pfUserMapper
	 * 
	 * 2.通过获取po类通过 上下文 获取对应的实体类
	 * ***/
	
	@SuppressWarnings("unchecked")
	public BaseController(){
		
		Object object = this.getClass().getGenericSuperclass();
		if (object instanceof ParameterizedType){
			this.entityClassT = (Class<T>) ((ParameterizedType) object).getActualTypeArguments()[0];
			this.entityClassE = (Class<E>) ((ParameterizedType) object).getActualTypeArguments()[1];
		}
		
		if (null == baseService && null != entityClassT) {
			baseService = BeanFactory.getBean(new StringBuilder().append(StringUtils.toLowerFirstChar(entityClassT.getSimpleName())).append("ServiceImpl").toString());
		}
	}
	
	/**
	 * 根据bo获取对应的service
	 * @param t
	 * @return
	 */
	private BaseService<T,E> getBaseService(Class<T> t){
		
		if (null == baseService && null != entityClassT) {
			baseService = BeanFactory.getBean(new StringBuilder().append(StringUtils.toLowerFirstChar(entityClassT.getSimpleName())).append("ServiceImpl").toString());
		}
		return baseService;
	}
	
	
	/**
	 * 在SpringMVC中，bean中定义了Date，double等类型，如果没有做任何处理的话，日期以及double都无法绑定。
	          解决的办法就是使用spring mvc提供的@InitBinder标签
	          在我的项目中是在BaseController中增加方法initBinder，并使用注解@InitBinder标注，
	          那么spring mvc在绑定表单之前，都会先注册这些编辑器，当然你如果不嫌麻烦，
	          你也可以单独的写在你的每一个controller中。
	          剩下的控制器都继承该类。spring自己提供了大量的实现类，
	          诸如CustomDateEditor ，CustomBooleanEditor，CustomNumberEditor等许多，基本上够用。
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(String.class,new StringEscapeEditor(true));
	}
	
	
	
	/**
	 * service 已获取，然后封装共同的功能，及页面
	 * 1.列表查询
	 * ***/
	@RequestMapping("/delete.html")
	public String deleteData(){
		
		return "";
	}
	
	/**
	 * 列表页面展示
	 * @param t
	 * @param e
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/showListPage.html")
	public String showListPage(T t,E e,PageBean pageBean,HttpServletRequest request,HttpServletResponse response,Model model){
		
		//获取po的类名，全部小写
		String str = t.getClass().getSimpleName().toLowerCase();
		//获取查询条件
		Object vo = getConditionVo(t, request);
		//查询url对应的父菜单ID，展开菜单的时候需要用到
		/*String url = request.getServletPath();
		//TbFunctionService xx =null;
		TbFunctionService service = (TbFunctionService)SpringHolder.getBean("tbFunctionService");
		TbFunctionVo tbVo = new TbFunctionVo();
		Criteria cter = tbVo.createCriteria();
		cter.andFunctionUrlEqualTo(url);
		TbFunction function = service.selectByVo(tbVo).get(0);
		if(function != null){
			String functionId = function.getParentId();
			if("-1".equals(functionId)){
				request.getSession().setAttribute("functionId", function.getId());
			}else{
				request.getSession().setAttribute("functionId", function.getParentId());
			}
		}*/
		//真正的逻辑处理在这里
		this.queryList(vo,t,e,pageBean,request,response,model);
		
		return "business/"+str+"/list";
	}

	/**
	 * 获取查询条件VO类
	 * @param t
	 * @param request
	 * @return
	 */
	private Object getConditionVo(T t, HttpServletRequest request) {
		Object vo = null;
		
		String conditionVoName = PACKAGE_NAME.concat(".").concat(t.getClass().getSimpleName()).concat(SUFFIX);
		
		try {
			Class<?> clazz = Class.forName(conditionVoName);
			
			vo = clazz.newInstance();
			
			List<Field> list = ReflectUtils.getAllFields(clazz);
			
			for (Field field : list) {
				
				String key = field.getName();
				
				String value = request.getParameter(key);
				
				if(StringUtils.isNullString(value)){
					continue;
				}
				String firstLetter = key.substring(0, 1)
						.toUpperCase();
				//调用set方法
				// 获得和属性对应的setXXX()方法
				String setMethodName = "set" + firstLetter
						+ key.substring(1);
				// 调用原对象的setXXX()方法
				Method setMethod = clazz.getMethod(setMethodName,
						new Class[] { field.getType() });
				
				//根据fieldType 转换对象
				Class<?> tempClazz = field.getType();
				
				Object[] tempObject = new Object[]{value};
				
				if(tempClazz.getName().equals("int")){
					tempObject = new Integer[]{Integer.valueOf(value)};
				}else if(tempClazz.getName().equals("char")){
					tempObject = new Character[]{value.charAt(0)};
				}else if(tempClazz.getName().equals("long")){
					tempObject = new Long[]{Long.valueOf(value)};
				}else if(tempClazz.getName().equals("double")){
					tempObject = new Double[]{Double.valueOf(value)};
				}else if(tempClazz.getName().equals("boolean")){
					tempObject = new Boolean[]{Boolean.valueOf(value)};
				}else if(tempClazz.getName().equals("float")){
					tempObject = new Float[]{Float.valueOf(value)};
				}else if(tempClazz.getName().equals("short")){
					tempObject = new Short[]{Short.valueOf(value)};
				}else if(tempClazz.getName().equals("byte")){
					tempObject = new Byte[]{Byte.valueOf(value)};
				}
				
				setMethod.invoke(vo, tempObject);
			}
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			
			e1.printStackTrace();
		} catch (SecurityException e1) {
			
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			
			e1.printStackTrace();
		}
		return vo;
	}
	
	/**
	 * 让子类处理查询的业务逻辑
	 * @param vo
	 * @param t
	 * @param e
	 * @param request
	 * @param response
	 * @param model
	 */
	protected abstract void queryList(Object vo,T t,E e,PageBean pageBean,HttpServletRequest request,HttpServletResponse response,Model model);
	
	
	/**
	 * 新增页面展示
	 * @param t
	 * @param e
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAddPage.html")
	public String showAddPage(T t,E e,HttpServletRequest request,HttpServletResponse response,Model model){
		
		System.out.println(t.getClass().getName()+"-------showAddPage-------");
		//获取po的类名，全部小写
		String str = t.getClass().getSimpleName().toLowerCase();
		
		return "business/"+str+"/add";
	}
	
	
	/**
	 * 展示编辑页面
	 * @param t
	 * @param e
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/showEditPage.html")
	public String showEditPage(BigDecimal id,T t,HttpServletRequest request,HttpServletResponse response,Model model){
		
		System.out.println(t.getClass().getName()+"-------showListPage-------");
		//获取po的类名，全部小写
		String str = t.getClass().getSimpleName().toLowerCase();
		//根据T来获取完整的T
		T temp = this.getBaseService(entityClassT).selectByPrimaryKey(id);
		model.addAttribute("vo", temp);
		
		return "business/"+str+"/edit";
	}
	
	
	/**
	 * 数据保存
	 * @param t
	 * @param e
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/save.html")
	@ResponseBody
	public Object saveData(T t,E e,HttpServletRequest request,HttpServletResponse response,Model model){
		
		int num = this.getBaseService(entityClassT).insert(t);
		
		return null;
	}

	/**
	 * 数据更新
	 * @param t
	 * @param e
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit.html")
	@ResponseBody
	public String UpdateData(T t,E e,HttpServletRequest request,HttpServletResponse response,Model model){
		String url = request.getPathInfo();
		System.out.println(url);
		int num = this.getBaseService(entityClassT).updateByPrimaryKey(t);
		System.out.println(num);
		return "/common/success";
	}
	
}
