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
            List<String> list = new ArrayList<String>();
            for (String word : str.split("\\s+")) {
                list.add(word);
            }
            System.out.println(list);
            System.out.println(list);
        } finally {
            scan.close();
        }
    }

    public static boolean cheaty(List<String> list) {
        Set<String> words = new HashSet<String>();

        for (String word : list) {
            words.add(word);
        }

        return words.size() != list.size();
    }

    public static boolean dupe(List<String> list) {
        for (int i = 0; i < (list.size() - 1); i++) {
            for (int j = (i + 1); j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    // STDIN.get.chomp.split(/\s/).tap{|w|puts w.uniq==w}

}
