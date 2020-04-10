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

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
public class Fabricante {

    //Variables
    int id;
    String nombre;
    String historia;
    private FileInputStream logo;

   // private static Integer autoInc = 1;

    //Constuctor Uno
    public Fabricante() {

    }
    //Constuctor dos

    public Fabricante(String nombre) {
        //this.id = autoInc;
        this.nombre = nombre;
        //autoInc++;
    }
    //Constuctor Tres

    public Fabricante(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        //autoInc++;
    }
      //Constuctor Cuatro

    public Fabricante(String nombre, String historia, FileInputStream logo) {

        this.nombre = nombre;
        this.historia = historia;
        this.logo = logo;
    }
    //Metodo Constructor cinco

    public Fabricante(int id, String nombre, String historia, FileInputStream logo) {
        this.id = id;
        this.nombre = nombre;
        this.historia = historia;
        this.logo = logo;
    }
    
    
    //Metodo Seeter

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public void setLogo(FileInputStream logo) {
        this.logo = logo;
    }
    

    //METODOS Geeter
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHistoria() {
        return historia;
    }

    public FileInputStream getLogo() {
        return logo;
    }
    
        @Override
    public String toString() {
        return  nombre ;
    }

}
