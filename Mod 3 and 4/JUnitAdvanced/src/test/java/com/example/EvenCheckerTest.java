package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 10, 100})
    void testEvenNumbers(int input) {
        EvenChecker checker = new EvenChecker();
        assertTrue(checker.isEven(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testOddNumbers(int input) {
        EvenChecker checker = new EvenChecker();
        assertFalse(checker.isEven(input));
    }
}
