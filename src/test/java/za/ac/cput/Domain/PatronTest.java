package za.ac.cput.Domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// Ronewa Khashane
// 219398208
public class PatronTest {
    private Patron patron;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        patron = new Patron.Builder(1, "Ronewa")
                .address("10 Dorset Street")
                .email("219398208@mycput.ac.za")
                .build();

        book1 = new Book("ISBN-001", "Book1", "Author1", "Fiction", 2020, true);
        book2 = new Book("ISBN-002", "Book2", "Author2", "Non-fiction", 2019, true);
    }

    @Test
    void testGetId() {
        assertEquals(1, patron.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Alice", patron.getName());
    }

    @Test
    void testGetAddress() {
        assertEquals("10 Dorset Street", patron.getAddress());
    }

    @Test
    void testGetEmail() {
        assertEquals("219398208", patron.getEmail());
    }

    @Test
    void testBorrowBook() {
        patron.borrowBook(book1);
        patron.borrowBook(book2);

        List<Book> borrowedBooks = patron.getBorrowedBooks();

        assertTrue(borrowedBooks.contains(book1));
        assertTrue(borrowedBooks.contains(book2));
    }

    @Test
    void testReturnBook() {
        patron.borrowBook(book1);
        patron.borrowBook(book2);

        patron.returnBook(book1);

        List<Book> borrowedBooks = patron.getBorrowedBooks();

        assertFalse(borrowedBooks.contains(book1));
        assertTrue(borrowedBooks.contains(book2));
    }
}
