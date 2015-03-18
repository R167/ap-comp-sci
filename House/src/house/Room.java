/********************
 * File: Room.java
 * Author: Winston Durand
 * Modified: Feb 26, 2015
 ********************/
package house;

/**
 * @author wmd
 *
 */
public abstract class Room {
    private int size;
    private String flooring;
    private String color;
    private int numWindows;
    private int numDoors;

    public Room(int size, String flooring, String color, int numWindows, int numDoors) {
        super();
        this.size = size;
        this.flooring = flooring;
        this.color = color;
        this.numWindows = numWindows;
        this.numDoors = numDoors;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "size: " + size + " flooring: " + flooring + " color: " + color + " numWindows: " + numWindows + " numDoors: " + numDoors;
    }

    public String getFlooring() {
        return flooring;
    }

    public String getColor() {
        return color;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public int getNumDoors() {
        return numDoors;
    }

}
