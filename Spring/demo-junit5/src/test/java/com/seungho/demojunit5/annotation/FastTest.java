package com.seungho.demojunit5.annotation;

import org.junit.jupiter.api.Test;

public class FastTest {

    @Test
    @Fast
    void myFast() {
        System.out.println("fast!");
    }

}
