/****************************
 * File: BeeperPath.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package beeperpath;

import kareltherobot.*;

/**
 * @author Winston Durand
 */
public class BeeperPath extends Robot {
    public BeeperPath(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void run() {
        move();
        while (true) {
            pickBeeper();
            if (nextToABeeper()) {
                pickBeeper();
                return;
            }
            turnRightWay();
        }
    }
    
    private void turnRightWay() {
        move();
        if (nextToABeeper()) return;
        turnLeft();
        turnLeft();
        move();
        turnLeft();
        turnRightWay();
    }
    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
