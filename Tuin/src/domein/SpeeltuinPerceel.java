package domein;

public class SpeeltuinPerceel extends TuinPerceel {

    private static final double WAARDE = 2.5;

    private final int aantalToestellen;

    public SpeeltuinPerceel(String perceelsCode, int aantalToestellen) {
        this(perceelsCode, DEFAULT_LENGTE_BREEDTE, DEFAULT_LENGTE_BREEDTE, aantalToestellen);
    }

    public SpeeltuinPerceel(String perceelsCode, double lengte, double breedte, int aantalToestellen) {
        super(perceelsCode, lengte, breedte);
        if (aantalToestellen * 3 > geefOppervlakte())
            throw new IllegalArgumentException("Er past niet meer dan 1 toestel per 3 vierkante meter");
        this.aantalToestellen = aantalToestellen;
    }

    @Override
    public double geefWaarde() {
        return aantalToestellen * WAARDE;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" en met %d toestellen om te spelen", aantalToestellen);
    }

    public int getAantalToestellen() {
        return aantalToestellen;
    }
}
