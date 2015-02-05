/**********************************
 * File: Board.java
 * 
 * Author: Winston Durand
 * Modified: Feb 2, 2015
 **********************************/
package connectfour;

/**
 * @author Winston Durand
 */
public class Board {
    private Color[][] board;

    public Board() {
        board = new Color[7][6];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = Color.NONE;
            }
        }
    }

    public boolean dropColumn(int col, Color piece) {
        for (int i = 0; i < board[col].length; i++) {
            if (board[col][i] == Color.NONE) {
                board[col][i] = piece;
                return true;
            }
        }
        return false;
    }

    public Color getAt(int col, int row) {
        return board[col][row];
    }

    /**
     * Generates and ASCII art version of the board to be printed out
     */
    public String toString() {
        StringBuilder ret = new StringBuilder(board.length * board[0].length * 5);
        // Prints the top separator
        separate(ret, board.length);
        for (int j = board[0].length - 1; j >= 0; j--) {
            ret.append('|');
            for (int i = 0; i < board.length; i++) {
                // Puts the Piece's char to the board
                ret.append(board[i][j].getChar()).append('|');
            }
            ret.append('\n');
        }
        // Prints the bottom separator
        separate(ret, board.length);
        ret.append(' ');
        // Prints the numbers of the column
        for (int i = 0; i < board.length; i++) {
            ret.append(i).append(' ');
        }
        return ret.toString();
    }

    private void separate(StringBuilder str, int times) {
        str.append("+");
        for (int i = 0; i < times; i++) {
            str.append("-+");
        }
        str.append('\n');
    }

    /**
     * Figures out the winner for the game
     * 
     * @return Color of the winner or NONE
     */
    public Color getWinner() {
        Color col;
        if ((col = horizontalWinner()).isNotNone()) {
            return col;
        } else if((col = verticalWinner()).isNotNone()) {
            return col;
        } else if ((col = diagnolWinner()).isNotNone()) {
            return col;
        } else {
            return Color.NONE;
        }
    }

    /**
     * Looks for diagnol winners
     * 
     * @return Color of the winner or NONE
     */
    private Color diagnolWinner() {
        Color col;
        for (int i = 0; i <= board.length - 4; i++) {
            if ((col = genericDiagnol(i, 1)).isNotNone()) {
                return col;
            }
        }
        for (int i = board.length - 1; i >= board.length - 4; i--) {
            if ((col = genericDiagnol(i, -1)).isNotNone()) {
                return col;
            }
        }
        return Color.NONE;
    }
    
    /**
     * Keeps code DRY
     * 
     * @param i column to look in
     * @param direction offset type thing
     * @return winners within the 
     */
    private Color genericDiagnol(int i, int direction) {
        for (int j = 0; j <= board[0].length - 4; j++) {
            Color current = board[i][j];
            if (current.isNotNone()) {
                boolean success = true;
                for (int k = 1; k < 4; k++) {
                    if (board[i + k * direction][j + k] != current) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    return current;
                }
            }
        }
        return Color.NONE;
    }

    /**
     * Looks for horizontal winners
     * 
     * @return Color of the winner or NONE
     */
    private Color horizontalWinner() {
        for (int i = 0; i < board[0].length; i++) {
            Color current = Color.NONE;
            int length = 0;
            for (int j = 0; j < board.length; j++) {
                if (current == board[j][i]) {
                    length += 1;
                } else {
                    current = board[j][i];
                    length = 1;
                }
                if (length >= 4 && current != Color.NONE) {
                    return current;
                }
            }
        }
        return Color.NONE;
    }

    /**
     * Looks for vertical winners
     * 
     * @return Color of the winner or NONE
     */
    private Color verticalWinner() {
        for (int i = 0; i < board.length; i++) {
            Color current = Color.NONE;
            int length = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (current == board[i][j]) {
                    length += 1;
                } else {
                    current = board[i][j];
                    length = 1;
                }
                if (length >= 4 && current.isNotNone()) {
                    return current;
                }
            }
        }
        return Color.NONE;
    }

    public int spots() {
        return board[0].length * board.length;
    }
}
