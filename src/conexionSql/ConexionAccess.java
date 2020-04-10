/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionSql;

//import java.net.MalformedURLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionAccess {
  Connection ccn = null;
Statement st = null;


    public ConexionAccess() //throws SQLException //URL url = new URL("jar:file:GiTaller.jar!/gitaller/baseDatos/Sistema_Registro.accd");
            {

          /* 
        //URL url = new URL("jar:file:GiTaller.jar!../gitaller/baseDatos/Sistema_Registro.accd");
                String rutafile =  "../gitaller/baseDatos/Sistema_Registro.accdb";
                String Url = "jdbc:ucanaccess://" + rutafile;
             try {   
                ccn =  DriverManager.getConnection (Url);
                st = ccn.createStatement();
            } catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, "Conexion Dañada Guey" + e);  
                }
        */
    }
    
    public Connection getConnection(){
        return ccn;
    }
    
    public void Desconexion(){
        try 
            {
                ccn.close();            
                //System.exit(0);
            } catch (SQLException ex) 
                {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
    }  
}
