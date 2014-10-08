/**********************************
 * File: Lab5RockPaperScissors.java
 * 
 * Author: Winston Durand
 * Modified: Sep 25, 2014
 **********************************/
package Lab5Package;

import java.util.Scanner;
import java.util.Random;

/**
 * Plays a game of Rock Paper Scissors
 * 
 * @author Winston Durand
 */
public class Lab5RockPaperScissors {

    private static char[] choices;

    /**
     * Asks user to choose either rock paper or scissors. Validates that the user's
     * input is legal and then has the computer choose r, p, or s. Prints out who
     * won or if the result was a tie. Throws an exception if something invalid made
     * it past validation.
     * 
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your choice of Rock, Paper, or Scissors: ");
        String rawChoice = null;
        try {
            rawChoice = scan.nextLine();
        } finally {
            scan.close();
        }
        char choice = rawChoice.toLowerCase().charAt(0);
        choices = new char[] {'r', 'p', 's'};

        if (validChoice(choices, choice)) {
            char computer = choices[new Random().nextInt(2)];
            int winner = whoWon(choice, computer);

            if (winner == 0) {
                System.out.println("You chose " + letterToName(computer) + " and so did the computer. It is a tie.");
            } else if (winner == 1) {
                System.out.println("You beat the computer with " + letterToName(choice) + ". It chose " + letterToName(computer));
            } else {
                System.out.println("The computer beat you with " + letterToName(computer) + ". You chose " + letterToName(choice));
            }
        } else {
            // User is wrong
            System.out.println("'" + rawChoice + "' is not valid.");
        }

    }

    /**
     * Gets the name of the tool that a letter corresponds to
     * 
     * @param letter letter of the tool
     * @return name of the tool
     */
    private static String letterToName(char letter) {
        if (letter == 'r') {
            return "Rock";
        } else if (letter == 'p') {
            return "Paper";
        } else if (letter == 's') {
            return "Scissors";
        }
        return "";
    }

    /**
     * Checks whether or not an element is contained in the char array
     * 
     * @param sides array of valid choices
     * @param choice the user choice 
     * @return whether or not choice is in the array
     */
    private static boolean validChoice(char[] sides, char choice) {
        for (char side : sides) {
            if (side == choice) {
                return true;
            }
        }
        // return false if flip is not in the array sides
        return false;
    }

    /**
     * Determines who won the rps match
     * 
     * @param user1 the choice of user1
     * @param user2 the choice of user2
     * @return 0 if tie, 1 if user1, -1 if user2
     * @throws Exception neither tie nor winner
     */
    private static int whoWon(char user1, char user2) throws Exception {
        if (user1 == user2) {
            return 0;
        } else if ((user1 == 'r' && user2 == 's') || (user1 == 's' && user2 == 'p') || (user1 == 'p' && user2 == 'r')) {
            return 1;
        } else if (whoWon(user2, user1) == 1) { // just to idiot check
            return -1;
        } else {
            throw new Exception("Invalid choice for one of the users! u1:" + user1 + " u2:" + user2);
        }
    }

}
