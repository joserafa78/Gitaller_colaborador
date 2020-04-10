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
package modeloConsultas;

import conexionSql.Conexion;
import conexionSql.ConexionAccess;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import modelo.Fabricante;
import modelo.Usuario;

public class UsuarioRegistroDAO {
    //Variables de la Clase

    //Conexion SQL 
    static Conexion conectar = new Conexion();
    static ConexionAccess conectarA1 = new ConexionAccess();
    static PreparedStatement ps;
    static Connection con;
    static ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------  
    
    public UsuarioRegistroDAO() {
    }

    public int agregar(Usuario u) {
        int r = 0;
        String sql = "INSERT INTO usuario(nombre_usuario,nombre,apellido,correo,celular,"
                + "pais,departamento,ciudad,clave,administrador,estado) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, u.getNombre_usuario());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getApellido());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getCelular());

            // ps.setString(6, u.getUrl());
            ps.setString(6, u.getPais());
            ps.setString(7, u.getDepartamento());
            ps.setString(8, u.getCiudad()); 
            
            ps.setString(9, u.getClave());
            ps.setInt(10, u.getAdministrador());
            ps.setInt(11, u.getEstado());
            //ps.setInt(10, m.getFecha());

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

    public Vector<Usuario> listarUsuariosRegistradosAccess() {
        Vector<Usuario> datos = new Vector<>();
        String sql = "select * from Registro";
        try {

            con = conectarA1.getConnection();//OJO
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.

                Usuario u = new Usuario();
                u.setId(rs.getInt("id_usuario"));           
                u.setNombre_usuario(rs.getString("nombre_u"));
                u.setEstado(rs.getInt("estado"));
                u.setPais(rs.getString("pais"));
                datos.add(u);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    // String sql = "INSERT INTO usuario(nombre_u,estado,licencia) VALUES (?,?,?)"
    public int agregarAccess(Usuario u) {
        int r = 0;
        try {
            Connection con = null;
            ConexionAccess conect = new ConexionAccess();//Crea objeto de la Clase ConexionA Access.
            con = conect.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO Registro(id_usuario,nombre_u,estado,licencia,pais) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, u.getId());
            pst.setString(2, u.getNombre_usuario());
            pst.setInt(3, u.getEstado());
            pst.setString(4, u.getNombre_usuario());//OJO Licencia Agregada
            pst.setString(5, u.getPais());//OJO Licencia Agregada

            int n = pst.executeUpdate();
   
            if (n > 0) {
                r = 1;  //JOptionPane.showMessageDialog(null, "DATOS GUARDADOS CORRECTAMENTE");
            } else {  //limpiar();
                r = 01;
            }

        } catch (Exception e) {

        }

        return r;
    }
    
    public int actualizaEstdoUsuarioAccess(Usuario u){//"update Registro set  estado=?, pais=? where id_usuario=?";

            int r = 0;
            
            
        //String sql = "update Registro set  estado=?, pais=? where id_usuario=?";
        try {
              Connection con = null;
            ConexionAccess conect = new ConexionAccess();//Crea objeto de la Clase ConexionA Access.
            con = conect.getConnection();
            Statement st = con.createStatement();
            String sql =  "update Registro set  estado=?, pais=? where id_usuario=?";
            PreparedStatement pst = con.prepareStatement(sql);
            //-------------------------------------------------    
            pst.setInt(1, u.getEstado());
            pst.setString(2, u.getPais());
            //ps.setString(3, u.getUrl());
            pst.setInt(3, u.getId());
   //System.out.println("estado:"+u.getEstado()+"pais:"+u.getPais()+"id;"+u.getId());   
            r = pst.executeUpdate();
            //-------------------------------------------------    
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Erro en Base...("+e);
        }
        return r;
    }//Actualiza el Estado y el Pais.
    
}
