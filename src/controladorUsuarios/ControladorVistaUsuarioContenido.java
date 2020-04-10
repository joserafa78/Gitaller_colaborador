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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Contenido;
import modelo.ContenidoDAO;
import vistas_usuarios.VistaUsuarioContenido;

/**
 *
 * @author naila
 */
public class ControladorVistaUsuarioContenido implements ActionListener {


    private int entidad;
    private int entidad_id;
//private  int aporte;
    private int aporte_id;
    private int area_falla;
    private int tipo_falla;
    private int usuario_id;
    private int fabricante_id;
    private int lineaproducto_id;
    private int modelo_id;
    private int Version_id;
    //-------------------------
    private String version;//EJM: SM-G4351
    
    //Para la el archivo Selecionado
    public static FileInputStream fis1; //Tipo de archivo deonde Gurarda el flujo de Datos byte
    private int longitudBytes;// Variabel que guarda la longitud
    private String ruta_archivo;//ruta   
    VistaUsuarioContenido vuc = new VistaUsuarioContenido();
    ContenidoDAO cdao = new ContenidoDAO();

    //*********************Constructor***************************
    public ControladorVistaUsuarioContenido(VistaUsuarioContenido vuc) {
        this.vuc = vuc;
        //Boontes
        this.vuc.boton_archivo.addActionListener(this);//
        this.vuc.boton_enviar.addActionListener(this);

    }
    //****************************************** 

    public void selecionarArchivo() throws FileNotFoundException {//Selector de Archivo
        JFileChooser selec = new JFileChooser();//Objeto Selecionador
        String tipo = "pdf";//Tipo de Archivo segun lo Selecionado
        FileNameExtensionFilter fi = new FileNameExtensionFilter(tipo, tipo);//Clase qeu crea una extencion . algo
        selec.setFileFilter(fi);//Filtra el Archivo Segun la Extension
        int se = selec.showOpenDialog(null);//Cuadro de dialogo
        if (se == 0) {
            fis1 = new FileInputStream(selec.getSelectedFile());//Objeto de Archivo Binario para entrada 
            //longitudBytes = (int) selec.getSelectedFile().length();//Catura la longitud del Archivo
            vuc.boton_archivo.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //vc.text_nombre.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //ruta_archivo = selec.getSelectedFile().getAbsolutePath();//obtienen la ruta
            //vc.text_ubicacion.setText(ruta_archivo);

        } else {
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vuc.boton_archivo) {
            try {
                //Boton envia los datos al SErvidor.
                selecionarArchivo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorJpanelPublicidadUno.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }//
        if (e.getSource() == vuc.boton_enviar) {
            int resul = validarCampos();

            if (resul == 0) {
                agregar();
            }
        }

    }

    //  Metodos Setter ******************
    public void setEntidad(int entidad) {
        this.entidad = entidad;
    }

    public void setEntidad_id(int entidad_id) {
        this.entidad_id = entidad_id;
    }

    public void setAporte_id(int aporte_id) {
        this.aporte_id = aporte_id;
    }

    public void setArea_falla(int area_falla) {
        this.area_falla = area_falla;
    }

    public void setTipo_falla(int tipo_falla) {
        this.tipo_falla = tipo_falla;
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

    public void setVersion_id(int Version_id) {
        this.Version_id = Version_id;
    }

    public int validarCampos() {
        int error = 0; //
        String val = vuc.combo_tipo_documento.getSelectedItem().toString();
        if (val == "Seleccionar") {
            JOptionPane.showMessageDialog(vuc, "Falta Ingresar Seleccionar Documento", "Advertencia", JOptionPane.WARNING_MESSAGE);
            vuc.combo_tipo_documento.requestFocus();
            error = 1;
        } else if (fis1 == null) {
            JOptionPane.showMessageDialog(vuc, "Falta Ingresar el Archivo Pdf ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            vuc.boton_archivo.requestFocus();
            error = 1;
        }

        return error;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    

    public void agregar() {
//------------------------------------------------------------------------------
        Contenido c = new Contenido();
   
         if (version.equals("")){
        c.setNombre(vuc.combo_tipo_documento.getSelectedItem().toString());
        }else{
        c.setNombre(vuc.combo_tipo_documento.getSelectedItem().toString()+". "+version);
        }
        
        c.setTipo_archivo(1);//PDF
        c.setUbicacion("");
        c.setArchivo(fis1);//Carga Longitud Binaria a la Clase Contenido
        c.setEntidad(entidad);
        c.setEntidad_id(entidad_id);
        c.setAporte(1);//Documentos      
        c.setAporte_id(aporte_id);
        c.setArea_falla(0);//
        c.setTipo_falla(0);//  
        c.setId_falla(0);// 
        c.setUsuraio_id(usuario_id);
        c.setFabricante_id(fabricante_id);
        c.setLineaproducto_id(lineaproducto_id);
        c.setModelo_id(modelo_id);
        c.setVersion_id(Version_id);
        //------------------------------------------------------------------------------- 
        System.out.println("nombrw:"+c.getNombre());
        System.out.println("Archivo:"+c.getTipo_archivo());
        System.out.println("Ubicacion:"+c.getUbicacion());
        System.out.println("Entidad:"+c.getEntidad());
        System.out.println("ID Entidad:"+c.getEntidad_id());
        System.out.println("Aporte:"+c.getAporte());
        System.out.println("ID Aporte:"+c.getAporte_id());
        System.out.println("Area Falla:"+c.getArea_falla());
        System.out.println("Tipo Falla:"+c.getTipo_falla());
        System.out.println("ID Falla:"+c.getId_falla());
        System.out.println("usurioa:"+c.getUsuraio_id());
        System.out.println("Fabricante ID:"+c.getFabricante_id());
        System.out.println("Linea Produc:"+c.getLineaproducto_id());
        System.out.println("Model:"+c.getModelo_id());
        System.out.println("Version:"+c.getVersion_id());
        System.out.println(".....FIN....");
         //------------------------------------------------------------------------------- 

        int r = cdao.agregar(c); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vuc, "Contenido Enviado Exito, Porfavor Esperar.");
            limpiar();
            vuc.setVisible(false);

        } else {
            JOptionPane.showMessageDialog(vuc, "Error, Revisar");
        }
    }

    public void limpiar() {
        vuc.label_detalles.setText("");
        vuc.boton_archivo.setText("rchivo (PDF)");
        fis1 = null;

    }

    public void inicia(String detalle) {
        vuc.setTitle("Cargar Contenido (Solo Para Tecnicos Autorizados) ");
        //vuc.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/Logo_tentativo.png")).getImage());
        //vuc.setBounds(0, 0, 560, 550);
        vuc.label_detalles.setText(detalle);
        vuc.setLocationRelativeTo(null);
        vuc.setVisible(true);
    }

}
