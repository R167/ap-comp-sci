package betterrobots;

import kareltherobot.*;
import java.awt.Color;

public class TestRunner implements Directions {

    public static void main(String args[]) {
        TestRobot karel = new TestRobot(2, 1, East, -1);
        karel.hello();
        karel.turnOff();
    }

    static {
        World.reset();
        World.setSize(20, 21);
        // World.readWorld("worlds/fig6-25.kwld");
        World.setBeeperColor(Color.blue);
        World.setStreetColor(Color.gray);
        World.setNeutroniumColor(Color.black);
        World.setDelay(4);
        World.setVisible(true);
    }

}
