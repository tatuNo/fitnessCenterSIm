package osat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Testiluokka Kello luokalle.
 * @author Tatu Nordström
 *
 */
class KelloTest {
	/** Käytettävä kello. */
	private static Kello kello;
	
	/**
	 * Ennen testejä haetaan kellon instanssi.
	 */
	@BeforeAll
	static void beforeAll () {
		kello = Kello.getInstance();
	}
	
	/**
	 * Testaa kellon ajan.
	 */
	@Test
	void aika () {
		kello.setAika(10.5);
		assertEquals(10.5, kello.getAika(), "Palautti väärän ajan");
		Kello kello2 = Kello.getInstance();
		assertEquals(10.5, kello2.getAika(), "Singelton ei toimi");
	}

}
