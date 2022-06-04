package testen;

import domein.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class FilmTest {

    @Test
    void maakFilm_alleParametersOk_creatieObject() {

        String naam = "test";
        int jaar = 2005;
        int sterren = 4;

        Film f = new Film(naam, jaar, sterren);

        Assertions.assertEquals(naam, f.getNaam());
        Assertions.assertEquals(sterren, f.getSterren());
        Assertions.assertEquals(jaar, f.getJaar());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "         ", "\t\t", "\n" })
    void maakFilm_legeNaam_exception(String naam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film(naam, 2018, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 6, 10})
    void maakFilm_aantalSterrenTeKleinOfTeGroot_exception(int sterren) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test", 2018, sterren));
    }

    @ParameterizedTest
    @ValueSource(ints = {Film.MIN_STERREN, Film.MAX_STERREN})
    void maakFilm_aantalSterrenGrenswaarde_maaktObject(int sterren) {
        Assertions.assertDoesNotThrow(() -> new Film("test", 2018, sterren));
    }

    @ParameterizedTest
    @ValueSource(ints = {Film.MIN_JAAR - 1, Film.MIN_JAAR - 10, 2022 + 1, 2022 + 10})
    void maakFilm_jaarTeKleinOfTeGroot_exception(int jaar) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Film("test", jaar, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {Film.MIN_JAAR, 2022})
    void maakFilm_jaarGrenswaarde_maaktObject(int jaar) {
        Assertions.assertDoesNotThrow(() -> new Film("test", jaar, 3));
    }


    @Test
    void equals_naamEnJaarGelijk_gelijkeObjecten() {
        Film f1 = new Film("naam", 2018, 3);
        Film f2 = new Film("naam", 2018, 1);
        Assertions.assertEquals(f1, f2);
    }

    @Test
    void equals_naamEnSterrenGelijk_verschillendeObjecten() {
        Film f1 = new Film("naam", 2018, 1);
        Film f2 = new Film("naam", 2016, 1);
        Assertions.assertNotEquals(f1, f2);
    }

    @Test
    void equals_jaarEnSterrenGelijk_verschillendeObjecten() {
        Film f1 = new Film("naam1", 2018, 1);
        Film f2 = new Film("naam2", 2018, 1);
        Assertions.assertNotEquals(f1, f2);
    }
}
