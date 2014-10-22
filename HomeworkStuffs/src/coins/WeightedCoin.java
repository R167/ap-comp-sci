/**********************************
 * File: WeightedCoin.java
 * 
 * Author: Winston Durand
 * Modified: Oct 22, 2014
 **********************************/
package coins;

/**
 * @author Winston Durand
 *
 */
public class WeightedCoin extends Coin {
    private double headWeight = 0.5;
    
    public WeightedCoin() {
        super();
    }
    
    public WeightedCoin(double percentHeads) throws Exception {
        if (percentHeads >= 0 && percentHeads <= 1) {
            headWeight = percentHeads;
        } else {
            throw new Exception("percentHeads out of range!");
        }
        
        flip();
    }
    
    public void flip() {
        face = (int)
    }

}
