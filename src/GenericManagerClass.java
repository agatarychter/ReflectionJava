import java.lang.reflect.*;
import static java.lang.reflect.Modifier.isStatic;

class GenericManagerClass {
    static <T> T makeNewInstance(Class<T> cls) {
        T newT;
        try {
            newT = cls.newInstance();
            return newT;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    static <T> T makeNewInstance(Class<T> clazz, Object... arg){
        T t;
        Class[] classes = new Class[arg.length];
        for (int i = 0; i < classes.length; i++) {
            classes[i] = arg[i].getClass();
        }
        try {
            for (Constructor<?> constructor : clazz.getConstructors()) {
                if (constructor.getParameterCount() > 0) {
                    Class[] types = constructor.getParameterTypes();
                    if (types.length == arg.length) {
                        for (int i = 0; i < types.length; i++) {
                            if (types[i].isPrimitive()&&types[i]==toPrimitive(classes[i])) {
                                classes[i] = toPrimitive(classes[i]);
                            }
                        }
                        t = clazz.getConstructor(classes).newInstance(arg);
                        return t;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private static Class<?> toPrimitive(Class<?> clazz) {
        if (clazz.isPrimitive())
            return clazz;
        if (clazz == Integer.class)
            return Integer.TYPE;
        if (clazz == Long.class)
            return Long.TYPE;
        if (clazz == Boolean.class)
            return Boolean.TYPE;
        if (clazz == Byte.class)
            return Byte.TYPE;
        if (clazz == Character.class)
            return Character.TYPE;
        if (clazz == Float.class)
            return Float.TYPE;
        if (clazz == Double.class)
            return Double.TYPE;
        if (clazz == Short.class)
            return Short.TYPE;
        if (clazz == Void.class)
            return Void.TYPE;

        return clazz;
    }


    static <T> T[] createArray(Class<T> clazz, int size)
    {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(clazz, size);
        return array;
    }
    
    static <T> T clone(T object, Class<T> clazz)
    {
        Class<?> cls = object.getClass();// to wtedy wrzucić do klasy P
        T newT = makeNewInstance(clazz);
        try {
            Field[] objectFields = object.getClass().getDeclaredFields();

            for (int i = 0; i < objectFields.length; i++) {
                Field field = objectFields[i];
                if(!isStatic(field.getModifiers()))
                {
                    field.setAccessible(true);
                    field.set(newT, field.get(object));
                }
            }
            return newT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
