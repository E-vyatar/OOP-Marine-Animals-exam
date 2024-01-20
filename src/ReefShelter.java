public class ReefShelter extends Shelter{

    private static String waterType = "Warm Trophic";

    private static String climate = "Tropical";

    private int numberOfUniqueCoralTypes;

    public ReefShelter(String id, int volume, boolean availability, int numberOfUniqueCoralTypes, ShelterType shelterType) {
        super(id, volume, availability);
        this.numberOfUniqueCoralTypes = numberOfUniqueCoralTypes;
        this.setShelterType(shelterType);
    }

    public static String getWaterType() {
        return waterType;
    }

    public static String getClimate() {
        return climate;
    }

    @Override
    public String toString() {
        return "Reef Shelter\n" +
                super.toStringPrime() +
                " - Number Of Unique Coral Types: " + numberOfUniqueCoralTypes;
    }
}
