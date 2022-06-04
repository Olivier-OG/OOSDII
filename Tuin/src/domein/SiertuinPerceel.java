package domein;

import java.util.ArrayList;
import java.util.List;

public class SiertuinPerceel extends TuinPerceel {

    private static final double EXTRA_WAARDE_PERK = 10;
    private final List<String> bloemenperken;
    private final boolean vijverAanwezig;

    public SiertuinPerceel(String perceelsCode, List<String> bloemenperken, boolean vijverAanwezig) {
        this(perceelsCode, DEFAULT_LENGTE_BREEDTE, DEFAULT_LENGTE_BREEDTE, bloemenperken, vijverAanwezig);
    }

    public SiertuinPerceel(String perceelsCode, double lengte, double breedte, List<String> bloemenperken, boolean vijverAanwezig) {
        super(perceelsCode, lengte, breedte);
        if (bloemenperken == null)
            this.bloemenperken = new ArrayList<>();
        else if (bloemenperken.size() > geefOppervlakte())
            throw new IllegalArgumentException("Te veel bloemenperken voor dit perceel");
        else
            this.bloemenperken = bloemenperken;
        this.vijverAanwezig = vijverAanwezig;
    }

    @Override
    public double geefWaarde() {
        return vijverAanwezig ? EXTRA_WAARDE_PERK + bloemenperken.size() : bloemenperken.size();
    }

    public void voegBloemenperkToe(String bloemenperk) {
        bloemenperken.add(bloemenperk);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" %s vijver", vijverAanwezig ? "met" : "zonder");
    }

    public List<String> getBloemenperken() {
        return bloemenperken;
    }

    public boolean isVijverAanwezig() {
        return vijverAanwezig;
    }
}
