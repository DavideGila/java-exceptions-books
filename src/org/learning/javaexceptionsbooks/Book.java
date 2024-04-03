package org.learning.javaexceptionsbooks;

public class Book {
    // ATTRIBUTI
    private String title;
    private int numberOfPages;
    private String author;
    private String publisher;

    // COSTRUTTORI
    public Book(String title, int numberOfPages, String author, String publisher) throws IllegalArgumentException {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("L'autore non può essere vuoto.");
        }
        if (publisher == null || publisher.isEmpty()) {
            throw new IllegalArgumentException("L'editore non può essere vuoto.");
        }
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Il numero di pagine deve essere maggiore di zero.");
        }

        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.publisher = publisher;
    }

    // GETTER E SETTER
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }


    // METODI
}
