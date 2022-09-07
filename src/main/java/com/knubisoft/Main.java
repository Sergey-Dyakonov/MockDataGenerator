package com.knubisoft;

import com.knubisoft.generator.DateGenerator;
import com.knubisoft.generator.Generator;
import com.knubisoft.generator.IntGenerator;
import com.knubisoft.generator.StringGenerator;
import com.knubisoft.samples.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Object object = generateObject(Person.class);
        System.out.println();
    }

    @SneakyThrows
    private static Object generateObject(Class<?> cls) {
        Field[] fields = cls.getDeclaredFields();
        Object instance = cls.getConstructor().newInstance();
        Generator<?> generator = null;
        for (Field field : fields) {
            Class<?> type = field.getType();
            if(!type.isArray()){
                if(type == int.class){
                    generator= new IntGenerator();
                } else if(type == String.class){
                    generator= new StringGenerator();
                } else if(type == Date.class){
                    generator= new DateGenerator();
                }
            }
            field.setAccessible(true);
            field.set(instance, generator.generate());
        }
        return instance;
    }
}
