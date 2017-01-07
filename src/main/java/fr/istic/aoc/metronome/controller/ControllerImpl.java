package fr.istic.aoc.metronome.controller;


import fr.istic.aoc.metronome.media.MediaPlayer;
import fr.istic.aoc.metronome.moteur.IMoteur;
import fr.istic.aoc.metronome.moteur.Moteur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//client et receiver
public class ControllerImpl implements IController {

    //Attributes
    public Circle ledA;
    public Circle ledB;
    public Slider slider;
    public TextField labelTempo;
    public TextField labelMesure;
    public Button incButton;
    public Button decButton;

    //Moteur
    private IMoteur moteur;
    //MediaPlayer
    private MediaPlayer mediaPlayer;

    //Initialisation
    public void initialize() {

        //Initialisation du moteur
        this.moteur = new Moteur();

        //Initialisation du MediaPlayer
        this.mediaPlayer = new MediaPlayer();

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
        initialize();
    }

    @Override
    public void updateStarted() {
        slider.setDisable(false);
        incButton.setDisable(false);
        decButton.setDisable(false);
    }

    @Override
    public void stopMetronome() {
        slider.setDisable(true);
        incButton.setDisable(true);
        decButton.setDisable(true);
    }

    @Override
    public void updateTempo() {
        labelTempo.setText(String.valueOf(moteur.getTempo()));
    }

    @Override
    public void updateTempsParMesure() {
        labelMesure.textProperty().setValue(String.valueOf(moteur.getMesure()));
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
    @Override
    public void onStartClick() {
        moteur.start();
    }

    @Override
    public void onStopClick() {
        moteur.stop();
    }

    @Override
    public void onIncClick() {
        moteur.incMesure();
    }

    @Override
    public void onDecClick() { moteur.decMesure(); }


    @Override
    public void setLedA(Circle ledA) {
        this.ledA = ledA;
    }

    @Override
    public void setLedB(Circle ledB) {
        this.ledB = ledB;
    }

    @Override
    public void setSlider(Slider slider) {
        this.slider = slider;
    }

    @Override
    public void setLabelTempo(TextField labelTempo) {
        this.labelTempo = labelTempo;
    }

    @Override
    public void setLabelMesure(TextField labelMesure) {
        this.labelMesure = labelMesure;
    }

    @Override
    public void setIncButton(Button incButton) {
        this.incButton = incButton;
    }

    @Override
    public void setDecButton(Button decButton) {
        this.decButton = decButton;
    }

    @Override
    public void setTempo(int newTempo) {
        moteur.setTempo(newTempo);
    }

   /* @Override
    public void addSliderListener() {
        //Listener on Slider
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                setTempo(newValue.intValue()); //mise du tempo cote moteur
            }
        });
    }*/
}

