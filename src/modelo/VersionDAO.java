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
import static modelo.InicialDAO.conex;

public class VersionDAO {
    //Variables de la Clase

    Version v = null;

    //Conexion SQL
    Conexion conectar = new Conexion();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------
    //Metodo para Listar Las Versiones Segun los Moelelos
    public Vector<Version> listar(int id) {
        Vector<Version> datos = new Vector<Version>();//Crea ArregloDinamico de Lista Modelo con Nomb Datos.

        String sql = "SELECT `id`, `version`,`nombre`, `capacidad`, `esdualsim`, `modelo_id` FROM `version` WHERE modelo_id=" + id;
        try { 
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
            //-----------Carga Elemento (0) ----------
            /* v = new Version();//Se crea el objeto para que grade cada variabel
            v.setId(0);
            v.setVersion("Version");
            v.setCapacidad(0);
            v.setEsDualSim(0);
            v.setModelo_id(1);
            datos.add(v);*/
            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 

                v = new Version();//Se crea el objeto para que grade cada variabel
                v.setId(rs.getInt("id"));
                v.setVersion(rs.getString("version"));
                v.setNombre(rs.getString("nombre"));
                v.setCapacidad(rs.getInt("capacidad"));
                v.setEsDualSim(rs.getInt("esdualsim"));
                v.setModelo_id(rs.getInt("modelo_id"));
                datos.add(v);

            }
        } catch (Exception e) {
        }
        return datos;
    }

    //Metodo para Agragar registros a la tabla Version
    public Version buscaporVersionporIdModelo(int id) {//Esta Funcion--> Carga la Base Datos VersionesES Segun  ID DE Modelo
        Version ve = new Version();

        String sql = "SELECT * FROM `version` WHERE `modelo_id`=" + id+"ORDER BY `version` ASC";

        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;

                Version v = new Version();
                v.setId(rs.getInt("id"));
                v.setVersion(rs.getString("version"));
                v.setCapacidad(rs.getInt("capacidad"));
                v.setEsDualSim(rs.getInt("esdualsim"));
                v.setModelo_id(rs.getInt("modelo_id"));

                ve = v;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }

        return ve;

    }
    
    public Version buscaporIDVersionMuestraDatos(int id_Versio){
            Version ve = new Version();

        String sql = "SELECT id,version,nombre,capacidad FROM `version` WHERE `id`=" + id_Versio+" ORDER BY `version` DESC";

        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;

                Version v = new Version();
                v.setId(rs.getInt("id"));
                v.setVersion(rs.getString("version"));
                 v.setNombre(rs.getString("nombre"));
                 v.setCapacidad(rs.getInt("capacidad"));
                ve = v;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }

        return ve;
    }

    public int agregar(Version v) {
        int r = 0;
        String sql = "INSERT INTO `version`( `version`,`nombre`, `capacidad`, `esdualsim`, `modelo_id`) VALUES (?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getVersion());
            ps.setString(2, v.getNombre());
            ps.setInt(3, v.getCapacidad());
            ps.setInt(4, v.getEsDualSim());
            ps.setInt(5, v.getModelo_id());

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
    
    public int actualizar(Version v){
            int r = 0;
        String sql = "UPDATE `version` SET `version`=?,`nombre`=?,`capacidad`=?,`esdualsim`=? WHERE `id`=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, v.getVersion());
            ps.setString(2, v.getNombre());
            ps.setInt(3, v.getCapacidad());
            ps.setInt(4, v.getEsDualSim());
            ps.setInt(5, v.getId());

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
