/****************************
 * File: SearchingArrayLists.java
 * 
 * Author: Winston Durand
 * Modified: Dec 18, 2014
 ***************************/
package arrays;

import java.util.ArrayList;

/**
 * @author Winston Durand
 * 
 */
public class SearchingArrayLists extends ArrayMod {
    public int linearSearch(ArrayList<String> myArray, String itemToFind)  {
        for (int i = 0; i < myArray.size(); i++) {
            if (itemToFind.equals(myArray.get(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public int binarySearch(ArrayList<String> myArray, String itemToFind) {
        int min = 0;
        int max = myArray.size() - 1;
        while (min <= max) {
            int pivot = min + (max - min) / 2;
            int compared = itemToFind.compareTo(myArray.get(pivot));
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
