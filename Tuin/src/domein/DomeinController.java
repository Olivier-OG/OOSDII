package domein;

import java.util.List;

public class DomeinController {

    private final TuinPerceelRepository tuinPerceelRepo;
    private Tuin tuin;

    public DomeinController() {
        this.tuinPerceelRepo = new TuinPerceelRepository();
    }

    public void maakTuin() {
        tuin = new Tuin(tuinPerceelRepo.geefTuinPercelen());
    }

    public List<String> geefAlleSiertuinpercelen() {
        return tuin.geefAlleSiertuinPercelen().stream().map(SiertuinPerceel::toString).toList();
    }

    public void voegPerceelToe(TuinPerceel tp) {
        tuin.voegPerceelToe(tp);
    }

    public int geefAantalPercelen() {
        return tuin.geefAantalPercelen();
    }

    public double geefTotaleWaardePercelen() {
        return tuin.geefTotaleWaardePercelen();
    }
}
