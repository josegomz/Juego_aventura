package interfaz;

//paquetes importados
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Josegomz
 */
public class Menu extends Ventana {

    //objetos internos 
    //componentes Jpanel
    JPanel panel_menu;
    JPanel panel_acerca;
    JPanel panel_puntuacion;

    //componentes generales
    //componentes menu
    private JLabel lbl_menu;
    private JLabel btn_iniciar;
    private JLabel btn_acerca;
    private JLabel btn_puntuacion;
    public JLabel lbl_creditos;

    //componentes acerca de 
    private JLabel lbl_ventanaAD;
    private JScrollPane scroll_AD;
    private JTextPane lbl_acerca;

    //cmponentes puntuacion
    private JLabel lbl_ventanaP;
    private JTable tabla_puntuacion;
    private DefaultTableModel modelo;
    String[] titulo_tabla = {"Nombre", "Puntuacion"};
    private JScrollPane jScrollPane1;

    //constructor vacío
    public Menu() {
        initFrame(1000, 700);
        cargarConfiguracion();
        cargarComponentesExtras();
        playMusic("Osondoar.wav");
        initComponentes();
        initEvent();
        componentsFrame();
    }

    @Override
    protected void initComponentes() {
        //personalizar panel
        panel_menu = getPanel();
        //botones
        btn_iniciar = new JLabel();
        btn_iniciar.setIcon(new ImageIcon("recursos/img/gui/botones/iniciar_01.png"));
        btn_iniciar.setSize(300, 100);
        btn_iniciar.setLocation(350, 200);

        btn_acerca = new JLabel();
        btn_acerca.setIcon(new ImageIcon("recursos/img/gui/botones/acerca_01.png"));
        btn_acerca.setSize(300, 100);
        btn_acerca.setLocation(350, 420);

        btn_puntuacion = new JLabel();
        btn_puntuacion.setIcon(new ImageIcon("recursos/img/gui/botones/puntuacion_01.png"));
        btn_puntuacion.setSize(300, 100);
        btn_puntuacion.setLocation(350, 310);

        lbl_menu = new JLabel();
        lbl_menu.setIcon(new ImageIcon("recursos/Game/img/gui/ventana/menu_01.png"));
        lbl_menu.setSize(450, 500);
        lbl_menu.setLocation(275, 100);

        lbl_creditos = new JLabel();
        lbl_creditos.setFont(new java.awt.Font("Tahoma", 0, 10));
        lbl_creditos.setSize(250, 40);
        lbl_creditos.setLocation(750, 660);
        lbl_creditos.setText("<html><a href=''>Juego creado por: José Benito Gómez Sánchez</a></html>");
        lbl_creditos.setForeground(new java.awt.Color(0, 0, 0));
        lbl_creditos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        //agregar los componentes al frame
        agregarConfiguracion(panel_menu);
        ocultarConfiguracion();
        panel_menu.add(lbl_creditos);
        panel_menu.add(btn_conf);
        panel_menu.add(titulo);
        panel_menu.add(btn_iniciar);
        panel_menu.add(btn_puntuacion);
        panel_menu.add(btn_acerca);
        panel_menu.add(lbl_menu);
        panel_menu.add(fondo);

        //acerca_de
        panel_acerca = getPanel();
        panel_acerca.setVisible(false);

        scroll_AD = new JScrollPane();
        scroll_AD.setSize(620, 330);
        scroll_AD.setBorder(null);
        scroll_AD.setLocation(190, 210);
        scroll_AD.setBackground(new java.awt.Color(213, 173, 81));
        scroll_AD.getVerticalScrollBar().setBackground(new java.awt.Color(193, 153, 61));
        scroll_AD.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new java.awt.Color(65, 44, 23);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        });
        lbl_acerca = new JTextPane();
        lbl_acerca.setFont(new java.awt.Font("Tahoma", 0, 38)); // NOI18N
        lbl_acerca.setBackground(new java.awt.Color(213, 173, 81));
        lbl_acerca.setText("aventura \n\nEl  juego  trata  de  una  aventura  donde  el  heroe  con  el  uso  de  sus  conocimientos  va  a  rescatar  a  su  princesa  quien  fue  secuestrada  por  unos  terribles  goblins \n\n"
                + "en  la  etapa  final  del  juego  el  heroe  tendra  que  luchar  con  el  jefe  para  poder  rescatar  a  la  princesa \n\n"
                + "Los  problemas  que  tendran  los obstaculos  seran  del  nivel  de  primaria  para  que  no  sea  complicado  el  juego");
        try {
            lbl_acerca.setFont(getFont(50));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_acerca.setCaretPosition(0);
        lbl_acerca.setEditable(false);
        StyledDocument doc = lbl_acerca.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
        scroll_AD.setViewportView(lbl_acerca);

        //botones
        lbl_ventanaAD = new JLabel();
        lbl_ventanaAD.setIcon(new ImageIcon("recursos/img/gui/ventana/acerca_de_01.png"));
        lbl_ventanaAD.setSize(800, 600);
        lbl_ventanaAD.setLocation(100, 50);

        panel_acerca.add(scroll_AD);
        panel_acerca.add(lbl_ventanaAD);
        //puntuación
        panel_puntuacion = getPanel();
        panel_puntuacion.setVisible(false);
        tabla_puntuacion = new JTable();
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setSize(620, 330);
        jScrollPane1.setBorder(null);
        jScrollPane1.setLocation(190, 210);
        jScrollPane1.setBackground(new Color(213, 173, 81));
        jScrollPane1.setViewportView(tabla_puntuacion);
        jScrollPane1.getVerticalScrollBar().setBackground(new java.awt.Color(193, 153, 61));
        jScrollPane1.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new java.awt.Color(65, 44, 23);
            }

            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }

            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        });
        tabla_puntuacion.setBackground(new Color(213, 173, 81));
        try {
            tabla_puntuacion.getTableHeader().setFont(getFont(50));
            tabla_puntuacion.setFont(getFont(50));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla_puntuacion.setFillsViewportHeight(true);
        tabla_puntuacion.getTableHeader().setOpaque(false);
        tabla_puntuacion.getTableHeader().setBackground(new Color(213, 173, 81));
        tabla_puntuacion.getTableHeader().setBorder(null);
        tabla_puntuacion.setBorder(null);
        tabla_puntuacion.setSelectionBackground(new Color(193, 153, 61));
        tabla_puntuacion.setSelectionForeground(Color.BLACK);
        tabla_puntuacion.setRowHeight(60);
        tabla_puntuacion.setGridColor(Color.BLACK);
        tabla_puntuacion.setShowGrid(true);
        tabla_puntuacion.setShowHorizontalLines(true);
        tabla_puntuacion.setShowVerticalLines(false);
        tabla_puntuacion.setEnabled(false);
        mostrarTabla();
        lbl_ventanaP = new JLabel();
        lbl_ventanaP.setIcon(new ImageIcon("recursos/img/gui/ventana/puntuacion.png"));
        lbl_ventanaP.setSize(800, 600);
        lbl_ventanaP.setLocation(100, 50);
        panel_puntuacion.add(jScrollPane1);
        panel_puntuacion.add(lbl_ventanaP);

    }

    private void mostrarTabla() {
        String barra = File.separator;
        String ubicacion = System.getProperty("user.dir") + barra + "recursos" + barra + "registros" + barra;
        File contenedor = new File(ubicacion);
        File[] registros = contenedor.listFiles();
        modelo = new DefaultTableModel(null, titulo_tabla) {
            Class[] types = new Class [] {
                 java.lang.Object.class,java.lang.Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        };
        tabla_puntuacion.setModel(modelo);

        for (int i = 0; i < registros.length; i++) {
            File url = new File(ubicacion + registros[i].getName());
            try {
                FileInputStream fis = new FileInputStream(url);
                Properties mostrar = new Properties();
                mostrar.load(fis);
                if (mostrar.getProperty("username") != null) {
                    String username = mostrar.getProperty("username");
                    int puntuacion = Integer.parseInt(mostrar.getProperty("puntuacion"));
                    modelo.addRow(new Object[]{username,puntuacion});
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(modelo);
        ArrayList <RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        elQueOrdena.setSortKeys(sortKeys); 
        elQueOrdena.setSortable(0, false);
        tabla_puntuacion.setRowSorter(elQueOrdena);
    }

    private void componentsFrame() {
        getContentPane().add(panel_menu);
        getContentPane().add(panel_acerca);
        getContentPane().add(panel_puntuacion);
    }

    /*
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("/Game/img/player/hombre/Idle_1.png"));
        return retValue;
    }
     */
    public void cambiar_componentes(JPanel panel_actual) {
        panel_actual.add(btn_atras);
        panel_actual.add(fondo);
        panel_actual.setVisible(true);
        btn_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_atras.setIcon(new ImageIcon("recursos/img/gui/botones/atras_01.png"));
                panel_menu.setVisible(true);
                panel_menu.enable();
                panel_actual.disable();
                panel_actual.setVisible(false);
                panel_menu.add(fondo);
            }
        });
    }

    @Override
    protected void initEvent() {
        btn_iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_iniciar.setIcon(new ImageIcon("recursos/img/gui/botones/iniciar_03.png"));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_iniciar.setIcon(new ImageIcon("recursos/img/gui/botones/iniciar_02.png"));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_iniciar.setIcon(new ImageIcon("recursos/img/gui/botones/iniciar_01.png"));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    guardarConfiguracion();
                    SelectGenero selectGenero = new SelectGenero();
                    selectGenero.show();
                    stopMusic();
                    dispose();
                }
            }
        });

        btn_acerca.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_acerca.setIcon(new ImageIcon("recursos/img/gui/botones/acerca_03.png"));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_acerca.setIcon(new ImageIcon("recursos/img/gui/botones/acerca_02.png"));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_acerca.setIcon(new ImageIcon("recursos/img/gui/botones/acerca_01.png"));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_acerca.setIcon(new ImageIcon("recursos/img/gui/botones/acerca_01.png"));
                    panel_menu.disable();
                    panel_menu.setVisible(false);
                    cambiar_componentes(panel_acerca);
                }
            }
        });
        btn_puntuacion.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_puntuacion.setIcon(new ImageIcon("recursos/img/gui/botones/puntuacion_03.png"));
                    playSound("click.wav");
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_puntuacion.setIcon(new ImageIcon("recursos/img/gui/botones/puntuacion_02.png"));
                    playSound("click2.wav");
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_puntuacion.setIcon(new ImageIcon("recursos/img/gui/botones/puntuacion_01.png"));
                }
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    btn_puntuacion.setIcon(new ImageIcon("recursos/img/gui/botones/puntuacion_01.png"));
                    panel_menu.disable();
                    panel_menu.setVisible(false);
                    cambiar_componentes(panel_puntuacion);
                }
            }
        });

        lbl_creditos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (mouseListener) {
                    try {
                        if (Desktop.isDesktopSupported()) {
                            Desktop desktop = Desktop.getDesktop();
                            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                                desktop.browse(new URI("https://github.com/josegomz"));
                            }
                        }
                    } catch (IOException | URISyntaxException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });
    }

}
