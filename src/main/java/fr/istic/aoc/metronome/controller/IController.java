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

    void setTempo(int newTempo); //Pour mettre le jour le tempo du moteur

    //Pattern command entre Controller et Adapteur(s)
    void setStartCmd(Command startCmd);
    void setMarqeurTempCmd(Command marqeurTempCmd);
    void setMarquerMesureCmd(Command marquerMesureCmd);
    void setTempoUpdateCmd(Command tempoUpdateCmd);
    void setMesureUpdateCmd(Command mesureUpdateCmd);


    //Transmission donne(tempo) du moteur vers le materiel
    int getTempoMateriel();
    int getMesureMateriel();
}
