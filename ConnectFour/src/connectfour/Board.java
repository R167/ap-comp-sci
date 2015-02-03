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

    public String toString() {
        StringBuilder ret = new StringBuilder(board.length * board[0].length * 5);
        seperate(ret, board.length);
        for (int j = board[0].length - 1; j >= 0; j--) {
            ret.append('|');
            for (int i = 0; i < board.length; i++) {
                ret.append(board[i][j].getChar()).append('|');
            }
            ret.append('\n');
        }
        seperate(ret, board.length);
        ret.append(' ');
        for (int i = 0; i < board.length; i++) {
            ret.append(i).append(' ');
        }
        return ret.toString();
    }

    private void seperate(StringBuilder str, int times) {
        str.append("+");
        for (int i = 0; i < times; i++) {
            str.append("-+");
        }
        str.append('\n');
    }

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

    public int spots() {
        return board[0].length * board.length;
    }
}
