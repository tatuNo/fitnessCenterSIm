package osat;

import java.util.PriorityQueue;

/**
 * Luokka pitää sisällään listan, joka pitää tapahtumat oikeassa ajan mukaisessa järjestyksessä.
 * Uudet tapahtumat viedään tapahtumalistaan.
 * @author Tatu Nordström
 * @author Nico Järvinen
 */
public class Tapahtumalista {
	/** Lista johon tapahtumat lisätään, pysyvät aikajärjestyksessä. */
	private PriorityQueue<Tapahtuma> lista = new PriorityQueue<Tapahtuma>();
	
	/**
	 * Tyhjä konstruktori.
	 */
	public Tapahtumalista(){
	 
	}
	
	/**
	 * Poistaa tapahtumalistasta ensimmäisenä olevan tapahtuman.
	 * @return poistettu tapahtuma.
	 */
	public Tapahtuma poista(){
		Trace.out(Trace.Level.INFO,"Poisto " + lista.peek());
		return lista.remove();
	}
	
	/**
	 * Lisää listaan tapahtuman.
	 * @param t lisättävä tapahtuma.
	 */
	public void lisaa(Tapahtuma t){
		lista.add(t);
	}
	
	/**
	 * Palauttaa listassa seuraavana vuorossa olevan ajan.
	 * @return seuraavan tapahtuman aika.
	 */
	public double getSeuraavanAika(){
		return lista.peek().getAika();
	}
}
