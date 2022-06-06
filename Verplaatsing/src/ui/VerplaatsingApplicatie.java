package ui;

import domein.DomeinController;

public class VerplaatsingApplicatie {

    private final DomeinController dc;

    public VerplaatsingApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        System.out.println(dc.geefOverzichtAantalDocumenten());
        System.out.println();
        System.out.println(dc.geefKostenLijst());
    }

}
