/****************************
 * File: User.java
 * 
 * Author: Winston Durand
 * Modified: Nov 19, 2014
 ***************************/
package blackjack;

import java.util.Scanner;

/**
 * @author Winston Durand
 */
public class User extends Player {
    private Scanner scan;

    public User(Deck deck, Scanner scan) {
        super(deck);
        this.scan = scan;
    }

    public boolean run() {
        while (!isBusted() && !isBlackjack()) {
            printStatus();
            System.out.print("Would you like to hit or stand: ");
            char selection = scan.nextLine().toLowerCase().charAt(0);
            if (selection == 'h') {
                hit();
            } else if (selection == 's') {
                break;
            } else {
                System.out.println("Invalid choice!");
                continue;
            }
            System.out.println();
        }
        if (isBusted()) {
            System.out.printf("You busted at %d!\n", getTotal());
            return false;
        } else {
            return true;
        }
    }

    public void printStatus() {
        System.out.println("Your cards are:");
        System.out.println(getCards());
        System.out.printf("Max: %02d | Min: %02d | Total: %02d\n", getSoftTotal(), getHardTotal(), getTotal());
    }
}
