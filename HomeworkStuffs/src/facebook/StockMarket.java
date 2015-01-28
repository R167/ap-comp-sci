/****************************
 * File: StockMarket.java
 * 
 * Author: Winston Durand
 * Modified: Jan 7, 2015
 ***************************/
package facebook;

import java.util.Random;

/**
 * @author Winston Durand
 * 
 */
public class StockMarket { 
    public static void main(String[] args) {
        Random prng = new Random();
        for (int i = 0; i < 5; i++) {
            double[] prices = new double[5];
            for (int j = 0; j < prices.length; j++) {
                prices[j] = prng.nextInt(50) + 1;
                System.out.print(prices[j]);
                System.out.print(' ');
            }
            
            System.out.println();
            
            System.out.println(maxProfitJor(prices));
            System.out.println(maxProfit(prices));
        }
    }
    
    public static double maxProfitJor(double[] prices) {
        double percentOriginal = 1;
        double lowestCurrent = prices[0];
        double highestCurrent = prices[0];
        for(int i=0; i < prices.length; i++) {
            if (prices[i] > highestCurrent && i < prices.length - 1) {
                highestCurrent = prices[i];
                continue;
            }

            percentOriginal = percentOriginal * (highestCurrent / lowestCurrent);
            if (prices[i] < lowestCurrent)
                lowestCurrent = prices[i];
            highestCurrent = prices[i];
        }
        if (prices[prices.length-1] > prices[prices.length-2]) {
            percentOriginal = percentOriginal * ((double)prices[prices.length-1] / (double)prices[prices.length-2]);
        }
        return percentOriginal;
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
