package persistentie;

import domein.SiertuinPerceel;
import domein.SpeeltuinPerceel;
import domein.TuinPerceel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TuinPerceelMapper {

    public List<TuinPerceel> geefTuinPercelen() {
        List<TuinPerceel> tuinpercelen = new ArrayList<>();
        tuinpercelen.add(new SiertuinPerceel("SI001",
                Arrays.asList("Gladiool", "Roos", "Distel"), true));
        tuinpercelen.add(new SiertuinPerceel("SI002", 20, 20,
                Arrays.asList("Gladiool", "Roos", "Distel"), true));
        tuinpercelen.add(new SiertuinPerceel("SI003", 20, 15,
                Arrays.asList("Zonnebloem", "Margriet", "Distel"), false));
        tuinpercelen.add(new SiertuinPerceel("SI004", 3, 3,
                Arrays.asList("Sneeuwvlokje", "Roos", "Tulp"), false));
        tuinpercelen.add(new SpeeltuinPerceel("SP001", 20, 10, 3));

        return tuinpercelen;
    }

}
