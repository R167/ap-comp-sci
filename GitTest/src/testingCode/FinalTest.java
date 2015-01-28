/****************************
 * File: FinalTest.java
 * 
 * Author: Winston Durand
 * Modified: Jan 27, 2015
 ***************************/
package testingCode;

/**
 * @author Winston Durand
 * 
 */
public class FinalTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(apcsReplaceAll("gGg gg", "g", "ab"));

    }
    
    public static String apcsReplaceAll(String str, String oldStr, String newStr) {
        String run = "";
        int last = 0;
        for (int i = 0; i <= str.length() - oldStr.length(); i++) {
            if (str.substring(i, i + oldStr.length()).equals(oldStr)) {
                run += str.substring(last, i);
                run += newStr;
                last = i + oldStr.length();
                i = last - 1;
            }
        }
        run += str.substring(last, str.length());
        return run;
    }

}
