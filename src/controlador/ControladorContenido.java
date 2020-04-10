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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Contenido;
import modelo.ContenidoDAO;
import modelo.Fabricante;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vistas.VistaContenido;
import vistas.VistaEntidad;
import vistas.VistaTipoAporte;
import vistas.VistaUsuario;

public class ControladorContenido implements ActionListener {

    //Variables de la Clase
    VistaContenido vc = new VistaContenido();
    UsuarioDAO udao = new UsuarioDAO();
    Contenido c = new Contenido();
    ContenidoDAO cdao = new ContenidoDAO();
    DefaultComboBoxModel modelocombo = null;
    DefaultTableModel modelo = new DefaultTableModel();
    //Vista
    VistaEntidad ve = new VistaEntidad();
    ControladorEntidad ce = new ControladorEntidad(ve);
    //Vistas
    VistaTipoAporte vtp = new VistaTipoAporte();
    ControladorTipoAporte ctp = new ControladorTipoAporte(vtp);
    //Para la el archivo Selecionado
    private FileInputStream fis; //Tipo de archivo deonde Gurarda el flujo de Datos byte
    private int longitudBytes;// Variabel que guarda la longitud
    private String ruta_archivo;//ruta

    //**************************************************************************************    
    //Metodo Constructor
    //***************************************************************************************
    public ControladorContenido(VistaContenido vc) {
        this.vc = vc;

        //Botontes
        vc.boton_nuevo.addActionListener(this);
        vc.boton_cancelar.addActionListener(this);
        vc.boton_guardar.addActionListener(this);
        vc.boton_ubicacion.addActionListener(this);
        vc.boton_usuario.addActionListener(this);
        vc.boton_Editar.addActionListener(this);
        vc.boton_actualizar.addActionListener(this);
        vc.boton_eliminar.addActionListener(this);
        vc.boton_busca_id.addActionListener(this);
        //ComboBox
        vc.combo_usuario.addActionListener(this);
        vc.combo_tipo_aporte.addActionListener(this);
        vc.combo_entidad.addActionListener(this);

    }

    public void listarTodoContenido(JTable table) {//Metodo que Carga de la lista Clase de Contenido

        modelo = (DefaultTableModel) table.getModel();
        List<Contenido> lista = cdao.listarTodo();//Carga los datos del cla clase Contenido
        Object objeto[] = new Object[14]; //Crea un Arreglo tipo Objeto de 5 Elementos.

        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getTipo_archivo();
            objeto[2] = lista.get(i).getNombre();
            objeto[3] = lista.get(i).getEntidad();
            objeto[4] = lista.get(i).getEntidad_id();
            objeto[5] = lista.get(i).getAporte();
            objeto[6] = lista.get(i).getAporte_id();
            objeto[7] = lista.get(i).getArea_falla();
            objeto[8] = lista.get(i).getTipo_falla();
            objeto[9] = lista.get(i).getUsuraio_id();
            objeto[10] = lista.get(i).getFabricante_id();
            objeto[11] = lista.get(i).getLineaproducto_id();
            objeto[12] = lista.get(i).getModelo_id();
            objeto[13] = lista.get(i).getVersion_id();

            modelo.addRow(objeto); //Agrega un Objeto tipo vector al modelo 

        }
        vc.label_cantidad.setText(String.valueOf(lista.size()));
        table.setModel(modelo);

    }

    public void listarAutoresComboBox(JComboBox combo) {
        Vector<Usuario> lista = udao.listar();
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);
    }

    //Agrear Registro a Contenido
    public void agregar() {

        if ((fis == null) ||  (vc.text_id_usuario.getText().equals(""))) {
            JOptionPane.showMessageDialog(vc, "Error, Debe Ubicar Un Archivo y Selecionar el Autor ");

        } else {

//------------------------------------------------------------------------------
            c = new Contenido();

            c.setNombre(vc.text_nombre.getText());

            if (vc.combo_tipo_archivo.getSelectedItem() == "Pdf") {
                c.setTipo_archivo(1);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Jpg") {
                c.setTipo_archivo(2);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Png") {
                c.setTipo_archivo(3);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Txt") {
                c.setTipo_archivo(4);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Exe") {
                c.setTipo_archivo(5);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Iso") {
                c.setTipo_archivo(6);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Mp4") {
                c.setTipo_archivo(7);
            }

//---------------------------------------------------------------------------
            c.setUbicacion(String.valueOf(vc.text_ubicacion.getText()));

            c.setArchivo(fis);//Carga Longitud Binaria a la Clase Contenido

//---------------------------------------------------------------------------
            if (vc.combo_entidad.getSelectedItem() == "Fabricante") {
                c.setEntidad(1);
            }

            if (vc.combo_entidad.getSelectedItem() == "Linea Producto") {
                c.setEntidad(2);
            }

            if (vc.combo_entidad.getSelectedItem() == "Modelo") {
                c.setEntidad(3);
            }

            if (vc.combo_entidad.getSelectedItem() == "Version") {
                c.setEntidad(4);
            }

//----------------------------------------------------------------------------
            c.setEntidad_id(Integer.parseInt(vc.text_id_entidad.getText()));

//----------------------------------------------------------------------------
            if (vc.combo_tipo_aporte.getSelectedItem() == "Documentacion Aporte") {
                c.setAporte(1);
            }
            if (vc.combo_tipo_aporte.getSelectedItem() == "Falla Aporte") {
                c.setAporte(2);
            }
//-------------------------------------------------------------------------

            c.setAporte_id(Integer.parseInt(vc.text_id_aporte.getText()));

            c.setArea_falla(vc.area_falla);//Carga el valor que esta en la variabel de la clase VistaContenido

            c.setTipo_falla(vc.tipo_falla);//Carga el valor que esta en la variabel de la clase VistaContenido

            c.setUsuraio_id(Integer.parseInt(vc.text_id_usuario.getText()));           
            c.setFabricante_id(VistaContenido.fabricante_id);
            c.setLineaproducto_id(VistaContenido.lineaproducto_id);
            c.setModelo_id(VistaContenido.modelo_id);
            c.setVersion_id(VistaContenido.Version_id);
            //------------------------------------------------------------------------------- 
            int r = cdao.agregar(c); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
            if (r == 1) {
                JOptionPane.showMessageDialog(vc, "Contenido Agregado con Exito.");
                limpiar();
                limpiarTabla();
                listarTodoContenido(vc.table);//POR AHORA NO.
                bloquear();
            } else {
                JOptionPane.showMessageDialog(vc, "Error, Revisar");
            }

            //----------------------------------------------  
        }
    }

    public void editar() {
        int fila = vc.table.getSelectedRow(); //Debe haber Selecionado una Fila en la Tabla
        if (fila == -1) {
            JOptionPane.showMessageDialog(vc, "Debe Seleciconar Una Fila de La Tabla.");
        } else {
            //Pasa los Datos de la Tabla a cada uno de los Textx.

            String id = vc.table.getValueAt(fila, 0).toString(); //Seleciona fila y columan 0
            String tipo_archivo = vc.table.getValueAt(fila, 1).toString();
            String nombre = vc.table.getValueAt(fila, 2).toString();
            String entidad = vc.table.getValueAt(fila, 3).toString();
            String entidad_id = vc.table.getValueAt(fila, 4).toString();
            String aporte = vc.table.getValueAt(fila, 5).toString();
            String aporte_id = vc.table.getValueAt(fila, 6).toString();
            String area_falla = vc.table.getValueAt(fila, 7).toString();
            String tipo_falla = vc.table.getValueAt(fila, 8).toString();
            String usuario = vc.table.getValueAt(fila, 9).toString();
            //----------------------------------------------
            VistaContenido.fabricante_id=Integer.parseInt(vc.table.getValueAt(fila, 10).toString());
            VistaContenido.lineaproducto_id=Integer.parseInt(vc.table.getValueAt(fila, 11).toString());
            VistaContenido.modelo_id=Integer.parseInt(vc.table.getValueAt(fila, 12).toString());
            VistaContenido.Version_id=Integer.parseInt(vc.table.getValueAt(fila, 13).toString());
            
    
            //pasa a Vista
            vc.text_id.setText(id);
            //---------------------------------------------------------

            if (tipo_archivo.equals("1")) {
                vc.combo_tipo_archivo.setSelectedItem("Pdf");
            }
            if (tipo_archivo.equals("2")) {
                vc.combo_tipo_archivo.setSelectedItem("Jpg");
            }
            if (tipo_archivo.equals("3")) {
                vc.combo_tipo_archivo.setSelectedItem("Png");
            }
            if (tipo_archivo.equals("4")) {
                vc.combo_tipo_archivo.setSelectedItem("Txt");
            }
            if (tipo_archivo.equals("5")) {
                vc.combo_tipo_archivo.setSelectedItem("Exe");
            }
            if (tipo_archivo.equals("6")) {
                vc.combo_tipo_archivo.setSelectedItem("Iso");
            }
            if (tipo_archivo.equals("7")) {
                vc.combo_tipo_archivo.setSelectedItem("Mp4");
            }
            //---------------------------------------------------------

            vc.text_nombre.setText(nombre);
            //---------------------------------------------------------
            if (entidad.equals("1")) {//Fabricante, Linea Producto, Modelo, Version
                vc.combo_entidad.setSelectedItem("Fabricante");

            }
            if (entidad.equals("2")) {//Fabricante, Linea Producto, Modelo, Version
                vc.combo_entidad.setSelectedItem("Linea Producto");
            }
            if (entidad.equals("3")) {//Fabricante, Linea Producto, Modelo, Version          
                vc.combo_entidad.setSelectedItem("Modelo");

            }
            if (entidad.equals("4")) {//Fabricante, Linea Producto, Modelo, Version
                vc.combo_entidad.setSelectedItem("Version");

            }
            //----------------------------------------------------------               

            vc.text_id_entidad.setText(entidad_id);
            //Condicional para Combo.(Documento/Falla)
            //----------------------------------------------------------
            if (aporte.equals("1")) {
                vc.combo_tipo_aporte.setSelectedItem("Documentacion Aporte");
            }
            if (aporte.equals("2")) {
                vc.combo_tipo_aporte.setSelectedItem("Falla Aporte");
            }
            //----------------------------------------------------------

            vc.text_id_aporte.setText(aporte_id);
            vc.area_falla = Integer.parseInt(area_falla);
            vc.tipo_falla = Integer.parseInt(tipo_falla);
            vc.text_id_usuario.setText(usuario);//Condicional par combo(Busca todos los Usuario
            //vc.text_id_area_falla.setText(id_area_falla);
            desbloquearDos();

        }
    }

    public void actualizar() {
        if (vc.text_id.getText().equals("")) {
            JOptionPane.showMessageDialog(vc, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {

//------------------------------------------------------------------------------
            c = new Contenido();
            c.setId(Integer.parseInt(vc.text_id.getText()));
            c.setNombre(vc.text_nombre.getText());

            if (vc.combo_tipo_archivo.getSelectedItem() == "Pdf") {
                c.setTipo_archivo(1);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Jpg") {
                c.setTipo_archivo(2);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Png") {
                c.setTipo_archivo(3);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Txt") {
                c.setTipo_archivo(4);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Exe") {
                c.setTipo_archivo(5);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Iso") {
                c.setTipo_archivo(6);
            }
            if (vc.combo_tipo_archivo.getSelectedItem() == "Mp4") {
                c.setTipo_archivo(7);
            }

            c.setUbicacion(String.valueOf(vc.text_ubicacion.getText()));

            c.setArchivo(fis);//Carga Longitud Binaria a la Clase Contenido

            if (vc.combo_entidad.getSelectedItem() == "Fabricante") {
                c.setEntidad(1);
            }

            if (vc.combo_entidad.getSelectedItem() == "Linea Producto") {
                c.setEntidad(2);
            }

            if (vc.combo_entidad.getSelectedItem() == "Modelo") {
                c.setEntidad(3);
            }

            if (vc.combo_entidad.getSelectedItem() == "Version") {
                c.setEntidad(4);
            }

            c.setEntidad_id(Integer.parseInt(vc.text_id_entidad.getText()));

            if (vc.combo_tipo_aporte.getSelectedItem() == "Documentacion Aporte") {
                c.setAporte(1);
            }
            if (vc.combo_tipo_aporte.getSelectedItem() == "Falla Aporte") {
                c.setAporte(2);
            }

            c.setAporte_id(Integer.parseInt(vc.text_id_aporte.getText()));

            c.setArea_falla(vc.area_falla);//Carga el valor que esta en la variabel de la clase VistaContenido
            c.setTipo_falla(vc.tipo_falla);//Carga el valor que esta en la variabel de la clase VistaContenido
            c.setFabricante_id(VistaContenido.fabricante_id);
            c.setLineaproducto_id(VistaContenido.lineaproducto_id);
            c.setModelo_id(VistaContenido.modelo_id);
            c.setVersion_id(VistaContenido.Version_id);
            
    
  
            c.setUsuraio_id(Integer.parseInt(vc.text_id_usuario.getText()));
            //-------------------------------------------------------------------------------            
            int r = cdao.actualizar(c);
            if (r == 1) {

                JOptionPane.showMessageDialog(vc, "Ok.. Actualizada con Exito el Registro.");
                limpiar();
                limpiarTabla();
                listarTodoContenido(vc.table);
                bloquear();
            } else {

                JOptionPane.showMessageDialog(vc, "Error ");

            }

        }
    }

    public void eliminar() {
        int fila = vc.table.getSelectedRow();//Seleciona una fila de la tabla
        if (fila == -1) {
            JOptionPane.showMessageDialog(vc, "Debe Seleccionar una Fila...!!!");
        } else {
            int id = Integer.parseInt((String) vc.table.getValueAt(fila, 0).toString());
            cdao.eliminar(id);

            JOptionPane.showMessageDialog(vc, "Contenido Eliminado...!!!");
            limpiar();
            limpiarTabla();
            bloquear();
            listarTodoContenido(vc.table);
        }

    }
    
    public void buscaContenidoPorIdyLista(JTable table){
        int variable_id=Integer.parseInt( vc.text_busca_id.getText());
        limpiarTabla();
            modelo = (DefaultTableModel) table.getModel();
        List<Contenido> lista = cdao.BuscaContenidoPorIdyLista(variable_id);//Carga los datos del cla clase Contenido
        Object objeto[] = new Object[14]; //Crea un Arreglo tipo Objeto de 5 Elementos.

        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getTipo_archivo();
            objeto[2] = lista.get(i).getNombre();
            objeto[3] = lista.get(i).getEntidad();
            objeto[4] = lista.get(i).getEntidad_id();
            objeto[5] = lista.get(i).getAporte();
            objeto[6] = lista.get(i).getAporte_id();
            objeto[7] = lista.get(i).getArea_falla();
            objeto[8] = lista.get(i).getTipo_falla();
            objeto[9] = lista.get(i).getUsuraio_id();
            objeto[10] = lista.get(i).getFabricante_id();
            objeto[11] = lista.get(i).getLineaproducto_id();
            objeto[12] = lista.get(i).getModelo_id();
            objeto[13] = lista.get(i).getVersion_id();

            modelo.addRow(objeto); //Agrega un Objeto tipo vector al modelo 

        }
        
        vc.label_cantidad.setText(String.valueOf(lista.size()));
        table.setModel(modelo);
    }

    public void cargaIdEntidad(int id) {
        vc.text_id_entidad.setText(String.valueOf(id));
    }

    public void selecionarArchivo() throws FileNotFoundException {//Selector de Archivo
        JFileChooser selec = new JFileChooser();//Objeto Selecionador
        String tipo = (String) vc.combo_tipo_archivo.getSelectedItem().toString();//Tipo de Archivo segun lo Selecionado
        FileNameExtensionFilter fi = new FileNameExtensionFilter(tipo, tipo);//Clase qeu crea una extencion . algo
        selec.setFileFilter(fi);//Filtra el Archivo Segun la Extension
        int se = selec.showOpenDialog(null);//Cuadro de dialogo
        if (se == 0) {
            fis = new FileInputStream(selec.getSelectedFile());//Objeto de Archivo Binario para entrada 
            longitudBytes = (int) selec.getSelectedFile().length();//Catura la longitud del Archivo
            vc.boton_ubicacion.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            vc.text_nombre.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            ruta_archivo = selec.getSelectedFile().getAbsolutePath();//obtienen la ruta
            vc.text_ubicacion.setText(ruta_archivo);

        } else {
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vc.boton_nuevo) {
            limpiar();
            desbloquear();
        }
        if (e.getSource() == vc.boton_cancelar) {
            limpiar();
            bloquear();

        }
        if (e.getSource() == vc.boton_guardar) {
            agregar();

        }
        if (e.getSource() == vc.boton_Editar) {
            editar();

        }
        if (e.getSource() == vc.boton_actualizar) {
            actualizar();

        }
        if (e.getSource() == vc.boton_eliminar) {
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea Elimiar el Registro Del Contenido?", "Mensaje de Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {//Respuesta es igual a Si = 0
                eliminar();
            }

        }
        if (e.getSource() == vc.boton_busca_id) {
            buscaContenidoPorIdyLista(vc.table);
        }      
        
        if (e.getSource() == vc.combo_usuario) {
            Usuario usua = (Usuario) vc.combo_usuario.getSelectedItem();
            vc.text_id_usuario.setText(String.valueOf(usua.getId()));
            //vc.combo_tipo_falla.removeAll();//Limpia el combo              
        }
        if (e.getSource() == vc.combo_tipo_aporte) {    //Tipo de aporte  

            String texto = vc.combo_tipo_aporte.getSelectedItem().toString(); //Documentacion Aporte, Falla Aporte
            if (texto.equals("Documentacion Aporte")) {
                vc.text_id_aporte.setText("0");
                vc.area_falla = 0;
                vc.tipo_falla = 0;
            }
            if (texto.equals("Falla Aporte")) {
                vc.text_id_aporte.setText("");
                ctp.inicia();
            }//

        }
        if (e.getSource() == vc.combo_entidad) {    //Tipo de Entidad   
            String texto = vc.combo_entidad.getSelectedItem().toString(); //Documentacion Aporte, Falla Aporte
            if (texto.equals("Fabricante")) {// , Modelo, Version
                vc.text_id_entidad.setText("");
                ce.inicia();
                ce.visualizaFabriante();
            }
            if (texto.equals("Linea Producto")) {
                vc.text_id_entidad.setText("");
                VistaEntidad ve = new VistaEntidad();
                ControladorEntidad ce = new ControladorEntidad(ve);
                ce.inicia();
                ce.visualizaLineaProducto();
            }
            if (texto.equals("Modelo")) {
                vc.text_id_entidad.setText("");
                VistaEntidad ve = new VistaEntidad();
                ControladorEntidad ce = new ControladorEntidad(ve);
                ce.inicia();
                ce.visualizaModelo();
            }
            if (texto.equals("Version")) {
                vc.text_id_entidad.setText("");
                VistaEntidad ve = new VistaEntidad();
                ControladorEntidad ce = new ControladorEntidad(ve);
                ce.inicia();
                ce.visualizaVersion();
            }

        }

        if (e.getSource() == vc.boton_ubicacion) {
            try {
                selecionarArchivo();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ControladorContenido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vc.boton_usuario) {
            VistaUsuario vu = new VistaUsuario();
            ControladorUsuario cu = new ControladorUsuario(vu);
            cu.inicia();

        }

    }

    public void limpiar() {
     vc.text_id.setText("");
      //vc.text_id_entidad.setText("");//Se coloca el 3 porque es "Modelo"
       // vc.text_id_aporte.setText("");//Se coloca el dos porque es "Falla Aporte"
      // vc.text_id_usuario.setText("");
        vc.text_nombre.setText("");
        vc.text_ubicacion.setText("");
        vc.boton_ubicacion.setText("Ubicacion Archivo");
        vc.label_cantidad.setText("");
        //VistaContenido.fabricante_id=0;
        //VistaContenido.lineaproducto_id=0;
       // VistaContenido.modelo_id=0;
       // VistaContenido.Version_id=0;
        
        //Limpia Variables
        fis = null;
        longitudBytes = 0;
        ruta_archivo = "";

    }

    void limpiarTabla() {
        for (int i = 0; i < vc.table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void bloquear() {
        //Botones
        vc.boton_actualizar.setEnabled(false);
        vc.boton_cancelar.setEnabled(false);
        vc.boton_eliminar.setEnabled(false);
        vc.boton_guardar.setEnabled(false);
        vc.boton_nuevo.setEnabled(true);
        vc.boton_ubicacion.setEnabled(false);
        vc.boton_usuario.setEnabled(false);
        //Textos
        vc.text_id.setEnabled(false);
        vc.text_id_aporte.setEnabled(false);
        vc.text_id_entidad.setEnabled(false);
        vc.text_id_usuario.setEnabled(false);
        vc.text_nombre.setEnabled(false);
        vc.text_ubicacion.setEnabled(false);
        //ComboBox
        vc.combo_entidad.setEnabled(false);
        vc.combo_tipo_aporte.setEnabled(false);
        vc.combo_tipo_archivo.setEnabled(false);
        vc.combo_usuario.setEnabled(false);

    }

    public void desbloquear() {
        //Botones
        vc.boton_actualizar.setEnabled(false);
        vc.boton_cancelar.setEnabled(true);
        vc.boton_eliminar.setEnabled(false);
        vc.boton_guardar.setEnabled(true);
        vc.boton_nuevo.setEnabled(false);
        vc.boton_ubicacion.setEnabled(true);
        vc.boton_usuario.setEnabled(true);
        //Textos
        vc.text_id.setEnabled(false);
        vc.text_id_aporte.setEnabled(false);
        vc.text_id_usuario.setEnabled(false);
        vc.text_nombre.setEnabled(true);
        vc.text_ubicacion.setEnabled(false);
        //ComboBox
        vc.combo_entidad.setEnabled(true);
        vc.combo_tipo_aporte.setEnabled(true);
        vc.combo_tipo_archivo.setEnabled(true);
        vc.combo_usuario.setEnabled(true);

    }

    public void desbloquearDos() {
        //Botones
        vc.boton_actualizar.setEnabled(true);
        vc.boton_cancelar.setEnabled(true);
        vc.boton_eliminar.setEnabled(true);
        vc.boton_guardar.setEnabled(false);
        vc.boton_nuevo.setEnabled(false);
        vc.boton_ubicacion.setEnabled(false);
        vc.boton_usuario.setEnabled(true);
        //Textos
        vc.text_id.setEnabled(false);
        vc.text_id_aporte.setEnabled(false);
        vc.text_id_usuario.setEnabled(false);
        vc.text_nombre.setEnabled(true);
        vc.text_ubicacion.setEnabled(false);
        //ComboBox
        vc.combo_entidad.setEnabled(true);
        vc.combo_tipo_aporte.setEnabled(true);
        vc.combo_tipo_archivo.setEnabled(true);
        vc.combo_usuario.setEnabled(true);
    }

    public void inicia() {
        vc.setTitle("Agregar Contenido");
        vc.setLocationRelativeTo(null);
        vc.text_id.setEnabled(false);
        limpiar();
        bloquear();
        listarAutoresComboBox(vc.combo_usuario);//llama al metodo para cargar la tabla en la pantalla
        listarTodoContenido(vc.table);
        vc.setVisible(true);

    }

}
