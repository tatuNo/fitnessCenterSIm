package osat;


/**
 * Luokka, josta luodaan simulaattorin uudet tapahtumat.
 * @author Tatu Nordström
 * @author Nico Järvinen
 */
public class Tapahtuma implements Comparable<Tapahtuma> {
	
	/** Tapahtuman tyyppi. */	
	private TapahtumanTyyppi tyyppi;
	/** Tapahtuman kellon aika. */
	private double aika;
	
	/**
	 * Tapahtuman konstruktori.
	 * @param tyyppi uuden tapahtuman typppi.
	 * @param aika uuden tapahtuman aika.
	 */
	public Tapahtuma(TapahtumanTyyppi tyyppi, double aika){
		this.tyyppi = tyyppi;
		this.aika = aika;
	}
	
	/**
	 * @param tyyppi asettaa tapahtuman tyypin.
	 */
	public void setTyyppi(TapahtumanTyyppi tyyppi) {
		this.tyyppi = tyyppi;
	}
	/**
	 * @return tapahtuman tyyppi.
	 */
	public TapahtumanTyyppi getTyyppi() {
		return tyyppi;
	}
	/**
	 * @param aika asettaa tapahtuman ajan.
	 */
	public void setAika(double aika) {
		this.aika = aika;
	}
	/**
	 * @return tapahtuma aika.
	 */
	public double getAika() {
		return aika;
	}

	/**
	 * Metodi, jolla saadaan tapahtuman järjestettyä Tapahtumalistan priorityqueen oikeassa ajan järjestyksessä.
	 */
	@Override
	public int compareTo(Tapahtuma arg) {
		if (this.aika < arg.aika) return -1;
		else if (this.aika > arg.aika) return 1;
		return 0;
	}
	
	
	

}
