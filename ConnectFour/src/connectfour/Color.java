/**********************************
 * File: Color.java
 * 
 * Author: Winston Durand
 * Modified: Feb 2, 2015
 **********************************/
package connectfour;

/**
 * @author Winston Durand
 */
public enum Color {
    WHITE, BLACK, NONE;
    
    public boolean isNone() {
        return this == NONE;
    }
    
    public boolean isNotNone() {
        return this != NONE;
    }
}
