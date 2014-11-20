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
    public User(Deck deck) {
        super(deck);
    }

    public boolean run() {
        Scanner scan = new Scanner(System.in);
        try {
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
            }
        } finally {
            scan.close();
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
