package domein;

import persistentie.TuinPerceelMapper;

import java.util.List;

public class TuinPerceelRepository {

    public List<TuinPerceel> geefTuinPercelen() {
        return new TuinPerceelMapper().geefTuinPercelen();
    }

}
