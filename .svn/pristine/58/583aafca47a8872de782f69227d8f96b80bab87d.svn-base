package osat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Testiluokka Tapahtuma luokalle.
 * @author Tatu Nordström
 */
class TapahtumaTest {
	/** Käytettävä tapahtuma. */
	private static Tapahtuma t;
	
	/**
	 * Ennen testejä luodaan uusi tapahtuma.
	 */
	@BeforeAll
	static void beforeAll () {
		t = new Tapahtuma(TapahtumanTyyppi.DEP1, 10);
	}

	
	/**
	 * Testaa tapahtuman tyypin.
	 */
	@Test
	void testTyyppi() {
		t.setTyyppi(TapahtumanTyyppi.ARR1);
		assertEquals(TapahtumanTyyppi.ARR1, t.getTyyppi(),"Tyypin setter tai getter ei toimi");
	}
	
	/**
	 * Testaa tapahtuman ajan.
	 */
	@Test
	void testAika() {
		t.setAika(30);
		assertEquals(30,t.getAika(),"Ajan setter tai getter ei toimi");
	}

	/**
	 * Testaa compareTo metodin.
	 */
	@Test
	void testCompareTo() {
		Tapahtuma t2 = new Tapahtuma(TapahtumanTyyppi.DEP1, 20);
		assertEquals(1, t.compareTo(t2), "Compare To ei toimi");
	}
}
