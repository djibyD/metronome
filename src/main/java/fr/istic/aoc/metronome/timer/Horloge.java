package fr.istic.aoc.metronome.timer;

import fr.istic.aoc.metronome.command.Command;

/**
 * Created by djiby on 08/01/17.
 */
public interface Horloge {

    void activerPeriodiquement(Command command, long period);

    void activerApresDelai(Command command, long delai);

    void desactiver(Command command);
}
