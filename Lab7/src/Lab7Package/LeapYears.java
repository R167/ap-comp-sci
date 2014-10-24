/**********************************
 * File: LeapYears.java
 * 
 * Author: Winston Durand
 * Modified: Oct 24, 2014
 **********************************/
package Lab7Package;

import java.util.Scanner;

/**
 * Checks if a given year is a leap year
 * 
 * @author Winston Durand
 */
public class LeapYears {

    /**
     * Asks the user to enter a year and lets them know whether or not it is a leap year.
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
                
        try {
            while (true) {
                try {
                    System.out.print("Enter a year to see if it is a leap year: ");
                    int year = scan.nextInt();
                    System.out.println(year + " is " + (isLeapYear(year) ? "" : "not ") + "a leap year"); // Ternary to choose text
                    break;
                } catch (java.util.InputMismatchException err) {
                    System.out.println("'" + scan.next() + "' is not a valid input.");
                } catch (Exception err) {
                    System.out.println(err.getMessage());
                }
            }
        } finally { 
            scan.close();
        }

    }

    /**
     * Accepts a year and determines whether or not it is a leap year
     * according to the Gregorian calendar.
     * 
     * @param year year greater than 1582
     * @return whether or not year is a leap year
     * @throws Exception year is invalid
     */
    public static boolean isLeapYear(int year) throws Exception {
        if (year < 1582) throw new Exception("Years before 1582 are invalid!");

        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
