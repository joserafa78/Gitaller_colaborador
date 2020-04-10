package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.AreaFalla;
import modelo.AreaFallaDAO;
import modelo.TipoFalla;
import modelo.TipoFallaDAO;
import vistas.VistaAreaFalla;
import vistas.VistaTipoFalla;

public class ControladorAreaFalla implements ActionListener {
//Variable de la Clase   

    VistaAreaFalla vaf = new VistaAreaFalla();
    TipoFallaDAO tfdao = new TipoFallaDAO();
    AreaFalla af = null;
    AreaFallaDAO afdao = new AreaFallaDAO();
    DefaultComboBoxModel modelocombo = null;
    DefaultTableModel modelo = new DefaultTableModel();

    //Metodo Constructor 
    public ControladorAreaFalla(VistaAreaFalla vaf) {
        this.vaf = vaf;
//Botonoes
        vaf.boton_tipo_falla.addActionListener(this);
        vaf.boton_nuevo.addActionListener(this);
        vaf.boton_cancelar.addActionListener(this);
        vaf.boton_guardar.addActionListener(this);
        vaf.boton_actualizar.addActionListener(this);
        vaf.boton_editar.addActionListener(this);
//Combobox.
        vaf.combo_tipo_falla.addActionListener(this);

    }

    //Metodo para mostrar en ComboBox Todos los Tipos de Fallas
    public void listarTiposFalla(JComboBox combo) { //JComboBox combo
        Vector<TipoFalla> lista = tfdao.listar();
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }

    //Metodo para mostrar en Tabla Todas las Areas de Fallas segun los tipos de Fallas
    public void listarTabla(JTable table) {//Este Metodo 
        modelo = (DefaultTableModel) table.getModel();
        int n = Integer.parseInt(vaf.text_id_tipo_falla.getText());
        List<AreaFalla> lista = afdao.listar(n); //Carga los datos del cla clase FabricanteDao a la LISTA
        Object objeto[] = new Object[4]; //Crea un Arreglo tipo Objeto de 4Elementos.
        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getDescripcion();
            objeto[3] = lista.get(i).getTipo_falla_id();

            modelo.addRow(objeto); //Carga al TableModel Dato por Datos de la Lista 
        }
        table.setModel(modelo);;

    }

    public void Agregar() {

        af = new AreaFalla(1, vaf.text_nombre.getText(), vaf.text_descripcion.getText(), Integer.parseInt(vaf.text_id_tipo_falla.getText()));
                
        int r = afdao.agregar(af);// Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vaf, "Area de Falla Agregado con Exito.");
            limpiar();
            limpiarTabla();
            //listar(vf.tabla_maraca);
        } else {
            JOptionPane.showMessageDialog(vaf, "Error, Revisar");
        }

    }

    //Actualiza un registro del Area de Falla
    public void actualizar() {

        if (vaf.text_id_area_falla.getText().equals("")) {
            JOptionPane.showMessageDialog(vaf, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {

            int id = Integer.parseInt(vaf.text_id_area_falla.getText());
            String nombre_v = vaf.text_nombre.getText();
            String descripcion_v = vaf.text_descripcion.getText();
            int tipo_falla_id_v = Integer.parseInt(vaf.text_id_tipo_falla.getText()); //(vlp.text_id.getText()) ;
            //int id_fabriante_v = Integer.parseInt(vaf.text_id_empresa.getText());
            //------------------------------------
            af = new AreaFalla();
            af.setId(id);
            af.setNombre(nombre_v);
            af.setDescripcion(descripcion_v);
            af.setTipo_falla_id(tipo_falla_id_v);
            //------------------------------------

            int r = afdao.actualizar(af);
            if (r == 1) {
                JOptionPane.showMessageDialog(vaf, "Area de falla Actualizada con Exito.");
                limpiar();
                limpiarTabla();
                listarTabla(vaf.table);
                bloquear();
            } else {

                JOptionPane.showMessageDialog(vaf, "Error");

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vaf.boton_tipo_falla) {//****Evento Oyente Boton Mostrar Vista de Tipo Falla
            VistaTipoFalla vtf = new VistaTipoFalla();
            ControladorTipoFalla ctf = new ControladorTipoFalla(vtf);
            ctf.inicia();
        }
        if (e.getSource() == vaf.combo_tipo_falla) {//****Evento Oyente del ComboBox tipo Falla
            TipoFalla tipof = (TipoFalla) vaf.combo_tipo_falla.getSelectedItem();
            vaf.text_id_tipo_falla.setText(String.valueOf(tipof.getId()));
            limpiarTabla();
            listarTabla(vaf.table);

        }

        if (e.getSource() == vaf.boton_nuevo) {//****Evento Oyente Boton Nuevo
            limpiar();
            desbloquear();
        }
        if (e.getSource() == vaf.boton_cancelar) {//****Evento Oyente Boton Cancelar
            limpiar();
            bloquear();
        }
        if (e.getSource() == vaf.boton_guardar) {//****Evento Oyente Boton Guardar
            Agregar();
        }
        if (e.getSource() == vaf.boton_actualizar) {//****Evento Oyente Boton Actualizar
            actualizar();
        }
        if (e.getSource() == vaf.boton_editar) {//**********Boton Editar Tabla de Area de Fallas
            int fila = vaf.table.getSelectedRow();  //Debe haber Selecionado una Fila en la Tabla
            if (fila == -1) {

                JOptionPane.showMessageDialog(vaf, "Debe Seleciconar Una Fila de La Tabla .");

            } else {

                //Pasa los Datos de la Tabla a cada uno de los Textx.
                String id_v = (String) vaf.table.getValueAt(fila, 0).toString();

                String nombre_v = (String) vaf.table.getValueAt(fila, 1).toString();

                String descripcion_v = (String) vaf.table.getValueAt(fila, 2).toString();

                String tipo_falla_id_v = vaf.text_id_tipo_falla.getText();

                //pasa a Vista
                vaf.text_id_area_falla  .setText(id_v);
                vaf.text_nombre.setText(nombre_v);
                vaf.text_descripcion.setText(descripcion_v);
                vaf.text_id_tipo_falla.setText(tipo_falla_id_v);
                desbloqueardos();
            }

        }

    }

    public void limpiar() {
        vaf.text_id_area_falla.setText("");
        //vaf.text_id_tipo_falla.setText("");
        vaf.text_nombre.setText("");
        vaf.text_descripcion.setText("");

    }

    public void limpiarComboTipoFalla() { //getRowCount()
        for (int i = 0; i < vaf.combo_tipo_falla.getItemCount(); i++) {
            vaf.combo_tipo_falla.removeItemAt(i);
            //i = i - 1;
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < vaf.table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void bloquear() {
        //Textos
        vaf.text_id_area_falla.setEnabled(false);
        vaf.text_id_tipo_falla.setEnabled(false);
        vaf.text_nombre.setEnabled(false);
        vaf.text_descripcion.setEnabled(false);
        //Botones
        vaf.boton_nuevo.setEnabled(true);
        vaf.boton_cancelar.setEnabled(false);
        vaf.boton_guardar.setEnabled(false);
        vaf.boton_actualizar.setEnabled(false);
        vaf.boton_eliminar.setEnabled(false);;

    }

    public void desbloquear() {
        //Textos
        vaf.text_id_area_falla.setEnabled(false);
        vaf.text_id_tipo_falla.setEnabled(false);
        vaf.text_nombre.setEnabled(true);
        vaf.text_descripcion.setEnabled(true);
        //Botones
        vaf.boton_nuevo.setEnabled(false);
        vaf.boton_cancelar.setEnabled(true);
        vaf.boton_guardar.setEnabled(true);
        vaf.boton_actualizar.setEnabled(false);
        vaf.boton_eliminar.setEnabled(false);;

    }
    
        public void desbloqueardos() {
        //Textos
        vaf.text_id_area_falla.setEnabled(false);
        vaf.text_id_tipo_falla.setEnabled(false);
        
        vaf.text_nombre.setEnabled(true);
        vaf.text_descripcion.setEnabled(true);
        //Botones
        vaf.boton_nuevo.setEnabled(false);
        vaf.boton_cancelar.setEnabled(true);
        vaf.boton_guardar.setEnabled(false);
        vaf.boton_actualizar.setEnabled(true);
        vaf.boton_eliminar.setEnabled(false);;

    }

    public void inicia() {
        vaf.setTitle("Nueva Area de Falla");
        vaf.setLocationRelativeTo(null);
        vaf.text_id_tipo_falla.setEnabled(false);
        vaf.text_id_area_falla.setEnabled(false);

        //-------------------------------------------
        //-------------------------------------------
        bloquear();
        listarTiposFalla(vaf.combo_tipo_falla);
        vaf.setVisible(true);//Se vuelve visible

    }

}
