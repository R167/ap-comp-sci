/**********************************
 * File: Lab5GradeAssigner.java
 * 
 * Author: Winston Durand
 * Modified: Sep 24, 2014
 **********************************/
package Lab5Package;

import java.util.Scanner;

/**
 * Translates a grade percentage to a letter grade
 * 
 * @author Winston Durand
 */
public class Lab5GradeAssigner {

    /**
     * Asks the user to input the grade that they got. Checks to see if the number
     * entered is within the applicable range of 0-100 inclusive. It then prints
     * out the letter that the user's grade corresponds to.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter the percent you got on the test: ");
        int grade;
        try {
            grade = scan.nextInt();
        } finally {
            scan.close();
        }
        
        // Check whether the grade is in the range
        if (0 <= grade && grade <= 100) {
            System.out.print("Your letter grade is ");

            if (grade >= 90) {
                System.out.println("an A");
            } else if (90 > grade && grade >= 80) {
                System.out.println("a B");
            } else if (80 > grade && grade >= 70) {
                System.out.println("a C");
            } else if (70 > grade && grade >= 60) {
                System.out.println("a D");
            } else if (grade < 60) {
                System.out.println("an F");
            }
        } else {
            System.out.println("Your percentage was not in the acceptable range of 0-100");
        }

    }

}
