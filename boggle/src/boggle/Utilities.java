/****************************
 * File: Utilities.java
 * 
 * Author: Winston Durand
 * Modified: Dec 14, 2014
 ***************************/
package boggle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Winston Durand
 * 
 */
public final class Utilities {
    // The word list to be used
    public static String[] WORDLIST = null;
    
    static {
        try {
            List<String> words = new ArrayList<String>();
            // reads a file that is composed of words
            BufferedReader buff = new BufferedReader(new FileReader("src/boggle/words.txt"));
            String line = null;
            // adds words while there are still lines to be read
            while ((line = buff.readLine()) != null) {
                words.add(line);
            }
            buff.close();
            // converts to a String array from an arraylist
            WORDLIST = words.toArray(new String[words.size()]);
        } catch (FileNotFoundException e) {
            // Runs this if there is no words.txt file
            e.printStackTrace();
            System.out.println("Crapus. Where is the words.txt file?!");
            System.exit(1);
        } catch (IOException e) {
            // Catches an error if file read badly
            e.printStackTrace();
            System.out.println("Crapus. Something broke?!");
            System.exit(1);
        }
        
    }
}
