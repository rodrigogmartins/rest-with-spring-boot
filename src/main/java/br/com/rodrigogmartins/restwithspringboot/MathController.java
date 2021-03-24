package br.com.rodrigogmartins.restwithspringboot;

import br.com.rodrigogmartins.restwithspringboot.classes.Calculator;
import br.com.rodrigogmartins.restwithspringboot.classes.NumberConverter;
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
                NumberConverter.convertNumericToDouble(firstNumber),
                NumberConverter.convertNumericToDouble(secondNumber)
        );
    }

    @RequestMapping(value = "subtraction/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        return Calculator.subtract(
                NumberConverter.convertNumericToDouble(firstNumber),
                NumberConverter.convertNumericToDouble(secondNumber)
        );
    }

    @RequestMapping(value = "multiplication/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        return Calculator.multiply(
                NumberConverter.convertNumericToDouble(firstNumber),
                NumberConverter.convertNumericToDouble(secondNumber)
        );
    }

    @RequestMapping(value = "division/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double division(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        return Calculator.divide(
                NumberConverter.convertNumericToDouble(firstNumber),
                NumberConverter.convertNumericToDouble(secondNumber)
        );
    }


    @RequestMapping(value = "squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "number") String number) throws InvalidNumericValueFormatException {
        return Calculator.squareRoot(NumberConverter.convertNumericToDouble(number));
    }

    @RequestMapping(value = "average/{firstNumber}/{secondNumber}", method = RequestMethod.GET)
    public Double average(
            @PathVariable(value = "firstNumber") String firstNumber,
            @PathVariable(value = "secondNumber") String secondNumber
    ) throws InvalidNumericValueFormatException {
        double[] numbers = {
                NumberConverter.convertNumericToDouble(firstNumber),
                NumberConverter.convertNumericToDouble(secondNumber)
        };

        return Calculator.average(numbers);
    }

}
