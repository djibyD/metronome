package fr.istic.aoc.metronome.controller;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import fr.istic.aoc.metronome.moteur.IMoteur;
import fr.istic.aoc.metronome.moteur.Moteur;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

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

    //Bip
   /* String bip = "file:bip.wav";
    Media hit = new Media(Paths.get(bip).toUri().toString());
    //Media hit = new Media(ControllerImpl.class.getResource("beep.wav").toExternalForm());
    MediaPlayer mediaPlayer = new MediaPlayer(hit);*/

   public void playSound() {

       String url = "file:./src/main/resources/beep.wav";

       AudioClip audio = null;

       try

       {
           audio = new AudioClip(new URL(url).toString());
       } catch(
               MalformedURLException e)

       {
           e.printStackTrace();
       }

       audio.play();
    }

    @FXML
    public void initialize() {

        //Initialisation du moteur
        this.moteur = new Moteur();

        //Listener on Slider
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                moteur.setTempo(newValue.intValue()); //mise du tempo cote moteur
                System.out.println("tempo : " + moteur.getTempo());
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
        playSound();
        flash(ledA, Color.RED, Color.WHITE);
       /* System.out.println("SONN");
        for (int i = 0; i < 5; i++) {
            mediaPlayer.play();
        }*/

    }

    @Override
    public void marquerMesure() {
        //playSound();
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

