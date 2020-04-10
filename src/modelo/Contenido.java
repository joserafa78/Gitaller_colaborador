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

//abstract

import java.io.FileInputStream;

public  class Contenido  {
    //Variables
    private  int id;
    private String nombre;
    private  int tipo_archivo;
    private FileInputStream archivo;
    private String ubicacion;
    private  int entidad;
    private  int entidad_id;
    private  int aporte;
    private  int aporte_id; 
    private  int area_falla;
    private  int tipo_falla;
    private  int id_falla;
    private int usuraio_id;
    //-----------------------------
    private int fabricante_id;
    private int lineaproducto_id;
    private int modelo_id;
    private int Version_id;
    //private static Integer autoInc = 1;

    public Contenido() {
    }
    
        
    //Constructor uno
    public Contenido(int id, String nombre, int tipo_archivo,FileInputStream archivo, String ubicacion, int entidad,
            int entidad_id, int aporte, int aporte_id,int area_falla,int tipo_falla,
            int usuraio_id, int fabricante_id,int lineaproducto_id, int modelo_id, int Version_id) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_archivo = tipo_archivo;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.entidad = entidad;
        this.entidad_id = entidad_id;
        this.aporte = aporte;
        this.aporte_id = aporte_id;
        this.area_falla = area_falla;
        this.tipo_falla=tipo_falla;
        this.usuraio_id = usuraio_id;
        this.fabricante_id=fabricante_id;
        this.lineaproducto_id=lineaproducto_id;
        this.modelo_id=modelo_id;
        this.Version_id=Version_id;
        
        
    }
    
    //Constructor dos

    public Contenido(int id, String nombre, int tipo_archivo, FileInputStream archivo, String ubicacion, int entidad, int entidad_id, int aporte, int aporte_id, int area_falla, int tipo_falla, int id_falla, int usuraio_id, int fabricante_id, int lineaproducto_id, int modelo_id, int Version_id) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_archivo = tipo_archivo;
        this.archivo = archivo;
        this.ubicacion = ubicacion;
        this.entidad = entidad;
        this.entidad_id = entidad_id;
        this.aporte = aporte;
        this.aporte_id = aporte_id;
        this.area_falla = area_falla;
        this.tipo_falla = tipo_falla;
        this.id_falla = id_falla;
        this.usuraio_id = usuraio_id;
        this.fabricante_id = fabricante_id;
        this.lineaproducto_id = lineaproducto_id;
        this.modelo_id = modelo_id;
        this.Version_id = Version_id;
    }
    
    
//Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo_archivo(int tipo_archivo) {
        this.tipo_archivo = tipo_archivo;
    }

    public void setArchivo(FileInputStream archivo) {
        this.archivo = archivo;
    }
    

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setEntidad(int entidad) {
        this.entidad = entidad;
    }

    public void setEntidad_id(int entidad_id) {
        this.entidad_id = entidad_id;
    }

    public void setAporte(int aporte) {
        this.aporte = aporte;
    }

    public void setAporte_id(int aporte_id) {
        this.aporte_id = aporte_id;
    }

    public void setUsuraio_id(int usuraio_id) {
        this.usuraio_id = usuraio_id;
    }

    public void setArea_falla(int area_falla) {
        this.area_falla = area_falla;
    }

    public void setTipo_falla(int tipo_falla) {
        this.tipo_falla = tipo_falla;
    }

    public void setFabricante_id(int fabricante_id) {
        this.fabricante_id = fabricante_id;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }

    public void setLineaproducto_id(int lineaproducto_id) {
        this.lineaproducto_id = lineaproducto_id;
    }

    public void setModelo_id(int modelo_id) {
        this.modelo_id = modelo_id;
    }

    public void setVersion_id(int Version_id) {
        this.Version_id = Version_id;
    }
    
    
    //getter

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo_archivo() {
        return tipo_archivo;
    }

    public FileInputStream getArchivo() {
        return archivo;
    }

    public int getId_falla() {
        return id_falla;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public int getEntidad() {
        return entidad;
    }

    public int getEntidad_id() {
        return entidad_id;
    }

    public int getAporte() {
        return aporte;
    }

    public int getAporte_id() {
        return aporte_id;
    }

    public int getUsuraio_id() {
        return usuraio_id;
    }

    public int getArea_falla() {
        return area_falla;
    }

    public int getTipo_falla() {
        return tipo_falla;
    }

    public int getFabricante_id() {
        return fabricante_id;
    }

    public int getLineaproducto_id() {
        return lineaproducto_id;
    }

    public int getModelo_id() {
        return modelo_id;
    }

    public int getVersion_id() {
        return Version_id;
    }
    
    //ToString

    @Override
    public String toString() {
        return   nombre ;
    }
    

    
}
