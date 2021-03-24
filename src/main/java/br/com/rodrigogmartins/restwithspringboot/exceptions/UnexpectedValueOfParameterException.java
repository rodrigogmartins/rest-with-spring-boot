package br.com.rodrigogmartins.restwithspringboot.exceptions;

public class UnexpectedValueOfParameterException extends RuntimeException {

    public UnexpectedValueOfParameterException(String exception) {
        super(exception);
    }

}
