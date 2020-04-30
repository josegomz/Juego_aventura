//nombre del paquete
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
 * @author Josegomz
 */
public class Jugar extends JFrame {
    final int NUM_OBSTACULOS=5;
    //variables de objeto
    Movimiento hilo;
    Sonido sound;
    Jugador jugador;
    Componentes componentes;
    Obstaculos obstaculos[];
    AudioClip audio;
    
    JPanel panel_jugar;
    JLabel[] fondo;
    JLabel[] tile_01;
    JLabel btn_home;
    JLabel btn_pausa;

    public Jugar(String genero) {
        this.paso = new int[2];
        jugador = new Jugador(genero, 20, 390);
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
        
        obstaculos = new Obstaculos[NUM_OBSTACULOS];
        for (int i = 0; i < NUM_OBSTACULOS; i++) {
            obstaculos[i]= new Obstaculos(i*450+300, 500);
            obstaculos[i].agregar();
        }
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
        tile_01 = new JLabel[20];
        for (int i = 0; i < 20; i++) {
            tile_01[i] = new JLabel();
            tile_01[i].setSize(60, 60);
            tile_01[i].setLocation((60 * i), 640);
            tile_01[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/tiles/2.png")));
            panel_jugar.add(tile_01[i]);
        }
        
        fondo = new JLabel[2];
        for (int i = 0; i < 2; i++) {
            fondo[i] = new JLabel();
            fondo[i].setSize(1000, 700);
            fondo[i].setLocation(i * 1000, 0);
            fondo[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/bg/BG1.png"))); // NOI18N
        }
        
        panel_jugar.add(jugador.player);
        panel_jugar.add(btn_home);
        panel_jugar.add(btn_pausa);
        panel_jugar.add(componentes.btn_cerrar);
        panel_jugar.add(fondo[0]);
        panel_jugar.add(fondo[1]);
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
                        caminando = true;
                        paso[0]= -20;
                        paso[1] = -5;
                        break;
                    case KeyEvent.VK_A:
                        estadoizquierda = true;
                        caminando = true;
                        paso[0]= 20;
                        paso[1] = 5;
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
                    caminando = false;
                } else if (kevt == KeyEvent.VK_A) {
                    estadoizquierda = false;
                }
            }
        });

    }

    private void componetesframe() {
        getContentPane().add(panel_jugar);
    }
    
    //variables de estado del jugador
    private boolean estadoderecha;
    private boolean estadoizquierda;
    private boolean salto;
    private boolean caminando;
    private int[] paso ={-20,-3};

    //hilo que se encarga del movimiento
    private class Movimiento extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("");
                if (caminando) {
                    for (int j = 0; j < NUM_OBSTACULOS; j++) {
                            obstaculos[j].mover(paso[0]);
                    }
                    for (int i = 0; i < 20; i++) {
                        tile_01[i].setLocation(tile_01[i].getX() + paso[0], tile_01[i].getY());
                        if (tile_01[i].getX() == -60 && paso[0]== -20) {
                            tile_01[i].setLocation(19 * 60, tile_01[i].getY());
                        }
                        else if (tile_01[i].getX() == 19*60 && paso[0] == 20) {
                            tile_01[i].setLocation(-60, tile_01[i].getY());
                        }
                    }
                    for (int i = 0; i < 2; i++) {
                        fondo[i].setLocation(fondo[i].getX() + paso[1], 0);
                        if (fondo[i].getX() == -1000 &&paso[i]== -3) {
                            fondo[i].setLocation(1000, 0);
                        }
                        else if (fondo[i].getX() == 1000 && paso[i]== 3) {
                            fondo[i].setLocation(-1000, 0);
                        }
                    }
                }
                if (estadoderecha) {
                    sound.sonido("sfx_step_rock_r.wav");
                    for (int i = 1; i <= 8; i++) {
                        try {
                            Thread.sleep(30);
                            jugador.paint_walk(i);
                            if (i == 4) {
                                sound.sonido("sfx_step_rock_r.wav");
                            }
                            if (jugador.getX()<830) {
                                jugador.setLocation(jugador.getX() + 10, jugador.getY());
                            }
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }
                if (estadoizquierda) {
                    sound.sonido("sfx_step_rock_l.wav");
                    for (int i = 1; i <= 8; i++) {
                        try {
                            Thread.sleep(35);
                            jugador.paint_walk(i + 8);
                            if (i == 4) {
                                sound.sonido("sfx_step_rock_r.wav");
                            }
                            jugador.setLocation(jugador.getX() - 10, jugador.getY());
                            Thread.sleep(35);
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
                    int salt = 15;
                    sound.sonido("sfx_step_rock_l.wav");
                    for (int i = 1; i <= 15; i++) {
                        try {
                            Thread.sleep(20);
                            jugador.paint_jump(i);
                            jugador.setLocation(jugador.getX(), jugador.getY() - salt);
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Jugar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (i == 8) {
                            salt = -salt;
                        }
                    }

                    jugador.setLocation(jugador.getX(), jugador.getY() + 15);
                    sound.sonido("sfx_step_rock_l.wav");
                    salto = false;
                }
            }
        }
    }
    
    private class Obstaculos{
        int posX;
        int posY;
        JLabel[] tile_02;
        

        public Obstaculos(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
            initComponents();
        }

        private void initComponents() {
            tile_02 = new JLabel[3];
            for (int i = 0; i < 3; i++) {
                tile_02[i] = new JLabel();
                tile_02[i].setSize(83, 60);
                tile_02[i].setLocation(posX+(i*83), posY);
                tile_02[i].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/tiles/"+(13+i)+".png")));
                
            }
        }
        
        private void agregar(){
            panel_jugar.add(tile_02[0]);
            panel_jugar.add(tile_02[1]);
            panel_jugar.add(tile_02[2]);
        }
        
        private void mover(int paso){
            for (int i = 0; i < 3; i++)
                tile_02[i].setLocation(tile_02[i].getX() + paso, tile_02[i].getY());
        }
    }

}
