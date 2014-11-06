/****************************
 * File: SortingTask.java
 * 
 * Author: Winston Durand
 * Modified: Nov 5, 2014
 ***************************/
package sortingtask;

import kareltherobot.*;
import java.util.Arrays;

/**
 * @author Winston Durand
 */
public class SortingTask extends Robot {
    public SortingTask(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }

    public void run() {
        origin();
        int[] stacks = new int[countRows()];
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = countInRow();
            move();
        }
        origin();
        Arrays.sort(stacks);
        for (int i = 0; i < stacks.length; i++) {
            turnLeft();
            for (int j = 0; j < stacks[i]; j++) {
                putBeeper();
                move();
            }
            turnX(2);
            hitWall();
            turnLeft();
            move();
        }
        origin();
    }

    private int countRows() {
        int rows = 0;
        while (nextToABeeper()) {
            move();
            rows++;
        }
        origin();
        return rows;
    }

    private int countInRow() {
        turnLeft();
        int count = 0;
        while (nextToABeeper()) {
            pickBeeper();
            move();
            count++;
        }
        turnX(2);
        hitWall();
        turnLeft();
        return count;
    }

    private void turnX(int x) {
        for (int i = 0; i < x; i++)
            turnLeft();
    }

    private void origin() {
        while (!facingWest())
            turnLeft();
        hitWall();
        turnLeft();
        hitWall();
        turnLeft();
    }
    
    private void hitWall() {
        while (frontIsClear()) move();
    }
}
