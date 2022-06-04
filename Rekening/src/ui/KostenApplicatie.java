package ui;

import domein.DomeinController;

public class KostenApplicatie {
    private final DomeinController dc;

    public KostenApplicatie(DomeinController dc) {
        this.dc = dc; // NIET this.dc = new DomeinController();
    }

    public void werkMetKosten() {
        String[] titels = dc.geefTitelsBeheerskosten();

        int index = 0;
        for (String titel : titels) {
            System.out.println(titel); // groen
            System.out.println(dc.geefDetailBeheerskost(index)); // geel
            System.out.println( dc.geefBeheerskostWaarde(index)); // rood
            System.out.println();
            index++;
        }
    }
}
