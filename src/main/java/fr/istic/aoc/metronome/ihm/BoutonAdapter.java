package fr.istic.aoc.metronome.ihm;

import fr.istic.aoc.metronome.controller.ControllerImpl;
import fr.istic.aoc.metronome.controller.FXController;
import fr.istic.aoc.metronome.controller.IController;
import fr.istic.aoc.metronome.timer.Clock;
import fr.istic.aoc.metronome.timer.Horloge;

/**
 * Created by djiby on 10/01/17.
 */
public class BoutonAdapter implements Bouton {

    private IController controller;
    private Clavier clavier;
    private Horloge clock;
    private FXController fxController;

    public BoutonAdapter(FXController fxc) {
        this.fxController=fxc;
        controller = new ControllerImpl();
        this.clavier=fxController.getClavier();
        //new Thread(() -> {
            clock = new Clock();
            clock.activerPeriodiquement(() -> {
                afterStartClicked();
                System.out.println("tour");
            }, 100);
       // }).start();
    }

   /* @Override
    public void setDisable(boolean b) {

    }*/

    @Override
    public void setDisableINCDEC() {
        // slider.setDisable(false);
        System.out.println("hhhhhhhhhhhhhh");
        fxController.incButton.setDisable(false);
        fxController.decButton.setDisable(false);
    }

    public void afterStartClicked(){
        System.out.println("eeeeeeeeeee");
        switch (clavier.touchePressee()){
            case 1 : controller.onStartClick(); System.out.println("Dans le switch 1"); break;
            case 2 : controller.onStopClick();System.out.println("Dans le switch 2"); break;
            case 3 : controller.onIncClick();System.out.println("Dans le switch 3"); break;
            case 4 : controller.onDecClick(); System.out.println("Dans le switch 4");break;
            default:
        }
    }

    //Events methods
    public void onStartClick() {
        fxController.onStartClick();
    }

    public void onStopClick() {
        clavier.press(2);
    }

    public void onIncClick() {
        clavier.press(3);
    }

    public void onDecClick() {
        clavier.press(4);
    }
}
