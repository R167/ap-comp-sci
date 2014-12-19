/****************************
 * File: SortingArrayLists.java
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
public class SortingArrayLists extends ArrayMod {
    public ArrayList<Integer> selectionSortAscending(ArrayList<Integer> myArray) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> copy = (ArrayList<Integer>) myArray.clone();
        for (int i = 0; i < copy.size(); i++) {
            int smallest = i;
            for (int j = i + 1; j < copy.size(); j++) {
                if (copy.get(j) < copy.get(smallest)) smallest = j;
            }
            swap(copy, i, smallest);
        }
        return copy;
    }
    
    public ArrayList<Integer> selectionSortDescending(ArrayList<Integer> myArray) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> copy = (ArrayList<Integer>) myArray.clone();
        for (int i = 0; i < copy.size(); i++) {
            int biggest = i;
            for (int j = i + 1; j < copy.size(); j++) {
                if (copy.get(j) > copy.get(biggest)) biggest = j;
            }
            swap(copy, i, biggest);
        }
        return copy;
    }
    
    public ArrayList<Integer> insertionSortAscending(ArrayList<Integer> myArray) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> copy = (ArrayList<Integer>) myArray.clone();
        for (int index = 1; index < copy.size(); index++) {
            for (int sec = index; sec > 0 && copy.get(sec) < copy.get(sec - 1); sec--) {
                swap(copy, sec, sec - 1);
            }
        }
        return copy;
    }
    
    public ArrayList<Integer> insertionSortDescending(ArrayList<Integer> myArray) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> copy = (ArrayList<Integer>) myArray.clone();
        for (int index = 1; index < copy.size(); index++) {
            for (int sec = index; sec > 0 && copy.get(sec) > copy.get(sec - 1); sec--) {
                swap(copy, sec, sec - 1);
            }
        }
        return copy;
    }
}
