package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class WelcomeMessageTest {

    private ByteArrayOutputStream outputConsoleStream;
    private WelcomeMessage welcomeMessage;

    @Test
    public void userWelcomeMessageIsPrinted() {
        outputConsoleStream = new ByteArrayOutputStream();
        PrintStream consoleOutputPrintStream = new PrintStream(outputConsoleStream);
        System.setOut(consoleOutputPrintStream);

        welcomeMessage = new WelcomeMessage();
        welcomeMessage.print();

        assertThat(
                outputConsoleStream.toString(),
                is("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n")
        );
    }
}
