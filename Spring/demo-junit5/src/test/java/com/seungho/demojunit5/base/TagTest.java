package com.seungho.demojunit5.base;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tags({@Tag("fast"), @Tag("model")})
public class TagTest {

    @Test
    @Tag("exact")
    void doSomething() {
        System.out.println("hi");
    }

}
