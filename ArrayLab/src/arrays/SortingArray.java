/****************************
 * File: SortingArray.java
 * 
 * Author: Winston Durand
 * Modified: Dec 18, 2014
 ***************************/
package arrays;

import java.util.Arrays;

/**
 * @author Winston Durand
 * 
 */
public class SortingArray extends ArrayMod {
    public int[] selectionSortAscending(int[] myArray) {
        int[] copy = Arrays.copyOf(myArray, myArray.length);
        for (int i = 0; i < copy.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[smallest]) smallest = j;
            }
            swap(copy, i, smallest);
        }
        return copy;
    }
    
    public int[] selectionSortDescending(int[] myArray) {
        int[] copy = Arrays.copyOf(myArray, myArray.length);
        for (int i = 0; i < copy.length; i++) {
            int biggest = i;
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] > copy[biggest]) biggest = j;
            }
            swap(copy, i, biggest);
        }
        return copy;
    }
    
    public int[] insertionSortAscending(int[] myArray) {
        int[] nums = Arrays.copyOf(myArray, myArray.length);
        for (int i = 1; i < nums.length; i++) {
            for (int k = i; k > 0 && nums[k] < nums[k-1]; k--) {
                swap(nums, k, k - 1);
            }
        }
        return nums;
    }
    
    public int[] insertionSortDescending(int[] myArray) {
        int[] nums = Arrays.copyOf(myArray, myArray.length);
        for (int i = 1; i < nums.length; i++) {
            for (int k = i; k > 0 && nums[k] > nums[k-1]; k--) {
                swap(nums, k, k - 1);
            }
        }
        return nums;
    }
}
