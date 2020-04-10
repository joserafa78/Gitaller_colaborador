
package controladorUsuarios;

import static controladorUsuarios.ControladorJpanelPublicidadUno.fis1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas_usuarios.JpanelPublicidadDos;


public class ControladorJpanelPublicidadDos implements ActionListener{
//Variables de la Clase
    JpanelPublicidadDos jpdos=new JpanelPublicidadDos();
    
    
    
    
    //Metodo Constructor
    
    
    
    
    
    public ControladorJpanelPublicidadDos(JpanelPublicidadDos jpdos) {
        this.jpdos=jpdos;
        //Botones de la clase
        
    }
    
    
        public int validarCampos(){
    int error=0;

/*
else if (jptres.text_codigo_pago.getText().isEmpty()){
JOptionPane.showMessageDialog(jpuno, "Falta Ingresar Codigo de Pago, en Paso(3)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jptres.text_codigo_pago.requestFocus();
error=1;
}
 */       
if (jpdos.Check_acepto.isSelected()){

}else{
JOptionPane.showMessageDialog(jpdos, "Falta Aceptar Condiciones de Publicacion, en Paso(2)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jpdos.Check_acepto.requestFocus();
error=1;
} 
    
    
    return error;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    public void limpiar(){
    jpdos.Check_acepto.setSelected(false);
    }
    
    public void inicial(){
    jpdos.setVisible(true);
    }
    
}
