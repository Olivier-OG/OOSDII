package persistentie;

import domein.Film;
import domein.Vertoonbaar;

import java.util.ArrayList;
import java.util.List;

public class VertoonbaarMapper {

    public List<Vertoonbaar> geefAlleVoorstellingen() {

        List<Vertoonbaar> voorstellingen = new ArrayList<>();

        voorstellingen.add(new Film("film A", 2020, 5));
        voorstellingen.add(new Film("film B", 2018, 3));

        return voorstellingen;
    }
}
