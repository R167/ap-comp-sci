/**********************************
 * File: Card.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 **********************************/
package blackjack;

/**
 * @author Winston Durand
 */
final public class Card {
    public static final String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
    public static final String[] names = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
    final private int suit;
    final private int num;
    
    public Card(int suit, int num) {
        this.suit = suit;
        this.num = num;
    }
    
    public String toString() {
        return String.format("%s of %s", getName(), getSuit());
    }
    
    public String getName() {
        return names[num - 2];
    }
    
    public String getSuit() {
        return suits[suit];
    }
    
    public int getValue() {
        if (num == 14) {
            return 1;
        } else if (num > 10) {
            return 10;
        } else {
            return num;
        }
    }
    
    public boolean isAce() {
        return num == 14;
    }
}
