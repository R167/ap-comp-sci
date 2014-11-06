/**********************************
 * File: DefendDemocracy.java
 * 
 * Author: Winston Durand
 * Modified: Nov 6, 2014
 **********************************/
package defenddemocracy;

import kareltherobot.*;

/**
 * @author Winston Durand
 */
public class DefendDemocracy extends Robot {

    public DefendDemocracy(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
    }
    
    public void run() {
        move();
        rooms();
        for (int i = 0; i < 4; i++) {
            move();
            move();
            rooms();
        }
    }
    
    private void rooms() {
        boolean clear = !nextToABeeper();
        turnLeft();
        move();
        while (nextToABeeper()) pickBeeper();
        if (!clear) putBeeper();
        turnX(2);
        move();
        move();
        while (nextToABeeper()) pickBeeper();
        if (!clear) putBeeper();
        turnX(2);
        move();
        turnRight();
    }
    
    private void turnRight() {
        turnX(3);
    }

    private void turnX(int x) {
        for (int i = 0; i < x; i++) turnLeft();
    }
}
