/**
 * clase abstracta de una ventana en el cual tiene funciones que tienen en comun todas las
 * interfaces
 */

package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import org.ini4j.*;

/**  
 * @author josegomz
 */
public abstract class Ventana extends JFrame {

    protected boolean mouseListener = true;
    protected boolean config = false;
    //sonido de fondo y efectos
    protected Clip musica;
    protected Clip sonido;
    protected String ruta = "recursos/music/";

    //ventana de configuración
    public JLabel btn_cerrar_conf;
    protected JLabel lbl_sonido;
    protected JLabel lbl_musica;
    protected JLabel img_sonido;
    protected JLabel img_musica;
    protected JSlider jSlider_musica;
    protected JSlider jSlider_sonido;
    protected JLabel vnt_configuracion;
    protected JLabel lbl_transparente;

    //background 
    protected JLabel fondo;
    protected JLabel titulo;
    //variables de configuración
    public double vol_sound = 1.0;
    public double vol_music = 1.0;
    //Buttons
    protected JLabel btn_cerrar;
    protected JLabel btn_atras;
    protected JLabel btn_conf;

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
            InputStream audioSrc = new FileInputStream(new File(ruta+music));
            //Corrección del error mark/reset support en el ejecutable
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            musica = AudioSystem.getClip();
            musica.open(audioStream);
            setVolumeMusic();
            musica.loop(Clip.LOOP_CONTINUOUSLY);           
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void setVolumeMusic() {
        FloatControl gaincontrol = (FloatControl) musica.getControl(FloatControl.Type.MASTER_GAIN);
        float db = (float) (Math.log(vol_music) / Math.log(10.0) * 20);
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
            InputStream audioSrc = new FileInputStream(new File(ruta+sound));
            //Corrección del error mark/reset support en el ejecutable
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            sonido = AudioSystem.getClip();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            sonido.open(audioStream);
            //control de volumen
            FloatControl soundcontrol = (FloatControl) sonido.getControl(FloatControl.Type.MASTER_GAIN);
            float db = (float) (Math.log(vol_sound) / Math.log(10.0) * 20);
            soundcontrol.setValue(db);
            sonido.start();

        } catch (LineUnavailableException|UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected Font getFont(float size) throws FontFormatException, IOException {
        InputStream is = new FileInputStream(new File("recursos/font/ARCADECLASSIC.TTF"));
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
        fondo.setIcon(new ImageIcon("recursos/img/bg/BG1.png"));
        //boton cerrar
        btn_cerrar = new JLabel();
        btn_cerrar.setIcon(new ImageIcon("recursos/img/gui/botones/salir_01.png"));
        btn_cerrar.setSize(70, 70);
        btn_cerrar.setLocation(920, 10);

        btn_cerrar_conf = new JLabel();
        btn_cerrar_conf.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_01.png"), 50, 50));
        btn_cerrar_conf.setSize(50, 50);
        btn_cerrar_conf.setLocation(690, 250);

        //boton atras
        btn_atras = new JLabel();
        btn_atras.setIcon(new ImageIcon("recursos/img/gui/botones/atras_01.png"));
        btn_atras.setSize(70, 70);
        btn_atras.setLocation(10, 10);
        //boton configuración
        btn_conf = new JLabel();
        btn_conf.setIcon(new javax.swing.ImageIcon("recursos/img/gui/botones/configuracion_01.png"));
        btn_conf.setSize(70, 70);
        btn_conf.setLocation(10, 620);

        vnt_configuracion = new JLabel();
        vnt_configuracion.setIcon(new ImageIcon("recursos/img/gui/ventana/configuracion.png"));
        vnt_configuracion.setSize(600, 400);
        vnt_configuracion.setLocation(200, 150);

        img_musica = new JLabel();
        img_sonido = new JLabel();
        img_musica.setIcon(new ImageIcon("recursos/img/gui/botones/musica_01.png"));
        img_sonido.setIcon(new ImageIcon("recursos/img/gui/botones/sonido_01.png"));
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
        jSlider_sonido.setMajorTickSpacing(50);
        jSlider_sonido.setPaintTicks(true);
        Double vol1 = vol_music*100;
        Double vol2 = vol_sound*100;   
        jSlider_musica.setValue(vol1.intValue());
        jSlider_sonido.setValue(vol2.intValue());

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
        lbl_transparente.setIcon(new ImageIcon("recursos/img/bg/transparente.png"));

        cargarEventos();
    }

    //carga  los eventos de los componentes extras que se iniciaron
    private void cargarEventos() {
        btn_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(new ImageIcon("recursos/img/gui/botones/salir_03.png"));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(new ImageIcon("recursos/img/gui/botones/salir_02.png"));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(new ImageIcon("recursos/img/gui/botones/salir_01.png"));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    guardarConfiguracion();
                    System.exit(0);
                }
            }
        });
        btn_cerrar_conf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_03.png"), 50, 50));

                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_02.png"), 50, 50));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_01.png"), 50, 50));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (config) {
                    btn_cerrar_conf.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_01.png"), 50, 50));
                    ocultarConfiguracion();
                }
            }
        });

        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new ImageIcon("recursos/img/gui/botones/atras_03.png"));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new ImageIcon("recursos/img/gui/botones/atras_02.png"));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new ImageIcon("recursos/img/gui/botones/atras_01.png"));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_atras.setIcon(new ImageIcon("recursos/img/gui/botones/atras_01.png"));
                }
            }
        });

        btn_conf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new ImageIcon("recursos/img/gui/botones/configuracion_03.png"));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new ImageIcon("recursos/img/gui/botones/configuracion_02.png"));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new ImageIcon("recursos/img/gui/botones/configuracion_01.png"));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_conf.setIcon(new ImageIcon("recursos/img/gui/botones/configuracion_01.png"));
                    lbl_transparente.setVisible(true);
                    mostrarConfiguracion();
                }
            }
        });

        jSlider_sonido.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vol_sound = jSlider_sonido.getValue() / 100.0;
                if (jSlider_sonido.getValue() % 10 == 0) {
                    playSound("click2.wav");
                }

            }
        });

        jSlider_musica.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vol_music = (double) (jSlider_musica.getValue() / 100.0);
                setVolumeMusic();
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

    protected void agregarConfiguracion(JPanel panel) {
        panel.add(lbl_musica);
        panel.add(img_musica);
        panel.add(img_sonido);
        panel.add(lbl_sonido);
        panel.add(jSlider_musica);
        panel.add(jSlider_sonido);
        panel.add(btn_cerrar_conf);
        panel.add(vnt_configuracion);
        panel.add(lbl_transparente);
    }

    protected void cargarConfiguracion() {
        try {
            Wini ini = new Wini(new File("recursos/config.ini"));
            vol_music = ini.get("volumen", "music", double.class);
            vol_sound = ini.get("volumen", "sound", double.class);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error al cargar la configuracion", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void guardarConfiguracion() {
        try {
            Wini ini = new Wini(new File("recursos/config.ini"));          
            ini.put("volumen", "music", vol_music);
            ini.put("volumen", "sound", vol_sound);
            ini.store();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error al guardar la configuracion", JOptionPane.WARNING_MESSAGE);
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ImageIcon getImageIconResized(ImageIcon imageIcon,int ancho, int alto){
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back
        return imageIcon;
    }
}
