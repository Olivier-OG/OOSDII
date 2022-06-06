package domein;

public class Gebouw implements Draagbaar {

    private final String naam;
    private final double hoogte;

    public Gebouw(String naam, double hoogte) {
        this.hoogte = hoogte;
        this.naam = naam;
        controleerParams();
    }

    private void controleerParams() {
        if (hoogte < 3)
            throw new IllegalArgumentException("Hoogte is minimum 3");
        if (naam == null || naam.isBlank())
            throw new IllegalArgumentException("Naam mag niet leeg zijn");
    }

    public double getHoogte() {
        return hoogte;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public boolean isDraagbaar() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("Residentie %s met hoogte %.1f is niet draagbaar.", naam, hoogte);
    }
}
