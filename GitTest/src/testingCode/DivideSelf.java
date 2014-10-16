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
        System.out.println("Val\tString\tInt");
        for (int n : nums) {
            System.out.println(n + "\t" + divideSelfStr(n) + "\t" + divideSelfInt(n));
        }

    }

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
    
    public static boolean divideSelfInt(int val) {
        int run = Math.abs(val);
        while (true) {
          int digit = run % 10;
          run /= 10;
          if (digit == 0 || val % digit != 0) {
            return false;
          } else if (run == 0) {
            return true;
          }
        }
      }

}
