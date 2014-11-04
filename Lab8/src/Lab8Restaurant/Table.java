package Lab8Restaurant;

public class Table {
    /*
     * Member Variables
     */
    private int numSeatsAvailable = 4;
    private int numSeatedCustomers;
    private boolean tableEmpty = true;
    private Tab tableTab = new Tab();
    
    
    public boolean isTableEmpty() {
        return tableEmpty;
    }
    
    public void setTableEmpty() {
        this.tableEmpty = true;
    }
    
    public void setTableOccupied(int customers) {
        this.tableEmpty = false;
        this.numSeatedCustomers = customers;
    }

    //addOrderToTable(String itemName, double price)
    public void addOrderToTable(String itemName, double price) {
        tableTab.orderItem(itemName, price);
    }

    //displayTableOrders()
    public void displayTableOrders() {
        tableTab.displayOrders();
    }

    //getTabTotal() - return string of what tab looks like
    public String getTabTotal() {
        double subtotal = RestaurantUtility.calculateTotal(tableTab);
        double tax = RestaurantUtility.calculateTax(0.1, subtotal);
        double total = subtotal + tax;
        StringBuilder str = new StringBuilder();
        str.append(tableTab.toString());
        str.append(String.format("Subotal: $%.02f", subtotal));
        str.append(String.format("\nTotal: $%.02f", total));
        for (int i = 10; i < 25; i += 5) {
            double tip = RestaurantUtility.calculateTip(i, subtotal);
            str.append(String.format("\n%d%% tip: $%.02f New Total: $%.02f", i, tip, total + tip));
        }
        return str.toString();
    }
    //the tab should include:
    //each items name and its price
    //the total of the bill, and tax. 
    //the amount $ amount of tip that would correspond to 10%, 15%, 20% tip. 
    //it should look and feel like a bill printout you would get at a restaurant. 
    //All the values in the tab need to be calculated using the utility functions in the RestaurantUtility class. 

}
