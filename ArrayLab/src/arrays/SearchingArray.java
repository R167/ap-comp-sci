/****************************
 * File: SearchingArray.java
 * 
 * Author: Winston Durand
 * Modified: Dec 18, 2014
 ***************************/
package arrays;

/**
 * @author Winston Durand
 * 
 */
public class SearchingArray extends ArrayMod {
    
    /**
     * If the array has the element in it, it returns the index or -1 if the element is not
     * in the array.
     * 
     * @param myArray array to search
     * @param itemToFind item to look for
     * @return index of itemToFind or -1
     */
    public int linearSearch(String[] myArray, String itemToFind) {
        for (int i = 0; i < myArray.length; i++) {
            if (itemToFind.equals(myArray[i])) {
                return i;
            }
        }
        return -1;
    }
    
    public int binarySearch(String[] myArray, String itemToFind) {
        int min = 0;
        int max = myArray.length - 1;
        while (min <= max) {
            int pivot = min + (max - min) / 2;
            int compared = itemToFind.compareTo(myArray[pivot]);
            if (compared < 0) {
                max = pivot - 1;
            } else if (compared > 0) {
                min = pivot + 1;
            } else {
                return pivot;
            }
        }
        return -1;
    }
}
