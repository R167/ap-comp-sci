/****************************
 * File: TokenPass.java
 * 
 * Author: Winston Durand
 * Modified: Jan 27, 2015
 ***************************/
package sem1final;

import java.util.Random;

/**
 * @author Winston Durand
 * 
 */
public class TokenPass {
    private int[] board;
    private int currentPlayer;
    private Random rand = new Random();

    public TokenPass(int playerCount) {
        board = new int[playerCount];
        currentPlayer = rand.nextInt(board.length);
        for (int player = 0; player < board.length; player++) {
            board[player] = rand.nextInt(10) + 1;
        }
        printBoard();
    }

    public static void main (String args[]) {
        TokenPass tokenPass = new TokenPass(5);
        tokenPass.distributeCurrentPlayerTokens();
        
        tokenPass.printBoard();
    }

    public void distributeCurrentPlayerTokens() {
        int tmp = board[currentPlayer];
        int incPlayer = currentPlayer + 1;
        board[currentPlayer] = 0;
        
        for (int i = 0; i < tmp; i++) {
            printBoard();
            board[incPlayer % board.length] += 1;
            incPlayer++;
        }
    }
    
    public void printBoard() {
        for (int i : board) {
            System.out.printf("%02d ", i);
        }
        
        System.out.println();
    }
    
    /**
     * Implements a random number using Math.random() <br>
     * Returns random number in the range of lower...upper (ruby notation)
     * 
     * @param lower inclusive lower range
     * @param upper exclusive upper range
     * @return random number
     */
    @SuppressWarnings("unused")
    private static int random(int lower, int upper) {
        return (int) (Math.random() * (upper - lower)) + lower;
    }
}
