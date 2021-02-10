package view;
	

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import controller.*;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import osat.ISuorituskykysuureetDAO;
import osat.Suorituskykysuureet;
import osat.Trace;
import osat.Trace.Level;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 * Main luokka yhdistää ohjelman mallin ja näkymän yhdeksi ohjelmaksi.
 * @author Tatu Nordström
 * @author Nico Järvinen
 *
 */
public class Main extends Application implements GuiIf {

	// Käyttöliittymäkomponentit:
	/**
	* Määritetään javafx ikkuna muuttujaan.
	*/
	private Stage primaryStage;
	/**
	* Määritetään pohjapaneeli BorderPaneen, jotta saadaan navigointipalkki pysymään ohjelman yläkulmassa.
	*/
    private BorderPane rootLayout;
    /**
	* Määritetään paneeli AnchorPaneen, jotta saadaan ladattua simulaattorin yleisnäkymä ohjelmaan.
	*/
    private AnchorPane simuOverview;
    /**
	* Määritetään paneeli AnchorPaneen, jotta saadaan ladattua simulaattorin animaationäkymä ohjelmaan.
	*/
    private AnchorPane animationOverview;
    /**
	* Määritetään paneeli BorderPaneen, jotta saadaan ladattua simulaattorin yleisnäkymään animaationäkymä.
	*/
    private BorderPane simuBorder;
    /**
	* Määritetään paneeli TabPaneen, jotta saadaan ladattua simulaattorin tilastonäkymä omaan ikkunaan.
	*/
    private TabPane statisticsView;
    /**
	* Määritetään animaatio näkymän kontrolleri.
	*/
    private AnimationOverviewController controller;
    /**
	* Määritetään simulaation yleisnäkymän kontrolleri.
	*/
    private SimuOverviewController controlleri;
    /**
	* Määritetään simulaation tilastonäkymän kontrolleri.
	*/
    private StatisticsViewController statkontrolleri;
    /**
	* Määritetään Kontrolleri-luokan interface.
	*/
    private KontrolleriIf kontrolleri;
    /**
	* Määritetään uuden asiakkaan id Integer muuttujaan, jotta osat.moottori luokasta voidaan tuoda id simulaattorin animaatiolle.
	*/
    private int id = 0;
   
    
    /**
   	* Tyhjä konstruktori, jotta main voidaan kutsua muissa luokissa.
   	*/
    public Main() {
	
	}
    /**
   	* Yliajo metodi, jossa asetetaan osat.Trace luokan arvot ja Kontrolleri luokan olio.
   	*
   	* @return void
   	*/
	@Override
	public void init() {
		Trace.setTraceLevel(Level.INFO);
		kontrolleri = new Kontrolleri(this);
	}
	
    /**
   	* Yliajo metodi, joka tarvitaan Application interfacea varten.
   	* Suoritetaan kun ohjelma käynnistetään.
   	* Luo uuden ikkunan ja asettaa näkymät ikkunaan.
   	* @param primaryStage on ohjelman pohjaikkuna johon kaikki alkunäkymät ladataan.
   	* @return void
   	*/
	@Override
    public void start(Stage primaryStage) {
		init();
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Kuntosali Simulaattori");
        this.primaryStage.setResizable(false);
        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:/images/kuva.png"));
    
        initRootLayout();
        
        showSimuOverview();
        
        showAnimationOverview();
        
        //controller.moveCircle();
	}	
	
    /**
   	* Metodi, jossa luodaan instanssi FXMLLoader luokalla pohjanäkymästä.
   	* Metodia kutsutaan start metodissa.
   	*
   	* @return void
   	*/
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show thescene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMain(this);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
   	* Metodi, jossa luodaan instanssi FXMLLoader luokalla yleisnäkymästä.
   	* Metodia kutsutaan start metodissa.
   	*
   	* @return void
   	*/
	public void showSimuOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("SimuOverview.fxml"));
            simuOverview = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            rootLayout.setCenter(simuOverview);
            
         // Give the controller access to the main app.
            controlleri = loader.getController();
            controlleri.setMain(this);
            
            simuBorder = controlleri.getBorderPane();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
   	* Metodi, jossa luodaan instanssi FXMLLoader luokalla animaationäkymästä.
   	* Metodissa ladataan myös yleisnäkymässä oleva borderpane johon tämä näkymä asetetaan.
   	* Metodia kutsutaan start metodissa.
   	*
   	* @return void
   	*/
	public void showAnimationOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AnimationOverview.fxml"));
            animationOverview = (AnchorPane) loader.load();
            
            // Set person overview into the center of root layout.
            BorderPane.setAlignment(animationOverview, Pos.CENTER);
            BorderPane.setMargin(animationOverview, new Insets(12,12,12,12)); // optional
            simuBorder.setCenter(animationOverview);
            
            // Give the controller access to the main app.
            controller = loader.getController();
            controller.setMain(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/**
   	* Metodi, jossa luodaan instanssi FXMLLoader luokalla tilastonäkymästä.
   	* Metodi luo uuden ikkunan.
   	* Metodia kutsutaan RootLayoutController metodissa.
   	*
   	* @return void
   	*/
	public void showStatisticsView() {
	      try {
	    	// Load the fxml file and create a new stage for the popup.
	          FXMLLoader loader = new FXMLLoader();
	          loader.setLocation(Main.class.getResource("StatisticsView.fxml"));
	          statisticsView = (TabPane) loader.load();
	           
	          Stage dialogStage = new Stage();
	          dialogStage.setTitle("Statistiikka");
	          dialogStage.initModality(Modality.WINDOW_MODAL);
	          dialogStage.initOwner(primaryStage);
	          Scene scene = new Scene(statisticsView);
	          dialogStage.setScene(scene);

	          statkontrolleri = loader.getController();
	          
	          dialogStage.show();
	      
	      } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	/**
	* Metodi joka palauttaa ohjelman ikkunan.
   	*
   	* @return Stage
   	*/
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	* Metodi joka palauttaa kontrollerista saadun viiveen.
   	*
   	* @return long
   	*/
	public long simuViive() {
		return kontrolleri.getViive();
	}
	
	/**
	* Metodi joka käynnistää simulaation kontrolleri luokasta.
   	*
   	* @return void
   	*/
	public void simuloi() {
		kontrolleri.kaynnistaSimulointi();
	}	
	
	/**
	* Metodi joka kutsuu simulaation nopeutus metodin kontrolleri luokasta.
   	*
   	* @return void
   	*/
	public void nopeuta() {
		kontrolleri.nopeuta();
	}
	
	/**
	* Metodi joka kutsuu simulaation hidastus metodin kontrolleri luokasta.
   	*
   	* @return void
   	*/
	public void hidasta() {
		kontrolleri.hidasta();
	}
	
	/**
	* Metodi joka asettaa animaationäkymän vastaanotto palvepisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setVastaanottoAsiakkaat (int size) {
		controller.setVastaanotto(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän rontgen palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setRontgenAsiakkaat(int size) {
		controller.setRontgen(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän kuntosali palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setKuntosaliAsiakkaat(int size) {
		controller.setKuntosali(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän ryhmäliikunta palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setRLAsiakkaat(int size) {
		controller.setRL(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän juoksumatto palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setJuoksuAsiakkaat(int size) {
		controller.setJuoksu(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän hieronta palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setHierontaAsiakkaat(int size) {
		controller.setHieroja(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän fysioterapeutti palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setFysioAsiakkaat(int size) {
		controller.setFysio(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän naistenpukuhuone palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setNPHAsiakkaat(int size) {
		controller.setNPH(size);
	}
	
	/**
	* Metodi joka asettaa animaationäkymän miestenpukuhuone palvelupisteen jonon pituuden.
   	*
   	* @return void
   	*/
	public void setMPHAsiakkaat(int size) {
		controller.setMPH(size);
	}
	
	// JavaFX-sovelluksen (käyttöliittymän) käynnistäminen
	
	/**
	 * main() metodi sivuutetaan jos JavaFX ohjelma käynnistyy oikein.
	 * main() toimii ainoastaan varmistuksena jos ohjelmaa ei pystytä käynnistämään normaalisti
	 * Esimerkkinä IDE:t joissa on vajaa JavaFX tuki
	 *
	 * @param args komentolinja argumentit
	 * @return void
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Yliajo metodi, jolla palautetaan Kontrolleri luokasta moottorin simulaatioaika.
	 * 
	 * @return double
	 */
	@Override
	public double getAika(){	
		return controlleri.simuAika();
	}
	
	/**
	 * Yliajo metodi, jolla palautetaan Kontrolleri luokasta moottorin simulaation viive.
	 * 
	 * @return long
	 */
	@Override
	public long getViive(){
		return controlleri.simuViive();
	}
	
	/**
	 * Yliajo metodi, jolla palautetaan Kontrolleri luokasta moottorin simulaatiossa palveltutasiakkaat.
	 * 
	 * @return int
	 */
	@Override
	public int getPalveltutAsiakkaat() {
		return kontrolleri.getPalveltutAsiakkaat();
	}
	
	/**
	 * Yliajo metodi, jolla palautetaan Kontrolleri luokasta moottorin simulaatiosta kaikki asiakkaat.
	 * 
	 * @return int
	 */
	@Override
	public int getKaikkiAsiakkaat() {
		return kontrolleri.getKaikkiAsiakkaat();
	}
	
	/**
	 * Yliajo metodi, jolla asetetaan simulaation yleisnäkymään loppuaika (tulos).
	 * 
	 * @return void
	 */
	@Override
	public void setLoppuaika(double aika){
		 controlleri.simuLoppuaika(aika);
	}
	
	/**
	 * Yliajo metodi, jolla luodaan uusi asiakas animaationäkymään Kontrolleri luokan kautta ohjelman moottorissa.
	 * Asiakkaalle annetaan id, joka haetaan moottorista.
	 * 
	 * @return void
	 */
	@Override
	public void createAsiakas() {
		id = getId();
		controller.createNewAsiakas(id);
	}
	
	/**
	 * Yliajo metodi, jolla poistetaan kaikki asiakkaat animaationäkymästä Kontrolleri luokan kautta ohjelman moottorissa.
	 * 
	 * @return void
	 */
	@Override
	public void deleteAllAsiakkaat() {
		controller.deleteAllAsiakkaat();
	}
	
	/**
	 * Yliajo metodi, jolla haetaan asiakkaan id Kontrolleri luokan kautta moottorista.
	 * 
	 * @return int
	 */
	@Override
	public int getId() {
		return kontrolleri.getId();
	}
	
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void vastaanottoToPH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveToMPH(getId());
		} else {
			controller.moveToNPH(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void PHtoR() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveMPHtoR(getId());
		} else {
			controller.moveNPHtoR(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void RtoPH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveRtoMPH(getId());
		} else {
			controller.moveRtoNPH(getId());
		}
	}
	
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void PHtoF() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveMPHtoF(getId());
		} else {
			controller.moveNPHtoF(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void FtoPH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveFtoMPH(getId());
		} else {
			controller.moveFtoNPH(getId());
		}
	}

	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void PHtoRL() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveMPHtoRL(getId());
		} else {
			controller.moveNPHtoRL(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void RLtoPH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveRLtoMPH(getId());
		} else {
			controller.moveRLtoNPH(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void PHtoK() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveMPHtoK(getId());
		} else {
			controller.moveNPHtoK(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void KtoPH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveKtoMPH(getId());
		} else {
			controller.moveKtoNPH(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void PHtoJ() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveMPHtoJ(getId());
		} else {
			controller.moveNPHtoJ(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void JtoPH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveJtoMPH(getId());
		} else {
			controller.moveJtoNPH(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void PHtoH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveMPHtoH(getId());
		} else {
			controller.moveNPHtoH(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void HtoPH() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveHtoMPH(getId());
		} else {
			controller.moveHtoNPH(getId());
		}
	}
	/**
	 * Yliajo metodi, jolla tarkistetaan asiakkaan sukupuoli ja siirretään asiakas määritettyyn palvelupisteeseen animaationäkymässä.
	 * 
	 * @return void
	 */
	@Override
	public void PHtoS() {
		if(kontrolleri.asiakkaanSukupuoli() == true) {
			controller.moveMPHtoS(getId());
		} else {
			controller.moveNPHtoS(getId());
		}
	}
	
	/**
	 * Yliajo metodi, jolla haetaan simulaattorin yleisnäkymässä asetettu jakauman keskiarvo.
	 * 
	 * @return int
	 */
	@Override
	public int getJakaumaX() {
		return controlleri.getJakaumaX();
	}
	
	/**
	 * Yliajo metodi, jolla haetaan simulaattorin yleisnäkymässä asetettu jakauman hajonta.
	 * 
	 * @return int
	 */
	@Override
	public int getJakaumaY() {
		return controlleri.getJakaumaY();
	}
	
	/**
	 * Yliajo metodi, jolla haetaan simulaattorin aika moottorista Kontrolleri luokan kautta.
	 * 
	 * @return double
	 */
	@Override
	public double getAikaT() {
		return kontrolleri.getAika();
	}
	
	/**
	 * Yliajo metodi, jolla tallennetaan kaikki simuloinnin tulokset tietokantaan.
	 * 
	 * @return void
	 */
	public void tallennatulokset () {
		kontrolleri.tallennaTulokset();
	}
}
