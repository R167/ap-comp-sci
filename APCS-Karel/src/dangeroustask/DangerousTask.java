/****************************
 * File: DangerousTask.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package dangeroustask;

import kareltherobot.*;

/**
 * @author Winston Durand
 * 
 */
public class DangerousTask extends Robot {
    public DangerousTask(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void run() {
        int beepers = 0;
        while (this.nextToABeeper()) {
            this.pickBeeper();
            beepers ++;
        }
        if (beepers % 2 == 0) {
            turnRight();
        } else {
            turnLeft();
        }
        move();
        while (this.nextToABeeper()) {
            this.pickBeeper();
            beepers ++;
        }
    }
    
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    
}
