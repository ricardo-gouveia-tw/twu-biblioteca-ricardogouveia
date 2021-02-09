package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp appInstance = new BibliotecaApp();
        appInstance.run();
    }

    public void run() {
        WelcomeMessage welcomeUserMessage = new WelcomeMessage();
        welcomeUserMessage.print();

        ArrayList<Book> bookList = createBookList();
        Printer printer = new Printer();
        printer.printBookListAsTable(bookList);
    }

    private ArrayList<Book> createBookList() {
        ArrayList<Book> bookList = new ArrayList<Book>();

        ArrayList<String> harryPotterAuthorsList = new ArrayList<String>();
        harryPotterAuthorsList.add("J. K. Rowling");
        Book harryPotter = new Book("Harry Potter and the Deadly Hallows", harryPotterAuthorsList, "2007");

        ArrayList<String> eloquentJavascriptAuthorsList = new ArrayList<String>();
        eloquentJavascriptAuthorsList.add("Marijn Haverbeke");
        Book eloquentJavascript = new Book("Eloquent Javascript", eloquentJavascriptAuthorsList, "2011");

        ArrayList<String> northernLightsAuthorsList = new ArrayList<String>();
        northernLightsAuthorsList.add("Philip Pullman");
        Book northernLights = new Book("Northern Lights", northernLightsAuthorsList, "1995");

        ArrayList<String> chroniclesOfNarniaAuthorsList = new ArrayList<String>();
        chroniclesOfNarniaAuthorsList.add("C. S. Lewis");
        Book chroniclesOfNarnia = new Book("The Chronicles of Narnia", chroniclesOfNarniaAuthorsList, "1950");

        ArrayList<String> theLastAirbenderAuthorsList = new ArrayList<String>();
        theLastAirbenderAuthorsList.add("Michael Dante DiMartino");
        theLastAirbenderAuthorsList.add("Bryan Konietzko");
        Book theLastAirbender = new Book("Avatar: The Last Airbender", theLastAirbenderAuthorsList, "2005");

        Book maybeImWrong = new Book("Maybe I'm Wrong");


        bookList.add(harryPotter);
        bookList.add(eloquentJavascript);
        bookList.add(northernLights);
        bookList.add(chroniclesOfNarnia);
        bookList.add(theLastAirbender);
        bookList.add(maybeImWrong);

        return bookList;
    }

}
