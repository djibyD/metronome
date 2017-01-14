package fr.istic.aoc.metronome.ihm;

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

    public ClavierImpl(FXController fxc, IController c) {

        fxController = fxc;
        controller = c;
        controller.setStartCmd(() -> {
            demarre();
        });
        clock = new Clock();
        clock.activerPeriodiquement(() -> {
            afterStartClicked();
        }, 100);
        // }).start();

    }

    @Override
    public int touchePressee() {

        return touche;
    }

    @Override
    public void press(int i) {
        this.touche = i;
    }

    public void afterStartClicked() {
        switch (touchePressee()) {
            case 1:
                controller.onStartClick(); press(0);
                break;
            case 2:
                controller.onStopClick(); press(0);
                break;
            case 3:
                controller.onIncClick(); press(0);
                break;
            case 4:
                controller.onDecClick(); press(0);
                break;
            default:
        }
    }

    public void demarre() {
        fxController.incButton.setDisable(false);
        fxController.decButton.setDisable(false);
    }

}
