package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsNot.*;

public class SearchTest {

    @Test
    public void searchBookInBookList() {
        ArrayList<String> authorList = new ArrayList<String>();
        authorList.add("author1");
        authorList.add("author2");
        Book testBook = new Book("Test Book", authorList, "2000");
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(testBook);

        Search search = new Search();
        SearchResponse foundBook = search.searchByTitle(bookList, "Test Book");

        assertThat(foundBook.getSearchSuccess(), is(true));
        assertThat(foundBook.getBook(), is(testBook));
    }

    @Test
    public void cantFindBookInBooklist() {
        ArrayList<String> authorList = new ArrayList<String>();
        authorList.add("author1");
        authorList.add("author2");
        Book testBook = new Book("Test Book 2", authorList, "2000");
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(testBook);

        Search search = new Search();
        SearchResponse foundBook = search.searchByTitle(bookList, "Test Book");

        assertThat(foundBook.getSearchSuccess(), is(false));
        assertThat(foundBook, is(not(testBook)));
    }
}
