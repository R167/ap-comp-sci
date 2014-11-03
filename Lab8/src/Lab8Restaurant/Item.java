package Lab8Restaurant;

public class Item {

    /*
     * MemberVariables
     */

    private String name;
    private double price;

    /*
     * MemberFunctions
     */

    //TODO: implement the following functions

    //constructor to initialize the above items to 0 if its an int/double, or empty string if its a String.
    public Item(String itemName, double itemPrice) {
        this.name = itemName;
        this.price = itemPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String toString() {
        return name + ": $" + price;
    }

    //getters and setters for each of the variables
}
