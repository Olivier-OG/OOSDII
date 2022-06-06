package testen;

import domein.ConcertRegistratie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ConcertRegistratieTest {

    private static final String GELDIGE_ARTIEST = "geldigeArtiest", GELDIGE_NAAM = "geldigeConcertnaam";
    private ConcertRegistratie gcr;

    @BeforeEach
    public void setUp() {
        gcr = new ConcertRegistratie(GELDIGE_ARTIEST, GELDIGE_NAAM);
    }

    @Test
    public void maakCR_gettersKomenOvereen() {
        Assertions.assertEquals(GELDIGE_ARTIEST, gcr.getArtiest());
        Assertions.assertEquals(GELDIGE_NAAM, gcr.getConcertnaam());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t ", " \n", "\t \n"})
    public void maakCR_ongeldigeArtiest_gooitException(String artiest) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ConcertRegistratie(artiest, GELDIGE_NAAM));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t ", " \n", "\t \n"})
    public void maakCR_ongeldigeConcertnaam_gooitException(String concertnaam) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ConcertRegistratie(GELDIGE_ARTIEST, concertnaam));
    }

}
