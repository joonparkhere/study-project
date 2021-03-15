package com.seungho.demojunit5.classScope;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class NestedTest {

    @Test
    void outerTest() {
        System.out.println("Outer Class Test");
    }

    @Nested
    class InnerClass {

        @Test
        void innerTest() {
            System.out.println("Inner Class Test");
        }

    }

}
