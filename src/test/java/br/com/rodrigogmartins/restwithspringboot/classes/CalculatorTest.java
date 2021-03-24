package br.com.rodrigogmartins.restwithspringboot.classes;

import br.com.rodrigogmartins.restwithspringboot.exceptions.InvalidDivisionByZeroException;
import br.com.rodrigogmartins.restwithspringboot.exceptions.UnexpectedValueOfParameterException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    @Test
    @DisplayName("Test average only with positive numbers")
    public void testAverageWithOnlyPositiveNumbers() {
        double[] numbers = { 30, 20, 10 };

        assertEquals(20, Calculator.average(numbers));
    }

    @Test
    @DisplayName("Test average with negative numbers")
    public void testAverageWithNegativeNumbers() {
        double[] numbers = { 30, 20, -10, -40 };

        assertEquals(0, Calculator.average(numbers));
    }

    @Test
    @DisplayName("Test average of empty numbers list")
    public void testAverageOfEmptyNumbersList() {
        double[] numbers = new double[0];

        assertEquals(0, Calculator.average(numbers));
    }

    @Test
    @DisplayName("Test average with decimal numbers")
    public void testAverageWithDecimalNumbers() {
        double[] numbers = { 30, 20.22, -10.44, -90.22 };

        assertEquals(-12.61, Calculator.average(numbers));
    }

    @Test
    @DisplayName("Test addition with two positive numbers")
    public void testAdditionWithTwoPositiveNumbers() {
        assertEquals(15, Calculator.sum(7, 8));
    }

    @Test
    @DisplayName("Test addition with first number negative")
    public void testAdditionWithFirstNumberNegative() {
        assertEquals(-1, Calculator.sum(-9, 8));
    }

    @Test
    @DisplayName("Test addition with second number negative")
    public void testAdditionWithSecondNumberNegative() {
        assertEquals(3, Calculator.sum(8, -5));
    }

    @Test
    @DisplayName("Test addition with two negative numbers")
    public void testAdditionWithTwoNegativeNumbers() {
        assertEquals(-49, Calculator.sum(-44, -5));
    }

    @Test
    @DisplayName("Test addition of two decimal numbers with second number negative")
    public void testAdditionOfTwoDecimalNumbersWithSecondNumberNegative() {
        assertEquals(3.41, Calculator.sum(8.74, -5.33));
    }

    @Test
    @DisplayName("Test subtraction with two positive numbers")
    public void testSubtractionWithTwoPositiveNumbers() {
        assertEquals(3, Calculator.subtract(8, 5));
    }

    @Test
    @DisplayName("Test subtraction with first number negative")
    public void testSubtractionWithFirstNumberNegative() {
        assertEquals(-13, Calculator.subtract(-8, 5));
    }

    @Test
    @DisplayName("Test subtraction with second number negative")
    public void testSubtractionWithSecondNumberNegative() {
        assertEquals(13, Calculator.subtract(8, -5));
    }

    @Test
    @DisplayName("Test subtraction with two negative numbers")
    public void testSubtractionWithTwoNegativeNumbers() {
        assertEquals(-39, Calculator.subtract(-44, -5));
    }

    @Test
    @DisplayName("Test subtraction of two decimal numbers with second number negative")
    public void testSubtractionOfTwoDecimalNumbersWithSecondNumberNegative() {
        assertEquals(14.07, Calculator.subtract(8.74, -5.33));
    }

    @Test
    @DisplayName("Test multiplication with two positive numbers")
    public void testMultiplicationWithTwoPositiveNumbers() {
        assertEquals(20, Calculator.multiply(4, 5));
    }

    @Test
    @DisplayName("Test multiplication with first number negative")
    public void testMultiplicationWithFirstNumberNegative() {
        assertEquals(-20, Calculator.multiply(-4, 5));
    }

    @Test
    @DisplayName("Test multiplication with second number negative")
    public void testMultiplicationWithSecondNumberNegative() {
        assertEquals(-20, Calculator.multiply(4, -5));
    }

    @Test
    @DisplayName("Test multiplication of two decimal numbers with second number negative")
    public void testMultiplicationOfTwoDecimalNumbersWithSecondNumberNegative() {
        assertEquals(-25.515, Calculator.multiply(4.5, -5.67));
    }

    @Test
    @DisplayName("Test multiplication with two negative numbers")
    public void testMultiplicationWithTwoNegativeNumbers() {
        assertEquals(63, Calculator.multiply(-9, -7));
    }

    @Test
    @DisplayName("Test multiplication with one negative number changing the order of the factors")
    public void testMultiplicationWithOneNegativeNumberChangingTheOrderOfTheFactors() {
        assertEquals(Calculator.multiply(-99, 5), Calculator.multiply(99, -5));
    }

    @Test
    @DisplayName("Test division with two positive numbers")
    public void testDivisionWithTwoPositiveNumbers() {
        assertEquals(2, Calculator.divide(10, 5));
    }

    @Test
    @DisplayName("Test division by negative number")
    public void testDivisionByNegativeNumber() {
        assertEquals(-8.5, Calculator.divide(17, -2));
    }

    @Test
    @DisplayName("Test division of negative number")
    public void testDivisionOfNegativeNumber() {
        assertEquals(-5, Calculator.divide(-10, 2));
    }

    @Test
    @DisplayName("Test division by negative decimal number")
    public void testDivisionByNegativeDecimalNumber() {
        assertEquals(-4, Calculator.divide(10, -2.5));
    }

    @Test
    @DisplayName("Test division of negative decimal number")
    public void testDivisionOfNegativeDecimalNumber() {
        assertEquals(-5.25, Calculator.divide(-10.5, 2));
    }

    @Test
    @DisplayName("Test division of zero")
    public void testDivisionOfZero() {
        assertEquals(0, Calculator.divide(0, 10));
    }

    @Test
    @DisplayName("Test division by zero")
    public void testDivisionByZero() {
        assertThrows(InvalidDivisionByZeroException.class, () -> Calculator.divide(10, 0));
    }

    @Test
    @DisplayName("Test square root of positive number")
    public void testSquareRootOfPositive() {
        assertEquals(2, Calculator.squareRoot(4));
    }

    @Test
    @DisplayName("Test square root of zero")
    public void testSquareRootOfZero() {
        assertEquals(0, Calculator.squareRoot(0));
    }

    @Test
    @DisplayName("Test square root of positive decimal number")
    public void testSquareRootOfPositiveDecimalNumber() {
        assertEquals(2.1071307505705477, Calculator.squareRoot(4.44));
    }

    @Test
    @DisplayName("Test square root of negative number")
    public void testSquareRootOfNegativeNumber() {
        assertThrows(UnexpectedValueOfParameterException.class, () -> Calculator.squareRoot(-4));
    }

    @Test
    @DisplayName("Test square root of negative decimal number")
    public void testSquareRootOfNegativeDecimalNumber() {
        assertThrows(UnexpectedValueOfParameterException.class, () -> Calculator.squareRoot(-4.44));
    }

}