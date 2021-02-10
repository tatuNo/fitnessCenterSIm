package controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import osat.Moottori;
import osat.MoottoriIf;

import view.*;

/**
 * Kontrolleri luokka yhdistää ohjelman näkymän ja mallin.
 * @author Tatu Nordström
 * @author Nico Järvinen
 *
 */
public class Kontrolleri implements KontrolleriIf {
	/**
	* Määritetään moottorin interface.
	*/
	private MoottoriIf moottori;
	/**
	* Määritetään käyttöliittymän interface.
	*/
	private GuiIf gui;
	/**
	* Määritetään asiakkaan id muuttuja.
	*/
	private int id = 0;
	
	/**
   	* Konstruktori, jossa määritetään käyttöliittymän interface tälle luokalle.
   	* 
   	* @param gui käyttöliittymän interface, jotta Kontrolleri toimii Main luokassa.
   	*/
	public Kontrolleri(GuiIf gui) {
		this.gui = gui;
	}

	
	// Moottorin ohjausta:
	/**
   	* Yliajo metodi, jossa määritetään simulaation käynnistys moottorissa.
   	* Luodaan uusi mootorisäie ja asetetaan tarvittavat arvot käyttöliittymästä moottoriin.
   	* 
   	*
   	* @return void
   	*/
	@Override
	public void kaynnistaSimulointi() {
		moottori = new Moottori(this); // luodaan uusi moottorisäie jokaista simulointia varten
		moottori.setSimulointiaika(gui.getAika());
		moottori.setViive(gui.getViive());
        
		((Thread)moottori).start();
		//((Thread)moottori).run();
	}
	
	/**
   	* Yliajo metodi, jossa haetaan viive Moottori luokasta.
   	*
   	* @return long
   	*/
	@Override
	public long getViive() {
		return moottori.getViive();
	}
	/**
   	* Yliajo metodi, jossa haetaan Moottori luokasta palveltujen asiakkaiden määrä.
   	*
   	* @return int
   	*/
	@Override
	public int getPalveltutAsiakkaat() {
		return moottori.getPalveltutAsiakkaat();
	}
	
	/**
   	* Yliajo metodi, jossa haetaan Moottori luokasta kaikkien simulaation aikana tulleiden asiakkaiden määrä.
   	* 
   	* @return int
   	*/
	@Override
	public int getKaikkiAsiakkaat() {
		return moottori.getKaikkiAsiakkaat();
	}
	/**
   	* Yliajo metodi, jossa kasvatetaan simulaation viivettä Moottori luokassa.
   	*
   	* @return void
   	*/
	@Override
	public void hidasta() { // hidastetaan moottorisäiettä
		moottori.setViive((long)(moottori.getViive()*2));
		System.out.println(moottori.getViive());
	}

	/**
   	* Yliajo metodi, jossa pienennetään simulaation viivettä Moottori luokassa.
   	*
   	* @return void
   	*/
	@Override
	public void nopeuta() { // nopeutetaan moottorisäiettä
		moottori.setViive((long)(moottori.getViive()*0.5));
		System.out.println(moottori.getViive());
	}
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override
	public void setVastaanottoSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setVastaanottoAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override 
	public void setRLSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setRLAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override 
	public void setJuoksuSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setJuoksuAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override 
	public void setKuntosaliSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setKuntosaliAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override 
	public void setFysioSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setFysioAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override 
	public void setRontgenSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setRontgenAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override
	public void setHierontaSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setHierontaAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override 
	public void setMPHSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setMPHAsiakkaat(jonoSize);
			}
		});
	}
	
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu jononkoko
   	* käyttöliittymän tekstiin.
   	*
   	* @param jonoSize moottorista saatava jonon koko
   	* @return void
   	*/
	@Override
	public void setNPHSize(int jonoSize) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.setNPHAsiakkaat(jonoSize);
			}
		});	
	}
	// Simulointitulosten välittämistä käyttöliittymään.
	// Koska gui:n päivitykset tulevat moottorisäikeestä, ne pitää ohjata JavaFX-säikeeseen
		
	/**
   	* Yliajo metodi, jossa asetetaan moottorista saatu aika
   	* käyttöliittymän tekstiin.
   	*
   	* @param aika moottorista saatava loppuaika
   	* @return void
   	*/
	@Override
	public void naytaLoppuaika(double aika) {
		Platform.runLater(()->gui.setLoppuaika(aika)); 
	}
	 
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasVtoPH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.vastaanottoToPH();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasPHtoR() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.PHtoR();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasRtoPH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.RtoPH();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasPHtoF() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.PHtoF();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasFtoPH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.FtoPH();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasPHtoRL() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.PHtoRL();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasRLtoPH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.RLtoPH();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasPHtoK() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.PHtoK();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasKtoPH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.KtoPH();
			}
		});
	}	
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasPHtoJ() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.PHtoJ();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasJtoPH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.JtoPH();
			}
		});
	}	
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasPHtoH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.PHtoH();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasHtoPH() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.HtoPH();
			}
		});
	}	
	
	/**
   	* Yliajo metodi, jolla kutsutaan animaatio palvelupisteestä A pisteelle B.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void AsiakasPHtoS() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.PHtoS();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla luodaan uusi asiakas animaationäkymään.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void visualisoiAsiakas() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.createAsiakas();
			}
		});
	}

	/**
   	* Yliajo metodi, jolla poistetaan kaikki asiakkaat animaationäkymästä.
   	* Kutsu tapahtuu Moottori luokassa.
   	* Toteutus tapahtuu Main luokan kautta animaatio kontrollerissa.
   	*
   	* @return void
   	*/
	@Override
	public void deleteAsiakkaat() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				gui.deleteAllAsiakkaat();
			}
		});
	}
	
	/**
   	* Yliajo metodi, jolla haetaan asiakkaan sukupuoli Moottori luokasta.
   	* 
   	* @return boolean
   	*/
	@Override
	public boolean asiakkaanSukupuoli() {
		return moottori.asiakkaanSukupuoli();
	}
	
	/**
   	* Yliajo metodi, jolla haetaan asiakkaan id tämän luokan muuttujasta.
   	* 
   	* @return int
   	*/
	@Override
	public int getId() {
		return id;
	}
	
	/**
   	* Yliajo metodi, jolla asetetaan asiakkaan id Moottorista saaduksi arvoksi.
   	* 
   	* @return void
   	*/
	@Override
	public void setId(int id) {
		Platform.runLater(() -> this.id = id );
	}
	
	/**
   	* Yliajo metodi, joka kutsuu tietojen tallennuksen tietokantaan moottorissa.
   	* Käytetään Main luokassa.
   	* 
   	* @return void
   	*/
	@Override
	public void tallennaTulokset () {
		moottori.tallennaTulokset();
	}
	
	/**
   	* Yliajo metodi, joka palauttaa käyttöliittymään syötetyn keskiarvon moottorille.
   	* 
   	* @return int
   	*/
	@Override
	public int getJakaumaX() {
		return gui.getJakaumaX();
	}
	
	/**
   	* Yliajo metodi, joka palauttaa käyttöliittymään syötetyn hajonnan moottorille.
   	* 
   	* @return int
   	*/
	@Override
	public int getJakaumaY() {
		return gui.getJakaumaY();
	}	
	
	/**
   	* Yliajo metodi, joka palauttaa käyttöliittymään moottorista saadun ajan.
   	* 
   	* @return double
   	*/
	@Override
	public double getAika() {
		return moottori.getAika();
	}
}
