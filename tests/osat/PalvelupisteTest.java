package osat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.KontrolleriIf;
import eduni.distributions.Normal;
import osat.Trace.Level;

/**
 * Testiluokka Palvelupiste luokalle.
 * @author Tatu Nordström
 *
 */
class PalvelupisteTest {
	/** Käytettävä palvelupiste. */
	private Palvelupiste pp;
	/** Käytettävä moottori. */
	private static Moottori m;
	/** Käytettävä kontrolleri. */
	private static KontrolleriIf kontrolleri;
	/** Käytettävä kello. */
	private static Kello kello;
	
	/**
	 * Ennen testejä hakee kellon instanssin.
	 */
	@BeforeAll
	static void setUpBeforeClass() {
	Trace.setTraceLevel(Level.ERR);
	kello = Kello.getInstance();
	}
	
	/**
	 * Suoritetaan ennen jokaista testiä, nolla kellon ja tekee palvelupisteestä ja moottorista uuden instanssin.
	 */
	@BeforeEach
	void nollaa () {
		m = new Moottori(kontrolleri);
		kello.setAika(0);
		pp = new Palvelupiste(new Normal(1,1), m, TapahtumanTyyppi.DEP8);
	}

	/**
	 * Testaa jonon järjestyksen.
	 */
	@Test
	void testJonoJarjestys() {
		Asiakas a = new Asiakas(AsiakkaanTyyppi.arvoTyyppi(),AsiakkaanTyyppi.arvoSukupuoli());
		Asiakas b = new Asiakas(AsiakkaanTyyppi.arvoTyyppi(),AsiakkaanTyyppi.arvoSukupuoli());
		Asiakas c = new Asiakas(AsiakkaanTyyppi.arvoTyyppi(),AsiakkaanTyyppi.arvoSukupuoli());
		
		pp.lisaaJonoon(a);
		pp.lisaaJonoon(b);
		pp.lisaaJonoon(c);
		assertEquals(a, pp.otaJonosta(), "Jonosta pitäisi tulla aina ensimmäisenä siihen saapunut asiakas");
	}


	/**
	 * Testaa onJonossa metodin.
	 */
	@Test
	void testOnJonossa() {
		Asiakas a = new Asiakas(AsiakkaanTyyppi.arvoTyyppi(),AsiakkaanTyyppi.arvoSukupuoli());
		pp.lisaaJonoon(a);
		assertEquals(true, pp.onJonossa(), "Jonossa pitäisi olla asiakas");
	}

	/**
	 * Testaa onVarattu metodin.
	 */
	@Test
	void testOnVarattu () {
		pp.aloitaPalvelu();
		assertEquals(true, pp.onVarattu(), "Palvelupisteen pitäisi olla varattu");
	}
}
