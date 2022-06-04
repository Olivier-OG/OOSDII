package domein;

import persistentie.BeheerskostenMapper;

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
}