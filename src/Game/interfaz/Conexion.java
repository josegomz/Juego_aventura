package Game.interfaz;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josegomz
 */
public class Conexion {

    public Connection con;
    protected String database = "juego_aventura";//nombre de la Base de datos
    protected String pass_bd = "root";//Nombre de la contraseña de usuario postgres

    //constructor
    public Conexion() {
        try {
            Class.forName("org.postgresql.Driver");  //loads the driver
        } catch (ClassNotFoundException e) {
            System.out.println("No encontro driver");
        }
        try {
            String url;
            url = "jdbc:postgresql://localhost:5432/" + database;
            con = DriverManager.getConnection(url, "postgres", pass_bd);
            checkForWarning(con.getWarnings());//revisa advertencias
            DatabaseMetaData dma = con.getMetaData();
            System.out.println("\nConectado a: " + dma.getURL());
            System.out.println("Driver       " + dma.getDriverName());
            System.out.println("Version      " + dma.getDriverVersion());
        } catch (SQLException ex) {
            System.out.println("\n*** SQLException caught ***\n");
            while (ex != null) {
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("Vendor:   " + ex.getErrorCode());
                ex = ex.getNextException();
                System.out.println("Error Línea 71");
            }
        } catch (java.lang.Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static boolean checkForWarning(SQLWarning warn) throws SQLException {
        boolean rc = false;
        if (warn != null) {//no warnings
            System.out.println("\n *** Warning ***\n");
            rc = true;
            while (warn != null) {
                System.out.println("SQLState: " + warn.getSQLState());
                System.out.println("Message:  " + warn.getMessage());
                System.out.println("Vendor:   " + warn.getErrorCode());
                warn = warn.getNextWarning();
            }
        }
        return rc;
    }

    public void cerrarConexion() {
        try {
            //Cierra la conexion de la Base de Datos
            con.close();
            System.out.println("Cerrada la conexion con la Base de Datos");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion con la Base de datos. \n" + e);
        }
    }
    
    //codigo de conexión a postgreSQL
    
    public void iniciarSesion(String username, String password){
        
    }
    
    public void registrar(String username,String password){
        try {
            Statement statement = con.createStatement();
            String sql = "insert into jugador(\"username\",\"pwd\") values('"+username+"','"+password+"');";
            PreparedStatement st = con.prepareStatement(sql);
            st.executeUpdate();
            System.out.println("insercion exitosa");
        } catch (SQLException ex) {
            Logger.getLogger(Jugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.registrar("raul", "primo");   
    }
}
