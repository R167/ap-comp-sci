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
    public static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = null;
        int[] count = new int[vowels.length];
        int y = 0;
        try {
            System.out.print("Enter a string to check for vowels: ");
            input = scan.nextLine().toLowerCase();
        } finally {
            scan.close();
        }

        for (int i = 0; i < input.length(); i++) {
            if (isVowel(input, i)) {
                char cur = input.charAt(i);
                if (cur != 'y') {
                    count[inList(vowels, cur)] += 1;
                } else {
                    y += 1;
                }
            }
        }

        int vowelCount = y;
        for (int i=0; i<vowels.length; i++) {
            System.out.printf("%s: %d\n", vowels[i], count[i]);
            vowelCount += count[i];
        }
        System.out.println("y: " + y);
        System.out.println("spaces: " + (input.length() - input.replaceAll("\\s", "").length()));
        System.out.println("consonants: " + (input.length() - input.replaceAll("[a-z]", "").length() - vowelCount));
        System.out.println("punctuation: " + (input.replaceAll("[a-z0-9\\s]", "").length()));
    }

    public static boolean isVowel(String str, int index, int depth) {
        if (index < str.length() && index >= 0) {
            char letter = str.charAt(index);
            if (inList(vowels, letter) > -1) {
                return true;
            } else if (letter == 'y' && depth < 10) { // Prevent stack overflows
                return !isVowel(str, index + 1, depth + 1) && !isVowel(str, index - 1, depth + 1);
            }
        }
        return false;
    }
    
    public static boolean isVowel(String str, int index) {
        return isVowel(str, index, 0);
    }

    public static int inList(char[] ls, char c) {
        for (int i = 0; i < ls.length; i++) {
            if (ls[i] == c) return i;
        }
        return -1;
    }
}
