package Lab8Restaurant;

import java.util.ArrayList;

public class Tab {

    /*
     * MemberVariables
     */

    private ArrayList<Item> items = new ArrayList<Item>();


    /*
     * MemberFunctions
     */

    //TODO: implement the following functions

    //constructor to initialize items. 	

    //orderItem(String itemName, double itemPrice) - return void (fill the items in order. First item should be put in item1, second on item2, etc)
    public void orderItem(String itemName, double itemPrice) {
        items.add(new Item(itemName, itemPrice));
    }

    //displayOrders() - returns void, displays order to the console.
    public void displayOrders() {
        System.out.println(toString());
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Item item : items) str.append(item.toString()).append("\n");
        return str.toString();
    }

    //calculateTotal
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) total += item.getPrice();
        return total;
    }


}
