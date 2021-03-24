package br.com.rodrigogmartins.restwithspringboot.classes;

import br.com.rodrigogmartins.restwithspringboot.exceptions.InvalidNumericValueFormatException;

public class NumberConverter {

    public static Double convertNumericToDouble(String numericValue) throws InvalidNumericValueFormatException {
        if (numericValue == null) {
            throw new InvalidNumericValueFormatException("numeric value cannot be null");
        }

        if (!isNumeric(numericValue)) {
            throw new InvalidNumericValueFormatException("numeric value must be a numeric value string");
        }

        return Double.parseDouble(numericValue);
    }

    private static boolean isNumeric(String numericValue)  {
        numericValue = numericValue.replaceAll(",", ".");

        return numericValue.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
