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

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Fabricante;
import modelo.LineaProducto;
import modelo.LineaProductoDAO;
import vistas.VistaFabricante;
import vistas.VistaLineaProducto;

public class ControladorLineaProducto implements ActionListener {

    //Variables de Clase
    LineaProducto lp = new LineaProducto();
    VistaLineaProducto vlp = new VistaLineaProducto();
    LineaProductoDAO lpdao = new LineaProductoDAO();
    ControladorFabricante cf;
    VistaFabricante vf;
    //Medelo de Tabla
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultComboBoxModel modelocombo = null;     
    
    //Metodo Construcctor
    public ControladorLineaProducto(VistaLineaProducto vlp) {
        this.vlp = vlp;
        //Botones 
        vlp.boton_nuevo.addActionListener(this);
        vlp.boton_empresa.addActionListener(this);
        vlp.cbx_fabricante.addActionListener(this);
        vlp.boton_agregar.addActionListener(this);
        vlp.boton_editar.addActionListener(this);
        vlp.boton_actualiza.addActionListener(this);
        vlp.boton_eliminar.addActionListener(this);
    }

    //Metodo Carga a la Tabla Toda la Linea de Productos segun el Fabricante seleccionado
    public void listar(JTable table) {//Metodo que Carga de la lista Calse DAO Y O ENVIA al Modelo
        modelo = (DefaultTableModel) table.getModel();
        int id = Integer.parseInt(vlp.text_id_empresa.getText());
        List<LineaProducto> lista = lpdao.listar(id);//Carga los datos del la clase FabricanteDao a la LISTA
        Object objeto[] = new Object[3]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getGama();
            modelo.addRow(objeto); //Carga al TableModel Dato por Datos de la Lista 
        }
        table.setModel(modelo);
    }

    public void listarFabriantes(JComboBox combo) { //JComboBox combo

        Vector<Fabricante> lista = lpdao.listarFabricante();
        modelocombo = new DefaultComboBoxModel(lista);

        combo.setModel(modelocombo);

    }

    @Override  //Eventos
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vlp.boton_empresa) {//*******Muestra la Vista del Fabricante
            vf = new VistaFabricante();
            cf = new ControladorFabricante(vf);
            cf.inicia();
        }
        if (e.getSource() == vlp.cbx_fabricante) {//*********Evento Oyente del ComboBox Clic

            Fabricante fabri = (Fabricante) vlp.cbx_fabricante.getSelectedItem();
            vlp.text_id_empresa.setText(String.valueOf(fabri.getId()));
            limpiarTabla();
            listar(vlp.table);//llama al metodo para cargar la tabla de lista de  Prod
        }

        if (e.getSource() == vlp.boton_agregar) {//********Agrega un Nuela Linea de Producto a un Fab
            add();
        }

        if (e.getSource() == vlp.boton_editar) {//**********Boton Editar Tabla de Lista de Productos
            int fila = vlp.table.getSelectedRow();  //Debe haber Selecionado una Fila en la Tabla
            if (fila == -1) {

                JOptionPane.showMessageDialog(vf, "Debe Seleciconar Una Fila de La Tabla .");

            } else {

                //Pasa los Datos de la Tabla a cada uno de los Textx.
                String id_v = (String) vlp.table.getValueAt(fila, 0).toString();

                String nombre_v = (String) vlp.table.getValueAt(fila, 1).toString();

                String gama_v = (String) vlp.table.getValueAt(fila, 2).toString();

                String id_fabricante_v = vlp.text_id_empresa.getText();

                //pasa a Vista
                vlp.text_id.setText(id_v);
                vlp.text_nombre_linea.setText(nombre_v);
                vlp.cbx_gama.setSelectedItem(gama_v);
                vlp.text_id_empresa.setText(id_fabricante_v);
            }

        }

        if (e.getSource() == vlp.boton_actualiza) {//********Boton Actualizar
            //Llama a metodo Actualizar
            actualizar();
            limpiar();
            limpiarTabla();
            listar(vlp.table);
        }

        if (e.getSource() == vlp.boton_eliminar) {//********Boton eliminar
            //Llama a metodo Eliminar
            eliminar();
            limpiar();
            limpiarTabla();
            listar(vlp.table);

        }

    }

    public void limpiar() {
        vlp.text_nombre_linea.setText("");
        vlp.text_id.setText("");
        vlp.boton_nuevo.setText("Nuevo");
    }

    public void limpiarTabla() {
        for (int i = 0; i < vlp.table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void bloquear() {
        vlp.boton_nuevo.setEnabled(true);
        vlp.boton_cancelar.setEnabled(false);
        vlp.boton_eliminar.setEnabled(false);
        vlp.boton_empresa.setEnabled(false);
    }

    //Agrear Registro a Linea de Producto
    public void add() {

        lp = new LineaProducto(); //vf.text_nombre.getText()

        lp.setNombre(vlp.text_nombre_linea.getText());
        lp.setGama(String.valueOf(vlp.cbx_gama.getSelectedItem()));
        lp.setId_fabrica(Integer.parseInt(vlp.text_id_empresa.getText()));
        System.out.println(lp.getNombre() + " " + lp.getGama() + " " + lp.getId_fabrica());
        int r = lpdao.agregar(lp);// Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vf, "Linea de Producto Agregado con Exito.");
            limpiar();
            limpiarTabla();
            listar(vlp.table);
        } else {
            JOptionPane.showMessageDialog(vf, "Error, Revisar");
        }

    }

    //Actualiza un registro de la linea de productos
    public void actualizar() {

        if (vlp.text_id.getText().equals("")) {
            JOptionPane.showMessageDialog(vf, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {

            int id = Integer.parseInt(vlp.text_id.getText());
            String nombre_v = vlp.text_nombre_linea.getText();
            String gama_v = String.valueOf(vlp.cbx_gama.getSelectedItem());
            int id_v = Integer.parseInt(vlp.text_id.getText()); //(vlp.text_id.getText()) ;
            int id_fabriante_v = Integer.parseInt(vlp.text_id_empresa.getText());
            //------------------------------------
            lp = new LineaProducto();
            lp.setId(id);
            lp.setNombre(nombre_v);
            lp.setGama(gama_v);
            lp.setId_fabrica(id_fabriante_v);
            //------------------------------------

            int r = lpdao.actualizar(lp); //dao.actualizar(f);
            if (r == 1) {

                JOptionPane.showMessageDialog(vf, "Linea de Produccion Actualizada con Exito.");
            } else {

                JOptionPane.showMessageDialog(vf, "Error");

            }

        }

    }

    //Elimina un Registro de la Tabla Linea de Producto
    public void eliminar() {
        int fila = vlp.table.getSelectedRow();//Seleciona una fila de la tabla
        if (fila == -1) {
            JOptionPane.showMessageDialog(vlp, "Debe Seleccionar una Fila...!!!");
        } else {//Integer.parseInt((String) vf.tabla_maraca.getValueAt(fila, 0).toString());
            int id_v = Integer.parseInt((String) vlp.table.getValueAt(fila, 0).toString());
            lpdao.eliminar(id_v);
            JOptionPane.showMessageDialog(vf, "La Linea de Producto se ha Eliminado...!!!");
            limpiar();
            limpiarTabla();
            bloquear();
            listar(vlp.table);
        }

    }

    public void inicia() {

        vlp.setTitle("Fabriante*");
        vlp.setLocationRelativeTo(null);
        vlp.text_id.setEnabled(false);
        vlp.text_id_empresa.setEnabled(false);
        limpiar();
        //bloquear();          
        listarFabriantes(vlp.cbx_fabricante);
        vlp.setVisible(true);

    }
}
