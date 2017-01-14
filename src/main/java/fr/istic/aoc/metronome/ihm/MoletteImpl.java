package fr.istic.aoc.metronome.ihm;

import fr.istic.aoc.metronome.controller.FXController;
import fr.istic.aoc.metronome.controller.IController;

/**
 * Created by djiby on 08/01/17.
 */
public class MoletteImpl implements Molette {

    private IController controller;
    private FXController fxController;


    public MoletteImpl(FXController fxc, IController c){
        fxController = fxc;
        controller = c;
    }

    @Override
    public void setTempo(int tempo) {
        controller.setTempo(tempo);
    }

}
