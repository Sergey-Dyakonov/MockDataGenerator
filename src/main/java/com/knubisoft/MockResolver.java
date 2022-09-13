package com.knubisoft;

import com.knubisoft.generator.Generator;
import lombok.Setter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@Setter
public class MockResolver {

    private final Map<Class<?>, Generator<?>> generator;
    private int collectionSize = 5;

    public MockResolver() {
        generator = GeneratorUtils.getSimpleGenerator();
    }

    @SneakyThrows
    public Object populate(Type x) {
        if (isSimpleType(x)) {
            return generator.get(x).generate();
        } else {
            if (isCollectionFramework(x)) {
                ParameterizedType parameterizedType = (ParameterizedType) x;
                Class<?> rawClass = (Class<?>) parameterizedType.getRawType();
                return isCollection(rawClass) ? populateCollection(parameterizedType, rawClass) : populateMap(parameterizedType);
            } else {
                return populateComplexObject(x);
            }
        }
    }

    private Collection<Object> populateCollection(ParameterizedType parameterizedType, Class<?> rawClass) {
        Collection<Object> collection;
        Type actualType = parameterizedType.getActualTypeArguments()[0];
        if (List.class.isAssignableFrom(rawClass)) {
            collection = new ArrayList<>();
        } else if (Set.class.isAssignableFrom(rawClass)) {
            collection = new HashSet<>();
        } else {
            collection = new ArrayDeque<>();
        }
        for (int i = 0; i < collectionSize; i++) {
            collection.add(populate(actualType));
        }
        return collection;
    }

    private Map<Object, Object> populateMap(ParameterizedType parameterizedType) {
        Type keyType = parameterizedType.getActualTypeArguments()[0];
        Type valueType = parameterizedType.getActualTypeArguments()[1];
        Map<Object, Object> map = new HashMap<>();
        for (int i = 0; i < collectionSize; i++) {
            map.put(populate(keyType), populate(valueType));
        }
        return map;
    }

    @SneakyThrows
    private Object populateComplexObject(Type x) {
        Class<?> cl = Class.forName(x.getTypeName());
        Object instance = cl.getDeclaredConstructor().newInstance();
        for (Field field : cl.getDeclaredFields()) {
            field.setAccessible(true);
            field.set(instance, populate(field.getGenericType()));
        }
        return instance;
    }

    private boolean isCollectionFramework(Type x) {
        if (!(x instanceof ParameterizedType)) {
            return false;
        } else {
            Class<?> referenceRawType = (Class<?>) ((ParameterizedType) x).getRawType();
            return isCollection(referenceRawType) || Map.class.isAssignableFrom(referenceRawType);
        }
    }

    private boolean isCollection(Class<?> rawClass) {
        return Collection.class.isAssignableFrom(rawClass);
    }

    private boolean isSimpleType(Type x) {
        return generator.containsKey(x);
    }
}
