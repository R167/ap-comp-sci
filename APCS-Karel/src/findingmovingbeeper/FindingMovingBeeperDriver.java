/**********************************
 * File: FindingMovingBeeperDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package findingmovingbeeper;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class FindingMovingBeeperDriver implements Directions {
    public static void main(String args[]) {
        Robot karel = new Robot(2, 8, East, 0);
        karel.turnOff();
    }

    static {

        int beeperStreet = (int) (Math.random() * 4) + 3;
        int beeperAve = (int) (Math.random() * 3) + 3;
        int shift;
        if (Math.random() > 0.5)
            shift = 0;
        else
            shift = 1;
        World.reset();
        World.readWorld("worlds/fig6-29.kwld");
        World.placeBeepers(beeperStreet, beeperAve, 1);
        World.placeEWWall(beeperStreet - 1 * shift, beeperAve, 1);
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(10);
        World.setVisible(true);
    }
}
