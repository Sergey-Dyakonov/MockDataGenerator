package com.knubisoft.generator;

import java.math.BigInteger;

public class BigIntegerGenerator implements Generator<BigInteger> {
    @Override
    public BigInteger generate() {
        return BigInteger.valueOf(rand.nextLong());
    }
}
