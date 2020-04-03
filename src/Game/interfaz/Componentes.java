/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.applet.AudioClip;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author macbookair
 */
public class Componentes {
    public AudioClip audio;
    Sonido sound;

    //background 
    public JLabel fondo;
    public JLabel titulo;
    
    //Buttons
    public JLabel btn_cerrar;
    public JLabel btn_atras;
    
    public Componentes(){
        initComponents();
        sound = new Sonido();
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
                sound.sonido("click.wav");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_02.png"))); 
                sound.sonido("click2.wav");
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_01.png"))); 
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                System.exit(0);
            }
        });
        
        btn_atras = new JLabel();
        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png"))); // NOI18
        btn_atras.setSize(70, 70);
        btn_atras.setLocation(10, 10);
        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_03.png"))); 
                sound.sonido("click.wav");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_02.png"))); 
                sound.sonido("click2.wav");
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png"))); 
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png"))); 
            }
        });
    }
    
    public JPanel getPanel(){ 
        JPanel jPanel = new JPanel();
        GroupLayout grupo = new GroupLayout(jPanel);
        jPanel.setLayout(grupo);
        jPanel.setSize(1000, 700);
        jPanel.setBackground(Color.WHITE);
        return jPanel;
    }
    
}
