package fr.istic.aoc.metronome.controller;

import fr.istic.aoc.metronome.ihm.Bouton;
import fr.istic.aoc.metronome.ihm.BoutonAdapter;
import fr.istic.aoc.metronome.ihm.Clavier;
import fr.istic.aoc.metronome.ihm.ClavierImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


/**
 * Created by djiby on 04/01/17.
 */
public class FXController {

    //Attributes
    @FXML
    public Circle ledA;
    @FXML
    public Circle ledB;
    @FXML
    public Slider slider;
    @FXML
    public TextField labelTempo;
    @FXML
    public TextField labelMesure;
    @FXML
    public Button startButton;
    @FXML
    public Button stopcButton;
    @FXML
    public Button incButton;
    @FXML
    public Button decButton;

    //Clavier
    private Clavier clavier;

    //Controller
    //private IController controller;

   // private Bouton boutonAdapteur;

    @FXML
    public void initialize() {
        // boutonAdapteur = new BoutonAdapter();
        clavier = new ClavierImpl(this);
       // boutonAdapteur = new BoutonAdapter(this);
        //Adapteur
        //boutonAdapteur = new BoutonAdapter();

        //Configuration
       /* setLedA();
        setLedB();
        setSlider();
        setLabelTempo();
        setLabelMesure();
        setIncButton();
        setDecButton();*/

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // setTempo(newValue.intValue());
            }
        });

    }

    public FXController() {

    }

    /*
        public void setLedA(){
            controller.setLedA(this.ledA);
        }

        public void setLedB(){
            controller.setLedB(this.ledB);
        }

        public void setSlider(){
            controller.setSlider(this.slider);
        }

        public void setLabelTempo(){
            controller.setLabelTempo(this.labelTempo);
        }

        public void setLabelMesure(){
            controller.setLabelMesure(this.labelMesure);
        }

        public void setIncButton(){
            controller.setIncButton(this.incButton);
        }

        public void setDecButton(){
            controller.setDecButton(this.decButton);
        }

        public void setTempo(int tempo) {
            controller.setTempo(tempo);
        }
    */
    //Events methods
    public void onStartClick() {
       // System.out.println("vers claviers");
        clavier.press(1);
        //System.out.println("after pressed");
    }

    public void onStopClick() {
        clavier.press(2);
    }

    public void onIncClick() {
        clavier.press(3);
    }

    public void onDecClick() {
        clavier.press(4);
    }

    public void flashLedA() {
        ledA.setFill(Color.RED);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ledA.setFill(Color.WHITE);
    }

    public void flashLedB() {
        ledB.setFill(Color.RED);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ledB.setFill(Color.WHITE);
    }

   /* public Clavier getClavier() {
        return clavier;
    }*/

   /* public IController getController() {
        return controller;
    }*/
}
