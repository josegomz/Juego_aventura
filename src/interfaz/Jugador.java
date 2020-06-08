package interfaz;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author josegomz
 */
public class Jugador{
    public int posX;
    public int posY;
    private final int velocidadx = 10;
    private final int velocidady = 25;
    JLabel player;

    //informacion importante del jugador en el juego;
    String genero;
    String username;
    int id;
    int score;        
    
    int boundx=85;
    int boundy=125;
    
    //constructor
    public Jugador(String genero,int posX, int posY){
        player = new JLabel();
        this.genero = genero;
        this.posX = posX;
        this.posY = posY;
        paint(1);
        player.setSize(170,250);
        player.setLocation(posX-boundx, posY-boundy);
    }
    
    //pinta un frame de la animación del jugador parado
    public void paint(int numero){
        player.setIcon(new ImageIcon("recursos/img/player/"+genero+"/Idle_"+numero+".png"));
    }
    
    /**
     * pinta un frame de la animacion del jugador caminando
     * @param numero 
     */
    public void paint_walk(int numero){
        player.setIcon(new ImageIcon("recursos/img/player/"+genero+"/Walk_"+numero+".png"));
    }
    public void paint_jump(int numero){
        player.setIcon(new ImageIcon("recursos/img/player/"+genero+"/Jump_"+numero+".png"));
    }
    
    /**
     * retorna la posicion X actual de la posicion del jugador en el frame
     * @return 
     */
    public int getX(){
        return player.getX();
    }
    /**
     * retorna la posicion y actual de la posicion del jugador
     * @return 
     */
    public int getY(){
        return player.getY();
    }
    
    //mover al jugador a la izquierda
    public void moverIzquierda(){
        if(player.getX() > 0){
            player.setLocation(player.getX() -(velocidadx+10), player.getY());
            posX -= velocidadx;
            
        }
    }
    public void moverDerecha(){
        if(player.getX() < 830){
            player.setLocation(player.getX() +velocidadx, player.getY());
            posX += velocidadx;
        }
    }
    
    public void moverArriba(){
        if(player.getY() > 0){
            player.setLocation(player.getX(), player.getY()-velocidady);
            posY -= velocidady;
        }
    }
    
    public void moverAbajo(){
        player.setLocation(player.getX(), player.getY()+velocidady);
        posY += velocidady; 
    }
    
    
    
}
