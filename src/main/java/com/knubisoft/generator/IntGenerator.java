package com.knubisoft.generator;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.Random;
import java.util.random.RandomGeneratorFactory;

@AllArgsConstructor
@Setter
public class IntGenerator implements Generator<Integer>{
    private int minValue;
    private int maxValue;
    @Override
    public Integer generate() {
        return rand.nextInt(minValue, maxValue);
    }
}
