package Game.interfaz;

import java.applet.AudioClip;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author macbookair
 */
//clase para reproducir sonido de efectos
public class Sonido {
    public AudioClip audio;
    public String ruta = "/Game/music/";
    public void sonido(String archivo){
        audio = java.applet.Applet.newAudioClip(getClass().getResource(ruta+archivo));
        audio.play();
        /*try{
            clip=AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta+archivo)));
            clip.start();
        }catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
            System.out.println("Error de sonido");
        }*/
    }
}
