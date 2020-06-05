package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author josegomz
 */
public class Login extends Ventana {

    JPanel panel_login;

    private JLabel lbl_username;
    private JLabel lbl_password;
    private JLabel lbl_crear_cuenta;
    private JLabel btn_crear_cuenta;
    private JLabel btn_ok;
    private JTextField txt_username;
    private JPasswordField txt_password;

    private boolean login = true;

    private Component confirmation;
    //separador de carpetas tanto linux como windows
    String barra = File.separator;
    String ruta = System.getProperty("user.dir") + barra + "recursos" + barra + "registros";

    //constructor
    public Login() {
        initFrame(400, 450);
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
        btn_ok.setIcon(new ImageIcon("recursos/img/gui/botones/entrar_01.png"));

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

        btn_cerrar.setSize(50, 50);
        btn_cerrar.setLocation(340, 10);
        btn_cerrar.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_01.png"), 50, 50));
        btn_cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_03.png"), 50, 50));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_02.png"), 50, 50));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_cerrar.setIcon(getImageIconResized(new ImageIcon("recursos/img/gui/botones/salir_01.png"), 50, 50));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    guardarConfiguracion();
                    System.exit(0);
                }
            }
        });

        lbl_crear_cuenta = new JLabel();
        try {
            lbl_crear_cuenta.setFont(getFont(25));
            titulo.setFont(getFont(40));
        } catch (FontFormatException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_crear_cuenta.setForeground(Color.BLUE);
        lbl_crear_cuenta.setSize(200, 30);
        lbl_crear_cuenta.setText("Crear usuario");
        lbl_crear_cuenta.setLocation(35, 370);
        lbl_crear_cuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                playSound("click.wav");
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_crear_cuenta.setForeground(new java.awt.Color(150, 150, 150));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_crear_cuenta.setForeground(Color.BLUE);
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (login) {
                    lbl_crear_cuenta.setText("Iniciar Sesion");
                    titulo.setText("Registrarse");
                    login = false;
                } else {
                    lbl_crear_cuenta.setText("Crear usuario");
                    titulo.setText("Login");
                    login = true;

                }

            }
        });

        titulo.setForeground(Color.BLACK);
        titulo.setLocation(0, 10);
        titulo.setSize(400, 50);
        titulo.setText("Login");
        panel_login.add(lbl_crear_cuenta);
        panel_login.add(lbl_username);
        panel_login.add(lbl_password);
        panel_login.add(txt_username);
        panel_login.add(txt_password);
        panel_login.add(btn_ok);
        panel_login.add(titulo);
        panel_login.add(btn_cerrar);
        panel_login.add(fondo);

    }

    @Override
    protected JPanel getPanel() {
        JPanel jPanel = new JPanel();
        GroupLayout grupo = new GroupLayout(jPanel);
        jPanel.setLayout(grupo);
        jPanel.setSize(400, 450);
        jPanel.setBackground(Color.WHITE);
        return jPanel;
    }

    private void componentsFrame() {
        getContentPane().add(panel_login);
    }

    @Override
    protected void initEvent() {
        btn_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new ImageIcon("recursos/img/gui/botones/entrar_03.png"));
                playSound("click.wav");
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new ImageIcon("recursos/img/gui/botones/entrar_02.png"));
                playSound("click2.wav");
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new ImageIcon("recursos/img/gui/botones/entrar_01.png"));
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_ok.setIcon(new ImageIcon("recursos/img/gui/botones/entrar_01.png"));
                if (login) {
                    entrar();
                } else {
                    registrarse();
                }

            }

            private void entrar() {
                File url = new File(ruta+barra+txt_username.getText().trim()+".registro");
                if (txt_username.getText().trim().equals("") || txt_password.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    if(url.exists()){
                        try {
                            FileInputStream archivo = new FileInputStream(url);
                            Properties mostrar = new Properties();
                            mostrar.load(archivo);
                            if(txt_username.getText().trim().equals(mostrar.getProperty("username"))&&txt_password.getText().trim().equals(mostrar.getProperty("password"))){
                                gotoMenu();
                            }else{
                                JOptionPane.showMessageDialog(null, "usuario y contraseña incorrecots", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());         
                        }                  
                    }else{
                        JOptionPane.showMessageDialog(null, "El usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }

            }

            private void registrarse() {
                String archivo = txt_username.getText().trim() + ".registro";
                File crear_ubicacion = new File(ruta);
                File crear_archivo = new File(ruta +barra+ archivo);
                if (txt_username.getText().trim().equals("") || txt_password.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(null, "Campo vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
                } else {
                    try {
                        if (crear_archivo.exists()) {
                            JOptionPane.showMessageDialog(null, "El usuario ya existe", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        } else {
                            crear_ubicacion.mkdirs();
                            Formatter formatter = new Formatter(ruta+barra+archivo);
                            formatter.format("%s\r\n%s\r\n%s","username="+txt_username.getText(),"password="+txt_password.getText(),"puntuacion="+0);
                            formatter.close();
                            JOptionPane.showMessageDialog(null,"Registro creado");
                            gotoMenu();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No se puede crear el archivo", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                }

            }
        });
    }
    
    public void gotoMenu(){
        Menu menu = new Menu();
        menu.show();
        dispose();
    }

    //metodo principal
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

}
