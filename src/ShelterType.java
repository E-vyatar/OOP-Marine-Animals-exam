import java.util.List;

public enum ShelterType {
    COASTAL("Coastal"),
    TUNDRA("Tundra"),
    REEF("Reef");

    public final String label;

    ShelterType(String label) {
        this.label = label;
    }

    public static ShelterType find(String input) {
        for (ShelterType shelterType : ShelterType.values()) {
            if (shelterType.label.equals(input)) {
                return shelterType;
            }
        }
        return null;
    }

    public static String join(CharSequence delimiter, List<ShelterType> lst) {
        String res = "";
        for (int idx = 0; idx < lst.size()-1; ++idx) {
            res += lst.get(idx).label + delimiter;
        }
        res += lst.get(lst.size()-1).label;
        return res;
    }
}
