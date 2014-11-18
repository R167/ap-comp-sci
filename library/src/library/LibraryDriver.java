/**********************************
 * File: LibraryDriver.java
 * 
 * Author: Winston Durand
 * Modified: Nov 18, 2014
 **********************************/
package library;

/**
 * @author Winston Durand
 */
public class LibraryDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Library ourLibrary = new Library("Miramonte Library");
        ourLibrary.createBook("Godel Esher Bach", "Some Guy");
        System.out.println("Books:");
        System.out.println(ourLibrary.getBookList());
        System.out.println(ourLibrary.findBook("godel esher bach"));
        System.out.println(ourLibrary.findBook("godel esher back"));
    }

}
