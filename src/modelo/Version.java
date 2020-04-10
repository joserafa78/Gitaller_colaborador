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

public class Version {

    //Variables
    private Integer id;//1  -
    private String version;//2 - Numero de Modelo
    private String nombre;
    private int capacidad;//3  -
    private int esDualSim;//4  - (1= Dual Sim Card  y 0= Sim Card)
    private int modelo_id;//5  -
    private static Integer autoInc = 1;

    //Metodo Construcctor
    public Version(String version,String nombre, int capacidad, int esDualSim, int id_modelo) {
        this.id = autoInc;
        this.version = version;
        this.nombre=nombre;
        this.capacidad = capacidad;
        this.esDualSim = esDualSim;
        this.modelo_id = id_modelo;
        autoInc++;
    }
//Constructor Vacio
    public Version(){}
    //Metodo Setter
    public void setId(Integer id) {
        this.id = id;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setEsDualSim(int esDualSim) {
        this.esDualSim = esDualSim;
    }

    public void setModelo_id(int id_modelo) {
        this.modelo_id = id_modelo;
    }
    //Metodo Geetter.

    public Integer getId() {
        return id;
    }

    public String getVersion() {
        return version;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getEsDualSim() {
        return esDualSim;
    }

    public int getModelo_id() {
        return modelo_id;
    }

    @Override
    public String toString() {
        return  version ;
    }
    

}
