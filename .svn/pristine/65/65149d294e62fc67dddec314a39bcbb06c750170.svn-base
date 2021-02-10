package osat;

import java.util.HashMap;
import java.util.LinkedList;

import eduni.distributions.ContinuousGenerator;

/**
 * Luokka, jota simulaattorin pukuhuoneet toteuttavat. Toimintamalli samanlainen kuin kapasiteettipalvelupisteissä,
 * selkeyden vuoksi päätimme lisätä pukuhuoneille oman luokan. Simulaattorissa kaikki asiakkaat kulkevat pukuhuoneiden kautta
 * kahdesti: saapuessaan järjestelmään ja palvelun päätyttyä poistuessaan järjestelmästä. Täten pukuhuoneet luovat 
 * kahta erilaista tapahtumaa.
 * @author Tatu Nordström
 *
 */
public class Pukuhuone {

	
	/** Simulaattorin moottori. */
	private Moottori moottori;
	/** Lista jonolle. */
	private LinkedList<Asiakas> jono = new LinkedList<Asiakas>();
	/** Jakauma. */
	private ContinuousGenerator generator;
	/** Siirtymistapahtumille tapahtumantyyppi. */
	private TapahtumanTyyppi siirtymisTapahtumanTyyppi;
	/** Poistumistapahtumille tapahtumantyyyppi. */
	private TapahtumanTyyppi poistumisTapahtumanTyyppi;
	/** Pukuhuoneen kapasiteeetti. */
	private int kapasiteetti;
	/** Muuttuja joka pitää kirjaa pukuhuoneen asiakasmäärästä.*/
	private int asiakkaita;
	/** Palveltujen asiakkaiden lukumäärä. */
	private int palveltutAsiakkaat;
	/** Muuttuja aktiiviajan aloitusajalle. */
	private double aktiiviAloitus;
	/** Muuttuja aktiiviajan lopetusajalle.*/
	private double aktiiviLopetus;
	/** Summamuuttuja aktiiviajalle. */
	private double aktiiviaika;
	/** HashMap mihin asiakkaat talletetaan, avaimena tulevan tapahtuman aika. */
	private HashMap <Double,Asiakas> asiakkaat = new HashMap <Double,Asiakas>();
	/** Apumuuttuja aktiiviajan laskemiseen. */
	private boolean onkoAktiivinen = false;
	/** Suorituskykysuure olio, johon simulointitulokset asetetaan. */
	private Suorituskykysuureet suureet;
	
	/**
	 * Konstruktori, jossa määritellään pukuhuoneeseen liittyviä arvoja
	 * @param generator jakauma, jonka perusteella palvelupiste luo tapahtumiaan tulevalle ajan hetkelle. Käytetään eduni.distributions pakkausta.
	 * @param kapasiteetti kyseisen pukuhuoneen kapasiteetti.
	 * @param moottori moottori -luokka, jotta päästään käsiksi moottorin metodeihin.
	 * @param tyyppiS siirtymistapahtuman tyyppi(pukuhuone -> palvelu).
	 * @param tyyppiP poistumistapahtuman tyyppi(pukuhuone -> ulos järjestelmästä).
	 */
	public Pukuhuone(ContinuousGenerator generator, int kapasiteetti ,Moottori moottori, TapahtumanTyyppi tyyppiS, TapahtumanTyyppi tyyppiP){
		this.moottori = moottori;
		this.kapasiteetti = kapasiteetti;
		this.generator = generator;
		this.siirtymisTapahtumanTyyppi= tyyppiS;
		this.poistumisTapahtumanTyyppi = tyyppiP;
		this.asiakkaita = 0;		
	}
	
	/**
	 * Tarkistetaan onkoTilaa metodilla onko pukuhuoneessa tilaa, jos ei niin asetetaan asiakas jonoon.
	 * Muuten moottori luo uuden siirtymistapahtuman jakaumaa hyväksikäyttäen.
	 * Talletetaan asiakas hashMappiin avaimena skeduloidun tapahtuman aika.
	 * Näin toimiessa asiakkaat eivät mene sekaisin, vaikka myöhemmin saapunut poistuisi aikaisemmin kuin aikaisemmin saapunut.
	 * Kutsutaan aktiiviAloitus metodia aktiiviajan laskemiseksi.
	 * @param a pukuhuoneeseen lisättävä asiakas.
	 */
	public void lisaaPukuhuoneeseen (Asiakas a) {
		
		if(!onkoTilaa()) {
			jono.add(a);
		} else {
		
		asiakkaita++;
		double palveluaika = generator.sample();

		moottori.uusiTapahtuma(new Tapahtuma(siirtymisTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		asiakkaat.put(Kello.getInstance().getAika()+palveluaika, a);
		aktiiviAloitus();
		}
	}
	
	/**
	 * Metodissa talletetaan aktiiviajan aloitushetki aktiiviAloitus muuttujaan.
	 * Jos onkoAktiivinen muuttuja on false, aktiiviAloitukselle annetaan arvoksi
	 * kellon tämän hetkinen aika ja muutetaan onkoAktiivinen trueksi.
	 */
	
	public void aktiiviAloitus () {
		if(!onkoAktiivinen) {
		aktiiviAloitus = Kello.getInstance().getAika();
		onkoAktiivinen = true;
		}
	}
	
	/**
	 * Kutsutaan, kun palvelupiste ei ole aktiivinen. Aktiiviaika päivitetään
	 * aktiiviLopetus ja aktiiviAloitus erotuksella.
	 */
	
	public void aktiiviLopetus () {
		aktiiviLopetus = Kello.getInstance().getAika();
		aktiiviaika += (aktiiviLopetus - aktiiviAloitus);
	}
	
	/**
	 * Moottori kutsuu tätä metodia, kun asiakas siirretään pukuhuoneesta palvelupisteelle.
	 * Hakee hashmapista oikean asiakkaan kellon ajalla.
	 * Tarkastaa onko pukuhuoneessa väkeä, jos ei niin aktiiviaika päivitetään.
	 * @return siirrettävä asiakas.
	 */
	
	public Asiakas siiraPukuhuoneesta () {
		palveltutAsiakkaat++;
		Asiakas a = asiakkaat.get(Kello.getInstance().getAika());
		asiakkaat.remove(Kello.getInstance().getAika());
		
		if(asiakkaat.isEmpty()) {
			onkoAktiivinen = false;
			aktiiviLopetus();
		}
		return a;
	}
	
	/**
	 * Moottori kutsuu tätä metodia, kun asiakas palaa palvelupisteeltä pukuhuoneeseen.
	 * Skeduloi uuden poistumistapahtuman generaattorin jakauman avulla.
	 * Asiakas talteen hashmappiin avaimena skeduloidun tapahtuman aika.
	 * @param a pukuhuoneeseen palaava asiakas.
	 */
	
	public void palaaPukuhuoneeseen (Asiakas a) {
		double palveluaika = generator.sample();
		moottori.uusiTapahtuma(new Tapahtuma(poistumisTapahtumanTyyppi,Kello.getInstance().getAika()+palveluaika));
		asiakkaat.put(Kello.getInstance().getAika() + palveluaika, a);
		aktiiviAloitus();
	}
	
	/**
	 * Moottori kutsuu tätä metodia, kun asiakas poistuu järjestelmästä.
	 * Haetaan oikea asiakas hashmapista.
	 * Tarkastetaan aktiiviaika.
	 * Tehdään tilaa pukuhuoneeseen ja tarkastetaan, onko jonossa väkeä ja jos on, päästetään se pukuhuoneeseen.
	 * @return poistuva asiakas
	 */
	
	public Asiakas poistuPukuhuoneesta () {
		Asiakas a = asiakkaat.get(Kello.getInstance().getAika());
		asiakkaat.remove(Kello.getInstance().getAika());
		asiakkaita--;
		
		if(asiakkaat.isEmpty()) {
			onkoAktiivinen = false;
			aktiiviLopetus();
		}
		
		if (onkoJonoa()) {
			Asiakas b = jono.poll();
			lisaaPukuhuoneeseen(b);
		}
		
		return a;
	}
	
	/**
	 * Jonon tarkasteluun käytettävä metodi
	 * @return true jos on jonoa, false jos ei.
	 */
	
	public boolean onkoJonoa () {
		return jono.size() != 0;
	}
	
	/**
	 * Käyttöliittymään päivitetään jonon kokoja tällä metodilla.
	 * @return jonon koko kutsunta hetkellä.
	 */
	
	public int getJonoSize() {
		return jono.size();
	}
	
	/**
	 * Tarkastaa, onko palvelupisteessä olevien asiakkaiden määrä sama kuin kapasiteetti.
	 * @return true jos on, false jos ei.
	 */
	
	public boolean onkoTilaa () {
		return asiakkaita != kapasiteetti;
	}
	
	/**
	 * @return palauttaa Suorituskykysuureet olion, jossa palvelupistekohtaiset simulointitulokset.
	 */
	
	public Suorituskykysuureet getSuorituskykysuureet () {
		return suureet;
	}
	
	/**
	 * Tätä metodia kutsutaan moottorissa, kun simulointi päättyy.
	 * Jos pukuhuone on aktiivinen simuloinnin päättymishetkellä, kutsutaan aktiiviLopetus metodia.
	 * Lasketaan suorituskykysuureet ja pyöristetään ne kahden desimaalin tarkkuudelle.
	 * Luodaan Suorituskykysuureet olio näistä suureista, jotta tallentaminen tietokantaan olisi näppärämpää.
	 * @return tekstimuotoinen raportti simuloinnin tuloksista, palvelupistekohtainen.
	 */
	
	public String raportti () {
		if(onkoAktiivinen) {
			aktiiviLopetus();
		}
		aktiiviaika = Math.round(aktiiviaika * 100.0) / 100.0;
		double kayttoaste = (aktiiviaika / Kello.getInstance().getAika()) * 100.0;
		kayttoaste = Math.round(kayttoaste * 100.0) / 100.0;
		
		int tunnit = (int)Kello.getInstance().getAika() / 60;
		double suoritusteho = palveltutAsiakkaat / (double) tunnit;
		suoritusteho = Math.round(suoritusteho * 100.0) / 100.0;
		
		double avgpalveluaika = Math.round((aktiiviaika / palveltutAsiakkaat) * 100.0) / 100.0;
		suureet = new Suorituskykysuureet(palveltutAsiakkaat, aktiiviaika, kayttoaste, suoritusteho, avgpalveluaika);
		
		return "Palveltuja asiakkaita: " + palveltutAsiakkaat + " AKTIIVIAIKA: " + aktiiviaika + " KÄYTTÖASTE: " + kayttoaste + "% " + " SUORITUSTEHO: "
				+suoritusteho + " asiakasta/tunti\n" + "AVG PALVELUAIKA: " + avgpalveluaika + "\n";
	}
}
