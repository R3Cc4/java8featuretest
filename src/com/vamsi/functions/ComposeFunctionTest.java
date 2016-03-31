package com.vamsi.functions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.vamsi.data.Book;
import com.vamsi.data.BooksList;


public class ComposeFunctionTest {
    
    public ComposeFunctionTest(){
        
    }
    
    
    public static void main(String[] args){
        
        Book book1 = new Book("vamsi", "First Book", "Horror", Calendar.getInstance().getTime());
        Book book2 = new Book("vamsi", "second Book", "Suspense", new Date(Calendar.getInstance().getTimeInMillis()+150000));
        Book book3 = new Book("vamsi", "third Book", "Horror", new Date(Calendar.getInstance().getTimeInMillis()+180000));
        Book book4 = new Book("John", "first Book", "Horror", new Date(Calendar.getInstance().getTimeInMillis()+190000)); 
        Book book13 = new Book("John", "second Book", "Biography", new Date(Calendar.getInstance().getTimeInMillis()+110000));
        Book book5 = new Book("John", "third Book", "Suspense", new Date(Calendar.getInstance().getTimeInMillis()+140000));
        Book book6 = new Book("John", "fourth Book", "Comedy", new Date(Calendar.getInstance().getTimeInMillis()+280000));
        Book book7 = new Book("Smith", "first Book", "Suspense", new Date(Calendar.getInstance().getTimeInMillis()+580000));
        Book book8 = new Book("Smith", "second Book", "Horror", new Date(Calendar.getInstance().getTimeInMillis()+680000));
        Book book9 = new Book("Rajni", "first Book", "Horror", new Date(Calendar.getInstance().getTimeInMillis()+780000));
        Book book10 = new Book("Rajni", "second Book", "Suspense", new Date(Calendar.getInstance().getTimeInMillis()+980000));
        Book book11 = new Book("Rajni", "third Book", "Comedy", new Date(Calendar.getInstance().getTimeInMillis()+1800000));
        Book book12 = new Book("Rajni", "fourth Book", "Horror", new Date(Calendar.getInstance().getTimeInMillis()+1900000));
        
        
        List<Book> bookList = new ArrayList<Book>();
        
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);
        bookList.add(book11);
        bookList.add(book12);
        bookList.add(book13);
        
        BooksList booksList = new BooksList(bookList);
        
        System.out.println("Books Created.");
        
        System.out.println("********************Books IN the LIST***********");
        printList(booksList.getBooks());
        
        BiFunction <String,List<Book>,List<Book>> byAuthor = (name,articles)-> articles.stream()
                                                                                       .filter(a->a.getAuthor().equals(name))
                                                                                       .collect(Collectors.toList());
        //test the byAuthor Fuction.
        System.out.println("---Finding Books by Author-- Vamsi---");
        printList(byAuthor.apply("vamsi", booksList.getBooks()));
        
        
        BiFunction <String,List<Book>,List<Book>>byTag = (tag,articles)-> articles.stream()
                                                                                  .filter(a->a.getTag().equals(tag))
                                                                                  .collect(Collectors.toList());
        //test the byTag Fuction.                                                                       
        System.out.println("---Finding Books by Tag-- Horror---");                                                                       
        printList(byTag.apply("Horror", booksList.getBooks()));
        
        Function<List<Book>,List<Book>> sortByPublished = (articles)->articles.stream()
                                                                              .sorted((x,y)->y.getPublished().compareTo(x.getPublished()))
                                                                              .collect(Collectors.toList());
        //test the sortByPublished Fuction. 
        System.out.println("---Sorting Books by Date----");                                                                       
        printList(sortByPublished.apply( booksList.getBooks()));
        
                                                                              
        Function<List<Book>,Optional<Book>> getFirst = (articles)->articles.stream().findFirst();
        
        //Test the getFirst Function
        System.out.println("---The First Record of the Books List is----");                                                                       
        getFirst.apply(booksList.getBooks()).ifPresent(ComposeFunctionTest::bookprint);
        
        
        //Now Compose complex functions from each.
        
        //Most Recent Book.
        
        Function<List<Book>,Optional<Book>> newestBook = getFirst.compose(sortByPublished);
        
        //test the most recent book function
        System.out.println("---Newest book in the List is----");                                                                       
        newestBook.apply(BooksList.getBooks()).ifPresent(ComposeFunctionTest::bookprint);
         
        // Newest By Author.
         
        BiFunction<String,List<Book>,Optional<Book>> newestByAuthor = byAuthor.andThen(newestBook);
        
        //Test the function newestByAuthor.
        System.out.println("Newest Book of Author Smith is --");
        newestByAuthor.apply("Smith", BooksList.getBooks()).ifPresent(ComposeFunctionTest::bookprint);
        
        //ByAuthor Sorted.
        
        BiFunction<String,List<Book>,List<Book>>byAuthorSorted=byAuthor.andThen(sortByPublished);
        
        //test function byAuthorsorted
        
        System.out.println("List of Books by an Author in sorted order--- latest First");
        
        printList(byAuthorSorted.apply("John",BooksList.getBooks()));
        
        //Newest By Tag.
        
        BiFunction<String,List<Book>,Optional<Book>> newestByTag = byTag.andThen(newestBook);
        
        //Test the Newest by Tag for Suspense
        
        System.out.println("Newest book in Suspense Genre --");
        newestByTag.apply("Suspense", BooksList.getBooks()).ifPresent(ComposeFunctionTest::bookprint);
        
    }
    
   static void printList(List<Book>booksList){
      
       Optional<List<Book>> bookList = Optional.of(booksList);
        bookList.ifPresent(a->a.stream()
                                .forEach(ComposeFunctionTest::bookprint));
        System.out.println("**********************************");      
    }
   static void bookprint(Book a){
       
       
       System.out.println(a.getTitle()+"-"+a.getAuthor()+"-"+a.getTag()+"-"+a.getPublished().toString());
       
   }

}
