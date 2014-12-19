/****************************
 * File: SearchingArray.java
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
    
    /**
     * If the array has the element in it, it returns the index or -1 if the element is not
     * in the array.
     * 
     * @param myArray array to search
     * @param itemToFind item to look for
     * @return index of itemToFind or -1
     */
    public int binarySearch(String[] myArray, String itemToFind) {
        int index = Arrays.binarySearch(myArray, itemToFind);
        return index < 0 ? -1 : index;
    }
}
