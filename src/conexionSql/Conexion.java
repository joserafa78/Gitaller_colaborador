package conexionSql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Conexion {

    Connection conect ;

    public Connection getConnection(){

    String url = "jdbc:mysql://cp9ezkp70hkd.sa-east-1.rds.amazonaws.com:3306/gitaller";
        String user = "root";
        String pass = "0000";
        //Connection conect = null;

        try {

            Class.forName("org.gjt.mm.mysql.Driver");//"com.mysql.jdbc.Driver"
            conect=DriverManager.getConnection(url,user,pass);
           // JOptionPane.showMessageDialog(null,"Conectado OK");

        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "!!Lo Siento, No se puede Conextar al Servidor.!!  " );//+ e
        }
        return conect;
    }
    
        public void Desconexion(){

            ConexionAccess ca=new ConexionAccess();
            ca.Desconexion();//Se desconecta de la Conexion local.
            System.exit(0);
    }
    
}
