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

import java.sql.Connection;
import conexionSql.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Fabricante;
import modelo.InicialDAO;
import vistas.VistaFabricante;
import vistas.VistaPrincipal;

public class FabricanteDAO {

    //Variable de Clase
    Fabricante f = new Fabricante();
    InicialDAO dao = new InicialDAO();
    VistaFabricante vf = new VistaFabricante();
    ///DefaultTableModel modelo = new DefaultTableModel();
   static Conexion conectar = new Conexion();
   static PreparedStatement ps;
   static Connection con;
    static ResultSet rs;
//-------------------------------
    //Constructor no hay
//-------------------------------    

//Muestra todos los Farbircantes  
    public Vector<Fabricante> listar() {
        Vector<Fabricante> datos = new Vector<>();
        String sql = "select id,nombre,historia,logo from fabricante where vigente=1 ORDER BY `nombre` ASC";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Fabricante f = new Fabricante();
                f.setId(rs.getInt(1));
                f.setNombre(rs.getString(2));
                f.setHistoria(rs.getString(3));
               // f.setLogo(rs.getString(4)); No se coloca porque tiene su  propio metodo Getlogo
                datos.add(f);
            }

        } catch (Exception e) {
        
        }

        return datos;
        
    }

    public int agregar(Fabricante f) {
        int r = 0;
        String sql = "insert into fabricante(nombre,historia,logo)values(?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, f.getNombre());
             ps.setString(2, f.getHistoria());
            ps.setBinaryStream(3, f.getLogo());

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

    public int actualizar(Fabricante f) {
        int r = 0;
        String sql = "update fabricante set nombre=? ,historia=?,logo=? where id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
        //-------------------------------------------------    
            ps.setString(1, f.getNombre());
            ps.setString(2, f.getHistoria());
            ps.setBlob(3, f.getLogo());
            ps.setInt(4, f.getId());
            r = ps.executeUpdate();
        //-------------------------------------------------    
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;

    }

    public int eliminar(int id) {

        int r = 0;
        String sql = "delete from fabricante where Id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public static ImageIcon getFoto(int id) {
        String sql = "select `logo` from `fabricante` where id=" + id;
         ImageIcon ii = null;
        InputStream is = null;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
         if(rs.next()){   
 
                  is = rs.getBinaryStream(1);
                   BufferedImage bi = ImageIO.read(is);
                   ii = new ImageIcon(bi);
        
        }
        } catch (Exception e) {
        }

        return ii;
    }

}
