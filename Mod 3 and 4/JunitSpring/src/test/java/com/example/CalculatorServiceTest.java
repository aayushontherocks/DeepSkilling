package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService service = new CalculatorService();
        int result = service.add(5, 3);
        assertEquals(8, result);
    }
}
