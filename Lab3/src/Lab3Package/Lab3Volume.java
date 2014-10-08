/**********************************************************
 * File: Lab3Volume.java
 * 
 * Computes the volume of a room demonstrating conversion of inches to cubic
 * feet.
 * 
 * Author: Winston Durand
 * Modified: 2014-09-17
 **********************************************************/

package Lab3Package;

public class Lab3Volume {

	/**
	 * Prints out the volume of a room that was defined in inches
	 * in feet
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String side1Inches = "5";
		String side2Inches = "10";
		String side3Inches = "15";

		prettyLength(side1Inches, "side1Inches");
		prettyLength(side2Inches, "side2Inches");
		prettyLength(side3Inches, "side3Inches");

		double side1Feet = inchesToFeet(side1Inches);
		double side2Feet = inchesToFeet(side2Inches);
		double side3Feet = inchesToFeet(side3Inches);

		System.out.println("");

		// prints the length of each side
		prettyLength(side1Feet, "side1Feet");
		prettyLength(side2Feet, "side2Feet");
		prettyLength(side3Feet, "side3Feet");

		// used double so as to not lose precision since everything else is a
		// double at the is point
		double volume = side1Feet * side2Feet * side3Feet;

		System.out.println("\nThe volume of the room is " + volume + " cubic feet.");

	}

	/**
	 * Prints out a formatted view of the side-inches variables.
	 * 
	 * @param size
	 *            the value of the variable to print
	 * @param varName
	 *            name of the variable
	 */
	private static void prettyLength(String size, String varName) {
		System.out.println("The length of '" + varName + "' is " + size
				+ " inches.");
	}

	/**
	 * Prints out a formatted view of the side-feet variables. It converts the
	 * double to a string and calls the <code>prettyLength()</code> method
	 * 
	 * @param size
	 *            the value of the variable to print
	 * @param varName
	 *            name of the variable
	 */
	private static void prettyLength(double size, String varName) {
		prettyLength(Double.toString(size), varName);
	}

	/**
	 * Converts string representations of inches to a double representation of
	 * feet. Uses feet so as to not lose precision in the conversion.
	 * 
	 * @param inches
	 * @return double representation of of <code>inches</code> converted to feet
	 */
	private static double inchesToFeet(String inches) {
		return Double.parseDouble(inches) / 12.0;
	}

}
