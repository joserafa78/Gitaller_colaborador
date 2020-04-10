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
import modelo.Falla;
import modelo.FallaDAO;
import modelo.TipoFalla;
import modelo.TipoFallaDAO;
import vistas.VistaAreaFalla;
import vistas.VistaFalla;
import vistas.VistaTipoFalla;

public class ControladorFalla implements ActionListener {

    //Variables de la Clase
    VistaFalla vf = new VistaFalla();
    TipoFallaDAO tfdao = new TipoFallaDAO();
    AreaFallaDAO afdao = new AreaFallaDAO();
    Falla f = new Falla();
    FallaDAO fdao = new FallaDAO();
    DefaultComboBoxModel modelocombo = null;
    DefaultTableModel modelo = new DefaultTableModel();

    //Constructor   
    public ControladorFalla(VistaFalla vf) {
        this.vf = vf;
        //Botones
        vf.boton_nuevo.addActionListener(this);
        vf.boton_cancelar.addActionListener(this);
        vf.boton_guardar.addActionListener(this);
        vf.boton_editar.addActionListener(this);
        vf.boton_actualizar.addActionListener(this);
        vf.boton_tipo_falla.addActionListener(this);
        vf.boton_area_falla.addActionListener(this);

        //Combobox.
        vf.combo_tipo_falla.addActionListener(this);
        vf.combo_area_falla.addActionListener(this);
    }
    //Metodo para mostrar en ComboBox Todos los Tipos de Fallas

    public void listarTiposFalla(JComboBox combo) { //JComboBox combo
        Vector<TipoFalla> lista = tfdao.listar();
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }

    //Metodo para mostrar en ComboBox Todas la Areas de Fallas
    public void listarAreaFalla(JComboBox combo) { //JComboBox combo
        Vector<AreaFalla> lista = afdao.listar(Integer.parseInt(vf.text_id_tipo_falla.getText()));
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }

    public void listarFalla(JTable table) {//Metodo que Carga de la lista las fallas

        modelo = (DefaultTableModel) table.getModel();
        int id_v = Integer.parseInt(vf.text_id_area_falla.getText());
        List<Falla> lista = fdao.listar(id_v);//Carga los datos del cla clase Falla a la LISTA
        Object objeto[] = new Object[6]; //Crea un Arreglo tipo Objeto de 2 Elementos.

        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getCodigo();
            objeto[2] = lista.get(i).getNombre();
            objeto[3] = lista.get(i).getDescripcion();
            objeto[4] = lista.get(i).getAplica_a();       
            objeto[5] = lista.get(i).getArea_falla_id();

            modelo.addRow(objeto); //Agrega un Objeto tipo vector al modelo 
        }
        table.setModel(modelo);

    }

    public void Agregar() {

        f = new Falla(1, vf.text_codigo.getText(), vf.text_nombre.getText(), vf.text_descripcion.getText(),
               Integer.parseInt(vf.text_aplica_a.getText()) ,Integer.parseInt(vf.text_id_area_falla.getText()));

        int r = fdao.agregar(f);// Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vf, " Falla Agregada con Exito.");
            limpiar();
            limpiarTabla();
            listarFalla(vf.table);
            bloquear();
        } else {
            JOptionPane.showMessageDialog(vf, "Error, Revisar");
        }

    }

    public void actualizar() {

        if (vf.text_id_falla.getText().equals("")) {
            JOptionPane.showMessageDialog(vf, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {

            int id = Integer.parseInt(vf.text_id_falla.getText());
            String codigo = vf.text_codigo.getText();
            String nombre = vf.text_nombre.getText();
            String descripcion = vf.text_descripcion.getText();
            int aplica=Integer.parseInt(vf.text_aplica_a.getText());
            int id_area_falla = Integer.parseInt(vf.text_id_area_falla.getText());
            f = new Falla(id, codigo, nombre, descripcion, aplica,id_area_falla);
            int r = fdao.actualizar(f);
            if (r == 1) {

                JOptionPane.showMessageDialog(vf, "Falla Actualizada con Exito.");
                limpiar();
                limpiarTabla();
                listarFalla(vf.table);
                bloquear();
            } else {

                JOptionPane.showMessageDialog(vf, "Error");

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vf.combo_tipo_falla) {//****Evento Oyente del ComboBox tipo Falla
            TipoFalla tipof = (TipoFalla) vf.combo_tipo_falla.getSelectedItem();
            vf.text_id_tipo_falla.setText(String.valueOf(tipof.getId()));
            vf.combo_tipo_falla.removeAll();//Limpia el combo        
            listarAreaFalla(vf.combo_area_falla);

        }

        if (e.getSource() == vf.combo_area_falla) {//****Evento Oyente del ComboBox tipo Falla
            AreaFalla areaf = (AreaFalla) vf.combo_area_falla.getSelectedItem();
            vf.text_id_area_falla.setText(String.valueOf(areaf.getId()));
            bloquear();
            limpiarTabla();
            listarFalla(vf.table);
        }

        if (e.getSource() == vf.boton_nuevo) {//****Evento Oyente del Boton Nuevo
            limpiar();
            desbloquear();
        }
        if (e.getSource() == vf.boton_cancelar) {//****Evento Oyente del Boton Nuevo
            limpiar();
            bloquear();
        }
        if (e.getSource() == vf.boton_guardar) {//****Evento Oyente del Boton Nuevo            
            Agregar();
        }
        if (e.getSource() == vf.boton_editar) {//****Evento Oyente del Boton Nuevo            
            int fila = vf.table.getSelectedRow(); //Debe haber Selecionado una Fila en la Tabla
            if (fila == -1) {
                JOptionPane.showMessageDialog(vf, "Debe Seleciconar Una Fila de La Tabla.");
            } else {
                //Pasa los Datos de la Tabla a cada uno de los Textx.
                String id = vf.table.getValueAt(fila, 0).toString(); //Seleciona fila y columan 0
                String codigo = (String) vf.table.getValueAt(fila, 1);
                String nombre = (String) vf.table.getValueAt(fila, 2);               
                String descripcion = (String) vf.table.getValueAt(fila, 3);
                String aplica =  vf.table.getValueAt(fila, 4).toString();
                //String id_area_falla = vf.table.getValueAt(fila, 4).toString();
                //pasa a Vista

                vf.text_id_falla.setText(id);
                vf.text_codigo.setText(codigo);
                vf.text_nombre.setText(nombre);                
                vf.text_descripcion.setText(descripcion);
                vf.text_aplica_a.setText(aplica);
                //vf.text_id_area_falla.setText(id_area_falla);
                desbloquearDos();
           
            }
        }

        if (e.getSource() == vf.boton_actualizar) {//****Evento Oyente del Boton Nuevo            
            actualizar();
        }

        if (e.getSource() == vf.boton_tipo_falla) {//****Evento Oyente del Boton Nuevo            
            VistaTipoFalla vtf = new VistaTipoFalla();
            ControladorTipoFalla ctf = new ControladorTipoFalla(vtf);
            ctf.inicia();
        }
        if (e.getSource() == vf.boton_area_falla) {//****Evento Oyente del Boton Nuevo            
            VistaAreaFalla vaf = new VistaAreaFalla();
            ControladorAreaFalla ctf = new ControladorAreaFalla(vaf);
            ctf.inicia();
        }

    }

    public void limpiar() {
        vf.text_codigo.setText("");
        vf.text_descripcion.setText("");
        vf.text_id_falla.setText("");
        vf.text_nombre.setText("");
    }

    void limpiarTabla() {
        for (int i = 0; i < vf.table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void bloquear() {
        vf.text_codigo.setEnabled(false);
        vf.text_descripcion.setEnabled(false);
        vf.text_id_falla.setEnabled(false);
        vf.text_nombre.setEnabled(false);

        vf.boton_nuevo.setEnabled(true);
        vf.boton_cancelar.setEnabled(false);
        vf.boton_guardar.setEnabled(false);
        vf.boton_actualizar.setEnabled(false);
        vf.boton_eliminar.setEnabled(false);
        vf.boton_editar.setEnabled(true);
        
         
    }

    public void bloquearTotal() {
        vf.text_codigo.setEnabled(false);
        vf.text_descripcion.setEnabled(false);
        vf.text_id_falla.setEnabled(false);
        vf.text_nombre.setEnabled(false);

        vf.boton_nuevo.setEnabled(false);
        vf.boton_cancelar.setEnabled(false);
        vf.boton_guardar.setEnabled(false);
        vf.boton_actualizar.setEnabled(false);
        vf.boton_eliminar.setEnabled(false);
        vf.boton_editar.setEnabled(false);
        
      
    }

    public void desbloquear() {
        vf.text_id_falla.setEnabled(false);
        vf.text_codigo.setEnabled(true);
        vf.text_descripcion.setEnabled(true);

        vf.text_nombre.setEnabled(true);

        vf.boton_nuevo.setEnabled(false);
        vf.boton_cancelar.setEnabled(true);
        vf.boton_guardar.setEnabled(true);
        vf.boton_actualizar.setEnabled(false);
        vf.boton_eliminar.setEnabled(false);

    }

    public void desbloquearDos() {
        vf.text_id_falla.setEnabled(false);
        vf.text_codigo.setEnabled(true);
        vf.text_descripcion.setEnabled(true);
        vf.text_nombre.setEnabled(true);

        vf.boton_nuevo.setEnabled(false);
        vf.boton_cancelar.setEnabled(true);
        vf.boton_guardar.setEnabled(false);
        vf.boton_actualizar.setEnabled(true);
        vf.boton_eliminar.setEnabled(false);

    }

    public void inicia() {
        vf.setTitle(" Fallas ");
        vf.setLocationRelativeTo(null);
        vf.text_id_tipo_falla.setEnabled(false);
        vf.text_id_area_falla.setEnabled(false);
        vf.text_id_falla.setEnabled(false);
      

        //-------------------------------------------
        bloquearTotal();
        listarTiposFalla(vf.combo_tipo_falla);
        vf.setVisible(true);//Se vuelve visible

    }

}
