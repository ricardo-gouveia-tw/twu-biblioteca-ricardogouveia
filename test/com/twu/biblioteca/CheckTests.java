package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CheckTests {
    private ArrayList<Book> bookList;
    private ByteArrayOutputStream outputConsoleStream;
    private Check bookChecker;
    private InputStream inputStream;


    @Before
    public void beforeEachCheckTest() {
        bookList = new ArrayList<Book>();
        ArrayList<String> authorList = new ArrayList<String>();
        authorList.add("author1");
        authorList.add("author2");
        Book testBook = new Book("Test Book 1", authorList, "2000");
        bookList.add(testBook);

        bookChecker = new Check(bookList);
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);
        inputStream = System.in;
    }

    @Test
    public void checkBookOnBooklist() {
        ByteArrayInputStream optionOne = new ByteArrayInputStream("Test Book 1".getBytes(StandardCharsets.UTF_8));
        System.setIn(optionOne);

        CheckResult checkResult = bookChecker.checkBook("out");
        ArrayList<Book> newBookList = checkResult.getBookList();

        Book bookToTest = new Book("");
        for ( Book book : newBookList ) {
            if ( book.getTitle() == "Test Book 1" ) { bookToTest = book; }
        }

        assertThat(bookToTest.getStatus(), is("checkedOut"));
        assertThat(checkResult.getCheckSuccess(), is(true));
        assertThat(checkResult.getResultString(), is("Thank you! Enjoy the book"));
    }

    @Test
    public void checkOutBookThatDoesntExistsOnBooklist() {
        ByteArrayInputStream optionOne = new ByteArrayInputStream("Test Book 2".getBytes(StandardCharsets.UTF_8));
        System.setIn(optionOne);

        CheckResult checkResult = bookChecker.checkBook("out");

        assertThat(checkResult.getCheckSuccess(), is(false));
        assertThat(checkResult.getResultString(), is("Sorry, that book is not available"));
    }

    @Test
    public void checkBookInBooklist() {
        ByteArrayInputStream optionOne = new ByteArrayInputStream("Test Book 1".getBytes(StandardCharsets.UTF_8));
        System.setIn(optionOne);

        CheckResult checkResult = bookChecker.checkBook("in");
        ArrayList<Book> newBookList = checkResult.getBookList();

        Book bookToTest = new Book("");
        for ( Book book : newBookList ) {
            if ( book.getTitle() == "Test Book 1" ) { bookToTest = book; }
        }

        assertThat(bookToTest.getStatus(), is("available"));
        assertThat(checkResult.getCheckSuccess(), is(true));
        assertThat(checkResult.getResultString(), is("Thank you for returning the book"));
    }

    @Test
    public void checkInBookThatDoesntExistsOnBooklist() {
        ByteArrayInputStream optionOne = new ByteArrayInputStream("Test Book 2".getBytes(StandardCharsets.UTF_8));
        System.setIn(optionOne);

        CheckResult checkResult = bookChecker.checkBook("in");

        assertThat(checkResult.getCheckSuccess(), is(false));
        assertThat(checkResult.getResultString(), is("That is not a valid book to return."));
    }
}
