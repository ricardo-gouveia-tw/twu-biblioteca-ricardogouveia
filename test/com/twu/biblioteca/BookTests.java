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
    public void getBookSummaryOnlyWithTitle() {
        book = new Book("title");

        assertEquals(
                "Book title",
                book.getSummary()
        );
    }

    @Test
    public void getBookSummaryWithAllFields() {
        ArrayList<String> authorsList = new ArrayList<String>();
        authorsList.add("author1");
        authorsList.add("author2");

        book = new Book("title", authorsList, "2001");

        assertEquals(
                // "Book title of author1, author2 published on 2001\n",
                "Book title of author1, author2 published on 2001",
                book.getSummary()
        );
    }
}
