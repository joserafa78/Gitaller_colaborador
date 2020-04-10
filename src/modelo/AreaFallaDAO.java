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

public class AreaFallaDAO {

    //Variables de la Clase
    AreaFalla af = null;
    //Conexion SQL
    Conexion conectar = new Conexion();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------
    public int agregar(AreaFalla af) {

        int r = 0;
        String sql = "INSERT INTO area_falla(nombre,descripcion,tipo_falla_id) VALUES (?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, af.getNombre());
            ps.setString(2, af.getDescripcion());
            ps.setInt(3, af.getTipo_falla_id());

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

    //Metodo para Listar Las Areas de Fallas Segun los Tipos de Fallas
    public Vector<AreaFalla> listar(int id) {
        Vector<AreaFalla> datos = new Vector<AreaFalla>();//Crea ArregloDinamico de Lista Modelo con Nomb Datos.
        //SELECT * FROM `modelo` WHERE 1
        String sql = "SELECT * FROM `area_falla` WHERE tipo_falla_id=" + id + " ORDER BY `nombre` ASC";//DESC
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                af = new AreaFalla();//Se crea el objeto para que grade cada variabel

                af.setId(rs.getInt("id"));
                af.setNombre(rs.getString("nombre"));
                af.setDescripcion(rs.getString("descripcion"));
                af.setTipo_falla_id(rs.getInt("tipo_falla_id"));

                datos.add(af);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    //Actualiza un Registro del Area de Falla
    public int actualizar(AreaFalla af) {
        int r = 0;

        String sql = "UPDATE `area_falla` SET `nombre`=?,`descripcion`=?,`tipo_falla_id`=? WHERE id =?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            //--------------------------------------------------   
            ps.setString(1, af.getNombre());
            ps.setString(2, af.getDescripcion());
            ps.setInt(3, af.getTipo_falla_id());
            ps.setInt(4, af.getId());

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
