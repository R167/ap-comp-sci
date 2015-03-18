/********************
 * File: Staff.java
 * Author: Winston Durand
 * Modified: Feb 22, 2015
 ********************/
package labinheritance;

public class Staff {
    private StaffMember[] staffList;

    // -----------------------------------------------------------------
    // Sets up the list of staff members.
    // -----------------------------------------------------------------
    public Staff() {
        staffList = new StaffMember[8];
        staffList[0] = new Executive("Elliot", "123 Main Line", "555-0469", "123-45-6789", 2423.07);
        staffList[1] = new Employee("Dr. Kelso", "456 Off Line", "555-0101", "987-65-4321", 1246.15);
        staffList[2] = new Employee("Turk", "789 Off Rocker", "555-0000", "010-20-3040", 1169.23);
        staffList[3] = new Hourly("Dr. Cox", "678 Fifth Ave.", "555-0690", "958-47-3625", 10.55);
        staffList[4] = new Volunteer("J.D.", "987 Suds Blvd.", "555-8374");
        staffList[5] = new Volunteer("Carla", "321 Duds Lane", "555-7282");
        staffList[6] = new Commision("Dr. Dre", "NaN Fifth Ave.", "666-6666", "666-66-6666", 6.25, 0.2);
        staffList[7] = new Commision("Dr. Oz", "NullPointerException College Ave.", "000-0000", "000-00-0000", 9.75, 0.15);
        ((Executive) staffList[0]).awardBonus(500.00);
        ((Hourly) staffList[3]).addHours(40);
        ((Commision) staffList[6]).addHours(35);
        ((Commision) staffList[6]).addSales(400);
        ((Commision) staffList[7]).addHours(40);
        ((Commision) staffList[7]).addSales(950);
    }

    // -----------------------------------------------------------------
    // Pays all staff members.
    // -----------------------------------------------------------------
    public void payday() {
        double amount;
        for (int count = 0; count < staffList.length; count++) {
            System.out.println(staffList[count]);
            amount = staffList[count].pay(); // polymorphic
            if (amount == 0.0)
                System.out.println("Thanks!");
            else
                System.out.println("Paid: " + amount);
            System.out.println("-----------------------------------");
        }
    }
}
