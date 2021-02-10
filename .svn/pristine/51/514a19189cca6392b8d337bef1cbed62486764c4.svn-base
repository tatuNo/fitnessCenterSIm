package osat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.KontrolleriIf;
import eduni.distributions.Normal;
import osat.Trace.Level;

/**
 * Testiluokka Ryhmaliikunta luokalle.
 * @author Tatu Nordström
 *
 */
class RyhmaliikuntaTest {
	/** Käytettävä ryhmaliikunta.*/
	private Ryhmaliikunta pp;
	/** Käytettävä moottori. */
	private static Moottori m;
	/** Käytettävä kontrolleri .*/
	private static KontrolleriIf kontrolleri;
	/** Käytettävä kello. */
	private static Kello kello;
	
	/**
	 * Ennen testejä haetaan kellon instanssi.
	 */
	@BeforeAll
	static void setUpBeforeClass() {
	Trace.setTraceLevel(Level.ERR);
	kello = Kello.getInstance();
	}
	
	/**
	 * Ennen jokaista testiä nollaa kellon ja tekee moottorista ja ryhmaliikunnasta uuden instanssin.
	 */
	@BeforeEach
	void nollaa () {
		m = new Moottori(kontrolleri);
		kello.setAika(0);
		pp = new Ryhmaliikunta(m, TapahtumanTyyppi.DEP8);
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
	 * Testaa onTaysi metodin.
	 */
	@Test
	void testOnTaysi() {
		for(int i = 0; i < 10; i++) {
			Asiakas a = new Asiakas(AsiakkaanTyyppi.arvoTyyppi(),AsiakkaanTyyppi.arvoSukupuoli());
			pp.lisaaJonoon(a);
		}
		assertEquals(true, pp.onTaysi(), "Palvelupisteen pitäisi olla täysi");
	}

	/**
	 * Testaa getOnKaynnissa metodin.
	 */
	@Test
	void testGetOnkaynnissa() {
		pp.aloitaPalvelu();
		assertEquals(true, pp.getOnkaynnissa(),"Palvelun pitäisi olla käynnissä");
	}

}
