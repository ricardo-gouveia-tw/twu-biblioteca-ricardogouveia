package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Iterator;

public class Book {
    private String title;
    private ArrayList<String> authors;
    private String yearPublished;

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, ArrayList<String> authors, String yearPublished) {
        this.title = title;
        this.authors = authors;
        this.yearPublished = yearPublished;
    }

    public String getSummary() {
        String summaryString = "Book ";

        summaryString = summaryString + title;

        if (authors != null) {
            summaryString = summaryString + " of " + returnAllAuthorsString(authors);
        }

        if (yearPublished != null) {
            summaryString = summaryString + " published on " + yearPublished;
        }

        return summaryString;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getAuthorsList() {
        return authors;
    }

    public String getAllAuthorsString() {
        return returnAllAuthorsString(getAuthorsList());
    }

    public String getYearPublished() {
        return yearPublished;
    }

    private String returnAllAuthorsString(ArrayList<String> authorsList) {
        String authorsListString = "";

        for ( Iterator<String> listOfAuthors = authorsList.iterator(); listOfAuthors.hasNext(); ) {
            String author = listOfAuthors.next();
            authorsListString = authorsListString + author;

            if (listOfAuthors.hasNext()) {
                authorsListString = authorsListString + ", ";
            }
        }

        return authorsListString;
    }
}
