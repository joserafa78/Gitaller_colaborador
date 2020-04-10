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
package controladorUsuarios;

import ClasesExtras.ValidarCampos;
import conexionSql.Conexion;
import controlador.ControladorInicial;
import static controladorUsuarios.ControladorUsuarioRegistro.UsuarioRegistrado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import modeloConsultas.UsuarioRegistroDAO;
import vistas.VistaPrincipal;
import vistas_usuarios.VistaUsuarioCuenta;
import vistas_usuarios.VistaUsuarioRegistro;


public class ControladorUsuarioCuenta implements ActionListener{
//Variables de la Clase
VistaUsuarioCuenta vuc=new VistaUsuarioCuenta();
ControladorInicial ci=null;
UsuarioDAO udao =new UsuarioDAO();
   UsuarioRegistroDAO vudao=new UsuarioRegistroDAO(); 
  Usuario u=null;
  
  
  //Constructor
public ControladorUsuarioCuenta(VistaUsuarioCuenta vuc){
this.vuc=vuc;
//Botones
this.vuc.boton_entrar.addActionListener(this);

}  



public void agregar(){
    
        
}  

public int validarCampos(){ //.isEmpty(
    int error=0;
 String p1= String.valueOf(vuc.texte_password.getPassword());
if (vuc.txte_correo.getText().isEmpty()){    
JOptionPane.showMessageDialog(vuc, "Falta Ingresar el Correo Electronico", "Advertencia", JOptionPane.WARNING_MESSAGE);
vuc.txte_correo.requestFocus();
error=1;
}else if(p1.equals("")){
 JOptionPane.showMessageDialog(vuc, "Falta Ingresar la Clave", "Advertencia", JOptionPane.WARNING_MESSAGE);
vuc.texte_password.requestFocus();    
error=1;

}


return error;
}

public int validarCuentaUsuario(){
int t=0;    
int v= validarCampos();

if (v==0){//Si los campos estan debidmentes llenados entonces buscan en base de Datos.

String correo= vuc.txte_correo.getText() ;
String clave=String.valueOf(vuc.texte_password.getPassword());

int correo_valido=udao.consultarCorreoyPasswor(correo,clave); //Metodo que Busca en Base de datos
t=correo_valido;
if (correo_valido==1){
t=1;
}else{
JOptionPane.showMessageDialog(vuc, "Error,Clave o Correo herrado", "Advertencia", JOptionPane.WARNING_MESSAGE);
t=0;
}

}


return t;
}
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource() == vuc.boton_entrar) {//Boton envia los datos al SErvidor.
         int aceptado=validarCuentaUsuario();

          if(aceptado==1) {//La Clave y Correo Fueron Aceptado
              
         ControladorUsuarioRegistro.UsuarioRegistrado=1;     
         ControladorInicial.estado_sesion=1;
         ControladorInicial.id_usuario=udao.consultaCorreoElectronicoDevuelveID(vuc.txte_correo.getText()) ;
         ControladorInicial.nombre_usuario = udao.contultaCorreoElectronicoDevuelveUsuario(vuc.txte_correo.getText());  
         ControladorInicial.pais_usuario= udao.contultaCorreoElectronicoDevuelvePais(vuc.txte_correo.getText());
         ControladorInicial.administrador = udao.contultaCorreoElectronicoDevuelveAdministrador(vuc.txte_correo.getText());
//u.setId(1);
        Usuario u1=new Usuario();
        u1.setId(ControladorInicial.id_usuario);
        u1.setNombre_usuario(ControladorInicial.nombre_usuario);
        u1.setEstado(0);//Cero es usuario Aceptado  
        u1.setPais(ControladorInicial.pais_usuario);//Cero es usuario Aceptado
        int a = vudao.agregarAccess(u1);
         JOptionPane.showMessageDialog(vuc, "OK entra", "Advertencia", JOptionPane.WARNING_MESSAGE);        
        
         
        limpiar();
        bloquear(false);
        visibilidad(false);
        //visibilidadEnVistaPrincipal(false);
         
         
          }  
             
             
        }   
  
        
        
        
    }
    
    public void limpiar(){
    vuc.txte_correo.setText("");
    vuc.texte_password.setText("");
    }
    
    public void visibilidad(boolean a){
       vuc.txte_correo.setVisible(a);
    vuc.texte_password.setVisible(a);
    vuc.boton_entrar.setVisible(a);
    vuc.setVisible(a);
    }
    
    public void bloquear(boolean a){
   vuc.txte_correo.setEnabled(a);
    vuc.texte_password.setEnabled(a);
    vuc.boton_entrar.setEnabled(a);
    
    }
    
    public void visibilidadEnVistaPrincipal (boolean a){
          // ci.muestraPanelFabricante(a);
           // ci. muestraPanelModelo(a);
        // ci. muestraPanesModelosVersion(a);          
        ci.muestraPanelCuentaUsuario(a);     
       // ci.listar();//llama al metodo para cargar la tabla en la pantalla
    }
    public void inicia(){

//Campos validar
//


vuc.setVisible(true);
}    
}
 