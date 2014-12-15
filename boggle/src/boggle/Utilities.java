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
    public static String[] WORDLIST = null;
    
    static {
        try {
            List<String> words = new ArrayList<String>();
            BufferedReader buff = new BufferedReader(new FileReader("src/boggle/words.txt"));
            String line = null;
            while ((line = buff.readLine()) != null) {
                words.add(line);
            }
            buff.close();
            WORDLIST = words.toArray(new String[words.size()]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Crapus. where is the words.txt file?!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
