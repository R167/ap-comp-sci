/**********************************
 * File: RepairQuad.java
 * 
 * Author: Winston Durand
 * Modified: Nov 6, 2014
 **********************************/
package repairquad;

import kareltherobot.*;

/**
 * @author Winston Durand
 */
public class RepairQuad extends Robot {
    public RepairQuad(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
    }
    
    public void run() {
        turnLeft();
        hitWall();
        turnRight();
        buildPillars(4);
    }
    
    private void buildPillars(int count) {
        if (count > 0) buildPillar();
        for (int i = 0; i < count - 1; i++) {
            nextPillar();
            buildPillar();
        }
    }

    private void nextPillar() {
        while (true) {
            move();
            turnLeft();
            if (!frontIsClear()) break;
            turnRight();
        }
        turnRight();
    }

    private void buildPillar() {
        turnRight();
        while (frontIsClear()) {
            if (!nextToABeeper()) putBeeper();
            move();
        }
        if (!nextToABeeper()) putBeeper();
        turnX(2);
        hitWall();
        turnRight();
    }
    
    private void hitWall() {
        while (frontIsClear()) move();
    }
    
    private void turnX(int x) {
        for (int i = 0; i < x; i++) turnLeft();
    }
    
    public void turnRight() {
        turnX(3);
    }
}
