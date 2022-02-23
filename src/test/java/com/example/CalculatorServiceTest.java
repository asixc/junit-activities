package com.example;

import com.example.demo.service.CalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CalculatorServiceTest: Operaciones aritméticas básicas")
class CalculatorServiceTest {

    // System Under Test
    CalculatorService calculator = new CalculatorService();

    @Test
    @DisplayName("Suma de números naturales: 5 + 5")
    void sumTest() {
        int actual = calculator.sum(5, 5);
        assertEquals(10, actual);
    }

    @Test
    @DisplayName("Suma cero es igual 0")
    void sumZeroTest() {
        int actual = calculator.sum(0, 0);
        assertEquals(0, actual);
    }

    @Test
    @DisplayName("Suma negativa es igual a 0")
    void sumNegativeTest() {
        int actual = calculator.sum(-5, 0);
        assertEquals(5, actual);
    }
}