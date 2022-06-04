package testen;

import domein.SiertuinPerceel;
import domein.SpeeltuinPerceel;
import domein.Tuin;
import domein.TuinPerceel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class TuinTest {

    private Tuin tuin;
    private TuinPerceel perceel1, perceel2, perceel3, perceel4;

    @BeforeEach
    public void before() {
        perceel1 = new SpeeltuinPerceel("SP001", 10, 5, 8);
        perceel2 = new SiertuinPerceel("SI001", 20, 10, Arrays.asList("Gladiool", "Roos", "Distel"), false);
        perceel3 = new SpeeltuinPerceel("SP002", 10, 5, 0);
        perceel4 = new SiertuinPerceel("SI002", 20, 10, Arrays.asList("Gladiool", "Roos", "Distel"), true);
        tuin = new Tuin(Arrays.asList(perceel1, perceel2, perceel3, perceel4));
    }


    @Test
    public void geefAlleSiertuinpercelen_retourneertDeSiertuinpercelen() {
        List<SiertuinPerceel> percelen = tuin.geefAlleSiertuinPercelen();
        Assertions.assertEquals(perceel2, percelen.get(0));
        Assertions.assertEquals(perceel4, percelen.get(1));
    }

    @Test
    public void geefAantalPercelen_lijstMet4_geeftAantalTerug() {
        Assertions.assertEquals(4, tuin.geefAantalPercelen());
    }

    @Test
    public void geefTotaleWaardenPercelen_lijstMet4_geeftAantalTerug() {
        Assertions.assertEquals(36, tuin.geefTotaleWaardePercelen());
    }

    @Test
    public void voegPerceelToe_perceelAlInLijst_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> tuin.voegPerceelToe(new SpeeltuinPerceel("SP001", 8, 4, 2)));
    }

    @Test
    public void voegPerceelToe_perceelNogNietInLijst_extraPerceelInLijst() {
        int aantal = tuin.geefAantalPercelen();
        tuin.voegPerceelToe(new SpeeltuinPerceel("SP010", 10, 5, 8));
        Assertions.assertEquals(aantal + 1, tuin.geefAantalPercelen());
    }
}
