package Game.interfaz;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * clase padre de todas las ventanas a usar la mayoria de las ventanas contienen
 * estos elementos
 *
 * @author josegomz
 */
public abstract class Ventana extends JFrame {

    //sonido de fondo y efectos
    protected AudioClip musica;
    protected AudioClip sonido;
    protected String ruta = "/Game/music/";

    //elementos generales
    //background 
    protected JLabel lbl_transparente;
    public JLabel fondo;
    public JLabel titulo;

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
        musica = java.applet.Applet.newAudioClip(getClass().getResource(ruta + music));
        musica.loop();
    }

    protected void stopMusic() {
        musica.stop();
    }

    protected void replayMusic() {
        musica.loop();
    }

    protected void playSound(String sound) {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource(ruta + sound));
        sonido.play();
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
        //boton atras
        btn_atras = new JLabel();
        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png"))); // NOI18
        btn_atras.setSize(70, 70);
        btn_atras.setLocation(10, 10);
        //boton configuración
        btn_conf = new JLabel();
        btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png"))); // NOI18
        btn_conf.setSize(70, 70);
        btn_conf.setLocation(10, 620);

        titulo = new JLabel();
        try {
            titulo.setFont(getFont(90));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        titulo.setText("AVENTURA");
        titulo.setSize(700, 100);
        titulo.setForeground(new java.awt.Color(0, 143, 57));
        titulo.setLocation(150, 10);
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbl_transparente = new JLabel();
        lbl_transparente.setSize(1000, 700);
        lbl_transparente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/bg/transparente.png"))); // NOI18N
        lbl_transparente.setVisible(false);

        cargarEventos();
    }

    //carga  los eventos de los componentes extras que se iniciaron
    private void cargarEventos() {
        btn_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_03.png")));
                playSound("click.wav");
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_02.png")));
                playSound("click2.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/salir_01.png")));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });

        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_03.png")));
                playSound("click.wav");
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_02.png")));
                playSound("click2.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png")));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/atras_01.png")));
            }
        });

        btn_conf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_03.png")));
                playSound("click.wav");
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_02.png")));
                playSound("click2.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png")));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png")));
                lbl_transparente.setVisible(true);
            }
        });
    }

}
