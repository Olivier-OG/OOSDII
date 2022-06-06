package ui;

import domein.DomeinController;

public class ConsoleApplicatie {
	private final DomeinController domeinController;

	public ConsoleApplicatie(DomeinController dc) {
		domeinController = dc;
	}

	public void run() {
		System.out.printf("Alle auto's oplopend op nummerplaat:%n%s%n",
				domeinController.geefAutoOpNummerplaat());
		System.out.printf("Alle auto's oplopend op merk:%n%s%n", domeinController.geefAutoOpMerk());
		System.out.printf("Alle auto's oplopend op merk en model :%n%s%n", domeinController.geefAutoOpMerkEnModel());
		System.out.printf("Alle auto's oplopend op aantal :%n%s%n", domeinController.geefAutoOpAantalOnderhoudsbeurtenAflopend());
	}

}
