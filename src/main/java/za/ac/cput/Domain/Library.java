package za.ac.cput.Domain;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

/*Library.java
Library model class
Author: Lubabalo Notutela
Date: 22 March 2024
 */

public class Library {
    private final int id;
    private final String name;
    private final String location;
    private final String librarian;
    private final List<Book> books;

    private Library(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.location = builder.location;
        this.librarian = builder.librarian;
        this.books = builder.books;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getLibrarian() {
        return librarian;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public static class Builder {
        private final int id;
        private final String name;
        private String location;
        private String librarian;
        private List<Book> books;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
            this.books = new ArrayList<>();
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder librarian(String librarian) {
            this.librarian = librarian;
            return this;
        }

        public Builder addBook(Book book) {
            this.books.add(book);
            return this;
        }

        public Library build() {
            return new Library(this);
        }
    }
}

