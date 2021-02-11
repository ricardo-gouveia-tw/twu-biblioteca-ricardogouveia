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

        if (searchResponse.getSearchSuccess() == true) {
            Book foundBook = searchResponse.getBook();

            if (operationType == "out" && checkBookStatus(foundBook, "available")) {
                foundBook = changeBookStatus( foundBook, operationType );

            } else if (operationType == "in" && checkBookStatus(foundBook, "checkedOut")) {
                foundBook = changeBookStatus( foundBook, operationType );

            } else {
                CheckResult checkResult = new CheckResult(false, bookList, operationType);
                return checkResult;
            }

            ArrayList<Book> newBookList = bookList;
            for (Book book: newBookList) {
                if (book.getTitle() == bookTitle) { book = foundBook; }
            }

            CheckResult checkResult = new CheckResult(true, newBookList, operationType);
            return checkResult;
        } else {
            CheckResult checkResult = new CheckResult(false, bookList, operationType);
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

    private Boolean checkBookStatus(Book book, String statusToCheck) {
        return book.getStatus() == statusToCheck;
    }
}

class CheckResult {
    private Boolean checkSuccess = false;
    private ArrayList bookList;
    private String resultString;
    private String operationType;

    public CheckResult(Boolean checkSuccess, ArrayList<Book> bookList, String operationType) {
        this.operationType = operationType;
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

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getResultString() {
        return resultString;
    }

    private void setResultString() {
        if (operationType == "out") {
            if (checkSuccess == true) { resultString = "Thank you! Enjoy the book"; }
            else { resultString = "Sorry, that book is not available"; }
        } else if (operationType == "in") {
            if (checkSuccess == true) { resultString = "Thank you for returning the book"; }
            else { resultString = "That is not a valid book to return."; }
        }
    }
}

