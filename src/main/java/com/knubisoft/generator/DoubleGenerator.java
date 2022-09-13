package com.knubisoft.generator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DoubleGenerator implements Generator<Double>{
    @Override
    public Double generate() {
        return rand.nextDouble();
    }
}
