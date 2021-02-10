package osat;

/**
 * Luokka josta luodaan palvelupistekohtaisesti olioita simulaation tuloksille.
 * Luokan ilmentymiä viemme SuorituskykysuureetAccessObjectilla SQL tietokantaan.
 * @author Tatu Nordström
 *
 */
public class Suorituskykysuureet {
	
	private int palveltutAsiakkaat;
	private double aktiiviaika;
	private double kayttoaste;
	private double suoritusteho;
	private double avgPalveluaika;
	private double lapimenoAjat;
	private double avgLapimenoajat;
	private double avgjononpituus;
	
	private String taulunnimi;
	private String paivays;
	private int simulointiaika;
	
	/**
	 * Konstruktori palvelupisteille, joista on laskettu kaikki tutkailtavat suorituskykysuureet.
	 * @param palveltutAsiakkaat palveltujen asiakkaiden määrä C.
	 * @param aktiiviaika palvelupisteen aktiiviaika B.
	 * @param kayttoaste palvelupisteen kayttoaste  U =  B / T(simulointiaika).
	 * @param suoritusteho palveltujen asiakkaiden lukumäärä tunnissa X = C / T. 
	 * @param avgPalveluaika keskimääräinen palveluaika S = B / C.
	 * @param lapimenoAjat kokonaisoleskeluaika, kaikkien asiakkaiden lapimenoaikojen summa W.
	 * @param avglapimenoAjat keskimääräinen läpimenoaika W / C.
	 * @param avgjononpituus keskimääräinen jonon pituus  W / T.
	 */
	public Suorituskykysuureet (int palveltutAsiakkaat, double aktiiviaika, double kayttoaste, double suoritusteho, double avgPalveluaika, double lapimenoAjat, double avglapimenoAjat, double avgjononpituus) {
		this.palveltutAsiakkaat = palveltutAsiakkaat;
		this.aktiiviaika = aktiiviaika;
		this.kayttoaste = kayttoaste;
		this.suoritusteho = suoritusteho;
		this.avgPalveluaika = avgPalveluaika;
		this.lapimenoAjat = lapimenoAjat;
		this.avgLapimenoajat = avglapimenoAjat;
		this.avgjononpituus = avgjononpituus;
		
	}
	
	/**
	 * Konstruktori palvelupisteille, joista ei lasketa kaikkia suorituskykysuureita.
	 * @param palveltutAsiakkaat palveltujen asiakkaiden määrä C.
	 * @param aktiiviaika palvelupisteen aktiiviaika B.
	 * @param kayttoaste palvelupisteen kayttoaste  U =  B / T(simulointiaika).
	 * @param suoritusteho palveltujen asiakkaiden lukumäärä tunnissa X = C / T.
	 * @param avgpalveluaika keskimääräinen palveluaika S = B / C.
	 */
	public Suorituskykysuureet (int palveltutAsiakkaat, double aktiiviaika, double kayttoaste, double suoritusteho, double avgpalveluaika) {
		this.palveltutAsiakkaat = palveltutAsiakkaat;
		this.aktiiviaika = aktiiviaika;
		this.kayttoaste = kayttoaste;
		this.suoritusteho = suoritusteho;
		this.avgPalveluaika = avgpalveluaika;
	}
	
	/**
	 * Tyhjä konstruktori.
	 */
	
	public Suorituskykysuureet() {
		
	}
	
	/**
	 * @param paivays asettaa päiväyksen.
	 */
	
	public void setPaivays (String paivays) {
		this.paivays = paivays;
	}
	
	/**
	 * @return päiväys string muodossa.
	 */
	
	public String getPaivays () {
		return paivays;
	}
	
	/**
	 * @param aika asettaa simulointiajan.
	 */
	
	public void setSimulointiaika (int aika) {
		this.simulointiaika = aika;
	}
	
	/**
	 * @return simulointiaika.
	 */
	
	public int getSimulointiaika () {
		return this.simulointiaika;
	}
	
	/**
	 * @param nimi asettaa oliolle taulun nimen, jota käytetään tietokantaan viemisessä.
	 */
	
	public void setTaulunNimi (String nimi) {
		this.taulunnimi = nimi;
	}
	
	/**
	 * @return tietokanta taulun nimi.
	 */
	
	public String getTaulunNimi () {
		return taulunnimi;
	}
	
	/**
	 * @return palveltujen asikkaiden määrä.
	 */
	
	public int getPalveltutAsiakkaat() {
		return palveltutAsiakkaat;
	}
	
	/**
	 * @param palveltutAsiakkaat asettaa palveltujen asiakkaiden määrän.
	 */
	
	public void setPalveltutAsiakkaat(int palveltutAsiakkaat) {
		this.palveltutAsiakkaat = palveltutAsiakkaat;
	}
	
	/**
	 * @return aktiiviaika.
	 */
	
	public double getAktiiviaika() {
		return aktiiviaika;
	}
	
	/**
	 * @param aktiiviaika asettaa aktiiviajan.
	 */
	
	public void setAktiiviaika(double aktiiviaika) {
		this.aktiiviaika = aktiiviaika;
	}
	
	/**
	 * @return käyttöaste.
	 */
	
	public double getKayttoaste() {
		return kayttoaste;
	}
	
	/**
	 * @param kayttoaste asettaa käyttöasteen.
	 */
	
	public void setKayttoaste(double kayttoaste) {
		this.kayttoaste = kayttoaste;
	}
	
	/**
	 * @return suoritusteho.
	 */
	
	public double getSuoritusteho() {
		return suoritusteho;
	}
	
	/**
	 * @param suoritusteho asettaa suoritustehon.
	 */
	
	public void setSuoritusteho(double suoritusteho) {
		this.suoritusteho = suoritusteho;
	}
	
	/**
	 * @return keskimääräinen palveluaika.
	 */
	
	public double getAvgPalveluaika() {
		return avgPalveluaika;
	}
	
	/**
	 * @param avgPalveluaika asettaa keskimääräisen palveluajan.
	 */
	
	public void setAvgPalveluaika(double avgPalveluaika) {
		this.avgPalveluaika = avgPalveluaika;
	}
	
	/**
	 * @return läpimenoaikojen summa.
	 */
	
	public double getLapimenoAjat() {
		return lapimenoAjat;
	}
	
	/**
	 * @param lapimenoAjat asettaa läpimenoaikojen summan.
	 */
	
	public void setLapimenoAjat(double lapimenoAjat) {
		this.lapimenoAjat = lapimenoAjat;
	}
	
	/**
	 * @return keskimääräinen läpimenoaika.
	 */
	
	public double getAvgLapimenoajat() {
		return avgLapimenoajat;
	}
	
	/**
	 * @param avgLapimenoajat asettaa keskimääräisen läpimenoajan.
	 */
	
	public void setAvgLapimenoajat(double avgLapimenoajat) {
		this.avgLapimenoajat = avgLapimenoajat;
	}
	
	/**
	 * @return keskimääräinen jonon pituus.
	 */
	
	public double getAvgjononpituus() {
		return avgjononpituus;
	}
	
	/**
	 * @param avgjononpituus asettaa keskimääräisen jonon pituuden.
	 */
	
	public void setAvgjononpituus(double avgjononpituus) {
		this.avgjononpituus = avgjononpituus;
	}
	
}
