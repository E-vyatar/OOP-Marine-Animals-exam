import java.util.Comparator;
import java.util.List;

public class SortShelters implements Comparator<Shelter> {

    private List<ShelterType> shelters;

    public SortShelters(List<ShelterType> shelters) {
        this.shelters = shelters;
    }

    public int compare(Shelter shelter1, Shelter shelter2) {
        int names = shelters.indexOf(shelter1.getShelterType().label) - shelters.indexOf(shelter2.getShelterType().label);
        int volumes = shelter1.getVolume() - shelter2.getVolume();

        if (names == 0) {
            return volumes;
        }
        else {
            return names;
        }
    }
}
