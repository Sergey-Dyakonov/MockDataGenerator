package com.knubisoft.generator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LongGenerator implements Generator<Long>{
    @Override
    public Long generate() {
        return rand.nextLong();
    }
}
