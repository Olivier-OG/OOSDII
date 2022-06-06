package domein;

public class ConcertRegistratie implements Vertoonbaar {

    private final String artiest, concertnaam;

    public ConcertRegistratie(String artiest, String concertnaam) {
        controleerIngevuld(artiest);
        controleerIngevuld(concertnaam);
        this.artiest = artiest;
        this.concertnaam = concertnaam;
    }

    private void controleerIngevuld(String param) {
        if (param == null || param.isBlank())
            throw new IllegalArgumentException("Ongeldige paramter meegegeven");
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getClass().getSimpleName(), concertnaam, artiest);
    }

    @Override
    public int wordtVertoondInZaal() {
        return 2;
    }

    public String getArtiest() {
        return artiest;
    }

    public String getConcertnaam() {
        return concertnaam;
    }

}
