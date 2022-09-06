package com.knubisoft.generator;

import java.util.Random;
import java.util.random.RandomGeneratorFactory;

public class IntGenerator implements Generator<Integer>{
    @Override
    public Integer generate() {
        return rand.nextInt();
    }
}
