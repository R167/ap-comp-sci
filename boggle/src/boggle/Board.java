/****************************
 * File: Board.java
 * 
 * Author: Winston Durand
 * Modified: Dec 14, 2014
 ***************************/
package boggle;

import java.util.Random;

/**
 * @author Winston Durand
 * 
 */
public class Board {
    private char[] letters = null;
    private Random rand = new Random();
    
    public Board() {
        this(10);
    }

    public Board(int len) {
        letters = new char[len];
        for (int i = 0; i < letters.length; i++) {
            letters[i] = randomElement(i < 4 ? Words.ALPHABET : Words.ALPHABET);
        }
    }

    private char randomElement(char[] cs) {
        return cs[rand.nextInt(cs.length)];
    }
    
    public void run() {
        
    }
}
