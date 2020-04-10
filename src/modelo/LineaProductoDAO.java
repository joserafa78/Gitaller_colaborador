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

import conexionSql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vistas.VistaLineaProducto;
import java.util.Vector;
import static modelo.InicialDAO.conex;

public class LineaProductoDAO {

    //Variables de la Clase
    LineaProducto lp = null;//Objeto
    Fabricante f = null;
    VistaLineaProducto vlp = new VistaLineaProducto();
    //Conexion SQL
    static Conexion conectar = new Conexion();
    static PreparedStatement ps;
    static Connection con;
    static ResultSet rs;
//--------------------------------
    //SIN CONTRUCTOR
//--------------------------------

    //METODO MOSTRAR CON UN LIST los PRODUCTOS SEGUN EL ID FABRICANTE
    public Vector<LineaProducto> listar(int id) {
        Vector<LineaProducto> datos = new Vector<LineaProducto>();//Crea ArregloDinamico de Line Produc con Nomb Datos.
        String sql = "SELECT `id`, `nombre_linea`, `gama`, `fabricante_id` FROM `lineaproducto` "
                + "WHERE fabricante_id=" + id+" ORDER BY `nombre_linea` DESC";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta  
            //-----------Carga Elemento (0) ----------
            //lp = new LineaProducto();
            //lp.setId(0);
            // lp.setNombre("Linea Producto");
            //datos.add(lp);
            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                lp = new LineaProducto();//Se crea el objeto para que grade cada variabel
                lp.setId(rs.getInt("id"));
                lp.setNombre(rs.getString("nombre_linea"));
                lp.setGama(rs.getString("gama"));
                datos.add(lp);

            }
        } catch (Exception e) {
        }
        return datos;
    }

    public Vector<Fabricante> listarFabricante() {
        Vector<Fabricante> datos = new Vector<Fabricante>();//Crea ArregloDinamico de Line Produc con Nomb Datos.
        String sql = "SELECT id,nombre FROM fabricante";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
            //-----------Carga Elemento (0) ----------
            f = new Fabricante();
            f.setId(0);
            f.setNombre("FABRICANTE");
            datos.add(f);
            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                f = new Fabricante();//Se crea el objeto para que grade cada variabel
                f.setId(rs.getInt("id"));
                f.setNombre(rs.getString("nombre"));
                datos.add(f);
            }

        } catch (Exception e) {
        }
        return datos;
    }

    //Agraga un Registro en linea de Productos
    public int agregar(LineaProducto lp) {
        int r = 0;
        String sql = "INSERT INTO `lineaproducto`( nombre_linea, gama, fabricante_id) VALUES (?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, lp.getNombre());
            ps.setString(2, lp.getGama());
            ps.setInt(3, lp.getId_fabrica());
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

    //Actualiza un Registro de la linea de Produccion
    public int actualizar(LineaProducto lp) {
        int r = 0;

        String sql = "UPDATE `lineaproducto` SET `nombre_linea`=?,`gama`=? , `fabricante_id`=? WHERE id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, lp.getNombre());
            ps.setString(2, lp.getGama());
            ps.setInt(3, lp.getId_fabrica());
            ps.setInt(4, lp.getId());
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

    //Elimina un Registro de la lista de producto
    public int eliminar(int id) {
        int r = 0;
        //DELETE FROM `lineaproducto` WHERE 1
        String sql = "DELETE FROM `lineaproducto` WHERE Id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public LineaProducto buscaLinesProductoporNombre(String nomFab) {
        LineaProducto lp = new LineaProducto();
        String valor = "'" + nomFab + "'";
        String sql = "SELECT * FROM `lineaproducto` WHERE `nombre_linea`=" + valor;
        //SELECT `id`, `nombre_linea`, `gama`, `fabricante_id` FROM `lineaproducto` WHERE `nombre_linea`='G'
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta

            while (rs.next()) {     //Mietras halla filla hacer. 

                LineaProducto l = new LineaProducto();
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre_linea"));
                l.setGama(rs.getString("gama"));
                lp = l;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }

        return lp;

    }

    public LineaProducto buscaLinesProductoporID(int id) {
        LineaProducto lp = new LineaProducto();

        String sql = "SELECT * FROM `lineaproducto` WHERE `id`=" + id;

        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta

            while (rs.next()) {     //Mietras halla filla hacer. 

                LineaProducto l = new LineaProducto();
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre_linea"));
                l.setGama(rs.getString("gama"));
                lp = l;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }

        return lp;

    }

}
