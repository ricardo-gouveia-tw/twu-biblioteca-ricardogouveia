package com.twu.biblioteca;

public class Menu {
    public void Menu() {}

    private String menuString =
            "+-----------------------------------+\n" +
            "|              OPTIONS              |\n" +
            "+-----------------------------------+\n" +
            "|  01 - LIST OF BOOKS               |\n" +
            "|  99 - QUIT                        |\n" +
            "+-----------------------------------+\n";

    public void show() {
        System.out.println(menuString);
    }
}
