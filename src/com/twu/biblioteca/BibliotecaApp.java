package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp appInstance = new BibliotecaApp();
        appInstance.run();
    }

    public void run() {
        WelcomeMessage welcomeUserMessage = new WelcomeMessage();

        welcomeUserMessage.print();
    }
}
