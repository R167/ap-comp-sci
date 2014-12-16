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

        int[] selection = copy(nums);
        int[] insertion = copy(nums);

        selectionSort(selection);
        ArrayIndeces.printArr(selection);

        insertionSort(insertion);
        ArrayIndeces.printArr(insertion);

    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[smallest]) smallest = j;
            }
            swap(nums, i, smallest);
        }

    }

    public static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int k = i; k > 0 && nums[k] < nums[k-1]; k--) {
                swap(nums, k, k - 1);
            }
        }
    }

    public static void swap(int[] nums, int i1, int i2) {
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }

    public static int[] copy(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i];
        }
        return ret;
    }

}
