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

        if (authors.size() > 0 ) {
            summaryString = summaryString + " of ";
            for ( Iterator<String> listOfAuthors = authors.iterator(); listOfAuthors.hasNext(); ) {
                String author = listOfAuthors.next();
                summaryString = summaryString + author;

                if (listOfAuthors.hasNext()) {
                    summaryString = summaryString + ", ";
                }
            }
        }

        if (yearPublished != "") {
            summaryString = summaryString + " published on " + yearPublished;
        }

        return summaryString;
    }

    public String getTitle() {
        return title;
    }
}
