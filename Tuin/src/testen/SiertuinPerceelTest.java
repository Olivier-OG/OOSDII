package testen;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.SiertuinPerceel;
import domein.TuinPerceel;


public class SiertuinPerceelTest {

	private SiertuinPerceel perceel;

	@BeforeEach
	public void before()  {
		perceel = new SiertuinPerceel("SI005",20, 10, Arrays.asList("Gladiool", "Roos", "Distel"), true);
	}

	@Test
	public void maakSiertuinperceel_geldigeWaarden_maaktSiertuinperceel() {
		Assertions.assertEquals("SI005", perceel.getPerceelsCode());
		Assertions.assertEquals(20, perceel.getLengte());
		Assertions.assertEquals(10, perceel.getBreedte());
		Assertions.assertEquals(Arrays.asList("Gladiool", "Roos", "Distel"), perceel.getBloemenperken());
		Assertions.assertTrue(perceel.isVijverAanwezig());
	}

	@Test
	public void maakSiertuinperceel_defaultLengteEnBreedte_maaktSiertuinperceel()  {
		perceel = new SiertuinPerceel("SI005", Arrays.asList("Gladiool", "Roos", "Distel"), false);
		Assertions.assertEquals("SI005", perceel.getPerceelsCode());
		Assertions.assertEquals(TuinPerceel.DEFAULT_LENGTE_BREEDTE, perceel.getLengte());
		Assertions.assertEquals(TuinPerceel.DEFAULT_LENGTE_BREEDTE, perceel.getBreedte());
		Assertions.assertEquals(Arrays.asList("Gladiool", "Roos", "Distel"), perceel.getBloemenperken());
		Assertions.assertFalse(perceel.isVijverAanwezig());
	}

	@Test
	public void maakSiertuinperceel_nullBloemenperken_maaktSiertuinperceel() {
		perceel = new SiertuinPerceel("SI005",null, false);
		Assertions.assertEquals(TuinPerceel.DEFAULT_LENGTE_BREEDTE, perceel.getLengte());
		Assertions.assertEquals(TuinPerceel.DEFAULT_LENGTE_BREEDTE, perceel.getBreedte());
		Assertions.assertEquals(0, perceel.getBloemenperken().size());
		Assertions.assertFalse(perceel.isVijverAanwezig());
	}

	@Test

	public void maakSiertuinperceel_teveelBloemenperken_werptException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new SiertuinPerceel("SI005",1, 1, Arrays.asList("Gladiool", "Roos"), false));
	}

	@ParameterizedTest
	@ValueSource(ints = { -5, 0 })
	public void maakSiertuinperceel_ongeldigeLengte_werptException(int lengte) {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new SiertuinPerceel("SI005",lengte, 1, Arrays.asList("Gladiool", "Roos", "Distel"), false));
	}

	@ParameterizedTest
	@ValueSource(ints = { -5, 0 })
	public void maakSiertuinperceel_ongeldigeBreedte_werptException(int breedte) {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new SiertuinPerceel("SI005",1, breedte, Arrays.asList("Gladiool", "Roos", "Distel"), false));
	}

	@Test
	public void maakSiertuinperceel_lengteKleinerDanBreedte_werptException() {
		Assertions.assertThrows(IllegalArgumentException.class,
				() -> new SiertuinPerceel("SI005",5, 10, Arrays.asList("Gladiool", "Roos", "Distel"), false));
	}

	@Test
	public void geefWaarde_SiertuinperceelZonderVijver_retourneertWaarde() {
		perceel = new SiertuinPerceel("SI005",20, 10, Arrays.asList("Gladiool", "Roos", "Distel"), false);
		Assertions.assertEquals(3, perceel.geefWaarde(), 0);
	}

	@Test
	public void geefWaarde_SiertuinperceelMetVijver_retourneertWaarde() {
		Assertions.assertEquals(13.0, perceel.geefWaarde(),0);
	}
	
	@Test
	public void geefOppervlakte_siertuin200_geeftOppTerug() {
		Assertions.assertEquals(200.0, perceel.geefOppervlakte(),0);
	}

}
