package fr.istic.aoc.metronome.controller;

import fr.istic.aoc.metronome.command.Command;
import javafx.scene.shape.Rectangle;

/**
 * Created by djiby on 07/11/16.
 */
public interface IController {

	public void updateStarted();
	public void stopMetronome();
	public void updateTempo();
	public void updateTempsParMesure();
	public void marquerTemps();
	public void marquerMesure();

}
