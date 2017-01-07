package fr.istic.aoc.metronome.controller;


import fr.istic.aoc.metronome.media.MediaPlayer;
import fr.istic.aoc.metronome.moteur.IMoteur;
import fr.istic.aoc.metronome.moteur.Moteur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//client et receiver
public class ControllerImpl implements IController {

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

    //Others attributes
    private boolean marquerTemps = false;
    private boolean marquerMesure = false;


    //Moteur
    private IMoteur moteur;
    //MediaPlayer
    private MediaPlayer mediaPlayer;

    @FXML
    public void initialize() {

        //Initialisation du moteur
        this.moteur = new Moteur();

        //Initialisation du MediaPlayer
        this.mediaPlayer = new MediaPlayer();

        //Listener on Slider
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                moteur.setTempo(newValue.intValue()); //mise du tempo cote moteur
            }
        });

        //Configuration des commandes
        moteur.setCommandStart(() -> {
            updateStarted();
        });

        moteur.setCommandStop(() -> {
            stopMetronome();
        });

        moteur.setCommandUpdateTemps(() -> {
            updateTempo();
        });
        moteur.setCommandUpdateMesure(() -> {
            updateTempsParMesure();
        });
        moteur.setCommandMarquerTemps(() -> {
            marquerTemps();
        });
        moteur.setCommandMarquerMesure(() -> {
            marquerMesure();
        });
    }

    public ControllerImpl() {

    }

    @Override
    public void updateStarted() {
        slider.setDisable(false);
        inc.setDisable(false);
        dec.setDisable(false);
    }

    @Override
    public void stopMetronome() {
        slider.setDisable(true);
        inc.setDisable(true);
        dec.setDisable(true);
    }

    @Override
    public void updateTempo() {
        label.setText(String.valueOf(moteur.getTempo()));
    }

    @Override
    public void updateTempsParMesure() {
        tempParMesure.textProperty().setValue(String.valueOf(moteur.getMesure()));
    }

    @Override
    public void marquerTemps() {
        mediaPlayer.playSound();
        flash(ledA, Color.RED, Color.WHITE);

    }

    @Override
    public void marquerMesure() {
        flash(ledB, Color.GREENYELLOW, Color.WHITE);
    }

    //Allumer les leds
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

    //Events methods
    public void onStartClick() {
        moteur.start();
    }

    public void onStopClick() {
        moteur.stop();
    }

    public void onIncClick() {
        moteur.incMesure();
    }

    public void onDecClick() {
        moteur.decMesure();
    }

}

