/**************************************************
 * File: Lab3Circle.java
 * 
 * Computes the area and circumferences for circles of varying radii.
 * 
 * Author: Winston Durand
 * Modified: 2014-09-17
 ***************************************************/

package Lab3Package;

public class Lab3Circle {

	/**
	 * Prints off the radii, areas, and circumferences of
	 * different circles
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int radius = 10;
		final double PI = Math.PI; // yes, I know how to declare constants :)
		double area1 = PI * radius * radius;
		double circumference1 = PI * radius * 2;

		System.out.println("The area of a circle with radius " + radius
				+ " is " + area1);
		System.out.println("The circumference of a circle with radius "
				+ radius + " is " + circumference1);

		radius = 20;
		double area2 = PI * radius * radius;
		double circumference2 = PI * radius * 2;

		System.out.println("The area of a circle with radius " + radius + " is " + area2);
		System.out.println("The circumference of a circle with radius " + radius + " is " + circumference2);

		double areaDiff = area1 / area2;
		double circumferenceDiff = circumference1 / circumference2;

		// area is pi times radius squared so it makes sense (100/400 = 0.25)
		System.out.println("The result of area1 / area2 is " + areaDiff);
		// circumference is two pi times radius so it also make sense that
		// (10/20 = 0.5)
		System.out.println("The result of circumference1 / circumference2 is " + circumferenceDiff);

	}
}
