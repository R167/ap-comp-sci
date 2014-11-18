/**********************************
 * File: Library.java
 * 
 * Author: Winston Durand
 * Modified: Nov 17, 2014
 **********************************/
package library;

import java.util.HashMap;

/**
 * @author Winston Durand
 */
public class Library {
    private String name = null;
    private HashMap<String, Book> books = new HashMap<String, Book>();
    
    public Library(String libraryName) {
        this.name = libraryName;
    }
    
    public void createBook(String bookTitle, String bookAuthor) {
        books.put(bookTitle.toLowerCase(), new Book(bookTitle, bookAuthor));
    }
    
    public String getName() {
        return name;
    }
    
    public String getBookList() {
        StringBuilder str = new StringBuilder();
        for (Book book : books.values()) {
            str.append(book.getTitle()).append("\n");
        }
        return str.toString();
    }
    
    public String findBook(String title) {
        return books.getOrDefault(title.toLowerCase(), new Book("N/A", "N/A")).toString();
    }
}
