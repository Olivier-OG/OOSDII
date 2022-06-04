package domein;


import java.time.LocalDate;
import java.util.Objects;

public class Film {

    public final static int MIN_JAAR = 1900, HUIDIG_JAAR = LocalDate.now().getYear();
    public final static int MIN_STERREN = 0, MAX_STERREN = 5;

    private String naam;
    private int jaar, sterren;

    public Film(String naam, int jaar, int sterren) {
        setNaam(naam);
        setJaar(jaar);
        setSterren(sterren);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %d - %d", getClass().getSimpleName(), naam, sterren, jaar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film film)) return false;
        return jaar == film.jaar && Objects.equals(naam, film.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, jaar);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isBlank())
            throw new IllegalArgumentException("Naam mag niet leeg zijn");
        this.naam = naam;
    }

    public int getJaar() {
        return jaar;
    }

    public void setJaar(int jaar) {
        System.out.println(jaar);
        if (jaar > HUIDIG_JAAR || jaar < MIN_JAAR)
            throw new IllegalArgumentException(String.format("Jaar moet in het interval [%d, %d] liggen", MIN_STERREN, MAX_STERREN));
        this.jaar = jaar;
    }

    public int getSterren() {
        return sterren;
    }

    public void setSterren(int sterren) {
        if (sterren > MAX_STERREN || sterren < MIN_STERREN)
            throw new IllegalArgumentException(String.format("Sterren moet in het interval [%d, %d] liggen", MIN_STERREN, MAX_STERREN));
        this.sterren = sterren;
    }
}


