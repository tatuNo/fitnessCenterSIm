package osat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import controller.KontrolleriIf;

import eduni.distributions.*;
import osat.AsiakkaanTyyppi.AsiakkaanSukupuoli;

/**
 * Simulaattorin moottori, käsittelee asiakasvirtaa ja suorittaa tapahtumia.
 * @author Tatu Nordström
 * @author Nico Järvinen
 */
public class Moottori extends Thread implements MoottoriIf{
	/** Kontrolleri käyttöliittymän hallintaan. */
	private KontrolleriIf kontrolleri;
	/** Simulointiaika. */
	private double simulointiaika = 0;
	/** Kello ajan hallintaan. */
	private Kello kello;
	/** Simulaattorin käyttöliittymässä käytettävä viive. */
	private long viive = 0;
	/** Saapumisprosessi saapumisten luomiseen. */
	private Saapumisprosessi saapumisprosessi;
	/** Tapahtumalista tapahtumien hallintaan. */
	private Tapahtumalista tapahtumalista;
	/** Vastaanoton palvelupiste. */
	private Palvelupiste vastaanotto;
	/** Hieronnan palvelupiste. */
	private Palvelupiste hieronta;
	/** Röntgenin palvelupiste. */
	private Palvelupiste rontgen;
	/** Miesten pukuhuone. */
	private Pukuhuone pukuhuoneM;
	/** Naisten pukuhuone. */
	private Pukuhuone pukuhuoneN;
	/** Kuntosali palvelupiste. */
	private KapasiteettiPalvelupiste kuntosali;
	/** Juoksumatto palvelupiste. */
	private KapasiteettiPalvelupiste juoksumatto;
	/** Kuntosalin kapasiteetti. */
	private int kuntosaliKapasiteetti = 30;
	/** Juoksumaton kapasiteetti. */
	private int juoksumattoKapasiteetti = 12;
	/** Pukuhuoneen kapasiteetti. */
	private int pukuhuoneKapasiteetti = 50;
	/** Muuttuja johon haetaan käyttäjän syöttämä jakauman arvo. */
	private static int x = 3;
	/** Muuttuja johon haetaan käyttäjän syöttämä jakauman arvo. */
	private static int y = 2;
	/** Muuttuja simulaation jälkeiseen alerttiin. */
	private static int asiakasMaara = 0;
	/** Muuttuja simulaation jälkeiseen alerttiin. */
	private static int palveltutAsiakkaat = 0;
	/** Ryhmäliikunnan palvelupiste. */
	private Ryhmaliikunta ryhmaliikunta;
	/** Fysioterapian palvelupiste. */
	private Palvelupiste fysioterapia;
	/** Apu asiakas. */
	private Asiakas a;
	/** Vastaanoton Suorituskykysuure olio. */
	private Suorituskykysuureet vastaanottoSuureet;
	/** Miesten pukuhuoneen Suorituskykysuure olio. */
	private Suorituskykysuureet phmSuureet;
	/** Naisten pukuhuoneen Suorituskykysuure olio. */
	private Suorituskykysuureet phnSuureet;
	/** Kuntosalin Suorituskykysuure olio. */
	private Suorituskykysuureet kuntosaliSuureet;
	/** Juoksumaton Suorituskykysuure olio. */
	private Suorituskykysuureet juoksuMattoSuureet;
	/** Röntgenin Suorituskykysuure olio. */
	private Suorituskykysuureet rontgenSuureet;
	/** Hieronnan Suorituskykysuure olio. */
	private Suorituskykysuureet hierontaSuureet;
	/** Ryhmäliikunnan Suorituskykysuure olio. */
	private Suorituskykysuureet ryhmaliiSuureet;
	/** Fysioterapian Suorituskykysuure olio. */
	private Suorituskykysuureet fysioSuureet;
	/** Lista Suorituskykysuure olioille. */
	private ArrayList<Suorituskykysuureet> suurelista = new ArrayList<Suorituskykysuureet> ();
	/** Päiväys Suorituskykysuurre olioille. */
	private LocalDateTime paivays;
	/** Päiväyksen formaatti. */
	private DateTimeFormatter dtf;
	/** DataAccess objekti. */
	private ISuorituskykysuureetDAO dao;

	/**
	 * Moottorin konstruktorissa tehdään tarvittavia alustuksia simuloinnin käynnistämiseksi, kuten luodaan
	 * palvelupisteet sekä ensimmäinen saapumistapahtuma.
	 * @param kontrolleri moottorin kontrolleri
	 */
	public Moottori(KontrolleriIf kontrolleri){

		//Kommentoi n�m� pois ennen testej�!!!

		kontrolleri.deleteAsiakkaat();
		kontrolleri.setRontgenSize(0);
		kontrolleri.setFysioSize(0);
		kontrolleri.setHierontaSize(0);
		kontrolleri.setRLSize(0);
		kontrolleri.setKuntosaliSize(0);
		kontrolleri.setJuoksuSize(0);
		kontrolleri.setNPHSize(0);
		kontrolleri.setMPHSize(0);
		kontrolleri.setVastaanottoSize(0);

		asiakasMaara = 0;
		palveltutAsiakkaat = 0;

		
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		paivays = LocalDateTime.now();

		this.kontrolleri = kontrolleri;
		vastaanotto = new Palvelupiste(new Normal(2, 1), this, TapahtumanTyyppi.DEP1);

		pukuhuoneM = new Pukuhuone(new Normal(5,2), pukuhuoneKapasiteetti, this, TapahtumanTyyppi.DEP2, TapahtumanTyyppi.DEP10);
		pukuhuoneN = new Pukuhuone(new Normal(5,2), pukuhuoneKapasiteetti, this, TapahtumanTyyppi.DEP3, TapahtumanTyyppi.DEP11);

		kuntosali = new KapasiteettiPalvelupiste(new Normal(40, 15), kuntosaliKapasiteetti, this, TapahtumanTyyppi.DEP8);
		juoksumatto = new KapasiteettiPalvelupiste(new Normal(25, 15), juoksumattoKapasiteetti, this, TapahtumanTyyppi.DEP9);
		
		rontgen = new Palvelupiste(new Normal(15, 5), this, TapahtumanTyyppi.DEP4);
		hieronta = new Palvelupiste(new Normal(30,15), this, TapahtumanTyyppi.DEP5);
		ryhmaliikunta = new Ryhmaliikunta(this, TapahtumanTyyppi.DEP6);
		fysioterapia = new Palvelupiste(new Normal(30, 15), this, TapahtumanTyyppi.DEP7);

		kello = Kello.getInstance(); // Otetaan kello muuttujaan yksinkertaistamaan koodia
		kello.setAika(0);
		
		//KOMMENTOI N�M� KAKSI POIS ENNEN TESTEJ�
		x = getJakaumaX();
		y = getJakaumaY();
		
		saapumisprosessi = new Saapumisprosessi(this, new Negexp(x, y),TapahtumanTyyppi.ARR1);
		tapahtumalista = new Tapahtumalista();	
		saapumisprosessi.generoiSeuraava(); // Ensimm�inen saapuminen!!

	}

	/**
	 * Hakee Kontrolleri luokan kautta käyttöliittymään syötetyn keskiarvon.
	 * Keskiarvoa käytetään saapumisprosessissa.
	 * 
	 * @return int
	 */
	public int getJakaumaX() {
		return kontrolleri.getJakaumaX();
	}
	
	/**
	 * Hakee Kontrolleri luokan kautta käyttöliittymään syötetyn hajonnan.
	 * Hajontaa käytetään saapumisprosessissa.
	 * 
	 * @return int
	 */
	public int getJakaumaY() {
		return kontrolleri.getJakaumaY();
	}
	
	@Override
	public void setSimulointiaika(double aika) {
		simulointiaika = aika;
	}

	@Override
	public void setViive(long viive) {
		this.viive = viive;
	}

	
	@Override
	public long getViive() {
		return viive;
	}
	
	@Override
	public double getAika() {
		return kello.getAika();
	}
	
	@Override
	public int getPalveltutAsiakkaat() {
		return palveltutAsiakkaat;
	}
	
	@Override
	public int getKaikkiAsiakkaat() {
		return asiakasMaara;
	}
	
	/**
	 * Käynnistää moottorisäikeen. Päivittää kelloa seuraavaan tapahtumahetkeen ja suorittaa tapahtumia, kunnes
	 * simulointiaika päättyy. Lopussa kutsuu moottorin tulokset metodia.
	 */
	@Override
	public void run(){
		while (simuloidaan()){
			try {
				viive();
				kello.setAika(nykyaika());
				suoritaBTapahtumat();
				yritaCTapahtumat();
			} 
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		tulokset();
	}

	/**
	 * Suorittaa B tapahtumia niin kauan, kun kellon aika on sama kuin tapahtumalistan seuraavan tapahtuman aika.
	 */
	void suoritaBTapahtumat(){
		while (tapahtumalista.getSeuraavanAika() == kello.getAika()){
			suoritaTapahtuma(tapahtumalista.poista());
		}
	}

	/**
	 * C tapahtumissa tarkastetaan, voidaanko palveluita aloittaa, eli onko FIFO palvelupisteissä vapaata ja onko siellä
	 * asiakas jonossa sekä tarkastetaan voidaanko ryhmäliikunta käynnistää.
	 */
	void yritaCTapahtumat(){

		if(!vastaanotto.onVarattu() && vastaanotto.onJonossa()) {
			vastaanotto.aloitaPalvelu();
		}
		if(!fysioterapia.onVarattu() && fysioterapia.onJonossa()) {
			fysioterapia.aloitaPalvelu();
		}
		if(!hieronta.onVarattu() && hieronta.onJonossa()) {
			hieronta.aloitaPalvelu();
		}
		if(!rontgen.onVarattu() && rontgen.onJonossa()) {
			rontgen.aloitaPalvelu();
		}
		if(ryhmaliikunta.onTaysi() && !ryhmaliikunta.getOnkaynnissa()) {
			ryhmaliikunta.aloitaPalvelu();
		}
	}


	/**
	 * Keskitetty algoritmi tapahtumien käsittelyyn ja asiakkaiden siirtymisten hallintaan. Asiakkaita liikutellaan 
	 * palvelupisteeltä toiselle asiakkaan sukupuolen, asiakkaan palveluntarpeen sekä tapahtuman tyypin perusteella.
	 * @param t suoritettava tapahtuma.
	 */
	void suoritaTapahtuma(Tapahtuma t){
		
		switch (t.getTyyppi()){

		case ARR1: 
		asiakasMaara++;
		vastaanotto.lisaaJonoon(new Asiakas(AsiakkaanTyyppi.arvoTyyppi(), AsiakkaanTyyppi.arvoSukupuoli()));
		kontrolleri.visualisoiAsiakas();
		kontrolleri.setVastaanottoSize(vastaanotto.getJonoSize());
		saapumisprosessi.generoiSeuraava();
		break;
		case DEP1: // LÃ¤hteminen vastaanotosta
			// Ohjaa oikeaan pukuhuoneeseen sukupuolen perusteella
			a = vastaanotto.otaJonosta();
			if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
				System.out.println(a + " miesten pukuhuoneeseen");
				kontrolleri.setId(a.getId());
				kontrolleri.AsiakasVtoPH();
				pukuhuoneM.lisaaPukuhuoneeseen(a);
				kontrolleri.setMPHSize(pukuhuoneM.getJonoSize());
			} else {
				System.out.println(a + " naisten pukuhuoneeseen");
				kontrolleri.setId(a.getId());
				kontrolleri.AsiakasVtoPH();
				pukuhuoneN.lisaaPukuhuoneeseen(a);
				kontrolleri.setNPHSize(pukuhuoneN.getJonoSize());
			}
			break;
		case DEP2: // LÃ¤hde miesten pukuhuoneesta, ohjaa asiakkaan tyypin mukaan palveluun

			a = pukuhuoneM.siiraPukuhuoneesta(); 
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.HIERONTA) {
				// hierontaan
				System.out.println(a + " hieronta jonoon");
				kontrolleri.AsiakasPHtoH();
				hieronta.lisaaJonoon(a);
				kontrolleri.setHierontaSize(hieronta.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.RYHMALIIKUNTA) {
				//ryhmaliikuntaan
				System.out.println(a + " ryhmÃ¤liikunta jonoon");
				kontrolleri.AsiakasPHtoRL();
				ryhmaliikunta.lisaaJonoon(a);
				kontrolleri.setRLSize(ryhmaliikunta.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.RONTGEN) {
				//rontgeniin
				System.out.println(a + " rontgen jonoon");
				kontrolleri.AsiakasPHtoR();
				rontgen.lisaaJonoon(a);
				kontrolleri.setRontgenSize(rontgen.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.FYSIOTERAPIA) {
				// fysioterapiaan
				System.out.println(a + " fysioterapia jonoon");
				kontrolleri.AsiakasPHtoF();
				fysioterapia.lisaaJonoon(a);
				kontrolleri.setFysioSize(fysioterapia.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.KUNTOSALI) {
				// kuntosalille
				System.out.println(a + " kuntosali jonoon");
				kontrolleri.AsiakasPHtoK();
				kuntosali.lisaaPalvelupisteeseen(a);
				kontrolleri.setKuntosaliSize(kuntosali.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.JUOKSIJA) {
				// juoksemaan
				System.out.println(a + " juoksumatto jonoon");
				kontrolleri.AsiakasPHtoJ();
				juoksumatto.lisaaPalvelupisteeseen(a);
				kontrolleri.setJuoksuSize(juoksumatto.getJonoSize());
			}
			break;  
		case DEP3: 
			// LÃ¤hde naisten pukuhuoneesta, ohjaa asiakkaan tyypin mukaan palveluun 
			a = pukuhuoneN.siiraPukuhuoneesta(); 
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.HIERONTA) {
				// hierontaan
				System.out.println(a + " hieronta jonoon");
				kontrolleri.AsiakasPHtoH();
				hieronta.lisaaJonoon(a);
				kontrolleri.setHierontaSize(hieronta.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.RYHMALIIKUNTA) {
				//ryhmaliikuntaan
				System.out.println(a + " ryhmÃ¤liikunta jonoon");
				kontrolleri.AsiakasPHtoRL();
				ryhmaliikunta.lisaaJonoon(a);
				kontrolleri.setRLSize(ryhmaliikunta.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.RONTGEN) {
				//rontgeniin
				System.out.println(a + " rontgen jonoon");
				kontrolleri.AsiakasPHtoR();
				rontgen.lisaaJonoon(a);
				kontrolleri.setRontgenSize(rontgen.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.FYSIOTERAPIA) {
				// fysioterapiaan
				System.out.println(a + " fysioterapia jonoon");
				kontrolleri.AsiakasPHtoF();
				fysioterapia.lisaaJonoon(a);
				kontrolleri.setFysioSize(fysioterapia.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.KUNTOSALI) {
				// kuntosalille
				System.out.println(a + " kuntosali jonoon");
				kontrolleri.AsiakasPHtoK();
				kuntosali.lisaaPalvelupisteeseen(a);
				kontrolleri.setKuntosaliSize(kuntosali.getJonoSize());
			}
			if (a.getAsiakkaanTyyppi() == AsiakkaanTyyppi.JUOKSIJA) {
				// juoksemaan
				System.out.println(a + " juoksumatto jonoon");
				kontrolleri.AsiakasPHtoJ();
				juoksumatto.lisaaPalvelupisteeseen(a);
				kontrolleri.setJuoksuSize(juoksumatto.getJonoSize());
			}
			break;  
		case DEP4:
			a = rontgen.otaJonosta();
			System.out.println(a + " rÃ¶ntgenÃ¶ity lÃ¤htee himaan");
			if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
				kontrolleri.AsiakasRtoPH();
				pukuhuoneM.palaaPukuhuoneeseen(a);
			} else {
				kontrolleri.AsiakasRtoPH();
				pukuhuoneN.palaaPukuhuoneeseen(a);
			}

			break;
		case DEP5:  
			a = hieronta.otaJonosta();
			System.out.println(a + " hierottu lÃ¤htee himaan");
			if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
				kontrolleri.AsiakasHtoPH();
				kontrolleri.setMPHSize(pukuhuoneM.getJonoSize());
				pukuhuoneM.palaaPukuhuoneeseen(a);
			} else {
				kontrolleri.AsiakasHtoPH();
				kontrolleri.setNPHSize(pukuhuoneM.getJonoSize());
				pukuhuoneN.palaaPukuhuoneeseen(a);
			}

			break;
		case DEP6:
			a = ryhmaliikunta.otaJonosta();
			
			if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
				kontrolleri.AsiakasRLtoPH();
				pukuhuoneM.palaaPukuhuoneeseen(a);
			} else {
				kontrolleri.AsiakasRLtoPH();
				pukuhuoneN.palaaPukuhuoneeseen(a);
			}
			break;
		case DEP7:	
			a = fysioterapia.otaJonosta();
			System.out.println(a + " fysioterapioitu lÃ¤htee himaan");
			if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
				kontrolleri.AsiakasFtoPH();
				pukuhuoneM.palaaPukuhuoneeseen(a);
			} else {
				kontrolleri.AsiakasFtoPH();
				pukuhuoneN.palaaPukuhuoneeseen(a);
			}
			break;

		case DEP8:
			a = kuntosali.siiraPalvelupisteesta();
			System.out.println(a + " treeni vedytty, asiakas lï¿½htee himaan");
			if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
				kuntosali.poistuPalvelupisteesta();
				kontrolleri.AsiakasKtoPH();
				pukuhuoneM.palaaPukuhuoneeseen(a);
			} else {
				kuntosali.poistuPalvelupisteesta();
				kontrolleri.AsiakasKtoPH();
				pukuhuoneN.palaaPukuhuoneeseen(a);
			}
			break;
		case DEP9:
			a = juoksumatto.siiraPalvelupisteesta();
			System.out.println(a + " juoksut juostu, asiakas lï¿½htee himaan");
			if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
				juoksumatto.poistuPalvelupisteesta();
				kontrolleri.AsiakasJtoPH();
				pukuhuoneM.palaaPukuhuoneeseen(a);
			} else {
				juoksumatto.poistuPalvelupisteesta();
				kontrolleri.AsiakasJtoPH();
				pukuhuoneN.palaaPukuhuoneeseen(a);
			}
			break;
		case DEP10:
			a = pukuhuoneM.poistuPukuhuoneesta();
			kontrolleri.AsiakasPHtoS();
			a.setPoistumisaika(kello.getAika());
			a.raportti();
			break;
		case DEP11:
			a = pukuhuoneN.poistuPukuhuoneesta();
			kontrolleri.AsiakasPHtoS();
			a.setPoistumisaika(kello.getAika());
			a.raportti();
			break;		
		}	
	}

	/**
	 * Lisää tapahtumalistaan uuden tapahtuman.
	 * @param t lisättävä tapahtuma.
	 */
	public void uusiTapahtuma(Tapahtuma t){
		tapahtumalista.lisaa(t);
	}


	/**
	 * Käytetään siinä, että saadaan kello siirrettyä seuraavan tapahtuman aikaan.
	 * @return tapahtumalistan seuraavan tapahtuman aika.
	 */
	public double nykyaika(){
		return tapahtumalista.getSeuraavanAika();
	}

	/**
	 * @return true jos simulointiaika on pienempi kuin kellon aika, false muuten.
	 */
	private boolean simuloidaan(){
		Trace.out(Trace.Level.INFO, "Kello on: " + kello.getAika());
		return kello.getAika() < simulointiaika;
	}

	/**
	 * Simuloinnin päättyessä kutsuttava metodi. Printataan konsoliin tuloksia, asetetaan Suorituskykysuureille oikea 
	 * taulun nimi, simulointiaika sekä päiväys. Päivietään laskuarvoja alkuarvoihin, jotta voidaan ajaa uusi simulaatio käynnistämättä
	 * sovellusta uudelleen.
	 */
	private void tulokset(){
		Asiakas a = new Asiakas();
		System.out.println("Simulointi pï¿½ï¿½ttyi kello " + kello.getAika());
		System.out.println("Asiakkaita järjestelmän läpi meni " + a.getPalveltutAsiakkaat());
		System.out.println("Vastaanotto " + vastaanotto.raportti());
		vastaanottoSuureet = vastaanotto.getSuorituskykysuureet();
		vastaanottoSuureet.setTaulunNimi("vastaanotto");
		suurelista.add(vastaanottoSuureet);
		
		System.out.println("Miesten pukuhuone: " + pukuhuoneM.raportti());
		phmSuureet = pukuhuoneM.getSuorituskykysuureet();
		phmSuureet.setTaulunNimi("miestenPH");
		suurelista.add(phmSuureet);
		
		System.out.println("Naisten pukuhuone " + pukuhuoneN.raportti());
		phnSuureet = pukuhuoneN.getSuorituskykysuureet();
		phnSuureet.setTaulunNimi("naistenPH");
		suurelista.add(phnSuureet);
		
		System.out.println("Hieronta: " + hieronta.raportti());
		hierontaSuureet = hieronta.getSuorituskykysuureet();
		hierontaSuureet.setTaulunNimi("hieronta");
		suurelista.add(hierontaSuureet);
		
		System.out.println("Fysioterapia: " + fysioterapia.raportti());
		fysioSuureet = fysioterapia.getSuorituskykysuureet();
		fysioSuureet.setTaulunNimi("fysioterapia");
		suurelista.add(fysioSuureet);
		
		System.out.println("RÃ¶ntgen: " + rontgen.raportti());
		rontgenSuureet = rontgen.getSuorituskykysuureet();
		rontgenSuureet.setTaulunNimi("rontgen");
		suurelista.add(rontgenSuureet);
		
		System.out.println("Kuntosali: " + kuntosali.raportti());
		kuntosaliSuureet = kuntosali.getSuorituskykysuureet();
		kuntosaliSuureet.setTaulunNimi("kuntosali");
		suurelista.add(kuntosaliSuureet);
		
		System.out.println("Juoksumatto: " + juoksumatto.raportti());
		juoksuMattoSuureet = juoksumatto.getSuorituskykysuureet();
		juoksuMattoSuureet.setTaulunNimi("juoksumatto");
		suurelista.add(juoksuMattoSuureet);
		
		System.out.println("RyhmÃ¤liikunta: " + ryhmaliikunta.raportti());
		ryhmaliiSuureet = ryhmaliikunta.getSuorituskykysuureet();
		ryhmaliiSuureet.setTaulunNimi("ryhmaliikunta");
		suurelista.add(ryhmaliiSuureet);
		
		for(Suorituskykysuureet s : suurelista) {
			s.setPaivays(dtf.format(paivays));
			s.setSimulointiaika((int)kello.getAika());
		}


		kontrolleri.naytaLoppuaika(kello.getAika());
		palveltutAsiakkaat = a.getPalveltutAsiakkaat();
		a.setAlkuarvot();
	}

	@Override 
	public void tallennaTulokset () {
		dao = new SuorituskykysuureetAccessObject();
		for(Suorituskykysuureet s : suurelista) {
			dao.luoSuorituskykysuurre(s);
		}
	}


	/**
	 * Kutsuu Thread.sleep metodia, jolla moottori säiettä saadaan viivytettyä.
	 */
	private void viive() {
		System.out.println ("Viive " + viive);
		try {
			Thread.sleep(viive);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Käytettiin animaatioiden reititykseen.
	 */
	@Override
	public boolean asiakkaanSukupuoli() {
		if(a.getAsiakkaanSukupuoli() == AsiakkaanSukupuoli.MIES) {
			return true;
		}
		return false;
	}
}