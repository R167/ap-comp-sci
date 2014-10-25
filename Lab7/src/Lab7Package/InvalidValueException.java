/****************************
 * File: InvalidValueException.java
 * 
 * Author: Winston Durand
 * Modified: Oct 25, 2014
 ***************************/
package Lab7Package;

/**
 * Indicates an Invalid Value
 * 
 * @author Winston Durand
 */
public class InvalidValueException extends Exception {
    /**
     * Creates an {@code Exception} with a message
     * 
     * @param string message
     * @see Exception
     */
    public InvalidValueException(String string) {
        super(string);
    }

    private static final long serialVersionUID = -3893329619067923557L;

}
