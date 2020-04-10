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

import static controladorUsuarios.ControladorVistaUsuarioContenido.fis1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Contenido;
import modelo.ContenidoDAO;
import modelo.Falla;
import modelo.FallaDAO;
import modelo.Version;
import modelo.VersionDAO;
import vistas_usuarios.VistaUsuarioContenidoHardware;

public class ControladorVistaUsuarioContenidoHardware implements ActionListener {
//Variables de la Clase
 VistaUsuarioContenidoHardware vuch= new VistaUsuarioContenidoHardware(); 
 FallaDAO fdao=new FallaDAO();
 VersionDAO vdao= new VersionDAO();
 DefaultComboBoxModel modelocombo = null;
 ContenidoDAO cdao = new ContenidoDAO();
         //Mas Variables
        private int entidad;
        private int  entidad_id;
        private int  Aporte_id;
        private int  area_falla;
        private int tipo_falla;
        private int  id_falla;
        private int  usuario_id;
        private int  fabricante_id;
        private int  lineaproducto_id;
        private int  modelo_id;
        private int  version_id;
        //-------------------------
        private String version;
        //private int  vigente;
        
    //Para la el archivo Selecionado
    public static FileInputStream fis1; //Tipo de archivo deonde Gurarda el flujo de Datos byte
    private int longitudBytes;// Variabel que guarda la longitud
    private String ruta_archivo;//ruta 
    
    
    //Metodo Constructor
    public ControladorVistaUsuarioContenidoHardware(VistaUsuarioContenidoHardware vuch) {
    this.vuch=vuch;
            //Botones y mas
     vuch.combo_falla.addActionListener(this);
      vuch.combo_version.addActionListener(this);
        vuch.boton_archivo.addActionListener(this);  
         vuch.boton_enviar.addActionListener(this);
    }

    public void selecionarArchivo() throws FileNotFoundException {//Selector de Archivo
        JFileChooser selec = new JFileChooser();//Objeto Selecionador
        String tipo = "pdf";//Tipo de Archivo segun lo Selecionado
        FileNameExtensionFilter fi = new FileNameExtensionFilter(tipo, tipo);//Clase qeu crea una extencion . algo
        selec.setFileFilter(fi);//Filtra el Archivo Segun la Extension
        int se = selec.showOpenDialog(null);//Cuadro de dialogo
        if (se == 0) {
            fis1 = new FileInputStream(selec.getSelectedFile());//Objeto de Archivo Binario para entrada 
            //longitudBytes = (int) selec.getSelectedFile().length();//Catura la longitud del Archivo
            vuch.boton_archivo.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //vc.text_nombre.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //ruta_archivo = selec.getSelectedFile().getAbsolutePath();//obtienen la ruta
            //vc.text_ubicacion.setText(ruta_archivo);

        } else {
        }

    } 
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == vuch.combo_falla) {//****Evento Oyente del ComboBox tipo Falla
            Falla fa = (Falla) vuch.combo_falla.getSelectedItem();
            id_falla = fa.getId();//Asigna a la Variable local el ID del Area de Falla
            String fallad= fa.getNombre();

           vuch.text_id_falla.setText( String.valueOf(id_falla));
           String data= vuch.label_detalles_falla.getText();
           data+= fallad;
           vuch.label_detalles_falla.setText(data);
        }
      
           if (e.getSource() == vuch.combo_version) {//****Evento Oyente del ComboBox tipo Falla
            Version ve = (Version) vuch.combo_version.getSelectedItem();
            version_id = ve.getId();//Asigna a la Variable local el ID del Area de Falla
            
            if (version_id == 0){
            version="";
            }else{
            version= ve.getVersion();
            }
            
            //id_tipo_falla = 2;//Asingan el 2 que corresponde al tipo hardware.
           vuch.text_id_version.setText( String.valueOf(version_id));
           String data= vuch.label_detalles.getText();
           data+= " > "+version;
           vuch.label_detalles.setText(data);
           if (version_id==0){//Todas las Versiones(Modelos)
           entidad=3;
           version_id =0;
           }else{
           entidad=4;
           
           }

        }       
 
          if (e.getSource() == vuch.boton_enviar) {//****Evento Oyente del ComboBox tipo Falla
              int resul=validarCampos();
              if(resul==0){
                  agregar() ;
              
              }
                
        }  
        
            if (e.getSource() == vuch.boton_archivo) {try {
                //****Evento Oyente del ComboBox tipo Falla
                
                selecionarArchivo();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ControladorVistaUsuarioContenidoHardware.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }   //   
        
     
    }
    //--------------SETTER--------------------------
    
      public int validarCampos() {
        int error = 0; //
        if (vuch.text_id_falla.getText().equals("")) {
            JOptionPane.showMessageDialog(vuch, "Falta Seleccionar la Falla", "Advertencia", JOptionPane.WARNING_MESSAGE);
            vuch.combo_falla.requestFocus();
            error = 1;
        } else if (vuch.text_id_version.getText().equals("")  ) {
            JOptionPane.showMessageDialog(vuch, "Falta Seleccionar la Version", "Advertencia", JOptionPane.WARNING_MESSAGE);
            vuch.combo_version.requestFocus();
            error = 1;
        } else if (fis1 == null) {
            JOptionPane.showMessageDialog(vuch, "Falta Ingresar el Archivo Pdf ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            vuch.boton_archivo.requestFocus();
            error = 1;
        }

        return error;
    }

    public void setEntidad(int entidad) {
        this.entidad = entidad;
    }

    public void setEntidad_id(int entidad_id) {
        this.entidad_id = entidad_id;
    }

    public void setAporte_id(int Aporte_id) {
        this.Aporte_id = Aporte_id;
    }

    public void setArea_falla(int area_falla) {
        this.area_falla = area_falla;
    }

    public void setTipo_falla(int tipo_falla) {
        this.tipo_falla = tipo_falla;
    }

    public void setId_falla(int id_falla) {
        this.id_falla = id_falla;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setFabricante_id(int fabricante_id) {
        this.fabricante_id = fabricante_id;
    }

    public void setLineaproducto_id(int lineaproducto_id) {
        this.lineaproducto_id = lineaproducto_id;
    }

    public void setModelo_id(int modelo_id) {
        this.modelo_id = modelo_id;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }    
    
    public void listarFalla(JComboBox combo) { //JComboBox combo
        Vector<Falla> lista = fdao.listar(area_falla );
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }
        
    public void listarVersion(JComboBox combo) { //JComboBox combo
        Vector<Version> lista = vdao.listar(modelo_id );
        Version v1=new Version();
        v1.setId(0);
        v1.setVersion("Todas Las Versiones");
        lista.add(v1);
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }
    
    public void limpiar(){
    vuch.label_detalles.setText("");
    vuch.label_detalles_falla.setText("");
    vuch.text_id_falla.setText("");
    vuch.text_id_version.setText("");
    vuch.boton_archivo.setText("Archivo (PDF)");   
    fis1=null;
    }
    public void bloquear(){
    vuch.label_detalles.setVisible(false);
    vuch.label_detalles_falla.setVisible(false);
    vuch.boton_archivo.setVisible(false);  
    }
    
    
        public void agregar() {
//------------------------------------------------------------------------------
        Contenido c = new Contenido();
        if (version.equals("")){
        c.setNombre(vuch.combo_falla.getSelectedItem().toString());
        }else{
        c.setNombre(vuch.combo_falla.getSelectedItem().toString()+". "+version);
        }
        c.setTipo_archivo(1);//PDF
        c.setUbicacion("");
        c.setArchivo(fis1);//Carga Longitud Binaria a la Clase Contenido
        c.setEntidad(entidad);
        c.setEntidad_id(entidad_id);
        c.setAporte(2);//Documentos      
        c.setAporte_id(Aporte_id);
        c.setArea_falla(area_falla);//
        c.setTipo_falla(tipo_falla);//
        c.setId_falla(id_falla);
        c.setUsuraio_id(usuario_id);
        c.setFabricante_id(fabricante_id);
        c.setLineaproducto_id(lineaproducto_id);
        c.setModelo_id(modelo_id);
        c.setVersion_id(version_id);
        //------------------------------------------------------------------------------- 

        int r = cdao.agregar(c); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vuch, "Contenido Enviado Exito, Porfavor Esperar.");
            limpiar();
            bloquear();
            vuch.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(vuch, "Error, Revisar");
        }
    }
    //-----------------------------------------------
    public void inicial(String  detalle,String  falla){
    	vuch.setTitle("Cargar Contenido en Hardhare (Solo Para Tecnicos Autorizados) ");
        //vuch.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/Logo_tentativo.png")).getImage());
        //vuch.setBounds(0, 0, 560, 550);
        vuch.label_detalles.setText(detalle);
        vuch.label_detalles_falla.setText(falla);
        vuch.setLocationRelativeTo(null);
        listarFalla(vuch.combo_falla);
        listarVersion(vuch.combo_version);    
      vuch.text_id_falla.setVisible(false);
    vuch.text_id_version.setVisible(false);
        vuch.setVisible(true);
    }
    
}
