package fr.istic.aoc.metronome.materiel;

import fr.istic.aoc.metronome.controller.ControllerImpl;
import fr.istic.aoc.metronome.controller.FXController;
import fr.istic.aoc.metronome.controller.IController;
import fr.istic.aoc.metronome.ihm.*;
import fr.istic.aoc.metronome.media.EmetteurSonore;
import fr.istic.aoc.metronome.media.EmetteurSonoreImpl;
import fr.istic.aoc.metronome.timer.Clock;
import fr.istic.aoc.metronome.timer.Horloge;

/**
 * Created by djiby on 08/01/17.
 */
public class Materiel {

    //Controllers
    IController controller;
    FXController fxController;

    private Clavier clavier;
    private Molette molette;
    private Afficheur afficheur;
    //private EmetteurSonore emetteurSonore;

    //Contructeur
    public Materiel(FXController fxc){
        fxController = fxc;
        controller = new ControllerImpl();

        clavier = new ClavierImpl(fxController, controller);
        molette = new MoletteImpl(fxController, controller);
        afficheur = new AfficheurImpl(fxController, controller);
       // emetteurSonore = new EmetteurSonoreImpl();

    }

    public Horloge getHorloge(){
        return  new Clock();
    }
    public Clavier getClavier(){
        return clavier;
    }
    public Molette getMolette(){
        return  molette;
    }
    public EmetteurSonore getEmetteurSonore(){
        return new EmetteurSonoreImpl();
    }
    public Afficheur getAfficheur(){
        return afficheur;
    }
}
