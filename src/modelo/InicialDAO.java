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
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static modelo.FabricanteDAO.conectar;

public class InicialDAO {

    //VARIABLES DE LA CLASE
  static  PreparedStatement ps;
   static ResultSet rs;
   static Connection con;
   static Conexion conex = new Conexion();
    Fabricante f;

    public List listar() {//Esta Funcion--> Carga la Base Datos Fabricantes en una Lista "datos"
        List<Fabricante> datos = new ArrayList<>();
        String sql = "select id,nombre,historia,logo from fabricante where vigente=1 ORDER BY `nombre` ASC";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Fabricante f = new Fabricante();
                f.setId(rs.getInt(1));
                f.setNombre(rs.getString(2));
                datos.add(f);
          
            }

        } catch (Exception e) {
        }

        return datos;

    }

    public Fabricante buscaporFabricantePorNombre(String nomFab) {//Esta Funcion--> Carga la Base Datos Fabricantes en una Lista "datos"
        Fabricante fa = new Fabricante();
        String valor = "'" + nomFab + "'";
        String sql = "SELECT `id`,`nombre`,`historia` FROM `fabricante` WHERE `nombre`=" + valor;
     
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;
               
                Fabricante f = new Fabricante();

                f.setId(rs.getInt(1));
                f.setNombre(rs.getString(2));
                f.setHistoria(rs.getString(3));
            
                fa = f;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }
      
        return fa;

    }
    
    public Fabricante buscaporFabricantePorID(int id){
            Fabricante fa = new Fabricante();
        
        String sql = "SELECT `id`,`nombre`,`historia` FROM `fabricante` WHERE `id`=" + id;
     
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;
               
                Fabricante f = new Fabricante();

                f.setId(rs.getInt(1));
                f.setNombre(rs.getString(2));
                f.setHistoria(rs.getString(3));
            
                fa = f;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }
      
        return fa;
    
    }
    
    
    public static ImageIcon getlogo(int id) {
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
