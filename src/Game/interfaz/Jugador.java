/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import javax.swing.JLabel;

/**
 *
 * @author josegomz
 */
public class Jugador{
    Conexion conexion;
    //informacion importante del jugador en el juego;
    int id;
    String username;
    int score;
    
    JLabel player;
    String genero;
    public Jugador(String genero,int posX, int posY){
        player = new JLabel();
        this.genero = genero;
        paint(1);
        player.setSize(170,250);
        setLocation(posX, posY);
    }
    //pinta un frame de la animación del jugador parado
    public void paint(int numero){
        player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/"+genero+"/Idle_"+numero+".png")));
    }
    
    /**
     * pinta un frame de la animacion del jugador caminando
     * @param numero 
     */
    public void paint_walk(int numero){
        player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/"+genero+"/Walk_"+numero+".png")));
    }
    public void paint_jump(int numero){
        player.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/player/"+genero+"/Jump_"+numero+".png")));
    }
    
    /**
     * retorna la posicion X actual de la posicion del jugador en el frame
     * @return 
     */
    public int getX(){
        return player.getX();
    }
    public int getY(){
        return player.getY();
    }
    
    /**
     * cambia la posicion del jugador en el frame
     * @param posX
     * @param posY 
     */
    public void setLocation(int posX,int posY){
        player.setLocation(posX, posY);
    }
    
    
}
