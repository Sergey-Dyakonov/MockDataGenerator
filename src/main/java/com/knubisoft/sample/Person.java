package com.knubisoft.sample;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private int age;
    private String name;
    private Date dateOfBirth;
}