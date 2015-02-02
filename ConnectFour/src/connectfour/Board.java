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

    public Color findWinner() {
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

    private Color diagnolWinner() {
        for (int i = 0; i <= board.length - 4; i++) {
            for (int j = 0; j <= board[0].length - 4; j++) {
                Color current = board[i][j];
                if (current.isNotNone()) {
                    boolean success = true;
                    for (int k = 1; k < 4; k++) {
                        if (board[i + k][j + k] != current) {
                            success = false;
                            break;
                        }
                    }
                    if (success) {
                        return current;
                    }
                }
            }
        }
        for (int i = board.length - 1; i >= board.length - 4; i--) {
            for (int j = 0; j <= board[0].length - 4; j++) {
                Color current = board[i][j];
                if (current.isNotNone()) {
                    boolean success = true;
                    for (int k = 1; k < 4; k++) {
                        if (board[i - k][j + k] != current) {
                            success = false;
                            break;
                        }
                    }
                    if (success) {
                        return current;
                    }
                }
            }
        }
        return Color.NONE;
    }

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
}
