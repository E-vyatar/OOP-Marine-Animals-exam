public class CoastalShelter extends Shelter{

    private static String waterType = "Cool Eutrophic";

    private static String climate = "Temperate";

    private int landSurfaceArea;


    public CoastalShelter(String id, int volume, boolean availability, int landSurfaceArea, ShelterType shelterType) {
        super(id, volume, availability);
        this.landSurfaceArea = landSurfaceArea;
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
        return "Coastal Shelter\n" +
                super.toStringPrime() +
                " - Land Surface Area: " + landSurfaceArea + " m2";
    }
}
