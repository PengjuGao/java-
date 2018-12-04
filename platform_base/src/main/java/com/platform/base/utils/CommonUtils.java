package com.platform.base.utils;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import com.platform.base.enums.ConstantsCore.IDPrefix;

@SuppressWarnings({"rawtypes","unchecked"})
public class CommonUtils implements Serializable {

	private static final long serialVersionUID = 6458428317155311192L;

	public static Map<String, Object> object2Map(Object obj) {

		if (isEmpty(obj))
			return Collections.EMPTY_MAP;
		Map<String, Object> resultMap = new HashMap<String, Object>(0);
		// 拿到属性器数组
		try {
			PropertyDescriptor[] pds = Introspector.getBeanInfo(obj.getClass()).getPropertyDescriptors();
			for (int index = 0; pds.length > 1 && index < pds.length; index++) {
				if (Class.class == pds[index].getPropertyType() || pds[index].getReadMethod() == null) {

					continue;
				}
				Object value = pds[index].getReadMethod().invoke(obj);
				// 只处理简单类型,对于对象类型,集合不处理
				if (notEmpty(value)) {

					if (isPrototype(pds[index].getPropertyType())//java里的原始类型(去除自己定义类型)
							|| pds[index].getPropertyType().isPrimitive()//基本类型
							|| ReflectUtils.isPrimitivePackageType(pds[index].getPropertyType())
							|| pds[index].getPropertyType() == String.class) {

						resultMap.put(pds[index].getName(), value);
					}
				}
			}
		} catch (Exception e) {
			//logger.error(e.getMessage());
			e.printStackTrace();
		}
		return resultMap;
	}

	/**
	 * 非空判断
	 *
	 * @param objs 要判断,处理的对象,任意一个为空都返回true
	 * @return Boolean
	 * @author <a href="mailto:niceboyz@qq.com">Ben</a>
	 * @see <b>对象为Null返回true,集合的大小为0也返回true,迭代器没有下一个也返回true..</b>
	 * @since 1.0
	 */
	public static Boolean isEmpty(Object... objs) {

		if (objs == null) {
			return Boolean.TRUE;
		}

		if (objs.length==0) return Boolean.TRUE;

		for (Object obj:objs) {
			if (obj == null) {
				return true;
			}

			// 字符序列集
			if ((obj instanceof CharSequence) && "".equals(obj.toString().trim())) {
				return true;
			}
			// 单列集合
			if (obj instanceof Collection) {
				if(((Collection<?>) obj).isEmpty()){
					return true;
				}
			}
			// 双列集合
			if (obj instanceof Map) {
				if (((Map<?, ?>) obj).isEmpty()) {
					return true;
				}
			}

			if (obj instanceof Iterable) {
				if (((Iterable<?>) obj).iterator() == null || !((Iterable<?>) obj).iterator().hasNext()) {
					return true;
				}
			}

			// 迭代器
			if (obj instanceof Iterator) {
				if (!((Iterator<?>) obj).hasNext()) {
					return true;
				}
			}

			// 文件类型
			if (obj instanceof File) {
				if (!((File) obj).exists()) {
					return true;
				}
			}

			if ((obj instanceof Object[]) && ((Object[]) obj).length == 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 对象属性拷贝
	 * <b>拷贝两个对象的值，参数一:拷贝源，参数二:拷贝目标</b></br>
	 *      <b>拷贝源里为空(或List不能为单size为0)的属性值将不会往目标对象里拷贝
	 *      注意如果传入的两个对象有继承关系,则:第一个参数destObj为子类，第二个参数srcObj为父类。参数顺序不能颠倒! </b>
	 * @param destObj 拷贝目标实例 || 子类
	 * @param srcObj  拷贝源实例 || 夫类
	 * @return void
	 * @throws Exception
	 * @author <a href="mailto:benjobs@qq.com">Wanghuajie</a>
	 * @since 1.0
	 */
	public static void copyProperties(Object destObj, Object srcObj)
			throws Exception {

		AssertUtils.notNull(destObj, srcObj);

		// 两个类型一样不执行,否则判断srcObj是否是destObj的父类!
		if (destObj.getClass() != srcObj.getClass()
				&& destObj.getClass().getSuperclass() != srcObj.getClass()) {
			//logger.error("srcObj and the destObj don't have the same class or interface, or destObj's super class or super interface is not be this srcObj!");
		}

		// 拿到拷贝源上的属性器数组
		PropertyDescriptor[] srcObjPds = Introspector.getBeanInfo(srcObj.getClass()).getPropertyDescriptors();

		for (int i = 0; srcObjPds.length > 1 && i < srcObjPds.length; i++) {

			if (Class.class == srcObjPds[i].getPropertyType() || srcObjPds[i].getReadMethod() == null) {
				continue;
			}

			Object value = srcObjPds[i].getReadMethod().invoke(srcObj);// 拿到拷贝源上的该值
			if (isEmpty(value)) {
				continue;
			}

			// 避免集合浅拷贝(destObj和srcObj引用的是同一个集合)
			if (value instanceof List) {
				value = new ArrayList((List) value);
			} else if (value instanceof Set) {
				value = new LinkedHashSet((Set) value);
			} else if (value instanceof Map) {
				value = new HashMap((Map) value);
			}
			try {
				srcObjPds[i].getWriteMethod().invoke(destObj, value);
			} catch (InvocationTargetException e) {
				//目标方法执行失败退出本次循环(目标类上没set方法)
				//logger.error(e.getMessage());
			}
		}

	}

	/**
	 * 空判断
	 *
	 * @param obj 要判断,处理的对象
	 * @return Boolean
	 * @author <a href="mailto:benjobs@qq.com">Ben</a>
	 * @see <b>与非空相反</b>
	 * @since 1.0
	 */
	public static Boolean notEmpty(Object... obj) {
		return !isEmpty(obj);
	}

	public static Long toLong(Object val,Long defVal){
		if (isEmpty(val)) {
			return defVal;
		}
		try {
			return Long.parseLong(val.toString());
		} catch (NumberFormatException e){
			return defVal;
		}
	}

	public static Long toLong(Object val){
		return toLong(val,null);
	}

	public static Integer toInt(Object val,Integer defVal){
		if (isEmpty(val)) {
			return defVal;
		}
		try {
			return Integer.parseInt(val.toString());
		} catch (NumberFormatException e){
			return defVal;
		}
	}

	public static Integer toInt(Object val){
		return toInt(val,null);
	}

	/**
	 * 对Null作预处理
	 *
	 * @param obj   待处理的对象
	 * @param clazz 该对象的类型
	 * @return T 返回处理后的不为Null的该对象
	 * @author <a href="mailto:benjobs@qq.com">Ben</a>
	 * @see <b>对Null作预处理,有效避免NullPointerException</b>
	 * @since 1.0
	 */
	public static  <T> T preparedNull(T obj, Class<?> clazz) {

		if (notEmpty(obj)) {
			return obj;
		}

		AssertUtils.notNull(clazz,"this class must be not null!");

		Object val = null;

		// 单列集合
		if (List.class.isAssignableFrom(clazz)) {
			val = new ArrayList<Object>(0);
		} else if (Set.class.isAssignableFrom(clazz)) {
			val = new HashSet<Object>(0);
		} else if (Map.class.isAssignableFrom(clazz)) {
			val = new HashMap<Object, Object>(0);
		} else {
			try {
				val = clazz.newInstance();
			} catch (Exception e) {
				//logger.error(e.getMessage());
			}
		}
		return (T) val;
	}


	public static List arrayToList(Object source) {
		return Arrays.asList(ObjectUtils.toObjectArray(source));
	}

	public static boolean contains(Iterator iterator, Object element) {
		if (iterator != null) {
			while (iterator.hasNext()) {
				Object candidate = iterator.next();
				if (ObjectUtils.safeEquals(candidate, element)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check whether the given Enumeration contains the given element.
	 * @param enumeration the Enumeration to check
	 * @param element the element to look for
	 * @return <code>true</code> if found, <code>false</code> else
	 */
	public static boolean contains(Enumeration enumeration, Object element) {
		if (enumeration != null) {
			while (enumeration.hasMoreElements()) {
				Object candidate = enumeration.nextElement();
				if (ObjectUtils.safeEquals(candidate, element)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check whether the given Collection contains the given element instance.
	 * <p>Enforces the given instance to be present, rather than returning
	 * <code>true</code> for an equal element as well.
	 * @param collection the Collection to check
	 * @param element the element to look for
	 * @return <code>true</code> if found, <code>false</code> else
	 */
	public static boolean containsInstance(Collection collection, Object element) {
		if (collection != null) {
			for (Object candidate : collection) {
				if (candidate == element) {
					return true;
				}
			}
		}
		return false;
	}


	public static <A,E extends A> A[] toArray(Enumeration<E> enumeration, A[] array) {
		ArrayList<A> elements = new ArrayList<A>();
		while (enumeration.hasMoreElements()) {
			elements.add(enumeration.nextElement());
		}
		return elements.toArray(array);
	}

	/**
	 * Adapt an enumeration to an iterator.
	 * @param enumeration the enumeration
	 * @return the iterator
	 */
	public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
		@SuppressWarnings("hiding")
		class EnumerationIterator<E> implements Iterator<E> {
			private Enumeration<E> enumeration;
			public EnumerationIterator(Enumeration<E> enumeration) {
				this.enumeration = enumeration;
			}

			public boolean hasNext() {
				return this.enumeration.hasMoreElements();
			}

			public E next() {
				return this.enumeration.nextElement();
			}

			public void remove() throws UnsupportedOperationException {
				throw new UnsupportedOperationException("Not supported");
			}
		}
		return new EnumerationIterator<E>(enumeration);
	}

	//获取系统名字
	public static String getOsName() {
		return System.getProperties().getProperty("os.name");
	}

	public static boolean isLinuxOs() {
		return getOsName().toUpperCase().startsWith("LIN");
	}

	//是否为Window系统
	public static boolean isWindowOs() {
		return getOsName().toUpperCase().startsWith("WIN");
	}

	//判断类型是否为jdk里自带的原始类型
	public static boolean isPrototype(Class clazz) {
		return clazz.getClassLoader() == null;
	}

	/**
	 * @Title getRandomString
	 * @Description 随机生成字符串
	 * @param length=生成字符串的长度
	 * @return String
	 * @author LuoRun
	 * @date 2012-10-22 下午12:13:17
	 */
	public static String getRandomString(Integer length) {
		String base = "abcdefghijkmnpqrstuvwxyz23456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * @Title: listToString
	 * @Description:List对像转换为字符串
	 * @param:
	 * @return: String
	 * @author: LuoRun
	 * @date: 2012-10-23 下午8:52:24
	 * @throws:
	 */
	public static String stringListToString(List<String> list, String speater) {
		if (speater.matches("\\\\++")){
			int len = speater.length();
			for (int i=0;i<len;i++) speater+="\\";
		}
		return list.toString().replaceAll(", ",speater).replaceAll("\\[|]", "");

	}

	public static long getDateDiffSeconds(Date d1, Date d2) {
		return Math.abs(d1.getTime() - d2.getTime()) / 1000;
	}

	public static void copyBeanProperties(Object destObj, Object srcObj) throws Exception {
		if (isEmpty(destObj) || isEmpty(srcObj)) {
			//logger.error("srcObj or destObj Must be not Null!");
			return;
		}

		// 拿到拷贝源上的属性器数组
		PropertyDescriptor[] srcObjPds = Introspector.getBeanInfo(
				srcObj.getClass()).getPropertyDescriptors();

		PropertyDescriptor[] destObjPds = Introspector.getBeanInfo(
				destObj.getClass()).getPropertyDescriptors();

		for (int i = 0; srcObjPds.length > 1 && i < srcObjPds.length; i++) {
			//跳出从object继承的class属性,源上必须有get方法
			if (Class.class == srcObjPds[i].getPropertyType()
					|| srcObjPds[i].getReadMethod() == null) {
				continue;
			}

			for (int j = 0; destObjPds.length > 1 && j < destObjPds.length; j++) {
				//跳出从object继承的class属性,目标类上必须有set方法
				if (Class.class == destObjPds[j].getPropertyType()
						|| destObjPds[j].getWriteMethod() == null) {
					continue;
				}

				//类型和属性名一样

				if ((srcObjPds[i].getPropertyType() == destObjPds[j].getPropertyType()||
						ReflectUtils.checkPackageType(srcObjPds[i].getPropertyType(), destObjPds[j].getPropertyType()))
						&& srcObjPds[i].getName().equals(
								destObjPds[j].getName())) {

					String propertyName = destObjPds[j].getName();

					if (Map.class.isAssignableFrom(srcObjPds[i].getPropertyType())
							|| Collection.class.isAssignableFrom(srcObjPds[i].getPropertyType())
							) {

						Type descPropType = destObj.getClass().getDeclaredField(propertyName).getGenericType();
						Type srcPropType = srcObj.getClass().getDeclaredField(propertyName).getGenericType();
						//Map或Collection上没加类型,不做处理
						if (!(descPropType instanceof ParameterizedType) || !(srcPropType instanceof ParameterizedType)) {
							continue;
						}

						ParameterizedType destMapPropPT = (ParameterizedType) descPropType;
						ParameterizedType srcMapPropPT = (ParameterizedType) srcPropType;
						Type descPropKeyType = destMapPropPT.getActualTypeArguments()[0];
						Type srcPropKeyType = srcMapPropPT.getActualTypeArguments()[0];

						if (descPropKeyType != srcPropKeyType) continue;

						if (Map.class.isAssignableFrom(srcObjPds[i].getPropertyType())) {
							Type descMapValType = destMapPropPT.getActualTypeArguments()[1];
							Type srcMapValKeyType = srcMapPropPT.getActualTypeArguments()[1];
							if (descMapValType != srcMapValKeyType) continue;
						}
					}

					Object value = srcObjPds[i].getReadMethod().invoke(srcObj);// 拿到拷贝源上的该值 、
					if (value != null) {
						try {
							destObjPds[j].getWriteMethod().invoke(destObj, value);
						} catch (InvocationTargetException e) {
							//执行目标异常,让目标对象执行set方法,如果出异常则直接退出本次循环
							//skip
						}
					}
				}
			}
		}
	}


	/**
	 * 将String数组转化为Long数组
	 * @Title: strArr2LongArr
	 * @param strArr String数组
	 * @return Long数组
	 * @author: wanghajie 2012-12-13上午10:15:42
	 */
	public static Long[] string2LongArray(String[] strArr) {
		if (CommonUtils.isEmpty(strArr) ) {
			return null;
		}
		Long longArray[] = new Long[strArr.length];
		for (int i = 0; i < longArray.length; i++) {
			longArray[i] = StringUtils.parseLong(strArr[i]);
		}
		return longArray;
	}

	/**
	 * 将将String数组转化为LongList
	 * @Title: strArr2LongList
	 * @param strArr String数组
	 * @return LongList
	 * @author: wanghajie 2012-12-13上午11:09:10
	 */
	public static List<Long> string2LongList(String[] strArr) {
		// 将String数组转化为Long数组
		Long[] longArr = string2LongArray(strArr);
		return longArr == null? ((List<Long>) Collections.EMPTY_LIST) :Arrays.asList(longArr);
	}


	/**
	 * id随机生成数
	 * @return
	 */
	public static Long genatorRandomId(){

		//随机数
		String randomNo = String.valueOf(Math.round(Math.random()*9000+1000));


		String currentDate = DateUtils.parseStringFromDate(new Date(), "yyyyMMddHHmmss");

		return CommonUtils.toLong(currentDate+randomNo);

	}

	public static boolean safeEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}

		if (o1 == o2) {
			return true;
		}

		if (o1.equals(o2)) {
			return true;
		}

		if (o1.toString().equalsIgnoreCase(o2.toString())) {
			return true;
		}

		if (o1.getClass().isArray() && o2.getClass().isArray()) {
			if (o1 instanceof Object[] && o2 instanceof Object[]) {
				return Arrays.equals((Object[]) o1, (Object[]) o2);
			}
			if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
				return Arrays.equals((boolean[]) o1, (boolean[]) o2);
			}
			if (o1 instanceof byte[] && o2 instanceof byte[]) {
				return Arrays.equals((byte[]) o1, (byte[]) o2);
			}
			if (o1 instanceof char[] && o2 instanceof char[]) {
				return Arrays.equals((char[]) o1, (char[]) o2);
			}
			if (o1 instanceof double[] && o2 instanceof double[]) {
				return Arrays.equals((double[]) o1, (double[]) o2);
			}
			if (o1 instanceof float[] && o2 instanceof float[]) {
				return Arrays.equals((float[]) o1, (float[]) o2);
			}
			if (o1 instanceof int[] && o2 instanceof int[]) {
				return Arrays.equals((int[]) o1, (int[]) o2);
			}
			if (o1 instanceof long[] && o2 instanceof long[]) {
				return Arrays.equals((long[]) o1, (long[]) o2);
			}
			if (o1 instanceof short[] && o2 instanceof short[]) {
				return Arrays.equals((short[]) o1, (short[]) o2);
			}
		}
		return false;
	}



	private static void doeach(Map<Integer, Integer> map,int index) {
		if (map.size()==1) {
			int value = map.entrySet().iterator().next().getValue();
			System.out.println("结果是:" + value + ";总共轮循了[" + index + "]圈");
			return;
		}

		Map<Integer,Integer> newMap = new TreeMap<Integer, Integer>();

		int flag = 1;
		for(Map.Entry<Integer,Integer> entry:map.entrySet()){
			if (entry.getKey()%2==1) {
				newMap.put(flag++, entry.getValue());
			}
		}

		if (map.size()%2==0) {
			//递归查找,进入下次轮循
			doeach(newMap, ++index);
		}else {//特殊处理最后一个
			//把最后一个添加到第一个位置,把原来的第一个往后移一位
			int last = newMap.get(newMap.size());
			newMap.remove(newMap.size());
			Map<Integer,Integer> mergeMap = new TreeMap<Integer,Integer>();
			mergeMap.put(1,last);
			for(Map.Entry<Integer,Integer> entry:newMap.entrySet() ){
				mergeMap.put(mergeMap.size()+1,entry.getValue());
			}
			doeach(mergeMap, ++index);
		}
	}

	/**
	 * 
	 * @param num
	 * @param seed
	 * @return
	 */
	public static String genatorRandomBatchNo(int num,int seed){

		StringBuffer buffer = new StringBuffer();

		for(int i=0;i<num;i++){
			buffer.append(String.valueOf(Math.round(Math.random()*seed)));
		}

		return buffer.toString();
	}

	/**
	 * 是否是空字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){

		return "".equals(str) || null == str;
	}


	//首字母转小写
	public static String toLowerCaseFirstOne(String s)
	{
		if(Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}
	//首字母转大写
	/***********************
	 * 2016年1月6日下午9:43:30
	 * @param s
	 * @return
	 * @author gaopj
	 ***********************/
	public static String toUpperCaseFirstOne(String s)
	{
		if(Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}


	/***********************
	 * 2016年1月6日下午9:51:01
	 * @param prefix
	 * @return
	 * @author gaopj
	 ***********************/
	public static String generaterRandomId(IDPrefix idEnum){

		SimpleDateFormat sip = new SimpleDateFormat("yyddHHmmss");
		Date date = new Date();
		String value = sip.format(date);
		//生成四位随机数
		Double num = (Math.random()*90000);
		int seed = num.intValue()+10000;
		if(!isEmpty(idEnum.prefix)){
			return idEnum.prefix+value+seed;
		}
		return value+seed;
	}

	/**
	 * 每次登陆都会返回一个token
	 * @param userId
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static String encryptToken(String userId, Date date) throws Exception {
		//加密key为当期那时间串
		SimpleDateFormat sip = new SimpleDateFormat("yyyyMMddHHmmss");
		if(userId.length()<8){
			userId = userId+"most";
		}
		//加密后的数据
		String pwd = DigestUtils.desEncrypt(userId, sip.format(date));
		/*if(pwd.contains("/")){
			pwd = pwd.replace("/", "#");
		}*/
		return pwd;
	}

	/** 解析token返回时间串
	 * @param userId
	 * @param token
	 * @return
	 */
	public static String decryptToken(String userId,String token){
		//token = token.replace("#", "/");
		try {
			if(userId.length()<8){
				userId =userId+"most";
			}
			String timeStr = DigestUtils.desDecrypt(userId, token);
			return timeStr;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	public static void main(String[] args) {
		Date date = new Date();
		for (int i = 0; i < 10; i++) {
			System.out.println(Math.round(Math.random()*i));
		}
		try {
			String token = encryptToken("most1234", date);
			System.out.println(token);

			String value = decryptToken("most1234", token);

			String dateStr = DateUtils.dateToStr(date, "yyyy-MM-dd HH:mm:ss");
			if(value.equals(dateStr)){
				System.out.println(value);
			}else{
				System.err.println(token +"---"+value+"0000"+dateStr);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 生成随机数
	 * @param start
	 * @param end
	 */
	public static int  makeRondomNum(int seed){
		
		Double num = (Math.random()*seed);
		
		return num.intValue();
	}
	
	/**
	 * 处理map集合为参数串用&链接
	 * @param paramMap2
	 * @return
	 */
	public static String dealMap(Map<String, String> map) {
		StringBuilder builder = new StringBuilder();
		Set<String> keySet = map.keySet();
		for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext();) {
			String key =  iterator.next();
			String value = map.get(key);
			builder.append(key).append("=").append(value);
			if(iterator.hasNext()){
				builder.append("&");
			}
		}
		
		return builder.toString();
	}
	
}


