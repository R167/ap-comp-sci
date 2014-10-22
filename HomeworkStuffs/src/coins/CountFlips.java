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

}
