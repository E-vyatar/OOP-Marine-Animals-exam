import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Animal {

    private String name;

    private int volume;

    private List<ShelterType> possibleShelters;

    public Animal(String name, int volume, List<ShelterType> possibleShelters) {
        this.name = name;
        this.volume = volume;
        this.possibleShelters = possibleShelters;
    }

    public String getName() {
        return name;
    }

    public List<ShelterType> getPossibleShelters() {
        return possibleShelters;
    }

    public int getVolume() {
        return volume;
    }

    public static List<Animal> read(File animalsFile) {
        try {
            Scanner animalScanner = new Scanner(animalsFile);
            List<Animal> shelterAnimals = new ArrayList<>();

            String line;
            while (animalScanner.hasNextLine()) {
                line = animalScanner.nextLine();
                shelterAnimals.add(Animal.readAnimal(line));
            }

            return shelterAnimals;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Animal readAnimal(String line) {
        try {
            Scanner lineScanner = new Scanner(line).useDelimiter("; ");

            String name = lineScanner.next();
            int volume = lineScanner.nextInt();
            List<ShelterType> possibleShelters = Arrays.asList(lineScanner.next().split(", "))
                    .stream()
                    .map(shelter -> ShelterType.find(shelter))
                    .toList();

            return new Animal(name, volume, possibleShelters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + " - " +
                "Requires: " + volume + " m3" +
                " - Preferred shelter: " + ShelterType.join(", ", possibleShelters);
    }
}
