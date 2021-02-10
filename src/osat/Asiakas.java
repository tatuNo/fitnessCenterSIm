package osat;

import osat.AsiakkaanTyyppi.AsiakkaanSukupuoli;

/**
 * Asiakas luokasta luodaan järjestelmään asiakkaita, joita liikutellaan järjestelmässä.
 * @author Tatu Nordström
 * @author Nico Järvinen
 *
 */
public class Asiakas {
	/** Järjestelmään saapumisaika. */
	private double saapumisaika;
	/** Järjestelmästä poistumisaika. */
	private double poistumisaika;
	/** Asiakkaan järjestysnumero. */
	private int id;
	/** Staattinen numero joka pitää kirjaa seuraavasta järjestysnumerosta. */
	private static int i = 1;
	/** Summa muuttuja läpimenoaikojen keskiarvon laskemiselle. */
	private static long sum = 0;
	/** Muuttuja asiakkaan tyypille. */
	private AsiakkaanTyyppi tyyppi;
	/** Muuttuja asiakkaan sukupuolelle. */
	private AsiakkaanSukupuoli sukupuoli;
	/** Staattinen muuttuja järjestelmästä poistuneille asiakkaille.*/
	private static int palveltutAsiakkaat;
	/** Läpimenon aloitus muuttuja. */
	private double lapimenoAloitus;
	/** Läpimenon lopetus muuttuja. */
	private double lapimenoLopetus;
	
	/**
	 * Luo uuden asiakkaan ja asettaa asiakkaan saapumisajan kellon sen hetkiseen aikaan.
	 * @param tyyppi luodun asiakkaan tyyppi, kuvaa asiakkaan palvelun tarvetta.
	 * @param sukupuoli luodun asiakkaan sukupuoli.
	 */
	public Asiakas(AsiakkaanTyyppi tyyppi, AsiakkaanSukupuoli sukupuoli){
	    this.id = i++;
	    this.tyyppi = tyyppi;
	    this.sukupuoli = sukupuoli;
		saapumisaika = Kello.getInstance().getAika();
		Trace.out(Trace.Level.INFO, "Uusi asiakas: " + id + " " + this.tyyppi + " " + this.sukupuoli + " ajassa: " +saapumisaika);
	}
	
	/**
	 * Asettaa asiakkaan staattiset muuttujat alkuarvoihin, jotta saadaan valideja tuloksia
	 * käynnistämättä ohjelmaa uudestaan.
	 */
	public void setAlkuarvot() {
		this.id = 0;
		i = 1;
		sum = 0;
		palveltutAsiakkaat = 0;
	}
	
	/**
	 * Tyhjä konstruktori, jotta päästään asiakkaan gettereihin käsiksi.
	 */
	public Asiakas () {
		
	}
	
	/**
	 * @return asiakkaan palvelutarpeen tyyppi.
	 */
	public AsiakkaanTyyppi getAsiakkaanTyyppi () {
		return this.tyyppi;
	}
	
	/**
	 * @return asiakkaan sukupuoli
	 */
	public AsiakkaanSukupuoli getAsiakkaanSukupuoli () {
		return this.sukupuoli;
	}
	
	/**
	 * @return ajan hetki, jolloin asiakas on poistunut järjestelmästä. 
	 */
	public double getPoistumisaika() {
		return poistumisaika;
	}

	/** 
	 * @param poistumisaika ajan hetki, jolloin asiakas on poistunut järjestelmästä.
	 */
	public void setPoistumisaika(double poistumisaika) {
		this.poistumisaika = poistumisaika;
	}

	/**
	 * @return ajan hetki, jolloin asiakas on saapunut järjestelmään.
	 */
	public double getSaapumisaika() {
		return saapumisaika;
	}

	/**
	 * @param saapumisaika ajan hetki, jolloin asiakas on saapunut järjestelmään.
	 */
	public void setSaapumisaika(double saapumisaika) {
		this.saapumisaika = saapumisaika;
	}
	
	/**
	 * @return asiakkaan id.
	 */
	public int getId () {
		return id;
	}
	
	/**
	 * @return palveltujen asiakkaiden lukumäärä.
	 */
	public int getPalveltutAsiakkaat () {
		return palveltutAsiakkaat;
	}
	
	/**
	 * Käytetään palvelupisteissä läpimenoaikojen laskemiseen.
	 * @return ajan hetki, jolloin asiakas on saapunut palvelupisteeseen.
	 */
	public double getLapimenoAloitus () {
		return this.lapimenoAloitus;
	}
	
	/**
	 * Käytetään palvelupisteissä läpimenoaikojen laskemiseen.
	 * @return ajan hetki, jolloin asiakas on poistunut palvelupisteestä.
	 */
	public double getLapimenoLopetus () {
		return this.lapimenoLopetus;
	}
	
	/**
	 * Käytetään palvelupisteissä läpimenoaikojen laskemiseen.
	 * @param aloitus ajan hetki, jolloin läpimeno on aloitettu.
	 */
	public void setLapimenoAloitus (double aloitus) {
		this.lapimenoAloitus = aloitus;
	}
	
	/**
	 * Käytetään palvelupisteissä läpimenoaikojen laskemiseen.
	 * @param lopetus ajan hetki, jolloin läpimeno päättyy.
	 */
	public void setLapimenoLopetus (double lopetus) {
		this.lapimenoLopetus = lopetus;
	}
	
	/**
	 * Kutsutaan, kun asiakas poistuu järjestelmästä.
	 * Pitää yllä järjestelmän läpi kulkeneiden asiakkaiden lukumäärää.
	 * Tulostaa konsoliin asiakkaan saapumisajan, poistumisajan ja viipymisajan ja asiakkaiden läpimenoaikojen keskiarvon.
	 */
	public void raportti(){
		palveltutAsiakkaat++;
		Trace.out(Trace.Level.INFO, "Asiakas "+id+ " saapui:" +saapumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " poistui:" +poistumisaika);
		Trace.out(Trace.Level.INFO,"Asiakas "+id+ " viipyi:" +(poistumisaika-saapumisaika));
		sum += (poistumisaika-saapumisaika);
		double keskiarvo = sum/palveltutAsiakkaat;
		System.out.println("Asiakkaiden läpimenoaikojen keskiarvo "+ keskiarvo);
	}
}
