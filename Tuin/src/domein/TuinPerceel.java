package domein;

import java.util.Objects;

public abstract class TuinPerceel {

    public static final int DEFAULT_LENGTE_BREEDTE = 5;

    private final String perceelsCode;
    private final double lengte, breedte;

    public TuinPerceel(String perceelsCode, double lengte, double breedte) {
        controleerLengteEnBreedte(lengte, breedte);
        this.lengte = lengte;
        this.breedte = breedte;
        this.perceelsCode = perceelsCode;
    }

    private void controleerLengteEnBreedte(double lengte, double breedte) {
        if (lengte < 1 || breedte < 1)
            throw new IllegalArgumentException("Lengte en breedte moeten strikt positief zijn");
        if (lengte < breedte)
            throw new IllegalArgumentException("Lengte moet groter dan of gelijk aan breedte zijn");
    }

    public double geefOppervlakte() {
        return lengte * breedte;
    }

    @Override
    public String toString() {
        return String.format("%s van %.1f op %.1f met een waarde van %.2f", getClass().getSimpleName(), lengte, breedte, geefWaarde());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TuinPerceel tp)) return false;
        return Objects.equals(perceelsCode, tp.perceelsCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perceelsCode);
    }

    public abstract double geefWaarde();

    public double getBreedte() {
        return breedte;
    }

    public double getLengte() {
        return lengte;
    }

    public String getPerceelsCode() {
        return perceelsCode;
    }
}
