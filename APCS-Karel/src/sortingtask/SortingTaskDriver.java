/**********************************
 * File: SortingTaskDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package sortingtask;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class SortingTaskDriver implements Directions {
    public static void main(String args[]) {
        // Do NOT modify the code below
        Robot stackBot = new Robot(1, 1, East, -1);

        stackBot.setVisible(false);
        stackBot.turnOff();

        // Your code goes here:
        Robot karel = new SortingTask(8, 2, West, 0);
        karel.run();
        karel.turnOff();
    }

    static {
        World.reset();
        World.readWorld("worlds/fig6-31.kwld");
        // World.readWorld("worlds/sortsolution.kwld"); // Solution
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(5);
        World.setVisible(true);
    }
}
