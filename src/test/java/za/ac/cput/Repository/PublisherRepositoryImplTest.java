/* PublisherRepositoryImplTest.java
Publisher repository test class
Author: Ferdi Davids (220631948)
Date: 26 March 2024
 */
package za.ac.cput.Repository;

import org.junit.jupiter.api.*;
import za.ac.cput.Domain.Publisher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is used to test the PublisherRepositoryImpl class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PublisherRepositoryImplTest {
    private PublisherRepositoryImpl publisherRepository;

    /**
     * This method sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        publisherRepository = new PublisherRepositoryImpl();
    }

    /**
     * This test checks if a Publisher can be saved to the repository.
     */
    @Test
    @Order(1)
    void savePublisher_withValidPublisher_shouldAddPublisherToList() {
        Publisher publisher = new Publisher.Builder("Publisher Name", "Location").build();
        publisherRepository.savePublisher(publisher);

        List<Publisher> publishers = publisherRepository.getAllPublishers();
        assertTrue(publishers.contains(publisher));
    }

    /**
     * This test checks if an existing Publisher can be updated in the repository.
     */
    @Test
    @Order(2)
    void updatePublisher_withExistingPublisher_shouldUpdatePublisherInList() {
        Publisher publisher = new Publisher.Builder("Publisher Name", "Location").build();
        publisherRepository.savePublisher(publisher);

        Publisher updatedPublisher = new Publisher.Builder("Publisher Name", "New Location").build();
        publisherRepository.updatePublisher(updatedPublisher);

        Publisher retrievedPublisher = publisherRepository.getPublisherByName("Publisher Name");
        assertEquals("New Location", retrievedPublisher.getPublisherLocation());
    }

    /**
     * This test checks if an existing Publisher can be deleted from the repository.
     */
    @Test
    @Order(3)
    void deletePublisher_withExistingPublisher_shouldRemovePublisherFromList() {
        Publisher publisher = new Publisher.Builder("Publisher Name", "Location").build();
        publisherRepository.savePublisher(publisher);

        publisherRepository.deletePublisher("Publisher Name");

        Publisher retrievedPublisher = publisherRepository.getPublisherByName("Publisher Name");
        assertNull(retrievedPublisher);
    }

    /**
     * This test checks if a Publisher can be retrieved by its name from the repository.
     */
    @Test
    @Order(4)
    void getPublisherByName_withExistingPublisher_shouldReturnPublisher() {
        Publisher publisher = new Publisher.Builder("Publisher Name", "Location").build();
        publisherRepository.savePublisher(publisher);

        Publisher retrievedPublisher = publisherRepository.getPublisherByName("Publisher Name");

        assertEquals(publisher, retrievedPublisher);
    }

    /**
     * This test checks if a Publisher that does not exist returns null when retrieved by its name from the repository.
     */
    @Test
    @Order(6)
    void getPublisherByName_withNonExistingPublisher_shouldReturnNull() {
        Publisher retrievedPublisher = publisherRepository.getPublisherByName("Non Existing Publisher");
        assertNull(retrievedPublisher);
    }

    /**
     * This test checks if all Publishers can be retrieved from the repository.
     */
    @Test
    @Order(5)
    void getAllPublishers_withExistingPublishers_shouldReturnListOfPublishers() {
        Publisher publisher1 = new Publisher.Builder("Publisher Name 1", "Location 1").build();
        Publisher publisher2 = new Publisher.Builder("Publisher Name 2", "Location 2").build();
        publisherRepository.savePublisher(publisher1);
        publisherRepository.savePublisher(publisher2);

        List<Publisher> publishers = publisherRepository.getAllPublishers();

        assertTrue(publishers.contains(publisher1));
        assertTrue(publishers.contains(publisher2));
    }
}