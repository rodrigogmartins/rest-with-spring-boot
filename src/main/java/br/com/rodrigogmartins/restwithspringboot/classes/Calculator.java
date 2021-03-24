package br.com.rodrigogmartins.restwithspringboot.classes;

import br.com.rodrigogmartins.restwithspringboot.exceptions.InvalidDivisionByZeroException;
import br.com.rodrigogmartins.restwithspringboot.exceptions.UnexpectedValueOfParameterException;

public class Calculator {

    public static double average(double[] numbers) {
        double totalSumOfNumbers = 0;
        int amountOfNumbers = numbers.length;

        if (isAnEmptyArrayOfNumbers(numbers)) {
            return 0;
        }

        for (double number : numbers) {
            totalSumOfNumbers  = sum(totalSumOfNumbers, number);
        }

        return divide(totalSumOfNumbers, amountOfNumbers);
    }

    private static boolean isAnEmptyArrayOfNumbers(double[] numbers) {
        return numbers.length == 0;
    }

    public static double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new InvalidDivisionByZeroException("unexpected division by zero");
        }

        return firstNumber / secondNumber;
    }

    public static double squareRoot(double number) {
        if (number < 0) {
            throw new UnexpectedValueOfParameterException("the number to get square root must be greater than 0");
        }

        return Math.sqrt(number);
    }

}
