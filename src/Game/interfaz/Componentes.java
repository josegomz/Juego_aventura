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
            
    private void initComponents(){
        //personalizar el fondo
        fondo = new JLabel();
        fondo.setSize(1000,700);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/bg/BG1.png"))); // NOI18N
        //boton cerrar
        btn_cerrar = new JLabel();
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_01.png"))); // NOI18N
        btn_cerrar.setSize(70, 70);
        btn_cerrar.setLocation(920, 10);
        btn_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_03.png"))); 
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_02.png"))); 
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_01.png"))); 
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_02.png"))); 
            }
        });
    }
     public void playAudio(String nombre){
         audio = Applet.newAudioClip(getClass().getClassLoader().getResource("/Game/music/"+nombre));
         audio.loop();
     }
     
}
