package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * Käyttöliittymän pohja, jossa on ylärivin työkalupalkki.
 * 
 * @author Nico Järvinen
 */
public class RootLayoutController implements Initializable{
	
	/**
	 * Main luokan määritys muuttujaan.
	 */
    private Main main;
    /**
   	 * Asettaa kontrollerin näkyville Main luokalle, jotta instanssin luominen on mahdollista FXMLLoaderissa.
   	 * 
   	 * @return void
   	 */
    public void setMain(Main main) {
        this.main = main;
    }
    
    /**
	 * Pohjanäkymän työkalupalkissa olevan tietoja valikon painikkeen käsittelijä.
	 * Luo hälytyksen painettaessa Tekijät painiketta, tyyppinä informaatio.
	 * Ohjelma odottaa kunnes OK painiketta painettu ja jatkaa sitten toimintaa.
	 * 
	 * @return void
	 */
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Kuntokeskus Simulaattori");
    	alert.setHeaderText("Tietoja");
    	alert.setContentText("Tekijät: Nico Järvinen ja Tatu Nordström");

    	alert.showAndWait();
    }
    
    /**
   	 * Pohjanäkymän työkalupalkissa olevan tietoja valikon painikkeen käsittelijä.
   	 * Luo hälytyksen painettaessa Ohjeet painiketta, tyyppinä informaatio.
   	 * Ohjelma odottaa kunnes OK painiketta painettu ja jatkaa sitten toimintaa.
   	 * 
   	 * @return void
   	 */
    @FXML
    private void handleOhjeet() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Kuntokeskus Simulaattori");
    	alert.setHeaderText("Ohjeet");
    	alert.setHeight(600);
    	alert.setContentText("Sininen laatikko näyttää palvelupisteen jonon pituuden.\nPunainen ympyrä kuvaa palvelupistettä ja jonoa.\nMustat ympyrät ovat asiakkaita.\n \nSimulaation aloittamiseksi täytyy asettaa simulointiaika minuuteissa, viive kuinka kauan jokaisen simulointitapahtuman välissä kestää ja asiakasmäärän keskiarvo ja hajonta.\n"
    			+ "\nTallenna tiedot painikkeella saat tallennettua simuloinnin tulokset tietokantaan. Nämä tulokset ovat näkyvissä kohdassa Tilastot --> Kuvaajat");

    	alert.showAndWait();
    }
    
    /**
   	 * Pohjanäkymän työkalupalkissa olevan tilastot valikon painikkeen käsittelijä.
   	 * Avaa uuden ikkunan jossa on StatisticsView näkymä Tilastot painiketta painettaessa.
   	 * 
   	 * @return void
   	 */
	@FXML
	public void handleStatistiikka() {
		main.showStatisticsView();
	}
	
	 /**
   	 * Pohjanäkymän työkalupalkissa olevan tiedosto valikon painikkeen käsittelijä.
	 * Pakottaa koko ohjelman sulkeutumaan ja palauttaa arvon 0.
	 * 
   	 * @return void
   	 */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    /**
  	* Yliajo metodi Initializable interfacelle, joka suoritetaan aina, kun FXML-kontrollerin juuri elementti on alustettu.
  	*
  	* @param url Käytetään FXML-kontrollerin juurielementin löytämiseen tarvittaessa.
  	* @param rb Käytetään juurielementin lokalisointiin.
  	* @return void
  	*/
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}