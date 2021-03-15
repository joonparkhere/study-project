package com.seungho.demojunit5.methodScope;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTest {

    @Test
    @Order(1)
    void test01() {
        System.out.println("test01");
    }

    @Test
    @Order(4)
    void test04() {
        System.out.println("test04");
    }

    @Test
    @Order(2)
    void test02() {
        System.out.println("test02");
    }

    @Test
    @Order(3)
    void test03() {
        System.out.println("test03");
    }

}
