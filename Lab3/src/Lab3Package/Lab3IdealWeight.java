/*********************************************
 * File: Lab3IdealWeight.java
 * 
 * Finds the ideal weight of a person based off of their height. Prints out both
 * male and female weight ranges.
 * 
 * Author: Winston Durand
 * Modified: 2014-09-17
 **********************************************/

package Lab3Package;

import java.util.Scanner;

public class Lab3IdealWeight {

	/**
	 * Asks the user for their height and then outputs
	 * an ideal weight range for them to be in
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Declare and init the male/female base/mult constants
		final int MALEBASE = 106, FEMALEBASE = 100;
		final int MALEMULT = 6, FEMALEMULT = 5;

		// Let the user know the format I expect
		System.out.println("You will be asked for your height in inches and feet."
						+ "\nPlease respond as if you were typing your height in form 4 feet 7 inches."
						+ "\n(Please enter each part seperately)\n");
		// Prompt for height in feet
		System.out.print("Please input how many feet tall you are: ");

		// Store as int because feet should be one number
		// replaceAll() removes non 0-9 characters
		int heightFeet = Integer.parseInt(in.nextLine().replaceAll("[^0-9]", ""));

		// Prompt for height in inches
		System.out.print("Please input how many extra inches you are: ");

		// save as double because you could be 5'9.5"
		// replaceAll() removes non 0-9 and decimal characters
		// the second replaceAll() removes all but the first decimal
		double heightInches = Double.parseDouble(in.nextLine()
				.replaceAll("[^0-9\\.]", "").replaceAll("\\.?(.*?\\.)*", ""));

		// Make sure we close the input stream
		in.close();

		// Compute total inches
		double totalInches = heightFeet * 12 + heightInches;

		System.out.println("\nYou are " + totalInches + " inches tall.\n");

		// Computes the ideal weights
		double maleIdeal = MALEBASE + MALEMULT * (totalInches - 60);
		double femaleIdeal = FEMALEBASE + FEMALEMULT * (totalInches - 60);

		System.out.println("If you are a male, your ideal weight is between "
				+ weightRange(maleIdeal));
		System.out.println("If you are a female, your ideal weight is between "
				+ weightRange(femaleIdeal));

	}

	/**
	 * Calculates the weight range of <code>weight</code> with 15% variance.
	 * 
	 * @param weight
	 * @return a string of form
	 *         <code>weight - 15% lbs and weight + 15% lbs</code>
	 */
	private static String weightRange(double weight) {
		// multiplying by 0.15 is equivalent to getting 15 percent
		double variance = weight * 0.15;

		return (weight - variance) + " lbs and " + (weight + variance) + " lbs";
	}

}
