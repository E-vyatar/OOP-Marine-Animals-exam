import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    Animal animal = new Animal("a", 400, Arrays.asList(ShelterType.TUNDRA, ShelterType.REEF));
    @Test
    void getName() {
        assertEquals("a", animal.getName());
    }

    @Test
    void getPossibleShelters() {
        assertEquals(Arrays.asList("Tundra", "Reef"), animal.getPossibleShelters());
    }

    @Test
    void getVolume() {
        assertEquals(400, animal.getVolume());
    }

    @Test
    void testToString() {
        String check = "a" + " - " +
                "Requires: " + 400 + " m3" +
                " - Preferred shelter: Tundra, Reef";

        assertEquals(check, animal.toString());
    }
}