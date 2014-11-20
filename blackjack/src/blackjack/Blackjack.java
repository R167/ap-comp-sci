/****************************
 * File: Blackjack.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 ***************************/
package blackjack;

/**
 * @author Winston Durand
 * 
 */
public class Blackjack {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Deck deck = new Deck();

        User user = new User(deck);
        AI dealer = new AI(deck);

        System.out.println("User faceup is " + user.getFaceUp());
        System.out.println("Dealer faceup is " + dealer.getFaceUp());

        if (user.isBlackjack()) {
            if (dealer.isBlackjack()) {
                System.out.println("It's a blackjack tie!");
            } else {
                System.out.println("You won with blackjack!");
            }
        } else {
            if (user.run()) {
                if (dealer.isBlackjack()) {
                    System.out.println("The dealer won with blackjack!");
                } else if (dealer.run(user.getTotal())) {
                    System.out.println("The dealer won!");
                } else {
                    if (user.getTotal() == dealer.getTotal()) {
                        System.out.println("It's a tie!");
                    } else {
                        System.out.println("You won!");
                    }
                }
            } else {
                System.out.println("The dealer won!");
            }
        }
        System.out.println("User cards: " + user.getTotal());
        System.out.println(user.getCards());
        System.out.println("Dealer cards: " + dealer.getTotal());
        System.out.println(dealer.getCards());
    }
}
