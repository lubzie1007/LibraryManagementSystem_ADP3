package za.ac.cput.Repository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Author;

//Author: Muneeb Solomons//
//Date: 26 March 2024//

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AuthorRepositoryTest {

    private iAuthorRepository repository = AuthorRepository.getRepository();

    private Author author;

    @Test
    @Order(1)
    void create() {

        Author created = repository.create(author);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Author read = repository.read(author.getName());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Author newAuthor = new Author.Builder().copy(author).setName("Muneeb Solomons").build();
        Author updated = repository.update(newAuthor);
        assertNotNull(updated);
        System.out.println(updated);
    }


    @Test
    @Order(4)
    void delete() {
        assertTrue(repository.delete(author.getName()));
        System.out.println("Success: employee deleted");
    }

    @Test
    @Order(5)
    void getall() {
        System.out.printf(repository.getall());
    }
}