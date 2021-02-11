package com.twu.biblioteca;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.AllOf.allOf;

public class MenuTests {
    private ByteArrayOutputStream outputConsoleStream;

    @Test
    public void showOptions() {
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        Menu menu = new Menu();
        menu.showOptions();

        assertThat(
                outputConsoleStream.toString(),
                allOf(
                        containsString("OPTIONS"),
                        containsString("01 - LIST OF BOOKS"),
                        containsString("02 - CHECKOUT A BOOK"),
                        containsString("03 - RETURN A BOOK"),
                        containsString("99 - QUIT")
                )
        );
    }

    @Test
    public void getUserOption() {
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        InputStream inputStream = System.in;
        ByteArrayInputStream optionOne = new ByteArrayInputStream("01".getBytes(StandardCharsets.UTF_8));
        System.setIn(optionOne);

        Menu menu = new Menu();
        menu.getUserOption();

        assertThat(
                outputConsoleStream.toString(),
                allOf(
                        containsString("ENTER OPTION NUMBER: ")
                )
        );
    }
}
