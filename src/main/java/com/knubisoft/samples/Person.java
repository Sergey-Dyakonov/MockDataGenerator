package com.knubisoft.samples;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Person {
    private int age;
    private String name;
    private Date dateOfBirth;
}