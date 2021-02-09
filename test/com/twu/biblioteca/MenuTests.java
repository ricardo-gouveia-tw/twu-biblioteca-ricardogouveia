package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.hamcrest.core.AllOf.allOf;

public class MenuTests {
    private ByteArrayOutputStream outputConsoleStream;

    @Test
    public void showMenu() {
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        Menu menu = new Menu();
        menu.show();

        assertThat(
                outputConsoleStream.toString(),
                allOf(
                        containsString("OPTIONS"),
                        containsString("01 - LIST OF BOOKS"),
                        containsString("99 - QUIT")
                )
        );
    }
}
