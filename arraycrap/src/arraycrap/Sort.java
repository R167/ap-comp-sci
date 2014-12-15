/**********************************
 * File: SelectionSort.java
 * 
 * Author: Winston Durand
 * Modified: Dec 15, 2014
 **********************************/
package arraycrap;

/**
 * @author Winston Durand
 */
public class Sort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {7,0,-6,4};
        
        selectionSort(nums);
        
        ArrayIndeces.printArr(nums);

    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int biggest = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[biggest]) biggest = j;
            }
            swap(nums, i, biggest);
        }
        
    }
    
    public static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

}
