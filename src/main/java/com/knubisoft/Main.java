package com.knubisoft;

import com.fasterxml.jackson.core.type.TypeReference;
import com.knubisoft.generator.*;
import com.knubisoft.sample.Person;
import com.knubisoft.sample.X;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/* Make possible to generate:
 *  TODO: 0. REFACTOR
 *  DONE: 1. primitives
 *  DONE: 2. composite objects
 *  DONE: 3. collections
 *  DONE: 4. collections of collections
 *  TODO: 5. arrays
 *  TODO: 6. enums
 *  TODO: 7. objects of inner classes
 *  TODO: 8. records
 *  TODO: 9. reading all generators from the package 'generator'
 *  TODO:10. generating all classes from 'sample' dir
 *  TODO:11. write tests
 * */

public class Main {

    static Map<Class<?>, Generator<?>> generator = new LinkedHashMap<>();

    static {
        generator.put(Integer.class, new IntGenerator(0, 10));
        generator.put(int.class, new IntGenerator(0, 10));
        generator.put(Boolean.class, new BooleanGenerator());
        generator.put(boolean.class, new BooleanGenerator());
        generator.put(String.class, new StringGenerator());
        generator.put(Date.class, new DateGenerator());
        generator.put(Character.class, new CharGenerator(CharGenerator.MIN_ASCII_ALPHABETICAL_SYMBOL, CharGenerator.MAX_ASCII_ALPHABETICAL_SYMBOL));
    }

    public static void main(String[] args) {
        System.out.println(populate(new TypeReference<String>() {
        }.getType()));
        System.out.println(populate(new TypeReference<Person>() {
        }.getType()));
        System.out.println(populate(new TypeReference<List<String>>() {
        }.getType()));
        System.out.println(populate(new TypeReference<Set<Integer>>() {
        }.getType()));
        System.out.println(populate(new TypeReference<Queue<Character>>() {
        }.getType()));
        System.out.println(populate(new TypeReference<List<List<Integer>>>() {
        }.getType()));
        System.out.println(populate(new TypeReference<Map<Integer, String>>() {
        }.getType()));
        System.out.println(populate(new TypeReference<X>() {
        }.getType()));
    }

    @SneakyThrows
    private static Object populate(Type x) {
        if (isSimpleType(x)) {
            return generator.get(x).generate();
        } else {
            if (isCollection(x)) {
                ParameterizedType parameterizedType = (ParameterizedType) x;
                Class<?> rawClass = (Class<?>) parameterizedType.getRawType();
                if (Collection.class.isAssignableFrom(rawClass)) {
                    Collection<Object> collection = new ArrayList<>();
                    Type actualType = parameterizedType.getActualTypeArguments()[0];
                    if (List.class.isAssignableFrom(rawClass)) {
                        collection = new ArrayList<>();
                    } else if (Set.class.isAssignableFrom(rawClass)) {
                        collection = new HashSet<>();
                    } else if (Queue.class.isAssignableFrom(rawClass)) {
                        collection = new ArrayDeque<>();
                    }
                    for (int i = 0; i < 5; i++) {
                        collection.add(populate(actualType));
                    }
                    return collection;
                } else {
                    Type keyType = parameterizedType.getActualTypeArguments()[0];
                    Type valueType = parameterizedType.getActualTypeArguments()[1];
                    Map<Object, Object> map = new HashMap<>();
                    for (int i = 0; i < 5; i++) {
                        map.put(populate(keyType), populate(valueType));
                    }
                    return map;
                }
            } else {
                Class<?> cl = Class.forName(x.getTypeName());
                Field[] fields = cl.getDeclaredFields();
                Object instance = cl.getDeclaredConstructor().newInstance();
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(instance, populate(field.getGenericType()));
                }
                return instance;
            }
        }
    }

    private static boolean isCollection(Type x) {
        if (!(x instanceof ParameterizedType)) {
            return false;
        }
        Class<?> referenceRawType = (Class<?>) ((ParameterizedType) x).getRawType();
        return Collection.class.isAssignableFrom(referenceRawType) ||
                Map.class.isAssignableFrom(referenceRawType);
    }

    private static boolean isSimpleType(Type x) {
        return generator.containsKey(x);
    }

    private static <T> Type[] nestedTypes(Type typeRef) {
        return typeRef instanceof ParameterizedType ? ((ParameterizedType) typeRef).getActualTypeArguments() : new Type[]{typeRef};
    }
}
