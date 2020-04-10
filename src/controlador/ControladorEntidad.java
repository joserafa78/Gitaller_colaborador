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
import modelo.Fabricante;
import modelo.FabricanteDAO;
import modelo.LineaProducto;
import modelo.LineaProductoDAO;
import modelo.Modelo;
import modelo.ModeloDAO;
import modelo.TipoFalla;
import modelo.Version;
import modelo.VersionDAO;
import vistas.VistaContenido;
import vistas.VistaEntidad;

public class ControladorEntidad implements ActionListener {
    //Variables de la Clase


    VistaEntidad ve = new VistaEntidad();
    
    VistaContenido vc=new VistaContenido();
    Fabricante f = new Fabricante();
    FabricanteDAO fdao = new FabricanteDAO();
    LineaProductoDAO lpdao = new LineaProductoDAO();

    ModeloDAO mdao = new ModeloDAO();
    VersionDAO vdao = new VersionDAO();
    DefaultComboBoxModel modelocombo = null;

    //Metodo Constructor
    public ControladorEntidad(VistaEntidad ve) {
        this.ve = ve;
        //Botones
        ve.boton_envia_fabricante.addActionListener(this);
        ve.boton_envia_liena_producto.addActionListener(this);
        ve.boton_envia_modelo.addActionListener(this);
        ve.boton_envia_version.addActionListener(this);

        //Combobox
        ve.combo_fabricante.addActionListener(this);
        ve.combo_linea_producto.addActionListener(this);
        ve.combo_modelo.addActionListener(this);
        ve.combo_version.addActionListener(this);
    }

    //Metodo para mostrar en ComboBox Todos los Fabricantes
    public void listarFabricante(JComboBox combo) { //JComboBox combo
        Vector<Fabricante> lista = fdao.listar();
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }
    //Metodo para mostrar en ComboBox Todos LInea de Producto Segun Fabricante

    public void listarLineaProducto(JComboBox combo) { //JComboBox combo
        Vector<LineaProducto> lista = lpdao.listar(Integer.parseInt(ve.text_id_fabricante.getText()));
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }
    //Metodo para mostrar en ComboBox Todos los Medolos Segun Linea de Producto

    public void listarModelo(JComboBox combo) { //JComboBox combo
        Vector<Modelo> lista = mdao.listar(Integer.parseInt(ve.text_id_linea_producto.getText()));
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }
    //Metodo para mostrar en ComboBox Todos las Versiones segun Modelo

    public void listarVersion(JComboBox combo) { //JComboBox combo
        Vector<Version> lista = vdao.listar(Integer.parseInt(ve.text_id_modelo.getText()));
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == ve.combo_fabricante) {//****Evento Oyente del ComboBox tipo Falla
            Fabricante fab = (Fabricante) ve.combo_fabricante.getSelectedItem();
            ve.text_id_fabricante.setText(String.valueOf(fab.getId()));
            ve.text_fabricante.setText(String.valueOf(fab.getNombre()));
            listarLineaProducto(ve.combo_linea_producto);
                        //---------------------------------------
            VistaContenido.fabricante_id= Integer.parseInt(ve.text_id_fabricante.getText())  ;
            VistaContenido.lineaproducto_id=0;
            VistaContenido.modelo_id=0;
            VistaContenido.Version_id=0;

        }
        
           if (e.getSource() == ve.combo_linea_producto) {//****Evento Oyente del ComboBox tipo Falla
            LineaProducto lineap = (LineaProducto) ve.combo_linea_producto.getSelectedItem();
            ve.text_id_linea_producto.setText(String.valueOf(lineap.getId()));
              ve.text_linea_producto.setText(String.valueOf(lineap.getNombre()));
            listarModelo(ve.combo_modelo);
            //---------------------------------------
            VistaContenido.fabricante_id= Integer.parseInt(ve.text_id_fabricante.getText())  ;
            VistaContenido.lineaproducto_id=Integer.parseInt(ve.text_id_linea_producto.getText());
            VistaContenido.modelo_id=0;
            VistaContenido.Version_id=0;

        }
           if (e.getSource() == ve.combo_modelo) {//****Evento Oyente del ComboBox Modelo
            Modelo mod = (Modelo) ve.combo_modelo.getSelectedItem();
            ve.text_id_modelo.setText(String.valueOf(mod.getId()));
            ve.text_modelo.setText(String.valueOf(mod.getNombre_comercial()));
            listarVersion(ve.combo_version);
            //---------------------------------------
            VistaContenido.fabricante_id= Integer.parseInt(ve.text_id_fabricante.getText())  ;
            VistaContenido.lineaproducto_id=Integer.parseInt(ve.text_id_linea_producto.getText());
            VistaContenido.modelo_id=Integer.parseInt(ve.text_id_modelo.getText());
            VistaContenido.Version_id=0;
                   
    }
            if (e.getSource() == ve.combo_version) {//****Evento Oyente del ComboBox Version
            Version ver = (Version) ve.combo_version.getSelectedItem();
            ve.text_id_version.setText(String.valueOf(ver.getId()));
            ve.text_version.setText(String.valueOf(ver.getVersion()));
            //---------------------------------------
            VistaContenido.fabricante_id= Integer.parseInt(ve.text_id_fabricante.getText())  ;
            VistaContenido.lineaproducto_id=Integer.parseInt(ve.text_id_linea_producto.getText());
            VistaContenido.modelo_id=Integer.parseInt(ve.text_id_modelo.getText());
            VistaContenido.Version_id=Integer.parseInt(ve.text_id_version.getText());
            
    }
//--------------------------------------------------------------------------------------------------
         if (e.getSource() == ve.boton_envia_fabricante) {//****Evento Oyente del Boton Fabricante           
        vc.text_id_entidad.setText(ve.text_id_fabricante.getText()); 
        
        vc.combo_entidad.setSelectedItem(ve.text_fabricante.getText());
        JOptionPane.showMessageDialog(ve, "Usted A Selecionado El Fabricante: ' "+ ve.text_fabricante.getText()+" '");
         ve.setVisible(false);              
        }
                  if (e.getSource() == ve.boton_envia_liena_producto) {//****Evento Oyente del Boton Linea
        vc.text_id_entidad.setText(ve.text_id_linea_producto.getText());  
        vc.combo_entidad.setSelectedItem(ve.text_linea_producto.getText());
        JOptionPane.showMessageDialog(ve, "Usted A Selecionado Liena de Producto: ' "+ ve.text_linea_producto.getText()+" '");
         ve.setVisible(false);   
        }
              if (e.getSource() == ve.boton_envia_modelo) {//****Evento Oyente del Boton Modelo
                  
        vc.text_id_entidad.setText(ve.text_id_modelo.getText());  
        vc.combo_entidad.setSelectedItem(ve.text_modelo.getText());
        JOptionPane.showMessageDialog(ve, "Usted A Selecionado el Modelo: ' "+ ve.text_modelo.getText()+" '");
         ve.setVisible(false);
        }
           if (e.getSource() == ve.boton_envia_version) {//****Evento Oyente del Boton version
        vc.text_id_entidad.setText(ve.text_id_version.getText());  
        vc.combo_entidad.setSelectedItem(ve.text_version.getText());
        JOptionPane.showMessageDialog(ve, "Usted A Selecionado la Version: ' "+ ve.text_version.getText()+" '");
         ve.setVisible(false);
        }        
            
    }
    
    public void visualizaFabriante() {
        ve.panel_fabricante.setVisible(true);
        ve.panel_linea_producto.setVisible(false);
        ve.panel_modelo.setVisible(false);
        ve.panel_version.setVisible(false);
        //Botones
        ve.boton_envia_fabricante.setVisible(true);
        ve.boton_envia_liena_producto.setVisible(false);
        ve.boton_envia_modelo.setVisible(false);
        ve.boton_envia_version.setVisible(false);
    }

    public void visualizaLineaProducto() {
        ve.panel_fabricante.setVisible(true);
        ve.panel_linea_producto.setVisible(true);
        ve.panel_modelo.setVisible(false);
        ve.panel_version.setVisible(false);
        //Botones
        ve.boton_envia_fabricante.setVisible(false);
        ve.boton_envia_liena_producto.setVisible(true);
        ve.boton_envia_modelo.setVisible(false);
        ve.boton_envia_version.setVisible(false);
    }

    public void visualizaModelo() {
        ve.panel_fabricante.setVisible(true);
        ve.panel_linea_producto.setVisible(true);
        ve.panel_modelo.setVisible(true);
        ve.panel_version.setVisible(false);
        //Botones
        ve.boton_envia_fabricante.setVisible(false);
        ve.boton_envia_liena_producto.setVisible(false);
        ve.boton_envia_modelo.setVisible(true);
        ve.boton_envia_version.setVisible(false);
    }

    public void visualizaVersion() {
        ve.panel_fabricante.setVisible(true);
        ve.panel_linea_producto.setVisible(true);
        ve.panel_modelo.setVisible(true);
        ve.panel_version.setVisible(true);
        //Botones
        ve.boton_envia_fabricante.setVisible(false);
        ve.boton_envia_liena_producto.setVisible(false);
        ve.boton_envia_modelo.setVisible(false);
        ve.boton_envia_version.setVisible(true);
    }

    public void inicia() {
        ve.setTitle("Asigna un Entidad al Contenido");
        ve.setLocationRelativeTo(null);
        ve.text_id_fabricante.setEnabled(false);
        ve.text_id_linea_producto.setEnabled(false);
        ve.text_id_modelo.setEnabled(false);
        ve.text_id_version.setEnabled(false);

        listarFabricante(ve.combo_fabricante);
        ve.setVisible(true);

    }

}
