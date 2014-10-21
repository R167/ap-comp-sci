/****************************
 * File: VowelCode.java
 * 
 * Author: Winston Durand
 * Modified: Oct 20, 2014
 ***************************/

package testingCode;

import java.util.Scanner;

/**
 * Checks for vowels in user input
 * 
 * @author Winston Durand
 */
public class VowelCode {
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    public static final int MAXYS = 3;

    /**
     * Asks the user to enter a string. Counts up the number of vowels
     * in the input and returns the total count of it all. Also prints
     * out the spaces, consonants, and punctuation.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = null;
        int[] count = new int[VOWELS.length];
        int y = 0;
        try {
            System.out.print("Enter a string to check for vowels: ");
            input = scan.nextLine().toLowerCase();
        } finally {
            scan.close();
        }

        for (int i = 0; i < input.length(); i++) {
            try {
            if (isVowel(input, i, 0)) {
                char cur = input.charAt(i);
                if (cur != 'y') {
                    count[inList(VOWELS, cur)] += 1;
                } else {
                    y += 1;
                }
            }
            } catch (java.io.IOException err) {
                System.out.println(err.getMessage() + " Ignoring...");
            }
        }

        int vowelCount = y;
        for (int i=0; i<VOWELS.length; i++) {
            System.out.printf("%s: %d\n", VOWELS[i], count[i]);
            vowelCount += count[i];
        }
        System.out.println("y: " + y);
        System.out.println("spaces: " + (input.length() - input.replaceAll("\\s", "").length()));
        System.out.println("consonants: " + (input.length() - input.replaceAll("[a-z]", "").length() - vowelCount));
        System.out.println("punctuation: " + (input.replaceAll("[a-z0-9\\s]", "").length()));
    }

    /**
     * Recursively checks if a char at index in str in a vowel
     * 
     * @param str string
     * @param index index of string
     * @param depth current recursive depth
     * @return if index is a vowel
     * @throws java.io.IOException recursion of y was too deep
     */
    public static boolean isVowel(String str, int index, int depth) throws java.io.IOException {
        if (index < str.length() && index >= 0) {
            char letter = str.charAt(index);
            if (inList(VOWELS, letter) > -1) {
                return true;
            } else if (letter == 'y') {
                if (depth > MAXYS - 1) throw new java.io.IOException("Too many 'y's. Char " + index); // avoid infinite recursion
                return !isVowel(str, index + 1, depth + 1) && !isVowel(str, index - 1, depth + 1);
            }
        }
        return false;
    }

    /**
     * Checks if a char is in a char array
     * 
     * @param ls char array to check against
     * @param c char to check
     * @return if c is in ls
     */
    public static int inList(char[] ls, char c) {
        for (int i = 0; i < ls.length; i++) {
            if (ls[i] == c) return i;
        }
        return -1;
    }
}
