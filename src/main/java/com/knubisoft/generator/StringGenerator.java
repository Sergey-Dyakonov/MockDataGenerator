package com.knubisoft.generator;

public class StringGenerator implements Generator<String>{

    private static final int MAX_LENGTH = 20;
    @Override
    public String generate() {
        StringBuilder str = new StringBuilder();
        CharGenerator charGenerator = new CharGenerator();
        int length = rand.nextInt(1, MAX_LENGTH);
        for (int i = 0; i < length; i++) {
            str.append(charGenerator.generate());
        }
        return str.toString();
    }
}
