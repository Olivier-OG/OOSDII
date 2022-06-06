package domein;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DomeinController {
	private final StripfiguurRepository stripfiguurRepo;

	public DomeinController() {
		this.stripfiguurRepo = new StripfiguurRepository();
	}

	public Collection<String> geefAlsStrings(Collection<Stripfiguur> stripfiguren) {
		List<String> resultaat = new ArrayList<>();
		for (Stripfiguur stripfiguur : stripfiguren) {
			resultaat.add(stripfiguur.toString());
		}
		return resultaat;
	}

	public Collection<String> geefAlleStripfiguren() {
		return geefAlsStrings(stripfiguurRepo.geefAlleStripfiguren());
	}

	public Collection<String> geefAlleStripfigurenGesorteerdOpNaam() {
		return geefAlsStrings(stripfiguurRepo.geefStripfigurenGesorteerdOpNaam());
	}

	public Collection<String> geefAlleStripfigurenAflopendGesorteerdOpGrootte() {
		return geefAlsStrings(stripfiguurRepo.geefStripfigurenAflopendGesorteerdOpGrootte());
	}

	public Collection<String> geefAlleStripfigurenZonderDubbels() {
		return geefAlsStrings(stripfiguurRepo.geefStripfigurenZonderDubbels());
	}

	public void voegStripfiguurToe(String naam, double grootte) {
		stripfiguurRepo.voegStripfiguurToe(naam, grootte);
	}

	public Collection<String> geefDrieWillekeurigeStripfiguren() {
		return geefAlsStrings(stripfiguurRepo.geefDrieWillekeurigeStripfiguren());
	}

	public void voegDeExtraStripfigurenToe() {
		stripfiguurRepo.voegExtraStripfigurenToe();
	}

	public String[] geefLijstTerugArrayVanString(List<Stripfiguur> lijst) {
		String[] res = new String[lijst.size()];
		int index = 0;
		for (Stripfiguur strip : lijst) {
			res[index++] = strip.toString();
		}
		return res;
	}
}
