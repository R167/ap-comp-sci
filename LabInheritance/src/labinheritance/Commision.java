/********************
 * File: Commision.java
 * Author: Winston Durand
 * Modified: Feb 22, 2015
 ********************/
package labinheritance;

/**
 * @author wmd
 *
 */
public class Commision extends Hourly {
    private double totalSales;
    private double commision;
    
    public Commision(String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commision) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commision = commision;
        this.totalSales = 0;
    }
    
    public void addSales(double earned) {
        totalSales += earned;
    }
    
    public double pay() {
        double ret = super.pay() + totalSales * commision;
        totalSales = 0;
        return ret;
    }
    
    public String toString() {
        return super.toString() + String.format("\nTotal Salses: %f", totalSales);
    }

}
