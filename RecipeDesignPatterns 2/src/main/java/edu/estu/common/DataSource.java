package edu.estu.common;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@UtilityClass
public class DataSource {

    public interface Entity {
    }

    private static final HashMap<Class<? extends Entity>, Object> dataSource = new HashMap<>();

    public static void createNewDataSet(Class<? extends Entity> entityClass) {
        dataSource.put(entityClass, new ArrayList<>());
    }

    public static <T extends Entity> Collection<T> getDataSet(Class<? extends Entity> key) {
        return (Collection<T>) dataSource.get(key);
    }

    public static void addToDataSet(Class<? extends Entity> key, Collection<Entity> data) {
        if (!dataSource.containsKey(key)) createNewDataSet(key);
        Collection<Entity> entity = getDataSet(key);
        entity.addAll(data);
    }

    public static void addToDataSet(Class<Entity> key, Entity data) {
        if (!dataSource.containsKey(key)) createNewDataSet(key);
        Collection<Entity> entity = getDataSet(key);
        entity.add(data);
    }
}
