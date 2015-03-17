/****************************
 * File: RiemannSumsDriver.java
 * 
 * Author: Winston Durand
 * Modified: Mar 16, 2015
 ***************************/
package riemannsums;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @author Winston Durand
 * 
 */
public class RiemannSumsDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            do {
                System.out.println("Enter a Riemann Sum to solve");
                System.out.print("Expression in terms of x: ");
                String expression = scan.nextLine();

                double lower = getDouble(scan, "Lower bounds");
                double upper = getDouble(scan, "Upper bounds");
                int count = getInt(scan, "Number of Subsections");
                scan.nextLine();
                SolveMethod select = getSolveMethod(scan);

                System.out.println(new RiemannSum(expression, lower, upper, count, select).solve());
                
                System.out.print("Continue (y/n)? ");
            } while (scan.nextLine().toLowerCase().charAt(0) == 'y');
        }
    }

    public static double getDouble(Scanner scan, String prompt) {
        double ret;
        while (true) {
            try {
                System.out.print(prompt + ": ");
                ret = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println(scan.next() + " is not a valid number!");
            }
        }
        return ret;
    }

    public static SolveMethod getSolveMethod(Scanner scan) {
        while (true) {
            System.out.print("Choose Right, Left, Middle, or Trapazoid: ");
            switch (scan.nextLine().toLowerCase().charAt(0)) {
            case 'r':
                return SolveMethod.RIGHT;
            case 'l':
                return SolveMethod.LEFT;
            case 'm':
                return SolveMethod.MIDDLE;
            case 't':
                return SolveMethod.TRAPAZOID;
            default:
                System.out.println("No such option! Try again.");
            }
        }
    }

    public static int getInt(Scanner scan, String prompt) {
        while (true) {
            int count = 0;
            try {
                System.out.print(prompt + ": ");
                count = scan.nextInt();
                if (count < 1)
                    throw new NumberFormatException();
                return count;
            } catch (InputMismatchException e) {
                System.out.println(scan.next() + " is not a valid number!");
            } catch (NumberFormatException e) {
                System.out.println(count + " is too small!");
            }
        }
    }

}
