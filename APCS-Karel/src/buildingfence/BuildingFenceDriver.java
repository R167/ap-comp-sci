/**********************************
 * File: BuildingFenceDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package buildingfence;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class BuildingFenceDriver implements Directions {
    static int beeperLocation = (int) (Math.random() * 10) + 1;
    static int fenceLength = (int) (Math.random() * 10) + 1;
    static int fenceHeight = (int) (Math.random() * 10) + 1;
    static int numBeepers = 2 * (fenceLength + fenceHeight) + 4;

    public static void main(String args[]) {
        Robot karel = new BuildingFence(1, 1, North, 0);
        karel.run();
        karel.turnOff();
    }

    static {
        World.reset();
        World.setSize(beeperLocation + fenceHeight + 2, 6 + fenceLength);
        World.placeBeepers(beeperLocation, 1, numBeepers);
        World.placeEWWall(beeperLocation, 5, fenceLength);
        World.placeEWWall(beeperLocation + fenceHeight, 5, fenceLength);
        World.placeNSWall(beeperLocation + 1, 4, fenceHeight);
        World.placeNSWall(beeperLocation + 1, 4 + fenceLength, fenceHeight);
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(10);
        World.setVisible(true);
    }
}
