/**********************************
 * File: Lab5CoinFlip.java
 * 
 * Author: Winston Durand
 * Modified: Sep 24, 2014
 **********************************/
package Lab5Package;

import java.util.Scanner;
import java.util.Random;

/**
 * Determines whether or not the user won a coin toss
 * 
 * @author Winston Durand
 */
public class Lab5CoinFlip {

    /**
     * Asks the user to input either heads or tails. Computer then randomly chooses
     * heads or tails for a 'coin toss' from an array by selecting a random element
     * of either 't' or 'h'. It then compares the input of the user to figure out if
     * the user won. Prints the output using several statements to keep the code DRY.
     * 
     * @param args
     */
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);
        
        final char[] sides = {'h', 't'};
        
        String name = null;
        String full = null;
        char flip;
        final char coin = sides[new Random().nextInt(2)];
        
        try {
            System.out.print("Please enter your name: ");
            name = scan.nextLine();
            System.out.print("Please enter your choice of either Heads or Tails: ");
            full = scan.nextLine();
            flip = full.charAt(0);
        } finally {
            scan.close();
        }
        
        if (validFlip(sides, flip)) {
            if (coin == flip) {
                System.out.print("Congratulations " + name + ", you won. ");
            } else {
                System.out.print("I'm sorry " + name + ", you lost. ");
            }
            System.out.print("The coin landed on ");
            if (coin == 'h') {
                System.out.println("Heads.");
            } else {
                System.out.println("Tails.");
            }
        } else {
            System.out.println("I'm sorry " + name + ", but '" + full + "' is not a input.");
        }

    }
    
    /**
     * Checks whether or not an element is contained in the char array
     * 
     * @param sides array of valid choices
     * @param flip the user choice 
     * @return whether or not flip is in the array
     */
    private static boolean validFlip(final char[] sides, final char flip) {
        for (final char side : sides) {
            if (side == flip) {
                return true;
            }
        }
        // return false if flip is not in the array sides
        return false;
    }

}
