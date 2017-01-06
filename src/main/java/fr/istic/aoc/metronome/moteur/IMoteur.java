package fr.istic.aoc.metronome.moteur;

import fr.istic.aoc.metronome.command.Command;

/**
 * Created by djiby on 05/01/17.
 */
public interface IMoteur {
    public void setCommandStart(Command command);

    public void setCommandStop(Command command);

    public void setCommandUpdateTemps(Command command);

    public  void setCommandUpdateMesure(Command command);

    public void setCommandMarquerTemps(Command command);

    public void setCommandMarquerMesure(Command command);

    public int getTempo();

    public void setTempo(int tempo);

    public int getMesure();

    public void start();

    public void stop();

    public void marquerTemps();

    public void marquerMesure();

    public void incMesure();

    public void decMesure();
}
