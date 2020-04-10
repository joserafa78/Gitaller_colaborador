package modeloConsultas;

import conexionSql.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TelefonoInformaiconDAO {
    //Variables de la Clase

   static TelefonoInformacion ti = new TelefonoInformacion();

    //Conexion SQL
   static Conexion conectar = new Conexion();
   static PreparedStatement ps;
   static Connection con;
   static ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------
    
    
    //METODOS OBSOLETOS YA FUERO USADOS PARA ACTUALIZAR LA TABLA CONTENIDO 
//****************************************************************************************************   
    //Metodo para Buscar IDVERSION,IDMODELO,IDLINEA,IDFABRICANTE de todos los Modelos de Telefono Segun la <<ID Version>>
    public TelefonoInformacion buscaIDTelefonosSegunIDVersion(int version_id) {

        String sql = "Select v.id ,m.id,lp.id ,f.id  \n"
                + "from \n"
                + "version as v,modelo as m,lineaproducto as lp,fabricante as f \n"
                + "where\n"
                + "(m.id=v.modelo_id)and(m.lineaProducto_id=lp.id)and(lp.fabricante_id=f.id)and v.id =" + version_id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                ti = new TelefonoInformacion();//Se crea el objeto para que grade cada variabel

                ti.setVersion_id(rs.getInt("v.id"));
                ti.setModelo_id(rs.getInt("m.id"));
                ti.setLineaproducto_id(rs.getInt("lp.id"));
                ti.setFabricante_id(rs.getInt("f.id"));

            }
        } catch (Exception e) {
        }
        return ti;
    }

    public TelefonoInformacion buscaIDTelefonosSegunIDModelo(int modelo_id) {

        String sql = "Select m.id,lp.id ,f.id  \n"
                + "from \n"
                + "modelo as m,lineaproducto as lp,fabricante as f \n"
                + "where\n"
                + "(m.lineaProducto_id=lp.id)and(lp.fabricante_id=f.id)and m.id =" + modelo_id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                ti = new TelefonoInformacion();//Se crea el objeto para que grade cada variabel

                ti.setVersion_id(0);
                ti.setModelo_id(rs.getInt("m.id"));
                ti.setLineaproducto_id(rs.getInt("lp.id"));
                ti.setFabricante_id(rs.getInt("f.id"));

            }
        } catch (Exception e) {
        }
        return ti;
    }

    public TelefonoInformacion buscaIDTelefonosSegunIDLineProducto(int lineaProducto_id) {

        String sql = "Select lp.id ,f.id  \n"
                + "from \n"
                + "lineaproducto as lp,fabricante as f \n"
                + "where\n"
                + "(lp.fabricante_id=f.id)and lp.id =" + lineaProducto_id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                ti = new TelefonoInformacion();//Se crea el objeto para que grade cada variabel

                ti.setVersion_id(0);
                ti.setModelo_id(0);
                ti.setLineaproducto_id(rs.getInt("lp.id"));
                ti.setFabricante_id(rs.getInt("f.id"));

            }
        } catch (Exception e) {
        }
        return ti;
    }

    public TelefonoInformacion buscaIDTelefonosSegunIDFabricante(int Fabricante_id) {

        String sql = "Select f.id  \n"
                + "from \n"
                + "fabricante as f \n"
                + "where\n"
                + " f.id =" + Fabricante_id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                ti = new TelefonoInformacion();//Se crea el objeto para que grade cada variabel

                ti.setVersion_id(0);
                ti.setModelo_id(0);
                ti.setLineaproducto_id(0);
                ti.setFabricante_id(rs.getInt("f.id"));

            }
        } catch (Exception e) {
        }
        return ti;
    }
//****************************************************************************************************
     public static String IformacionTelefonosSegunIDVersion(int version_id) {
      String valor="";
        String sql = "Select f.nombre,lp.nombre_linea,m.nombre_oficial,v.version \n"
                + "from \n"
                + "version as v,modelo as m,lineaproducto as lp,fabricante as f \n"
                + "where\n"
                + "(m.id=v.modelo_id)and(m.lineaProducto_id=lp.id)and(lp.fabricante_id=f.id)and v.id =" + version_id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                TelefonoInformacion ti1 = new TelefonoInformacion();//Se crea el objeto para que grade cada variabel

                ti1.setVersion(rs.getString("v.version"));
                ti1.setModelo(rs.getString("m.nombre_oficial"));
                ti1.setLineaproducto(rs.getString("lp.nombre_linea"));
                ti1.setFabricante(rs.getString("f.nombre"));
                ti=ti1;
            }
        } catch (Exception e) {
        }
        valor=ti.getFabricante()+" > "+ti.getLineaproducto()+" > "+ti.getModelo()+" > "+ti.getVersion();
        return valor;
    }
     
    public static String IformacionTelefonosSegunIDModelo(int modelo_id) {
      String valor="";
        String sql = "Select f.nombre,lp.nombre_linea,m.nombre_oficial \n"
                + "from \n"
                + "modelo as m,lineaproducto as lp,fabricante as f \n"
                + "where\n"
                + "(m.lineaProducto_id=lp.id)and(lp.fabricante_id=f.id)and m.id =" + modelo_id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                TelefonoInformacion ti1 = new TelefonoInformacion();//Se crea el objeto para que grade cada variabel

                //ti1.setVersion(rs.getString("v.version"));
                ti1.setModelo(rs.getString("m.nombre_oficial"));
                ti1.setLineaproducto(rs.getString("lp.nombre_linea"));
                ti1.setFabricante(rs.getString("f.nombre"));
                ti=ti1;
            }
        } catch (Exception e) {
        }
        valor=ti.getFabricante()+" > "+ti.getLineaproducto()+" > "+ti.getModelo();
        return valor;
    }
    
}
