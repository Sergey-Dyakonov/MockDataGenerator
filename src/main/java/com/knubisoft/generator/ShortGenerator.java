package com.knubisoft.generator;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShortGenerator implements Generator<Short> {
    @Override
    public Short generate() {
        return (short) rand.nextInt(-32768, 32768);
    }
}
