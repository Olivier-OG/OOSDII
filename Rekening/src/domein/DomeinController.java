package domein;

import java.util.List;

public class DomeinController {
    private final RekeningRepository rekeningRepos;
    private final KostenRepository kostenRepos;

    public DomeinController() {
        rekeningRepos = new RekeningRepository();
        kostenRepos = new KostenRepository();
    }

    public void wijzigRekeningen() {
        rekeningRepos.wijzigRekeningen();
    }

    public String[] geefRekeningen() {
        return rekeningRepos.getRekeningen().stream().map(Rekening::toString).toArray(String[]::new);
    }

    public double[][] geefSaldoEnMaxKredietOnderNul() {
        List<Rekening> lijst = rekeningRepos.geefZichtrekeningen();
        double[][] infoBedragen = new double[lijst.size()][2];
        int teller = 0;
        for (Rekening r : lijst) {
            if (r instanceof ZichtRekening zr) {
                infoBedragen[teller][0] = zr.getSaldo();
                infoBedragen[teller][1] = zr.getMaxKredietOnderNul();
                teller++;
            }
        }
        return infoBedragen;
    }

    public List<String> geefCodes() {
        return rekeningRepos.getRekeningen().stream().map(Rekening::geefCode).toList();
    }

    public String[] geefTitelsBeheerskosten() {
        return kostenRepos.getKosten().stream().map(kost -> {
            if (kost instanceof Kluis kluis)
                return String.format("kluisnr = %d, houder = %s", kluis.getKluisnummer(), kluis.getHouder());
            Rekening rek = (Rekening) kost;
            return String.format("%s, houder = %s", rek.getClass().getSimpleName(), rek.getHouder());
        }).toArray(String[]::new);
    }

    public String geefDetailBeheerskost(int index) {
        return "Details: " + kostenRepos.geefBeheerskost(index).toString();
    }

    public String geefBeheerskostWaarde(int index) {
        return "Kost: " + kostenRepos.geefBeheerskost(index).geefJaarlijkseKost();
    }

}
