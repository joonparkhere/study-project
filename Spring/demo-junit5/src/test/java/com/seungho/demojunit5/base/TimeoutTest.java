package com.seungho.demojunit5.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class TimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    void timeoutTest() throws InterruptedException {
        delay(400);
    }


    void delay(int millisecond) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(millisecond);
    }

}
