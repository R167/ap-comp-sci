/****************************
 * File: VowelCode.java
 * 
 * Author: Winston Durand
 * Modified: Oct 20, 2014
 ***************************/

package testingCode;

import java.util.Scanner;

/**
 * @author Winston Durand
 */
public class VowelCode {
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    public static final int MAXYS = 3;

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
            if (isVowel(input, i)) {
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

    public static boolean isVowel(String str, int index, int depth) throws java.io.IOException {
        if (index < str.length() && index >= 0) {
            char letter = str.charAt(index);
            if (inList(VOWELS, letter) > -1) {
                return true;
            } else if (letter == 'y') {
                if (depth > MAXYS - 2) throw new java.io.IOException("Too many 'y's. Char " + index); // avoid infinite recursion
                return !isVowel(str, index + 1, depth + 1) && !isVowel(str, index - 1, depth + 1);
            }
        }
        return false;
    }
    
    public static boolean isVowel(String str, int index) throws java.io.IOException {
        return isVowel(str, index, 0);
    }

    public static int inList(char[] ls, char c) {
        for (int i = 0; i < ls.length; i++) {
            if (ls[i] == c) return i;
        }
        return -1;
    }
}
