package ui;

import domein.DomeinController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TuinApp {
    private final DomeinController dc;

    public TuinApp(DomeinController dc) {
        this.dc = dc;
    }

    public void start() {
        dc.maakTuin();
        toonEnReageerOpMenu();
    }

    private void toonEnReageerOpMenu() {
        String[] keuzes = {"Toon alle siertuinpercelen", "Voeg speeltuinperceel toe", "Geef aantal percelen", "Geef totale waarde percelen", "Stop" };
        int keuze = 0;
        while (keuze != 5) {
            keuze = maakKeuzeUitMenu(keuzes);
            switch (keuze) {
                case 1 -> toonAlleSiertuinPercelen();
                case 2 -> System.out.println("Voegt speeltuinperceel toe");
                case 3 -> toonAantalPercelen();
                case 4 -> toonTotaleWaardePercelen();
            }
            System.out.println();
        }
    }

    private void toonAlleSiertuinPercelen() {
        for (String stp : dc.geefAlleSiertuinpercelen())
            System.out.println(stp);
    }

    private void toonAantalPercelen() {
        System.out.println("Totaal aantal percelen: " + dc.geefAantalPercelen());
    }

    private void toonTotaleWaardePercelen() {
        System.out.println("Totale waarde van alle percelen: " + dc.geefTotaleWaardePercelen());
    }

    private int maakKeuzeUitMenu(String[] keuzes) {
        Scanner sc = new Scanner(System.in);
        int keuze = 0;
        try {
            StringBuilder menu = new StringBuilder("Menu\n====\n");
            for (int i = 0; i < keuzes.length; i++)
                menu.append(String.format("%d. %s%n", i + 1, keuzes[i]));
            menu.append(String.format("Je keuze (1-%d): ", keuzes.length));
            System.out.print(menu);
            keuze = sc.nextInt();
        } catch (InputMismatchException ex) {
            System.err.println("Vul een getal in tussen 1 en " + keuzes.length);
            sc.next();
        }
        return keuze;
    }

}
