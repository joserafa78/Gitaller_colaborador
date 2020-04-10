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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modelo.UsuarioDAO;
import modeloConsultas.UsuarioRegistroDAO;
import vistas.VistaPrincipal;
import vistas_usuarios.VistaUsuarioCuenta;
import vistas_usuarios.VistaUsuarioRegistro;

public class ControladorUsuarioRegistro implements ActionListener{
//Variables de la Clase
  VistaUsuarioRegistro vur=new VistaUsuarioRegistro(); 
  VistaUsuarioCuenta vuc=new VistaUsuarioCuenta();
  UsuarioRegistroDAO vudao=new UsuarioRegistroDAO();
  UsuarioDAO udao= new UsuarioDAO();
  Usuario u=null;
  ControladorInicial ci=null;
  public static int UsuarioRegistrado;
  private int bandera_de_error;
  private String msg_error;
  ValidarCampos vc=new ValidarCampos();  
  ControladorUsuarioCuenta cuc=new ControladorUsuarioCuenta(vuc);
   VistaPrincipal vp=new VistaPrincipal();

    
  //Constructor
public ControladorUsuarioRegistro(VistaUsuarioRegistro vur){
this.vur=vur;
//Botones
this.vur.boton_enviar.addActionListener(this);

}  



public void agregar(){
    
        int validacion= validarCampos();//Metodo para Validar
        if (validacion==0){ 
         
                int CorreoActivo = udao.consultaCorreoElectronico(vur.txte_correo.getText());          
                if (CorreoActivo==0){
 
                    int Usua=0;
                     Usua= udao.consultaNombreUsuario(vur.txte_nombre_usuario.getText());//
                    if (Usua==0){
                  //_______________________________________________________________ 
                   u = new Usuario();
                   u.setId(1);
                   u.setNombre_usuario(vur.txte_nombre_usuario.getText());
                   u.setNombre(vur.txte_nombre.getText());
                   u.setApellido(vur.txte_apellidos.getText());
                   u.setCorreo(vur.txte_correo.getText());
                   u.setCelular(vur.txte_celular.getText());
                   u.setPais(vur.combo_pais.getSelectedItem().toString());
                   u.setDepartamento(vur.combo_departamento.getSelectedItem().toString());
                   u.setCiudad(vur.txte_ciudad.getText());
                   u.setClave(String.valueOf(vur.txte_clave_uno.getPassword()) );
                   u.setAdministrador(4);//Root=0    Admin=1    Comprometido=2   Colaborador=3   UsuarGeneral=4
                   u.setEstado(0); //estado 0= aceptado
                      

                      int r = vudao.agregar(u);// Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
                     int id_Usu_Registrado_Ya = udao.consultaCorreoElectronicoDevuelveID(vur.txte_correo.getText());
                      u.setId(id_Usu_Registrado_Ya); // AQUI DEBE CONSULTAR EL ID DEL USUARIO NUEVO y asigna el id.
                      int c = vudao.agregarAccess(u);//Guarda el REgistro en Access.
                      if (r == 1) {
                      
                        //ci1.metodohilo();
                          JOptionPane.showMessageDialog(vur, "¡¡¡Registro Exitoso!!!. Haga Clic fuera del Formulario");
                          UsuarioRegistrado=1;
                          ControladorInicial.id_usuario=id_Usu_Registrado_Ya;
                          ControladorInicial.estado_sesion=1;
                          ControladorInicial.nombre_usuario=vur.txte_nombre_usuario.getText();                         
                          limpiar();
                          visibilidadComponentes(false);
                         
 
                             bloquear(false);
                             cuc.bloquear(false);
                             
  
                             
                             
                      } else {
                          JOptionPane.showMessageDialog(vur, "Error,Lo Sentimos.....");
                      }
                    }else{
          JOptionPane.showMessageDialog(vur, "Este Nombre Usuario ya esta en Uso, Cambielo", "Advertencia", JOptionPane.WARNING_MESSAGE);              
                    }
                
                
                }else{
       JOptionPane.showMessageDialog(vur, "Este Coreo Electronico ya esta en Uso", "Advertencia", JOptionPane.WARNING_MESSAGE);
  
                }
        //_______________________________________________________________

        }
}  

public int validarCampos(){ //.isEmpty(
  
    int error=0;
    //-----------------------
   String p1= String.valueOf(vur.txte_clave_uno.getPassword());
   String p2= String.valueOf(vur.txte_clave_dos.getPassword());
  
    //----------------------
    
if (vur.txte_nombre_usuario.getText().isEmpty()){    
JOptionPane.showMessageDialog(vur, "Falta Ingresar el UsuarioNombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_nombre_usuario.requestFocus();
error=1;
}else if(vur.txte_nombre.getText().isEmpty()){
 JOptionPane.showMessageDialog(vur, "Falta Ingresar el Nombre", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_nombre.requestFocus();    
error=1;
}else if(vur.txte_apellidos.getText().isEmpty()){
 JOptionPane.showMessageDialog(vur, "Falta Ingresar el Apellido", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_apellidos.requestFocus();    
error=1;
}else if(vur.txte_correo.getText().isEmpty()){
 JOptionPane.showMessageDialog(vur, "Falta Ingresar el Correo electroico", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_correo.requestFocus();    
error=1;
}else if(vur.txte_celular.getText().isEmpty()){
 JOptionPane.showMessageDialog(vur, "Falta Ingresar el Telefono Celular", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_celular.requestFocus();    
error=1;
}else if(vur.combo_pais.getSelectedItem().equals("")){
 JOptionPane.showMessageDialog(vur, "Falta Ingresar el Pais", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.combo_pais.requestFocus();    
error=1; 
}else if(p1.equals("")){
 JOptionPane.showMessageDialog(vur, "Falta Ingresar el Primer(1) Password", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_clave_uno.requestFocus();    
error=1; //
}
else if(p2.equals("")){
 JOptionPane.showMessageDialog(vur, "Falta Ingresar el Segundo(2) Password", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_clave_dos.requestFocus();    
error=1; //
}else if(p1.equals(p2) ){//vur.txte_clave_dos.getPassword()


error=0; //
}else{
 JOptionPane.showMessageDialog(vur, "No Coinciden los Password", "Advertencia", JOptionPane.WARNING_MESSAGE);
vur.txte_clave_uno.requestFocus();  
error=1;
}



return error;
}
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == vur.boton_enviar) {//Boton envia los datos al SErvidor.

            agregar(); 
             
        }   
        
        
        
        
    }
    
    public void limpiar(){
     vur.txte_nombre_usuario.setText("");
vur.txte_nombre.setText("");
  vur.txte_apellidos.setText("");
  vur.txte_correo.setText("");
  vur.txte_celular.setText("");
  vur.combo_pais.getSelectedItem().toString();
 vur.txte_clave_uno.setText(""); 
 vur.txte_clave_dos.setText("");    
    }
    
    public void bloquear(boolean a){
         vur.txte_nombre_usuario.setEnabled(a);
vur.txte_nombre.setEnabled(a);
  vur.txte_apellidos.setEnabled(a);
  vur.txte_correo.setEnabled(a);
  vur.txte_celular.setEnabled(a);
  vur.combo_pais.setEnabled(a);
 vur.txte_clave_uno.setEnabled(a);; 
 vur.txte_clave_dos.setEnabled(a);
 vur.boton_enviar.setEnabled(a);
 
    
    }
    public void visibilidadComponentes(boolean a){
    vur.txte_nombre_usuario.setVisible(a);
vur.txte_nombre.setVisible(a);
  vur.txte_apellidos.setVisible(a);
  vur.txte_correo.setVisible(a);
  vur.txte_celular.setVisible(a);
  vur.combo_pais.setVisible(a);
 vur.txte_clave_uno.setVisible(a); 
 vur.txte_clave_dos.setVisible(a);
 vur.boton_enviar.setVisible(a);
 vur.setVisible(a);
    
    }
    
    public void visibilidadEnVistaPrincipal (boolean a){
          // ci.muestraPanelFabricante(a);
           // ci. muestraPanelModelo(a);
        // ci. muestraPanesModelosVersion(a);          
        ci.muestraPanelRegistroUsuario(a);     
        ci.listar();//llama al metodo para cargar la tabla en la pantalla
    }
    public void inicia(){

//Campos validar
//
vc.validarEspacios(this.vur.txte_nombre_usuario);//
vc.validarLimiteCaracteres(this.vur.txte_nombre_usuario, 20);
vc.validarNumeros(this.vur.txte_celular);//
vc.validarLetras(this.vur.txte_nombre);
vc.validarLetras(this.vur.txte_apellidos);
vc.validaLimiteCaracterPasswor(this.vur.txte_clave_uno, 9);
vc.validaLimiteCaracterPasswor(this.vur.txte_clave_dos, 9);

vur.setVisible(true);
}    
}
 