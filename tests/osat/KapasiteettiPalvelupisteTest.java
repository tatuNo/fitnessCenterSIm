package osat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.KontrolleriIf;
import eduni.distributions.ContinuousGenerator;
import eduni.distributions.Normal;
import osat.AsiakkaanTyyppi.AsiakkaanSukupuoli;
import osat.Trace.Level;

/**
 * Testiluokka KapasiteettiPalvelupiste luokalle.
 * @author Tatu Nordström
 *
 */
class KapasiteettiPalvelupisteTest {
	/** Käytettävä kapasiteettipalvelupiste. */
	private KapasiteettiPalvelupiste pp;
	/** Käytettävä moottori. */
	private static Moottori m;
	/** Käytettävä kontrolleri. */
	private static KontrolleriIf kontrolleri;
	/** Käytettävä kello. */
	private static Kello kello;
	
		
	/**
	 * Suoritetaan ennen testiajoa, haetaan kello.
	 */
	@BeforeAll
	static void setUpBeforeClass() {
	Trace.setTraceLevel(Level.ERR);
	kello = Kello.getInstance();
	}
	
	/**
	 * Suoritetaan enenn jokaista testiä, nollataan kellon aika ja tehdään moottorista ja kapasiteettipalvelupisteestä
	 * uusi ilmentymä.
	 */
	@BeforeEach
	void nollaa () {
		m = new Moottori(kontrolleri);
		kello.setAika(0);
		pp = new KapasiteettiPalvelupiste(new Normal(1,1), 20, m, TapahtumanTyyppi.DEP8);
	}
	
	/**
	 * Testaa lisaaPalvelupisteeseen ja siirraPalvelupisteesta.
	 */
	@Test
	void testlisaaJaSiirraPalvelupisteesta () {
		//Suoritetaan moottorin luoma ensimmäinen tapahtuma pois alta, yritetään saada ajassa 1 luotu asiakas pihalle.
		m.suoritaBTapahtumat();
		kello.setAika(1);
		Asiakas a = new Asiakas(AsiakkaanTyyppi.FYSIOTERAPIA, AsiakkaanSukupuoli.MIES);
		pp.lisaaPalvelupisteeseen(a);
		kello.setAika(5);
		Asiakas b = new Asiakas(AsiakkaanTyyppi.HIERONTA, AsiakkaanSukupuoli.MIES);
		pp.lisaaPalvelupisteeseen(b);
		kello.setAika(10);
		Asiakas c = new Asiakas(AsiakkaanTyyppi.KUNTOSALI, AsiakkaanSukupuoli.MIES);
		pp.lisaaPalvelupisteeseen(c);
		
		
		kello.setAika(m.nykyaika());
		Asiakas result = pp.siiraPalvelupisteesta();
		
		assertEquals(AsiakkaanTyyppi.FYSIOTERAPIA, result.getAsiakkaanTyyppi(),"Siirrettiin väärä asiakas!");
	}
	
	/**
	 * Testaa kapasiteetin toimivuuden.
	 */
	@Test
	void testKapasiteetti () {
		
		for(int i = 0; i < 21; i++) {
			Asiakas a = new Asiakas (AsiakkaanTyyppi.KUNTOSALI, AsiakkaanSukupuoli.MIES);
			pp.lisaaPalvelupisteeseen(a);
		}
		assertEquals(false, pp.onkoTilaa(), "Palvelupisteessä ei pitäisi olla tilaa");
		assertEquals(true, pp.onkoJonoa(), "Palvelupisteessä pitäisi olla jonoa");
	}
	
	/**
	 * Testaa jonosta palveluun siirtymisen.
	 */
	@Test
	void testJonostaPalveluun () {
		for(int i = 0; i < 21; i++) {
			Asiakas a = new Asiakas (AsiakkaanTyyppi.KUNTOSALI, AsiakkaanSukupuoli.MIES);
			pp.lisaaPalvelupisteeseen(a);
		}
		pp.poistuPalvelupisteesta();
		assertEquals(false, pp.onkoJonoa(), "Palvelupisteessä ei pitäisi olla poiston jälkeen jonoa");
	}
	
	/**
	 * Testaa aktiiviajan.
	 */
	@Test
	void testAktviiviaika () {
		// Suoritetaan taas ensimmäinen saapuminen pois alta
		m.suoritaBTapahtumat();
		kello.setAika(1);
		
		Asiakas a = new Asiakas (AsiakkaanTyyppi.FYSIOTERAPIA, AsiakkaanSukupuoli.MIES);
		pp.lisaaPalvelupisteeseen(a);
		kello.setAika(m.nykyaika());
		
		double expected = kello.getAika() - 1;
		Asiakas r = pp.siiraPalvelupisteesta();
		
		assertEquals(expected, pp.getAktiiviaika(), "Aktiiviaika väärä");
	}
}
