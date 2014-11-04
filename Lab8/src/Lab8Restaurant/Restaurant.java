package Lab8Restaurant;

import java.util.Scanner;

public class Restaurant {

    /*
     * Member Variables
     */
    private Table table1;
    private Table table2;
    private Table table3;

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
                        int table = userInTable(readOption);
                        System.out.print("People to seat: ");
                        int count = readOption.nextInt();
                        setTableOccupied(table, count);
                    } else if (userInput == 2) {
                        int table = userInTable(readOption);
                        System.out.print("Dish being ordered: ");
                        String order = readOption.next();
                        System.out.print("Price of dish: ");
                        double price = readOption.nextDouble();
                        addOrderToTable(table, order, price);
                    } else if (userInput == 3) {
                        displayTableOrders(userInTable(readOption));
                    } else if (userInput == 4) {
                        System.out.println(getTabTotalForTable(userInTable(readOption)));
                    } else if (userInput == 5) {
                        setTableEmpty(userInTable(readOption));
                    } else if (userInput == 6) {
                        System.out.println("Empty Tables: " + getTablesAvailable());
                    }
                } catch (java.util.InputMismatchException err) {
                    System.out.print("Invalid input! '");
                    System.out.print(readOption.next());
                    System.out.println("' is not valid!");
                } catch (InvalidValueException err) {
                    System.out.println(err.getMessage());
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
    }

    // tableEmpty(int tableNum)
    private boolean tableEmpty(int tableNum) throws InvalidValueException {
        return tableByNumber(tableNum).isTableEmpty();
    }

    // setTableEmpty(int tableNum)
    private void setTableEmpty(int tableNum) throws InvalidValueException {
        tableByNumber(tableNum).setTableEmpty();
    }

    // setTableOccupied(int tableNum, int customers)
    private void setTableOccupied(int tableNum, int customers) throws InvalidValueException {
        tableByNumber(tableNum).setTableOccupied(customers);
    }

    // getTablesAvailable()
    // return a string with the names of the tables that are empty.
    private String getTablesAvailable() throws InvalidValueException {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            if (tableEmpty(i)) str.append("Table " + i + ", ");
        }
        return str.toString().replaceAll(", $", "").replaceAll("^$", "There are no empty tables.");
    }

    // addOrderToTable(int tableNum, String itemName, double price)
    private void addOrderToTable(int tableNum, String itemName, double price) throws InvalidValueException {
        tableByNumber(tableNum).addOrderToTable(itemName, price);
    }

    // displayTableOrders(int tableNum) - void
    private void displayTableOrders(int tableNum) throws InvalidValueException {
        tableByNumber(tableNum).displayTableOrders();
    }
    
    private int userInTable(Scanner scan) {
        System.out.print("Please enter a table number: ");
        return scan.nextInt();
    }

    // getTabTotalForTable(int tableNum)
    private String getTabTotalForTable(int tableNum) throws InvalidValueException {
        return tableByNumber(tableNum).getTabTotal();
    }

    private Table tableByNumber(int tableNum) throws InvalidValueException {
        switch (tableNum) {
        case 1: return table1;
        case 2: return table2;
        case 3: return table3;
        default: throw new InvalidValueException("No such table!");
        }
    }

}
