package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

public class CheckTests {
    private ArrayList<Book> bookList;

    @Before
    public void beforeEachCheckTest() {
        bookList = new ArrayList<Book>();
        ArrayList<String> authorList = new ArrayList<String>();
        authorList.add("author1");
        authorList.add("author2");
        Book testBook = new Book("Test Book", authorList, "2000");
        bookList.add(testBook);
    }

    @Test
    public void checkBookOnBooklist() {
        Check bookChecker = new Check(bookList);
        ArrayList<Book> newBookList = bookChecker.checkBook("Test Book", "out").getBookList();

        Book bookToTest = new Book("");
        for ( Book book : newBookList ) {
            if ( book.getTitle() == "Test Book" ) { bookToTest = book; }
        }

        assertThat(bookToTest.getStatus(), is("checkedOut"));
    }

    @Test
    public void checkBookThatDoesntExistsOnBooklist() {
        Check bookChecker = new Check(bookList);
        CheckResult checkResult = bookChecker.checkBook("Test Book 2", "out");

        assertThat(checkResult.getCheckSuccess(), is(false));
    }
}
