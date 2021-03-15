package com.seungho.demojunit5.lifeCycle;

import org.junit.jupiter.api.*;

public class LifeCycleTest {

    @RepeatedTest(3)
    void doSomething() {
        System.out.println("hi");
    }

    @BeforeAll
    static void beforeStart() {
        System.out.println("before start");
    }

    @BeforeEach
    void init() {
        System.out.println("init");
    }

    @AfterAll
    static void afterStart() {
        System.out.println("after start");
    }

    @AfterEach
    void done() {
        System.out.println("done");
    }

}
