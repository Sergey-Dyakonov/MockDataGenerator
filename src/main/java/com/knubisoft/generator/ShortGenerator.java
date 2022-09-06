package com.knubisoft.generator;

public class ShortGenerator implements Generator<Short> {
    @Override
    public Short generate() {
        return (short) rand.nextInt(-32768, 32768);
    }
}
