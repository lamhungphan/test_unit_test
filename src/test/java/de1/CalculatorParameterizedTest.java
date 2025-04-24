package de1;

import com.course.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorParameterizedTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Order(1)
    @Test
    void testMultiplyFirst() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Order(2)
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "3, 5, 8",
            "4, 2, 6",
            "-1, 1, 0"
    })
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @Order(3)
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "9, 4, 5",
            "7, 2, 5",
            "5, 5, 0"
    })
    void testSubtractLast(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @Order(4)
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({
            "8, 2, 4",
            "9, 3, 3"
    })
    void testDivide(int a, int b, int expected) {
        assertEquals(expected, calculator.divide(a, b));
    }

    @Order(5)
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("/ by zero", exception.getMessage());
    }
}
