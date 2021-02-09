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
}
