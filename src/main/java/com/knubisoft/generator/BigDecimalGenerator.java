package com.knubisoft.generator;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
public class BigDecimalGenerator implements Generator<BigDecimal> {
    @Override
    public BigDecimal generate() {
        return new BigDecimal(rand.nextLong());
    }
}
