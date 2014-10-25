/****************************
 * File: Stars.java
 * 
 * Author: Winston Durand
 * Modified: Oct 25, 2014
 ***************************/
package Lab7Package;

import java.util.Arrays;

/**
 * Creates the triangles from the 3.12 programming project
 * 
 * @author wmd
 */
public class Stars {

    /**
     * Creates all the triangle configurations for programming problem 3.12
     * 
     * @param args
     */
    public static void main(String[] args) {
        int starCount = 3;
        try {
            System.out.println("a).\n" + triangleLeftDown(starCount));
            System.out.println("\nb).\n" + triangleRightUp(starCount));
            System.out.println("\nc).\n" + triangleRightDown(starCount));
            System.out.println("\nd).\n" + diamond(starCount));
        } catch (InvalidValueException err) {
            System.out.println(err.getMessage());
        }

    }
    
    /**
     * Creates a diamond with the specified width
     * 
     * @param width width of the diamond
     * @return the diamond with asterisks and spaces
     * @throws InvalidValueException width is not an odd positive
     */
    public static String diamond(int width) throws InvalidValueException {
        if (width % 2 != 1) {
            throw new InvalidValueException("'" + width + "' is not valid! Must be a positive odd number!");
        }
        
        int evenHalf = (width - 1) / 2;
        StringBuilder str = new StringBuilder();
        
        for (int i = 0; i < evenHalf; i++) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(repeat(' ', evenHalf - i)).append(repeat('*', i));
            str.append(tmp).append('*').append(tmp.reverse());
            str.append('\n');
        }
        StringBuilder reversed = new StringBuilder(str.reverse());
        str.reverse().append(repeat('*', width)).append(reversed);
        
        return str.toString();
    }
    
    /**
     * Creates a triangle with the specified width with the "legs" on the
     * right and bottom (points upwards)
     * 
     * @param width width of the triangle
     * @return the triangle with asterisks and spaces
     * @throws InvalidValueException width is not a positive
     */
    public static String triangleRightUp(int width) throws InvalidValueException {
        if (width < 0) {
            throw new InvalidValueException("'" + width + "' is not valid! Must be a positive odd number!");
        }
        
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= width; i++) {
            str.append(repeat(' ', width - i)).append(repeat('*', i));
            str.append('\n');
        }
        
        return str.deleteCharAt(str.length() - 1).toString();
    }
    
    /**
     * Creates a triangle with the specified width with the "legs" on the
     * left and top (points downwards)
     * 
     * @param width width of the triangle
     * @return the triangle with asterisks and spaces
     * @throws InvalidValueException width is not a positive
     */
    public static String triangleLeftDown(int width) throws InvalidValueException {
        return new StringBuilder(triangleRightUp(width)).reverse().toString();
    }
    
    /**
     * Creates a triangle with the specified width with the "legs" on the
     * right and top (points downwards)
     * 
     * @param width width of the triangle
     * @return the triangle with asterisks and spaces
     * @throws InvalidValueException width is not a positive
     */
    public static String triangleRightDown(int width) throws InvalidValueException {
        if (width < 0) {
            throw new InvalidValueException("'" + width + "' is not valid! Must be a positive odd number!");
        }
        
        StringBuilder str = new StringBuilder();
        for (int i = width; i >= 1; i--) {
            str.append(repeat(' ', width - i)).append(repeat('*', i));
            str.append('\n');
        }
        
        return str.deleteCharAt(str.length() - 1).toString();
    }
    
    /**
     * Accepts a char and returns a string with it repeated the specified
     * number of times
     * 
     * @param c char to be made in string
     * @param repeat number of times to repeat <code>c</code>
     * @return a string with <code>c</code> repeated <code>repeat</code> times
     */
    private static String repeat(char c, int repeat) {
        char[] chArr = new char[repeat];
        Arrays.fill(chArr, c);
        return new String(chArr);
    }

}
