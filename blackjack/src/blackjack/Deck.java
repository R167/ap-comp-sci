/**********************************
 * File: Deck.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 **********************************/

package blackjack;

import java.util.Collections;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
        
    public Deck() {
        super();
        for (int suit = 0; suit < 4; suit ++) {
            for (int cardNum = 0; cardNum < 13; cardNum ++) {
                cards.add(new Card(suit, cardNum + 2));
            }
        }
        shuffle();
    }
    
    public Card nextCard() {
        return cards.remove(0);
    }
    
    public int size() {
        return cards.size();
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
}
