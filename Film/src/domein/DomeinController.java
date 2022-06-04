package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {

	private final FilmRepository filmRepo;
	
	
	public DomeinController() {
		filmRepo = new FilmRepository();
	}


	public List<String> geefAlleFilms() {
		return filmRepo.getFilms().stream().map(Film::toString).toList();
		
	}
	
	public void voegFilmToe(String naam, int jaar, int sterren) {
		filmRepo.voegFilmToe(new Film(naam, jaar, sterren));
	}
	
	public int geefAantalFilms() {
		return filmRepo.geefAantalFilms();
	}
}
