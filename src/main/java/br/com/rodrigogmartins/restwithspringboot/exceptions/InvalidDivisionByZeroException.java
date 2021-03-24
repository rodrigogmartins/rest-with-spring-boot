package br.com.rodrigogmartins.restwithspringboot.exceptions;

public class InvalidDivisionByZeroException extends RuntimeException {

    public InvalidDivisionByZeroException(String exception) {
        super(exception);
    }

}
