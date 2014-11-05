/**********************************
 * File: DoubleBeepersDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/

package doublebeepers;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class DoubleBeepersDriver implements Directions {
    public static void main(String args[]) {
        Robot karel = new Robot(1, 1, East, -1);
        karel.turnOff();
    }

    static {
        World.reset();
        World.setSize(3, 4);
        World.placeBeepers(1, 2, (int) (Math.random() * 50));
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(10);
        World.setVisible(true);
    }
}
