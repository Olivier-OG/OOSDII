/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domein;


/**
 * @author sv964
 */
public class DomeinController {
    private final DraagbaarRepository draagbaarRepo;

    public DomeinController() {
        draagbaarRepo = new DraagbaarRepository();
    }

    public void voegWapenToe(String naam, double gewicht,
                             int niveau, int kracht, boolean gebruikt) {
        Voorwerp wapen = new Wapen(naam, gewicht, niveau, kracht, gebruikt);
        draagbaarRepo.voegDraagbaarToe(wapen);
    }

    public void voegSleutelToe(String naam, double gewicht,
                               int niveau, int deur) {
        Voorwerp sleutel = new Sleutel(naam, gewicht, niveau, deur);
        draagbaarRepo.voegDraagbaarToe(sleutel);
    }

    public void voegGebouwToe(String naam, double hoogte) {
        draagbaarRepo.voegDraagbaarToe(new Gebouw(naam, hoogte));
    }

    public String geefOverzicht() {
        return draagbaarRepo.geefOverzicht();
    }

}
