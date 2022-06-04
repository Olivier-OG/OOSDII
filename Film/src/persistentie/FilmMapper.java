package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Film;

public class FilmMapper {

	public List<Film> geefAlleFilms(){
		
		List<Film> films = new ArrayList<>();
		
		films.add(new Film("film A",2020, 5));
		films.add(new Film("film B",2018, 3));
		
		return films;
	}
}
