/********************
 * File: Bathroom.java
 * Author: Winston Durand
 * Modified: Feb 26, 2015
 ********************/
package house;

/**
 * @author wmd
 *
 */
public class Bathroom extends Room {
    private int numSinks;
    private boolean hasTub;

    public Bathroom(int size, String flooring, String color, int numWindows, int numDoors, int sinks, boolean tub) {
        super(size, flooring, color, numWindows, numDoors);
        numSinks = sinks;
        hasTub = tub;
    }

    @Override
    public String toString() {
        return super.toString() + " numSinks: " + numSinks + " hasTub: " + hasTub;
    }

    public int getNumSinks() {
        return numSinks;
    }

    public boolean isHasTub() {
        return hasTub;
    }
}
