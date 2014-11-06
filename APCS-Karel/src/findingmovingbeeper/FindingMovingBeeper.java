/****************************
 * File: FindingMovingBeeper.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package findingmovingbeeper;

import kareltherobot.*;

/**
 * @author Winston Durand
 * 
 */
public class FindingMovingBeeper extends Robot {
    public FindingMovingBeeper(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void run() {
        turnX(2);
        zigZag();
        moveBeeper();
        returnHome();
    }
    
    private void returnHome() {
        while (!facingEast()) turnLeft();
        while (frontIsClear()) move();
        turnRight();
        while (frontIsClear()) move();
        turnX(2);
    }

    private void zigZag() {
        while (frontIsClear()) {
            move();
            if (nextToABeeper()) return;
        }
        turnRight();
        move();
        turnRight();
        while (frontIsClear()) {
            move();
            if (nextToABeeper()) return;
        }
        turnLeft();
        move();
        turnLeft();
        zigZag();
    }
    
    private void moveBeeper() {
        pickBeeper();
        while (frontIsClear()) turnLeft();
        turnRight();
        move();
        turnLeft();
        move();
        turnLeft();
        move();
        putBeeper();
        move();
    }
    
    public void turnRight() {
        turnX(3);
    }
    
    private void turnX(int x) {
        for (int i = 0; i < x; i++) turnLeft();
    }
}
