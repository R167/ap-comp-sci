/**********************************
 * File: Lab6Factors.java
 * 
 * Author: Winston Durand
 * Modified: Oct 5, 2014
 **********************************/
package Lab6Package;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Prints out the factors of a number
 * 
 * @author Winston Durand
 */
public class Lab6Factors {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        List<Integer> factors = new ArrayList<Integer>();
        
        try {
            boolean success = false;
            while (!success) {
                try {
                    System.out.print("Please enter a number to see its factors: ");
                    number = scan.nextInt();
                    if (number > 1) {
                        success = true;
                    } else {
                        System.out.println("Your number needs to be positive and greater than 1");
                    }
                } catch (java.util.InputMismatchException error) {
                    System.out.println("ERROR: '" + scan.next() + "' is not an integer");
                }
            }
           
        } finally {
            scan.close();
        }
        int working = number;
        for (int i = 2; i < number; i++) {
            while (working % i == 0) {
                working = working / i;
                factors.add(i);
            }
        }
        
        if (factors.isEmpty()) {
            System.out.println(number + " is prime");
        } else {
            System.out.print("The factors for " + number + " are: ");
            StringBuilder out = new StringBuilder();
            out.append(factors.get(0));
            for (int i = 1; i < factors.size(); i++) {
                out.append(" * ").append(factors.get(i));
            }
            System.out.println(out.toString());
        }

    }

}
