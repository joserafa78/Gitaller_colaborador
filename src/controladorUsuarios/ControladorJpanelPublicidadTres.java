package controladorUsuarios;

import controlador.ControladorInicial;
import static controladorUsuarios.ControladorJpanelPublicidadUno.fis1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modeloConsultas.Publicidad;
import modeloConsultas.PublicidadDAO;
import vistas_usuarios.JpanelPublicidadDos;
import vistas_usuarios.JpanelPublicidadTres;
import vistas_usuarios.JpanelPublicidadUno;

public class ControladorJpanelPublicidadTres implements ActionListener {
    //Botones de la Clse

    JpanelPublicidadTres jptres = new JpanelPublicidadTres();
    JpanelPublicidadUno jpuno = new JpanelPublicidadUno();
    JpanelPublicidadDos jpdos = new JpanelPublicidadDos();
    Publicidad p = new Publicidad();

    ControladorJpanelPublicidadUno cjpuno;

    //Contrucor
    public ControladorJpanelPublicidadTres(JpanelPublicidadTres jptres) {
        this.jptres = jptres;
        //Botones
      

    }
    
    
    
        public int validarCampos(){
    int error=0; //

if (jptres.text_codigo_pago.getText().isEmpty()){    
JOptionPane.showMessageDialog(jpuno, "Falta Ingresar El Codigo de Pago, en Paso(3)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jptres.text_codigo_pago.requestFocus();
error=1;

}else if (jptres.combo_forma_pago.getSelectedItem().equals("Seleccione")){    //"Seleccione"
JOptionPane.showMessageDialog(jpuno, "Falta Selecionar la Forma de Pago, en Paso(3)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jptres.combo_forma_pago.requestFocus();
error=1;

}
     
        return error;
}
@Override
    public void actionPerformed(ActionEvent e) {

    }
 public void limpiar(){
 jptres.text_codigo_pago.setText("");
 
 }
 public void bloquear(boolean a){
     jptres.text_codigo_pago.setVisible(a);
     jptres.combo_forma_pago.setVisible(a);
     
 }
    //Variables de la clase 
    public void inicial() {
        jptres.setVisible(true);
    }
}
