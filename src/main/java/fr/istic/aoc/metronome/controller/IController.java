package fr.istic.aoc.metronome.controller;

import fr.istic.aoc.metronome.command.Command;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Created by djiby on 07/11/16.
 */
public interface IController {

    void updateStarted();

    void stopMetronome();

    void updateTempo();

    void updateTempsParMesure();

    void marquerTemps();

    void marquerMesure();

    void onStartClick();

    void onStopClick();

    void onIncClick();

    void onDecClick();

    /*void setLedA(Circle ledA);

    void setLedB(Circle ledB);

    void setSlider(Slider slider);

    void setLabelTempo(TextField labelTempo);

    void setLabelMesure(TextField labelMesure);

    void setIncButton(Button incButton);

    void setDecButton(Button decButton);*/

    void setTempo(int newTempo); //Pour mettre le jour le tempo du moteur

    //Pour le clavier
    public void setDemarrer(Command demarrer);

}
