package domein;

import java.util.ArrayList;
import java.util.List;

public class Tuin {
    private final List<TuinPerceel> tuinPercelen;


    public Tuin(List<TuinPerceel> tuinPercelen) {
        this.tuinPercelen = new ArrayList<>(tuinPercelen);
    }

    public List<SiertuinPerceel> geefAlleSiertuinPercelen() {
        List<SiertuinPerceel> lijst = new ArrayList<>();
        for (TuinPerceel tp : tuinPercelen)
            if (tp instanceof SiertuinPerceel stp)
                lijst.add(stp);
        return lijst;
    }

    public void voegPerceelToe(TuinPerceel tp) {
        if (tuinPercelen.contains(tp))
            throw new IllegalArgumentException("Tuinperceel bestaat reeds");
        tuinPercelen.add(tp);
    }

    public int geefAantalPercelen() {
        return tuinPercelen.size();
    }

    public double geefTotaleWaardePercelen() {
        return tuinPercelen.stream().mapToDouble(TuinPerceel::geefWaarde).sum();
    }

}
