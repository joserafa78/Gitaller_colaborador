package controladorUsuarios;

import ClasesExtras.ValidarCampos;
import controlador.ControladorInicial;
import java.awt.Desktop;
import java.awt.Image;
import modeloConsultas.Publicidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modeloConsultas.PublicidadDAO;
import vistas_usuarios.*;

public class ControladorJpanelPublicidadUno implements ActionListener {
//Clases Globales de la Clase
            HiloPublicidadPrueba pub =new HiloPublicidadPrueba();                        
            Thread HiloPublicidad=new Thread(pub);  //Luego, construye un hilo de ese objeto. 

    JpanelPublicidadUno jpuno = new JpanelPublicidadUno();
    JpanelPublicidadDos jpdos = new JpanelPublicidadDos();
    JpanelPublicidadTres jptres = new JpanelPublicidadTres();
    ValidarCampos vc=new ValidarCampos(); 
    //Para la el archivo Selecionado
    public static FileInputStream fis1; //Tipo de archivo deonde Gurarda el flujo de Datos byte
    public static FileInputStream fis2; //Tipo de archivo deonde Gurarda el flujo de Datos byte
    private int longitudBytes;// Variabel que guarda la longitud
    private String ruta_archivo;//ruta
    
    //Mas variables
    private String ling_web = "https://twitter.com/joserafa";
    private String descripcion_publicidad="Servicio \"Altamente Profesional\"  (313-694.67.37) Bogotá";

    
    
    //Metodo Constructor
    public ControladorJpanelPublicidadUno(JpanelPublicidadUno jpuno) {
        this.jpuno = jpuno;
        //botones de la Clase  
        jpuno.boton_imagen_uno.addActionListener(this);
    }

    public void selecionarArchivo1() throws FileNotFoundException, IOException {//Selector de Archivo
        JFileChooser selec = new JFileChooser();//Objeto Selecionador
        String tipo = "jpg";//Tipo de Archivo segun lo Selecionado
        FileNameExtensionFilter fi = new FileNameExtensionFilter(tipo, tipo);//Clase qeu crea una extencion . algo
        selec.setFileFilter(fi);//Filtra el Archivo Segun la Extension
        int se = selec.showOpenDialog(null);//Cuadro de dialogo
        if (se == 0) {
            fis1 = new FileInputStream(selec.getSelectedFile());//Objeto de Archivo Binario para entrada 
            //longitudBytes = (int) selec.getSelectedFile().length();//Catura la longitud del Archivo
            jpuno.boton_imagen_uno.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //vc.text_nombre.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //ruta_archivo = selec.getSelectedFile().getAbsolutePath();//obtienen la ruta
            //vc.text_ubicacion.setText(ruta_archivo);
            
              //Crea un icono y lo Re-Dimensiona al tamaño exacto del label...
            Image icono = ImageIO.read(selec.getSelectedFile()).getScaledInstance(jpuno.labe_imagen_publicidad_mini.getWidth(), jpuno.labe_imagen_publicidad_mini.getHeight(), Image.SCALE_DEFAULT);
            jpuno.labe_imagen_publicidad_mini.setIcon(new ImageIcon(icono));
            jpuno.labe_imagen_publicidad_mini.updateUI(); //Actualiza el Label.
            //-------------------------------------------------------- 
            ling_web=jpuno.text_url.getText();
            descripcion_publicidad=jpuno.text_telefono.getText();
            jpuno.Label_inferior_publicidad.setText(descripcion_publicidad);
          //-------------------INICIA HILO DE PUBLICIDAD---------------------------
    
            HiloPublicidad.start();
        //--------------------------------------------------------
            

        } else {
        }

    }

    public void selecionarArchivo2() throws FileNotFoundException {//Selector de Archivo
        JFileChooser selec = new JFileChooser();//Objeto Selecionador
        String tipo = "jpg";//Tipo de Archivo segun lo Selecionado
        FileNameExtensionFilter fi = new FileNameExtensionFilter(tipo, tipo);//Clase qeu crea una extencion . algo
        selec.setFileFilter(fi);//Filtra el Archivo Segun la Extension
        int se = selec.showOpenDialog(null);//Cuadro de dialogo
        if (se == 0) {
            fis2 = new FileInputStream(selec.getSelectedFile());//Objeto de Archivo Binario para entrada 
            //longitudBytes = (int) selec.getSelectedFile().length();//Catura la longitud del Archivo
            //jpuno.boton_imagen_dos.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //vc.text_nombre.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //ruta_archivo = selec.getSelectedFile().getAbsolutePath();//obtienen la ruta
            //vc.text_ubicacion.setText(ruta_archivo);

        } else {
        }

    }
    
    public int validarCampos(){
    int error=0; //

if (jpuno.text_titulo.getText().isEmpty()){    
JOptionPane.showMessageDialog(jpuno, "Falta Ingresar El Titulo, en Paso(1)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jpuno.text_titulo.requestFocus();
error=1;
}else    if (fis1 == null){    
JOptionPane.showMessageDialog(jpuno, "Falta Ingresar La Imagen Mini, en Paso(1)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jpuno.boton_imagen_uno.requestFocus();
error=1;
}else if (jpuno.text_telefono.getText().equals("")){
JOptionPane.showMessageDialog(jpuno, "Falta Ingresar La Informacion de Contacto, en Paso(1)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jpuno.text_telefono.requestFocus();
error=1;
}else if (jpuno.text_url.getText().isEmpty()){
JOptionPane.showMessageDialog(jpuno, "Falta Ingresar Ling Url, en Paso(1)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jpuno.text_url.requestFocus();
error=1;
}
/*
else if (jptres.text_codigo_pago.getText().isEmpty()){
JOptionPane.showMessageDialog(jpuno, "Falta Ingresar Codigo de Pago, en Paso(3)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jptres.text_codigo_pago.requestFocus();
error=1;
}else if (jpdos.Check_acepto.isSelected()){

}else{
JOptionPane.showMessageDialog(jpuno, "Falta Aceptar Condiciones de Publicacion, en Paso(2)", "Advertencia", JOptionPane.WARNING_MESSAGE);
jpdos.Check_acepto.requestFocus();
error=1;
} 
*/    
    
    return error;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jpuno.boton_imagen_uno) {
            try {
                //Boton envia los datos al SErvidor.
                selecionarArchivo1();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorJpanelPublicidadUno.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ControladorJpanelPublicidadUno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    
  
    
    public void metodoClicFotoPublicidad() {
        jpuno.labe_imagen_publicidad_mini.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                    abrirLink();
                }

            @Override
            public void mouseEntered(MouseEvent e) {
           
  
              
            }

            @Override
            public void mouseExited(MouseEvent e) {
             
            }


        });

    }
   
      private void abrirLink() {
        try {
            Desktop.getDesktop().browse(new URI(ling_web));
        } catch (Exception e) {
        }
    }

    public class HiloPublicidadPrueba implements Runnable {
    int publicidad_activa=0;    
    int durarion=5; //Variables modificable para la publicidad
    int comientza=2;    
    int sg=0;      
    int c_duracion=0;   
    @Override
    public void run(){
     boolean arranca=true;
     int cuenta=0;
    //----------------------------------------
     while (arranca){   
    
     sg++; 
     cuenta++;
       if (sg>comientza){         
                      c_duracion++;                  
                    publicidad_activa=1;                    
                    if (c_duracion==durarion){                   
                    publicidad_activa=0;                    
                    c_duracion=0;
                    sg=0;
                    }      
       }        
    //---------------------------------------    
     if (publicidad_activa==1){
    jpuno.panel_publicitario_mini.setVisible(true);
   
    }else{
    jpuno.panel_publicitario_mini.setVisible(false);
   
    }
    //----------------------------------------
        try { 
            sleep(1000);//Un Segundo Duerme
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
    if (cuenta>= 60){//Termina el Ciclo
    arranca=false;
    
    }
     }   
    }
    }
    

    public void limpiar() {
        jpuno.boton_imagen_uno.setText("Cargar Imagen Mini");
       // jpuno.boton_imagen_dos.setText("Cargar Imagen Grande");
        jpuno.text_telefono.setText("");
        jpuno.text_url.setText("");
        //jpuno.combo_pais
        //Variables
        fis1=null;
fis2=null;
longitudBytes=0;
ruta_archivo="";
ling_web = "https://twitter.com/joserafa";
descripcion_publicidad="Servicio \"Altamente Profesional\"  (313-694.67.37) Bogotá";

HiloPublicidad.interrupt();//Detiene hilo



    }
    
    

    public void bloquear(boolean a) {
        jpuno.boton_imagen_uno.setEnabled(a);
        //jpuno.boton_imagen_dos.setEnabled(a);
        jpuno.text_telefono.setEnabled(a);
        jpuno.text_url.setEnabled(a);
        //jpuno.combo_pais

    }

    public void inicial() {
        //Campos validar
vc.validarLimiteCaracteres(this.jpuno.text_titulo, 18);//Limited de espacio en Text
vc.validarLimiteCaracteres(this.jpuno.text_telefono, 50);      
        metodoClicFotoPublicidad();
        jpuno.setVisible(true);

    }

}
