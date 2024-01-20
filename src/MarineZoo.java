import java.io.File;
import java.util.*;

public class MarineZoo {

    private List<Shelter> shelters;

    private List<Animal> animals;

    public MarineZoo() {

    }

    public void setShelters(List<Shelter> shelters) {
        this.shelters = shelters;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public static MarineZoo read(File sheltersFile, File animalsFile) {
        MarineZoo marineZoo = new MarineZoo();

        marineZoo.setShelters(Shelter.read(sheltersFile));
        marineZoo.setAnimals(Animal.read(animalsFile));

        return marineZoo;
    }

    public void showAllShelters() {
        for (Shelter shelter : shelters) {
            System.out.println(shelter.toString());
        }
    }

    public void showAllAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    public void sheltersSuitableForAnimal(Scanner inputScanner, boolean favorite) {
        System.out.println("Choose an animal: ");
        for (int i = 0; i < animals.size(); ++i) {
            System.out.println(i+1 + " - " + animals.get(i).getName());
        }

        Animal animal = animals.get(inputScanner.nextInt() - 1);

        List<Shelter> wantedShelters = new ArrayList<>();
        for (Shelter shelter : shelters) {
            if (animal.getPossibleShelters().contains(shelter.getShelterType().label)) {
                wantedShelters.add(shelter);
            }
        }

        System.out.println();

        if (favorite) {
            Collections.sort(wantedShelters, new SortShelters(animal.getPossibleShelters()));
            wantedShelters = wantedShelters.stream()
                    .filter(shelter -> shelter.isAvailability())
                    .filter(shelter -> shelter.getVolume() >= animal.getVolume())
                    .toList();

            wantedShelters.forEach(System.out::println);
        }
        else {
            wantedShelters.forEach(System.out::println);
        }

    }

    public void shelterProperties(Scanner inputScanner) {
        System.out.println("""
                Choose shelter type:
                1 - Coastal
                2 - Tundra
                3 - Reef
                """);

        int choice = inputScanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Coastal Shelter\n" +
                        CoastalShelter.getWaterType() + " Water - " +
                        CoastalShelter.getClimate() + " Climate");
                break;
            case 2:
                System.out.println("Tundra Shelter\n" +
                        TundraShelter.getWaterType() + " Water - " +
                        TundraShelter.getClimate() + " Climate");
                break;
            case 3:
                System.out.println("Reef Shelter\n" +
                        ReefShelter.getWaterType() + " Water - " +
                        ReefShelter.getClimate() + " Climate");
                break;
        }
    }
}
