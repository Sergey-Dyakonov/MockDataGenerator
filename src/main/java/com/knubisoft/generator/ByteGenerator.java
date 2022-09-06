package com.knubisoft.generator;

public class ByteGenerator implements Generator<Byte> {
    @Override
    public Byte generate() {
        return (byte) rand.nextInt(-128, 128);
    }
}
