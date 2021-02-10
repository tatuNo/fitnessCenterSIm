package osat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import osat.AsiakkaanTyyppi.AsiakkaanSukupuoli;
import osat.Trace.Level;

/**
 * Testiluokka Asiakas luokalle.
 * @author Tatu Nordström
 *
 */
class AsiakasTest {
	
	/** Testeissä  käytettävä asiakas.*/
	private static Asiakas asiakas;
	/** Testeissä käytettävä kello.*/
	private static Kello kello;
	
	/**
	 * Suoritetaan ennen testejä, luodaan asiakkaasta uusi asiakas ja haetaan kellon instanssi.
	 * @throws Exception jos tulee virhe.
	 */
	@BeforeAll
	 static void setUpBeforeClass () throws Exception {
		Trace.setTraceLevel(Level.WAR);
		kello = Kello.getInstance();
		asiakas = new Asiakas (AsiakkaanTyyppi.HIERONTA, AsiakkaanSukupuoli.MIES);
	}
	

	/**
	 * Testaa asiakkaan tyypin.
	 */
	@Test
	void testGetAsiakkaanTyyppi() {
		assertEquals(AsiakkaanTyyppi.HIERONTA, asiakas.getAsiakkaanTyyppi(),"Palautti väärän tyypin");
	}
	
	
	/**
	 * Testaa asiakkaan sukupuolen.
	 */
	@Test
	void testGetAsiakkaanSukupuoli() {
		assertEquals(AsiakkaanSukupuoli.MIES, asiakas.getAsiakkaanSukupuoli(),"Palautti väärän sukupuolen");
	}
	
	
	/**
	 * Testaa poistumisajan.
	 */
	@Test
	void testPoistumisaika() {
		double aika = 15.0;
		asiakas.setPoistumisaika(aika);
		assertEquals(15.0, asiakas.getPoistumisaika(), "Poistumisajan getter tai setter ei toimi");
	}
	
	
	/**
	 * Testaa saapumisajan.
	 */
	@Test
	void testSaapumisaika() {
		double aika = 15.0;
		asiakas.setSaapumisaika(aika);
		assertEquals(15.0, asiakas.getSaapumisaika(), "Saapumisajan getter tai setter ei toimi");
	}
	
	/**
	 * Testaa asiakkaan id:n.
	 */
	@Test
	void testGetId() {
		Asiakas kaksi = new Asiakas(AsiakkaanTyyppi.JUOKSIJA, AsiakkaanSukupuoli.NAINEN);
		assertEquals(1, asiakas.getId(),"Piti olla toinen asiakas");
	}
	
	
	/**
	 * Testaa palveltujen asiakkaiden lukumäärän.
	 */
	@Test
	void testGetPalveltutAsiakkaat() {
		for(int i = 0; i < 5; i++) {
			asiakas.raportti();
		}
		assertEquals(5, asiakas.getPalveltutAsiakkaat(), "Palveltuja asiakkaita pitäisi olla 5");
	}
	
	
	/**
	 * Testaa läpimenoajat.
	 */
	@Test
	void testLapimeno() {
		double aika = 10.0;
		asiakas.setLapimenoAloitus(aika);
		assertEquals(aika, asiakas.getLapimenoAloitus(), "LäpimenoAloitus ei toimi");
		aika = 12.4;
		asiakas.setLapimenoLopetus(aika);
		assertEquals(aika, asiakas.getLapimenoLopetus(), "LäpimenoLopetus ei toimi");
	}
}
