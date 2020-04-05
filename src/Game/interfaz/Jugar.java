/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.applet.AudioClip;
import java.awt.event.KeyEvent;
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
public class Jugar extends JFrame {

    Movimiento hilo;
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
        hilo = new Movimiento();
        hilo.start();
    }

    private void initComponentes() {
        panel_jugar = componentes.getPanel();

        btn_home = new JLabel();
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_01.png")));
        btn_home.setSize(70, 70);
        btn_home.setLocation(10, 10);
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_02.png")));
                sound.sonido("click2.wav");

            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_01.png")));

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/home_03.png")));
                sound.sonido("click.wav");

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_02.png")));
                sound.sonido("click2.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_01.png")));

            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_pausa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/pausa_03.png")));
                sound.sonido("click.wav");

            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
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
        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                int kevt = evt.getExtendedKeyCode();
                switch (kevt) {
                    case KeyEvent.VK_D:
                        estadoderecha = true;
                        break;
                    case KeyEvent.VK_A:
                        estadoizquierda = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        salto = true;
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                int kevt = evt.getExtendedKeyCode();
                if (kevt == KeyEvent.VK_D) {
                    estadoderecha = false;
                } else if (kevt == KeyEvent.VK_A) {
                    estadoizquierda = false;
                }
            }
        });

    }

    private void componetesframe() {
        getContentPane().add(panel_jugar);
    }
    private boolean estadoderecha;
    private boolean estadoizquierda;
    private boolean salto;

    private class Movimiento extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println("");
                if (estadoderecha) {
                    sound.sonido("sfx_step_rock_r.wav");
                    for (int i = 1; i <= 8; i++) {
                        try {
                            Thread.sleep(50);
                            jugador.paint_walk(i);
                            if (i == 4) {
                                sound.sonido("sfx_step_rock_r.wav");
                            }
                            jugador.setLocation(jugador.getX() + 10, jugador.getY());
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
                if (estadoizquierda) {
                    sound.sonido("sfx_step_rock_l.wav");
                    for (int i = 1; i <= 8; i++) {
                        try {
                            Thread.sleep(50);
                            jugador.paint_walk(i + 8);
                            if (i == 4) {
                                sound.sonido("sfx_step_rock_r.wav");
                            }
                            jugador.setLocation(jugador.getX() - 10, jugador.getY());
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (!estadoderecha && !estadoizquierda) {
                    for (int i = 1; i <= 8; i++) {
                        try {
                            Thread.sleep(50);
                            jugador.paint(i);
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                if (salto) {
                    sound.sonido("sfx_step_rock_l.wav");
                    for (int i = 1; i <= 8; i++) {
                        try {
                            Thread.sleep(50);
                            jugador.paint_jump(i);
                            jugador.setLocation(jugador.getX(), jugador.getY() - 15);
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    for (int i = 9; i <= 15; i++) {
                        try {
                            Thread.sleep(30);
                            jugador.paint_jump(i);
                            jugador.setLocation(jugador.getX(), jugador.getY() + 15);
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    jugador.setLocation(jugador.getX(), jugador.getY() + 15);
                    sound.sonido("sfx_step_rock_l.wav");
                    salto = false;
                }
            }
        }
    }

}
