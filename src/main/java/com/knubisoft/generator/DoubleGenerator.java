package com.knubisoft.generator;

public class DoubleGenerator implements Generator<Double>{
    @Override
    public Double generate() {
        return rand.nextDouble();
    }
}
