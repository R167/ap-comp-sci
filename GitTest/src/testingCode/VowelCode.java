package testingCode;
import java.util.Scanner;

public class VowelCode {
    public static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = null;
        int[] count = new int[vowels.length];
        int y = 0;
        try {
            System.out.print("Enter a string to check for vowels: ");
            input = scan.nextLine();
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
        
        for (int i=0; i<vowels.length; i++) {
            System.out.printf("%s: %d\n", vowels[i], count[i]);
        }
        System.out.println("y: " + y);
        System.out.println("spaces: " + (input.length() - input.replaceAll(" ", "").length()));
        System.out.println("consanants: " + (input.length() - input.replaceAll("[a-zA-Z]", "").length()));
        System.out.println("punctuation: " + (input.length() - input.replaceAll("[a-zA-Z0-9 ]", "").length()));
    }
    
    public static boolean isVowel(String str, int index) {
        if (index < str.length() && index >= 0) {
            char letter = str.toLowerCase().charAt(index);
            if (inList(vowels, letter) > -1) {
                return true;
            } else if (letter == 'y') {
                return !isVowel(str, index + 1) && !isVowel(str, index - 1);
            }
        }
        return false;
    }
    
    public static int inList(char[] ls, char c) {
        for (int i = 0; i < ls.length; i++) {
            if (ls[i] == c) return i;
        }
        return -1;
    }
}
