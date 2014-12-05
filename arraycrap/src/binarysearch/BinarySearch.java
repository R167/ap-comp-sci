/**********************************
 * File: BinarySearch.java
 * 
 * Author: Winston Durand
 * Modified: Dec 4, 2014
 **********************************/
package binarysearch;

/**
 * @author Winston Durand
 */
public class BinarySearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] search = {1, 3, 5, 9, 12, 15, 18, 24};
        int[] vals = {-3, 9, 12, 24, 52};
        
        System.out.println("Array to search");
        
        for (int v : search) {
            System.out.print(v + " ");
        }
        
        System.out.println();
        
        for (int v : vals) {
            System.out.println("\nSearching for " + v);
            binarySearch(search, v);
        }
    }
    
    public static int binarySearch(int[] arr, int val) {
        int min = 0;
        int max = arr.length - 1;        
        while (min <= max) {
            int pivot = min + (max - min) / 2;
            System.out.printf("Max: %d | Min: %d | Pivot: %d\n", max, min, pivot);
            if (val < arr[pivot]) {
                max = pivot - 1;
                System.out.printf("%d is less than %d. Max is now %d\n\n", val, arr[pivot], max);
            } else if (val > arr[pivot]) {
                min = pivot + 1;
                System.out.printf("%d is less than %d. Min is now %d\n\n", val, arr[pivot], min);
            } else {
                System.out.printf("%d is at index %d\n\n", val, pivot);
                return pivot;
            }
        }
        System.out.println("Min is no longer less than or equal to max. Exit while loop.");
        System.out.printf("%d is not in the array\n\n", val);
        return -1;
    }
}
