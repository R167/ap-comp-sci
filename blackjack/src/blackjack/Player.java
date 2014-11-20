/**********************************
 * File: Player.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 **********************************/
package blackjack;

/**
 * @author Winston Durand
 */
public abstract class Player {
    private Hand hand = new Hand();
    private Deck deck = null;
    
    public Player(Deck deck) {
        super();
        this.deck = deck;
        hit();
        hit();
    }
    
    public String getCards() {
        return hand.toString();
    }
    
    public int hit() {
        hand.addCard(deck.nextCard());
        return hand.getTotal();
    }
    
    public int getTotal() {
        return hand.getTotal();
    }

    public int getSoftTotal() {
        return hand.getSoftTotal();
    }

    public int getHardTotal() {
        return hand.getHardTotal();
    }

    public boolean isBusted() {
        return hand.isBusted();
    }

    public boolean isBlackjack() {
        return hand.isBlackjack();
    }

    public Card getFaceUp() {
        return hand.getFaceUp();
    }
}
