package com.example;

import org.junit.Assert.assertEquals;
import org.junit.Test;

public class calculatorTest {

    @Test
    public void testAdd() {
        calculator calc = new calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testSubtract() {
        calculator calc = new calculator();
        assertEquals(1, calc.subtract(4, 3));
    }
}
