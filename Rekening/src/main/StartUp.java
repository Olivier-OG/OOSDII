package main;

import domein.DomeinController;
import ui.KostenApplicatie;
import ui.RekeningApplicatie;

public class StartUp {

    public static void main(String[] args) {
        new RekeningApplicatie(new DomeinController()).werkMetRekeningen();
        new KostenApplicatie(new DomeinController()).werkMetKosten();
    }
}
