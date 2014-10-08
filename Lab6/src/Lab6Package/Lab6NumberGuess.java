/**********************************
 * File: Lab6NumberGuess.java
 * 
 * Author: Winston Durand
 * Modified: Oct 5, 2014
 **********************************/
package Lab6Package;

import java.util.Random;
import java.util.Scanner;

/**
 * Implements a number guessing game
 * 
 * @author Winston Durand
 */
public class Lab6NumberGuess {

    /**
     * Asks the user to input a number. It will continue the game
     * until the user guesses correct. The user is given the option
     * to quit or continue and the game repeats if the user chooses to
     * play again.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        try {
            do {
                int secret = randomRange(rand, 1, 100);
                boolean success = false;
                do {
                    int guess = getGuess(scan, 1, 100);
                    if (guess == secret) {
                        System.out.print("CORRECT! You guessed the secret number. ");
                        success = true;
                    } else if (guess < secret) {
                        System.out.println("Your guess is too low, please try again.");
                    } else if (guess > secret) {
                        System.out.println("Your guess is too high, please try again.");
                    } else {
                        System.out.println("You broke my program, impressive...");
                    }
                } while (!success);
            } while (keepPlaying(scan));
            System.out.println("Good-bye!");
        } finally {
            scan.close();
        }
    }

    /**
     * Asks the user to input a number. Makes sure that it is between the min
     * and max. Will keep prompting the user until an acceptable answer is received.
     * 
     * @param scan
     * @param min minimum
     * @param max maximum
     * @return number between min and max
     */
    public static int getGuess(Scanner scan, int min, int max) {
        boolean success = false;
        int ret = 0;
        while (!success) {
            System.out.print("Please enter your guess (" + min + " to " + max + ") : ");
            try {
                ret = scan.nextInt();
                if (ret < min || ret > max) {
                    System.out.println("Your guess is outside the acceptable range. Please guess again.");
                } else {
                    success = true;
                }
            } catch(java.util.InputMismatchException error) {
                System.out.println("ERROR: '" + scan.next() + "' is not an integer");
            }
        }
        return ret;
    }

    /**
     * Returns a random number in the range of min-max
     * 
     * @param prng pseudorandom number generator
     * @param min minimum
     * @param max maximum
     * @return number between min and max
     */
    public static int randomRange(Random prng, int min, int max) {
        return prng.nextInt(max-min+1)+min;
    }

    /**
     * Asks the user if they want to play again
     * 
     * @param scan Scanner
     * @return whether or not the user wants to play again
     */
    public static boolean keepPlaying(Scanner scan) {
        System.out.print("Do you want to play again? [Y/n]: ");
        if (scan.next().toLowerCase().charAt(0) == 'y') {
            return true;
        } else {
            return false;
        }
    }

}
