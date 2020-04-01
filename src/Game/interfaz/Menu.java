/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author macbookair
 */
public class Menu extends JFrame{
    Componentes componentes;
    JPanel panel_menu;

    public Menu(){
        componentes = new Componentes();
        initComponents();
        componentsFrame();
        componentes.playAudio("Osondoar.wav");
    }
    
    private void initComponents(){
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
        panel_menu = new JPanel();

        GroupLayout grupo = new GroupLayout(panel_menu);
        panel_menu.setLayout(grupo);
        panel_menu.setSize(1000, 700);
        panel_menu.setBackground(Color.GREEN);   
        
        panel_menu.add(componentes.btn_cerrar);
        panel_menu.add(componentes.fondo);
    }
    
    private void componentsFrame() {
        getContentPane().add(panel_menu);
    }
   
   
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    
}
