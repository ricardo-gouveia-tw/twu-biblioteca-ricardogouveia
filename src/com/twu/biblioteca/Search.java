package com.twu.biblioteca;

import java.util.ArrayList;

public class Search {

    public Search() {}

    public SearchResponse searchByTitle(ArrayList<Book> bookList, String searchString) {
        SearchResponse result = new SearchResponse(false);

        for (Book book : bookList) {
            if ( searchString.contains( book.getTitle() ) ) {
                result.setSearchSuccess(true);
                result.setBook(book);
            }
        }

        return result;
    }
}

class SearchResponse {
    public SearchResponse(Boolean searchSuccess) {
        this.searchSuccess = searchSuccess;
    }

    private Boolean searchSuccess;
    private Book book;

    public Boolean getSearchSuccess() {
        return searchSuccess;
    }

    public void setSearchSuccess(Boolean searchSuccess) {
        this.searchSuccess = searchSuccess;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book responseBook) {
        this.book = responseBook;
    }
}