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


public class AreaFalla {
    //Variable de la Clase
    private int id;
    private String nombre;
    private String descripcion;
    private int tipo_falla_id; //--(4)-----

    
    
    //Metodo Construcctor Vacio
    public AreaFalla() {
    }
    
    //Metodo Construcctor
    public AreaFalla(int id, String nombre, String descripcion, int tipo_falla_id) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo_falla_id = tipo_falla_id;
    }

  //Metodos Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo_falla_id(int tipo_falla_id) {
        this.tipo_falla_id = tipo_falla_id;
    }
    //Metodos Getter

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getTipo_falla_id() {
        return tipo_falla_id;
    }
    //To String

    @Override
    public String toString() {
        return  nombre ;
    }
    
}
