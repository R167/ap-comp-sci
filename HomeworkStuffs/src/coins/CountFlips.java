/**********************************
 * File: CountFlips.java
 * 
 * Author: Winston Durand
 * Modified: Oct 22, 2014
 **********************************/
package coins;

/**
 * @author Winston Durand
 *
 */
public class CountFlips {
    public final static int NUM_FLIPS = 1000;

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Fair coin:");
        fair();
        
        System.out.println("75% heads weighted:");
        weighted(75);
    }
    
    public static void fair() {
        int heads = 0, tails = 0;
        
        Coin myCoin = new Coin();
        
        
        for (int i = 0; i < NUM_FLIPS; i++) {
            myCoin.flip();
            
            if (myCoin.isHeads()) {
                heads++;
            } else {
                tails++;
            }
        }
        
        System.out.println("The number of flips: " + NUM_FLIPS);
        System.out.println("The number of heads: " + heads);
        System.out.println("The number of tails: " + tails);
    }
    
    public static void weighted(int percent) {
        int heads = 0, tails = 0;
        
        Coin myCoin = null;
        
        try {
            myCoin = new WeightedCoin(percent);
        } catch (Exception err) {
            System.exit(1);
        }
        
        for (int i = 0; i < NUM_FLIPS; i++) {
            myCoin.flip();
            
            if (myCoin.isHeads()) {
                heads++;
            } else {
                tails++;
            }
        }
        
        System.out.println("The number of flips: " + NUM_FLIPS);
        System.out.println("The number of heads: " + heads);
        System.out.println("The number of tails: " + tails);
    }

}
