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
package controlador;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Modelo;
import modelo.Version;
import modelo.VersionDAO;
import vistas.VistaVersion;

public class ControladorVersion {

    //Variable de la Clase  
    Version v = new Version(); //Clase de la vista conla que trabaja
    VistaVersion vv = new VistaVersion();
    VersionDAO vdao = new VersionDAO();
    //Constructor de la Clase
    public ControladorVersion(VistaVersion vv) {
        this.vv = vv;
        //Botones

    }
    //Agrear Registro de Versiones
    public void add() {
        //------------------------------------------------------------------------------
        v = new Version();
        v.setId(0);
        v.setVersion("vv");
        v.setCapacidad(0);
        v.setEsDualSim(0);
        v.setModelo_id(1);

        //------------------------------------------------------------------------------- 
        int r = vdao.agregar(v); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vv, "Modelo Agregado con Exito.");
            //limpiar();
        } else {
            JOptionPane.showMessageDialog(vv, "Error, Revisar");
        }
    }
}
