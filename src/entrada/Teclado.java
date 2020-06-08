/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entrada;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @akuthor josegomz
 */
public class Teclado implements KeyListener{
    public boolean keys[]= new boolean[256];
    public static boolean UP, LEFT,RIGHT, SPACE;
    
    public Teclado(){
        UP= false;
        LEFT = false;
        RIGHT = false;
        SPACE = false;
    }
    
    public void update(){
        UP =keys[KeyEvent.VK_UP];
        LEFT = keys[KeyEvent.VK_LEFT];
        RIGHT = keys[KeyEvent.VK_RIGHT];
        SPACE = keys[KeyEvent.VK_SPACE];
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()]=true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    
}
