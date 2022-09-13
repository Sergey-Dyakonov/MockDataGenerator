package com.knubisoft.generator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BooleanGenerator implements Generator<Boolean>{
    @Override
    public Boolean generate() {
        return rand.nextBoolean();
    }
}
