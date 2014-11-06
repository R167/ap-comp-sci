/**********************************
 * File: TreasureHuntDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 **********************************/
package treasurehunt;

import kareltherobot.*;
import java.awt.Color;

/**
 * @author Winston Durand
 */
public class TreasureHuntDriver implements Directions {
    public static void main(String args[]) {

        // Your code goes below here:
        Robot karel = new TreasureHunt(2, 2, North, 0);
        karel.run();
//        karel.setVisible(false);
        karel.turnOff();
    }

    static {
        int world = (int) (Math.random() * 3 + 1);
        World.reset();
        World.setSize(10, 10);
        if (world == 1) {
            World.readWorld("worlds/treasure1.kwld");
        } else if (world == 2) {
            World.readWorld("worlds/treasure2.kwld");
        } else if (world == 3) {
            World.readWorld("worlds/treasure3.kwld");
        }
        // World.readWorld("worlds/fig6-27.kwld");
        World.setBeeperColor(Color.black);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(10);
        World.setVisible(true);
    }
}
