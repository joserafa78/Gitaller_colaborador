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

import java.util.ArrayList;
import java.util.List;

public class Modelo {

    //Variables
    private Integer id;
    private String nombreOficial;
    private String nombre_comercial;
    private int anioLanza;
    private int esPlus; //1= Plus y 0= Normal
    private int id_lineaProducto;
    
    private static Integer autoInc = 1;

    //Metodos Contructor Vacio
    public Modelo() {

    }

    //Metodos Contructor Uno
    public Modelo(String nombreOficial,String nombre_comercial ,int anioLanza, int esPlus, int lineaProducto) {
        this.nombreOficial = nombreOficial;
        this.nombre_comercial=nombre_comercial;
        this.id_lineaProducto = lineaProducto;
        this.esPlus = esPlus;
        this.anioLanza = anioLanza;
        autoInc++;
    }
    //Metodos Setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombreOficial(String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public void setLineaProducto(int lineaProducto) {
        this.id_lineaProducto = lineaProducto;
    }

    public void setEsPlus(int esPlus) {
        this.esPlus = esPlus;
    }

    public void setAnioLanza(int anioLanza) {
        this.anioLanza = anioLanza;
    }

    public void setId_lineaProducto(int id_lineaProducto) {
        this.id_lineaProducto = id_lineaProducto;
    }

    //Metodos Getter
    public Integer getId() {
        return id;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public int getLineaProducto() {
        return id_lineaProducto;
    }

    public int getEsPlus() {
        return esPlus;
    }

    public int getAnioLanza() {
        return anioLanza;
    }

    public int getId_lineaProducto() {
        return id_lineaProducto;
    }

    @Override
    public String toString() {
        return  nombre_comercial ;
    }
    

}
