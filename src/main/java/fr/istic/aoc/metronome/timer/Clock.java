package fr.istic.aoc.metronome.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.metronome.command.Command;;

/**
 * Created by djiby on 07/11/16.
 */
public class Clock {

    private Command commande;
    private ScheduledExecutorService scheduler;

    public Clock(Command cmd) {
        this.commande = cmd;
    }

    public void start(long period) {
        if (scheduler != null) {
            this.stop();
        }
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> commande.execute(), 1000L, period, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        scheduler.shutdownNow();
    }
}
