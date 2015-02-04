/**********************************
 * File: Color.java
 * 
 * Author: Winston Durand
 * Modified: Feb 2, 2015
 **********************************/
package connectfour;

/**
 * An enum containing the possible colors that people
 * can choose. Has WHITE and BLACK for players and NONE
 * for when a square is blank.
 * 
 * @author Winston Durand
 */
public enum Color {
    WHITE, BLACK, NONE;

    /**
     * Helper to check if the enum is NONE
     * without == in code.
     * 
     * @return is this NONE
     */
    public boolean isNone() {
        return this == NONE;
    }

    /**
     * Helper to check if the enum is not NONE
     * without == in code.
     * 
     * @return is this NONE
     */
    public boolean isNotNone() {
        return this != NONE;
    }

    /**
     * Gets the other color for changing players.
     * Returns BLACK when WHITE, WHITE when BLACK,
     * and NONE when NONE for compatibility.
     * 
     * @return opposite of the current color
     */
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

    /**
     * Returns a char representation of the current
     * Color for display purposes.
     * 
     * @return char representing Color
     */
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
