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
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PublicidadDAO {
    //Variables de la Clase
    
    
  
    
    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------
    
     //Conexion SQL
   static Conexion conectar = new Conexion();
   static PreparedStatement ps;
   static Connection con;
   static ResultSet rs;   
    
  //--------------------------------   
  
    public int agregar(Publicidad p) {
        int r = 0;
String sql = "INSERT INTO publicidad(titulo,imagen_uno,telefono,url,duracion,tiempo,pais,vigente,forma_pago,cod_pago,usuario_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, p.getTitulo());
            ps.setBinaryStream(2, p.getImagen_uno());   
            ps.setString(3, p.getTelefono());
            ps.setString(4, p.getUrl());
            ps.setInt(5,p.getDuracion());
            ps.setInt(6, p.getTiempo());
            ps.setString(7, p.getPais());
            ps.setInt(8, p.getVigente());
             ps.setString(9, p.getForma_pago());  
            ps.setString(10, p.getCod_pago());
            ps.setInt(11, p.getUsuario_id());
            

            
            
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println("Menaje de Erro Base de Datos."+e);
        }
        return r;
    }  
    //Lista las publicaciones por Usuario
    public Vector<Publicidad> listar(int id) {
        Vector<Publicidad> datos = new Vector<Publicidad>();//Crea ArregloDinamico de Lista Modelo con Nomb Datos.

        String sql = "SELECT `id`, `titulo`,`telefono`,`url`, `duracion`, `tiempo`, `pais`, `vigente`,"
                + " `cod_pago` ,`fecha` FROM `publicidad` WHERE usuario_id="+ id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
            //-----------Carga Elemento (0) ----------


            while (rs.next()) { //Mietras halla filla ha,cer. 

               Publicidad p = new Publicidad();//Se crea el objeto para que grade cada variabel
                         
			p.setId(rs.getInt("id")); 
                        p.setTitulo(rs.getString("titulo"));
			//p.setImagen_uno() 
			//p.setImagen_dos(rs.getString("nombre")) ;
			p.setTelefono(rs.getString("telefono")); 
			p.setUrl(rs.getString("url")); 
			p.setDuracion(rs.getInt("duracion")) ;
			p.setTiempo(rs.getInt("tiempo")) ;
			p.setPais(rs.getString("pais")) ;
			p.setVigente(rs.getInt("vigente")) ;
			p.setCod_pago(rs.getString("cod_pago")) ;
			p.setFecha( rs.getString("fecha")) ;
			//p.getUsuario_id(rs.getInt("id")) ;


                datos.add(p);

            }
        } catch (Exception e) {
            System.out.println("Error base de datos.."+e);
        }
        return datos;
    }
    
     //Lirtar Publicacione por Pais que esten Vigente
    public Vector<Publicidad> listarPorPaisVigente(String Pais) {
        Vector<Publicidad> datos = new Vector<Publicidad>();//Crea ArregloDinamico de Lista Modelo con Nomb Datos.

        String sql = "SELECT `id`, `titulo`, `telefono`, `url`,`vigente` FROM `publicidad` WHERE `vigente`=1 and `pais`= '"+Pais+"'" ;//+ id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
            //-----------Carga Elemento (0) ----------


            while (rs.next()) { //Mietras halla filla ha,cer. 

               Publicidad p = new Publicidad();//Se crea el objeto para que grade cada variabel
                         
			p.setId(rs.getInt("id")); 
                        p.setTitulo(rs.getString("titulo"));
			//p.setImagen_uno() 
			//p.setImagen_dos(rs.getString("nombre")) ;
			p.setTelefono(rs.getString("telefono")); 
			p.setUrl(rs.getString("url")); 
			//p.setDuracion(rs.getInt("duracion")) ;
			//p.setTiempo(rs.getInt("tiempo")) ;
			//p.setPais(rs.getString("pais")) ;
			//p.setVigente(rs.getInt("vigente")) ;
			//p.setCod_pago(rs.getString("cod_pago")) ;
			//p.setFecha( rs.getString("fecha")) ;
			//p.getUsuario_id(rs.getInt("id")) ;

                datos.add(p);

            }
        } catch (Exception e) {
            System.out.println("Error base de datos..@@@@-"+e);
        }
        return datos;
    }
    
    public static String muestraLingWeb(int id){
     //Publicidad p1= new Publicidad();
     String p1="";

        String sql = "SELECT `telefono`,`url` FROM `publicidad` WHERE usuario_id="+ id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
            //-----------Carga Elemento (0) ----------


            while (rs.next()) { //Mietras halla filla ha,cer. 

               Publicidad p = new Publicidad();//Se crea el objeto para que grade cada variabel
                         
			//p.setId(rs.getInt("id")); 
                        //p.setTitulo(rs.getString("titulo"));
			//p.setImagen_uno() 
			//p.setImagen_dos(rs.getString("nombre")) ;
			p.setTelefono(rs.getString("telefono")); 
			p.setUrl(rs.getString("url")); 
			//p.setDuracion(rs.getInt("duracion")) ;
			//p.setTiempo(rs.getInt("tiempo")) ;
			//p.setPais(rs.getString("pais")) ;
			//p.setVigente(rs.getInt("vigente")) ;
			//p.setCod_pago(rs.getString("cod_pago")) ;
			//p.setFecha( rs.getString("fecha")) ;
			//p.getUsuario_id(rs.getInt("id")) ;


                p1=rs.getString("telefono");

            }
        } catch (Exception e) {
            System.out.println("Error base de datos.."+e);
        }
        return p1;
    }
    
    public static ImageIcon getImagenmini(int id) {
        String sql = "select `imagen_uno` from `publicidad` where id=" + id;
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
