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

public class TelefonoContenido {

    //Variables
    private Integer id;
    private String nombre;

    private Version version;
    private int anioLanza;
    private static Integer autoInc = 1;

    //Metodos Constructor Uno
    public TelefonoContenido(String nombreComercial, Version version, int anioLanza) {
        this.id = autoInc;
        this.nombre = nombreComercial;
        this.version = version;
        this.anioLanza = anioLanza;
        autoInc++;
    }
    //Metodo Setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombre = nombreComercial;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public void setAnioLanza(int anioLanza) {
        this.anioLanza = anioLanza;
    }
    //metodo Geeter

    public Integer getId() {
        return id;
    }

    public String getNombreComercial() {
        return nombre;
    }

    public Version getVersion() {
        return version;
    }

    public int getAnioLanza() {
        return anioLanza;
    }

}
