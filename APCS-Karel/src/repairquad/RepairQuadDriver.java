/**********************************
 * File: RepairQuadDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package repairquad;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class RepairQuadDriver implements Directions {
    public static void main(String args[]) {
        Robot karel = new RepairQuad(1, 1, East, -1);
        karel.run();
        karel.turnOff();
    }

    static {
        World.reset();
        World.readWorld("worlds/quad.kwld");
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(10);
        World.setVisible(true);
    }
}
