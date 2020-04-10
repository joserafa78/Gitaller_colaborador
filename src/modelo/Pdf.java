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

public class Pdf extends Contenido {

    //Variables
    private byte[] archivopdf;

    //Metodos
    public Pdf(int id, String nombre, int tipo_archivo,FileInputStream archivo, String ubicacion, int entidad, 
            int entidad_id, int aporte, int aporte_id,int area_falla,int tipo_falla, int usuario_id,byte[] archivopdf,
            int fabricante_id,int lineaproducto_id, int modelo_id,int Version_id ) {
        super(id,nombre,tipo_archivo,archivo,ubicacion,entidad,entidad_id,aporte,aporte_id,area_falla,
                tipo_falla,usuario_id,fabricante_id,lineaproducto_id,modelo_id,Version_id);
  
        this.archivopdf=archivopdf;
    }
    //Setter

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }
  //Getter
    public byte[] getArchivopdf() {
        return archivopdf;
    }
    



}
