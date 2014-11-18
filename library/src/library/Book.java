/**********************************
 * File: Book.java
 * 
 * Author: Winston Durand
 * Modified: Nov 17, 2014
 **********************************/
package library;

/**
 * @author Winston Durand
 */
public class Book {
    private String author = null;
    private String title = null;
    
    public Book(String title, String author) {
        super();
        this.author = author;
        this.title = title;
    }
    
    public String toString() {
        return String.format("Title: %s | Author: %s", title, author);
    }
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
