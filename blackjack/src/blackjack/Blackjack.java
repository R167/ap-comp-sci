/****************************
 * File: Blackjack.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 ***************************/
package blackjack;

import java.util.Scanner;

/**
 * @author Winston Durand
 * 
 */
public class Blackjack {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int win = 0, total = 0;
        // multiple decks
        Deck deck = new Deck(2);
        try {
            while (true) {

                User user = new User(deck, scan);
                AI dealer = new AI(deck);

                System.out.println("User faceup is " + user.getFaceUp());
                System.out.println("Dealer faceup is " + dealer.getFaceUp());

                if (user.isBlackjack()) {
                    if (dealer.isBlackjack()) {
                        System.out.println("It's a blackjack tie!");
                    } else {
                        System.out.println("You won with blackjack!");
                        win++;
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
                                win++;
                            }
                        }
                    } else {
                        System.out.println("The dealer won!");
                    }
                }
                total++;
                System.out.println("User cards: " + user.getTotal());
                System.out.println(user.getCards());
                System.out.println("Dealer cards: " + dealer.getTotal());
                System.out.println(dealer.getCards());
                user.discard();
                dealer.discard();
                System.out.println();
                System.out.printf("You won %d out of %d games\n", win, total);
                System.out.print("Would you like to play again? (y/n): ");
                if (scan.nextLine().toLowerCase().charAt(0) != 'y') break;
                System.out.println();
            }
        } finally {
            scan.close();
        }
    }
}
