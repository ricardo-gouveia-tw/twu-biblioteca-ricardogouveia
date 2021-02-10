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
        String separatorDashes = "-----------------------------------------------------------------------------------------------------------";

        System.out.println(separatorDashes);
        System.out.println("\n Listing all books in Library:");
        System.out.println(separatorDashes);
        System.out.printf("%35s %45s %25s", "TITLE", "AUTHOR(S)", "YEAR OF PUBLICATION");
        System.out.println();
        System.out.println(separatorDashes);

        for (Book book: bookList) {
            if ( book.getStatus() == "available" ) {
                System.out.format(
                        "%35s %45s %25s",
                        book.getTitle(),
                        book.getAllAuthorsString(),
                        book.getYearPublished()
                );
                System.out.println();
            }
        }

        System.out.println(separatorDashes);    }

}
