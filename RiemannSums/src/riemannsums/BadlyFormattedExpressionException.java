/****************************
 * File: BadlyFormattedExpressionException.java
 * 
 * Author: Winston Durand
 * Modified: Mar 16, 2015
 ***************************/
package riemannsums;

/**
 * @author Winston Durand
 * 
 */
public class BadlyFormattedExpressionException extends ArithmeticException {
    private static final long serialVersionUID = 5666585026359150506L;

    public BadlyFormattedExpressionException() {
        super();
    }

    public BadlyFormattedExpressionException(String s) {
        super(s);
    }
}
