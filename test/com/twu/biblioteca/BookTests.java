package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookTests {
    private Book book;

    @Test
    public void getBookTitle() {
        book = new Book("title");

        assertEquals( "title", book.getTitle() );
    }

    @Test
    public void getBookSummary() {
        ArrayList<String> authorsList = new ArrayList<String>();
        authorsList.add("author 1");
        authorsList.add("author 2");

        book = new Book("title", authorsList, "2001");

        assertEquals(
                // "Book title of author1, author2 published on 2001\n",
                "Book title published on 2001",
                book.getSummary()
        );
    }
}
