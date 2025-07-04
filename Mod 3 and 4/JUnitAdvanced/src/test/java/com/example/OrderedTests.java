package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running A");
        assertTrue(true);
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running B");
        assertTrue(true);
    }

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running C");
        assertTrue(true);
    }
}
