/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.applet.AudioClip;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author macbookair
 */
public class Jugar extends JFrame {
    Sonido sound;
    Jugador jugador;
    Componentes componentes;
    AudioClip audio;
    JPanel panel_jugar;

    JLabel btn_home;
    JLabel btn_pausa;

    public Jugar(String genero) {
        jugador = new Jugador(genero, 20, 320);
        sound = new Sonido();
        componentes = new Componentes();
        initFrame();
        initComponentes();
        componetesframe();
        audio = java.applet.Applet.newAudioClip(getClass().getResource("/Game/music/bg.wav"));
        audio.play();
    }


    private void initComponentes() {
        panel_jugar = componentes.getPanel();

        btn_home = new JLabel();
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_01.png")));
        btn_home.setSize(70, 70);
        btn_home.setLocation(10, 10);
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_02.png")));
                sound.sonido("click2.wav");
                
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_01.png")));
                
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_03.png")));
                sound.sonido("click.wav");
                
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_01.png")));
                Menu menu = new Menu();
                audio.stop();
                menu.show();
                dispose();
            }
            
        });
        btn_pausa = new JLabel();
        btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_01.png")));
        btn_pausa.setSize(70, 70);
        btn_pausa.setLocation(90, 10);
        btn_pausa.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_02.png")));
                sound.sonido("click2.wav");
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_01.png")));
                
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_03.png")));
                sound.sonido("click.wav");
                
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_01.png")));
                
            }
            
        });
        
        panel_jugar.add(jugador.player);
        panel_jugar.add(btn_home);
        panel_jugar.add(btn_pausa);
        panel_jugar.add(componentes.btn_cerrar);
        panel_jugar.add(componentes.fondo);
    }

    private void initFrame() {
        //personalizar el FRAME
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 1000, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 700, Short.MAX_VALUE));
        pack();
        setLocationRelativeTo(null);
    }

    private void componetesframe() {
        getContentPane().add(panel_jugar);
    }
}
