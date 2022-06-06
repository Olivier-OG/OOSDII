package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import persistentie.StripfiguurMapper;

public class StripfiguurRepository {
	private final List<Stripfiguur> stripfiguren;
	private final StripfiguurMapper mapper;

	public StripfiguurRepository() {
		this.mapper = new StripfiguurMapper();
		stripfiguren = new ArrayList<>(Arrays.asList(mapper.geefStripfiguren()));
	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren
	 */
	public Collection<Stripfiguur> geefAlleStripfiguren() {
		return stripfiguren;
	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren, gesorteerd op naam
	 */
	public Collection<Stripfiguur> geefStripfigurenGesorteerdOpNaam() {
		Collections.sort(stripfiguren, Comparator.comparing(Stripfiguur::getNaam));
		return stripfiguren;
	}

	/**
	 * @return alle stripfiguren uit de lijst stripfiguren, aflopend gesorteerd op
	 *         grootte
	 */
	public Collection<Stripfiguur> geefStripfigurenAflopendGesorteerdOpGrootte() {
		Collections.sort(stripfiguren, Comparator.comparing(Stripfiguur::getGrootte).reversed());
		return stripfiguren;
	}

	/**
	 * Tip: maak gebruik van een Set datastructuur
	 * 
	 * @return alle stripfiguren uit de lijst stripfiguren zonder dubbels
	 */
	public Collection<Stripfiguur> geefStripfigurenZonderDubbels() {
		return new HashSet<Stripfiguur>(stripfiguren);
	}

	/**
	 * Tip: maak gebruik van de shuffle methode
	 * 
	 * @return drie willekeurige stripfuren uit de lijst stripfiguren
	 */
	public Collection<Stripfiguur> geefDrieWillekeurigeStripfiguren() {
		Collections.shuffle(stripfiguren);
		List<Stripfiguur> pick3 = stripfiguren.subList(0, 3);
		return pick3;
	}

	/**
	 * Voegt een nieuwe stripfiguur toe aan de lijst stripfiguren
	 * 
	 * @param naam    de naam van de nieuwe stripfiguur
	 * @param grootte de grootte van de nieuwe stripfiguur
	 */
	public void voegStripfiguurToe(String naam, double grootte) {
		stripfiguren.add(new Stripfiguur(naam, grootte));
	}

	/**
	 * Voegt extra stripfiguren toe aan de lijst met stripfiguren
	 * 
	 * Tip: haal via de mapper de extra stripfiguren op en voeg ze in bulk toe aan
	 * de lijst stripfiguren
	 */
	public void voegExtraStripfigurenToe() {
		stripfiguren.addAll(Arrays.asList(mapper.geefExtraStripfiguren()));
	}
}
