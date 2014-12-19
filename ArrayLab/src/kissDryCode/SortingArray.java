/****************************
 * File: SortingArray.java
 * 
 * Author: Winston Durand
 * Modified: Dec 18, 2014
 ***************************/
package kissDryCode;

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
        int[] copy = selectionSortAscending(myArray);
        reverse(copy);
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
        int[] copy = insertionSortAscending(myArray);
        reverse(copy);
        return copy;
    }
    
    public int[] sort(int[] myArray) {
        int[] copy = Arrays.copyOf(myArray, myArray.length);
        Arrays.sort(copy);
        return copy;
    }
}
