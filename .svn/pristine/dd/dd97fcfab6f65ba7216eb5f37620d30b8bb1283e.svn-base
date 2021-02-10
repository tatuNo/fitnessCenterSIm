package osat;

/**
 * Apuväline simuloinnin jäljittämiseen ja konsolitulostuksiin. 
 * @author Tatu Nordström
 * @author Nico Järvinen
 */
public class Trace {

	/**
	 * Jäljitys taso
	 * @author Tatu Nordström
	 * @author Nico Järvinen
	 */
	public enum Level{INFO, WAR, ERR}
	
	private static Level traceLevel;
	
	/**
	 * @param lvl asettaa jäljitystason.
	 */
	public static void setTraceLevel(Level lvl){
		traceLevel = lvl;
	}
	/**
	 * Tulostaa konsoliin tavaraa.
	 * @param lvl jäljitystaso.
	 * @param txt tulostettava teksti.
	 */
	public static void out(Level lvl, String txt){
		if (lvl.ordinal() >= traceLevel.ordinal()){
			System.out.println(txt);
		}
	}
	
	
	
}