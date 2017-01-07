package fr.istic.aoc.metronome.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
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
    public TextField label;
    @FXML
    public TextField tempParMesure;
    @FXML
    public Button inc;
    @FXML
    public Button dec;

    //Controller
    private ControllerImpl controller;

    public FXController(){

    }

    /*public void setLedA(){
        controller.setLedA(this.ledA);
    }*/

}
