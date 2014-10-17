/**********************************
 * File: BenfordLaw.java
 * 
 * Author: Winston Durand
 * Modified: Oct 17, 2014
 **********************************/
package testingCode;

/**
 * @author Winston Durand
 *
 */
public class BenfordLaw {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] recur = new int[10];
        int total = 0;
        for (int i=0; i<10000; i++) {
            if (DivideSelf.divideSelfInt(i)) {
                recur[Character.getNumericValue(String.valueOf(i).charAt(0))] += 1;
                total++;
            }
        }
        
        for (int i=0; i<recur.length; i++) {
            System.out.println(i + " : " + recur[i] + "\t" + (100.0 * recur[i] / total) + "%");
        }

    }

}
