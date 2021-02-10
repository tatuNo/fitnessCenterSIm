package osat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import eduni.distributions.Negexp;
import eduni.distributions.Normal;
import osat.AsiakkaanTyyppi.AsiakkaanSukupuoli;
import osat.Trace.Level;

/**
 * Käytettiin simulaattorin testausvaiheessa, kun graafista käyttöliittymää ei oltu vielä tehty.
 * @author Tatu Nordström
 * @author Nico Järvinen
 */
public class Simulaattori {

	public static void main(String[] args) {
		
		Negexp negexp = new Negexp (10,3);
		
		for(int i = 0; i < 50; i++); {
			System.out.println(negexp.sample());
		}
	}
}
