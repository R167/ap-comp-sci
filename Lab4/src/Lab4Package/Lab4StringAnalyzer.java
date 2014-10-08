/**********************************
 * File: Lab4StringAnalyzer.java
 * 
 * Author: Winston Durand
 * Modified: Sep 21, 2014
 **********************************/
package Lab4Package;

import java.util.Scanner;

/**
 * @author Winston Durand
 */
public class Lab4StringAnalyzer {

	/**
	 * Prompts the user for two words and then prints out the length of
	 * each word, the first character of each, the length of the strings
	 * combined, and the combined string.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String word1, word2;
		
		// Ensure that scanner is always properly closed
		try {
			System.out.print("Please enter a word: ");
			word1 = scanner.nextLine();
			System.out.print("Please enter another word: ");
			word2 = scanner.nextLine();
		} finally {
			scanner.close();
		}
		
		// Create the combined word
		String combined = word1 + word2;
		
		// Print length of each word
		System.out.println("\nThe the first word is " + word1.length() + " characters long"
				+ " and the the second word is " + word2.length() + " characters long");
		
		// Print the first character of each word
		System.out.println("The first character of the first word is '" + word1.charAt(0) + "'"
				+ " and the first character of the second word is '" + word2.charAt(0) + "'");
		
		// Print the combined length
		System.out.println("The length of the combined strings is " + combined.length() + " characters");
		
		// Print the combined string
		System.out.println("The combined string is '" + combined + "'");

	}

}

