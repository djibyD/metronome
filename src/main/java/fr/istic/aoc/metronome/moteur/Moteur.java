package fr.istic.aoc.metronome.moteur;

import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.timer.Clock;

public class Moteur implements IMoteur {

    //Timer
    private Clock clock;
    private int tempo = 45;
    private int mesure = 4;
    private boolean isStarted = false;
    private int compteurMesure = 0;

    //Commands
    private Command startCommand;
    private Command stopCommand;
    private Command updateTempsCommand;
    private Command updateMesureCommand;
    private Command marquerTempsCommand;
    private Command marquerMesureCommand;

    public Moteur() {

    }

    @Override
    public void setCommandStart(Command command) {
        this.startCommand = command;
    }

    @Override
    public void setCommandStop(Command command) {
        this.stopCommand = command;
    }

    @Override
    public void setCommandUpdateTemps(Command command) {
        this.updateTempsCommand = command;
    }

    @Override
    public void setCommandUpdateMesure(Command command) {
        this.updateMesureCommand = command;
    }

    @Override
    public void setCommandMarquerTemps(Command command) {
        this.marquerTempsCommand = command;
    }

    @Override
    public void setCommandMarquerMesure(Command command) {
        this.marquerMesureCommand = command;
    }

    @Override
    public int getTempo() {
        return this.tempo;
    }

    @Override
    public void setTempo(int tempo) {
        this.tempo = tempo;
        updateTempsCommand.execute();
        if (isStarted) {//On stop et on redemarre que si le metronome etait entrain de tourner
            stop();
            start();
        }
    }

    @Override
    public int getMesure() {
        return this.mesure;
    }

    @Override
    public void start() {
        if (isStarted) {//Metronome etait deja entrain de tourner
            clock.stop();
            isStarted = false;
        }
        isStarted = true;
        clock = new Clock(() -> {
            if (isStarted) {
                if (compteurMesure == (mesure - 1)) {
                    marquerMesure();
                }
                marquerTemps();
            }
        });
        clock.start(60000 / this.getTempo());
        startCommand.execute();
    }

    @Override
    public void stop() {
        if (isStarted) {
            isStarted = false;
            compteurMesure = 0;
            clock.stop();
            stopCommand.execute();
        }
    }

    @Override
    public void marquerTemps() {
        compteurMesure++;
        marquerTempsCommand.execute();
    }

    @Override
    public void marquerMesure() {
        marquerMesureCommand.execute();
        compteurMesure = -1;
    }

    @Override
    public void incMesure() {
        if (mesure < 7) {
            mesure++;
            updateMesureCommand.execute(); //fr.istic.aoc.metronome.controller.notify
            if (isStarted) {//On stop et on redemarre que si le metronome etait entrain de tourner
                stop();
                start();
            }
        }
    }

    @Override
    public void decMesure() {
        if (mesure > 2) {
            mesure--;
            updateMesureCommand.execute(); //fr.istic.aoc.metronome.controller.notify
            if (isStarted) {//On stop et on redemarre que si le metronome etait entrain de tourner
                stop();
                start();
            }
        }
    }
}
