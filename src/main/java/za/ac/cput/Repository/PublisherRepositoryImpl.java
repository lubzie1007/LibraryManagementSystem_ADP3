package za.ac.cput.Repository;

/* PublisherRepositoryImpl.java
 * This is a PublisherRepositoryImpl class for implementation of the PublisherRepository.java
 * Author: Ferdi Davids (220631948)
 * Date: 26 March 2024
 */

import za.ac.cput.Domain.Publisher;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {
    private List<Publisher> publishers;

    PublisherRepositoryImpl() {
        this.publishers = new ArrayList<>();
    }


    @Override
    public void savePublisher(Publisher publisher) {
        publishers.add(publisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        for (int i = 0; i < publishers.size(); i++) {
            if (publishers.get(i).getPublisherName().equals(publisher.getPublisherName())) {
                publishers.set(i, publisher);
                break;
            }
        }
    }

    @Override
    public void deletePublisher(String publisherName) {
        publishers.removeIf(publisher -> publisher.getPublisherName().equals(publisherName));
    }

    @Override
    public Publisher getPublisherByName(String publisherName) {
        for (Publisher publisher : publishers) {
            if (publisher.getPublisherName().equals(publisherName)) {
                return publisher;
            }
        }
        return null;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return new ArrayList<>(publishers);
    }
}
