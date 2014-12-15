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
        for (int i = 0; i < letters.length; i++) {
            if (probability) {
                letters[i] = probLetter();
            } else {
                letters[i] = randomElement(i < 4 ? Words.ALPHABET : Words.ALPHABET);
            }
        }
    }

    private char randomElement(char[] cs) {
        return cs[rand.nextInt(cs.length)];
    }

    public void run() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Get ready to play Boggle!");
            System.out.println("Letters to choose from:");
            for (char c : letters) {
                System.out.printf("%s ", c);
            }
            System.out.println();
            while (true) {
                System.out.print("Enter a word or -1 to quit: ");
                String input = scan.nextLine();
                if (input.equals("-1")) {
                    break;
                } else if (input.length() >= 3 && input.length() <= 8) {
                    entries.add(new Entry(input, letters));
                } else {
                    System.out.println("Entries must be at least 3 letters long and no more than 8.");
                }
            }

            int earned = 0, lost = 0, total = 0;
            for (Entry e : entries) {
                earned += e.getEarned();
                lost -= e.getLost();
                total += e.getPoints();
                System.out.printf("%-6s | %2d\n", e.getWord(), e.getPoints());
            }

            System.out.printf("Points earned: %d\n", earned);
            System.out.printf("Points lost: %d\n", lost);
            System.out.printf("Points total: %d\n", total);
        } finally {
            scan.close();
        }
    }

    private char probLetter() {
        double val = rand.nextDouble();
        double running = 0.0;
        for (int i = 0; i < Words.PROBABILITY.length; i++) {
            running += Words.PROBABILITY[i];
            if (val < running) {
                return Words.ALPHABET[i];
            }
        }
        return probLetter();
    }
}
