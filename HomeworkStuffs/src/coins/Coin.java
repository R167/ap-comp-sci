/****************************
 * File: Coin.java
 * 
 * Author: Winston Durand
 * Modified: Oct 20, 2014
 ***************************/
package coins;

/**
 * Represents a Coin with heads and tails
 * 
 * @author Winston Durand
 */
public class Coin {
    private static final int HEADS = 0;
    
    protected int face = 0;
    
    public Coin() {
        flip();
    }
    
    public void flip() {
        face = (int) (Math.random() * 2);
    }
    
    public boolean isHeads() {
        return face == HEADS;
    }
    
    public boolean isTails() {
        return !isHeads();
    }
    
    public String toString() {
        if (isHeads()) return "Heads";
        return "Tails";
    }
}
