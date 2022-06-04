package domein;

public class Kluis implements Beheerskost {

    private static final double JAARLIJKSE_KOST = 29;

    private final String houder;
    private final int kluisnummer;

    public Kluis(String houder, int kluisnummer) {
        this.houder = houder;
        this.kluisnummer = kluisnummer;
    }

    @Override
    public String toString() {
        return String.format("%d %s", kluisnummer, houder);
    }

    @Override
    public double geefJaarlijkseKost() {
        return JAARLIJKSE_KOST;
    }

    public int getKluisnummer() {
        return kluisnummer;
    }

    public String getHouder() {
        return houder;
    }
}
