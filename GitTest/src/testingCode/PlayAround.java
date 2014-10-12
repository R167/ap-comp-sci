/****************************
 * File: PlayAround.java
 * 
 * Author: Winston Durand
 * Modified: Oct 8, 2014
 ***************************/
package testingCode;

/**
 * @author wmd
 *
 */
public class PlayAround {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("helell".split("(?:l)").length);

        int count = 0;
        String str = "code co e  ";
        for (int i=0; i<str.length()-3; i++) {
            if (str.charAt(i) == 'c' && str.charAt(i+1) == 'o' && str.charAt(i+3) == 'e') {
                count ++;
                i += 3;
            }
        }

        System.out.println(count);

        int myVal = 2;
        String myChoice = "bye";

        if(myVal == 1) {
            if (myChoice.equals("hi")) {
                System.out.println ("John");
            } else if (myChoice.equals("bye")) {
                System.out.println ("Joe");
            } else if(myVal == 2) {
                if (myChoice.equals("hi")) {
                    System.out.println ("Jesse");
                } else if (myChoice.equals("bye")) {
                    System.out.println ("Jordan");
                }
            }
        }

    }

}
