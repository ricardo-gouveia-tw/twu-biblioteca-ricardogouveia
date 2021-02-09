package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Printer {
    public void Printer() {}

    public void printBookList(ArrayList<Book> bookList) {
        for (Iterator<Book> listOfBooks = bookList.iterator(); listOfBooks.hasNext(); ) {
            Book book = listOfBooks.next();
            System.out.println(book.getTitle());
        }
    }

    public void printBookListAsTable(ArrayList<Book> bookList) {


        // Print the list objects in tabular format.
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%7s %30s %30s", "TITLE", "AUTHOR(S)", "YEAR OF PUBLICATION");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for(Book book: bookList){
            System.out.format("%7s %30s %30s",
                    book.getTitle(), book.getAllAuthorsString(), book.getYearPublished());
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
}
