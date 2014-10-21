/****************************
 * File: FlipRace.java
 * 
 * Author: Winston Durand
 * Modified: Oct 20, 2014
 ***************************/
package coins;

/**
 * @author Winston Durand
 *
 */
public class FlipRace {
    /**
     * Flips coins for heads 3 times in a row
     * 
     * @param args
     */
    public static void main(String[] args) {
        final int GOAL = 3;
        int count1 = 0, count2 = 0;
        
        Coin coin1 = new Coin();
        Coin coin2 = new Coin();
        
        while (count1 < GOAL && count2 < GOAL) {
            coin1.flip();
            coin2.flip();
            
            System.out.printf("Coin 1: %s Coin 2: %s\n", coin1, coin2);
            
            if (coin1.isHeads()) {
                count1 ++;
            } else {
                count1 = 0;
            }
            if (coin2.isHeads()) {
                count2 ++;
            } else {
                count2 = 0;
            }
        }
        
        if (count1 < GOAL) {
            System.out.println("Coin 2 Wins!");
        } else if (count2 < GOAL) {
            System.out.println("Coin 1 Wins!");
        } else {
            System.out.println("It's a TIE!");
        }
    }
}
