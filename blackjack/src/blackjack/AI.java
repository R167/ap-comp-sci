/****************************
 * File: AI.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 ***************************/
package blackjack;

/**
 * @author Winston Durand
 * 
 */
public class AI extends Player {
    final public static int HIT = 17;
    
    public AI(Deck deck) {
        super(deck);
    }
    
    public boolean run(int scoreToBeat) {
        while (getHardTotal() < HIT) {
            if (getTotal() <= scoreToBeat) {
                hit();
            } else {
                break;
            }
        }
        return !isBusted() && getTotal() > scoreToBeat;
    }
}
