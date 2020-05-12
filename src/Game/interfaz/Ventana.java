package Game.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * clase padre de todas las ventanas a usar la mayoria de las ventanas contienen
 * estos elementos
 *
 * @author josegomz
 */
public abstract class Ventana extends JFrame {

    protected boolean mouseListener = true;
    protected boolean config = false;
    //sonido de fondo y efectos
    protected Clip musica;
    protected Clip sonido;
    protected String ruta = "/Game/music/";

    //elementos generales
    //ventana de configuración
    
    public JLabel btn_cerrar_conf;
    JLabel lbl_sonido;
    JLabel lbl_musica;
    JLabel img_sonido;
    JLabel img_musica;
    JSlider jSlider_musica;
    JSlider jSlider_sonido;
    public JLabel vnt_configuracion;
    //background 
    protected JLabel lbl_transparente;
    public JLabel fondo;
    public JLabel titulo;
    public double vol_sound= 1.0;
    //Buttons
    public JLabel btn_cerrar;
    public JLabel btn_atras;
    public JLabel btn_conf;

    //inicia el frame centrado y con el ancho y alto especificados
    public void initFrame(int width, int heigth) {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);//borra el boton ampliar minimizar y cerrar que trae por default
        setResizable(false);//evita cambiar de tamaño
        GroupLayout layout = new GroupLayout(getContentPane());//crea la capa a partir del frame
        getContentPane().setLayout(layout);//agrega una capa 
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, width, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, heigth, Short.MAX_VALUE));
        pack();
        setLocationRelativeTo(null);//centra le ventata
    }

    protected abstract void initComponentes();

    protected abstract void initEvent();

    protected void playMusic(String music) {
        try {
            musica = AudioSystem.getClip();
            try {
                musica.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + music)));
            } catch (UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            musica.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (LineUnavailableException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void setVolumeMusic(double volumen) {
        FloatControl gaincontrol = (FloatControl) musica.getControl(FloatControl.Type.MASTER_GAIN);
        float db = (float) (Math.log(volumen) / Math.log(10.0) * 20);
        gaincontrol.setValue(db);
    }

    protected void stopMusic() {
        musica.stop();
    }

    protected void replayMusic() {
        musica.loop(Clip.LOOP_CONTINUOUSLY);
    }

    protected void playSound(String sound) {
        try {
            sonido = AudioSystem.getClip();
            try {
                sonido.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + sound)));
            } catch (UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            FloatControl soundcontrol = (FloatControl) sonido.getControl(FloatControl.Type.MASTER_GAIN);
            float db = (float) (Math.log(vol_sound) / Math.log(10.0) * 20);
            soundcontrol.setValue(db);
            sonido.start();

        } catch (LineUnavailableException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected Font getFont(float size) throws FontFormatException, IOException {
        InputStream is = getClass().getResourceAsStream("/Game/font/ARCADECLASSIC.TTF");
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(size);
        return font;
    }

    protected JPanel getPanel() {
        JPanel jPanel = new JPanel();
        GroupLayout grupo = new GroupLayout(jPanel);
        jPanel.setLayout(grupo);
        jPanel.setSize(1000, 700);
        jPanel.setBackground(Color.WHITE);
        return jPanel;
    }

    //cargar componentes extras
    protected void cargarComponentesExtras() {
        //personalizar el fondo
        fondo = new JLabel();
        fondo.setSize(1000, 700);
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/bg/BG1.png")));
        //boton cerrar
        btn_cerrar = new JLabel();
        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_01.png"))); // NOI18N
        btn_cerrar.setSize(70, 70);
        btn_cerrar.setLocation(920, 10);

        btn_cerrar_conf = new JLabel();
        btn_cerrar_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_04.png"))); // NOI18N
        btn_cerrar_conf.setSize(50, 50);
        btn_cerrar_conf.setLocation(690, 250);

        //boton atras
        btn_atras = new JLabel();
        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png")));
        btn_atras.setSize(70, 70);
        btn_atras.setLocation(10, 10);
        //boton configuración
        btn_conf = new JLabel();
        btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png")));
        btn_conf.setSize(70, 70);
        btn_conf.setLocation(10, 620);

        vnt_configuracion = new JLabel();
        vnt_configuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/ventana/configuracion.png")));
        vnt_configuracion.setSize(600, 400);
        vnt_configuracion.setLocation(200, 150);
        
        img_musica = new JLabel();
        img_sonido = new JLabel();
        img_musica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/musica_01.png")));
        img_sonido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/sonido_01.png")));
        img_musica.setSize(60, 60);
        img_sonido.setSize(60, 60);
        img_musica.setLocation(275, 310);
        img_sonido.setLocation(275, 410);
        
        jSlider_musica = new javax.swing.JSlider();
        jSlider_sonido = new javax.swing.JSlider();
        jSlider_musica.setSize(300, 50);
        jSlider_sonido.setSize(300, 50);
        jSlider_musica.setLocation(340, 310);
        jSlider_sonido.setLocation(340, 410);
        jSlider_musica.setMajorTickSpacing(50);
        jSlider_musica.setPaintTicks(true);
        jSlider_musica.setValue(100);
        jSlider_sonido.setMajorTickSpacing(50);
        jSlider_sonido.setPaintTicks(true);
        jSlider_sonido.setValue(100);
        
        lbl_musica = new JLabel();
        lbl_sonido = new JLabel();
        titulo = new JLabel();
        try {
            lbl_musica.setFont(getFont(30));
            lbl_sonido.setFont(getFont(30));
            titulo.setFont(getFont(90));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_musica.setText("MUSICA");
        lbl_sonido.setText("EFECTOS");
        lbl_sonido.setSize(400, 40);
        lbl_musica.setSize(400, 40);
        lbl_musica.setLocation(275, 270);
        lbl_sonido.setLocation(275, 370);
        
        
        titulo.setText("AVENTURA");
        titulo.setSize(700, 100);
        titulo.setForeground(new java.awt.Color(0, 143, 57));
        titulo.setLocation(150, 10);
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_transparente = new JLabel();
        lbl_transparente.setSize(1000, 700);
        lbl_transparente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/bg/transparente.png"))); // NOI18N

        cargarEventos();
    }

    protected void agregarConfiguracion() {

    }

    //carga  los eventos de los componentes extras que se iniciaron
    private void cargarEventos() {
        btn_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_03.png")));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_02.png")));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_01.png")));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    System.exit(0);
                }
            }
        });
        btn_cerrar_conf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_06.png")));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_05.png")));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_04.png")));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_04.png")));
                    ocultarConfiguracion();
                }
            }
        });

        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_03.png")));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_02.png")));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png")));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png")));
                }
            }
        });

        btn_conf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_03.png")));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_02.png")));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png")));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png")));
                    lbl_transparente.setVisible(true);
                    mostrarConfiguracion();
                }
            }
        });
        
        jSlider_sonido.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vol_sound = jSlider_sonido.getValue() / 100.0;
                if(jSlider_sonido.getValue()%10==0)
                    playSound("click2.wav");

            }
        });
        
        jSlider_musica.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                setVolumeMusic((double) (jSlider_musica.getValue() / 100.0));
            }
        });

    }

    protected void mostrarConfiguracion() {
        lbl_musica.setVisible(true);
        lbl_sonido.setVisible(true);
        img_musica.setVisible(true);
        img_sonido.setVisible(true);
        jSlider_musica.setVisible(true);
        jSlider_sonido.setVisible(true);
        vnt_configuracion.setVisible(true);
        lbl_transparente.setVisible(true);
        btn_cerrar_conf.setVisible(true);
        desabilitarBotones();
        config = true;

    }

    protected void ocultarConfiguracion() {
        lbl_musica.setVisible(false);
        lbl_sonido.setVisible(false);
        img_musica.setVisible(false);
                img_sonido.setVisible(false);
        jSlider_musica.setVisible(false);
        jSlider_sonido.setVisible(false);
        vnt_configuracion.setVisible(false);
        lbl_transparente.setVisible(false);
        btn_cerrar_conf.setVisible(false);
        habilitarBotones();
        config = false;
    }

    protected void habilitarBotones() {
        mouseListener = true;
    }

    protected void desabilitarBotones() {
        mouseListener = false;

    }
}
