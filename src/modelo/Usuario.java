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

public class Usuario {
    //Variables
    private int id;
    private String nombre_usuario;//NUEVO
    private String nombre;
    private String apellido;//NUEVO
    private String correo;
    private String celular;//NUEVO    
    private String url;
    private String pais;//NUEVO
    private String departamento;
    private String ciudad;
    private String clave;//NUEVO
    private int estado;//NUEVO
    private int administrador;//NUEVO
    private String fecha;//NUEVO
    //Constructor Vacio
    public Usuario() {    
    }

    //Metodos Constructor DOS

    public Usuario(int id, String nombre_usuario, String nombre, String apellido, String correo, String celular, String url, String pais,String departamento,String ciudad, String clave, int estado, int administrador, String fecha) {
        this.id = id;
        this.nombre_usuario = nombre_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.url = url;
        this.pais = pais;
        this.departamento=departamento;
        this.ciudad=ciudad;
        this.clave = clave;
        this.estado = estado;
        this.administrador = administrador;
        this.fecha = fecha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    //Metodos Constructor UNO
    public Usuario(int id, String nombre, String correo, String url) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.url = url;
    }
    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setAdministrador(int administrador) {
        this.administrador = administrador;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    //Getter.

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getUrl() {
        return url;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCelular() {
        return celular;
    }

    public String getPais() {
        return pais;
    }

    public String getClave() {
        return clave;
    }

    public int getEstado() {
        return estado;
    }

    public int getAdministrador() {
        return administrador;
    }

    public String getFecha() {
        return fecha;
    }
    
    //ToString

    @Override
    public String toString() {
        return nombre ;
    }
    
    
}
