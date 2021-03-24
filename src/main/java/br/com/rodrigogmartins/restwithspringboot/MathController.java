package br.com.rodrigogmartins.restwithspringboot;

import br.com.rodrigogmartins.restwithspringboot.classes.Calculator;
import br.com.rodrigogmartins.restwithspringboot.exceptions.InvalidNumericValueFormatException;
import org.springframework.web.bind.annotation.*;


@RestController
public class MathController {

    @RequestMapping(value = "addition/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double addition(
        @PathVariable(value = "firstNumber") String firstNumber,
        @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        return Calculator.sum(
                Calculator.convertNumericToDouble(firstNumber),
                Calculator.convertNumericToDouble(secondNumber)
        );
    }

    @RequestMapping(value = "subtraction/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        return Calculator.subtract(
                Calculator.convertNumericToDouble(firstNumber),
                Calculator.convertNumericToDouble(secondNumber)
        );
    }

    @RequestMapping(value = "multiplication/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        return Calculator.multiply(
                Calculator.convertNumericToDouble(firstNumber),
                Calculator.convertNumericToDouble(secondNumber)
        );
    }

    @RequestMapping(value = "division/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double division(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        return Calculator.divide(
                Calculator.convertNumericToDouble(firstNumber),
                Calculator.convertNumericToDouble(secondNumber)
        );
    }


    @RequestMapping(value = "squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number) throws InvalidNumericValueFormatException {
        return Calculator.squareRoot(Calculator.convertNumericToDouble(number));
    }

    @RequestMapping(value = "average/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double average(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        double[] numbers = {
                Calculator.convertNumericToDouble(firstNumber),
                Calculator.convertNumericToDouble(secondNumber)
        };

        return Calculator.average(numbers);
    }

}
