@startuml

class Library {
    - id: int
    - name: String
    - location: String
    - librarian: String
    - books: List<Book>
    + addBook(book: Book): void
    + removeBook(book: Book): void
}

class Patron {
    - id: int
    - name: String
    - address: String
    - email: String
    + borrowBook(book: Book): void
    + returnBook(book: Book): void
}

class Book {
    - isbn: String
    - title: String
    - author: String
    - genre: String
    - publicationYear: int
    - available: boolean
}

class Author {
    - name: String
    - nationality: String
    - birthYear: int
    - booksWritten: List<Book>
}

class Publisher {
    - name: String
    - location: String
    - booksPublished: List<Book>
}

class Genre {
    - name: String
    - description: String
    - booksInGenre: List<Book>
}

Library "1" -- "*" Book : contains
Patron "1" -- "*" Book : borrows
Book "1" -- "1" Author : written by
Book "1" -- "1" Publisher : published by
Book "1" -- "*" Genre : belongs to

@enduml
