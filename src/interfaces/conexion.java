package interfaces;
import java.sql.*;
import javax.swing.JOptionPane;
public class conexion {
    Connection connect = null;
    public boolean conectado = false;
    public Connection conectar() {
        try {
           //    String basedatos="jdbc:oracle:thin:@192.168.1.18:1521:XE";
           //   connect = DriverManager.getConnection(basedatos, "proyecto", "12345");
            
             String basedatos="jdbc:oracle:thin:@localhost:1521:XE";
            connect = DriverManager.getConnection(basedatos, "proyecto", "p12345");

            conectado = true;
                System.out.println(conectado);

        } catch (Exception e) {
            conectado = false;
            JOptionPane.showMessageDialog(null, e+"conexion fallida");
        }
        System.out.println(conectado);
        return connect;
    }
    public static void main(String[] args) {
       conexion cc=new conexion();
        Connection cn=cc.conectar();
        System.out.println(new conexion().conectar());
    }
}
