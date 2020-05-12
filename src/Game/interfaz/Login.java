/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author josegomz
 */
public class Login extends Ventana{
    JPanel panel_login;
    
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JLabel btn_ok;
    
    private JTextField txt_username;
    private JPasswordField txt_password;
    
    private Component confirmation;
    String usuario = "root";
    String password = "root";
    
    //constructor
    public Login(){
        initFrame(400,350);
        cargarComponentesExtras();
        initComponentes();
        initEvent();
        componentsFrame();
    }

    @Override
    protected void initComponentes() {
        panel_login = getPanel();
        
        fondo.setLocation(-200, -200);
        btn_ok = new JLabel();
        btn_ok.setSize(200, 67);
        btn_ok.setLocation(100, 270);
        btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/entrar_01.png"))); // NOI18N
        
        lbl_username = new JLabel();
        lbl_password = new JLabel();
        lbl_username.setSize(300, 50);
        lbl_password.setSize(300, 50);
        lbl_username.setLocation(25, 70);
        lbl_password.setLocation(25, 160); 
        try {
            lbl_username.setFont(getFont(30));
            lbl_password.setFont(getFont(30));

        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }       
        lbl_username.setText("User");
        lbl_password.setText("Password");
        
        txt_username = new JTextField();
        txt_username.setSize(350, 50);
        txt_username.setLocation(25, 110);
        txt_username.setBackground(new java.awt.Color(213, 173, 81));
        txt_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        try {
            txt_username.setFont(getFont(30));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_username.setBorder(null);
        
        txt_password = new JPasswordField();
        txt_password.setSize(350, 50);
        txt_password.setLocation(25, 200);
        txt_password.setBackground(new java.awt.Color(213, 173, 81));
        txt_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_password.setBorder(null);
        
        titulo.setForeground(Color.BLACK);
        titulo.setLocation(0, 10);
        titulo.setSize(400, 50);
        titulo.setText("Login");
        
        panel_login.add(lbl_username);
        panel_login.add(lbl_password);
        panel_login.add(txt_username);
        panel_login.add(txt_password);
        panel_login.add(btn_ok);
        panel_login.add(titulo);
        panel_login.add(fondo);
        
        
    }
    
    @Override
    protected JPanel getPanel(){ 
        JPanel jPanel = new JPanel();
        GroupLayout grupo = new GroupLayout(jPanel);
        jPanel.setLayout(grupo);
        jPanel.setSize(400, 350);
        jPanel.setBackground(Color.WHITE);
        return jPanel;
    }
    
    private void componentsFrame() {
        getContentPane().add(panel_login);
    }
    
    @Override
    protected void initEvent(){
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/entrar_03.png")));
                playSound("click.wav");
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/entrar_02.png")));
                playSound("click2.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/entrar_01.png")));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Game/img/gui/botones/entrar_01.png")));
                Menu menu = new Menu();
                menu.show();
                dispose();
                        
            }
        });
    }
    
    //metodo principal
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
}
