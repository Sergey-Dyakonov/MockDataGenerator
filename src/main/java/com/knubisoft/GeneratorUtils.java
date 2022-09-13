package com.knubisoft;

import com.knubisoft.generator.BooleanGenerator;
import com.knubisoft.generator.Generator;
import com.knubisoft.generator.IntGenerator;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class GeneratorUtils {
    private final static Map<Class<?>, Generator<?>> generator = new LinkedHashMap<>();
    @SneakyThrows
    public static Map<Class<?>, Generator<?>> getSimpleGenerator() {
        if (generator.size() == 0) {
            Reflections ref = new Reflections("com.knubisoft.generator");
            for (Class<? extends Generator> aClass : ref.getSubTypesOf(Generator.class)) {
                Type actualType = ((ParameterizedType) (aClass.getGenericInterfaces()[0])).getActualTypeArguments()[0];
                generator.put(Class.forName(actualType.getTypeName()), aClass.getDeclaredConstructor().newInstance());
            }
            generator.put(int.class, new IntGenerator());
            generator.put(boolean.class, new BooleanGenerator());
        }
        return generator;
    }
}
