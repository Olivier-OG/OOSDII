package domein;

public class Ticket implements Kosten {

    private final String omschrijving;
    private double prijs;

    public Ticket(String omschrijving, double prijs) {
        controleerPrijs(prijs);
        setPrijs(prijs);
        this.omschrijving = omschrijving;
    }

    private void controleerPrijs(double prijs) {
        if (prijs <= 0)
            throw new IllegalArgumentException("Prijs moet een strikt positief getal zijn");
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    @Override
    public double berekenPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return String.format("%20s %9.2f", omschrijving, prijs);
    }
}
