/****************************
 * File: ArrayMod.java
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
public abstract class ArrayMod {
    public void swap(int[] ints, int index1, int index2) {
        int tmp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = tmp;
    }
    
    public void swap(char[] ints, int index1, int index2) {
        char tmp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = tmp;
    }
    
    public void swap(long[] ints, int index1, int index2) {
        long tmp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = tmp;
    }
    
    public void swap(double[] ints, int index1, int index2) {
        double tmp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = tmp;
    }
    
    public <T> void swap(ArrayList<T> list, int index1, int index2) {
        T tmp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp);
    }
    
    public void swap(String[] ints, int index1, int index2) {
        String tmp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = tmp;
    }
}
