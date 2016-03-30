package com.vamsi.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class BooksList {
    
    private static List<Book> books;
    
   public BooksList(List<Book>books){
       this.books = Objects.requireNonNull(books);
       
   }


/** Getter for instance variable 'books'.
 * 
 * <p>TODO Describe and specify range of return value/object
 *            including whether null or an empty object may be returned.</p>
 *
 * @return books.
 */
public static List<Book> getBooks() {
    return books;
}


/** Setter for instance variable 'books'.
 *
 * <p>TODO Describe and specify acceptable values for the input parameter
 *            including whether empty or null objects are acceptable.</p>
 *
 * @param books The books to set.
 */
public static void setBooks(List<Book> books) {
    BooksList.books = books;
}
    
    

}
