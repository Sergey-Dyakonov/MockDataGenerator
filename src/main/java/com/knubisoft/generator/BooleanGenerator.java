package com.knubisoft.generator;

public class BooleanGenerator implements Generator<Boolean>{
    @Override
    public Boolean generate() {
        return rand.nextBoolean();
    }
}
