/****************************
 * File: ClosingWindow.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package closingwindow;

import kareltherobot.*;

/**
 * @author Winston Durand
 * 
 */
public class ClosingWindow extends Robot {
    public ClosingWindow(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }

    public void run() {
        while (true) {
            if (placedBuzzer()) return;
            if (!frontIsClear()) turnRight();
            move();
        }
    }

    private boolean placedBuzzer() {
        turnLeft();
        boolean ret = false;
        if (frontIsClear()) {
//            move();
            if (nextToABeeper()) ret = true;
            else putBeeper();
            turnX(2);
//            move();
            turnLeft();
        } else {
            turnRight();
        }
        return ret;
    }

    public void turnRight() {
        turnX(3);
    }

    private void turnX(int x) {
        for (int i = 0; i < x; i++) turnLeft();
    }
}
