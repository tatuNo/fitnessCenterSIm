package osat;

import java.util.Random;

/**
 * AsiakkaanTyyppi määrittelee asikkaan palvelutarpeen tyypin.
 * @author Tatu Nordström
 *
 */
public enum AsiakkaanTyyppi {
	RONTGEN,
	JUOKSIJA,
	KUNTOSALI,
	FYSIOTERAPIA,
	HIERONTA,
	RYHMALIIKUNTA;
	
/**
 * AsiakkaanSukupuoli määrittelee asiakkaan sukupuolen.
 * @author Tatu Nordström
 *
 */
public enum AsiakkaanSukupuoli {
	MIES,
	NAINEN;
}
/** Lista kaikista AsiakkaanTyypeistä */
private static final AsiakkaanTyyppi[] TYYPIT = AsiakkaanTyyppi.values();
/** TYYPIT listan koko.*/
private static final int KOKO = TYYPIT.length;
/** Random työkalu arpomiseen. */
private static final Random RANDOM = new Random();
/** Lista sukupuolista. */
private static final AsiakkaanSukupuoli [] SUKUPUOLET = AsiakkaanSukupuoli.values();
/** Sukupuolilistan koko. */
private static final int KOKO2 = SUKUPUOLET.length;

/**
 * Arpoo asiakkaalle palvelutarpeen tyypin. Käytetään, kun luodaan järjestelmään uusi saapumistapahtuma.
 * @return AsiakkaanTyyppi kaikista mahdollisista tyypeistä Javan Random metodia hyödyntäen.
 */
public static AsiakkaanTyyppi arvoTyyppi()  {
	return TYYPIT[RANDOM.nextInt(KOKO)];
	}

/**
 * Arpoo asiakkaalle sukupuolen. Käytetään, kun luodaan järjestelmään uusi saapumistapahtuma.
 * @return AsiakkaanSukupuoli, mies tai nainen arvottuna Javan Random metodilla.
 */
public static AsiakkaanSukupuoli arvoSukupuoli()  {
	return SUKUPUOLET[RANDOM.nextInt(KOKO2)];
	}
}

