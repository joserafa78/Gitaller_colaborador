/*
SISTEMA "TODO TALLER "
 */
package Inicio;

import controlador.ControladorInicial;
import vistas.VistaPrincipal;
public class inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
              VistaPrincipal v = new VistaPrincipal();     
        ControladorInicial con = new ControladorInicial(v);       
        con.inicia();
    }
    
}
