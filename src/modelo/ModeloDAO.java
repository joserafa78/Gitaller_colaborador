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

public class ModeloDAO {

    //Variables de la Clase
    Modelo m = null;

    //Conexion SQL
   static Conexion conectar = new Conexion();
   static PreparedStatement ps;
   static Connection con;
   static ResultSet rs;

    //--------------------------------
    //SIN CONTRUCTOR
    //--------------------------------
    //Metodo para Listar Los Modelos Segun la Linea de Productos
    public Vector<Modelo> listar(int id) {
        Vector<Modelo> datos = new Vector<Modelo>();//Crea ArregloDinamico de Lista Modelo con Nomb Datos.
        //SELECT * FROM `modelo` WHERE 1
        String sql = "SELECT * FROM `modelo` WHERE lineaProducto_id=" + id+" ORDER BY `nombre_comercial` DESC";
        try {
        
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
            //-----------Carga Elemento (0) ----------
           // m = new Modelo();//Se crea el objeto para que grade cada variabel
           // m.setId(0);
          //  m.setNombre_comercial("Modelo");
           // datos.add(m);
            //-----------------------------------------
            while (rs.next()) { //Mietras halla filla hacer. 
                m = new Modelo();//Se crea el objeto para que grade cada variabel
                m.setId(rs.getInt("id"));
                m.setNombreOficial(rs.getString("nombre_oficial"));
                m.setNombre_comercial(rs.getString("nombre_comercial"));
                m.setAnioLanza(rs.getInt("anio_lanza"));
                m.setEsPlus(rs.getInt("esplus"));
                m.setId_lineaProducto(rs.getInt("lineaProducto_id"));
                datos.add(m);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    //Agraga un Registro en Modelo

    public int muestraUltimoRegistroModelo() {
        //SELECT idurl from enlaces ORDER BY idurl DESC LIMIT 1;   
        String sql = "SELECT `id`, `nombre_oficial`, `nombre_comercial`, `anio_lanza`, `esplus`, `lineaProducto_id` FROM modelo ORDER BY `id` DESC LIMIT 1";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 

            while (rs.next()) { //Mietras halla filla hacer. 
                m = new Modelo();//Se crea el objeto para que grade cada variabel
                m.setId(rs.getInt("id"));
                m.setNombreOficial(rs.getString("nombre_oficial"));
                m.setNombre_comercial(rs.getString("nombre_comercial"));
                m.setAnioLanza(rs.getInt("anio_lanza"));
                m.setEsPlus(rs.getInt("esplus"));
                m.setId_lineaProducto(rs.getInt("lineaProducto_id"));

            }
        } catch (Exception e) {
        }

        return m.getId();
    }

    public int agregar(Modelo m) {
        int r = 0;
        String sql = "INSERT INTO modelo(nombre_oficial,nombre_comercial,anio_lanza,esplus,lineaProducto_id) VALUES (?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, m.getNombreOficial());
            ps.setString(2, m.getNombre_comercial());
            ps.setInt(3, m.getAnioLanza());
            ps.setInt(4, m.getEsPlus());
            ps.setInt(5, m.getId_lineaProducto());

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

    //Actualiza un Registro de la linea de Modelo
    public int actualizar(Modelo m) {
        int r = 0;
//esplus =?,
        String sql = "UPDATE `modelo` SET `nombre_oficial`=?,`nombre_comercial`=?,`anio_lanza`=?,`esplus`=?,`lineaProducto_id`=? WHERE id =?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            //--------------------------------------------------   
            ps.setString(1, m.getNombreOficial());
            ps.setString(2, m.getNombre_comercial());
            ps.setInt(3, m.getAnioLanza());
            ps.setInt(4, m.getEsPlus());
            ps.setInt(5, m.getId_lineaProducto());
            ps.setInt(6, m.getId());

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

    public int eliminar(int id) {
        int r = 0;
        //DELETE FROM `lineaproducto` WHERE 1
        String sql = "DELETE FROM `modelo` WHERE Id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
        
    public Modelo buscaporModeloPorNombre(String nomFab) {//Esta Funcion--> Carga la Base Datos Fabricantes en una Lista "datos"
        Modelo mo = new Modelo();
        String valor = "'" + nomFab + "'";
        String sql = "SELECT * FROM `modelo` WHERE 'nombre_comercial'=" + valor;
    

        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;
               
                Modelo m = new Modelo();
                m.setId(rs.getInt("id"));
                m.setNombreOficial(rs.getString("nombre_oficial"));
                m.setNombre_comercial(rs.getString("nombre_comercial"));
                m.setAnioLanza(rs.getInt("anio_lanza"));
                m.setEsPlus(rs.getInt("esplus"));
                m.setId_lineaProducto(rs.getInt("lineaProducto_id"));
            
                mo = m;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }
      
        return mo;

    }
    
    public Modelo buscaporModeloporID(int id){
            Modelo mo = new Modelo();
       
        String sql = "SELECT * FROM `modelo` WHERE `id`=" + id;
    

        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();//Ejecuta la Consulta
            int c = 0;

            while (rs.next()) {     //Mietras halla filla hacer. 
                c++;
               
                Modelo m = new Modelo();
                m.setId(rs.getInt("id"));
                m.setNombreOficial(rs.getString("nombre_oficial"));
                m.setNombre_comercial(rs.getString("nombre_comercial"));
                m.setAnioLanza(rs.getInt("anio_lanza"));
                m.setEsPlus(rs.getInt("esplus"));
                m.setId_lineaProducto(rs.getInt("lineaProducto_id"));
            
                mo = m;
            }

        } catch (Exception e) {
            System.out.println("Erro al Recorer la BD**" + e);
        }
      
        return mo;
    }

}
