package com.codeup.reviewlister;

// ------------------  THE BEAN  ------------------- //

public class Quote {

    // All the things included in each Quote object
    private String quote;
    private String author;
    private long id;

    // Constructor with id, quote, and author.  For retrieving quotes.
    public Quote(long id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }
    // Constructor with quote, author.  User made quotes, seeder made quotes.
    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    // Getters and Setters for:
    // Quotes
    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
    // Authors
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    // IDs
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
