package com.knubisoft.generator;

import java.util.Random;

public interface Generator <T>{

    Random rand = new Random();
    T generate();
}
