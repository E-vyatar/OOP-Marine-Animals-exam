import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MarineZooTest {

    private MarineZoo marineZoo;

    @BeforeEach
    void setUp() {
        marineZoo = new MarineZoo();

        List<Shelter> shelt = new ArrayList<>();
        shelt.add(new CoastalShelter("a", 500, true, 300, ShelterType.COASTAL));
        shelt.add(new TundraShelter("b", 600, true, ShelterType.TUNDRA));
        shelt.add(new ReefShelter("c", 700, true, 4, ShelterType.REEF));
        marineZoo.setShelters(shelt);

        List<Animal> animals = new ArrayList<>();
        List<ShelterType> sh = new ArrayList<>(Arrays.asList(ShelterType.TUNDRA, ShelterType.REEF));
        animals.add(new Animal("d", 550, sh));
        animals.add(new Animal("e", 470, sh));
    }

    @org.junit.jupiter.api.Test
    void setShelters() {
        marineZoo.setShelters(Arrays.asList(new CoastalShelter("a", 500, true, 300, ShelterType.COASTAL)));

    }

    @org.junit.jupiter.api.Test
    void setAnimals() {
    }

    @org.junit.jupiter.api.Test
    void showAllShelters() {
    }

    @org.junit.jupiter.api.Test
    void showAllAnimals() {
    }

    @org.junit.jupiter.api.Test
    void sheltersSuitableForAnimal() {
    }

    @org.junit.jupiter.api.Test
    void shelterProperties() {
    }
}