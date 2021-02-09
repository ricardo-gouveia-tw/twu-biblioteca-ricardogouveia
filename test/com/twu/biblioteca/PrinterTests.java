package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;


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
}
