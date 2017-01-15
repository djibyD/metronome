package fr.istic.aoc.metronome.ihm;

import fr.istic.aoc.metronome.controller.FXController;
import fr.istic.aoc.metronome.controller.IController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by djiby on 08/01/17.
 */
public class AfficheurImpl implements Afficheur {

    private IController controller;
    private FXController fxController;

    public AfficheurImpl(FXController fxc, IController c){
        fxController = fxc;
        controller = c;
        controller.setMarqeurTempCmd(() -> {
            flashLedA();
        });
        controller.setMarquerMesureCmd(() -> {
            flashLedB();
        });
        controller.setTempoUpdateCmd(() -> {
            afficherTempo(controller.getTempoMateriel());
        });
        controller.setMesureUpdateCmd(() -> {
            afficherMesure(controller.getMesureMateriel());
        });
    }

    @Override
    public void flashLedA() {
        fxController.flashLedA();
    }

    @Override
    public void flashLedB() {
        fxController.flashLedB();
    }

    @Override
    public void afficherTempo(int valeurTempo) {
        fxController.afficherTempo(valeurTempo);
    }

    @Override
    public void afficherMesure(int valeurTempo) {
        fxController.afficherMesure(valeurTempo);
    }

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
}
