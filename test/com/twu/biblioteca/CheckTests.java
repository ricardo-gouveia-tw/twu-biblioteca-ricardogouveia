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
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        InputStream inputStream = System.in;
        ByteArrayInputStream optionOne = new ByteArrayInputStream("Test Book".getBytes(StandardCharsets.UTF_8));
        System.setIn(optionOne);

        ArrayList<Book> newBookList = bookChecker.checkBook("out").getBookList();

        Book bookToTest = new Book("");
        for ( Book book : newBookList ) {
            if ( book.getTitle() == "Test Book" ) { bookToTest = book; }
        }

        assertThat(bookToTest.getStatus(), is("checkedOut"));
    }

    @Test
    public void checkBookThatDoesntExistsOnBooklist() {
        Check bookChecker = new Check(bookList);
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        InputStream inputStream = System.in;
        ByteArrayInputStream optionOne = new ByteArrayInputStream("Tesb Book 2".getBytes(StandardCharsets.UTF_8));
        System.setIn(optionOne);

        CheckResult checkResult = bookChecker.checkBook("out");

        assertThat(checkResult.getCheckSuccess(), is(false));
    }
}
