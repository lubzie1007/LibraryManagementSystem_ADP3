package za.ac.cput.Factory;

import za.ac.cput.Domain.Book;
import za.ac.cput.Domain.Publisher;

import java.util.List;

/*PublisherFactory.java
 * This class contains test cases for the PublisherFactory class to ensure proper creation of Publisher objects.
 * Author: Ferdi Davids (220631948)
 * Date: 26 March 2024
 */

public class PublisherFactory {
    public static Publisher createPublisher(String publisherName, String publisherLocation, List<Book> booksPublished) {
        return new Publisher.Builder(publisherName, publisherLocation)
                .setBooksPublished(booksPublished)
                .build();
    }
}
