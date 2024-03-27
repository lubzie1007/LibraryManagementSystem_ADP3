package za.ac.cput.Factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Author;

import static org.junit.jupiter.api.Assertions.*;

//Author: Muneeb Solomons//
//Date: 26 March 2024//

class AuthorFactoryTest {

    @Test
    void testBuildEmployer() {
        Author e = AuthorFactory.buildAuthor();

        assertNotNull(e);
        System.out.println(e.toString());
    }
    @Test
    void testBuildEmployeeWithFail() {
        Author e = AuthorFactory.buildAuthor();

        assertNotNull(e);
        System.out.println(e.toString());
    }
}