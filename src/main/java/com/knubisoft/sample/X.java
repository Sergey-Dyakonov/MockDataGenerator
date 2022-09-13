package com.knubisoft.sample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class X {
    private String name;
    private Map<Integer, List<Date>> list;
    private boolean flag;

    @Override
    public String toString() {
        return "X{" +
                "name='" + name + '\'' +
                ", list=" + list +
                ", flag=" + flag +
                '}';
    }
}
