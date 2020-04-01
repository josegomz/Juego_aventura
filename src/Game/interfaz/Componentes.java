/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.applet.Applet;
import java.applet.AudioClip;
import javax.swing.JLabel;

/**
 *
 * @author macbookair
 */
public class Componentes {
    AudioClip audio;
    //background 
    public JLabel fondo;
    
    //Buttons
    public JLabel btn_cerrar;
    
    public Componentes(){
        initComponents();
    }
            
    public void initComponents(){
        //personalizar el fondo
        fondo = new JLabel();
        fondo.setSize(1000,700);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/img/bg/BG1.png"))); // NOI18N
        
        //boton cerrar
        btn_cerrar = new JLabel();
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/game/img/bg/BG1.png"))); // NOI18N
        
    }
     public void playAudio(String nombre){
         audio = Applet.newAudioClip(getClass().getClassLoader().getResource("/game/music/"+nombre));
         audio.loop();
     }
     
}
