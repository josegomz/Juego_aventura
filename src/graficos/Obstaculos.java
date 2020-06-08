/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author josegomz
 */
public class Obstaculos {

        int posX;
        int posY;
        JLabel[] tile_02;
        JLabel[] objetos;

        public Obstaculos(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
            initComponents();
        }

 
        private ImageIcon randomObject(){
            int icon = (int) Math.floor(Math.random()*6+1);
            ImageIcon imageIcon = new ImageIcon("recursos/img/object/object"+icon+".png");
            double alto=(83.0/imageIcon.getIconWidth())*imageIcon.getIconHeight();
            System.out.println("ancho:"+alto);
            Image image = imageIcon.getImage(); // transform it 
           
            Image newimg = image.getScaledInstance(83, (int)alto,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
            return imageIcon;
        }
        private void initComponents() {
            objetos = new JLabel[3];
            tile_02 = new JLabel[3];
            for (int i = 0; i < 3; i++) {
                tile_02[i] = new JLabel();
                tile_02[i].setSize(83, 60);
                tile_02[i].setLocation(posX + (i * 83), posY);
                tile_02[i].setIcon(new ImageIcon("recursos/img/tiles/" + (13 + i) + ".png"));
                objetos[i] = new JLabel();
                objetos[i].setSize(83, 83);
                objetos[i].setLocation(posX + (i * 83), posY-83);
                objetos[i].setIcon(randomObject());
                objetos[i].setVerticalTextPosition(JLabel.BOTTOM);
                objetos[i].setVerticalAlignment(JLabel.BOTTOM);
   

            }
        }

        public void agregar(JPanel panel) {
            panel.add(tile_02[0]);
            panel.add(tile_02[1]);
            panel.add(tile_02[2]);
            panel.add(objetos[0]);
            panel.add(objetos[1]);
            panel.add(objetos[2]);
        }

        public void mover(int paso) {
            for (int i = 0; i < 3; i++) {
                tile_02[i].setLocation(tile_02[i].getX() + paso, tile_02[i].getY());
                objetos[i].setLocation(objetos[i].getX() + paso, objetos[i].getY());
            }
        }
    }