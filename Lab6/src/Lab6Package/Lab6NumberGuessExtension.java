/**********************************
 * File: Lab6NumberGuessExtension.java
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
public class Lab6NumberGuessExtension {

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
        // The default ranges
        int[][] ranges = {{0,10}, {0,100}, {0,500}, {0,1000}};
        try {
            do {
                int[] range = getRange(scan, ranges);
                int min = range[0], max = range[1];
                int secret = randomRange(rand, min, max);
                boolean success = false;
                int guesses = minimumGuesses(min, max);

                System.out.println("You have " + guesses + " guess(es) to guess the secret number.");
                do {
                    if (guesses == 0) {
                        System.out.print("You ran out of guesses. The secret number was " + secret + ". ");
                        break;
                    }
                    int guess = getGuess(scan, min, max);
                    guesses--;
                    if (guess == secret) {
                        System.out.print("CORRECT! You guessed the secret number. ");
                        success = true;
                    } else if (guess < secret) {
                        System.out.println("Your guess is too low, please try again. " + 
                                "You have " + guesses + " guess(es) left.");
                    } else if (guess > secret) {
                        System.out.println("Your guess is too high, please try again. " + 
                                "You have " + guesses + " guess(es) left.");
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
        return prng.nextInt((max - min) + 1) + min;
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

    /**
     * Calculates minimum number of guesses to ensure getting the number in the range
     * 
     * @param min minimum
     * @param max maximum
     * @return minimum guesses required
     */
    public static int minimumGuesses(int min, int max) {
        return (int)(Math.log(max-min + 1)/Math.log(2)) + 1;
    }

    /**
     * Asks the user to choose a range from preconfigured defaults. Allows
     * the user to enter a custom range if they so choose. Returns an int
     * array with the first element being the min and the second the max.
     * 
     * @param scan Scanner
     * @param defaults int[][] of defaults
     * @return min and max in int[]
     */
    public static int[] getRange(Scanner scan, int[][] defaults) {
        System.out.println("Please select the range you want to play with:");
        for (int i=0; i < defaults.length; i++) {
            System.out.printf("%0"+(Integer.toString(defaults.length+1).length())+"d.   %d - %d\n",
                    i+1, defaults[i][0], defaults[i][1]);
        }
        System.out.println((defaults.length+1) + ".   Custom Range");
        boolean success = false;
        int choice = 0;
        while (!success) {
            System.out.print("Your selection (1 to " + (defaults.length+1) + ") : ");
            try {
                choice = scan.nextInt();
                if (choice < 1 || choice > defaults.length+1) {
                    System.out.println("Your choice is outside the acceptable range. Please choose again.");
                } else {
                    success = true;
                }
            } catch(java.util.InputMismatchException error) {
                System.out.println("ERROR: '" + scan.next() + "' is not a valid choice");
            }
        }
        if (choice == defaults.length+1) {
            int[] range = new int[2];
            boolean successMin = false, successMax = false;
            while (!successMin) {
                System.out.print("Choose the minimum: ");
                try {
                    range[0] = scan.nextInt();
                    successMin = true;
                } catch(java.util.InputMismatchException error) {
                    System.out.println("ERROR: '" + scan.next() + "' is not a valid number");
                }
            }
            while (!successMax) {
                System.out.print("Choose the maximum: ");
                try {
                    range[1] = scan.nextInt();
                    if (range[0] <= range[1]) {
                        successMax = true;
                    } else {
                        System.out.println("Maximum must be greater than minimum.");
                    }
                } catch(java.util.InputMismatchException error) {
                    System.out.println("ERROR: '" + scan.next() + "' is not a valid number");
                }
            }
            return range;
        } else {
            return defaults[choice-1];
        }
    }
}

