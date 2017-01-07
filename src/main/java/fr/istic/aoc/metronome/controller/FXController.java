package fr.istic.aoc.metronome.controller;

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
    public Button incButton;
    @FXML
    public Button decButton;

    //Controller
    private IController controller;

    @FXML
    public void initialize() {
        controller = new ControllerImpl();

        //Configuration
        setLedA();
        setLedB();
        setSlider();
        setLabelTempo();
        setLabelMesure();
        setIncButton();
        setDecButton();

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setTempo(newValue.intValue());
            }
        });

    }

    public FXController(){

    }

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

    public void setTempo(int tempo){
        controller.setTempo(tempo);
    }

    //Events methods
    public void onStartClick() {
        controller.onStartClick();
    }

    public void onStopClick() {
        controller.onStopClick();
    }

    public void onIncClick() {
        controller.onIncClick();
    }

    public void onDecClick() { controller.onDecClick(); }

}
