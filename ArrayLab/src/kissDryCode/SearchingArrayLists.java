/****************************
 * File: SearchingArrayLists.java
 * 
 * Author: Winston Durand
 * Modified: Dec 18, 2014
 ***************************/
package kissDryCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Winston Durand
 * 
 */
public class SearchingArrayLists extends ArrayMod {
    /**
     * If the list has the element in it, it returns the index or -1 if the element is not
     * in the list.
     * 
     * @param myArray list to search
     * @param itemToFind item to look for
     * @return index of itemToFind or -1
     */
    public int linearSearch(ArrayList<String> myArray, String itemToFind)  {
        for (int i = 0; i < myArray.size(); i++) {
            if (itemToFind.equals(myArray.get(i))) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * If the list has the element in it, it returns the index or -1 if the element is not
     * in the list.
     * 
     * @param myArray list to search
     * @param itemToFind item to look for
     * @return index of itemToFind or -1
     */
    public int binarySearch(ArrayList<String> myArray, String itemToFind) {
        int index = Collections.binarySearch(myArray, itemToFind);
        return index < 0 ? -1 : index;
    }
}
