package com.knubisoft.generator;

public class LongGenerator implements Generator<Long>{
    @Override
    public Long generate() {
        return rand.nextLong();
    }
}
