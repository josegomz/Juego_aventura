package Game.interfaz;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

/**
 *
 * @author macbookair
 */
public class Configuracion extends JPanel{
    float volAudio;
    float volEfectos;
    public Configuracion(){
        initComponentes();
    }
    private void initComponentes(){
        GroupLayout grupo = new GroupLayout(this);
        setLayout(grupo);
        setSize(600, 300);
        setLocation(200, 200);
        setBackground(new java.awt.Color(213, 173, 81));
    }
}
