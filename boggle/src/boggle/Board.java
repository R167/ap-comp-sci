/****************************
 * File: Board.java
 *
 * Author: Winston Durand
 * Modified: Dec 14, 2014
 ***************************/
package boggle;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

/**
 * @author Winston Durand
 *
 */
public class Board {
    private char[] letters = null;
    private Random rand = new Random();
    // keeps things unique
    private Set<Entry> entries = new LinkedHashSet<Entry>();

    public Board() {
        this(10, true);
    }

    /**
     * The real constructor for the boggle board
     * @param len number of letters to choose from
     * @param probability use letter occurrence or just random
     */
    public Board(int len, boolean probability) {
        letters = new char[len];
        // sets the random letters for usage
        for (int i = 0; i < letters.length; i++) {
            if (probability) {
                // sets the letter based off of pure probability
                letters[i] = probLetter();
            } else {
                // just ensures at least 4 letters are vowels (purely random)
                letters[i] = randomElement(i < 4 ? Words.VOWELS : Words.ALPHABET);
            }
        }
    }

    private char randomElement(char[] cs) {
        // chooses a random element
        return cs[rand.nextInt(cs.length)];
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Get ready to play Boggle!");
            System.out.println("Letters to choose from:");
            // prints each of the letters out
            for (char c : letters) {
                System.out.printf("%s ", c);
            }
            System.out.println();
            while (true) {
                System.out.print("Enter a word or -1 to quit: ");
                // gets the users input
                String input = scan.nextLine();
                if (input.equals("-1")) {
                    // quits the input mode
                    break;
                } else if (input.length() >= 3 && input.length() <= 8) {
                    // ensures that the word is in range of the word list length
                    entries.add(new Entry(input, letters));
                } else {
                    // prints a warning
                    System.out.println("Entries must be at least 3 letters long and no more than 8.");
                }
            }

            int earned = 0, lost = 0, total = 0;
            // prints out each of the entries
            for (Entry e : entries) {
                earned += e.getEarned();
                lost -= e.getLost();
                total += e.getPoints();
                System.out.printf("%-8s | %2d\n", e.getWord(), e.getPoints());
            }
            // print out the point earnings
            System.out.printf("Points earned: %d\n", earned);
            System.out.printf("Points lost: %d\n", lost);
            System.out.printf("Points total: %d\n", total);
        } finally {
            // this must always happen
            scan.close();
        }
    }

    /**
     * returns letters based off of probability
     * @return weighted random letter
     */
    private char probLetter() {
        // chooses a random number to check against
        double val = rand.nextDouble();
        double running = 0.0;
        for (int i = 0; i < Words.PROBABILITY.length; i++) {
            // adds the probability and checks if less than running
            // if less, then this is the letter
            running += Words.PROBABILITY[i];
            if (val < running) {
                return Words.ALPHABET[i];
            }
        }
        // runs through again on the off chance that there was a rounding error
        return probLetter();
    }
}
