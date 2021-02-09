package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.AllOf.allOf;


public class PrinterTests {

    private ByteArrayOutputStream outputConsoleStream;

    @Test
    public void printBookList() {
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        Book testBook = new Book("Test Book");
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(testBook);

        Printer printer = new Printer();
        printer.printBookList(bookList);

        assertThat(outputConsoleStream.toString(), is( equalTo("Test Book\n") ));
    }

    @Test
    public void printBookListAsTable() {
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        ArrayList<String> authorList = new ArrayList<String>();
        authorList.add("author1");
        authorList.add("author2");
        Book testBook = new Book("Test Book", authorList, "2000");
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(testBook);

        Book testBook2 = new Book("Test Book 2");
        bookList.add(testBook2);

        Printer printer = new Printer();
        printer.printBookListAsTable(bookList);

        assertThat(outputConsoleStream.toString(), allOf(
                containsString("Test Book"),
                containsString("author1"),
                containsString("author2"),
                containsString("2000"),
                containsString("Test Book 2")
        ));
    }
}
