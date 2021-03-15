package com.seungho.demojunit5.assertion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    @Test
    void equalsAssertions() {
        assertEquals(2, 1+1);
    }

    @Test
    void sameAssertions() {
        assertSame("abc", "abc");
    }

    @Test
    void nullCheckAssertions() {
        String input = "a";
        assertNotNull(input);
    }

    @Test
    void exceptionAssertions() {
        String input = null;
        assertThrows(NullPointerException.class, () -> {
            int length = input.length();
            System.out.println("length = " + length);
        });
    }

    @Test
    void timeoutAssertions() {
        assertTimeout(Duration.ofMillis(100),
                () -> Thread.sleep(50)
        );
    }

    @Test
    void groupedAssertions() {
        assertAll(
                () -> assertEquals(2, 1+1),
                () -> assertEquals(2, 4/2)
        );
    }

}
