public class TundraShelter extends Shelter{

    private static String waterType = "Cool Eutrophic";

    private static String climate = "Polar";

    public TundraShelter(String id, int volume, boolean availability, ShelterType shelterType) {
        super(id, volume, availability);
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
        return "Tundra Shelter\n" +
                super.toStringPrime();
    }
}
