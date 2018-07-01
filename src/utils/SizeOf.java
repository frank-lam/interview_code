package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Java中类似于C++中的sizeof方法，使用： SizeOf.of(Object);
 */
public class SizeOf {

	private SizeOf() {
		
	}
	
	public static int of(int a) {
		return Integer.BYTES;
	}

	public static int of(short a) {
		return Short.BYTES;
	}

	public static int of(double a) {
		return Double.BYTES;
	}

	public static int of(long a) {
		return Long.BYTES;
	}

	public static int of(float a) {
		return Float.BYTES;
	}

	public static int of(char a) {
		return Character.BYTES;
	}

	public static int of(byte a) {
		return Byte.BYTES;
	}

	public static int of(boolean a) {
		return Byte.BYTES;
	}

	private static final Map<Class<?>, Byte> WRAPPER_TYPES = new HashMap<>();

	static {
		WRAPPER_TYPES.put(boolean.class, (byte) 1);
		WRAPPER_TYPES.put(char.class, (byte) (1 << 1));
		WRAPPER_TYPES.put(byte.class, (byte) 1);
		WRAPPER_TYPES.put(short.class, (byte) (1 << 1));
		WRAPPER_TYPES.put(int.class, (byte) (1 << 2));
		WRAPPER_TYPES.put(long.class, (byte) (1 << 3));
		WRAPPER_TYPES.put(float.class, (byte) (1 << 2));
		WRAPPER_TYPES.put(double.class, (byte) (1 << 3));
		WRAPPER_TYPES.put(void.class, (byte) 0);
	}

	private static boolean isWrapperType(Class<?> clazz) {
		return WRAPPER_TYPES.containsKey(clazz);
	}

	private static boolean isArray(Class<?> clazz) {
		return clazz.isArray();
	}

	private static byte wrapperSize(Class<?> wrapper) {
		return WRAPPER_TYPES.get(wrapper);
	}

	private static int ofClass(Class<?> clazz, int sum) {
		if (clazz == null)
			return 0;
		for (Field f : clazz.getDeclaredFields()) {
			if (Modifier.isStatic(f.getModifiers())) {
				continue;
			}
			if (isWrapperType(f.getType())) {
				sum += wrapperSize(f.getType());
				continue;
			}
			if (isArray(f.getType())) {
				if (f.getType() == int[].class || f.getType() == Integer[].class) {
					sum += 4;
				}
				if (f.getType() == boolean[].class || f.getType() == Boolean[].class) {
					sum += 1;
				}
				if (f.getType() == char[].class || f.getType() == Character[].class) {
					sum += 2;
				}
				if (f.getType() == short[].class || f.getType() == Short[].class) {
					sum += 2;
				}
				if (f.getType() == long[].class || f.getType() == Long[].class) {
					sum += 8;
				}
				if (f.getType() == double[].class || f.getType() == Double[].class) {
					sum += 8;
				}
				if (f.getType() == float[].class || f.getType() == Float[].class) {
					sum += 4;
				}
				if (f.getType() == byte[].class || f.getType() == Byte[].class) {
					sum += 1;
				}
				continue;
			}
			sum += ofClass(f.getType(), sum);
		}
		return sum;
	}

	public static int of(Class<?> clazz) {
		return ofClass(clazz, 0);
	}

	private static int ofSuperClass(Object obj, Class<?> superClass) {
		int sum = 0;
		if (superClass.getSuperclass() != null) {
			sum += ofSuperClass(obj, superClass.getSuperclass());
		}
		if (isArray(superClass)) {
			sum += arrayHandle(obj);
		}
		if (isWrapperType(superClass)) {
			sum += primitiveHandle(obj);
		}
		for (Field field : superClass.getDeclaredFields()) {
			if (Modifier.isStatic(field.getModifiers()))
				continue;
			if (!field.isAccessible())
				field.setAccessible(true);
			if (isWrapperType(field.getType())) {
				sum += wrapperSize(field.getType());
				continue;
			}
			Object fieldVal = extractFromField(obj, field);
			if (fieldVal == null)
				continue;
			if (isArray(field.getType())) {
				sum += arrayHandle(fieldVal);
				continue;
			}
			sum += ofSuperClass(fieldVal, superClass);
		}
		return sum;
	}

	public static int of(Object obj) {
		if (obj == null)
			return 0;
		int sum = 0;
		Class<?> clazz = obj.getClass();
		if (clazz.getSuperclass() != null) {
			sum += ofSuperClass(obj, clazz.getSuperclass());
		}
		if (isArray(clazz)) {
			sum += arrayHandle(obj);
		}
		if (isWrapperType(clazz)) {
			sum += primitiveHandle(obj);
		}
		for (Field field : clazz.getDeclaredFields()) {
			if (Modifier.isStatic(field.getModifiers()))
				continue;
			if (!field.isAccessible())
				field.setAccessible(true);
			if (isWrapperType(field.getType())) {
				sum += wrapperSize(field.getType());
				continue;
			}
			Object fieldVal = extractFromField(obj, field);
			if (isArray(field.getType())) {
				if (fieldVal == null)
					continue;
				sum += arrayHandle(fieldVal);
				continue;
			}
			sum += of(fieldVal);
		}
		return sum;
	}

	private static Object extractFromField(Object from, Field field) {
		try {
			return field.get(from);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			return null;
		}
	}

	private static int primitiveHandle(Object obj) {
		return wrapperSize(obj.getClass());
	}

	private static int arrayHandle(Object obj) {
		if (obj instanceof boolean[]) {
			boolean[] arr = (boolean[]) obj;
			return arr.length * 1;
		}
		if (obj instanceof byte[]) {
			byte[] arr = (byte[]) obj;
			return arr.length * Byte.BYTES;
		}
		if (obj instanceof short[]) {
			short[] arr = (short[]) obj;
			return arr.length * Short.BYTES;
		}
		if (obj instanceof char[]) {
			char[] arr = (char[]) obj;
			return arr.length * Character.BYTES;
		}
		if (obj instanceof int[]) {
			int[] arr = (int[]) obj;
			return arr.length * Integer.BYTES;
		}
		if (obj instanceof float[]) {
			float[] arr = (float[]) obj;
			return arr.length * Float.BYTES;
		}
		if (obj instanceof long[]) {
			long[] arr = (long[]) obj;
			return arr.length * Long.BYTES;
		}
		if (obj instanceof double[]) {
			double[] arr = (double[]) obj;
			return arr.length * Double.BYTES;
		}
		Object[] arr = (Object[]) obj;
		int sum = 0;
		for (Object ob : arr) {
			sum += of(ob);
		}
		return sum;
	}

	//	public static int of(Object obj) {
	//		return of(obj);
	//	}

}