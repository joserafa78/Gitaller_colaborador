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
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import static modelo.FabricanteDAO.con;
import modeloConsultas.TelefonoInformacion;

public class ContenidoDAO {
    //Variable de Clase

    ///Muestra las conexiones
    Conexion conectar = new Conexion();
    PreparedStatement ps;
    Connection con;
    ResultSet rs;
//-------------------------------
    //Constructor no hay
//------------------------------- 

    public int agregar(Contenido c) {
       
        int r = 0;
        String sql = "INSERT INTO contenido(`nombre`, `tipo_archivo`,`archivo`, `ubicacion`, `entidad`, `entidad_id`,"
                + "`aporte`, `aporte_id`,`area_falla`, `tipo_falla`,`id_falla`,"
                + "`usuario_id`,`fabricante_id`,`lineaproducto_id`,`modelo_id`,`Version_id`)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
//-----------------------------------------------------------  

//------------------------------------------------------------
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getTipo_archivo());
            ps.setBinaryStream(3, c.getArchivo());
            ps.setString(4, c.getUbicacion());
            ps.setInt(5, c.getEntidad());
            ps.setInt(6, c.getEntidad_id());
            ps.setInt(7, c.getAporte());
            ps.setInt(8, c.getAporte_id());
            
            ps.setInt(9, c.getArea_falla());
            ps.setInt(10, c.getTipo_falla());
            ps.setInt(11 , c.getId_falla() );
            ps.setInt(12, c.getUsuraio_id());
            //---------------------
            ps.setInt(13, c.getFabricante_id());
            ps.setInt(14, c.getLineaproducto_id());
            ps.setInt(15, c.getModelo_id());
            ps.setInt(16, c.getVersion_id());
            //-------------------------------------------------------------  

            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Algun Error!!!!");

        }
        return r;
    }
    //UPDATE `contenido` SET `nombre`=?,`tipo_archivo`=?,`archivo`=?,`ubicacion`=?,`entidad`=?,`entidad_id`=?,`aporte`=?,`aporte_id`=?,`area_falla`=?,`tipo_falla`=?,`usuario_id`=? WHERE `id`=?   

    public int actualizar(Contenido c) {
        int r = 0;
        String sql = "UPDATE `contenido` SET `nombre`=?,`tipo_archivo`=?,"
                + "`entidad`=?,`entidad_id`=?,`aporte`=?,`aporte_id`=?,`area_falla`=?,`tipo_falla`=?,"
                + "`usuario_id`=?,`fabricante_id`=?,`lineaproducto_id`=?,`modelo_id`=?,`version_id`=? WHERE `id`=? ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

//--------------------------------------------------------------
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getTipo_archivo());
            //ps.setBinaryStream(3, c.getArchivo());
            //ps.setString(4, c.getUbicacion());

            ps.setInt(3, c.getEntidad());
            ps.setInt(4, c.getEntidad_id());
            ps.setInt(5, c.getAporte());
            ps.setInt(6, c.getAporte_id());
            ps.setInt(7, c.getArea_falla());
            ps.setInt(8, c.getTipo_falla());

            ps.setInt(9, c.getUsuraio_id());
            //---------------------------
            ps.setInt(10, c.getFabricante_id());
            ps.setInt(11, c.getLineaproducto_id());
            ps.setInt(12, c.getModelo_id());
            ps.setInt(13, c.getVersion_id());
            //--------------------------- 
            ps.setInt(14, c.getId());
            //-------------------------------------------------------------  
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "Algun Error!!!!");

        }
        return r;

    }
//******************************************************************************************
            //METODOS OBSOLETOS YA FUERO USADOS PARA ACTUALIZAR LA TABLA CONTENIDO
    public int actualizaSoloIDs(TelefonoInformacion ti, int Contenido_id) {
        int r = 0;
        String sql = "UPDATE `contenido` SET `fabricante_id`=?,`lineaproducto_id`=?,`modelo_id`=?,`version_id`=? WHERE `id`=? ";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

//--------------------------------------------------------------
            ps.setInt(1, ti.getFabricante_id());
            ps.setInt(2, ti.getLineaproducto_id());
            ps.setInt(3, ti.getModelo_id());
            ps.setInt(4, ti.getVersion_id());
            ps.setInt(5, Contenido_id);

            //-------------------------------------------------------------  
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() + "--Algun Error!!!!");

        }
        return r;
    }
            //METODOS OBSOLETOS YA FUERO USADOS PARA ACTUALIZAR LA TABLA CONTENIDO
    public int buscaEntidadIDsegunID(int Id_Contenido) {//Metodo que devuelve el <<Entidad_id>>Segun el Id
        String sql = "select entidad_id from contenido where id=" + Id_Contenido;
        int resultado = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {  //Mietras halla filla hacer.  

                resultado = rs.getInt("entidad_id");

            }

        } catch (Exception e) {
        }

        return resultado;
    }
           //METODOS OBSOLETOS YA FUERO USADOS PARA ACTUALIZAR LA TABLA CONTENIDO   
    public Vector<Contenido> recorrelaTablayCargaLista(){
        Vector<Contenido> datos = new Vector<>();
             String sql = "select id,entidad,entidad_id from contenido ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {  //Mietras halla filla hacer.           
                Contenido c = new Contenido();
                c.setId(rs.getInt("id"));
                c.setEntidad(rs.getInt("entidad"));
                c.setEntidad_id(rs.getInt("entidad_id"));


                datos.add(c);

            }

        } catch (Exception e) {
        }

        return datos;   
    }
//******************************************************************************************
    public int eliminar(int id) {

        int r = 0;
        String sql = "delete from contenido where Id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public Vector<Contenido> BuscaContenidoPorIdyLista(int id) {

        Vector<Contenido> datos = new Vector<>();
        // HACE UNA LISTA DE LOS ULTIMOS 5 REGISTROS.
        String sql = "select * from contenido where id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {  //Mietras halla filla hacer.           
                Contenido c = new Contenido();
                c.setId(rs.getInt("id"));
                c.setTipo_archivo(rs.getInt("tipo_archivo"));
                c.setNombre(rs.getString("nombre"));
                c.setEntidad(rs.getInt("entidad"));
                c.setEntidad_id(rs.getInt("entidad_id"));
                c.setAporte(rs.getInt("aporte"));
                c.setAporte_id(rs.getInt("aporte_id"));
                c.setArea_falla(rs.getInt("area_falla"));
                c.setTipo_falla(rs.getInt("tipo_falla"));
                c.setUsuraio_id(rs.getInt("usuario_id"));
                //-------------------------
                c.setFabricante_id(rs.getInt("fabricante_id"));
                c.setLineaproducto_id(rs.getInt("lineaproducto_id"));
                c.setModelo_id(rs.getInt("modelo_id"));
                c.setVersion_id(rs.getInt("Version_id"));

                datos.add(c);

            }

        } catch (Exception e) {
        }

        return datos;
    }

    //Muestra todos los contenidos Agregados 
    public Vector<Contenido> listarTodo() {

        Vector<Contenido> datos = new Vector<>();
        // HACE UNA LISTA DE LOS ULTIMOS 5 REGISTROS.
        String sql = "select * from contenido ORDER BY `id` DESC LIMIT 5";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {  //Mietras halla filla hacer.           
                Contenido c = new Contenido();
                c.setId(rs.getInt("id"));
                c.setTipo_archivo(rs.getInt("tipo_archivo"));
                c.setNombre(rs.getString("nombre"));
                c.setEntidad(rs.getInt("entidad"));
                c.setEntidad_id(rs.getInt("entidad_id"));
                c.setAporte(rs.getInt("aporte"));
                c.setAporte_id(rs.getInt("aporte_id"));
                c.setArea_falla(rs.getInt("area_falla"));
                c.setTipo_falla(rs.getInt("tipo_falla"));
                c.setUsuraio_id(rs.getInt("usuario_id"));
                //-------------------------
                c.setFabricante_id(rs.getInt("fabricante_id"));
                c.setLineaproducto_id(rs.getInt("lineaproducto_id"));
                c.setModelo_id(rs.getInt("modelo_id"));
                c.setVersion_id(rs.getInt("Version_id"));

                datos.add(c);

            }

        } catch (Exception e) {
        }

        return datos;

    }

    public Vector<Contenido> MostrarContenidoAportePorModelo(int Id_Modelo, int Area_falla, int Tipo_falla) {
        Vector<Contenido> datos = new Vector<>();
        //Contenido: 3= M0delo
        //Aporte:  2=Aportes Fallas
        //entidad_id: Modelo Seleccionado
// "SELECT `id`,`tipo_archivo`,`nombre` FROM `contenido` WHERE (`entidad`=3 or `entidad`=4) and `aporte`=2  and `area_falla`=" + Area_falla + " and `tipo_falla`=" + Tipo_falla + " and `entidad_id`=" + Id_Modelo;
        //String sql = "SELECT `id`,`tipo_archivo`,`nombre` FROM `contenido` WHERE (`entidad`=3 or `entidad`=4) and `aporte`=2  and `area_falla`=" + Area_falla + " and `tipo_falla`=" + Tipo_falla + " and `entidad_id`=" + Id_Modelo;
String sql="select `id`,`tipo_archivo`,`nombre`\n" +
"from contenido\n" +
"where aporte= 2 and tipo_falla="+Tipo_falla+" and area_falla="+Area_falla+" and modelo_id="+Id_Modelo;
        //String sql = "SELECT * FROM `contenido` WHERE `entidad`=3 and `aporte`=2 and `entidad_id`="+Id_Modelo+"and `area_falla`="+Area_falla+"and `tipo_falla`="+Tipo_falla;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Contenido c = new Contenido();

                c.setId(rs.getInt("id"));
                c.setTipo_archivo(rs.getInt("tipo_archivo"));
                c.setNombre(rs.getString("nombre"));
                //c.setAporte(rs.getInt("aporte"));              
                //c.setArea_falla(rs.getInt("area_falla"));
                // c.setTipo_falla(rs.getInt("tipo_falla"));               
                //c.setUsuraio_id(rs.getInt("usuario_id"));
                
                datos.add(c);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public Vector<Contenido> MostrarContenidoDocumentacionPorModelo(int Id_Modelo) {
        Vector<Contenido> datos = new Vector<>();
        //Contenido: 3= M0delo
        //Aporte:  2=Aportes Fallas
        //entidad_id: Modelo Seleccionado

        String sql = "SELECT `id`,`tipo_archivo`,`nombre` FROM `contenido` WHERE `entidad`=3 and `aporte`=1  and `area_falla`=0 and `tipo_falla`=0 and `entidad_id`=" + Id_Modelo;

        //String sql = "SELECT * FROM `contenido` WHERE `entidad`=3 and `aporte`=2 and `entidad_id`="+Id_Modelo+"and `area_falla`="+Area_falla+"and `tipo_falla`="+Tipo_falla;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Contenido c = new Contenido();

                c.setId(rs.getInt("id"));
                c.setTipo_archivo(rs.getInt("tipo_archivo"));
                c.setNombre(rs.getString("nombre"));
                //c.setAporte(rs.getInt("aporte"));              
                //c.setArea_falla(rs.getInt("area_falla"));
                // c.setTipo_falla(rs.getInt("tipo_falla"));               
                //c.setUsuraio_id(rs.getInt("usuario_id"));

                datos.add(c);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public Vector<Contenido> MostrarContenidoDocumentacionPorFabricante(int Id_Fabrica) {
        Vector<Contenido> datos = new Vector<>();
        //Contenido: 3= M0delo
        //Aporte:  2=Aportes Fallas
        //entidad_id: Modelo Seleccionado

        String sql = "SELECT `id`,`tipo_archivo`,`nombre` FROM `contenido` WHERE `entidad`=1 and `aporte`=1  and `area_falla`=0 and `tipo_falla`=0 and `entidad_id`=" + Id_Fabrica;

        //String sql = "SELECT * FROM `contenido` WHERE `entidad`=3 and `aporte`=2 and `entidad_id`="+Id_Modelo+"and `area_falla`="+Area_falla+"and `tipo_falla`="+Tipo_falla;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Contenido c = new Contenido();

                c.setId(rs.getInt("id"));
                c.setTipo_archivo(rs.getInt("tipo_archivo"));
                c.setNombre(rs.getString("nombre"));
                //c.setAporte(rs.getInt("aporte"));              
                //c.setArea_falla(rs.getInt("area_falla"));
                // c.setTipo_falla(rs.getInt("tipo_falla"));               
                //c.setUsuraio_id(rs.getInt("usuario_id"));

                datos.add(c);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public Vector<Contenido> MostrarContenidoDocumentacionPorVersion(int Id_Modelo) {
        Vector<Contenido> datos = new Vector<>();
        //Contenido: 3= M0delo
        //Aporte:  2=Aportes Fallas
        //entidad_id: Modelo Seleccionado

        String sql = "SELECT `id`,`tipo_archivo`,`nombre` FROM `contenido` WHERE `entidad`=4 and `aporte`=1  and `area_falla`=0 and `tipo_falla`=0 and `entidad_id`=" + Id_Modelo;

        //String sql = "SELECT * FROM `contenido` WHERE `entidad`=3 and `aporte`=2 and `entidad_id`="+Id_Modelo+"and `area_falla`="+Area_falla+"and `tipo_falla`="+Tipo_falla;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Contenido c = new Contenido();

                c.setId(rs.getInt("id"));
                c.setTipo_archivo(rs.getInt("tipo_archivo"));
                c.setNombre(rs.getString("nombre"));
                //c.setAporte(rs.getInt("aporte"));              
                //c.setArea_falla(rs.getInt("area_falla"));
                // c.setTipo_falla(rs.getInt("tipo_falla"));               
                //c.setUsuraio_id(rs.getInt("usuario_id"));

                datos.add(c);
            }

        } catch (Exception e) {
        }

        return datos;
    }

    public void ejecutarArchivoPdf(int id) {
        byte[] b = null;
        System.out.println("Encontro el id del contenido:"+id);
        String sql = "select archivo from contenido where id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta

            while (rs.next()) {  //Mietras halla filla hacer. 
System.out.println("Cargo el binario en variable b-");//getBytes(1);
                b = rs.getBytes(1) ;

            }

            InputStream bos = new ByteArrayInputStream(b);
            System.out.println("Carga variable Dos:");
            int tamanoInput = bos.available();
            System.out.println("Tamaño de Archivo en Variable:"+tamanoInput);
            byte[] datosPDF = new byte[tamanoInput];
            System.out.println("Crea Vector de byte");
            bos.read(datosPDF, 0, tamanoInput);
            System.out.println("Lee la Variable dos.");
            String nomb_archivo = String.valueOf(id) + ".pdf";//Nombre del Archivo que Aparece arriba
            System.out.println("Captura nombre de archivo:"+nomb_archivo);
            OutputStream out = new FileOutputStream(nomb_archivo);//"new.pdf"
            System.out.println("Crea objeto FileOutputStream.");
            out.write(datosPDF);
            System.out.println("Mando a Abrir el Archivo con el metodo Write");

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            System.out.println("Cierra todos los metodos.-out,bos,ps,rs.");
        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "!!Error al abrir archivo!!" );//
        }
    }

}
