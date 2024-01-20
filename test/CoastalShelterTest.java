import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoastalShelterTest {
    CoastalShelter coastalShelter = new CoastalShelter("a", 500, true, 600, ShelterType.COASTAL);

    @Test
    void getWaterType() {
        assertEquals("Cool Eutrophic", CoastalShelter.getWaterType());
    }

    @Test
    void getClimate() {
        assertEquals("Temperate", CoastalShelter.getClimate());
    }

    @Test
    void testToString() {
        String check = "Coastal Shelter\n" +
                "ID: " + "a" +
                " - Volume: " + 500 + " m3" +
                " - availability: " + true +
                " - Land Surface Area: " + 600 + " m2";

        assertEquals(check, coastalShelter.toString());
    }
}