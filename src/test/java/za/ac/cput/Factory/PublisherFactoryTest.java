package za.ac.cput.Factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Book;
import za.ac.cput.Domain.Publisher;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/* PublisherFactoryTest.java
 * This class contains test cases for the PublisherFactory class to ensure proper creation of Publisher objects.
 * Author: Ferdi Davids (220631948)
 * Author: Ferdi Davids (220631948)
 * Date: 26 March 2024
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PublisherFactoryTest {
    @Test
    @Order(1)
    void createPublisher_withValidData_shouldReturnPublisher() {
        List<Book> booksPublished = new ArrayList<>();
        booksPublished.add(new Book("Book Title", "Author"));
        Publisher publisher = PublisherFactory.createPublisher("Publisher Name", "Location", booksPublished);
        assertNotNull(publisher);
        assertEquals("Publisher Name", publisher.getPublisherName());
        assertEquals("Location", publisher.getPublisherLocation());
        assertEquals(1, publisher.getBooksPublished().size());
    }

    @Test
    @Order(2)
    void createPublisher_withEmptyPublisherName_shouldReturnPublisherWithEmptyName() {
        List<Book> booksPublished = new ArrayList<>();
        Publisher publisher = PublisherFactory.createPublisher("", "Location", booksPublished);
        assertNotNull(publisher);
        assertEquals("", publisher.getPublisherName());
        assertEquals("Location", publisher.getPublisherLocation());
        assertEquals(0, publisher.getBooksPublished().size());
    }

    @Test
    @Order(3)
    void createPublisher_withNullPublisherName_shouldThrowException() {
        List<Book> booksPublished = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> {
            Publisher publisher = PublisherFactory.createPublisher(null, "Location", booksPublished);
        });
    }

    @Test
    @Order(4)
    void createPublisher_withNullBookList_shouldReturnPublisherWithEmptyBookList() {
        Publisher publisher = PublisherFactory.createPublisher("Publisher Name", "Location", null);
        assertNotNull(publisher);
        assertEquals("Publisher Name", publisher.getPublisherName());
        assertEquals("Location", publisher.getPublisherLocation());
        assertEquals(0, publisher.getBooksPublished().size());
    }
}