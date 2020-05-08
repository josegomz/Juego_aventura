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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Josegomz
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
    public JLabel btn_conf;
    
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
        
        btn_conf = new JLabel();
        btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png"))); // NOI18
        btn_conf.setSize(70, 70);
        btn_conf.setLocation(10, 620);
        btn_conf.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_03.png"))); 
                sound.sonido("click.wav");
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt){
                btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_02.png"))); 
                sound.sonido("click2.wav");
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt){
                btn_conf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/configuracion_01.png"))); 
            }
        });
        
        
        titulo = new JLabel();
        try {
            titulo.setFont(getFont(90));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Componentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        titulo.setText("AVENTURA");
        titulo.setSize(700,100);
        titulo.setForeground(new java.awt.Color(0, 143, 57));
        titulo.setLocation(150, 10);
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        
    }
    
    public JPanel getPanel(){ 
        JPanel jPanel = new JPanel();
        GroupLayout grupo = new GroupLayout(jPanel);
        jPanel.setLayout(grupo);
        jPanel.setSize(1000, 700);
        jPanel.setBackground(Color.WHITE);
        return jPanel;
    }
    
    public Font getFont(float size) throws FontFormatException, IOException {
        
        InputStream is = getClass().getResourceAsStream("/Game/font/ARCADECLASSIC.TTF");
        Font font = Font.createFont(Font.TRUETYPE_FONT, is);
        font = font.deriveFont(size);
        return font;
    }
}
