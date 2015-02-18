/****************************
 * File: Kangaroo.java
 * 
 * Author: Winston Durand
 * Modified: Feb 18, 2015
 ***************************/
package inheritance;

/**
 * @author Winston Durand
 * 
 */
public class Kangaroo extends Mammal {
    public static final int LIFE_EXPECTANCY = 20;
    
    public Kangaroo() {
        super();
        this.setLifeExpectancy(LIFE_EXPECTANCY);
    }
}
