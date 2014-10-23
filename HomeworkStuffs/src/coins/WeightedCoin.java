/**********************************
 * File: WeightedCoin.java
 * 
 * Author: Winston Durand
 * Modified: Oct 22, 2014
 **********************************/
package coins;

/**
 * Creates a coin with uneven odds
 * 
 * @author Winston Durand
 */
public class WeightedCoin extends Coin {
    private double headWeight = 0.5;
    
    public WeightedCoin() {
        super();
    }
    
    public WeightedCoin(double percentHeads) throws Exception {
        setHeadWeight(percentHeads);
        flip();
    }
    
    public WeightedCoin(int percentHeads) throws Exception {
        setHeadWeight(percentHeads / 100.0);
        flip();
    }
    
    public void flip() {
        this.face = (Math.random() < this.headWeight ? 0 : 1);
    }

    public double getHeadWeight() {
        return headWeight;
    }

    public void setHeadWeight(double headWeight) throws Exception {
        if (headWeight >= 0 && headWeight <= 1) {
            this.headWeight = headWeight;
        } else {
            throw new Exception("'headWeight' out of range! Should be a decimal type percentage! (0.50 = 50%)");
        }
    }

}
