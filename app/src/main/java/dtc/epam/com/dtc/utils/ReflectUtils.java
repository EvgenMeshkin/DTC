package dtc.epam.com.dtc.utils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Yauheni_Meshkin on 6/1/2015.
 */
public class ReflectUtils {
    public static <T, P> T newInstance(Class<T> clazz, Class<P> parameterClazz, P arg) {
        try {
            return clazz.getConstructor(parameterClazz).newInstance(arg);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(e);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
