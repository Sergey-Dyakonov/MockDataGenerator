package com.knubisoft.sample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class X {
    private String name;
    private List<Date> list;
    private boolean flag;
}
