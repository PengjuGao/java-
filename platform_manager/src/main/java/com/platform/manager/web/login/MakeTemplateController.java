package com.platform.manager.web.login;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platform.base.common.classTemplate.FilePathConstants;
import com.platform.base.common.classTemplate.FileUtils;
import com.platform.base.common.vo.ConditionTargetVo;
import com.platform.base.common.vo.JSPTemplateVo;
import com.platform.base.common.vo.TargetVo;
import com.platform.base.utils.CommonUtils;
import com.platform.base.utils.html.MyHtmlUtils;


//import com.platform.common.classTemplate.PathParamVo.TemplateType;

@Controller
@RequestMapping("/Template")
public class MakeTemplateController{
	
	//@Autowired
	//private TbFunctionService tbfunctionService;
	
	/**
	 * 展示生成list.jsp的页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/makeListTempLate.html")
	public String makeTempLate(HttpServletRequest request,HttpServletResponse response,Model model){
		//获取所有没有生成list.jsp页面的po类名（此时，类名所有字母是小写）
		List<String> list = MakeTemplateController.getNeededFileName(FilePathConstants.LIST_JSP);
		model.addAttribute("classList", list);
		
		return "/common/generaterJSP/generaterListJSP";
	}
	
	/**
	 * 生成list.jsp
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/generaterList.html")
	public String generaterList(HttpServletRequest request,JSPTemplateVo vo,Model model){
		
		List<TargetVo> clazzList = vo.getList();
		List<ConditionTargetVo> voList = vo.getVoList();
		
		//新增页面的url
		String addUrl = "/system/"+vo.getClasslowerName()+"/"+FilePathConstants.ADD_HTML;
		//编辑页面的url
		String editUrl = "/system/"+vo.getClasslowerName()+"/"+FilePathConstants.EDIT_HTML;
		//列表页面url
		String listUrl = "/system/"+vo.getClasslowerName()+"/"+FilePathConstants.LIST_HTML;
		//生成list.jsp
		generaterListJSP(vo, clazzList, voList,listUrl,addUrl,editUrl);
		
		//创建add.jsp
		if("yes".equalsIgnoreCase(vo.getIsAdd())){
			generaterAddJSP(vo, clazzList,addUrl);
		}
		//创建edit.jsp
		if("yes".equalsIgnoreCase(vo.getIsEdit())){
			generaterEditJSP(vo,clazzList,editUrl);
		}
		
		return "redirect:makeListTempLate.html";
	}

	
	/**
	 * 生成编辑页面edit.jsp
	 * @param vo
	 * @param clazzList
	 */
	private void generaterEditJSP(JSPTemplateVo vo, List<TargetVo> clazzList,String url) {
		
		//读取文件内容
				String fileContent = FileUtils.getFileContent(FilePathConstants.TEMPLEATE_JSP+FilePathConstants.EDIT_JSP,"UTF-8");
				StringBuffer contentBuffer= new StringBuffer("");
				
				int len = clazzList.size();
				
				int num = 0;
				
				for (int i = 0; i < len; i++) {
					
					TargetVo obj = clazzList.get(i);
					
					if("1".equals(obj.getIsChecked())){
						/*<tr>
						<td>菜单名称<font color="FF0000">*</font></td>
						<td colspan="2"><input name="name" value="" type="text" /></td>
						<td><span class="msg"></span></td>
						</tr>*/
						String html = MyHtmlUtils.getHtml(obj.getFieldName(),obj.getFieldType());
						
						if(num ==0){
							contentBuffer.append("<tr>\n");
						}else{
							contentBuffer.append("\t\t\t<tr>\n");
						}
						contentBuffer.append("\t\t\t\t<td>").append(obj.getAlias())
									 .append("<font color=\"FF0000\">*</font></td>\n");
						contentBuffer.append("\t\t\t\t<td colspan=\"2\">").append(html)
									 .append("</td>\n");
						contentBuffer.append("\t\t\t\t<td><span class=\"msg\"></span></td>\n");
						contentBuffer.append("\t\t\t</tr>\n");
						++num;
					}else{
						continue;
					}
					
				}
				fileContent = fileContent.replace("$#Page_edit_content#", contentBuffer.toString());
				
				//生成文件
				String path = FilePathConstants.JSP_TARGET_URL+vo.getClasslowerName()+"\\"+FilePathConstants.EDIT_JSP;
				
				FileUtils.makeFile(path, fileContent,"UTF-8",false);
				
				//生成菜单
				makeFunction(vo.getClasslowerName(),url,"EditPage");
		
	}

	/***********************
	 * 2016年1月1日下午1:43:27
	 * @param className
	 * @param url
	 * @param type
	 * @author gaopj
	 ***********************/
	private void makeFunction(String className,String url,String type) {
		
		/*//查询url是否存在，存在则不再添加
		TbFunctionVo vo = new TbFunctionVo();
		TbFunctionVo.Criteria criteria = vo.createCriteria();
		criteria.andFunctionUrlEqualTo(url);
		criteria.andParentIdNotEqualTo("-1");
		List<TbFunction> list = this.tbfunctionService.selectByVo(vo);
		
		if(!list.isEmpty())
			return;
		
		Date date = new Date();
		int unixTime = Integer.valueOf(String.valueOf(System.currentTimeMillis()));
		TbFunction tbfunction = new TbFunction();
		tbfunction.setFunctionId(String.valueOf(CommonUtils.genatorRandomId()));
		tbfunction.setCreateTime(unixTime);
		tbfunction.setCreator("10000");
		tbfunction.setCreatorName("system");
		if(!"ListPage".equals(type)){
			tbfunction.setFunctionType("2");
		}else{
			tbfunction.setFunctionType("1");
		}
		tbfunction.setFunctionUrl(url);
		tbfunction.setIsValid(1);
		tbfunction.setModifyTime(unixTime);
		tbfunction.setName(className+"_"+type);
		tbfunction.setParentId("2016010101");
		
		this.tbfunctionService.insert(tbfunction);*/
	}

	/**
	 * 生成add.jsp
	 * @param vo
	 * @param clazzList
	 */
	private void generaterAddJSP(JSPTemplateVo vo, List<TargetVo> clazzList,String url) {
		//读取文件内容
		String fileContent = FileUtils.getFileContent(FilePathConstants.TEMPLEATE_JSP+FilePathConstants.ADD_JSP,"UTF-8");
		StringBuffer contentBuffer= new StringBuffer("");
		
		int len = clazzList.size();
		
		int num = 0;
		
		for (int i = 0; i < len; i++) {
			
			TargetVo obj = clazzList.get(i);
			
			if("1".equals(obj.getIsChecked())){
				/*<tr>
				<td>菜单名称<font color="FF0000">*</font></td>
				<td colspan="2"><input name="name" value="" type="text" /></td>
				<td><span class="msg"></span></td>
				</tr>*/
				String html = MyHtmlUtils.getAddHtml(obj.getFieldName(),obj.getFieldType());
				if(num ==0){
					contentBuffer.append("<tr>\n");
				}else{
					contentBuffer.append("\t\t\t<tr>\n");
				}
				contentBuffer.append("\t\t\t\t<td>").append(obj.getAlias())
							 .append("<font color=\"FF0000\">*</font></td>\n");
				contentBuffer.append("\t\t\t\t<td colspan=\"2\">").append(html)
							 .append("</td>\n");
				contentBuffer.append("\t\t\t\t<td><span class=\"msg\"></span></td>\n");
				contentBuffer.append("\t\t\t</tr>\n");
				++num;
			}else{
				continue;
			}
			
		}
		fileContent = fileContent.replace("$#Page_add_content#", contentBuffer.toString());
		
		//生成文件
		String path = FilePathConstants.JSP_TARGET_URL+vo.getClasslowerName()+"\\"+FilePathConstants.ADD_JSP;
		
		FileUtils.makeFile(path, fileContent,"UTF-8",false);
		
		makeFunction(vo.getClasslowerName(),url,"AddPage");
	}

	private void generaterListJSP(JSPTemplateVo vo, List<TargetVo> clazzList,
			List<ConditionTargetVo> voList,String listUrl,String addUrl,String editUrl) {
		//读取文件内容
		String fileContent = FileUtils.getFileContent(FilePathConstants.TEMPLEATE_JSP+FilePathConstants.LIST_JSP,"UTF-8");
		
		int num = 1;
		//第一步：替换条件内容
		StringBuffer paramBuffer= new StringBuffer("");
		for (ConditionTargetVo obj : voList) {
			//查询条件在模板里只给出了3个
			if(num>=4){
				break;
			}
			
			if("1".equals(obj.getIsChecked())){
				
				String html = MyHtmlUtils.getHtml(obj.getFieldName(),obj.getFieldType());
				
				fileContent = fileContent.replace("$#page_"+num+"_condition_name#", obj.getAlias());
				
				fileContent = fileContent.replace("$#page_"+num+"_condition_content#", html);
				//分页条件拼装
				paramBuffer.append(obj.getFieldName()+"=${vo."+obj.getFieldName()+"}");
				if(num!=3){
					paramBuffer.append("&");
				}
				num++;
			}else{
				continue;
			}
		}
		
		//处理列表表头
		StringBuffer theadBuffer = new StringBuffer("");
		StringBuffer tbodyBuffer = new StringBuffer("");
		int len = clazzList.size();
		for (int i=0;i<len;i++) {
			
			TargetVo obj = clazzList.get(i);
			
			if("1".equals(obj.getIsChecked())){
				
				theadBuffer.append("<td>");
				theadBuffer.append(obj.getAlias());
				theadBuffer.append("</td>");
				
				tbodyBuffer.append("<td>${obj.");
				tbodyBuffer.append(obj.getFieldName());
				tbodyBuffer.append("}</td>");
				
				if(i < len-1){
					theadBuffer.append("\n\t\t\t\t");
					tbodyBuffer.append("\n\t\t\t\t");
				}
				
			}else{
				continue;
			}
		}
		
		//字符串替换:列表
		fileContent = fileContent.replace("$#page_list_thead#", theadBuffer.toString());
		//字符串替换:列表
		fileContent = fileContent.replace("$#page_list_tbody#", tbodyBuffer.toString());
		//字符串替换:title
		fileContent = fileContent.replace("$#page_title#", vo.getPageTitle());
		//字符串替换:分页字符串
		fileContent = fileContent.replace("$#pager_param#", paramBuffer.toString());
		//字符串替换：新增页面url，编辑url
		fileContent = fileContent.replace("$#addPageUrl#", addUrl);
		fileContent = fileContent.replace("$#editPageUrl#", editUrl);
		
		//生成文件
		String path = FilePathConstants.JSP_TARGET_URL+vo.getClasslowerName()+"\\"+FilePathConstants.LIST_JSP;
		
		FileUtils.makeFile(path, fileContent,"UTF-8",false);
		
		makeFunction(vo.getClasslowerName(),listUrl,"ListPage");
		
	}
	
	

	@RequestMapping("/getPoFileds.html")
	@ResponseBody
	public Object getPoFileds(String className){
		
		Map<String,Object> map = gerPoFileds(className);
		//获取当前类的所有已字段
		Field[] field = (Field[])map.get("clazz");
		//获取条件类的所有字段
		Field[] voField = (Field[])map.get("voClazz");
		//获取条件类的完整包名
		String voName = (String)map.get("voName");
		
		JSONObject jsonArr = new JSONObject();
		
		Map<String,String> tempMap = new HashMap<String,String>();
		for (Field tempField : field) {
			
			String key = tempField.getName();
			
			//序列号属性不参与页面生成
			if("serialVersionUID".equals(key)){
				continue;
			}
			
			//条件查询的时间不参与页面生成
			if(key.endsWith("Time")){
				continue;
			}
			
			
			tempMap.put(key, key);
		}
		
		Map<String,String> tempVoMap = new HashMap<String,String>();
		
		for (Field tempField : voField) {
			
			String key = tempField.getName();
			
			//序列号属性不参与页面生成
			if("serialVersionUID".equals(key)){
				continue;
			}
			
			//条件查询的时间不参与页面生成
			if(key.endsWith("Time")){
				continue;
			}
			
			//pageNo和pageSize不参与页面生成
			if(key.startsWith("page")){
				continue;
			}
			
			tempVoMap.put(key, key);
		}
		
		jsonArr = new JSONObject();
		
		//同步获取查询vo类
		jsonArr.put("clazz", tempMap);
		jsonArr.put("voClazz", tempVoMap);
		jsonArr.put("voName", voName);
		System.out.println(jsonArr.toString());
		return jsonArr.toString();
	}
	
	
	/**根据类的小写名称，匹配po类并返回该类所有的字段
	 * map存放了查询条件类的完整包名+类的所有字段+查询类的所有可用字段
	 * @param className
	 * @return
	 */
	private Map<String,Object> gerPoFileds(String className) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<String> list = new ArrayList<String>();
		
		File file = new File(FilePathConstants.PO_URL);
		
		if(!file.exists()){
			System.err.println("-------路径错误----");
		}
		
		if(file.isDirectory()){
		   //获取所有的文件夹
		   File[] dicArr = file.listFiles();
		   for (File tempFile : dicArr) {
				  list.add(tempFile.getName());
		   }
		}else{
			System.out.println(FilePathConstants.JSP_TARGET_URL+"----不是一个目录------");
		}
		
		String classStr = "";
		
		String conditionClassStr = "";
		
		//循环遍历名字一样的类
		for (String fileName : list) {
			
			fileName = fileName.split("\\.")[0];
			
			if(className.equalsIgnoreCase(fileName)){
				
				classStr = FilePathConstants.PO_PACKAGE+"."+fileName;
				conditionClassStr = FilePathConstants.VO_PACKAGE+"."+fileName+"Vo";
				map.put("voName", conditionClassStr);
				break;
			}
		}
		
		//添加查询类clazz
		Class<?> voClazz = null;
		
		if(StringUtils.isNotEmpty(classStr)){
			
			try {
				Class<?> clazz = Class.forName(classStr);
				Field[] fileds = clazz.getDeclaredFields();
				map.put("clazz", fileds);
				
				voClazz = Class.forName(conditionClassStr);
				
				Field[] voClazzFileds = voClazz.getDeclaredFields();
				map.put("voClazz", voClazzFileds);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
				try {
					voClazz = Class.forName(FilePathConstants.ConditionVo_PACKAGE);
					Field[] voClazzFileds = voClazz.getDeclaredFields();
					map.put("voClazz", voClazzFileds);
					map.put("voName", FilePathConstants.ConditionVo_PACKAGE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}else{
			System.err.println(MakeTemplateController.class.getSimpleName()+"----找不到匹配的po类----");
			
		}
		
		return map;
	}

	/**
	 * 获取没有生成相应名称jsp
	 * @param
	 * @return
	 */
	private static List<String> getNeededFileName(String fileName) {
		
		List<String> list = new ArrayList<String>();
		
		File file = new File(FilePathConstants.JSP_TARGET_URL);
		
		if(!file.exists()){
			System.err.println("-------路径错误----");
		}
		
		if(file.isDirectory()){
		   //获取所有的文件夹
		   File[] dicArr = file.listFiles();
		   for (File tempFile : dicArr) {
			
			   if(tempFile.isDirectory()){
				   String path = tempFile.getAbsolutePath();
				   File listJspFile = new File(path,fileName);
				   if(!listJspFile.exists()){
					   list.add(tempFile.getName());
				   }
			   }
		   }
		}else{
			System.out.println(FilePathConstants.JSP_TARGET_URL+"----不是一个目录------");
		}
		return list;
	}

}
