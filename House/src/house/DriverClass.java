/********************
 * File: DriverClass.java
 * Author: Winston Durand
 * Modified: Feb 26, 2015
 ********************/
package house;

public class DriverClass {

    public static void main(String[] args) {
        Room[] roomsInHouse = new Room[6];
        
        roomsInHouse[0] = new Bedroom(10, "Marble", "Beige", 1, 0, -1, 100, new Bathroom(2, "Platinum", "Beige", 0, 1, 30, true));
        roomsInHouse[1] = new Bedroom(10, "Marble", "Beige", 1, 0, -1, 100, new Bathroom(2, "Platinum", "Beige", 0, 1, 30, true));
        roomsInHouse[2] = new Bedroom(10, "Marble", "Beige", 1, 0, -1, 100, new Bathroom(2, "Platinum", "Beige", 0, 1, 30, true));
        roomsInHouse[3] = new Bathroom(2, "Platinum", "Beige", 0, 1, 30, true);
        roomsInHouse[4] = new Bathroom(2, "Platinum", "Beige", 0, 1, 30, true);
        roomsInHouse[5] = new LivingRoom(20, "Gold", "Beige", 2000, 3, 63, false);


        for (int i = 0; i < 6; i++) {
            if (roomsInHouse[i].getClass() == Bedroom.class) {
                Bedroom theBedroom = (Bedroom) roomsInHouse[i];
                System.out.println("closet size in myBedroom2 object: " + theBedroom.getClosetSize());
            } else if (roomsInHouse[i].getClass() == Bathroom.class) {
                Bathroom theBathroom = (Bathroom) roomsInHouse[i];
                System.out.println("Closet size in myBedroom2 object: " + theBathroom.getNumSinks());
            }
            
            System.out.println(roomsInHouse[i]);
        }
    }
}
