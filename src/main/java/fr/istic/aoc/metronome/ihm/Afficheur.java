package fr.istic.aoc.metronome.ihm;

/**
 * Created by djiby on 08/01/17.
 */
public interface Afficheur {

    void allumerLED(int numLED) ;
    void éteindreLED(int numLED) ;
    void afficherTempo(int valeurTempo) ;
}
