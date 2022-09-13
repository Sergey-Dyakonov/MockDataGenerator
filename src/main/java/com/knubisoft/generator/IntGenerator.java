package com.knubisoft.generator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;
import java.util.random.RandomGeneratorFactory;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class IntGenerator implements Generator<Integer>{
    private int minValue = 0;
    private int maxValue = 10;
    @Override
    public Integer generate() {
        return rand.nextInt(minValue, maxValue);
    }
}
