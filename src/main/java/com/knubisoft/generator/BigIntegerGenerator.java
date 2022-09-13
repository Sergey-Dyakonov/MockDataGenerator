package com.knubisoft.generator;

import lombok.NoArgsConstructor;

import java.math.BigInteger;
@NoArgsConstructor
public class BigIntegerGenerator implements Generator<BigInteger> {
    @Override
    public BigInteger generate() {
        return BigInteger.valueOf(rand.nextLong());
    }
}
