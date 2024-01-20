import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class Shelter {

    private String id;

    private  int volume;

    private boolean availability;

    private ShelterType shelterType;

    public Shelter(String id, int volume, boolean availability) {
        this.id = id;
        this.volume = volume;
        this.availability = availability;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isAvailability() {
        return availability;
    }

    public ShelterType getShelterType() {
        return shelterType;
    }

    public void setShelterType(ShelterType shelterType) {
        this.shelterType = shelterType;
    }

    public static List<Shelter> read(File sheltersFile) {
        try {
            Scanner shelterScanner = new Scanner(sheltersFile);
            List<Shelter> shelters = new ArrayList<>();

            String line;
            while (shelterScanner.hasNextLine()) {
                line = shelterScanner.nextLine();
                shelters.add(Shelter.readShelter(line));
            }

            return shelters;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Shelter readShelter(String line) {
        Scanner lineScanner = new Scanner(line);

        ShelterType shelterType = ShelterType.find(lineScanner.next());
        String id = lineScanner.next();
        int volume = lineScanner.nextInt();
        boolean availability = lineScanner.nextBoolean();

        switch (shelterType) {
            case COASTAL:
                int landSurfaceArea = lineScanner.nextInt();
                return new CoastalShelter(id, volume, availability, landSurfaceArea, ShelterType.COASTAL);
            case TUNDRA:
                return new TundraShelter(id, volume, availability, ShelterType.TUNDRA);
            case REEF:
                int numberOfUniqueCoralTypes = lineScanner.nextInt();
                return new ReefShelter(id, volume, availability, numberOfUniqueCoralTypes, ShelterType.REEF);
            default:
                throw new InputMismatchException();
        }

//        if (shelterType.equals("Coastal")) {
//            int landSurfaceArea = lineScanner.nextInt();
//            return new CoastalShelter(id, volume, availability, landSurfaceArea);
//        } else if (shelterType.equals("Tundra")) {
//            return new TundraShelter(id, volume, availability);
//        } else if (shelterType.equals("Reef")) {
//            int numberOfUniqueCoralTypes = lineScanner.nextInt();
//            return new ReefShelter(id, volume, availability, numberOfUniqueCoralTypes);
//        }
//        else {
//            throw new InputMismatchException();
//        }
    }

    @Override
    public String toString() {
        return "Shelter\n" + toStringPrime();
    }

    public String toStringPrime() {
        return "ID: " + id +
                " - Volume: " + volume + " m3" +
                " - availability: " + availability;
    }

    public String className() {
        String res = this.getClass().getSimpleName();
        res = res.substring(0,1).toUpperCase() + res.substring(1).replace("Shelter", "");
        return res;
    }
}
