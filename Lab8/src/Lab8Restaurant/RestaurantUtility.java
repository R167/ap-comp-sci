package Lab8Restaurant;

public class RestaurantUtility {

    //All functions here are utility (thus class) functions, please implement them as such. DO NOT instantiate an object of RestaurantUtility to use the functions defined here. 

    //TODO: implement the following functions. 
    //calculateTax(double tax, double total)
    public static double calculateTax(double tax, double total) {
        return total * tax;
    }
    //calculateTotal(Tab myTab)
    public static double calculateTotal(Tab myTab) {
        return myTab.calculateTotal();
    }
    //calculateTip(double tipPercent, double total)
    public static double calculateTip(double tipPercent, double total) {
        return tipPercent * total;
    }
    //calculateTip(int tipAmount, double total)
    public static double calculateTip(int tipAmount, double total) {
        return calculateTip(tipAmount / 100.0, total);
    }

}
