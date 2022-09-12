package com.knubisoft.generator;

import java.util.Date;

public class DateGenerator implements Generator<Date> {
    @Override
    public Date generate() {
        return new Date();
    }
}
