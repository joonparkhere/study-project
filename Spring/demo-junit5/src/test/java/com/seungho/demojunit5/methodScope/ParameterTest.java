package com.seungho.demojunit5.methodScope;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
    void isOdd(int num) {
        assertTrue(num % 2 != 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AAA", "ABC", "AVXZE", "EFSCZ_EFDFA"})
    void isHavingA(String input) {
        assertTrue(input.contains("A"));
    }

}
