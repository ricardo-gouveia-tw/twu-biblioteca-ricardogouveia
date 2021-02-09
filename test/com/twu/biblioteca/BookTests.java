package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

public class BookTests {
    private Book book;

    @Test
    public void getBookTitle() {
        book = new Book("title");

        assertThat( book.getTitle(), is("title") );
    }

    @Test
    public void getYearPublished() {
        book = new Book("title");

        assertThat( book.getTitle(), is("title") );
    }

    @Test
    public void getAuthorsList() {
        ArrayList<String> bookAuthorsList = new ArrayList<String>();
        bookAuthorsList.add("author1");
        bookAuthorsList.add("author2");
        Book book = new Book("title", bookAuthorsList, "2000");

        assertThat(book.getAuthorsList(), is(bookAuthorsList));
    }

    @Test
    public void getAllAuthorsString() {
        ArrayList<String> bookAuthorsList = new ArrayList<String>();
        bookAuthorsList.add("author1");
        bookAuthorsList.add("author2");
        Book book = new Book("title", bookAuthorsList, "2000");

        assertThat(book.getAllAuthorsString(), is("author1, author2"));
    }

    @Test
    public void getBookSummaryOnlyWithTitle() {
        book = new Book("title");

        assertThat( book.getSummary(), is("Book title") );
    }

    @Test
    public void getBookSummaryWithAllFields() {
        ArrayList<String> authorsList = new ArrayList<String>();
        authorsList.add("author1");
        authorsList.add("author2");

        book = new Book("title", authorsList, "2001");

        assertThat(
                book.getSummary(), is("Book title of author1, author2 published on 2001")
        );
    }
}
