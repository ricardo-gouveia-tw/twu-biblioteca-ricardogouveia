package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

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
        assertEquals(

                "Welcome to Bangalore Public Library Management System!\n",
                outputConsoleStream.toString()
        );

    }
}
