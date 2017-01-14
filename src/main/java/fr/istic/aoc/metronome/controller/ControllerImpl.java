package fr.istic.aoc.metronome.controller;


import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.ihm.*;
import fr.istic.aoc.metronome.media.EmetteurSonoreImpl;
import fr.istic.aoc.metronome.moteur.IMoteur;
import fr.istic.aoc.metronome.moteur.Moteur;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//client et receiver
public class ControllerImpl implements IController {

    //Attributes
    public Afficheur afficheur;
    public Molette slider;
    public Bouton startButton;
    public Bouton stopButoon;
    public Bouton incButton;
    public Bouton decButton;

    private Bouton boutonAdapteur;
    //Moteur
    private IMoteur moteur;
    //EmetteurSonoreImpl
    private EmetteurSonoreImpl mediaPlayer;

    public void setDemarrer(Command demarrer) {
        this.demarrer = demarrer;
    }

    private Command demarrer;

    //Initialisation
    public void initialize() {

        //Initialisation du moteur
        this.moteur = new Moteur();

        //Initialisation des composants
        afficheur = new AfficheurImpl();

        //Initialisation du EmetteurSonoreImpl
        this.mediaPlayer = new EmetteurSonoreImpl();

        //Configuration des commandes
        moteur.setCommandStart(() -> {
            //System.out.println("dans start");
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
            System.out.println("set commande");
            marquerTemps();
        });
        moteur.setCommandMarquerMesure(() -> {
            marquerMesure();
        });
    }

    public ControllerImpl() {
        //System.out.println("controller moteur");
        initialize();
    }

    @Override
    public void updateStarted() {
        // slider.setDisable(false);
       /* incButton.setDisable(false);
        decButton.setDisable(false);*/
        //boutonAdapteur.setDisableINCDEC();
        //System.out.println("Suis fary");
        demarrer.execute();
    }

    @Override
    public void stopMetronome() {
        // slider.setDisable(true);
       /* incButton.setDisable(true);
        decButton.setDisable(true);*/
    }

    @Override
    public void updateTempo() {
        //labelTempo.setText(String.valueOf(moteur.getTempo()));
    }

    @Override
    public void updateTempsParMesure() {
        //labelMesure.textProperty().setValue(String.valueOf(moteur.getMesure()));
    }

    @Override
    public void marquerTemps() {
       // labelTempo.
        System.out.println("marquertemps");
        mediaPlayer.emettreClic();
        // flash(ledA, Color.RED, Color.WHITE);

    }

    @Override
    public void marquerMesure() {
        //  flash(ledB, Color.RED, Color.WHITE);
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
        System.out.println("J'ai commencer");
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


    /*@Override
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
    }*/

    @Override
    public void setTempo(int newTempo) {
        moteur.setTempo(newTempo);
    }

}

