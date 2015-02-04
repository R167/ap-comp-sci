/**********************************
 * File: Driver.java
 * 
 * Author: Winston Durand
 * Modified: Feb 2, 2015
 **********************************/
package connectfour;

import java.util.Scanner;

/**
 * @author Winston Durand
 */
public class Driver {

    /**
     * Main calling function for running the code
     * 
     * @param args
     */
    public static void main(String[] args) {
        logic();
    }

    /**
     * Runtime logic for the game
     */
    public static void logic() {
        Scanner scan = new Scanner(System.in);

        try {
            do {                
                Board board = new Board();

                Color winner = Color.NONE;
                Color player = Color.WHITE;

                int move = 0;

                for (; move < board.spots() && winner.isNone(); move++) {
                    System.out.println(board.toString());
                    System.out.printf("It is player %d's turn.\n", move % 2 + 1);

                    playerTurn(scan, player, board);

                    player = player.other();
                    winner = board.getWinner();
                }

                System.out.println(board.toString());

                if (winner.isNotNone()) {
                    System.out.printf("Player %d won!\n", move % 2 + 1);
                } else {
                    System.out.println("It was a tie!");
                }

                System.out.print("Would you like to play again [y/N]: ");
            } while (scan.next().trim().toLowerCase().charAt(0) == 'y');
        } finally {
            System.out.println("Goodbye!");
            scan.close();
        }
    }

    public static void playerTurn(Scanner scan, Color player, Board board) {
        boolean cont = true;
        
        while (cont) {
            System.out.printf("Column to play %s on: ", player.getChar());
            int num = 0;
            try {
                num = scan.nextInt();
                if (num > 6) {
                    System.out.printf("%d is not a valid number!\n", num);
                } else if (board.dropColumn(num, player)) {
                    cont = false;
                } else {
                    System.out.println("That column is full. Please try another.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.printf("%s is not a valid number!\n", scan.next());
            }
        }
    }
}
