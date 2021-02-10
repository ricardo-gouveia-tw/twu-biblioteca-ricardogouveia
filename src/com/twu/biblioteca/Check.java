package com.twu.biblioteca;

import java.util.ArrayList;

public class Check {
    private ArrayList<Book> bookList;

    public Check(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public CheckResult checkBook(String bookTitle, String operationType) {
        Search search = new Search();
        SearchResponse searchResponse = search.searchByTitle(bookList, bookTitle);

        if (searchResponse.getSearchSuccess() == true) {
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
}

class CheckResult {
    private Boolean checkSuccess = false;
    private ArrayList bookList;

    public CheckResult(Boolean checkSuccess, ArrayList<Book> bookList) {
        this.bookList = bookList;
        this.checkSuccess = checkSuccess;
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
    }
}

