/****************************
 * File: Arrays2D.java
 * 
 * Author: Winston Durand
 * Modified: Dec 18, 2014
 ***************************/
package arrays;

/**
 * @author Winston Durand
 * 
 */
public class Arrays2D extends ArrayMod {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] table = new int[9][9];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = (i + 1) * (j + 1);
            } 
        }
        print(table, new CustomLogic() {
            public boolean call(int param) {
                return true;
            }
        });
        System.out.println();
        print(table, new CustomLogic() {
            public boolean call(int param) {
                return param % 3 == 0;
            }
        });
    }
    
    public static void print(int[][] table, CustomLogic logic) {
        int padding = String.valueOf(table[table.length - 1][table[0].length - 1]).length();
        String strFmt = " %" + padding + "s |";
        String dgtFmt = " %" + padding + "s |";
        String sep = "+";
        for (int i = 0; i < padding + 2; i++) sep = "-" + sep;
        StringBuilder str = new StringBuilder();
        str.append(String.format(strFmt, 'X'));
        for (int i = 1; i <= table.length; i++) {
            str.append(String.format(dgtFmt, i));
        }
        str.append('\n');
        for (int i = 0; i <= table.length; i++) {
            str.append(sep);
        }
        for (int i = 0; i < table[0].length; i++) {
            str.append('\n');
            str.append(String.format(dgtFmt, i + 1));
            for (int j = 0; j < table.length; j++) {
                if (logic.call(table[j][i])) {
                    str.append(String.format(dgtFmt, table[j][i]));
                } else {
                    str.append(String.format(strFmt, ' '));
                }
            }
        }
        System.out.println(str.toString());
    }
}

class CustomLogic {
    public boolean call(int param) {
        return true;
    }
}
