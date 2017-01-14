package fr.istic.aoc.metronome.ihm;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by djiby on 08/01/17.
 */
public interface Afficheur {

    void flashLedA() ;
    void flashLedB() ;
    void afficherTempo(int valeurTempo) ;
    void afficherMesure(int valeurTempo) ;
    //public void flash();

    /*public void marquerTemps();
    public void marquerMesure();*/
}
