package edu.estu.singleton;

import lombok.SneakyThrows;

import java.util.HashSet;
import java.util.Set;

public class RecipeApplicationIoCContainer {

    private static final Set<Object> singletonObjects = new HashSet<>();

    @SneakyThrows
    public static <T> T getSingletonInstance(Class<T> clazz) {
        Object object = singletonObjects.stream().filter(obj -> obj.getClass().equals(clazz)).findFirst().orElse(null);
        if (object == null) {
            T newInstance = clazz.getDeclaredConstructor().newInstance();
            singletonObjects.add(newInstance);
            return newInstance;
        }
        return (T) object;
    }

}
