package fr.istic.aoc.metronome.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.metronome.command.Command;;

/**
 * Created by djiby on 07/11/16.
 */
public class Clock implements Horloge{

    private ScheduledExecutorService scheduler;

    public Clock() {
    }

    @Override
    public void activerPeriodiquement(Command command, long period) {
        if (scheduler != null) {
            this.stop();
        }
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> command.execute(), 1000L, period, TimeUnit.MILLISECONDS);
    }

    @Override
    public void activerApresDelai(Command command, long delai) {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleWithFixedDelay(() -> command.execute(), 0L, delai, TimeUnit.MILLISECONDS);
    }

    @Override
    public void desactiver(Command command) {

    }

    public void stop() {
        scheduler.shutdownNow();
    }
}
