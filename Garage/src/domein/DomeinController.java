package domein;

import java.util.List;

public class DomeinController {
    private final Garage garage;

    public DomeinController() {
        garage = new Garage();
    }

    public String geefAutoOpNummerplaat() {
        garage.sorteerOpNummerplaat();
        List<Auto> autos = garage.getAutoLijst();
        return zetOmNaarString(autos);
    }

    public String geefAutoOpMerk() {
        garage.sorteerOpMerk();
        List<Auto> autos = garage.getAutoLijst();
        return zetOmNaarString(autos);
    }

    public String geefAutoOpMerkEnModel() {
        garage.sorteerOpMerkEnModel();
        List<Auto> autos = garage.getAutoLijst();
        return zetOmNaarString(autos);
    }

    public String geefAutoOpAantalOnderhoudsbeurtenAflopend() {
        garage.sorteerOpAantalOnderhoudsbeurtenAflopend();
        List<Auto> autos = garage.getAutoLijst();
        return zetOmNaarString(autos);
    }

    private String zetOmNaarString(List<Auto> autos) {
        StringBuilder tekstueel = new StringBuilder();
        for (Auto auto : autos)
            tekstueel.append(String.format("%s%n", auto));
        return tekstueel.toString();
    }

}
