package za.ac.cput.Factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/*LibraryFactoryTest.java
LibraryFactory Test class
Author: Lubabalo Notutela
Date: 22 March 2024
 */

public class LibraryFactoryTest {

    @Test
    public void testCreateLibrary() {
        // Arrange
        LibraryFactory factory = new LibraryFactory();

        // Act
        LibraryFactory.Library library = factory.createLibrary(1, "Main Library", "Main Street", "John Doe");

        // Assert
        assertEquals(1, library.getId());
        assertEquals("Main Library", library.getName());
        assertEquals("Main Street", library.getLocation());
        assertEquals("John Doe", library.getLibrarian());
    }

    @Test
    public void testAddBookToLibrary() {
        // Arrange
        LibraryFactory factory = new LibraryFactory();
        LibraryFactory.Library library = factory.createLibrary(1, "Main Library", "Main Street", "John Doe");
        LibraryFactory.Book book = new LibraryFactory.Book("123", "Java Programming");

        // Act
        library.addBook(book);

        // Assert
        assertEquals(1, library.getBooks().size());
        assertEquals("123", library.getBooks().get(0).getIsbn());
        assertEquals("Java Programming", library.getBooks().get(0).getTitle());
    }
}