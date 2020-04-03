/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author macbookair
 */
public class Sonido {
    public Clip clip;
    public String ruta = "/Game/music/";
    public void sonido(String archivo){
        try{
            clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta+archivo)));
            clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            System.out.println("Error de sonido");
        }
    }
}
