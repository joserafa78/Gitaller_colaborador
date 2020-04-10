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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.AreaFalla;
import modelo.AreaFallaDAO;
import modelo.Falla;
import modelo.FallaDAO;
import modelo.TipoFalla;
import modelo.TipoFallaDAO;
import vistas.VistaContenido;
import vistas.VistaTipoAporte;

/**
 *
 * @author naila
 */
public class ControladorTipoAporte implements ActionListener {
//Variables de la Clase

    VistaTipoAporte vtp = new VistaTipoAporte();
    VistaContenido vc = new VistaContenido();
    TipoFallaDAO tfdao = new TipoFallaDAO();
    AreaFallaDAO afdao = new AreaFallaDAO();
    FallaDAO fdao = new FallaDAO();

    //Mas Variables
    DefaultComboBoxModel modelocombo = null;

    //Metodo Constructor   
    public ControladorTipoAporte(VistaTipoAporte vtp) {
        this.vtp = vtp;
        //Botones
        vtp.boton_envia_falla.addActionListener(this);
        //Combobox
        vtp.combo_tipo_falla.addActionListener(this);
        vtp.combo_area_falla.addActionListener(this);
        vtp.combo_falla.addActionListener(this);
    }

    //Metodo para mostrar en ComboBox Todos los tipos de Fallas Registrados
    public void listarTipoFalla(JComboBox combo) { //JComboBox combo
        Vector<TipoFalla> lista = tfdao.listar();
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);
    }

    //Metodo para mostrar en ComboBox Todas la Areas de Fallas Segun los tipos
    public void listarAreaFalla(JComboBox combo) { //JComboBox combo
        Vector<AreaFalla> lista = afdao.listar(Integer.parseInt(vtp.text_id_tipo_falla.getText()));
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }
    //Metodo para mostrar en ComboBox Todas la Fallas Segun el Area

    public void listarFalla(JComboBox combo) { //JComboBox combo
        Vector<Falla> lista = fdao.listar(Integer.parseInt(vtp.text_id_area_falla.getText()));
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vtp.combo_tipo_falla) {//****Evento Oyente del ComboBox tipo Falla
            TipoFalla tipof = (TipoFalla) vtp.combo_tipo_falla.getSelectedItem();
            vtp.text_id_tipo_falla.setText(String.valueOf(tipof.getId()));
            vtp.text_nombre_tipo_falla.setText(String.valueOf(tipof.getNombre()));
            listarAreaFalla(vtp.combo_area_falla);
        }
        if (e.getSource() == vtp.combo_area_falla) {//****Evento Oyente del ComboBox area Falla
            AreaFalla areaf = (AreaFalla) vtp.combo_area_falla.getSelectedItem();
            vtp.text_id_area_falla.setText(String.valueOf(areaf.getId()));
            vtp.text_nombre_area_falla.setText(String.valueOf(areaf.getNombre()));
            listarFalla(vtp.combo_falla);
        }

        if (e.getSource() == vtp.combo_falla) {//****Evento Oyente del ComboBox  Falla
            Falla fal = (Falla) vtp.combo_falla.getSelectedItem();
            vtp.text_id_falla.setText(String.valueOf(fal.getId()));
            vtp.text_nombre__falla.setText(String.valueOf(fal.getNombre()));

        }
        //--------------------------------------------------------------------------------------------------
         if (e.getSource() == vtp.boton_envia_falla) {//****Evento Oyente del Boton Envia Falla           
        vc.text_id_aporte.setText(vtp.text_id_falla.getText()); 
        vc.area_falla= Integer.parseInt(vtp.text_id_area_falla.getText());//Envia el Valor "Ara Falla" a la variable
        vc.tipo_falla=Integer.parseInt(vtp.text_id_tipo_falla.getText());
     
        JOptionPane.showMessageDialog(vtp, "Usted A Selecionado la Falla: ' " 
                + vtp.text_nombre__falla.getText()+" '"+"Area y Tipo: "+ vc.area_falla+" - "+vc.tipo_falla);
         vtp.setVisible(false);              
       }

    }

    public void inicia() {
        vtp.setTitle("Asigna un Falla al Contenido");
        vtp.setLocationRelativeTo(null);
        vtp.boton_envia_tipo_falla.setEnabled(false);
        vtp.boton_envia_area_falla.setEnabled(false);
        vtp.boton_envia_falla.setEnabled(true);

        listarTipoFalla(vtp.combo_tipo_falla);
        vtp.setVisible(true);

    }

}
