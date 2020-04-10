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
package modeloConsultas;

import java.io.FileInputStream;

public class Publicidad {
    //Variable de Clase
private int id;
private String titulo;
private FileInputStream  imagen_uno;
private FileInputStream  imagen_dos;
private String telefono;
private String url;
private int duracion;
private int tiempo;
private String pais;
private int vigente;
private String forma_pago;
private String cod_pago;
private String fecha;
private int usuario_id;  
    
    
    
    //Metodos Constructor uno

    public Publicidad() {
    }

    public Publicidad(int id,String titulo, FileInputStream imagen_uno, FileInputStream imagen_dos,
            String telefono, String url, int duracion, int tiempo, int vigente,String forma_pago, String cod_pago,
            String fecha, int usuario_id) {
        this.id = id;
        this.titulo=titulo;
        this.imagen_uno = imagen_uno;
        this.imagen_dos = imagen_dos;
        this.telefono = telefono;
        this.url = url;
        this.duracion = duracion;
        this.tiempo = tiempo;
        this.vigente = vigente;
        this.forma_pago=forma_pago;
        this.cod_pago = cod_pago;
        this.fecha = fecha;
        this.usuario_id = usuario_id;
    }

    //Metodo Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setImagen_uno(FileInputStream imagen_uno) {
        this.imagen_uno = imagen_uno;
    }

    public void setImagen_dos(FileInputStream imagen_dos) {
        this.imagen_dos = imagen_dos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setVigente(int vigente) {
        this.vigente = vigente;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public void setCod_pago(String cod_pago) {
        this.cod_pago = cod_pago;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    //Metodo Getter

    public int getId() {
        return id;
    }

    public FileInputStream getImagen_uno() {
        return imagen_uno;
    }

    public FileInputStream getImagen_dos() {
        return imagen_dos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getUrl() {
        return url;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getTiempo() {
        return tiempo;
    }

    public String getPais() {
        return pais;
    }

    public int getVigente() {
        return vigente;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public String getCod_pago() {
        return cod_pago;
    }

    public String getFecha() {
        return fecha;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public String getTitulo() {
        return titulo;
    }
    
    
    //Metodo tuString

    @Override
    public String toString() {
        return  url ;
    }
    
    
}
