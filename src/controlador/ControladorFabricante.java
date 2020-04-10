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

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Fabricante;
import modelo.FabricanteDAO;
import vistas.VistaFabricante;

public class ControladorFabricante implements ActionListener {

    //Variables de la Clase
    Fabricante f;
    FabricanteDAO dao = new FabricanteDAO();
    VistaFabricante vf = new VistaFabricante();
    DefaultTableModel modelo = new DefaultTableModel();
    //Para la el archivo Selecionado
    private FileInputStream fis; //Tipo de archivo deonde Gurarda el flujo de Datos byte
    private int longitudBytes;// Variabel que guarda la longitud
    private String ruta_archivo;//ruta

    //Metodo Constructor
    public ControladorFabricante(VistaFabricante vf) {
        this.vf = vf;
        //Botones

        vf.boton_nuevo.addActionListener(this);
        vf.boton_cancelar.addActionListener(this);
        vf.boton_guardar.addActionListener(this);
        vf.boton_editar.addActionListener(this);
        vf.boton_eliminar.addActionListener(this);
        vf.boton_seleciona_logo.addActionListener(this);

    }

    public void limpiar() {
        vf.text_nombre.setText("");
        vf.text_id.setText("");
        vf.boton_editar.setText("Editar");
        vf.boton_seleciona_logo.setText("Selecciona Logo");
        vf.textA_historia.setText("");
        vf.label_logo.setIcon(null);
        fis = null;
    }

    void limpiarTabla() {
        for (int i = 0; i < vf.tabla_maraca.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void bloquear() {
        vf.text_nombre.setEnabled(false);
        vf.boton_nuevo.setEnabled(true);
        vf.boton_cancelar.setEnabled(false);
        vf.boton_guardar.setEnabled(false);
        vf.tabla_maraca.setEnabled(false);
        vf.boton_editar.setText("Editar");

    }

    public void desbloquear() {
        vf.text_nombre.setEnabled(true);
        vf.boton_nuevo.setEnabled(false);
        vf.boton_cancelar.setEnabled(true);
        vf.boton_guardar.setEnabled(true);
        vf.tabla_maraca.setEnabled(true);
        vf.boton_editar.setText("Editar");
    }

    public void listar(JTable table) {//Metodo que Carga de la lista Calse DAO Y O ENVIA al Modelo

        modelo = (DefaultTableModel) table.getModel();
        List<Fabricante> lista = dao.listar();//Carga los datos del cla clase FabricanteDao a la LISTA
        Object objeto[] = new Object[3]; //Crea un Arreglo tipo Objeto de 2 Elementos.

        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getHistoria();
            //objeto[3] = lista.get(i).getLogo(); NO SE COLOCA PORQUE TIENE SU METODO GETLOGO
            
            
            modelo.addRow(objeto); //Agrega un Objeto tipo vector al modelo 

        }
        vf.tabla_maraca.setRowHeight(35);
        vf.tabla_maraca.setRowHeight(15);
        vf.tabla_maraca.setModel(modelo);
        //table.setModel(modelo);

    }

    public void add() {

        f = new Fabricante(vf.text_nombre.getText(), vf.textA_historia.getText(), fis); //vf.text_nombre.getText()

        int r = dao.agregar(f);// Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vf, "Usuario Agregado con Exito.");
            limpiar();
            limpiarTabla();
            listar(vf.tabla_maraca);
        } else {
            JOptionPane.showMessageDialog(vf, "Error, Revisar");
        }

    }

    public void actualizar() {

        if (vf.text_id.getText().equals("")) {
            JOptionPane.showMessageDialog(vf, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {

            int id = Integer.parseInt(vf.text_id.getText());
            String nombre = vf.text_nombre.getText();
            String historia = vf.textA_historia.getText();
            
            f = new Fabricante(id, nombre,historia,fis);

            int r = dao.actualizar(f);
            if (r == 1) {
                vf.boton_editar.setText("Editar");
                JOptionPane.showMessageDialog(vf, "Fabricante Actualizado con Exito.");
                limpiar();
                   limpiarTabla();
                  listar(vf.tabla_maraca);
                
            } else {
                vf.boton_editar.setText("Actualizar");
                JOptionPane.showMessageDialog(vf, "Error");

            }

        }

    }

    public void eliminar() {
        int fila = vf.tabla_maraca.getSelectedRow();//Seleciona una fila de la tabla
        if (fila == -1) {
            JOptionPane.showMessageDialog(vf, "Debe Seleccionar una Fila...!!!");
        } else {
            int id = Integer.parseInt((String) vf.tabla_maraca.getValueAt(fila, 0).toString());
            dao.eliminar(id);

            JOptionPane.showMessageDialog(vf, "Usuario Eliminado...!!!");
            limpiar();
            limpiarTabla();
            bloquear();
            listar(vf.tabla_maraca);
        }

    }

    public void selecionarArchivo() throws FileNotFoundException, IOException {//Selector de Archivo
        JFileChooser selec = new JFileChooser();//Objeto Selecionador
        //String tipo = (String) vc.combo_tipo_archivo.getSelectedItem().toString();//Tipo de Archivo segun lo Selecionado
        FileNameExtensionFilter fi = new FileNameExtensionFilter("Jpg", "Jpg");//Clase qeu crea una extencion . algo
        selec.setFileFilter(fi);//Filtra el Archivo Segun la Extension
        int se = selec.showOpenDialog(null);//Cuadro de dialogo
        if (se == 0) {
            fis = new FileInputStream(selec.getSelectedFile());//Objeto de Archivo Binario para entrada 
            longitudBytes = (int) selec.getSelectedFile().length();//Catura la longitud del Archivo
            vf.boton_seleciona_logo.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            //vc.text_nombre.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
            ruta_archivo = selec.getSelectedFile().getAbsolutePath();//obtienen la ruta

            //Crea un icono y lo Re-Dimensiona al tamaño exacto del label...
            Image icono = ImageIO.read(selec.getSelectedFile()).getScaledInstance(vf.label_logo.getWidth(), vf.label_logo.getHeight(), Image.SCALE_DEFAULT);
            vf.label_logo.setIcon(new ImageIcon(icono));
            vf.label_logo.updateUI(); //Actualiza el Label.

        } else {
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vf.boton_nuevo) {
            limpiar();
            desbloquear();
        }
        if (e.getSource() == vf.boton_cancelar) {
            limpiar();
            bloquear();
        }
        if (e.getSource() == vf.boton_guardar) {
            add();
        }

        if (e.getSource() == vf.boton_editar) {// Evento al Hacr Cli al Boton Editar
            if (vf.boton_editar.getText().equals("Editar")) {//Compara que el Boton este activado para Editar
                 
                int fila = vf.tabla_maraca.getSelectedRow(); //Debe haber Selecionado una Fila en la Tabla
                if (fila == -1) {
                    vf.boton_editar.setText("Editar");
                    JOptionPane.showMessageDialog(vf, "Debe Seleciconar Una Fila de La Tabla.");

                } else {
                    //Pasa los Datos de la Tabla a cada uno de los Textx.
                    String id = vf.tabla_maraca.getValueAt(fila, 0).toString(); //Seleciona fila y columan 0
                    String nombre = (String) vf.tabla_maraca.getValueAt(fila, 1);
                    String historia = (String) vf.tabla_maraca.getValueAt(fila, 2);
          
                    ImageIcon foto = FabricanteDAO.getFoto(Integer.parseInt(id));//Llama al metodo mostrar foto
                    //pasa a Vista
                    vf.text_id.setText(id);
                    vf.text_nombre.setText(nombre);
                    vf.textA_historia.setText(historia);
                    if (foto != null) {
                        //Crea un Nuevo icono y lo Re-Dimensiona al tamaño exacto del label.
                        ImageIcon foto2 = new ImageIcon(foto.getImage().getScaledInstance(vf.label_logo.getWidth(), vf.label_logo.getHeight(), Image.SCALE_SMOOTH));
                        vf.label_logo.setIcon(foto2);  //Carga la nueva imagen re-didimensionada al label    
                    } else {
                        vf.label_logo.setIcon(null);
                    }
                    vf.label_logo.updateUI();

                    vf.boton_editar.setText("Actualizar");

                }
            } else {
                if (vf.boton_editar.getText().equals("Actualizar")) {
                    //Llama a metodo Actualizar
                    actualizar();
       

                }
            }
        }
        if (e.getSource() == vf.boton_eliminar) {
            eliminar();
        }
              if (e.getSource() == vf.boton_seleciona_logo) {
            try {
                selecionarArchivo();
            } catch (IOException ex) {
                Logger.getLogger(ControladorFabricante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }

    public void inicia() {
        vf.setTitle("Fabriante");
        vf.setLocationRelativeTo(null);
        vf.text_id.setEnabled(false);
        limpiar();
        bloquear();
        listar(vf.tabla_maraca);//llama al metodo para cargar la tabla en la pantalla
        vf.setVisible(true);

    }

}
