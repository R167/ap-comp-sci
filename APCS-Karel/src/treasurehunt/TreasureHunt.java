/****************************
 * File: TreasureHunt.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package treasurehunt;

import kareltherobot.*;

/**
 * @author Winston Durand
 * 
 */
public class TreasureHunt extends Robot {
    public TreasureHunt(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }

    public void run() {
        while (true) {
            if (turnCorrect() == 5)
                return;
            move();
        }
    }

    private int turnCorrect() {
        int count = 0;
        while (nextToABeeper()) {
            pickBeeper();
            count ++;
        }
        if (count == 5) return 5;
        if (count == 0) return 0;
        while (true) {
            if (count == 1 && facingNorth()) return 1;
            else if (count == 2 && facingEast()) return 2;
            else if (count == 3 && facingSouth()) return 3;
            else if (count == 4 && facingWest()) return 4;
            turnLeft();
        }
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}
