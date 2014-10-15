/**
 * In class 2014-10-15
 */
package testingCode;

/**
 * @author Winston Durand
 *
 */
public class DivideSelf {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {12,73,104,-8,8};
        for (int n : nums) {
            System.out.println(n + "" + divideSelf(n));
        }

    }

    public static boolean divideSelf(int val) {
        String num = Integer.toString(val).replaceFirst("-", "");
        for (int i = 0; i < num.length(); i++) {
            int n = Character.getNumericValue(num.charAt(i));
            if (n == 0 || val % n != 0) {
                return false;
            }
        }
        return true;
    }

}
