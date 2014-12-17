/****************************
 * File: Words.java
 *
 * Author: Winston Durand
 * Modified: Dec 14, 2014
 ***************************/
package boggle;

/**
 * @author Winston Durand
 *
 */
public class Words {
    // the letters
    public static final char[] ALPHABET = new char[26];
    // all vowels
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
    // gets the word list
    public static final String[] WORDS = Utilities.WORDLIST;
    // probability of letters
    public static final double[] PROBABILITY = {0.10656619418454816, 0.026612135133620932, 0.0356490559695221, 0.03478626253571629, 0.10480699198834668, 0.014549834724634433, 0.026186340971482997, 0.02878592638243039, 0.06781892542999608, 0.004431620819093506, 0.01886380189366351, 0.05726371225278727, 0.032069023474704465, 0.05831699254860216, 0.06462546921396156, 0.02969914280912096, 0.0016303434366070927, 0.07010476777410499, 0.05328029581489159, 0.055504510056585805, 0.04592414140848227, 0.009742842736287748, 0.014471398957924814, 0.004168300745139784, 0.028976413244439465, 0.005165555493304947};

    /**
     * checks if the word is in the WORDS array by a
     * binary search
     * @param word word to search for
     * @return if it is in the array
     */
    public static int hasWord(String word) {
        int min = 0;
        int max = WORDS.length - 1;
        while (min <= max) {
            int pivot = min + (max - min) / 2;
            int compared = word.compareTo(WORDS[pivot]);
            if (compared < 0) {
                max = pivot - 1;
            } else if (compared > 0) {
                min = pivot + 1;
            } else {
                return pivot;
            }
        }
        return -1;
    }
    
    /**
     * normalizes the string
     * @param str a string
     * @return lowercase without spaces
     */
    public static String sanatize(String str) {
        return str.trim().toLowerCase();
    }

    static {
        // initializes the alphabet
        for (char i = 'a'; i <= 'z'; i++) {
            ALPHABET[i - 'a'] = i;
        }
        // ensures that the alphabet is the same length as probability
        if (ALPHABET.length != PROBABILITY.length) {
            System.out.println("ALPHABET and PROBABILITY must be same length!");
            System.exit(1);
        }
    }
}
