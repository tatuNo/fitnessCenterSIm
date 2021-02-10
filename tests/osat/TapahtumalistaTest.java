package osat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import osat.Trace.Level;

/**
 * Testiluokka Tapahtumalista luokalle.
 * @author Tatu Nordström
 *
 */
class TapahtumalistaTest {
	/** Käytettävä tapahtumalista. */
	private static Tapahtumalista lista;
	
	/**
	 * Ennen testejä luo tapahtumalistan ja lisää sinne tapahtumia.
	 */
	@BeforeAll
	static void beforeAll () {
		Trace.setTraceLevel(Level.ERR);
		lista = new Tapahtumalista();
		Tapahtuma t1 = new Tapahtuma(TapahtumanTyyppi.ARR1, 5);
		Tapahtuma t2 = new Tapahtuma(TapahtumanTyyppi.ARR1, 4);
		Tapahtuma t3 = new Tapahtuma(TapahtumanTyyppi.ARR1, 6);
		Tapahtuma t4 = new Tapahtuma(TapahtumanTyyppi.ARR1, 2);
		lista.lisaa(t1);
		lista.lisaa(t2);
		lista.lisaa(t3);
		lista.lisaa(t4);
	}

	/**
	 * Testaa tapahtuman poistamisen.
	 */
	@Test
	void testPoistuuko() {
		Tapahtuma t = lista.poista();
		assertEquals(2,t.getAika() , "Lista ei järjestyksessä pienmimmästä suurimpaan");
	}

	/**
	 * Testaa getSeuraavanAika metodin.
	 */
	@Test
	void testGetSeuraavanAika() {
		assertEquals(4, lista.getSeuraavanAika(),"Seuraavan aika ei ollut oikea");
	}

}
