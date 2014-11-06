/****************************
 * File: DoubleBeepers.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package doublebeepers;

import kareltherobot.*;

/**
 * @author Winston Durand
 * 
 */
public class DoubleBeepers extends Robot {
    public DoubleBeepers(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void run() {
        move();
        int count = 0;
        while (nextToABeeper()) {
            pickBeeper();
            count ++;
        }
        for (int i = 0; i < count * 2; i++) putBeeper();
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        turnLeft();
    }
}
