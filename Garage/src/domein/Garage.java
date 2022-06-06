package domein;

import persistentie.AutoMapper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Garage {

    private final List<Auto> autoLijst;

    public Garage() {
        autoLijst = new AutoMapper().geefLijstVanAutos();
    }


    public List<Auto> getAutoLijst() {
        return autoLijst;
    }


    public void sorteerOpNummerplaat() {
        Collections.sort(autoLijst);
    }


    public void sorteerOpMerk() {
        autoLijst.sort(Comparator.comparing(Auto::getMerk));
    }

    public void sorteerOpMerkEnModel() {
        autoLijst.sort(Comparator.comparing(Auto::getMerk).thenComparing(Auto::getModel));


    }

    public void sorteerOpAantalOnderhoudsbeurtenAflopend() {
        autoLijst.sort(Comparator.comparing(Auto::getAantalOnderhoudsbeurten).reversed());
    }


}
