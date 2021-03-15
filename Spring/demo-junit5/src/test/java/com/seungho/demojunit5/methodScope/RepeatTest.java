package com.seungho.demojunit5.methodScope;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RepeatTest {

    @RepeatedTest(4)
    void repeated() {
        String input = null;

        assertThrows(NullPointerException.class, () -> {
            int length = input.length();
            System.out.println("length = " + length);
        });
    }

}
