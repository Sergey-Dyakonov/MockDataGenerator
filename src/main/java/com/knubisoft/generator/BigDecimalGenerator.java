package com.knubisoft.generator;

import java.math.BigDecimal;

public class BigDecimalGenerator implements Generator<BigDecimal> {
    @Override
    public BigDecimal generate() {
        return new BigDecimal(rand.nextLong());
    }
}
