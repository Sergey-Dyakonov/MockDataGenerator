package com.knubisoft.generator;

public class FloatGenerator implements Generator<Float>{
    @Override
    public Float generate() {
        return rand.nextFloat();
    }
}
