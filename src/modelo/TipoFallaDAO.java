/*
SISTEMA "TODO TALLER "
Es Una Herramienta Informatica exclusiva para el Serviico Tecnio en Dispositivos Moviles
que reune informacion como: Documentacion de cada Dispositivo,
                            Documentacion de Aporte realizados por otros Tecnicos
                            Archivos .exe para dar solucion a cada Dispositivo
En General Todo Taller es un Enciclopedia Tecnica que Organiza toda la data de dispositivos Moviles
en una robusta base de datos ofresiendo al Taller Consultas especificas y Geneales a temas importantes.
------------------------------------------------------------------------------------------------------
Author  Jose rafael Jimenez Instagram: @joserafa78
------------------------------------------------------------------------------------------------------
 */
package modelo;

import conexionSql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class TipoFallaDAO {
    //Variables de la Clase

    //Conexion SQL
    Conexion conectar = new Conexion();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------  
    public int agregar(TipoFalla tf) {
        int r = 0;
        String sql = "INSERT INTO `tipo_falla`( `nombre`, `descripcion`) VALUES (?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            //ps.setInt(1, tf.getId() );
            ps.setString(1, tf.getNombre());
            ps.setString(2, tf.getDescripcion());

            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
     
        }
        return r;
    }
    //Muestra todos las tipo de fallas 
    public Vector<TipoFalla> listar() {
        Vector<TipoFalla> datos = new Vector<>(); 
        String sql = "select id,nombre,descripcion from Tipo_falla ORDER BY `nombre` DESC ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                TipoFalla tf = new TipoFalla();
                tf.setId(rs.getInt(1));
                tf.setNombre(rs.getString(2));
                tf.setDescripcion(rs.getString(3));
                datos.add(tf);
            }

        } catch (Exception e) {
        }

        return datos;

    }
    
        public int actualizar(TipoFalla tf) {
        int r = 0;

        String sql = "UPDATE `tipo_falla` SET `nombre`=?,`descripcion`=? WHERE id =?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            //--------------------------------------------------   
           
            ps.setString(1, tf.getNombre());
            ps.setString(2, tf.getDescripcion());
            ps.setInt(3, tf.getId());

            
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;

    }

}
