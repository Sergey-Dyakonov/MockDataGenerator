package com.knubisoft;

import com.knubisoft.generator.DateGenerator;
import com.knubisoft.generator.Generator;
import com.knubisoft.generator.IntGenerator;
import com.knubisoft.generator.StringGenerator;
import com.knubisoft.samples.Person;
import com.knubisoft.samples.X;
import jdk.internal.org.objectweb.asm.TypeReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Supplier;

public class Main {

    static Map<Class<?>, Supplier<Object>> generator = new LinkedHashMap<>();
    static List<String> list = new ArrayList<>();

    static {
        generator.put(Integer.class, () -> 1);
        generator.put(Boolean.class, () -> true);
        generator.put(String.class, () -> "Hello");
    }

    public static void main(String[] args) {
        /*Object object = generateObject(Person.class);
        System.out.println();*/
        List<String> list = new ArrayList<>();
        TypeReference<Integer> token = new TypeReference(){};
        TypeReference<X> x = new TypeReference(){};
        System.out.println(populate(list));
    }

    @SneakyThrows
    private static Object populate(Object x) {
        if (isSimpleType(x)) {
            return generator.get(x).get();
        } else {
            if (isCollection(x.getClass())) {
                if (List.class.isAssignableFrom(x.getClass())) {
                    ParameterizedType type = (ParameterizedType) Main.class.getDeclaredField("list").getGenericType();
                }
            } else {
                //we caught class
                // Class.forName(x.getType().getTypeName()).getDeclaredFields()
            }
        }
        return null;
    }

    private static boolean isCollection(Class<?> x) {
        return List.class.isAssignableFrom(x) || Map.class.isAssignableFrom(x);
    }

    private static boolean isSimpleType(Object x) {
        return generator.containsKey(x);
    }

    private static <T> Type[] nestedTypes(Type typeRef) {
        return typeRef instanceof ParameterizedType ? ((ParameterizedType) typeRef).getActualTypeArguments() : new Type[]{typeRef};
    }
}
