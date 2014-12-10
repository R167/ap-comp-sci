/****************************
 * File: TwoDArray.java
 * 
 * Author: Winston Durand
 * Modified: Dec 9, 2014
 ***************************/
package twodarray;

/**
 * @author Winston Durand
 * 
 */
public class TwoDArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] numbers = new int[10][10];
        
        for (int i = 0; i < 100; i++) {
            numbers[i / 10][i % 10] = i + 1;
        }
        
        for (int[] n : numbers) {
            for (int c: n) System.out.printf("%3d ", c);
            System.out.println();
        }

    }

}
