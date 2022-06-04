package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.SpeeltuinPerceel;
import domein.TuinPerceel;


public class SpeeltuinPerceelTest {

	private SpeeltuinPerceel perceel;

	@BeforeEach
	public void before() {
		perceel = new SpeeltuinPerceel(10, 5, 8,"SP01");
	}

	@Test
	public void maakSpeeltuinperceel_geldigeWaarden_maaktSpeeltuinperceel() {
		Assertions.assertEquals(10, perceel.getLengte());
		Assertions.assertEquals(5, perceel.getBreedte());
		Assertions.assertEquals(8, perceel.getAantalToestellen());
		Assertions.assertEquals("SP01", perceel.getPerceelsCode());
	}

	@Test
	public void maakSpeeltuinperceel_defaultLengteEnBreedte_maaktSpeeltuinperceel() {
		perceel = new SpeeltuinPerceel(6,"SP01");
		Assertions.assertEquals(TuinPerceel.DEFAULT_LENGTE_BREEDTE, perceel.getLengte());
		Assertions.assertEquals(TuinPerceel.DEFAULT_LENGTE_BREEDTE, perceel.getBreedte());
		Assertions.assertEquals(6, perceel.getAantalToestellen());
		Assertions.assertEquals("SP01", perceel.getPerceelsCode());
	}

	@Test

	public void maakSpeeltuinperceel_teveelToestellen_werptException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new SpeeltuinPerceel(1, 1, 1,"SP01"));
	}

	@ParameterizedTest
	@ValueSource(ints = { -5, 0 })
	public void maakSpeeltuinperceel_ongeldigeLengte_werptException(int lengte) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new SpeeltuinPerceel(lengte, 1, 0,"SP01"));
	}

	@ParameterizedTest
	@ValueSource(ints = { -5, 0 })
	public void maakSpeeltuinperceel_ongeldigeBreedte_werptException(int breedte) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new SpeeltuinPerceel(1, breedte, 0, "SP01"));
	}

	@Test
	public void maakSpeeltuinperceel_lengteKleinerDanBreedte_werptException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new SpeeltuinPerceel(5, 10, 0,"SP01"));
	}

	@Test
	public void geefWaarde_SpeeltuinperceelZonderToestellen_retourneertWaarde() {
		perceel = new SpeeltuinPerceel(10, 9, 0,"SP01");
		Assertions.assertEquals(0, perceel.geefWaarde(), 0);
	}

	@Test
	public void geefWaarde_SpeeltuinperceelMetToestellen_retourneertWaarde() {
		Assertions.assertEquals(20, perceel.geefWaarde(),0);
	}

}
