/****************************
 * File: Change.java
 * 
 * Author: Winston Durand
 * Modified: Oct 9, 2014
 ***************************/
package working;

import java.util.Scanner;

/**
 * @author Winston Durand
 *
 */
public class Change {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            int cents = scan.nextInt();
            
            System.out.print(cents % 25);
        } finally {
            scan.close();
        }

    }

}
