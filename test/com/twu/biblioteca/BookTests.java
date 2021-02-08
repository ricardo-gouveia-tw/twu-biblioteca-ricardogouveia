package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTests {
    private Book book;

    @Test
    public void getBookTitle() {
        book = new Book("title");

        assertEquals( "title", book.getTitle() );
    }
}
