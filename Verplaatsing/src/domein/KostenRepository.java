package domein;

import persistentie.KostenMapper;

import java.util.ArrayList;
import java.util.List;

public class KostenRepository {

    private final List<Kosten> kosten;

    public KostenRepository() {
        kosten = new ArrayList<>(new KostenMapper().geefKostenLijst());
    }

    public String geefOverzichtAantalDocumenten() {
        int ticket = 0, auto = 0, ov = 0;
        for (Kosten k : kosten)
            if (k instanceof Ticket)
                ticket++;
            else if (k instanceof VerplaatsingPerAuto)
                auto++;
            else if (k instanceof VerplaatsingPerBusTram)
                ov++;
        return String.format("Volgende documenten werden ingediend:%n%d ticket(s), %d verplaatsing(en) per auto, %d verplaatsing(en) per bus/tram.",
                ticket, auto, ov);
    }

    public String geefKostenLijst() {
        StringBuilder overzichtKosten = new StringBuilder(String.format("%s%n%n%70s %15s%n", "Overzicht gemaakte kosten:", "Kostenpost", "Bedrag"));
        double totaal = 0;
        for (Kosten k : kosten) {
            if (k instanceof Ticket t)
                overzichtKosten.append(String.format("%70s %15s%n", t.getOmschrijving(), t.berekenPrijs()));
            else if (k instanceof Verplaatsing v)
                overzichtKosten.append(
                        String.format("%70s %15.2f%n", v, totaal += v.berekenPrijs() * 0.79));
        }
        overzichtKosten.append(String.format("%nTotaal gedeclareerde kosten = %.2f", totaal));
        return overzichtKosten.toString();
    }

}
