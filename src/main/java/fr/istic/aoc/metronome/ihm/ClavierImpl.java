package fr.istic.aoc.metronome.ihm;

/**
 * Created by djiby on 08/01/17.
 */
public class ClavierImpl implements Clavier {
 private int touche=0;
    public ClavierImpl(){}

    @Override
    public int touchePressee() {
        System.out.println("touche "+ touche);
        return touche;
    }
    @Override
    public void press(int i){
        this.touche=i;
    }

}
