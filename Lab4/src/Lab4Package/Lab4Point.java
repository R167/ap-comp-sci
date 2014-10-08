/**********************************
 * File: Lab4Point.java
 * 
 * Author: Winston Durand
 * Modified: Sep 21, 2014
 **********************************/
package Lab4Package;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Winston Durand
 */
public class Lab4Point {

	/**
	 * Prompts the user for an upper and lower bound for random point
	 * coordinates. Prints out the coordinates of two points, distance between
	 * them and the slope. Slope is NaN if the same point is generated and
	 * either positive or negative infinity if the x-coordinate is the same.
	 * Throws an exception if the minimum is greater than the maximum. Points
	 * are generated range inclusive since the assignment did not specify.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Declare points for scope
		Point[] points = null;
		
		// Ensure that the scanner is always closed
		try {
			points = Point.fromScanner(sc, 2);
		} finally {
			sc.close();
		}
		
		// Print out the coords of all points in points
		for (int i=0; i<points.length; i++) {
			// Format to Point i: (x,y)
			System.out.format("Point %d:\t%s\n", i + 1, points[i]);
		}
		System.out.println("Distance:\t" + Point.distance(points[0], points[1]));
		System.out.println("Slope:\t\t" + Point.slope(points[0], points[1]));

	}

}

/**
 * A point on the Cartesian plane with x y coordinates
 * @author Winston Durand
 */
class Point {
	// The x y coordinate values
	public int x, y;
	// Create a private generator for the class
	private static Random generator = new Random();
	
	/**
	 * Creates a Point between the given min and max values inclusive
	 * 
	 * @param max
	 * @param min
	 * @throws Error when min is greater than max
	 */
	public Point(int min, int max) throws Error {
		// Throw an exception if min > max
		if (min > max) {
			throw new Error("Lower bound cannot be greater than upper bound!");
		}
		x = randCoord(min, max);
		y = randCoord(min, max);
	}
	
	/**
	 * Creates count number of points getting the upper and lower bounds
	 * 
	 * @param sc <code>Scanner</code> object to get input from
	 * @param count number of points to generate
	 * @return array of random <code>Point</code>s
	 */
	public static Point[] fromScanner(Scanner sc, int count) {
		System.out.print("Please enter a lower limit: ");
		int min = sc.nextInt();
		
		System.out.print("Please enter an upper limit: ");
		int max = sc.nextInt();
		
		// Create count number of points and return
		Point[] points = new Point[count];
		for (int i=0; i<count; i++) {
			points[i] = new Point(min, max);
		}
		return points;
	}
	
	/**
	 * Returns the the coordinate form of a point
	 * @return coordinate form of point
	 */
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}
	
	/**
	 * Returns a random coordinate
	 * 
	 * @param min minimum value
	 * @param max maximum value
	 * @return value between min and max inclusive
	 */
	private static int randCoord(int min, int max) {
		return generator.nextInt(max - min + 1) + min;
	}
	
	/**
	 * Computes distance between points.
	 * 
	 * @param point1 first point
	 * @param point2 second point
	 * @return distance between points
	 */
	public static double distance(Point point1, Point point2) {
		return Math.sqrt(Math.pow((point1.x - point2.x), 2) + Math.pow((point1.y - point2.y), 2));
	}
	
	/**
	 * Computes slope between points.
	 * 
	 * @param point1 first point
	 * @param point2 second point
	 * @return slope between points
	 */
	public static double slope(Point point1, Point point2) {
		return (double) (point2.y - point1.y) / (point2.x - point1.x);
	}
}

