
package modelo;

import conexionSql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class FallaDAO {
    //Variables de la Clase
   Falla f= null;
   
   
    //Conexion SQL
    Conexion conectar = new Conexion();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------
    
        //Metodo para Listar Las  Fallas Segun las Areas de Fallas
    public Vector<Falla> listar(int id) {
        Vector<Falla> datos = new Vector<Falla>();//Crea ArregloDinamico de Fallas 

        String sql = "SELECT * FROM `falla` WHERE area_falla_id=" + id+" ORDER BY `nombre` ASC";//DESC
        try {
     
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                f = new Falla();//Se crea el objeto para que grade cada variabel

                f.setId(rs.getInt("id"));
  		f.setCodigo(rs.getString("codigo"));
                f.setNombre(rs.getString("nombre"));
                f.setDescripcion(rs.getString("descripcion"));
                f.setAplica_a(rs.getInt("aplica_a"));
                f.setArea_falla_id(rs.getInt("area_falla_id"));
		
                datos.add(f);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    
    public int agregar(Falla f) {
        int r = 0;
        String sql = "INSERT INTO falla(codigo,nombre,descripcion,aplica_a,area_falla_id) VALUES (?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

	    ps.setString(1, f.getCodigo());
            ps.setString(2, f.getNombre());
            ps.setString(3, f.getDescripcion());
            ps.setInt(4, f.getAplica_a());
            ps.setInt(5, f.getArea_falla_id());
	    

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
    
        public int actualizar(Falla f) {
        int r = 0;
        String sql = "update falla set codigo=?, nombre=?,descripcion=?,aplica_a=?, area_falla_id=? where id=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
        //-------------------------------------------------    
            	ps.setString(1, f.getCodigo());
		ps.setString(2, f.getNombre());
		ps.setString(3, f.getDescripcion());
                ps.setInt(4, f.getAplica_a());
           	ps.setInt(5, f.getArea_falla_id());
		ps.setInt(6, f.getId());
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
}
