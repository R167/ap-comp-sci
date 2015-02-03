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

    public Color other() {
        switch(this) {
        case WHITE:
            return BLACK;
        case BLACK:
            return WHITE;
        default:
            return NONE;
        }
    }

    public char getChar() {
        switch(this) {
        case WHITE:
            return 'O';
        case BLACK:
            return 'X';
        default:
            return ' ';
        }
    }
}
