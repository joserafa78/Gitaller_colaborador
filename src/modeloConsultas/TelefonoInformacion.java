
package modeloConsultas;

public class TelefonoInformacion {
    //Variables de la Clase
    private String version;
    private int version_id;
    private String modelo;
    private String anio_lanza;
    private int modelo_id;
    private String lineaproducto;
    private int lineaproducto_id;
    private String fabricante;
    private int fabricante_id;
    
    
    
    
//Metodo Constructor Vacio
    public TelefonoInformacion() {
    }
//Metodo Constructor
    public TelefonoInformacion(String version, int version_id, String modelo, String anio_lanza, int modelo_id, String lineaproducto, int lineaproducto_id, String fabricante, int fabricante_id) {
        this.version = version;
        this.version_id = version_id;
        this.modelo = modelo;
        this.anio_lanza = anio_lanza;
        this.modelo_id = modelo_id;
        this.lineaproducto = lineaproducto;
        this.lineaproducto_id = lineaproducto_id;
        this.fabricante = fabricante;
        this.fabricante_id = fabricante_id;
    }
//Metodos Setter

    public void setVersion(String version) {
        this.version = version;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnio_lanza(String anio_lanza) {
        this.anio_lanza = anio_lanza;
    }

    public void setModelo_id(int modelo_id) {
        this.modelo_id = modelo_id;
    }

    public void setLineaproducto(String lineaproducto) {
        this.lineaproducto = lineaproducto;
    }

    public void setLineaproducto_id(int lineaproducto_id) {
        this.lineaproducto_id = lineaproducto_id;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setFabricante_id(int fabricante_id) {
        this.fabricante_id = fabricante_id;
    }
//Metodos Getter

    public String getVersion() {
        return version;
    }

    public int getVersion_id() {
        return version_id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnio_lanza() {
        return anio_lanza;
    }

    public int getModelo_id() {
        return modelo_id;
    }

    public String getLineaproducto() {
        return lineaproducto;
    }

    public int getLineaproducto_id() {
        return lineaproducto_id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getFabricante_id() {
        return fabricante_id;
    }

    @Override
    public String toString() {
        return   version + " Modelo:" + modelo ;
    }
    
    
}
