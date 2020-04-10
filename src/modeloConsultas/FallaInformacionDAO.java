/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloConsultas;

import conexionSql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class FallaInformacionDAO {
    
        //Conexion SQL
   static Conexion conectar = new Conexion();
   static PreparedStatement ps;
   static Connection con;
   static ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------
    
    
    
public static   String   informaiconFallaPorArea (int area_id){
String valor="";
 String tipo1="";
String area1="";
    String sql= "select  af.nombre,tf.nombre \n" 
                +"from  area_falla as af, tipo_falla as tf \n"
                +"where (af.tipo_falla_id=tf.id) and af.id="+ area_id;
try {  
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                String tipo;
		String area;

                tipo=(rs.getString("tf.nombre"));
                area=(rs.getString("af.nombre"));
               tipo1=tipo;
               area1=area;
            }
        } catch (Exception e) {
        }
        valor=tipo1+" > "+area1+" > ";

    
    
    
    
return valor;
}
    
    
    
    
    
    
}
