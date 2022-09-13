package com.knubisoft;

import com.knubisoft.generator.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class GeneratorUtils {
    private final static Map<Class<?>, Generator<?>> generator = new LinkedHashMap<>();

    public static Map<Class<?>, Generator<?>> getSimpleGenerator() {
        if (generator.size() == 0) {
            generator.put(Integer.class, new IntGenerator(0, 10));
            generator.put(int.class, new IntGenerator(0, 10));
            generator.put(Boolean.class, new BooleanGenerator());
            generator.put(boolean.class, new BooleanGenerator());
            generator.put(String.class, new StringGenerator());
            generator.put(Date.class, new DateGenerator());
            generator.put(Character.class, new CharGenerator(CharGenerator.MIN_ASCII_ALPHABETICAL_SYMBOL, CharGenerator.MAX_ASCII_ALPHABETICAL_SYMBOL));
        }
        return generator;
    }
}
