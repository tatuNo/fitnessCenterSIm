package osat;

/**
 * Rajapinta, joka määrittelee SuorituskykySuureetAccessObjectin metodit.
 * @author Tatu Nordström
 *
 */
public interface ISuorituskykysuureetDAO {
	
	/**
	 * Lisää SQL -tietokantaan simuloinnin tuloksina saatuja suorituskykysuureita.
	 * Jokaisella Suorituskykysuureet oliolla on nimi, jonka perusteella suureet tallennetaan oikeaan tauluun. 
	 * @param suureet talletettava Suorituskykysuureet olio.
	 * @return true jos tietokantaan tallennus onnistui, false jos ei.
	 */
	public boolean luoSuorituskykysuurre(Suorituskykysuureet suureet);
	
	/**
	 * Lukee SQL -tietokannasta halutun palvelupisteen kaikki talletetut suorituskykysuureet.
	 * @param palvelupiste taulun nimi, jonka suorituskykysuureet halutaan lukea tietokannasta.
	 * @return taulu, jossa palvelupisteen kaikki talletetut suorituskykysuureet.
	 */
	public Suorituskykysuureet [] lueSuorituskykysuurreet(String palvelupiste);
}
