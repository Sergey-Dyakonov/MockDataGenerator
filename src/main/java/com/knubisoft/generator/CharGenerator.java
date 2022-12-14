package com.knubisoft.generator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CharGenerator implements Generator<Character> {
    public static final int MIN_ASCII_ALPHABETICAL_SYMBOL = 65;
    public static final int MAX_ASCII_ALPHABETICAL_SYMBOL = 122;
    private int firstSymbolCode = MIN_ASCII_ALPHABETICAL_SYMBOL;
    private int lastSymbolCode = MAX_ASCII_ALPHABETICAL_SYMBOL;

    @Override
    public Character generate() {
        return (char) rand.nextInt(firstSymbolCode, lastSymbolCode + 1);
    }
}
