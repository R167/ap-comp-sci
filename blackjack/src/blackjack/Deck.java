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
    private ArrayList<Card> discardPile = new ArrayList<Card>();
        
    public Deck(int decksToPlayWith) {
        super();
        for (int i = 0; i < decksToPlayWith; i++) {
            for (int suit = 0; suit < 4; suit ++) {
                for (int cardNum = 0; cardNum < 13; cardNum ++) {
                    cards.add(new Card(suit, cardNum + 2));
                }
            }
            shuffle();
        }
    }
    
    public Card nextCard() {
        if (cards.size() <= 0) {
            System.out.println("Shuffling the discard pile...");
            cards = discardPile;
            discardPile = new ArrayList<Card>();
            shuffle();
        }
        return cards.remove(0);
    }
    
    public int size() {
        return cards.size();
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void returnCards(Card[] discard) {
        for (int i = 0; i < discard.length; i++) {
            discardPile.add(discard[i]);
        }
    }
}
