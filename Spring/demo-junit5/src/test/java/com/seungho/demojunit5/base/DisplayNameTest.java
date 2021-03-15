package com.seungho.demojunit5.base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Class for DisplayName")
public class DisplayNameTest {

    @Test
    @DisplayName("Test Method for DisplayName")
    void doSomething() {
        System.out.println("hi");
    }

}
