import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TundraShelterTest {

    TundraShelter coastalShelter = new TundraShelter("a", 500, true, ShelterType.TUNDRA);

    @Test
    void getWaterType() {
        assertEquals("Cool Eutrophic", TundraShelter.getWaterType());
    }

    @Test
    void getClimate() {
        assertEquals("Polar", TundraShelter.getClimate());
    }

    @Test
    void testToString() {
        String check = "Tundra Shelter\n" +
                "ID: " + "a" +
                " - Volume: " + 500 + " m3" +
                " - availability: " + true;

        assertEquals(check, coastalShelter.toString());
    }
}