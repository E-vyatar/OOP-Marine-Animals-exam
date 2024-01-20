import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelterTest {

    CoastalShelter coastalShelter = new CoastalShelter("a", 500, true, 600, ShelterType.COASTAL);

    @Test
    void getVolume() {
        assertEquals(500, coastalShelter.getVolume());
    }

    @Test
    void isAvailability() {
        assertEquals(true, coastalShelter.isAvailability());
    }

    @Test
    void toStringPrime() {
        String check = "ID: " + "a" +
                " - Volume: " + 500 + " m3" +
                " - availability: " + true;

        assertEquals(check, coastalShelter.toStringPrime());
    }
}