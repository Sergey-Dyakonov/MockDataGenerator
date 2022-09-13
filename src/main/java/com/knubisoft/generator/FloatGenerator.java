package com.knubisoft.generator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FloatGenerator implements Generator<Float>{
    @Override
    public Float generate() {
        return rand.nextFloat();
    }
}
