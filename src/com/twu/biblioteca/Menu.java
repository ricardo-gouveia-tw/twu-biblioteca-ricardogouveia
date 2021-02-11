package com.twu.biblioteca;

import java.util.Scanner;

public class Menu {
    public void Menu() {}

    private String dashedSeparator = "+-----------------------------------+\n";

    private String menuString =
            dashedSeparator +
            "|              OPTIONS              |\n" +
            dashedSeparator +
            "|  01 - LIST OF BOOKS               |\n" +
            "|  02 - CHECKOUT A BOOK             |\n" +
            "|  99 - QUIT                        |\n" +
            dashedSeparator;

    public void showOptions() {
        System.out.println(menuString);
    }

    public String getUserOption() {
        System.out.println("\n ENTER OPTION NUMBER: ");
        Scanner userOptionInput = new Scanner(System.in);

        String optionSelected =  userOptionInput.nextLine().toString();

        switch (optionSelected) {
            case "01":
                System.out.println("SELECTED: 01 - LIST OF BOOKS");
                return "01";

            case "02":
                System.out.println("SELECTED: 02 - CHECKOUT A BOOK");
                return "02";

            case "99":
                System.out.println("SELECTED: 99 - QUIT");
                return "99";

            default:
                System.out.println("PLEASE SELECT A VALID OPTION!");
                return "00";
        }
    }
}
