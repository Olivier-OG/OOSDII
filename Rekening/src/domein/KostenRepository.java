package domein;

import persistentie.BeheerskostenMapper;

import java.util.ArrayList;
import java.util.List;

public class KostenRepository {
    private final List<Beheerskost> kosten;

    public KostenRepository() {
        kosten = new BeheerskostenMapper().geefBeheerskosten();
    }

    public Beheerskost geefBeheerskost(int index) {
        return kosten.get(index);
    }

    public List<Beheerskost> getKosten() {
        return kosten;
    }

    public List<Rekening> getRekeningen() {
        List<Rekening> rekeningen = new ArrayList<>();
        for (Beheerskost kost : kosten)
            if (kost instanceof Rekening rekening)
                rekeningen.add(rekening);
        return rekeningen;
    }
}