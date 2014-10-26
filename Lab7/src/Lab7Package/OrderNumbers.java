/****************************
 * File: OrderNumbers.java
 * 
 * Author: Winston Durand
 * Modified: Oct 25, 2014
 ***************************/
package Lab7Package;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Asks the user to enter numbers and orders them from least to greatest
 * 
 * @author Winston Durand
 */
public class OrderNumbers {

    /**
     * Asks the user to enter a list of numbers and then sorts said numbers
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> ints = new ArrayList<Integer>(4);

        try {
            while (true) {
                try {

                    System.out.print("Input at least 3 numbers seperated by spaces: ");
                    String[] strs = scan.nextLine().split("\\s+");
                    if (strs.length < 3) throw new InvalidValueException("Too few entries. At least 3 required");
                    for (String str : strs) {
                        ints.add(new Scanner(str).nextInt());
                    }
                    Collections.sort(ints);
                    for (int i : ints) {
                        System.out.println(i);
                    }
                    break;
                } catch (InputMismatchException err) {
                    System.out.println("Unable to parse input to integers; please try again!");
                } catch (InvalidValueException err) {
                    System.out.println(err.getMessage());
                }
            }
        } finally {
            scan.close();
        }

    }

}
