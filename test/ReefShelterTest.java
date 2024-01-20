import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReefShelterTest {

    ReefShelter coastalShelter = new ReefShelter("a", 500, true, 6, ShelterType.REEF);

    @Test
    void getWaterType() {
        assertEquals("Warm Trophic", ReefShelter.getWaterType());
    }

    @Test
    void getClimate() {
        assertEquals("Tropical", ReefShelter.getClimate());
    }

    @Test
    void testToString() {
        String check = "Reef Shelter\n" +
                "ID: " + "a" +
                " - Volume: " + 500 + " m3" +
                " - availability: " + true +
                " - Number Of Unique Coral Types: " + 6;

        assertEquals(check, coastalShelter.toString());
    }
}