package view;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
/**
 * Käyttöliittymän yleisnäkymän kontrolleri.
 * @author Nico Järvinen
 */
public class SimuOverviewController implements Initializable{

	/**
	 * Määrittää SceneBuilder objektin TextField, joka on tekstikenttä.
	 */	
	@FXML
	private TextField simulointiaika;
	/**
	 * Määrittää SceneBuilder objektin TextField, joka on tekstikenttä.
	 */	
	@FXML
	private TextField viive;
	/**
	 * Määrittää SceneBuilder objektin TextField, joka on tekstikenttä.
	 */	
	@FXML
	private TextField tulos;
	
	/**
	 * Määrittää SceneBuilder objektin Text, joka on tekstiä.
	 */	
	@FXML
	private Text viiveTeksti;
	/**
	 * Määrittää SceneBuilder objektin TextField, joka on tekstikenttä.
	 */	
	@FXML
	private TextField jakaumaXTeksti;
	/**
	 * Määrittää SceneBuilder objektin TextField, joka on tekstikenttä.
	 */	
	@FXML
	private TextField jakaumaYTeksti;
	/**
	 * Määrittää SceneBuilder objektin AnchorPane, joka on yleisnäkymän pohjapaneeli.
	 */	
	@FXML
	private AnchorPane root;
	/**
	 * Määrittää SceneBuilder objektin Canvas, joka on piirtopohja.
	 * Ei käytetä ohjelmassa.
	 */	
	@FXML
	private Canvas canva;

//	@FXML
//	private AnchorPane animationPane;
	@FXML
	/**
	 * Määrittää SceneBuilder objektin BorderPane, joka tila johon animaationäkymä asetetaan.
	 */	
	private BorderPane border;
	/**
	 * Määrittää SceneBuilder objektin Text, joka on tekstiä.
	 */	
	@FXML
	private Text aika;
	
	/**
	 * Main luokan määritys muuttujaan.
	 */
	private Main main;
	
	 /**
  	* Yliajo metodi Initializable interfacelle, joka suoritetaan aina, kun FXML-kontrollerin juuri elementti on alustettu.
  	*
  	* @param url Käytetään FXML-kontrollerin juurielementin löytämiseen tarvittaessa.
  	* @param rb Käytetään juurielementin lokalisointiin.
  	* @return void
  	*/
	@Override
	public void initialize(URL arg0, ResourceBundle rb) {	

	} 
	
	/**
	 * Tyhjä konstruktori luokalle, jotta luokkaa voidaan kutsua muista luokista.
	 */
	public SimuOverviewController() {

	}
	
	/**
   	 * Metodi joka asettaa kontrollerin näkyville Main luokalle, jotta instanssin luominen on mahdollista FXMLLoaderissa.
   	 * 
   	 * @return void
   	 */
	public void setMain(Main main) {
		this.main = main;
	}
	
	/**
   	 * Metodi joka käsittelee simulointi nappulan toiminnan.
   	 * Hankkii tarvittavat tiedot moottorille, jotka syötetään sinne Kontrolleri luokan kautta.
   	 * Tiedot tarkistetaan, jotta ohjelmassa ei tule virheitä ja se suoriutuu oikein.
   	 * Tämän jälkeen ohjelma suoritetaan Main luokan kautta.
   	 * Ja päivitetään näkymän viive teksti.
   	 * 
   	 * @return void
   	 */
	@FXML
	public void handleSimuloi() {
		String v = viive.getText();
		String s = simulointiaika.getText();
		String jX = jakaumaXTeksti.getText();
		String jY = jakaumaYTeksti.getText();

		if(v.isEmpty() || s.isEmpty() || jX.isEmpty() || jY.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Kuntokeskus Simulaattori");
			alert.setHeaderText("Virhe aloittaessa simulaatio!");
			alert.setContentText("Muista asettaa kaikki tarvittavat arvot!\n"
					+ "Lisää ohjeita kohdassa Tietoja --> Ohjeet. ");
			alert.showAndWait();
		} else {
			main.simuloi();
			viiveTeksti.setText(Long.toString(main.simuViive()));	
		}
	}	
	
	/**
   	 * Metodi joka käsittelee nopeuta nappulan toiminnan.
   	 * Tarkistaa onko viive yksi, jotta viive ei voi mennä nollaksi.
   	 * Tämä sen takia, että animaatiot eivät rikkoudu.
   	 * Muuten simulaatiota nopeutetaan ja viive teksti asetetaan moottorista saatuun viiveeseen.
   	 * 
   	 * @return void
   	 */
	@FXML
	public void handleNopeuta() {
		if(viiveTeksti.getText().equals("1")) {
			viiveTeksti.setText(Long.toString(1));
		} else {
			main.nopeuta();
			viiveTeksti.setText(Long.toString(main.simuViive()));
		}
	}

	/**
   	 * Metodi joka käsittelee Hidasta nappulan toiminnan.
   	 * Kutsuu hidasta metodia Main luokasta ja asettaa viive tekstin moottorista saatuun viiveeseen.
   	 * 
   	 * @return void
   	 */
	@FXML
	public void handleHidasta() {
		main.hidasta();
		viiveTeksti.setText(Long.toString(main.simuViive()));
	}
	//Käyttöliittymän rajapintametodit (kutsutaan kontrollerista)

	/**
   	 * Metodi joka palauttaa border muuttujan.
   	 * Muuttuja on paneeli johon animaationäkymä asetetaan.
   	 * 
   	 * @return BorderPane
   	 */
	public BorderPane getBorderPane() {

		return border;
	}
	
	/**
	 * Metodi joka palauttaa simulaattoriin asetetun ajan moottorille Kontrolleri luokan kautta.
   	 * 
   	 * @return double
   	 */
	public double simuAika() {
		return Double.parseDouble(simulointiaika.getText());
	}
	/**
	 * Metodi joka palauttaa simulaattoriin asetetun viiveen moottorille Kontrolleri luokan kautta.
   	 * 
   	 * @return double
   	 */
	public long simuViive(){
		return Long.parseLong(viive.getText());
	}
	
	/**
	 * Metodi joka asettaa simulaattorin kokonais ajoajan.
   	 * Aika saadaan Moottori luokasta, Kontrolleri luokan kautta.
   	 * Aika formatoidaan kahden desimaalin tarkkuuteen.
   	 * Tämän jälkeen näytetään hälytys joka kertoo käyttäjälle, että simulointi on valmis.
   	 * 
   	 * @param aika 
   	 * @return void
   	 */
	public void simuLoppuaika(double aika){
		DecimalFormat formatter = new DecimalFormat("#0.00");
		this.tulos.setText(formatter.format(aika));
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Kuntokeskus Simulaattori");
		alert.setHeight(400);
		alert.setHeaderText("Simulointi valmis!");
		alert.setContentText("Simuloitiin " + Math.floor((main.getAika()/60)* 100) / 100 + " tuntia." + "\nAsiakkaita yhteensä: " + main.getKaikkiAsiakkaat() + ".\nAsiakkaista palveltiin: " + main.getPalveltutAsiakkaat() + "." + "\n\nMuistathan tallentaa tiedot simulaattorissa, jos haluat tarkastella simulaation tuloksia tarkemmin.");
		alert.showAndWait();
	}

	/**
	 * Metodi jolla tallennetaan simuloinnin tulokset tietokantaan.
	 * Jos tietoja ei ole tulee virheilmoitus, muuten tulee onnistumisilmoitus.
	 * 
   	 * @return void
   	 */
	public void tallennaTulokset() {
		try {
			main.tallennatulokset();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Kuntokeskus Simulaattori");
			alert.setHeaderText("Tiedot tallennettu!");
			alert.setContentText("Löydät tiedot kohdasta Tilastot --> Taulukot.");
			alert.showAndWait();
		} catch (NullPointerException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Kuntokeskus Simulaattori");
			alert.setHeaderText("Tallennettevaa tietoa ei löytynt");
			alert.setContentText("Ajathan simulaation läpi ennen tallentamista.");
			alert.showAndWait();
		}
	}
	/**
	 * Metodi joka palauttaa simulaattorin yleisnäkemän tekstikentässä olevan arvon moottorille kontrolleri luokan kautta.
   	 * @return int
   	 */
	public int getJakaumaX() {
		return Integer.parseInt(jakaumaXTeksti.getText());
	}
	/**
	 * Metodi joka palauttaa simulaattorin yleisnäkemän tekstikentässä olevan arvon moottorille kontrolleri luokan kautta.
   	 * @return int
   	 */
	public int getJakaumaY() {
		return Integer.parseInt(jakaumaYTeksti.getText());
	}
}
