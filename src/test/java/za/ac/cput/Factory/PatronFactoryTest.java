package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Patron;

import static org.junit.jupiter.api.Assertions.*;

class PatronFactoryTest {

    @Test
    void createPatron() {
        // Test the createPatron factory method
        Patron patron = PatronFactory.createPatron(1, "Ronewa", "10 Dorset Street", "219398208@mycput.ac.za");

        // Check if patron is not null
        assertNotNull(patron);

        // Check if the attributes are set correctly
        assertEquals(1, patron.getId());
        assertEquals("Ronewa", patron.getName());
        assertEquals("10 Dorset Street", patron.getAddress());
        assertEquals("219398208@mycput.ac.za", patron.getEmail());
    }
}
