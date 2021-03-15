package com.seungho.demojunit5.base;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisableTest {

    @Test
    @Disabled("Not implemented yet")
    void notYet() {
        String input = null;
        int length = input.length();
    }

}
