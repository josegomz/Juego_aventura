package interfaz;

import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author macbookair
 */
public class SelectGenero extends Ventana{
    private JPanel panel_genero;
    //mas componentes
    private JLabel ventana_genero;
    Movimiento movimiento;
    private JLabel player1;
    private JLabel player2;

    
    public SelectGenero(){
        initFrame(1000,700);
        cargarConfiguracion();
        cargarComponentesExtras();
        playMusic("airship.wav");
        initComponentes();
        initEvent();
        componentesFrame();
        movimiento = new Movimiento();
        movimiento.start();
        
    }

    @Override
    protected void initComponentes() {
        panel_genero = getPanel();//obtienes el panel
        
        player1 = new JLabel();
        player1.setIcon(new ImageIcon("recursos/img/player/hombre/Idle_1.png"));
        player1.setSize(170, 250);
        player1.setLocation(305, 225);
         
        player2 = new JLabel();
        player2.setIcon(new ImageIcon("recursos/img/player/mujer/Idle_9.png"));
        player2.setSize(170, 250);
        player2.setLocation(525, 225);
        
        ventana_genero = new JLabel();
        ventana_genero.setIcon(new ImageIcon("recursos/img/gui/ventana/genero_01.png")); 
        ventana_genero.setSize(600, 400);
        ventana_genero.setLocation(200, 150);
        
        //agregar los componentes al panel 
        agregarConfiguracion(panel_genero);
        ocultarConfiguracion();
        titulo.setText("Seleccionar genero");
        try {
            titulo.setFont(getFont(60));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(SelectGenero.class.getName()).log(Level.SEVERE, null, ex);
        }
        panel_genero.add(btn_conf);
        panel_genero.add(player1);
        panel_genero.add(player2);
        panel_genero.add(titulo);
        panel_genero.add(ventana_genero);
        panel_genero.add(btn_atras);
        panel_genero.add(fondo);          
    }

    private void componentesFrame() {
        getContentPane().add(panel_genero);
    }
    

    @Override
    protected void initEvent() {
        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt){
                if(mouseListener){
                guardarConfiguracion();
                btn_atras.setIcon(new ImageIcon("recursos/img/gui/botones/atras_01.png")); 
                Menu menu = new Menu();
                menu.show();
                stopMusic();
                movimiento.stop();
                dispose();
                }
            }
        });
        
        player1.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                playSound("click.wav");
                                guardarConfiguracion();
                Jugar jugar = new Jugar("hombre");
                jugar.show();
                stopMusic();
                movimiento.stop();
                dispose();
            }
        });
        
        player2.addMouseListener(new java.awt.event.MouseAdapter(){
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                playSound("click.wav");
                                guardarConfiguracion();

                Jugar jugar = new Jugar("mujer");
                jugar.show();
                stopMusic();
                movimiento.stop();
                dispose();
            }
        });
    }
    
    private class Movimiento extends Thread{
        @Override
        public void run(){
            while(true){
                for(int i= 1;i<=8;i++){
                    try {
                        Thread.sleep(50);
                        player1.setIcon(new ImageIcon("recursos/img/player/hombre/Idle_"+i+".png"));
                        player2.setIcon(new ImageIcon("recursos/img/player/mujer/Idle_"+(i+8)+".png"));
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SelectGenero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        }
    }
}
