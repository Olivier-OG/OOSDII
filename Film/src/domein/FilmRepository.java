package domein;

import persistentie.FilmMapper;

import java.util.List;

public class FilmRepository {

    private final List<Film> films;

    public FilmRepository() {
        films = new FilmMapper().geefAlleFilms();
    }

    public void voegFilmToe(Film f) {
        if (films.contains(f))
            throw new IllegalArgumentException("Film is reeds aanwezig");
        films.add(f);
    }

    public int geefAantalFilms() {
        return films.size();
    }

    public List<Film> getFilms() {
        return films;
    }

}
