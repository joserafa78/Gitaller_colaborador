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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Fabricante;
import modelo.LineaProducto;
import modelo.LineaProductoDAO;
import modelo.Modelo;
import modelo.ModeloDAO;
import modelo.Version;
import modelo.VersionDAO;
import vistas.VistaFabricante;
import vistas.VistaLineaProducto;
import vistas.VistaModelo;

public class ControladorModelo implements ActionListener {
//Variable de la Clase   

    Modelo m = new Modelo();
    Version v = new Version();
    VersionDAO vdao = new VersionDAO();
    VistaModelo vm = new VistaModelo();
    ModeloDAO mdao = new ModeloDAO();
    LineaProductoDAO lpdao = new LineaProductoDAO();
    Fabricante f = new Fabricante();
    DefaultComboBoxModel modelocombo = null;
    //-----------------------------------------------
    private ArrayList< JLabel> listaLabel;
    private ArrayList<JTextField> listaModelo;
    private ArrayList<JTextField> listaNombre;
    private ArrayList<JComboBox> listaComboBoxCapacidad;
    private ArrayList<JComboBox> listaComboBoxDualSim;
    private ArrayList<JButton> listaBotonAgregar;
     private ArrayList<JButton> listaBotonModificar;
    private int indice;

//Metodo Constructor            
    public ControladorModelo(VistaModelo vm) {
        this.vm = vm;
        //COMBOBOX
        vm.cbx_fabricantes.addActionListener(this);
        vm.cbx_linea_procto.addActionListener(this);
        vm.cbx_modelos.addActionListener(this);
        vm.cbx_cantidad_version.addActionListener(this);

        //BOTONES
        vm.boton_Fabricante.addActionListener(this);
        vm.boton_linea_producto.addActionListener(this);
        vm.boton_editar.addActionListener(this);
        vm.boton_nuevo.addActionListener(this);
        vm.boton_guardar.addActionListener(this);
        vm.boton_cancelar.addActionListener(this);
        vm.boton_actualizar.addActionListener(this);
        vm.boton_eliminar.addActionListener(this);

    }

    //Metodo para mostrar en ComboBox Todos los Fabricantes Registrados
    public void listarFabriantes(JComboBox combo) { //JComboBox combo
        Vector<Fabricante> lista = lpdao.listarFabricante();
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }

    //Metodo para mostrar en ComboBox Linea de Productos Segun Fabricante Selecionado
    public void listarLineaProducto(JComboBox combo) {//Metodo que Carga de la lista Calse DAO Y O ENVIA al Modelo
        int id_v = Integer.parseInt(vm.text_id_fabricante.getText());
        Vector<LineaProducto> lista = lpdao.listar(id_v);// POR QUI ESTA EL ERROR          
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);
    }

    //Metodo para mostrar en ComboBox Modelos Segun Linea de Productos
    public void listarModelo(JComboBox combo) {//Metodo que Carga de la lista 
        int id_v = Integer.parseInt(vm.text_id_lineaproducto.getText());
        Vector< Modelo> lista = mdao.listar(id_v); //lpdao.listar(id_v);// PENDIENTE         
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);

    }

    //Agrear Registro a Modelo
    public void add() {
        int v=validaCampoVersion();
      if (v==1){
      JOptionPane.showMessageDialog(vm, "Error. Falta Cargar campo en Area Version");
      } else{
        //------------------------------------------------------------------------------
        m = new Modelo();
        m.setNombreOficial(vm.text_nombre_comercial.getText());
        m.setNombre_comercial(String.valueOf(vm.text_nombre_comercial.getText()));
        m.setAnioLanza(Integer.parseInt(vm.text_anio_lanza.getText()));

        if (vm.cbx_es_plus.getSelectedItem() == "No Plus") {
            m.setEsPlus(0);
        }
        if (vm.cbx_es_plus.getSelectedItem() == "Es Plus") {
            m.setEsPlus(1);
        }
        m.setId_lineaProducto(Integer.parseInt(vm.text_id_lineaproducto.getText()));
        //------------------------------------------------------------------------------- 
        int r = mdao.agregar(m); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
        if (r == 1) {
            JOptionPane.showMessageDialog(vm, "Modelo Agregado con Exito.");
            addVersion();//Llama al metodo para cargar las versiones del medelo
            limpiar();
        } else {
            JOptionPane.showMessageDialog(vm, "Error, Revisar");
        }
        
      }  
    }

    //Agrega las Versiones por cada modelo 
    public void addVersion() {
        //----------------------
        int registroUltimo = mdao.muestraUltimoRegistroModelo();
        int cant;
        int id_modelo;
        String version;
        String nombre;
        int capacidad;
        String sim_v;
        int simCard = 0;
        //---------------------
        cant = Integer.parseInt(vm.cbx_cantidad_version.getSelectedItem().toString());//Captura el Valor

        for (int i = 0; i < cant; i++) {
            version = listaModelo.get(i).getText();
            nombre=listaNombre.get(i).getText();
          
            capacidad = Integer.parseInt(listaComboBoxCapacidad.get(i).getSelectedItem().toString());
            sim_v = listaComboBoxDualSim.get(i).getSelectedItem().toString();//Sim Card   Dual Sim 
            if (sim_v == "Sim Card") {
                simCard = 0;
            }
            if (sim_v == "Dual Sim") {
                simCard = 1;
            }
            id_modelo = registroUltimo;

            //--------------------------------------------------------------------- ---------
            v = new Version();
            v.setId(i);
            v.setVersion(version);
            v.setNombre(nombre);
            v.setCapacidad(capacidad);
            v.setEsDualSim(simCard);
            v.setModelo_id(id_modelo);
 
            //------------------------------------------------------------------------------- 
            int r = vdao.agregar(v); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
            if (r == 1) {
                JOptionPane.showMessageDialog(vm, "Modelo Agregado con Exito el (" + i + ") Registro");
                //limpiar();
            } else {
                JOptionPane.showMessageDialog(vm, "Error, Revisar");
            }
        }
    }
    
    public int validaCampoVersion(){
            //----------------------
        int resul=0;
        int cant;
        int id_modelo;
        String version;
        String nombre;
        int capacidad;
        String sim_v;
        int simCard = 0;
        //---------------------
        cant = Integer.parseInt(vm.cbx_cantidad_version.getSelectedItem().toString());//Captura el Valor

        for (int i = 0; i < cant; i++) {
            //version = listaModelo.get(i).getText();
            //nombre=listaNombre.get(i).getText();         
            //capacidad = Integer.parseInt(listaComboBoxCapacidad.get(i).getSelectedItem().toString());        
            sim_v = listaComboBoxDualSim.get(i).getSelectedItem().toString();//Sim Card   Dual Sim 
  //--------------------------------------------------------------------- ---------        
            if(listaModelo.get(i).equals("")){
                resul=1;
            }
            if(listaNombre.get(i).equals("")){
                resul=1;
            }
             if(sim_v.equals("")){
                resul=1;
            }
            if(listaComboBoxCapacidad.get(i).getSelectedItem().toString().equals("")){
                resul=1;
            }

 //------------------------------------------------------------------------------- 

        }
    return resul;
    }

    public void agregaVersion() {
        if (vm.text_id_modelo.equals("")) {//Valida que exita el id modelo
            JOptionPane.showMessageDialog(vm, "Falta asignar el Modelo, no se puede Agregar");
        } else {
            //----------------------
            int registroUltimo = Integer.parseInt(vm.text_id_modelo.getText());
            int cant;
            int id_modelo;
            String version;
            String nombre;
            int capacidad;
            String sim_v;
            int simCard = 0;
            //---------------------
            cant = 1;

            for (int i = 0; i < cant; i++) {
                version = listaModelo.get(i).getText();
                nombre= listaNombre.get(i).getText();
                capacidad = Integer.parseInt(listaComboBoxCapacidad.get(i).getSelectedItem().toString());
                sim_v = listaComboBoxDualSim.get(i).getSelectedItem().toString();//Sim Card   Dual Sim 
                if (sim_v == "Sim Card") {
                    simCard = 0;
                }
                if (sim_v == "Dual Sim") {
                    simCard = 1;
                }
                id_modelo = registroUltimo;

                //--------------------------------------------------------------------- ---------
                v = new Version();
                v.setId(i);
                v.setVersion(version);
                v.setNombre(nombre);
                v.setCapacidad(capacidad);
                v.setEsDualSim(simCard);
                v.setModelo_id(id_modelo);

                //------------------------------------------------------------------------------- 
                int r = vdao.agregar(v); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
                if (r == 1) {
                    JOptionPane.showMessageDialog(vm, "Version con Exito el (" + i + ") Registro");
                    limpiaObjetoVersion();
                } else {
                    JOptionPane.showMessageDialog(vm, "Error, Revisar");
                }
            }
        }
    }

    public void listarVersiones() {
        if (vm.text_id_modelo.getText() != "") {  //Si el Text es distinto de Vacio  Busca 
            int id_v = Integer.parseInt(vm.text_id_modelo.getText());
            limpiaObjetoVersion();//Metodo para limpiar
            Vector< Version> listaVersiones = vdao.listar(id_v);
            //-----------------------------------------------------------
            boolean agregar = false;

            for (int i = 0; i < listaVersiones.size(); i++) {
                int id=listaVersiones.get(i).getId();
                String ver = listaVersiones.get(i).getVersion();
                String nom= listaVersiones.get(i).getNombre();              
                String cap = String.valueOf(listaVersiones.get(i).getCapacidad());
                int Sim = listaVersiones.get(i).getEsDualSim();
                String SimCard = "";
                if (Sim == 1) {
                    SimCard = "Dual Sim";
                }
                if (Sim == 0) {
                    SimCard = "Sin Card";
                }
                //------------------------------------------------------------------------    
                if (i == listaVersiones.size() - 1) {//Cuando el valor de (i) llegal ya al ultimo Registro manda a colocar el boton
                    agregar = true;
                }
                
                creaObjetoVersion(String.valueOf(id) ,ver, nom,cap, SimCard, agregar, "Crea (1)Campo");
                //------------------------------------------------------------------------      
            }
        }
        //creaObjetoVersion(Modelo, Capacidad, SimCard);
    }

    //Actualiza un registro de la linea de Modelo
    public void actualizar() {

        if (vm.text_id_modelo.getText().equals("")) {
            JOptionPane.showMessageDialog(vm, "No se Identifica el Id. debe selecionar la opcion Editar");
        } else {

            //------------------------------------------------------------------------------
            m = new Modelo();
            m.setId(Integer.parseInt(vm.text_id_modelo.getText()));
            m.setNombreOficial(vm.text_nombre_oficial.getText());
            m.setNombre_comercial(String.valueOf(vm.text_nombre_comercial.getText()));
            m.setAnioLanza(Integer.parseInt(vm.text_anio_lanza.getText()));
            if (vm.cbx_es_plus.getSelectedItem() == "No Plus") {
                m.setEsPlus(0);
            }
            if (vm.cbx_es_plus.getSelectedItem() == "Es Plus") {
                m.setEsPlus(1);
            }
            m.setId_lineaProducto(Integer.parseInt(vm.text_id_lineaproducto.getText()));
            //------------------------------------------------------------------------------- 

            int r = mdao.actualizar(m);
            if (r == 1) {
                JOptionPane.showMessageDialog(vm, "Modelo Actualizada con Exito.");
                limpiar();
                bloquea();
            } else {
                JOptionPane.showMessageDialog(vm, "Error");

            }

        }

    }
    
    public void actualizarVersion(Version v){
  

            int r = vdao.actualizar(v);//mdao.actualizar(m);
            if (r == 1) {
                JOptionPane.showMessageDialog(vm, "Version se Actualizada con Exito.");
                //limpiar();
               // bloquea();
            } else {
                JOptionPane.showMessageDialog(vm, "Error");

            }

       
    
    }

    public void eliminar() {

        if (vm.text_id_modelo.getText().equals("")) {
            JOptionPane.showMessageDialog(vm, "Debe Seleccionar un modelo a Eliminar...!!!");
        } else {

            int id_v = Integer.parseInt(vm.text_id_modelo.getText());
            mdao.eliminar(id_v);
            JOptionPane.showMessageDialog(vm, "La Linea de Producto se ha Eliminado...!!!");
            //limpiar();
            //limpiarTabla();
            //bloquear();
            //listar(vlp.table);
        }
    }

    //Implementa Metodos de Accion.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vm.cbx_fabricantes) {//****Evento Oyente del ComboBox Fabricante
            Fabricante fabri = (Fabricante) vm.cbx_fabricantes.getSelectedItem();
            vm.text_id_fabricante.setText(String.valueOf(fabri.getId()));
            listarLineaProducto(vm.cbx_linea_procto);//Metodo para cargar la alista de Productos.
        }

        if (e.getSource() == vm.cbx_linea_procto) {//****Evento Oyente del ComboBox Linea Producto
            LineaProducto lineap = (LineaProducto) vm.cbx_linea_procto.getSelectedItem();
            vm.text_id_lineaproducto.setText(String.valueOf(lineap.getId()));
            listarModelo(vm.cbx_modelos);

        }
        if (e.getSource() == vm.cbx_modelos) {//****Evento Oyente del ComboBox Modelos
            Modelo mod = (Modelo) vm.cbx_modelos.getSelectedItem();
            vm.text_id_modelo.setText(String.valueOf(mod.getId()));
            listarVersiones();//Metodo para Mostrar la Versiones del Modelo
        }
        if (e.getSource() == vm.cbx_cantidad_version) {//****Evento Oyente del ComboBox Cant Version
            limpiaObjetoVersion();
            int i = Integer.parseInt(vm.cbx_cantidad_version.getSelectedItem().toString());//Captura el Valor del Combobx Version

            for (int j = 0; j < i; j++) {
                creaObjetoVersion("Modelo","","", "", "", false, "");
            }

        }
        if (e.getSource() == vm.boton_guardar) {//****Evento Oyente Boton Guardar           
            add();
        }
        if (e.getSource() == vm.boton_Fabricante) {//****Evento Oyente Boton Fabricante 
            VistaFabricante vf = new VistaFabricante();
            ControladorFabricante cf = new ControladorFabricante(vf);
            cf.inicia();

        }
        if (e.getSource() == vm.boton_linea_producto) {//****Evento Oyente Boton Fabricante 
            VistaLineaProducto vlp = new VistaLineaProducto();
            ControladorLineaProducto clp = new ControladorLineaProducto(vlp);
            clp.inicia();

        }
        if (e.getSource() == vm.boton_editar) {//****Evento Oyente Boton Editar 
            Modelo m = (Modelo) vm.cbx_modelos.getSelectedItem();
            vm.text_id_modelo.setText(String.valueOf(m.getId()));
            
            vm.text_nombre_oficial.setText(m.getNombreOficial());
            vm.text_nombre_comercial.setText(m.getNombre_comercial());
            vm.text_anio_lanza.setText(String.valueOf(m.getAnioLanza()));
            if (m.getEsPlus() == 0) {
                vm.cbx_es_plus.setSelectedItem("No Plus");
            }
            if (m.getEsPlus() == 1) {
                vm.cbx_es_plus.setSelectedItem("Es Plus");
            }

            //vlp.cbx_gama.setSelectedItem(gama_v);
        }
        if (e.getSource() == vm.boton_nuevo) {//****Evento Oyente Boton Nuevo

            desbloquea();
        }
        if (e.getSource() == vm.boton_cancelar) {//****Evento Oyente Boton Cancelar 
            limpiar();
            bloquea();
        }
        if (e.getSource() == vm.boton_actualizar) {//****Evento Oyente Boton Actualizar
            actualizar();

        }
        if (e.getSource() == vm.boton_eliminar) {//****Evento Oyente Boton Eliminar
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea Elimiar el Registro Modelo?", "Mensaje de Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {//Respuesta es igual a Si = 0
                eliminar();
            }
        }

    }

    public void bloquea() {
        vm.text_nombre_comercial.setEnabled(false);
        vm.text_nombre_oficial.setEnabled(false);
        vm.text_anio_lanza.setEnabled(false);
        vm.cbx_es_plus.setEnabled(false);
        vm.cbx_cantidad_version.setEnabled(false);

    }

    public void desbloquea() {
        vm.text_nombre_comercial.setEnabled(true);
        vm.text_nombre_oficial.setEnabled(true);
        vm.text_anio_lanza.setEnabled(true);
        vm.cbx_es_plus.setEnabled(true);
        vm.cbx_cantidad_version.setEnabled(true);

    }

    void limpiarCombolineaProducto() { //getRowCount()
        for (int i = 0; i < vm.cbx_linea_procto.getItemCount(); i++) {
            vm.cbx_linea_procto.removeItemAt(i);
            //i = i - 1;
        }
    }

    void limpiarComboModelo() { //getRowCount()
        for (int i = 0; i < vm.cbx_modelos.getItemCount(); i++) {
            vm.cbx_modelos.removeItemAt(i);
            //i = i - 1;
        }
    }

    public void creaObjetoVersion(String id,String Modelo,String Nombre, String Capacidad, String SimCard, boolean v, String textboton) {
        indice++;//Incremetnoo en 1 el indice
        JLabel etiqueta = new JLabel();
        JTextField modelo = new JTextField();
        JTextField nombre = new JTextField();
        JComboBox capacidad = new JComboBox();
        JComboBox dualsim = new JComboBox();
         JButton boton_modificar = new JButton("M");//Modifica
        //----------------------------------------
        int x1 = 30;
        etiqueta.setBounds(5, x1 * indice, 100, 30);
        etiqueta.setText(id );
        modelo.setBounds(50, x1 * indice, 80, 30);
        modelo.setText(Modelo);
        nombre.setBounds(150, x1 * indice, 150, 30);
        nombre.setText(Nombre);
        
        capacidad.setBounds(310, x1 * indice, 50, 30);
        capacidad.addItem(Capacidad);
        capacidad.addItem("0");
        capacidad.addItem("16");
        capacidad.addItem("32");
        capacidad.addItem("64");
        capacidad.addItem("128");
        capacidad.addItem("256");
        capacidad.addItem("512");
        dualsim.setBounds(390, x1 * indice, 80, 30);
        dualsim.addItem(SimCard);
        dualsim.addItem("Sim Card");
        dualsim.addItem("Dual Sim");
        boton_modificar.setBounds(490, x1 * indice, 50, 30);//posicion en el panel
        //-------------------------------------------

        vm.panel.add(etiqueta);
        vm.panel.add(modelo);
        vm.panel.add(nombre);
        vm.panel.add(capacidad);
        vm.panel.add(dualsim);
        vm.panel.add(boton_modificar);
        //------------------------------------------------
        listaModelo.add(modelo);
        listaNombre.add(nombre);
        listaLabel.add(etiqueta);
        listaComboBoxCapacidad.add(capacidad);
        listaComboBoxDualSim.add(dualsim);
        listaBotonModificar.add(boton_modificar);
        //____________________________________________ 
        if (v == true) {//muestra el boton agregar        
            JButton boton_agregar = new JButton(textboton);
           
            boton_agregar.setBounds(10, x1 + x1 + x1 * indice, 180, 20);//posicion en el panel
            
            vm.panel.add(boton_agregar);
            
            listaBotonAgregar.add(boton_agregar);
            
            //............EVENTO PARA EL BOTON...........
            boton_agregar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {//"Crea (1)Campo"
                    if (boton_agregar.getText() == "Crea (1)Campo") {
                        limpiaObjetoVersion();
                        creaObjetoVersion("Modelo","","", "", "", true, "Agregar a Base D");
                    }
                    if (boton_agregar.getText() == "Agregar a Base D") {
                        if (modelo.getText().equals("")) {
                            JOptionPane.showMessageDialog(vm, "El Campo esta Vacio,Error");
                        } else {
                            agregaVersion();
                        }
                    }
                }
            });
        }//________________EVENTO PARA EL BOTON MODIFICAR_________________ 
            boton_modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (etiqueta.getText().equals("Modelo")){
                  JOptionPane.showMessageDialog(vm,"No Atualiza nada");
              }  else{
               Version v1 =new Version();
               
               v1.setId(Integer.parseInt(etiqueta.getText()));
               v1.setVersion(modelo.getText());
               v1.setNombre(nombre.getText());
               String cap =String.valueOf(capacidad.getSelectedItem());
               v1.setCapacidad(Integer.parseInt(cap));
               
               int simCard =0;
               if (dualsim.getSelectedItem() == "Sim Card") {
                    simCard = 0;
                }
                if (dualsim.getSelectedItem() == "Dual Sim") {
                    simCard = 1;
                }

               v1.setEsDualSim(simCard);
               actualizarVersion(v1);   //Llama al metodo y actualiza
   
                          
              }
            }
        });
        
        //____________________________________________         
        vm.panel.updateUI();

    }

    public void limpiaObjetoVersion() {
        indice = 0;
        listaLabel.clear();
        listaModelo.clear();
        listaNombre.clear();
        listaComboBoxCapacidad.clear();
        listaComboBoxDualSim.clear();
        //++++++++++++++++++++++++
        vm.panel.removeAll();
        //-------------------------------------------
        vm.panel.updateUI();

    }

    public void limpiar() {
        vm.text_nombre_oficial.setText("");
        vm.text_nombre_comercial.setText("");
        vm.text_anio_lanza.setText("");
        vm.text_id_fabricante.setText("");
        vm.text_id_lineaproducto.setText("");
        vm.text_id_modelo.setText("");
        limpiaObjetoVersion();
        //limpiarCombolineaProducto();
        //limpiarComboModelo();

    }

    public void inicia() {
        vm.setTitle("Nuevo Modelo");
        vm.setLocationRelativeTo(null);
        vm.text_id_fabricante.setEnabled(false);
        vm.text_id_lineaproducto.setEnabled(false);
        vm.text_id_modelo.setEnabled(false);
        //-------------------------------------------
        listaLabel = new ArrayList<>();
        listaModelo = new ArrayList<>();
        listaNombre = new ArrayList<>();
        listaComboBoxCapacidad = new ArrayList<>();
        listaComboBoxDualSim = new ArrayList<>();
        listaBotonAgregar = new ArrayList<>();
        listaBotonModificar = new ArrayList<>();
        indice = 0;
        //-------------------------------------------
        bloquea();
        listarFabriantes(vm.cbx_fabricantes);
        vm.setVisible(true);//Se vuelve visible

    }
}
