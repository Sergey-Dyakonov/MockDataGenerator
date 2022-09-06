package com.knubisoft.generator;

public class CharGenerator implements Generator<Character> {
    private static final int MIN_ASCII_SYMBOL = 32;
    private static final int MAX_ASCII_SYMBOL = 127;

    @Override
    public Character generate() {
        return (char) rand.nextInt(32, 127);
    }
}
