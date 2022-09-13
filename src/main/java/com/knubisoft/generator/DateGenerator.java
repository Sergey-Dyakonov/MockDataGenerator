package com.knubisoft.generator;

import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class DateGenerator implements Generator<Date> {
    @Override
    public Date generate() {
        return new Date();
    }
}
