package ui;

import java.util.Collection;

import domein.DomeinController;

public class StripfigurenApp {
	private final DomeinController dc;

	public StripfigurenApp(DomeinController dc) {
		this.dc = dc;
	}

	public void start() {
		toonLijstMetStripfiguren("\nAlle Daltons:", dc.geefAlleStripfiguren());

		toonLijstMetStripfiguren("\nDe Daltons gesorteerd op naam:", dc.geefAlleStripfigurenGesorteerdOpNaam());
		toonLijstMetStripfiguren("\nDe Daltons aflopende gesorteerd op grootte:",
				dc.geefAlleStripfigurenAflopendGesorteerdOpGrootte());

		toonLijstMetStripfiguren("\nDe Daltons zonder dubbels:", dc.geefAlleStripfigurenZonderDubbels());

		dc.voegDeExtraStripfigurenToe();

		toonLijstMetStripfiguren("\nDe Daltons met extra stripfiguren toegevoegd, gesorteerd op naam:",
				dc.geefAlleStripfigurenGesorteerdOpNaam());

		toonLijstMetStripfiguren("\nDrie willekeurige Daltons:", dc.geefDrieWillekeurigeStripfiguren());

	}

	private void toonLijstMetStripfiguren(String titel, Collection<String> stripfiguren) {
		System.out.println(titel);
		for (String figuur : stripfiguren)
			System.out.printf("- %s%n", figuur);

	}
}
