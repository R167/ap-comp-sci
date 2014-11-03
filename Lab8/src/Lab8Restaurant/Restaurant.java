package Lab8Restaurant;

import java.util.Scanner;

public class Restaurant {

    /*
     * Member Variables
     */
    private Table table1;
    private Table table2;
    private Table table3;
    private int numTableAvailable;

    /*
     * MemberFunctions
     */

    public void run() {
        int userInput = 0;
        Scanner readOption = new Scanner(System.in);
        try {
            while (userInput != -1) {
                try {
                    System.out.println("What would you like to do:");
                    System.out.println("1) Seat a new party");
                    System.out.println("2) Add Order to table");
                    System.out.println("3) See the Orders for table");
                    System.out.println("4) Get the check for a table");
                    System.out.println("5) Set a table as empty");
                    System.out.println("6) Get a list of empty tables");
                    System.out.println("-----------------------------");
                    System.out.println("-1) Quit");

                    userInput = readOption.nextInt();
                    if (userInput == -1) {
                        return;
                    } else if (userInput == 1) {
                        // call function to seat local party
                    } else if (userInput == 2) {
                        // call function to add order to a table
                    } else if (userInput == 3) {
                        // call function to see table's order
                    } else if (userInput == 4) {
                        // call function to calculate the check for customer
                    } else if (userInput == 5) {
                        // call function to set a table as empty
                    } else if (userInput == 6) {
                        // call function to get a list of empty tables
                    }
                } catch (java.util.InputMismatchException err) {
                    System.out.println("Invalid input!");
                }
            }
        } finally {
            readOption.close();
        }

    }

    // TODO: implement the following functions.

    // Restaurant Constructor
    // create new objects for table1, table2, table3
    // set each of the tables to Empty
    // initialize numTableAvailable
    public Restaurant() {
        table1 = new Table();
        table2 = new Table();
        table3 = new Table();
        numTableAvailable = 3;
    }

    // tableEmpty(int tableNum)
    private boolean tableEmpty(int tableNum) {
        return tableByNumber(tableNum).isTableEmpty();
    }

    // setTableEmpty(int tableNum)
    private void setTableEmpty(int tableNum) {
        tableByNumber(tableNum).setTableEmpty();
    }

    // setTableOccupied(int tableNum, int customers)
    private void setTableOccupied(int tableNum, int customers) {
        tableByNumber(tableNum).setTableOccupied(customers);
    }

    // getTablesAvailable()
    // return a string with the names of the tables that are empty.

    // addOrderToTable(int tableNum, String itemName, double price)

    // displayTableOrders(int tableNum) - void

    // getTabTotalForTable(int tableNum)

    private Table tableByNumber(int tableNum) {
        switch (tableNum) {
        case 1: return table1;
        case 2: return table2;
        case 3: return table3;
        }
        return new Table();
    }

}
