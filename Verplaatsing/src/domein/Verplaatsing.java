package domein;

public class Verplaatsing implements Kosten {
    private String van;
    private String naar;
    private double aantalKm;

    public Verplaatsing(String van, String naar, double aantalKm) {
        setVan(van);
        setNaar(naar);
        setAantalKm(aantalKm);
    }

    public String getVan() {
        return van;
    }

    public final void setVan(String van) {
        if (van == null || van.equals(""))
            throw new IllegalArgumentException
                    ("Vertrekplaats (van) moet ingevuld worden!");
        this.van = van;
    }

    public String getNaar() {
        return naar;
    }

    public final void setNaar(String naar) {
        if (naar == null || naar.equals(""))
            throw new IllegalArgumentException
                    ("Aankomstplaats (naar) moet ingevuld worden!");
        this.naar = naar;
    }

    public double getAantalKm() {
        return aantalKm;
    }

    public final void setAantalKm(double aantalKm) {
        if (aantalKm <= 0)
            throw new IllegalArgumentException("Aantalkm moet groter dan 0 zijn!");
        this.aantalKm = aantalKm;
    }

    @Override
    public String toString() {
        return String.format("verplaatsing van %s naar %s", van, naar);
    }

    @Override
    public double berekenPrijs() {
        return 0;
    }
}
