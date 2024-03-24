package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Library;

import static org.junit.jupiter.api.Assertions.*;

/*LibraryRepositoryImplTest.java
LibraryRepository Test class
Author: Lubabalo Notutela
Date: 22 March 2024
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LibraryRepositoryImplTest {

    @Test
    @Order(1)
    void saveLibrary() {
        // Arrange
        LibraryRepositoryImpl repository = new LibraryRepositoryImpl();
        Library library = new Library.Builder(1, "Main Library")
                .location("Main Street")
                .librarian("John Doe")
                .build();

        // Act
        repository.saveLibrary(library);

        // Assert
        Library savedLibrary = repository.getLibraryById(1);
        assertNotNull(savedLibrary);
        assertEquals(1, savedLibrary.getId());
        assertEquals("Main Library", savedLibrary.getName());
        assertEquals("Main Street", savedLibrary.getLocation());
        assertEquals("John Doe", savedLibrary.getLibrarian());
    }

    @Test
    @Order(2)
    void updateLibrary() {
        // Arrange
        LibraryRepositoryImpl repository = new LibraryRepositoryImpl();
        Library originalLibrary = new Library.Builder(1, "Main Library")
                .location("Main Street")
                .librarian("John Doe")
                .build();
        repository.saveLibrary(originalLibrary);

        // Act
        Library updatedLibrary = new Library.Builder(1, "Updated Library")
                .location("New Street")
                .librarian("Jane Smith")
                .build();
        repository.updateLibrary(updatedLibrary);

        // Assert
        Library retrievedLibrary = repository.getLibraryById(1);
        assertNotNull(retrievedLibrary);
        assertEquals(1, retrievedLibrary.getId());
        assertEquals("Updated Library", retrievedLibrary.getName());
        assertEquals("New Street", retrievedLibrary.getLocation());
        assertEquals("Jane Smith", retrievedLibrary.getLibrarian());
    }

    @Test
    @Order(3)
    void deleteLibrary() {
        // Arrange
        LibraryRepositoryImpl repository = new LibraryRepositoryImpl();
        Library library = new Library.Builder(1, "Main Library")
                .location("Main Street")
                .librarian("John Doe")
                .build();
        repository.saveLibrary(library);

        // Act
        repository.deleteLibrary(1);

        // Assert
        Library deletedLibrary = repository.getLibraryById(1);
        assertNull(deletedLibrary);
    }

    @Test
    @Order(4)
    void getLibraryById() {
        // Test getLibraryById method
    }

    @Test
    @Order(5)
    void getAllLibraries() {
        // Test getAllLibraries method
    }
}
