package za.ac.cput.Repository;

import za.ac.cput.Domain.Publisher;

import java.util.List;

/**
 * This class represents a PublisherRepository that handles CRUD operations for publishers.
 * It provides the basic CRUD operations for a Publisher.
 * Publisher repository interface
 * Author: Ferdi Davids (220631948)
 * Date: 26 March 2024
 */
public interface PublisherRepository {
    /** This method is used to save a new Publisher.
     * @param publisher This is the Publisher object to be saved.
     * */
    void savePublisher(Publisher publisher);

    /** This method is used to update an existing Publisher.
     * @param publisher This is the Publisher object to be updated.
     */
    void updatePublisher(Publisher publisher);

    /** This method is used to delete a Publisher.
     * @param publisherName This is the name of the Publisher to be deleted.
     */
    void deletePublisher(String publisherName);

    /** This method is used to retrieve a Publisher by its name.
     * @param publisherName This is the name of the Publisher to be retrieved.
     */
    Publisher getPublisherByName(String publisherName);

    /** This method is used to retrieve all Publishers.
     * @return List<Publisher> This returns a list of all Publishers.
     */
    List<Publisher> getAllPublishers();

}