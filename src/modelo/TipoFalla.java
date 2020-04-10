package modelo;

public class TipoFalla {

    //Variables de la Clase
    private int id;
    private String nombre;
    private String descripcion;

    //Constructor Vacio
    public TipoFalla() {
        //VACIO
    }
    //Constructor
    public TipoFalla(int id, String nombre, String descripcion) {
        this.id=id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        
    }
//SETTER

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //GETTER

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return  nombre ;
    }
    
}
