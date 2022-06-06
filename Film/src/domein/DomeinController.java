package domein;

import java.util.List;

public class DomeinController {

    private final VertoonbaarRepository vertoonbaarRepo;


    public DomeinController() {
        vertoonbaarRepo = new VertoonbaarRepository();
    }


    public List<String> geefAlleVoorstellingen() {
        return vertoonbaarRepo.getVoorstellingen().stream().map(Vertoonbaar::toString).toList();

    }

    public void voegVoorstellingToe(String[] infoVoorstelling) {
        if (infoVoorstelling.length == 3) {
            int jaar = Integer.parseInt(infoVoorstelling[1]);
            int sterren = Integer.parseInt(infoVoorstelling[2]);
            vertoonbaarRepo.voegVoorstellingToe(new Film(infoVoorstelling[0], jaar, sterren));
        } else if (infoVoorstelling.length == 2) {
            vertoonbaarRepo.voegVoorstellingToe(new ConcertRegistratie(infoVoorstelling[0], infoVoorstelling[1]));
        } else
            throw new IllegalArgumentException("Ongeldige info ingevuld");
    }

    public int geefAantalInZaal(int zaalnr) {
        return vertoonbaarRepo.geefAantalInZaal(zaalnr);
    }
}
