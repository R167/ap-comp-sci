/**********************************
 * File: Facebook.java
 * 
 * Author: Winston Durand
 * Modified: Jan 8, 2015
 **********************************/
package working;

import ja

/**
 * @author Winston Durand
 */
public class Facebook {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public static double maxProfit(double[] prices) {
        double profit = 0;
        for (int min = 0; min < prices.length - 1; min++) {
            for (int max = min; max < prices.length; max++) {
                if (prices[max] - prices[min] > profit) {
                    profit = prices[max] - prices[min];
                }
            }
        }
        return profit;
    }

}
