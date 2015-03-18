/********************
 * File: LivingRoom.java
 * Author: Winston Durand
 * Modified: Feb 26, 2015
 ********************/
package house;

/**
 * @author wmd
 *
 */
public class LivingRoom extends Room {
    private int numTVs;
    private boolean hasFireplace;

    public LivingRoom(int size, String flooring, String color, int numWindows, int numDoors, int tvs, boolean fire) {
        super(size, flooring, color, numWindows, numDoors);
        numTVs = tvs;
        hasFireplace = fire;
    }

    @Override
    public String toString() {
        return super.toString() + " numTVs: " + numTVs + " hasFireplace: " + hasFireplace;
    }

    public int getNumTVs() {
        return numTVs;
    }

    public boolean isHasFireplace() {
        return hasFireplace;
    }

}
