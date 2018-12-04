package com.platform.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPropertyUtils {


	public static Map<String, Object> getClassStaticProperty(Class<?> clazz) {
		if (clazz == null) {
			return Collections.emptyMap();
		}

		Field[] fields = clazz.getFields();
		List<Field> staticFields = new ArrayList<Field>(fields.length);
		for (Field f : fields) {
			if (f.getModifiers() == Modifier.STATIC) {
				staticFields.add(f);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>(staticFields.size() * 2);
		for (Field f : fields) {
			try {
				map.put(f.getName(), f.get(null));
			} catch (Exception e) {
				e.printStackTrace();
				map.put(f.getName(), null);
			}
		}

		return map;
	}


	public static <T> Map<String, Object[]> getDifference(T obj1, T obj2) {
		if (obj1 == null || obj2 == null) {
			return Collections.emptyMap();
		}

		Class<? extends Object> clazz = obj1.getClass();

		Method[] methods = clazz.getMethods();
		List<Method> getMethods = new ArrayList<Method>(methods.length);
		for (Method m : methods) {
			if (m.getParameterTypes().length == 0 && m.getName().startsWith("get")) {
				getMethods.add(m);
			}
		}

		Map<String, Object[]> map = new HashMap<String, Object[]>(methods.length * 2);
		try {
			for (Method m : getMethods) {
				Object property1 = m.invoke(obj1);
				Object property2 = m.invoke(obj2);
				if (!property1.equals(property2)) {
					Object[] objs = new Object[2];
					objs[0] = property1;
					objs[1] = property2;
					map.put(m.getName().replaceFirst("get", ""), objs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	/**
	 * 拷贝属性
	 */
	public static void copyFields(Object src, Object des, boolean copyNull,
			String[] fieldNames, boolean include) {
		Class<?> desClass = des.getClass();
		Arrays.sort(fieldNames);

		Method[] methods = src.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();

			if (methodName.startsWith("get")) {
				String attrName = methodName.substring(3, 4).toLowerCase()
						+ methodName.substring(4, methodName.length());
				boolean inAttr = Arrays.binarySearch(fieldNames, attrName) > 0 ? true
						: false;

				try {
					if (inAttr == include) {
						Class<?> returnType = method.getReturnType();
						Object returnValue = method
								.invoke(src, new Object[] {});

						if (!copyNull && returnValue == null) {
							continue;
						}

						String invokeMethodName = "set"
								+ methodName.substring(3, methodName.length());
						Method invokeMethod = desClass.getMethod(
								invokeMethodName, new Class[] { returnType });
						invokeMethod.invoke(des, new Object[] { returnValue });
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void copyFields(Object src, Object des, boolean copyNull) {
		final String get = "get";
		final String set = "set";
		final String is = "is";

		Class<?> srcClass = src.getClass();
		Class<?> desClass = des.getClass();

		Method[] methods = srcClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();

			if (methodName.startsWith(get) || methodName.startsWith(is)) {
				String invokeMethodName = set + methodName.substring(3);
				if(invokeMethodName.equals("setClass")){
					continue;
				}
				try {
					Method invokeMethod = desClass.getMethod(invokeMethodName,
							new Class[] { method.getReturnType() });
					Object result = method.invoke(src, new Object[] {});

					if (!copyNull && result == null) {
						continue;
					}
					invokeMethod.invoke(des, new Object[] { result });
				} catch (Exception e) {
					e.printStackTrace();
					//TODO 需解决没有字段方法抛出异常
				}
			}
		}
	}

	/**
	 * 拷贝属性,此方法有误
	 * @param src 来源对象
	 * @param des 目标对象
	 * @param copyNull
	 * @param copyEmpty
	 */
	@Deprecated
	private static void copyFields(Object src, Object des, boolean copyNull,boolean copyEmpty) {
		final String get = "get";
		final String set = "set";
		final String is = "is";

		Class<?> srcClass = src.getClass();
		Class<?> desClass = des.getClass();

		Method[] methods = srcClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String methodName = method.getName();

			if (methodName.startsWith(get) || methodName.startsWith(set)
					|| methodName.startsWith(is)) {
				String invokerMethodName = set + methodName.substring(3);

				try {
					Method invokerMethod = desClass.getMethod(
							invokerMethodName, new Class[] { method
									.getReturnType() });
					Object result = method.invoke(src, new Object[] {});

					if (!copyNull && result == null) {
						continue;
					}
					if (!copyEmpty && result.toString().trim().equals("")) {
						continue;
					}

					invokerMethod.invoke(des, new Object[] { result });
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Object getValue(Object object, String name) {
		try {
			Method method = object.getClass().getMethod(
					"get" + formatCase(name), new Class[] {});
			Object result = method.invoke(object, new Object[] {});
			if (result != null) {
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected static String formatCase(String name) {
		StringBuffer buffer = new StringBuffer(name);
		char c = Character.toUpperCase(name.charAt(0));

		buffer.deleteCharAt(0);
		buffer.insert(0, c);

		return buffer.toString();
	}  
	

}
