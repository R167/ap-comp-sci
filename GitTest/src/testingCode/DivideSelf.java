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
        int[] nums = {12,73,104,-8,8,0,11,01};
        System.out.println("Val\tString\tInt");
        for (int n : nums) {
            System.out.println(n + "\t" + divideSelfStr(n) + "\t" + divideSelfInt(n));
        }
    }

    /**
     * Does divide self using Strings
     * @param val input
     * @return whether divisible by all nums
     */
    public static boolean divideSelfStr(int val) {
        String num = Integer.toString(val).replaceFirst("-", "");
        for (int i = 0; i < num.length(); i++) {
            int n = Character.getNumericValue(num.charAt(i));
            if (n == 0 || val % n != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Does divide self with ints only
     * @param val
     * @return
     */
    public static boolean divideSelfInt(int val) {
        int runningValue = Math.abs(val);
        while (true) {
            int digit = runningValue % 10;
            runningValue /= 10;
            if (digit == 0 || val % digit != 0) {
                return false;
            } else if (runningValue == 0) {
                return true;
            }
        }
    }

}
