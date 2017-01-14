package fr.istic.aoc.metronome.ihm;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.controller.ControllerImpl;
import fr.istic.aoc.metronome.controller.FXController;
import fr.istic.aoc.metronome.controller.IController;
import fr.istic.aoc.metronome.timer.Clock;
import fr.istic.aoc.metronome.timer.Horloge;

/**
 * Created by djiby on 08/01/17.
 */
public class ClavierImpl implements Clavier {
    private IController controller;
    private Horloge clock;
    private FXController fxController;
    private int touche = 0;

    public ClavierImpl(FXController fxc) {

        this.fxController = fxc;
        controller = new ControllerImpl();
        controller.setDemarrer(() -> {
            demarre();
        });
        //this.clavier=fxController.getClavier();
        //new Thread(() -> {
        clock = new Clock();
        clock.activerPeriodiquement(() -> {
            //  System.out.println("executer");
            afterStartClicked();
            //  System.out.println("ecouter");
        }, 100);
        // }).start();

    }

    @Override
    public int touchePressee() {

        return touche;
    }

    @Override
    public void press(int i) {
        System.out.println("touche " + touche);
        this.touche = i;
    }

    public void afterStartClicked() {
        // System.out.println("eeeeeeeeeee");
        switch (touchePressee()) {
            case 1:
                controller.onStartClick(); press(0);
                //System.out.println("Dans le switch 1");
                break;
            case 2:
                controller.onStopClick(); press(0);
                // System.out.println("Dans le switch 2");
                break;
            case 3:
                controller.onIncClick(); press(0);
                // System.out.println("Dans le switch 3");
                break;
            case 4:
                controller.onDecClick(); press(0);
                // System.out.println("Dans le switch 4");
                break;
            default:
        }
    }

    public void demarre() {
        //System.out.println("redemarrer ds fx");
        fxController.incButton.setDisable(false);
        fxController.decButton.setDisable(false);
    }

}
