/**********************************
 * File: ClosingWindowDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package closingwindow;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class ClosingWindowDriver implements Directions {
    public static void main(String args[]) {
        Robot karel = new ClosingWindow(7, 5, East, 9);
        karel.run();
        karel.turnOff();
    }

    static {
        World.reset();
        World.readWorld("worlds/fig6-28.kwld");
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(10);
        World.setVisible(true);
    }
}
