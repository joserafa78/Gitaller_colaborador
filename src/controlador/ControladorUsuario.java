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
import modelo.Usuario;
import modelo.UsuarioDAO;
import vistas.VistaUsuario;

public class ControladorUsuario implements ActionListener {

    //Variables de la Clase
    VistaUsuario vu = new VistaUsuario();
    UsuarioDAO udao = new UsuarioDAO();
    Usuario u = new Usuario();
    DefaultTableModel modelo = new DefaultTableModel();

    //Constructor 
    public ControladorUsuario(VistaUsuario vu) {
        this.vu = vu;
        //Botones
        vu.boton_nuevo.addActionListener(this);
        vu.boton_cancelar.addActionListener(this);
        vu.boton_guardar.addActionListener(this);
           vu.boton_editar.addActionListener(this);
              vu.boton_actualizar.addActionListener(this);

    }

    public void listarUsuario(JTable table) {//Metodo que Carga de la lista de usuarios

        modelo = (DefaultTableModel) table.getModel();
        List<Usuario> lista = udao.listar();//Carga los datos del cla clase Usuario
        Object objeto[] = new Object[4]; //Crea un Arreglo tipo Objeto de 2 Elementos.

        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getCorreo();
            objeto[3] = lista.get(i).getUrl();

            modelo.addRow(objeto); //Agrega un Objeto tipo vector al modelo 

        }

        table.setModel(modelo);
        
        if (lista.size() > 0) {//Si la lista tiene Registros entonces habilita la Editicion
            vu.boton_editar.setEnabled(true);
        }else{
             vu.boton_editar.setEnabled(false);
        }
    }

    public void agregar() {
//1,vu.text_nombre.getText(),vu.text_correo.getText(),vu.text_url.getText()
        u = new Usuario(1, vu.text_nombre.getText(), vu.text_correo.getText(), vu.text_url.getText());
        int r = udao.agregar(u);// Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vu, "Usuario Agregado con Exito.");
            limpiar();
            bloquear();
            limpiarTabla();
            listarUsuario(vu.table);
        } else {
            JOptionPane.showMessageDialog(vu, "Error, Revisar");
        }

    }

    public void actualizar() {

        if (vu.text_id.getText().equals("")) {
            JOptionPane.showMessageDialog(vu, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {

            int id = Integer.parseInt(vu.text_id.getText());
            String nombre = vu.text_nombre.getText();
            String correo = vu.text_correo.getText();
            String url = vu.text_url.getText();
            u = new Usuario(id, nombre, correo, url);

            int r = udao.actualizar(u);
            if (r == 1) {

                JOptionPane.showMessageDialog(vu, "Usuario Actualizado con Exito.");
                limpiar();
                limpiarTabla();
                listarUsuario(vu.table);
                bloquear();
            } else {

                JOptionPane.showMessageDialog(vu, "Error");

            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vu.boton_nuevo) {
            limpiar();
            desbloquear();
        }

        if (e.getSource() == vu.boton_cancelar) {
            limpiar();
            bloquear();
        }
        if (e.getSource() == vu.boton_guardar) {
            agregar();
        }
        if (e.getSource() == vu.boton_editar) {
            int fila = vu.table.getSelectedRow(); //Debe haber Selecionado una Fila en la Tabla
            if (fila == -1) {

                JOptionPane.showMessageDialog(vu, "Debe Seleciconar Una Fila de La Tabla.");

            } else {
                //Pasa los Datos de la Tabla a cada uno de los Textx.
                String id = vu.table.getValueAt(fila, 0).toString(); //Seleciona fila y columan 0
                String nombre = (String) vu.table.getValueAt(fila, 1);
                String correo = (String) vu.table.getValueAt(fila, 2);
                String url = (String) vu.table.getValueAt(fila, 3);
                //pasa a Vista
                vu.text_id.setText(id);
                vu.text_nombre.setText(nombre);
                vu.text_correo.setText(correo);
                vu.text_url.setText(url);
                desbloqueardos();

            }
        }
        
                if (e.getSource() == vu.boton_actualizar) {
            actualizar();
        }

    }

    public void limpiar() {
        vu.text_id.setText("");
        vu.text_nombre.setText("");
        vu.text_correo.setText("");
        vu.text_url.setText("");
        //limpiarTable();

    }

    void limpiarTabla() {
        for (int i = 0; i < vu.table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void bloquear() {
        vu.text_id.setEnabled(false);
        vu.text_nombre.setEnabled(false);
        vu.text_correo.setEnabled(false);
        vu.text_url.setEnabled(false);

        vu.boton_nuevo.setEnabled(true);
        vu.boton_cancelar.setEnabled(false);
        vu.boton_guardar.setEnabled(false);
        vu.boton_actualizar.setEnabled(false);
        vu.boton_eliminar.setEnabled(false);

    }

    public void bloqueoTotal() {
        vu.text_id.setEnabled(false);
        vu.text_nombre.setEnabled(false);
        vu.text_correo.setEnabled(false);
        vu.text_url.setEnabled(false);

        vu.boton_nuevo.setEnabled(true);
        vu.boton_cancelar.setEnabled(false);
        vu.boton_guardar.setEnabled(false);
        vu.boton_actualizar.setEnabled(false);
        vu.boton_eliminar.setEnabled(false);
        vu.boton_editar.setEnabled(false);

    }

    public void desbloquear() {
        vu.text_id.setEnabled(false);
        vu.text_nombre.setEnabled(true);
        vu.text_correo.setEnabled(true);
        vu.text_url.setEnabled(true);

        vu.boton_nuevo.setEnabled(false);
        vu.boton_cancelar.setEnabled(true);
        vu.boton_guardar.setEnabled(true);
        vu.boton_actualizar.setEnabled(false);
        vu.boton_eliminar.setEnabled(false);

    }

    public void desbloqueardos() {
        vu.text_id.setEnabled(false);
        vu.text_nombre.setEnabled(true);
        vu.text_correo.setEnabled(true);
        vu.text_url.setEnabled(true);

        vu.boton_nuevo.setEnabled(false);
        vu.boton_cancelar.setEnabled(true);
        vu.boton_guardar.setEnabled(false);
        vu.boton_actualizar.setEnabled(true);
        vu.boton_eliminar.setEnabled(true);
        vu.boton_editar.setEnabled(true);

    }

    public void inicia() {
        vu.setTitle(" Usuarios ");
        vu.setLocationRelativeTo(null);
        vu.text_id.setEnabled(false);

        //-------------------------------------------
        bloqueoTotal();
        listarUsuario(vu.table);
        vu.setVisible(true);//Se vuelve visible

    }

}
