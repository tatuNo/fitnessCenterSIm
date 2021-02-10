package osat;

/**
 * Singleton kello määrittää simuloinnin ajankulun ja tarjoaa metodit ajan asettamiseksi ja ajan 
 * saamiseksi.
 * @author Tatu Nordström
 * @author Nico Järvinen
 *
 */
public class Kello {
	/** Muuttuja kellon ajalle. */
	private double aika;
	/** Staattinen muuttuja kellon instanssille. */
	private static Kello instanssi;
	
	/**
	 * Alustaa ajan nollaksi.
	 */
	private Kello(){
		aika = 0;
	}
	
	/**
	 * Luo uuden kellon, jos instanssia ei ole vielä luotu.
	 * @return palauttaa aina saman instanssin kellosta.
	 */
	public static Kello getInstance(){
		if (instanssi == null){
			instanssi = new Kello();	
		}
		return instanssi;
	}
	
	/**
	 * @param aika asettaa kellonajan.
	 */
	public void setAika(double aika){
		this.aika = aika;
	}

	/**
	 * @return palauttaa kellon ajan.
	 */
	public double getAika(){
		return aika;
	}
}
