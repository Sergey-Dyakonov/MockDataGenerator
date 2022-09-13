package com.knubisoft;

import com.fasterxml.jackson.core.type.TypeReference;
import com.knubisoft.generator.*;
import com.knubisoft.sample.Person;
import com.knubisoft.sample.X;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

/* Make possible to generate:
 *  TODO: 0. REFACTOR
 *  DONE: 1. primitives
 *  DONE: 2. composite objects
 *  DONE: 3. collections
 *  DONE: 4. collections of collections
 *  TODO: 5. arrays
 *  TODO: 6. enums
 *  TODO: 7. objects of inner classes
 *  TODO: 8. records
 *  TODO: 9. reading all generators from the package 'generator'
 *  TODO:10. generating all classes from 'sample' dir
 *  TODO:11. write tests
 * */

public class Main {

    public static void main(String[] args) {
        MockResolver mockResolver = new MockResolver();
        System.out.println(mockResolver.populate(new TypeReference<String>() {
        }.getType()));
        System.out.println(mockResolver.populate(new TypeReference<Person>() {
        }.getType()));
        System.out.println(mockResolver.populate(new TypeReference<List<String>>() {
        }.getType()));
        System.out.println(mockResolver.populate(new TypeReference<Set<Integer>>() {
        }.getType()));
        System.out.println(mockResolver.populate(new TypeReference<Queue<Character>>() {
        }.getType()));
        System.out.println(mockResolver.populate(new TypeReference<List<List<Integer>>>() {
        }.getType()));
        System.out.println(mockResolver.populate(new TypeReference<Map<Integer, String>>() {
        }.getType()));
        System.out.println(mockResolver.populate(new TypeReference<X>() {
        }.getType()));
    }
}
