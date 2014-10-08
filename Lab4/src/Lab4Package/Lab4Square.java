/**********************************
 * File: Lab4Square.java
 * 
 * Author: Winston Durand
 * Modified: Sep 21, 2014
 **********************************/
package Lab4Package;

import java.util.Scanner;
import java.math.BigInteger;

/**
 * @author Winston Durand
 */
public class Lab4Square {

	/**
	 * Asks the user for their name and favorite number
	 * and then prints out the square. Utilizes error catching and
	 * to give the user a nice message should something go wrong.
	 * Also uses <code>BigInteger</code> so that really big numbers can be entered
	 * and properly computed.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = null;
		BigInteger favoriteNum = null;
		try {
			System.out.print("Please enter your name: ");
			name = scanner.nextLine();
			
			while (favoriteNum == null) {
				System.out.print("Please enter your favorite number: ");		
				try {
					favoriteNum = scanner.nextBigInteger();
				} catch(java.util.InputMismatchException e) {
					System.out.println("Your favorite number needs to be an integer!");
					scanner.next();
				}
			}
		} finally {
			scanner.close(); // Make sure that the scanner is always closed
		}
		
		System.out.println("\nHi " + name + ", the square of your favorite number is " + favoriteNum.pow(2));

	}

}

