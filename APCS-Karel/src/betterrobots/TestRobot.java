package betterrobots;

import kareltherobot.*;

public class TestRobot extends BetterRobot {
    public TestRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
    }
    
    public void hello() {
        int[][] letters = {
                {2, 2, 2, 6},
                {3, 4, 3, 4},
                {4, 2, 4, 6},
                
                {6, 6, 6, 2},
                {7, 2, 8, 2},
                {7, 4, 7, 4},
                {7, 6, 8, 6},
                
                {10, 6, 10, 2},
                {11, 2, 12, 2},
                
                {14, 6, 14, 2},
                {15, 2, 16, 2},

                {18, 2, 18, 6},
                {19, 6, 20, 6},
                {20, 5, 20, 2},
                {19, 2, 19, 2},
        };
        
        for (int[] l : letters) {
            drawLine(l[0], l[1], l[2], l[3]);
        }
        moveTo(1, 1);
    }
}
