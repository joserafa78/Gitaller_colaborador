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

public class LineaProducto {

    //Variables
    private int id;
    private String nombre;
    private String gama;
    private int id_fabrica;
    //private static Integer autoInc = 1;

    //Metodo Construcctor Uno
    public LineaProducto(int id, String nombre, String gama, int id_fabrica) {
        this.id = id;
        this.nombre = nombre;
        this.gama = gama;
        this.id_fabrica = id_fabrica;
    }
    //Metodo Construcctor Dos

    public LineaProducto() {
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public void setId_fabrica(int id_fabrica) {
        this.id_fabrica = id_fabrica;
    }
    //Getter

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGama() {
        return gama;
    }

    public int getId_fabrica() {
        return id_fabrica;
    }

    @Override
    public String toString() {
        return  nombre ;
    }


}
