/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.applet.AudioClip;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author macbookair
 */
public class SelectGenero extends JFrame{
    private JPanel panel_genero;
    Componentes componentes;
    AudioClip audio;
    Sonido sonido;
    
    //mas componentes
    private JLabel ventana_genero;
    Movimiento movimiento;
    private JLabel player1;
    private JLabel player2;

    
    public SelectGenero(){
        componentes = new Componentes();
        sonido = new Sonido();
        inicializarFrame();
        initComponentes();
        componentesFrame();
        movimiento = new Movimiento();
        movimiento.start();
        audio = java.applet.Applet.newAudioClip(getClass().getResource("/Game/music/airship.wav"));
        audio.play();
    }

    private void initComponentes() {
        panel_genero = componentes.getPanel();//obtienes el panel
        
        
        componentes.btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                componentes.btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png"))); 
                Menu menu = new Menu();
                menu.show();
                audio.stop();
                dispose();
            }
        });
        
        player1 = new JLabel();
        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/hombre/Idle_1.png")));
        player1.setSize(170, 250);
        player1.setLocation(305, 225);
        
        player2 = new JLabel();
        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/mujer/Idle_9.png")));
        player2.setSize(170, 250);
        player2.setLocation(525, 225);
        
        
        ventana_genero = new JLabel();
        ventana_genero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/ventana/genero_01.png"))); 
        ventana_genero.setSize(600, 400);
        ventana_genero.setLocation(200, 150);
        
        //agregar los componentes al panel
        
        panel_genero.add(player1);
        panel_genero.add(player2);
        panel_genero.add(ventana_genero);
        panel_genero.add(componentes.btn_cerrar);
        panel_genero.add(componentes.btn_atras);
        panel_genero.add(componentes.fondo);
                
    }

    private void componentesFrame() {
        getContentPane().add(panel_genero);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectGenero().setVisible(true);
            }
        });
    }
    
    private void inicializarFrame(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(null);
    }
    private class Movimiento extends Thread{
        @Override
        public void run(){
            while(true){
                for(int i= 1;i<=8;i++){
                    try {
                        Thread.sleep(50);
                        player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/hombre/Idle_"+i+".png")));
                        player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/mujer/Idle_"+(i+8)+".png")));
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SelectGenero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
    }
}
