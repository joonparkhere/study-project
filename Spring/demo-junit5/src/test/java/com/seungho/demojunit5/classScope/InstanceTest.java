package com.seungho.demojunit5.classScope;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InstanceTest {

    @Test
    void doSomeThing() {
        System.out.println("hi");
    }

    @BeforeAll
    void init() {
        System.out.println("TestInstance: before");
    }

    @AfterAll
    void done() {
        System.out.println("TestInstance: after");
    }

}
