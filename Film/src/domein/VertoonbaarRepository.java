package domein;

import persistentie.VertoonbaarMapper;

import java.util.ArrayList;
import java.util.List;

public class VertoonbaarRepository {

    private final List<Vertoonbaar> voorstellingen;

    public VertoonbaarRepository() {
        voorstellingen = new ArrayList<>(new VertoonbaarMapper().geefAlleVoorstellingen());
    }

    public void voegVoorstellingToe(Vertoonbaar v) {
        if (voorstellingen.contains(v))
            throw new IllegalArgumentException(v.getClass().getSimpleName() + " is reeds aanwezig");
        voorstellingen.add(v);
    }

    public int geefAantalInZaal(int zaalnr) {
        return (int) voorstellingen.stream().filter(v -> v.wordtVertoondInZaal() == zaalnr).count();
    }

    public List<Vertoonbaar> getVoorstellingen() {
        return voorstellingen;
    }

}
