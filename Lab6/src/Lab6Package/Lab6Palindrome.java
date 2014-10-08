/**********************************
 * File: Lab6Palindrome.java
 * 
 * Author: Winston Durand
 * Modified: Oct 5, 2014
 **********************************/
package Lab6Package;

import java.util.Scanner;

/**
 * Checks if words are palindromes
 * 
 * @author Winston Durand
 */
public class Lab6Palindrome {

    /**
     * Asks the user to enter a word. If the word is a palindrome (ignoring capitalization),
     * then let the user know. Otherwise say it isn't. If they enter quit, then quit.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = null;
        try {
            while (true) {
                System.out.print("Enter word to check if it’s a palindrome, or quit to quit: ");
                str = scan.nextLine();
                if (str.toLowerCase().equals("quit")) {
                    break;
                    // Use StringBuilder to reverse the string
                } else if (new StringBuilder(str.toLowerCase()).reverse().toString().equals(str.toLowerCase())) {
                    System.out.println("Congratulations, " + str + " is a palindrome. ");
                } else {
                    System.out.println(str + " is not a palindrome.");
                }
            }
            System.out.println("Thank you for using the palindrome checker.");
        } finally {
            scan.close();
        }
    }
}
