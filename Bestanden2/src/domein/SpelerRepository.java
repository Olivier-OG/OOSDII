package domein;

import java.util.ArrayList;
import java.util.List;

import persistentie.SpelerMapper;

public class SpelerRepository {
	private List<Speler> spelerslijst;
	private SpelerMapper spelerMapper;

	public SpelerRepository() {
		spelerMapper = new SpelerMapper();
		spelerslijst = new ArrayList<>();
	}

	private void vulSpelerslijst(String[][] gegevens) {
		// TODO
		spelerslijst.clear();

		int kracht;
		String type;
		Wapen[] wapens;

		for (int rij = 0; rij < gegevens.length; rij++) {
			String[] array = gegevens[rij];
			kracht = Integer.parseInt(array[0]);
			type = array[1];

			wapens = new Wapen[array.length - 2];
			int teller = 0;
			for (int kol = 2; kol < array.length; kol++) {
				wapens[teller++] = new Wapen(array[kol]);
			}
			spelerslijst.add(new Speler(kracht, type, wapens));
		}

	}

	public void schrijfNaarTekstBestand(String[][] gegevens) {
		this.vulSpelerslijst(gegevens);
		this.spelerMapper.schrijfNaarTekstBestand(spelerslijst, "src\\bestanden\\oef3.txt");
	}

	public List<Speler> leesTekstBestand(String bestandsnaam) {
		return this.spelerMapper.leesTekstBestand(bestandsnaam);
	}

	public void serialiseerObjectPerObject(String[][] gegevens) {
		vulSpelerslijst(gegevens);
		spelerMapper.serialiseerObjectPerObject(spelerslijst, "src\\bestanden\\oef2a.ser");
	}

	public void serialiseerVolledigeLijst(String[][] gegevens) {
		vulSpelerslijst(gegevens);
		spelerMapper.serialiseerVolledigeLijst(spelerslijst, "src\\bestanden\\oef2b.ser");
	}

	public List<Speler> deSerialiseerObjectPerObject(String naamBestand) {
		return this.spelerMapper.deSerialiseerObjectPerObject(naamBestand);
	}

	public List<Speler> deSerialiseerVolledigeLijst(String naamBestand) {
		return this.spelerMapper.deSerialiseerVolledigeLijst(naamBestand);
	}
}
