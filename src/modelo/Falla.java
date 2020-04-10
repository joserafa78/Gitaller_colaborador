
package modelo;

public class Falla {
    //Variables de la Clase
    private int id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private int aplica_a;
    private int area_falla_id;
    
   //Construcctor Vacio
    public Falla() {
    }   
    //Construcctor
    public Falla(int id, String codigo, String nombre, String descripcion,int aplica_a ,int area_falla_id) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aplica_a = aplica_a;
        this.area_falla_id = area_falla_id;
    }
    //Metodos Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setArea_falla_id(int area_falla_id) {
        this.area_falla_id = area_falla_id;
    }

    public void setAplica_a(int aplica_a) {
        this.aplica_a = aplica_a;
    }

    
     //Metodos Getter aplica_a

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getArea_falla_id() {
        return area_falla_id;
    }

    public int getAplica_a() {
        return aplica_a;
    }
    
 
    //ToString

    @Override
    public String toString() {
        return   nombre ;
    }
    
}
