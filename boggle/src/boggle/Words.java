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
    public static final char[] ALPHABET = new char[26];
    public static final char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    static {
        for (char i = 'a'; i <= 'z'; i++) {
            ALPHABET[i - 'a'] = i;
        }
    }
}
