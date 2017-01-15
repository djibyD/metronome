package fr.istic.aoc.metronome.controller;

import fr.istic.aoc.metronome.materiel.Materiel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


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

    //Materiel
    private Materiel materiel;

    @FXML
    public void initialize() {
        materiel = new Materiel(this);

        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                materiel.getMolette().setTempo(newValue.intValue());
            }
        });

    }

    public FXController() {

    }

    //Events methods
    public void onStartClick() {
        materiel.getClavier().press(1);
    }

    public void onStopClick() {
        materiel.getClavier().press(2);
    }

    public void onIncClick() {
        materiel.getClavier().press(3);
    }

    public void onDecClick() {
        materiel.getClavier().press(4);
    }

    public void flashLedA() {
        flash(ledA, Color.RED, Color.WHITE);
    }

    public void flashLedB() {
        flash(ledB, Color.RED, Color.WHITE);
    }

    private void flash(Circle led, Color on, Color off) {
        new Thread(() -> {
            led.setFill(on);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            led.setFill(off);
        }).start();
    }

    public void afficherTempo(int valeurTempo) {
        labelTempo.setText(String.valueOf(valeurTempo));
    }

    public void afficherMesure(int valeurMesure) {
        labelMesure.textProperty().setValue(String.valueOf(valeurMesure));
    }
}
