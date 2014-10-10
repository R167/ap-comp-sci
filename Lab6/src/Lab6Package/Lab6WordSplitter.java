/**********************************
 * File: Lab6WordSplitter.java
 * 
 * Author: Winston Durand
 * Modified: Oct 5, 2014
 **********************************/
package Lab6Package;

import java.util.Scanner;

/**
 * Splits a user entered word into each char and prints each on a newline
 * 
 * @author Winston Durand
 */
public class Lab6WordSplitter {

    /**
     * Asks the user to enter a word. Splits the user's input into each character
     * and prints each out on its own line
     * <br><br>
     * Precondition: User enters a word<br>
     * Postcondition: Prints out each character of the user's word
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = null;
        
        System.out.print("Please enter a word: ");
        try {
            word = scan.nextLine();
        } finally {
            scan.close();
        }
        
        System.out.println("Your split word is:");
        for (char c: word.toCharArray()) {
            System.out.println(c);
        }
        // The Ruby code for this is much shorter
        // print "Please enter a word: ";STDIN.gets.chomp.tap{puts "Your split word is:"}.each_char{|c|puts c}
        
    }

}
