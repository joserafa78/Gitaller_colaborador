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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.TipoFalla;
import modelo.TipoFallaDAO;
import vistas.VistaPrincipal;
import vistas.VistaTipoFalla;

public class ControladorTipoFalla implements ActionListener {

    //Variables de la Clase
    VistaTipoFalla vtf = new VistaTipoFalla();
    TipoFallaDAO tfdao = new TipoFallaDAO();
    TipoFalla tf;
    DefaultTableModel modelo = new DefaultTableModel();

    //Constructor uno
    public ControladorTipoFalla(VistaTipoFalla vtf) {
        this.vtf = vtf;
        vtf.boton_guardar.addActionListener(this);
        vtf.boton_nuevo.addActionListener(this);
        vtf.boton_cancelar.addActionListener(this);
        vtf.boton_editar.addActionListener(this);
        vtf.boton_actualizar.addActionListener(this);

    }

    //Agrear Registro de Tipo de Falla
    public void agregar() {
        //------------------------------------------------------------------------------
        tf = new TipoFalla();
        //tf.setId(0);
        tf.setNombre(vtf.text_nombre.getText());
        tf.setDescripcion(vtf.text_descripcion.getText());

        //------------------------------------------------------------------------------- 
        int r = tfdao.agregar(tf); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vtf, "Tipo de Falla Agregada con Exito.");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vtf, "Error, Revisar");
        }
    }

    public void listar(JTable table) {//Metodo que Carga de la lista de todos los tipos de fallas

        modelo = (DefaultTableModel) table.getModel();
        List<TipoFalla> lista = tfdao.listar();//Carga los datos del cla clase FabricanteDao a la LISTA
        Object objeto[] = new Object[3]; //Crea un Arreglo tipo Objeto de 2 Elementos.

        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getDescripcion();
            modelo.addRow(objeto); //Agrega un Objeto tipo vector al modelo 

        }

        table.setModel(modelo);

    }

    public void actualizar() {

        if (vtf.text_id.getText().equals("")) {
            JOptionPane.showMessageDialog(vtf, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {

            int id = Integer.parseInt(vtf.text_id.getText());
         
            String nombre = vtf.text_nombre.getText();
            String descripcion = vtf.text_descripcion.getText();
            tf = new TipoFalla(id, nombre, descripcion);
            int r = tfdao.actualizar(tf);
            if (r == 1) {

                JOptionPane.showMessageDialog(vtf, "Tipo de Falla  Actualizada con Exito.");
                limpiar();
                bloquear();
                limpiarTabla();
                listar(vtf.table);
                
            } else {
          
                JOptionPane.showMessageDialog(vtf, "Error");

            }

        }

    }

    @Override //-----------------------------------------------------------
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vtf.boton_guardar) {
            agregar();
        }

        if (e.getSource() == vtf.boton_nuevo) {
            limpiar();
            desbloquear();
        }

        if (e.getSource() == vtf.boton_cancelar) {
            limpiar();
            bloquear();
        }
        if (e.getSource() == vtf.boton_editar) {
            int fila = vtf.table.getSelectedRow(); //Debe haber Selecionado una Fila en la Tabla
            if (fila == -1) {
                JOptionPane.showMessageDialog(vtf, "Debe Seleciconar Una Fila de La Tabla.");
            } else {
                //Pasa los Datos de la Tabla a cada uno de los Textx.
                String id = vtf.table.getValueAt(fila, 0).toString(); //Seleciona fila y columan 0
                String nombre = (String) vtf.table.getValueAt(fila, 1);
                String descripcion = (String) vtf.table.getValueAt(fila, 2);
                //pasa a Vista
                vtf.text_id.setText(id);
                vtf.text_nombre.setText(nombre);
                vtf.text_descripcion.setText(descripcion);
                desbloquearDos();

            }
        }
                if (e.getSource() == vtf.boton_actualizar) {
         actualizar();
        }
        
    }

    public void limpiar() {
        vtf.text_id.setText("");
        vtf.text_nombre.setText("");
        vtf.text_descripcion.setText("");
    }

    public void bloquear() {
        vtf.text_id.setEnabled(false);
        vtf.text_nombre.setEnabled(false);
        vtf.text_descripcion.setEnabled(false);
        vtf.boton_nuevo.setEnabled(true);
        vtf.boton_cancelar.setEnabled(false);
        vtf.boton_guardar.setEnabled(false);
        vtf.boton_actualizar.setEnabled(false);
        vtf.boton_eliminar.setEnabled(false);
    }

    public void desbloquear() {
        vtf.text_id.setEnabled(false);
        vtf.text_nombre.setEnabled(true);
        vtf.text_descripcion.setEnabled(true);
        vtf.boton_nuevo.setEnabled(true);
        vtf.boton_cancelar.setEnabled(true);
        vtf.boton_guardar.setEnabled(true);
        vtf.boton_actualizar.setEnabled(false);
        vtf.boton_eliminar.setEnabled(false);
    }

    public void desbloquearDos() {
        vtf.text_id.setEnabled(false);
        vtf.text_nombre.setEnabled(true);
        vtf.text_descripcion.setEnabled(true);
        vtf.boton_nuevo.setEnabled(false);
        vtf.boton_cancelar.setEnabled(false);
        vtf.boton_guardar.setEnabled(false);
        vtf.boton_actualizar.setEnabled(true);
        vtf.boton_eliminar.setEnabled(true);
    }
    
    void limpiarTabla() {
        for (int i = 0; i < vtf.table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void inicia() {
        vtf.setTitle("Tipos de Fallas");
        //vtf.setBounds(0, 0, 995, 600);
        vtf.setLocationRelativeTo(null);
        limpiar();
        bloquear();
        listar(vtf.table);//llama al metodo para cargar la tabla en la pantalla
        vtf.setVisible(true);
    }
}
