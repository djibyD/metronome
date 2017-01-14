package fr.istic.aoc.metronome.media;

import javafx.scene.media.AudioClip;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by djiby on 07/01/17.
 */
public class EmetteurSonoreImpl implements EmetteurSonore{

    //Contructeur
    public EmetteurSonoreImpl(){

    }

    @Override
    public void emettreClic() {
        System.out.println("emettre click!");

        String url = "file:./src/main/resources/beep.wav";

        AudioClip audio = null;

        try

        {
            audio = new AudioClip(new URL(url).toString());
        } catch(
                MalformedURLException e)

        {
            e.printStackTrace();
        }

        audio.play();
    }
}
