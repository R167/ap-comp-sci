/**********************************
 * File: LabThings.java
 * 
 * Author: Winston Durand
 * Modified: Dec 3, 2014
 **********************************/
package arraycrap;

import java.util.Scanner;

/**
 * @author Winston Durand
 */
public class LabThings {

    /**
     * @param args
     */
    public static void main(String[] args) {        
        int[] vals;
        Scanner scan = new Scanner(System.in);
        try {
            while (true) {
                try {
                    System.out.print("How long would you like the array to be? ");
                    int count = scan.nextInt();
                    vals = new int[count];
                    for (int i = 0; i < count; i++) {
                        while (true) {
                            try {
                                System.out.printf("Number %d of %d: ", i + 1, count);
                                vals[i] = scan.nextInt();
                                break;
                            } catch(java.util.InputMismatchException error) {
                                System.out.println(scan.next() + " is not a valid number.");
                            }
                        }
                    }
                    break;
                } catch(java.util.InputMismatchException error) {
                    System.out.println(scan.next() + " is invalid input. Please try again.");
                } catch(NegativeArraySizeException error) {
                    System.out.println("Array size must be positive.");
                }
            } 
        } finally {
            scan.close();
        }

        System.out.println("Your normal array:");
        ArrayIndeces.printArr(vals);
        reverse(vals);
        System.out.println("Your reversed entries are:");
        ArrayIndeces.printArr(vals);

    }

    private static void reverse(int[] vals) {
        for (int i = 0; i < vals.length / 2; i++) {
            int tmp = vals[i];
            int swap = vals.length - i - 1;
            vals[i] = vals[swap];
            vals[swap] = tmp;
        }

    }

}
