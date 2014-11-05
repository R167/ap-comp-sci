/**********************************
 * File: DefendDemocracyDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package defenddemocracy;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class DefendDemocracyDriver implements Directions {
    public static void main(String args[]) {
        Robot karel = new Robot(3, 1, East, 0);
        karel.turnOff();
    }

    static {
        World.reset();
        World.readWorld("worlds/hangingchad.kwld");
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(10);
        World.setVisible(true);
    }
}
