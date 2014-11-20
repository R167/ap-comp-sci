/****************************
 * File: Hand.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 ***************************/
package blackjack;

import java.util.ArrayList;

/**
 * @author Winston Durand
 * 
 */
public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    public Hand() {
        super();
    }
    
    public int getSoftTotal() {
        int ret = 0;
        for (Card card : cards) {
            ret += (card.isAce() ? 11 : card.getValue());
        }
        return ret;
    }
    
    public void addCard(Card card) {
        cards.add(card);
    }
    
    public Card getFaceUp() {
        return cards.get(0);
    }
    
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (cards.size() > 0) {
            str.append(cards.get(0));
        }
        for (int i = 1; i < cards.size(); i++) {
            str.append("\n").append(cards.get(i));
        }
        return str.toString();
    }
    
    public int getTotal() {
        int aces = 0, ret = 0;
        for (Card card : cards) {
            ret += card.getValue();
            if (card.isAce()) {
                aces++;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (ret + 10 <= 21) {
                ret += 10;
            } else {
                break;
            }
        }
        return ret;
    }
    
    public int getHardTotal() {
        int ret = 0;
        for (Card card : cards) {
            ret += card.getValue();
        }
        return ret;
    }
    
    public boolean isBusted() {
        if (getHardTotal() > 21) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isBlackjack() {
        if (getSoftTotal() == 21) {
            return true;
        } else {
            return false;
        }
    }
}
