package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Check {
    private ArrayList<Book> bookList;

    public Check(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public CheckResult checkBook(String operationType) {
        System.out.println("\n ENTER BOOK TITLE: ");
        Scanner userOptionInput = new Scanner(System.in);
        String bookTitle =  userOptionInput.nextLine();

        Search search = new Search();
        SearchResponse searchResponse = search.searchByTitle(bookList, bookTitle);

        if (searchResponse.getSearchSuccess() == true && checkIfAvailableBook(searchResponse.getBook())) {
            Book bookFound = changeBookStatus(
                    searchResponse.getBook(),
                    operationType
            );

            ArrayList<Book> newBookList = bookList;
            for (Book book: newBookList) {
                if (book.getTitle() == bookTitle) { book = bookFound; }
            }

            CheckResult checkResult = new CheckResult(true, newBookList);
            return checkResult;
        } else {
            CheckResult checkResult = new CheckResult(false, bookList);
            //System.out.println(checkResult.getCheckSuccess() + checkResult.getResultString());
            return checkResult;
        }
    }

    private Book changeBookStatus(Book book, String operationType) {
        switch (operationType) {
            case "in":
                book.setStatus("available");
                return book;
            case "out":
                book.setStatus("checkedOut");
                return book;
            default:
                return book;
        }
    }

    private Boolean checkIfAvailableBook(Book book) {
        return book.getStatus() == "available";
    }
}

class CheckResult {
    private Boolean checkSuccess = false;
    private ArrayList bookList;
    private String resultString;

    public CheckResult(Boolean checkSuccess, ArrayList<Book> bookList) {
        this.bookList = bookList;
        this.checkSuccess = checkSuccess;
        setResultString();
    }

    public ArrayList getBookList() {
        return bookList;
    }

    public void setBookList(ArrayList bookList) {
        this.bookList = bookList;
    }

    public Boolean getCheckSuccess() {
        return checkSuccess;
    }

    public void setCheckSuccess(Boolean checkSuccess) {
        this.checkSuccess = checkSuccess;
        setResultString();
    }

    public String getResultString() {
        return resultString;
    }

    private void setResultString() {
        if (checkSuccess == true) {
            resultString = "Thank you! Enjoy the book";
        }
        else { resultString = "Sorry, that book is not available"; }
    }
}

