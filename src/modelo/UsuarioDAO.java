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
import javax.swing.table.DefaultTableModel;
import static modelo.InicialDAO.conex;

public class UsuarioDAO {

    //Variable de Clase
    DefaultTableModel modelo = new DefaultTableModel();
    //Variables de conexion
    Conexion conectar = new Conexion();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
//-------------------------------
    //Constructor no hay
//------------------------------- 
    //Muestra todos los Usuario 

    public Vector<Usuario> listar() {
        Vector<Usuario> datos = new Vector<>();
        String sql = "select id,nombre,correo,url from usuario";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setCorreo(rs.getString(3));
                u.setUrl(rs.getString(4));
                datos.add(u);
            }

        } catch (Exception e) {
        }

        return datos;

    }

    public int agregar(Usuario u) {
        int r = 0;
        String sql = "insert into usuario (nombre,correo,url)values(?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getUrl());
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

    public int actualizar(Usuario u) {
        int r = 0;
        String sql = "update usuario set nombre=?, correo=?, url=? where id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            //-------------------------------------------------    
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getCorreo());
            ps.setString(3, u.getUrl());
            ps.setInt(4, u.getId());

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

    public int consultaCorreoElectronico(String Correo_e) {

        int r = 0;

        Usuario us = new Usuario();
        String valor = "'" + Correo_e + "'";

        String sql = "Select id,nombre_usuario,correo from usuario where correo='" + Correo_e + "'";//+ valor;

        try {

            con = conex.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 

                c++;
                r = 1;
                Usuario u = new Usuario();
                //u.setId(rs.getInt("id"));
                //u.setNombre_usuario(rs.getString("nombre_usuario"));
                //u.setCorreo(rs.getString("correo"));

                us = u;
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = 1;//Se coloca uno para Evitar qeu se guarde un registro sin aver recorrido antes la bd
        }

        return r;
    }

    public String contultaCorreoElectronicoDevuelveUsuario(String Correo_e) {
        String r = "";

        //Usuario us = new Usuario();
        String valor = "'" + Correo_e + "'";

        String sql = "Select id,nombre_usuario,correo from usuario where correo='" + Correo_e + "'";//+ valor;

        try {

            con = conex.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 

                c++;
                r = rs.getString("nombre_usuario");
                //Usuario u = new Usuario();
                //u.setId(rs.getInt("id"));
                //u.setNombre_usuario(rs.getString("nombre_usuario"));
                //u.setCorreo(rs.getString("correo"));

                //us = u;
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = "";//Se coloca uno para Evitar qeu se guarde un registro sin aver recorrido antes la bd
        }

        return r;
    }
    
    public String contultaCorreoElectronicoDevuelvePais(String Correo_e) {
        String r = "";

        //Usuario us = new Usuario();
        String valor = "'" + Correo_e + "'";

        String sql = "Select id,nombre_usuario,correo,pais from usuario where correo='" + Correo_e + "'";//+ valor;

        try {

            con = conex.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 

                c++;
                r = rs.getString("pais");
        
                //Usuario u = new Usuario();
                //u.setId(rs.getInt("id"));
                //u.setNombre_usuario(rs.getString("nombre_usuario"));
                //u.setCorreo(rs.getString("correo"));

                //us = u;
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = "";//Se coloca uno para Evitar qeu se guarde un registro sin aver recorrido antes la bd
        }

        return r;
    }
    
    public int consultaCorreoElectronicoDevuelveID(String Correo_e) {
        int r = 0;

        //Usuario us = new Usuario();
        String valor = "'" + Correo_e + "'";

        String sql = "Select id,nombre_usuario,correo from usuario where correo='" + Correo_e + "'";//+ valor;

        try {

            con = conex.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 

                c++;
                r = rs.getInt("id");
                //Usuario u = new Usuario();
                //u.setId(rs.getInt("id"));
                //u.setNombre_usuario(rs.getString("nombre_usuario"));
                //u.setCorreo(rs.getString("correo"));

                //us = u;
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = 0;//Se coloca uno para Evitar qeu se guarde un registro sin aver recorrido antes la bd
        }

        return r;
    }
    
    public int consultaNombreUsuario(String Nombre_u) {

        int r = 0;

        Usuario us = new Usuario();
        String valor = "'" + Nombre_u + "'";

        String sql = "Select id,nombre_usuario,correo from usuario where nombre_usuario='" + Nombre_u + "'";//+ valor;

        try {

            con = conex.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 

                c++;
                r = 1;
                Usuario u = new Usuario();
                //u.setId(rs.getInt("id"));
                //u.setNombre_usuario(rs.getString("nombre_usuario"));
                //u.setCorreo(rs.getString("correo"));

                us = u;
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = 1;//Se coloca uno para Evitar qeu se guarde un registro sin aver recorrido antes la bd
        }

        return r;
    }

    public int consultarPasswor(String Password) {
        int r = 0;
        Usuario us = new Usuario();
        String sql = "Select id,nombre_usuario,correo from usuario where clave='" + Password + "'";//+ valor;
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;
            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;
                r = 1;
                Usuario u = new Usuario();
                us = u;
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = 1;//Se coloca uno para Evitar qeu se guarde un registro sin aver recorrido antes la bd
        }
        return r;
    }

    public int consultarCorreoyPasswor(String Correo, String Password) {
        int r = 0;
        Usuario us = new Usuario();
        String sql = "Select id,nombre_usuario,correo from usuario where clave='" + Password + "' and correo='" + Correo + "'";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;
            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;
                r = 1;
                Usuario u = new Usuario();
                us = u;
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = 0;//Se coloca 0 para Evitar qeu Aceda un usuari sin aver recorrido antes la bd
        }
        return r;
    }
    
    public int contultaCorreoElectronicoDevuelveAdministrador(String Correo_e){
            int r = 4;

        //Usuario us = new Usuario();
        String valor = "'" + Correo_e + "'";

        String sql = "Select administrador from usuario where correo='" + Correo_e + "'";//+ valor;

        try {

            con = conex.getConnection();

            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 

                c++;
                r = rs.getInt("administrador");
        
                //Usuario u = new Usuario();
                //u.setId(rs.getInt("id"));
                //u.setNombre_usuario(rs.getString("nombre_usuario"));
                //u.setCorreo(rs.getString("correo"));

                //us = u;
     System.out.println("nivel de administrador es:"+rs.getString("administrador"));        
            }

        } catch (Exception e) {
            System.out.println("###Erro al Recorer la BD**" + e);
            r = 4;//Se coloca uno para Evitar qeu se guarde un registro sin aver recorrido antes la bd
        }

        return r;
    }
}
