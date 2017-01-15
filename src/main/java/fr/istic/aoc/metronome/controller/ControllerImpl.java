package fr.istic.aoc.metronome.controller;


import fr.istic.aoc.metronome.command.Command;
import fr.istic.aoc.metronome.ihm.*;
import fr.istic.aoc.metronome.media.EmetteurSonoreImpl;
import fr.istic.aoc.metronome.moteur.IMoteur;
import fr.istic.aoc.metronome.moteur.Moteur;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//client et receiver
public class ControllerImpl implements IController {

    //Moteur
    private IMoteur moteur;
    //EmetteurSonoreImpl
    private EmetteurSonoreImpl mediaPlayer;

    //Attributes : Pattern command entre controller et adapter
    private Command startCmd;
    private Command stopCmd;
    private Command marqeurTempCmd;
    private Command marquerMesureCmd;
    private Command tempoUpdateCmd;
    private Command mesureUpdateCmd;

    @Override
    public void setStartCmd(Command startCmd) {
        this.startCmd = startCmd;
    }
    @Override
    public void setMarqeurTempCmd(Command marqeurTempCmd) {
        this.marqeurTempCmd = marqeurTempCmd;
    }
    @Override
    public void setMarquerMesureCmd(Command marquerMesureCmd) {
        this.marquerMesureCmd = marquerMesureCmd;
    }
    @Override
    public void setTempoUpdateCmd(Command tempoUpdateCmd) {
        this.tempoUpdateCmd = tempoUpdateCmd;
    }
    @Override
    public void setMesureUpdateCmd(Command mesureUpdateCmd) {
        this.mesureUpdateCmd = mesureUpdateCmd;
    }


    //Initialisation
    public void initialize() {

        //Initialisation du moteur
        this.moteur = new Moteur();

        //Initialisation du EmetteurSonoreImpl
        this.mediaPlayer = new EmetteurSonoreImpl();

        //Configuration des commandes
        moteur.setCommandStart(() -> {
            updateStarted();
        });

        moteur.setCommandStop(() -> {
            stopMetronome();
        });

        moteur.setCommandUpdateTemps(() -> {
            updateTempo();
        });
        moteur.setCommandUpdateMesure(() -> {
            updateTempsParMesure();
        });
        moteur.setCommandMarquerTemps(() -> {
            marquerTemps();
        });
        moteur.setCommandMarquerMesure(() -> {
            marquerMesure();
        });
    }

    public ControllerImpl() {
        initialize();
    }

    @Override
    public void updateStarted() {
        startCmd.execute();
    }

    @Override
    public void stopMetronome() {
        //On fait rien cote interface/Materiel
        //On arrestes juste le/les processus qui tourneent en dessous
    }

    @Override
    public void updateTempo() {
        tempoUpdateCmd.execute();
    }

    @Override
    public void updateTempsParMesure() {
        mesureUpdateCmd.execute();
    }

    @Override
    public void marquerTemps() {
        mediaPlayer.emettreClic();
        marqeurTempCmd.execute();
    }

    @Override
    public void marquerMesure() {
        marquerMesureCmd.execute();
    }

    @Override
    public void onStartClick() {
        moteur.start();
    }

    @Override
    public void onStopClick() {
        moteur.stop();
    }

    @Override
    public void onIncClick() {
        moteur.incMesure();
    }

    @Override
    public void onDecClick() {
        moteur.decMesure();
    }

    @Override
    public void setTempo(int newTempo) {
        moteur.setTempo(newTempo);
    }

    @Override
    public int getTempoMateriel() {
        return  moteur.getTempo();
    }

    @Override
    public int getMesureMateriel() {
        return moteur.getMesure();
    }

}

