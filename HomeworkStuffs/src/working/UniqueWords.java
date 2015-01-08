/**********************************
 * File: UniqueWords.java
 * 
 * Author: Winston Durand
 * Modified: Jan 8, 2015
 **********************************/
package working;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Winston Durand
 */
public class UniqueWords {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        try {
            System.out.print("Please enter some text: ");
            String str = scan.nextLine();
            System.out.println(cheaty(str));
        } finally {
            scan.close();
        }
    }
    
    public static boolean cheaty(String str) {
        List<String> list = new ArrayList<String>();
        for (String word : str.split("\\s+")) {
            list.add(word);
        }
        
        Set<String> words = new HashSet<String>();
        
        for (String word : list) {
            words.add(word);
        }
        
        return words.size() != list.size();
    }
    
    // STDIN.get.chomp.split(/\s/).tap{|w|puts w.uniq==w}

}
