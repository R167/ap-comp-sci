/****************************
 * File: BuildingFence.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package buildingfence;

import kareltherobot.*;

/**
 * @author Winston Durand
 */
public class BuildingFence extends Robot {
    public BuildingFence(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void run() {
        getBeepers();
        findBuilding();
        turnRight();
        buildFence();
        returnHome();
        turnRight();
    }
    
    private void returnHome() {
        while (frontIsClear()) move();
        turnRight();
        while (frontIsClear()) move();
    }

    private void findBuilding() {
        move();
        turnRight();
        while (frontIsClear()) {
            move();
        }
    }
    
    private void buildFence() {
        while (true) {
            if (!anyBeepersInBeeperBag()) return;
            putBeeper();
            move();
            wallThere();
        }
    }
    
    private boolean wallThere() {
        turnLeft();
        if (frontIsClear()) {
            return true;
        } else {
            turnRight();
            return false;
        }
    }

    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    private void getBeepers() {
        while (!nextToABeeper()) {
            move();
        }
        while (nextToABeeper()) {
            pickBeeper();
        }
    }
}
