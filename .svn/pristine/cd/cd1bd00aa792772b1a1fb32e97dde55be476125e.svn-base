package view;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.util.Duration;
/**
 * AnimationOverview FXML tiedoston kontrolleri luokka, jolla toteutetaan simulaattorin animointi.
 * @author Tatu Nordström
 * @author Nico Järvinen
 *
 */
public class AnimationOverviewController implements Initializable{
	/**
	* Tällä muuttujalla määritellään main luokka.
	*/
	private Main main;
	/**
	* Määritellään animaatioon tarvittava muuttuja, joka käyttää javafx animointi kirjastosta pathTransitionia.
	*/
	private PathTransition pt;
	/**
	* Tämä muuttuja on lista johon tallennetaan animoidut asiakkaat.
	*/
	private List<Circle> myCircles = new ArrayList<Circle>();
	/**
	* Tämä muuttuja on, jotta useamman ympyrän luominen on helpompi toteuttaa.
	*/
	@FXML
	private Circle circle;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path VtoNPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path VtoMPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path NPHtoR;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path MPHtoR;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path RtoNPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path RtoMPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path NPHtoF;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path MPHtoF;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path FtoNPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path FtoMPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path NPHtoRL;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path MPHtoRL;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path RLtoNPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path RLtoMPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path NPHtoK;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path MPHtoK;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path KtoNPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path KtoMPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path NPHtoJ;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path MPHtoJ;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path JtoNPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path JtoMPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path NPHtoH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path MPHtoH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path HtoNPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path HtoMPH;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path NPHtoS;
	/**
	* Määritetään Scenebuilderissä luotuja path objekteja, jotta niitä voi käyttää koodissa.
	*/
	@FXML
	private Path MPHtoS;
	/**
	* Käyttöliittymän taustan määritys, jotta sitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private AnchorPane background;
	/**
	* Käyttöliittymän piirtoalueen määritys, jotta sitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Canvas canva;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text vastaanottoTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text rontgenTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text NPHTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text MPHTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text RLTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text kuntosaliTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text juoksuTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text hierojaTeksti;
	/**
	* Käyttöliittymässä olevien tekstien määritys, jotta niitä pystyy käsittelemään koodissa.
	*/
	@FXML
	private Text fysioTeksti;
	
	/**
	* Tyhjä konstruktori, jotta luokkaa voi kutsua muista luokista.
	*/ 
	public AnimationOverviewController() {
    	
    }
	
	/**
	* Metodin tarkoitus on asettaa tämä luokka näkyväksi main luokalle.
	*
	* @param main tarkoitus määrittää luokan muuttuja "main"
	* @return void
	*/
    public void setMain(Main main) {
        this.main = main;    
    }
    
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveToNPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(VtoNPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveToMPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(VtoMPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveNPHtoR(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(NPHtoR);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveMPHtoR(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(MPHtoR);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveRtoNPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(RtoNPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveRtoMPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(RtoMPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveNPHtoF(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1 ));
    	pt.setPath(NPHtoF);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveMPHtoF(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(MPHtoF);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveFtoNPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(FtoNPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveFtoMPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(FtoMPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveNPHtoRL(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId() - 1));
    	pt.setPath(NPHtoRL);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveMPHtoRL(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(MPHtoRL);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveRLtoNPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(RLtoNPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveRLtoMPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(RLtoMPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveNPHtoK(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(NPHtoK);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveMPHtoK(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(MPHtoK);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveKtoNPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(KtoNPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveKtoMPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(KtoMPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveNPHtoJ(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(NPHtoJ);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveMPHtoJ(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(MPHtoJ);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveJtoNPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(JtoNPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.playFromStart();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveJtoMPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(JtoMPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveNPHtoH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(NPHtoH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveMPHtoH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(MPHtoH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveHtoNPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(HtoNPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveHtoMPH(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(HtoMPH);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveMPHtoS(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(MPHtoS);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa kaikki arvot pathtransitionille.
	*
	* @param id ei merkitystä
	* @return void
	*/
    public void moveNPHtoS(int id) {
    	pt = new PathTransition();
    	if(main.getViive() == 1) {
    		pt.setDuration(Duration.millis(0.5));
    	} else {
    		pt.setDuration(Duration.millis(main.getViive()));
    	}
    	pt.setNode(myCircles.get(main.getId()- 1));
    	pt.setPath(NPHtoS);
    	pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    	pt.setCycleCount(1);
    	pt.setAutoReverse(false);
    	pt.play();
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setVastaanotto(int size) {
    	vastaanottoTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setRontgen(int size) {
    	rontgenTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setJuoksu(int size) {
    	juoksuTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setNPH(int size) {
    	NPHTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setMPH(int size) {
    	MPHTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setHieroja(int size) {
    	hierojaTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setFysio(int size) {
    	fysioTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setRL(int size) {
    	RLTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka asettaa numeroarvon tekstille.
	*
	* @param size jonon koko
	* @return void
	*/
    public void setKuntosali(int size) {
    	kuntosaliTeksti.setText(Integer.toString(size));
    }
    /**
	* Metodi, joka luo uuden ympyrän, lisää sen listaan ja asettaa sen käyttöliittymän näkymään.
	*
	* @param id asiakkaan id, joka asetetaan listaan indeksi luvuksi.
	* @return void
	*/
    public void createNewAsiakas(int id) {
    	circle = new Circle(20,20,10,Color.BLACK);
    	myCircles.add(id, circle);
    	background.getChildren().add(circle);
    }
    /**
	* Metodi, joka tyhjentää listan ja näytön asiakas ympyröistä.
	*
	* @return void
	*/
    public void deleteAllAsiakkaat() {
    	for(Circle c : myCircles) {
    		background.getChildren().remove(c);
    	}
    }
    /**
	* Yliajo metodi Initializable interfacelle, joka suoritetaan aina, kun FXML-kontrollerin juuri elementti on alustettu.
	*
	* @param url Käytetään FXML-kontrollerin juurielementin löytämiseen tarvittaessa.
	* @param rb Käytetään juurielementin lokalisointiin.
	* @return void
	*/
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
}
