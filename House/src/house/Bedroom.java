/********************
 * File: Bedroom.java
 * Author: Winston Durand
 * Modified: Feb 26, 2015
 ********************/
package house;

/**
 * @author wmd
 *
 */
public class Bedroom extends Room {
    private Bathroom bathroom;
    private int numBeds;
    private int closetSize;

    public Bedroom(int size, String flooring, String color, int numWindows, int numDoors, int beds, int closets, Bathroom bath) {
        super(size, flooring, color, numWindows, numDoors);
        numBeds = beds;
        bathroom = bath;
        closetSize = closets;
    }

    @Override
    public String toString() {
        return super.toString() + " bathroom: " + bathroom + " numBeds: " + numBeds + " closetSize: " + closetSize;
    }

    public int getNumBeds() {
        return numBeds;
    }

    public void setNumBeds(int numBeds) {
        this.numBeds = numBeds;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public int getClosetSize() {
        return closetSize;
    }

}
