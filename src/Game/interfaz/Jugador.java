/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import javax.swing.JLabel;

/**
 *
 * @author macbookair
 */
public class Jugador{
    JLabel player;
    String genero;
    public Jugador(String genero,int posX, int posY){
        player = new JLabel();
        this.genero = genero;
        paint(1);
        player.setSize(170,250);
        setLocation(posX, posY);
    }
    public void paint(int numero){
        player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/"+genero+"/Idle_"+numero+".png")));
    }
    public void paint_walk(int numero){
        player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/"+genero+"/Walk_"+numero+".png")));
    }
    public void paint_jump(int numero){
        player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/"+genero+"/Jump_"+numero+".png")));
    }
    public int getX(){
        return player.getX();
    }
    public int getY(){
        return player.getY();
    }
    public void setLocation(int posX,int posY){
        player.setLocation(posX, posY);
    }
}
