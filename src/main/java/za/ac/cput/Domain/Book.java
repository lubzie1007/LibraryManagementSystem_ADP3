package za.ac.cput.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*Book.java
Book Model Class
Author: Petlo Jonathan Matabane 220294496
Date: 27 March 2024
 */
public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final String genre;
    private final int publicationYear;
    private final boolean available;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getPublicationYear() == book.getPublicationYear() && isAvailable() == book.isAvailable() && getIsbn().equals(book.getIsbn()) && getTitle().equals(book.getTitle()) && getAuthor().equals(book.getAuthor()) && getGenre().equals(book.getGenre());
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", publicationYear=" + publicationYear +
                ", available=" + available +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbn(), getTitle(), getAuthor(), getGenre(), getPublicationYear(), isAvailable());
    }

    private Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.author = builder.author;
        this.genre = builder.genre;
        this.publicationYear = builder.publicationYear;
        this.available = builder.available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public static class Builder {
        private final String isbn;
        private final String title;
        private String author;
        private String genre;
        private int publicationYear;
        private boolean available;

        public Builder(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder publicationYear(int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public Builder available(boolean available) {
            this.available = available;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

