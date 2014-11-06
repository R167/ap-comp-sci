/**********************************
 * File: BeeperPathDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package beeperpath;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class BeeperPathDriver implements Directions {
    public static void main(String args[]) {
        // DO NOT MODIFY THIS CODE
        Robot beeperBot = new Robot(2, 2, East, -1);
        makePath(beeperBot);
        Robot karel = new BeeperPath(2, 1, East, 0);
        // Your code goes below here
        karel.run();
        karel.turnOff();
    }

    public static void makePath(Robot beeperBot) {
        for (int j = 0; j < 10; j++) {
            int length = (int) (Math.random() * 5 + 3);
            for (int k = 0; k < length; k++) {
                beeperBot.putBeeper();
                if (j == 9 && k == (length - 1)) {
                    // Marks end of path
                    beeperBot.putBeeper();
                }
                beeperBot.move();
            }
            if (j % 4 == 0) {
                while (!beeperBot.facingEast()) {
                    beeperBot.turnLeft();
                }
            } else if (j % 4 == 1) {
                while (!beeperBot.facingNorth()) {
                    beeperBot.turnLeft();
                }
            } else if (j % 4 == 2) {
                while (!beeperBot.facingWest()) {
                    beeperBot.turnLeft();
                }
            } else {
                while (!beeperBot.facingNorth()) {
                    beeperBot.turnLeft();
                }
            }
        }
        beeperBot.setVisible(false);
        beeperBot.turnOff();
    }

    static {
        World.reset();
        World.setSize(31, 20);
        // World.readWorld("worlds/fig6-25.kwld");
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(2);
        World.setVisible(true);
    }
}
