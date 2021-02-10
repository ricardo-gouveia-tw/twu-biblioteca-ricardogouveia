package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Book {
    private String title;
    private ArrayList<String> authors;
    private String yearPublished;
    private String status;

    public Book(String title) {
        this.title = title;
        this.status = "available";
    }

    public Book(String title, ArrayList<String> authors, String yearPublished) {
        this.title = title;
        this.authors = authors;
        this.yearPublished = yearPublished;
        this.status = "available";
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getAuthorsList() {
        return authors;
    }

    public String getYearPublished() {
        if (yearPublished != null) {
            return yearPublished;
        } else { return ""; }
    }

    public String getStatus() {
        return status;
    }

    public String setStatus(String newStatus) {
        String oldStatus = getStatus();
        status = newStatus;
        return "Book " + getTitle() + " was " + oldStatus + " now is " + getStatus();
    }

    public String getAllAuthorsString() {
        String authorsListString = "";

        if (authors != null) {
            for ( Iterator<String> listOfAuthors = authors.iterator(); listOfAuthors.hasNext(); ) {
                String author = listOfAuthors.next();
                authorsListString = authorsListString + author;

                if (listOfAuthors.hasNext()) {
                    authorsListString = authorsListString + ", ";
                }
            }

            return authorsListString;
        } else { return ""; }
    }
}
