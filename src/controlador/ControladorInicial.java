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

import conexionSql.Conexion;
import java.sql.*;
import controladorUsuarios.ControladorUsuarioCuenta;
import controladorUsuarios.ControladorUsuarioRegistro;
import static controladorUsuarios.ControladorUsuarioRegistro.UsuarioRegistrado;
import controladorUsuarios.ControladorVistaPublicidad;
import controladorUsuarios.ControladorVistaUsuarioContenido;
import controladorUsuarios.ControladorVistaUsuarioContenidoHardware;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import static java.lang.Thread.sleep;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import modelo.AreaFalla;
import modelo.AreaFallaDAO;
import modelo.Contenido;
import modelo.ContenidoDAO;
import modelo.Fabricante;
import modelo.FabricanteDAO;
import modelo.InicialDAO;
import modelo.LineaProducto;
import modelo.LineaProductoDAO;
import modelo.Modelo;
import modelo.ModeloDAO;
import modelo.TipoFalla;
import modelo.Usuario;
import modelo.Version;
import modelo.VersionDAO;
import modeloConsultas.*;
import modeloConsultas.TelefonoInformaiconDAO;
import modeloConsultas.UsuarioRegistroDAO;
import vistas.VistaAreaFalla;
import vistas.VistaContenido;
import vistas.VistaFabricante;
import vistas.VistaFalla;
import vistas.VistaLineaProducto;
import vistas.VistaModelo;
import vistas.VistaPrincipal;
import vistas.VistaTipoFalla;
import vistas.VistaUsuario;
import vistas_usuarios.VistaPublicidad;
import vistas_usuarios.VistaUsuarioContenido;
import vistas_usuarios.VistaUsuarioContenidoHardware;
import vistas_usuarios.VistaUsuarioCuenta;
import vistas_usuarios.VistaUsuarioRegistro;

public class ControladorInicial implements ActionListener {//implementa
//Variables de la Clase

    Fabricante f = new Fabricante();
    InicialDAO dao = new InicialDAO();
    VistaPrincipal vp = new VistaPrincipal();
    LineaProductoDAO lpdao = new LineaProductoDAO();
    VersionDAO vdao = new VersionDAO();
    ModeloDAO mdao = new ModeloDAO();
    ContenidoDAO cdao = new ContenidoDAO();
    AreaFallaDAO afdao = new AreaFallaDAO();
    Version ver = new Version();
    VistaUsuarioRegistro vur = new VistaUsuarioRegistro();
    VistaUsuarioCuenta vuc = new VistaUsuarioCuenta();
    Usuario u = null;
    Usuario u1 = new Usuario();
    UsuarioRegistroDAO urdao = new UsuarioRegistroDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    ControladorUsuarioCuenta cuc = new ControladorUsuarioCuenta(vuc);
    ControladorUsuarioRegistro cur = new ControladorUsuarioRegistro(vur);
    VistaPublicidad vpublic = new VistaPublicidad();
    PublicidadDAO pdao1 = new PublicidadDAO();
    PublicidadDAO pdaof = null;
    Publicidad pubWeb  =new  Publicidad();
    UsuarioRegistroDAO rudao = new UsuarioRegistroDAO();

    
    Vector<modeloConsultas.Publicidad> listaPublicidad = null;//Crea la lista de Publicitaria del pais

    int id_fabricante;//Gurada el Valor del fabricante Selecionado
    int id_linea_producto;//Guarda el Valor de la Linea de producto seleccionado
    int id_modelo;//Guarda el Valor de la Linea de producto seleccionado
    int id_version;//Guarda el Valor de la Linea de producto seleccionado
    int id_aporte;
    int id_area_falla;
    int id_tipo_falla;
    
    int id_documentacion;
    int id_documentacion_fabricante;
    int id_documentacion_version;
    String version_selec; //Guarda la Version Selecionada Ejem: SM-2121
    //------------------------------------------------------
    public static int id_usuario=0;
    public static String nombre_usuario;
    public static int estado_sesion;
    public static String pais_usuario;
    public static int administrador= 4; //(Niveles:)
    //----------
    //Root=0    Admin=1    Comprometido=2   Colaborador=3   UsuarGeneral=4
    //Nivel=0   Nivel2=1   Nivel3=2         Nivel4=3        Nivel5=4
    private int nivel1=0;//Root
    private int nivel2=1;//Administrador
    private int nivel3=2;//Comprometido
    private int nivel4=3;//Colaborador
    private int nivel5=4;//Usuario General
    //---------------------------
    public static int tiempo_segungo;
    public static int publicidad_activa;//1=activa  y 0= Desctivada
    //Mas variables
    private String ling_web = "https://twitter.com/joserafa";
    private String descripcion_publicidad="Servicio \"Altamente Profesional\"  (313-694.67.37) Bogotá";
    //------------------------------------------------------
    //Variables para Botones dinamicos------------------
    private ArrayList<JButton> botones;
    private ArrayList<JButton> botones_linea;
    private ArrayList<JButton> botones_modelo;
    private ArrayList<JButton> botones_version;
    private ArrayList<JButton> botones_aporte;
     private ArrayList<JButton> botones_aporte_soft;
    private ArrayList<JButton> botones_Documentacion;
    private ArrayList<JButton> botones_Documentacion_fabricante;
    private ArrayList<JButton> botones_Documentacion_version;
    DefaultListModel list_modelo = new DefaultListModel();
    DefaultListModel list_Documentacion = new DefaultListModel();
    DefaultComboBoxModel modelocombo = null; //
    private int indice;
    private int indice_modelo;
    private int indice_version;
//---------------------------------------------------
    //Constructor uno
    public ControladorInicial(VistaPrincipal v) {
        this.vp = v;
        this.vp.boton_1.addActionListener(this);
        this.vp.boton_2.addActionListener(this);
        this.vp.boton_3.addActionListener(this);
        this.vp.boton_6.addActionListener(this);//Prueba JoptionPane
        this.vp.boton_5.addActionListener(this);//Prueba JoptionPane
        this.vp.boton_bublicidad.addActionListener(this);//Prueba JoptionPane

        this.vp.boton_muestra_version.addActionListener(this);
        this.vp.boton_muestra_documentos.addActionListener(this);
        this.vp.boton_muestra_documento_f.addActionListener(this);
        //this.vp.Imagenfondo.addComponentListener(actionPerformed(e));
        this.vp.combo_area_hardware.addActionListener(this);
        this.vp.combo_area_software.addActionListener(this);
        this.vp.boton_iniciar_sesion.addActionListener(this);
        this.vp.boton_registrarse.addActionListener(this);
    }

    public void listar() {//Este Metodo 
     
        //modelo = (DefaultTableModel) table.getModel();
        List<Fabricante> lista = dao.listar();//Carga los datos del cla clase FabricanteDao a la LISTA
        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();

            objeto[1] = lista.get(i).getNombre();

            //-----------------------------------
            int numero = lista.get(i).getId();
            String nombre = lista.get(i).getNombre();
            creaBotonDinamicoFabricante(numero, nombre);//Llama al METODO para Crear Boton Dinamico
            //----------------------------------
            //modelo.addRow(objeto); //Carga al TableModel Dato por Datos de la Lista
            

        }

        vp.Scroll.setVisible(true);//hace visible componentes
        vp.panel.setVisible(true);
    }

    public void listarLineaProducto() {
        //modelo = (DefaultTableModel) table.getModel();
        List<LineaProducto> lista = lpdao.listar(id_fabricante);//Carga los datos del la clase FabricanteDao a la LISTA

        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre();

            //-----------------------------------
            int numero = lista.get(i).getId();
            String nombre = lista.get(i).getNombre();
            creaBotonDinamicoLineaProductos(numero, nombre);
            //----------------------------------
            //modelo.addRow(objeto); //Carga al TableModel Dato por Datos de la Lista
        }

        //vp.tabla_marca.setModel(modelo);    
    }

    public void listarModelos() {//Muestra modelo Segun La Serie(Linea de producto)
        //modelo = (DefaultTableModel) table.getModel();
        List<Modelo> lista = mdao.listar(id_linea_producto);//Carga los datos del la clase FabricanteDao a la LISTA
        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre_comercial();//NOMBRE Comecial

            //-----------------------------------
            int numero = lista.get(i).getId();
            String nombre = lista.get(i).getNombre_comercial();
            creaBotonDianmicoModelo(numero, nombre);
            //----------------------------------
            //modelo.addRow(objeto); //Carga al TableModel Dato por Datos de la Lista
        }

        //vp.tabla_marca.setModel(modelo);    
    }

    public void listrarVersiones() {
        //modelo = (DefaultTableModel) table.getModel();
        List<Version> lista = vdao.listar(id_modelo);//Carga los datos del la clase FabricanteDao a la LISTA
        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getVersion();//NOMBRE Comecial

            //-----------------------------------
            int numero = lista.get(i).getId();
            String nombre = lista.get(i).getVersion();
            creaBotonDinamicoVersion(numero, nombre);//LLama al metodo para Crear los Botones Dinamicos
            //----------------------------------


        }

    }
//------------------------------------------------------------------------------

    public void creaBotonDinamicoFabricante(int id, String nombre) {
        indice++;//Incremetnoo en 1 el indice 
        JButton boton = new JButton(nombre); //Creo un boton

        //---------------------------------------------
        String val = String.valueOf(id);
        boton.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel.add(boton); //Agrego al panel el boton
        botones_linea.add(boton);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton.addActionListener(new ActionListener() {//Agrega Evento a cada Boton Creado
            @Override
            public void actionPerformed(ActionEvent e) {
                imagenFondo(false);//Metodo qeu cambia la imagen de fondo
               if( id_fabricante == Integer.parseInt(boton.getToolTipText())){
                muestraPanelModelo(true);//Oculta Pane               
                muestraPanesModelosVersion(true);
                muestraPanelFabricante(true);
                     
                 }else{

                muestraPanelModelo(false);//Oculta Pane
                muestraPanelModelo(false);
                muestraPanesModelosVersion(false);
                id_fabricante = Integer.parseInt(boton.getToolTipText());// Asigna a la Variabel el Valor de ID
                muestraFabricanteporID(id_fabricante);
                //muestraFabricanteporNombre(boton.getText());//Llama metodo para buscar por nombre
                limpiaBotonesLineaProducto();
                listarLineaProducto();//Llama al metodo para mostrar la liena segun el Fabricante seleccionado
                limpiaBotonesAporteDocumentacionFabricante();
           
                 }
            }
        });

        //----------------------------------
        vp.panel.updateUI();
    }

    public void creaBotonDinamicoLineaProductos(int id, String nombre) {
        indice++;//Incremetnoo en 1 el indice 
        JButton boton_linea = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_linea.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel_linea_producto.add(boton_linea); //Agrego al panel el boton
        botones_linea.add(boton_linea);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_linea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muestraPanelModelo(false);//Oculta Pane
                muestraPanelModelo(false);
                muestraPanesModelosVersion(false);
                //--------------------------------
                id_linea_producto = Integer.parseInt(boton_linea.getToolTipText());// Asigna a la Variabel el Valor de ID

                //muestraLineaProductoporNombre(boton_linea.getText());//Llama metodo para buscar por nombre
                muestraLineaProductoporID(id_linea_producto);
                limpiaBotonesModelo();
                listarModelos();
                // listarLineaProducto();//Llama al metodo para mostrar la liena segun el Fabricante selecciona
//-------------------------------------------------
            }
        });

        //----------------------------------
        vp.panel_linea_producto.updateUI();
    }

    public void creaBotonDianmicoModelo(int id, String nombre) {
        indice_modelo++;//Incremetnoo en 1 el indice 
        JButton boton_modelo = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_modelo.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------         
        vp.panel_modelos_todos.add(boton_modelo); //Agrego al panel el boton
        botones_modelo.add(boton_modelo);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_modelo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //--------------------------------
                muestraPanesModelosVersion(false);
                //--------------------------------               
                limpiaBotonnesVersion();
                limpiaBotonesAporteHardware();
                limpiaBotonesAporteDocumentacionModelo();
                limpiaBotonesAporteDocumentacionVersion();
                id_modelo = Integer.parseInt(boton_modelo.getToolTipText());

                muestraModeloporId(id_modelo);//Metodo donde Muestra los datos del modelo
                muestraAreaFallaPorcadaTipo(vp.combo_area_hardware, 1);//Carga Combo Box Con Area Falla(1)Hardware
                muestraAreaFallaPorcadaTipo(vp.combo_area_software, 2);//Carga Combo Box Con Area Falla(2)Software              

//muestraContenidoDocumentacionPorModelo(); //Carga en Panel Dinamico los Botonres con la Documentacion del Mod   
            }
        });

        //----------------------------------
        vp.panel_modelos_todos.updateUI();
    }

    public void creaBotonDinamicoVersion(int id, String nombre) {
        indice_version++;//Incremetnoo en 1 el indice 
        JButton boton_version = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_version.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel_versiones.add(boton_version); //Agrego al panel el boton
        botones_version.add(boton_version);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_version.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                id_version = Integer.parseInt(boton_version.getToolTipText());//Carga el valor de la version en Variable de Clase
                version_selec =boton_version.getText();//Carga el Nombre Version Ejm: SM-2134
                limpiaBotonesAporteDocumentacionVersion();
                ver = vdao.buscaporIDVersionMuestraDatos(id_version);
                vp.label_nombre_version.setText(ver.getNombre());
                vp.label_version.setText(ver.getVersion());
                vp.label_capacidad.setText(String.valueOf(ver.getCapacidad()));
                muestraContenidoDocumentacionPorVersion();
            }
        });

        //----------------------------------
        vp.panel_versiones.updateUI();
    }

    public void creaBotoneDinamicoAportesHard(int id, String nombre) {
        //indice_version++;//Incremetnoo en 1 el indice 
        JButton boton_aporte = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_aporte.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel_aportes.add(boton_aporte); //Agrego al panel el boton
        botones_aporte.add(boton_aporte);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_aporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int seleccion=Integer.parseInt(boton_aporte.getToolTipText());
                 if((seleccion!=0)) {   
                id_aporte = Integer.parseInt(boton_aporte.getToolTipText());//Carga el valor de la version en Variable de Clase
                //muestraLineaPorductoporNombre(boton_modelo.getText());//Llama metodo para buscar por nombre
                //-------------------------------------------------------------------
                cdao.ejecutarArchivoPdf(id_aporte);//Ejecuta Archivo PDF
                String nom_archivo = String.valueOf(id_aporte) + ".pdf"; //Construye le nombre del Archivo,Debe ser igual          
                try {
                    Desktop.getDesktop().open(new File(nom_archivo));
                } catch (Exception ex) {
                }
                //-------------------------------------------------------------------   
                 }
                 
                if((seleccion==0)) {
VistaUsuarioContenidoHardware vuch = new VistaUsuarioContenidoHardware();
ControladorVistaUsuarioContenidoHardware cvch = new ControladorVistaUsuarioContenidoHardware(vuch);
String f= FallaInformacionDAO.informaiconFallaPorArea(id_area_falla);
String v=  TelefonoInformaiconDAO.IformacionTelefonosSegunIDModelo(id_modelo);   

     
        cvch.setEntidad(3);//El 4 equivale a Version
        cvch.setEntidad_id(id_modelo);
        cvch.setAporte_id(1);
        cvch.setArea_falla(id_area_falla);
        cvch.setTipo_falla(id_tipo_falla);
        cvch.setId_falla(0);
        cvch.setUsuario_id(id_usuario);
        cvch.setFabricante_id(id_fabricante);
        cvch.setLineaproducto_id(id_linea_producto);
        cvch.setModelo_id(id_modelo);
        cvch.setVersion_id(0);

         //----------------------- */
         cvch.inicial(v,f);
                    
                }               
            }
        });

        //----------------------------------
        vp.panel_aportes.updateUI();
    }
    
    public void creaBotoneDinamicoAportesSoft(int id, String nombre){
    
        JButton boton_aporte_sotf = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_aporte_sotf.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel_aportes_soft.add(boton_aporte_sotf); //Agrego al panel el boton
        botones_aporte_soft.add(boton_aporte_sotf);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_aporte_sotf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int seleccion=Integer.parseInt(boton_aporte_sotf.getToolTipText());
                 if((seleccion!=0)) {   
                id_aporte = Integer.parseInt(boton_aporte_sotf.getToolTipText());//Carga el valor de la version en Variable de Clase
        
                //-------------------------------------------------------------------
                cdao.ejecutarArchivoPdf(id_aporte);//Ejecuta Archivo PDF
                String nom_archivo = String.valueOf(id_aporte) + ".pdf"; //Construye le nombre del Archivo,Debe ser igual          
                try {
                    Desktop.getDesktop().open(new File(nom_archivo));
                } catch (Exception ex) {
                }
                //-------------------------------------------------------------------   
                 }
                 
                if((seleccion==0)) {
VistaUsuarioContenidoHardware vuch = new VistaUsuarioContenidoHardware();
ControladorVistaUsuarioContenidoHardware cvch = new ControladorVistaUsuarioContenidoHardware(vuch);
String f= FallaInformacionDAO.informaiconFallaPorArea(id_area_falla);
String v=  TelefonoInformaiconDAO.IformacionTelefonosSegunIDModelo(id_modelo);   

     
        cvch.setEntidad(3);//El 4 equivale a Version
        cvch.setEntidad_id(id_modelo);
        cvch.setAporte_id(2);
        cvch.setArea_falla(id_area_falla);
        cvch.setTipo_falla(id_tipo_falla);
        cvch.setId_falla(0);
        cvch.setUsuario_id(id_usuario);
        cvch.setFabricante_id(id_fabricante);
        cvch.setLineaproducto_id(id_linea_producto);
        cvch.setModelo_id(id_modelo);
        cvch.setVersion_id(0);

         //----------------------- */
         cvch.inicial(v,f);
                    
                }               
            }
        });

        //----------------------------------
        vp.panel_aportes.updateUI();
    
    }

    public void creaBotoneDinamicoDocumentacionModelo(int id, String nombre) {
        JButton boton_Documentacion = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_Documentacion.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel_documentacion.add(boton_Documentacion); //Agrego al panel el boton
        botones_Documentacion.add(boton_Documentacion);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_Documentacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccion=Integer.parseInt(boton_Documentacion.getToolTipText());
               if((seleccion!=0)) {             
                id_documentacion = Integer.parseInt(boton_Documentacion.getToolTipText());//Carga el valor de la version en Variable de Clase

                //-------------------------------------------------------------------
                String nom_archivo = String.valueOf(id_documentacion) + ".pdf"; //Construye le nombre del Archivo,Debe ser igual          
                cdao.ejecutarArchivoPdf(id_documentacion);//Ejecuta Archivo PDF
                try {
                    Desktop.getDesktop().open(new File(nom_archivo));
                } catch (Exception ex) {
                }
                //-------------------------------------------------------------------        
            }
                           if((seleccion==0)) {//El Usuario a Seleccionado la Opcion Agregar
         VistaUsuarioContenido vuct=new VistaUsuarioContenido();
         ControladorVistaUsuarioContenido cfc=new ControladorVistaUsuarioContenido(vuct);                 
         String v=TelefonoInformaiconDAO.IformacionTelefonosSegunIDModelo(id_modelo);  
         //-----------------------
        cfc.setEntidad(3);//El 3 equivale a Modelo
        cfc.setEntidad_id(id_modelo);
        cfc.setAporte_id(1);
        cfc.setArea_falla(0);
        cfc.setTipo_falla(0);
        cfc.setUsuario_id(id_usuario);
        cfc.setFabricante_id(id_fabricante);
        cfc.setLineaproducto_id(id_linea_producto);
        cfc.setModelo_id(id_modelo);
        cfc.setVersion_id(0);
        cfc.setVersion("");

         //-----------------------
         cfc.inicia(v);
               }   
               
               
            }
        });

        //----------------------------------
        vp.panel_documentacion.updateUI();
    }

    public void creaBotoneDinamicoDocumentacionFabricante(int id, String nombre) {
        JButton boton_Documentacion_fabricante = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_Documentacion_fabricante.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel_documentacion_fabricante.add(boton_Documentacion_fabricante); //Agrego al panel el boton
        botones_Documentacion_fabricante.add(boton_Documentacion_fabricante);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_Documentacion_fabricante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                id_documentacion_fabricante = Integer.parseInt(boton_Documentacion_fabricante.getToolTipText());//Carga el valor de la version en Variable de Clase

                //-------------------------------------------------------------------
                String nom_archivo = String.valueOf(id_documentacion_fabricante) + ".pdf"; //Construye le nombre del Archivo,Debe ser igual          
                cdao.ejecutarArchivoPdf(id_documentacion_fabricante);//Ejecuta Archivo PDF
                try {
                    Desktop.getDesktop().open(new File(nom_archivo));
                } catch (Exception ex) {
                }
                //-------------------------------------------------------------------        

            }
        });

        //----------------------------------
        vp.panel_documentacion.updateUI();

    }
            //NUEVO "Se Creo Condicion para mostrar Botoon Agregar"
    public void creaBotoneDinamicoDocumentacionVersion(int id, String nombre) {
        JButton boton_Documentacion_version = new JButton(nombre); //Creo un boton
        //---------------------------------------------
        String val = String.valueOf(id);
        boton_Documentacion_version.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima
        //---------------------------------------------       
        vp.panel_documentacion_v.add(boton_Documentacion_version); //Agrego al panel el boton
        botones_Documentacion_version.add(boton_Documentacion_version);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_Documentacion_version.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccion=Integer.parseInt(boton_Documentacion_version.getToolTipText());
               if((seleccion!=0)) {
                id_documentacion_version = seleccion;//Carga el valor de la version en Variable de Clase
                //-------------------------------------------------------------------
                String nom_archivo = String.valueOf(id_documentacion_version) + ".pdf"; //Construye le nombre del Archivo,Debe ser igual          
                cdao.ejecutarArchivoPdf(id_documentacion_version);//Ejecuta Archivo PDF
                try {
                    Desktop.getDesktop().open(new File(nom_archivo));
                } catch (Exception ex) {
                }
                //-------------------------------------------------------------------        
                            }
               if((seleccion==0)) {//El Usuario a Seleccionado la Opcion Agregar
         VistaUsuarioContenido vuct=new VistaUsuarioContenido();
         ControladorVistaUsuarioContenido cfc=new ControladorVistaUsuarioContenido(vuct);                 
         String v=TelefonoInformaiconDAO.IformacionTelefonosSegunIDVersion(id_version);  
         //-----------------------
         cfc.setEntidad(4);//El 4 equivale a Version
        cfc.setEntidad_id(id_version);
        cfc.setAporte_id(1);
        cfc.setArea_falla(0);
        cfc.setTipo_falla(0);
        cfc.setUsuario_id(id_usuario);
        cfc.setFabricante_id(id_fabricante);
        cfc.setLineaproducto_id(id_linea_producto);
        cfc.setModelo_id(id_modelo);
        cfc.setVersion_id(id_version);
        cfc.setVersion(version_selec);

         //-----------------------
         cfc.inicia(v);
               }
               
            }
        });

        //----------------------------------
        vp.panel_documentacion_v.updateUI();
    }

//------------------------------------------------------------------------------
    public void limpiaBotonesLineaProducto() {
        botones.clear();//limpia list
        indice = 0;
        vp.panel_linea_producto.removeAll();
        vp.panel_linea_producto.updateUI();//actualiza panel 

    }

    public void limpiaBotonesModelo() {
        botones_modelo.clear();//limpia list
        indice_modelo = 0;
        vp.panel_modelos_todos.removeAll();
        vp.panel_modelos_todos.updateUI();//actualiza panel 

    }

    public void limpiaBotonnesVersion() {
        vp.label_version.setText("");
        vp.label_nombre_version.setText("");
        vp.label_capacidad.setText("");
        botones_version.clear();//limpia list
        indice_version = 0;
        vp.panel_versiones.removeAll();
        vp.panel_versiones.updateUI();//actualiza panel 
    }

    public void limpiaBotonesAporteHardware() {
        botones_aporte.clear();//limpia list
        //indice_version = 0;
        vp.panel_aportes.removeAll();
        vp.panel_aportes.updateUI();//actualiza panel 
    }
    
    public void limpiaBotonesAporteSoftwaare(){
            botones_aporte_soft.clear();//limpia list
          vp.panel_aportes_soft.removeAll();
        vp.panel_aportes_soft.updateUI();//actualiza panel 
    }

    public void limpiaBotonesAporteDocumentacionModelo() {
        botones_Documentacion.clear();//limpia list
        //indice_version = 0;
        vp.panel_documentacion.removeAll();
        vp.panel_documentacion.updateUI();//actualiza panel
    }

    public void limpiaBotonesAporteDocumentacionFabricante() {
        botones_Documentacion_fabricante.clear();//limpia list
        //indice_version = 0;
        vp.panel_documentacion_fabricante.removeAll();
        vp.panel_documentacion_fabricante.updateUI();//actualiza panel   
    }

    public void limpiaBotonesAporteDocumentacionVersion() {
        botones_Documentacion_version.clear();//limpia list
        //indice_version = 0;
        vp.panel_documentacion_v.removeAll();
        vp.panel_documentacion_v.updateUI();//actualiza panel
    }
//------------------------------------------------------------------------------

    public void muestraFabricanteporNombre(String nf) {//Muestra el nombre y su contenido
        //modelo = (DefaultTableModel) table.getModel();

        Fabricante f = dao.buscaporFabricantePorNombre(nf);//Carga los datos del cla clase FabricanteDao a la LISTA
        muestraPanelFabricante(false);//Limpia y luego muestra el panel
        muestraPanelFabricante(true);//Limpia y luego muestra el panel
        id_fabricante = f.getId();//Carga el valor del Fabricante en Variable de Clase
        vp.label_fabricante.setText(f.getNombre());
        vp.textA_historia.setText(f.getHistoria());
        //---------------
        muestraLogo(f.getId());
        //-------------------

    }

    public void muestraFabricanteporID(int id) {
        Fabricante f = dao.buscaporFabricantePorID(id);//Carga los datos del cla clase FabricanteDao a la LISTA
        muestraPanelFabricante(false);//Limpia y luego muestra el panel
        muestraPanelFabricante(true);//Limpia y luego muestra el panel
        id_fabricante = f.getId();//Carga el valor del Fabricante en Variable de Clase
        vp.label_fabricante.setText(f.getNombre());
        vp.textA_historia.setText(f.getHistoria());
        //---------------
        muestraLogo(f.getId());
        //-------------------    
    }

    public void muestraModeloporNombre(String nm) {
        //modelo = (DefaultTableModel) table.getModel();

        Modelo m = mdao.buscaporModeloPorNombre(nm);//Carga los datos del cla clase FabricanteDao a la LISTA
        muestraPanelFabricante(false);//Limpia y luego muestra el panel
        muestraPanelFabricante(true);//Limpia y luego muestra el panel
        id_fabricante = f.getId();//Carga el valor del Fabricante en Variable de Clase
        vp.label_fabricante.setText(f.getNombre());
        vp.textA_historia.setText(f.getHistoria());
        //---------------
        muestraLogo(f.getId());
        //-------------------
    }

    public void muestraModeloporId(int id) {
        Modelo m = mdao.buscaporModeloporID(id);//Carga los datos del cla clase FabricanteDao a la LISTA
        muestraPanesModelosVersion(false);//Limpia y luego muestra el panel
        muestraPanesModelosVersion(true);//Limpia y luego muestra el panel

        vp.label_nombre_modelo.setText(m.getNombre_comercial());
        vp.label_nombre_oficial.setText(m.getNombreOficial());
        vp.label_año_lanza.setText(String.valueOf(m.getAnioLanza()));
        int valor = m.getEsPlus();
        if (m.getEsPlus() == 1) {
            vp.label_es_plus.setText("Es Plus");
        }
        if (m.getEsPlus() == 0) {
            vp.label_es_plus.setText("No es Plus");
        }

        //---------------
        //muestraLogo(f.getId());
        //-------------------
    }

    public void muestraLineaProductoporNombre(String nl) {
        LineaProducto lp = lpdao.buscaLinesProductoporNombre(nl);//Carga los datos del cla clase FabricanteDao a la LISTA
        muestraPanelModelo(false);//Limpia y luego muestra el panel
        muestraPanelModelo(true);//Limpia y luego muestra el panel

        id_linea_producto = lp.getId();//Carga el valor del Fabricante en Variable de Clase
        vp.label_nombre_linea_producto.setText(lp.getNombre());
        vp.label_gama.setText(lp.getGama());
        //---------------
        listarModelos();//Llama al metodo para listar los modelos segun la serie
        //-------------------
    }

    public void muestraLineaProductoporID(int id) {
        LineaProducto lp = lpdao.buscaLinesProductoporID(id);//Carga los datos del cla clase FabricanteDao a la LISTA
        muestraPanelModelo(false);//Limpia y luego muestra el panel
        muestraPanelModelo(true);//Limpia y luego muestra el panel

        id_linea_producto = lp.getId();//Carga el valor del Fabricante en Variable de Clase
        vp.label_nombre_linea_producto.setText(lp.getNombre());
        vp.label_gama.setText(lp.getGama());
        //---------------
        listarModelos();//Llama al metodo para listar los modelos segun la serie
        //-------------------  
    }

    public void muestraVersionporId(int id) {//Muestra las Versiones Segun el Modelo Seleccionado

        Version v = vdao.buscaporVersionporIdModelo(id);//Carga los datos del cla clase Version a la LISTA
        muestraPanesModelosVersion(false);//Limpia y luego muestra el panel
        muestraPanesModelosVersion(true);//Limpia y luego muestra el panel

        //vp.label_nombre_linea_producto.setText(v.getVersion());
        //vp.label_gama.setText(v.getGama());
        //---------------
        //listarModelos();//Llama al metodo para listar los modelos segun la serie
        //-------------------    
    }

    public void muestraContenidoAportePorModeloHardware() {

        // ListModel<Contenido> list_modelo = list.getModel();
        List<Contenido> lista = cdao.MostrarContenidoAportePorModelo(id_modelo, id_area_falla, id_tipo_falla);//Carga los datos del la clase FabricanteDao a la LISTA
        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
       int b=0;
        for (int i = 0; i < lista.size(); i++) {
            
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre().toString();
            //objeto[2] = lista.get(i).getTipo_archivo();
            // objeto[3] = lista.get(i).getAporte();
            //objeto[4] = lista.get(i).getUsuraio_id();
            //list_modelo.addElement(objeto); //Carga al TableModel Dato por Datos de la Lista
            //-----------------------------------------------------------
            int numero = lista.get(i).getId();
            int valor_archivo = lista.get(i).getTipo_archivo();//Obtiene el Valor del Tipo de Archivo. en Numero
            String tipo_archivo = tipoArchivo(valor_archivo);//Metodo que Devuelve el tipo de Archivo en String
            String nombre = lista.get(i).getNombre().toString() + " - (" + tipo_archivo + ")";
            creaBotoneDinamicoAportesHard(numero, nombre);
                  //------------NUEVO-------------------
                      //Root=0    Admin=1    Comprometido=2   Colaborador=3   UsuarGeneral=4  // Base de Datos
                     //Nivel1=0    Nivel2=1   Nivel3=2         Nivel4=3        Nivel5=4        // Sistema
            if( (lista.size()==i+1)&&( administrador <= nivel3 )){//Root=0 Admin=1  Colabora=2  Comprometi=3  UsuarGeneral=4
                b++;
         
            creaBotoneDinamicoAportesHard(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            }             
            //----------------------------------     

        }
        
              //-------------NUEVO----------------
            if( (b==0)&&( administrador<= nivel3 )){//OJO DEBE SER CAMBIA A NIVEL 3
          
            creaBotoneDinamicoAportesHard(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            } 
        //----------------------------------  
    }
    //NUEVO EN CONTSTRUCCION
    public void muestraContenidoAportePorModeloSoftware(){
            List<Contenido> lista = cdao.MostrarContenidoAportePorModelo(id_modelo, id_area_falla, id_tipo_falla);//Carga los datos del la clase FabricanteDao a la LISTA
        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
       int b=0;
        for (int i = 0; i < lista.size(); i++) {
            
            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre().toString();
      
            //-----------------------------------------------------------
            int numero = lista.get(i).getId();
            int valor_archivo = lista.get(i).getTipo_archivo();//Obtiene el Valor del Tipo de Archivo. en Numero
            String tipo_archivo = tipoArchivo(valor_archivo);//Metodo que Devuelve el tipo de Archivo en String
            String nombre = lista.get(i).getNombre().toString() + " - (" + tipo_archivo + ")";
            creaBotoneDinamicoAportesSoft(numero, nombre);
                  //------------NUEVO-------------------
            if( (lista.size()==i+1)&&( administrador<= nivel3 )){//OJO DEBE SER CAMBIA A NIVEL 3
                b++;
         
            creaBotoneDinamicoAportesSoft(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            }             
            //----------------------------------     

        }
        
              //-------------NUEVO----------------
            if( (b==0)&&( administrador<= nivel3 )){//OJO DEBE SER CAMBIA A NIVEL 3
          
            creaBotoneDinamicoAportesSoft(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            } 
        //----------------------------------  
    
    }

    public void muestraContenidoDocumentacionPorModelo() {//
        List<Contenido> lista = cdao.MostrarContenidoDocumentacionPorModelo(id_modelo);//Carga los datos del la clase FabricanteDao a la LISTA
        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        int b=0;
        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre().toString();
            //objeto[2] = lista.get(i).getTipo_archivo();
            // objeto[3] = lista.get(i).getAporte();
            //objeto[4] = lista.get(i).getUsuraio_id();
            list_Documentacion.addElement(objeto); //Carga al TableModel Dato por Datos de la Lista
            //-----------------------------------------------------------
            int numero = lista.get(i).getId();
            int valor_archivo = lista.get(i).getTipo_archivo();//Obtiene el Valor del Tipo de Archivo. en Numero
            String tipo_archivo = tipoArchivo(valor_archivo);//Metodo que Devuelve el tipo de Archivo en String
            String nombre = lista.get(i).getNombre().toString() + " - (" + tipo_archivo + ")";
            creaBotoneDinamicoDocumentacionModelo(numero, nombre);
            //------------NUEVO-------------------
            if( (lista.size()==i+1)&&( administrador<= nivel4 )){
                b++;
         
            creaBotoneDinamicoDocumentacionModelo(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            }             
            //----------------------------------

        }
                //-------------NUEVO----------------
            if( (b==0)&&( administrador<= nivel4 )){
          
            creaBotoneDinamicoDocumentacionModelo(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            } 
        //---------------------------------- 
    }

    public void muestraContenidoDocumentacionPorFabricante() {
        List<Contenido> lista = cdao.MostrarContenidoDocumentacionPorFabricante(id_fabricante);//Carga los datos del la clase FabricanteDao a la LISTA
        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.

        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre().toString();
            //objeto[2] = lista.get(i).getTipo_archivo();
            // objeto[3] = lista.get(i).getAporte();
            //objeto[4] = lista.get(i).getUsuraio_id();
            //list_Documentacion.addElement(objeto); //Carga al TableModel Dato por Datos de la Lista

            //-----------------------------------------------------------
            int numero = lista.get(i).getId();
            int valor_archivo = lista.get(i).getTipo_archivo();//Obtiene el Valor del Tipo de Archivo. en Numero
            String tipo_archivo = tipoArchivo(valor_archivo);//Metodo que Devuelve el tipo de Archivo en String
            String nombre = lista.get(i).getNombre().toString() + " - (" + tipo_archivo + ")";
            creaBotoneDinamicoDocumentacionFabricante(numero, nombre);

        }
    }
            //Nuevo "Se Agrego Condicion para Mostrar Botones <<+>>"
    public void muestraContenidoDocumentacionPorVersion() {
        List<Contenido> lista = cdao.MostrarContenidoDocumentacionPorVersion(id_version);//Carga los datos del la clase FabricanteDao a la LISTA

        Object objeto[] = new Object[2]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        int b=0;
        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getNombre().toString();
            //objeto[2] = lista.get(i).getTipo_archivo();
            // objeto[3] = lista.get(i).getAporte();
            //objeto[4] = lista.get(i).getUsuraio_id();
            //list_Documentacion.addElement(objeto); //Carga al TableModel Dato por Datos de la Lista

            //-----------------------------------------------------------
            int numero = lista.get(i).getId();
            int valor_archivo = lista.get(i).getTipo_archivo();//Obtiene el Valor del Tipo de Archivo. en Numero
            String tipo_archivo = tipoArchivo(valor_archivo);//Metodo que Devuelve el tipo de Archivo en String
            String nombre = lista.get(i).getNombre().toString() + " - (" + tipo_archivo + ")";
            creaBotoneDinamicoDocumentacionVersion(numero, nombre);
            //------------NUEVO-------------------
            if( (lista.size()==i+1)&&( administrador<= nivel4 )){
                b++;
         
            creaBotoneDinamicoDocumentacionVersion(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            }             
            //----------------------------------
        }
        //-------------NUEVO----------------
            if( (b==0)&&( administrador<= nivel4 )){
          
            creaBotoneDinamicoDocumentacionVersion(0, "<< + >>");//Llama al METODO para Crear Boton Dinamico
            } 
        //----------------------------------    
    }

    public void muestraAreaFallaPorcadaTipo(JComboBox combo, int id) {
        Vector<AreaFalla> lista = afdao.listar(id);//Busca las Fallas de Hardware(2)
        modelocombo = new DefaultComboBoxModel(lista);
        combo.setModel(modelocombo);
    }

    //------------------------------------------------------------------------------
    //METODOS OBSOLETOS YA FUERO USADOS PARA ACTUALIZAR LA TABLA CONTENIDO
    private void ActualizaIDsContenidoAutomatico() {//Metodo que Actualiza de manera Automatica los Id de Version,....
        int id_cont = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el Id del Contenido Para Actualizar"));
        int id_version = cdao.buscaEntidadIDsegunID(id_cont);
        TelefonoInformaiconDAO tidao = new TelefonoInformaiconDAO();
        int r = cdao.actualizaSoloIDs(tidao.buscaIDTelefonosSegunIDVersion(id_version), id_cont);
        if (r == 1) {

            JOptionPane.showMessageDialog(vp, "OK... Actualizado con Exito.");

        } else {

            JOptionPane.showMessageDialog(vp, "Error");

        }
    }
    //METODOS OBSOLETOS YA FUERO USADOS PARA ACTUALIZAR LA TABLA CONTENIDO

    private void ActualizaLaListadeContenidoAutomaticamente() {

        List<Contenido> lista = cdao.recorrelaTablayCargaLista();//Carga los datos del cla clase Falla a la LISTA
        Object objeto[] = new Object[6]; //Crea un Arreglo tipo Objeto de 2 Elementos.
        int c = 0;
        for (int i = 0; i < lista.size(); i++) {
            c++;
            int Id_Contenido = lista.get(i).getId();
            int Entidad = lista.get(i).getEntidad();
            int Entidad_id = lista.get(i).getEntidad_id();
            int op = Entidad;
            int r = 0;
            switch (op) {
                case 1:
                    //-------------------------------------------------------------                
                    TelefonoInformaiconDAO tidao1 = new TelefonoInformaiconDAO();
                    r = cdao.actualizaSoloIDs(tidao1.buscaIDTelefonosSegunIDFabricante(Entidad_id), Id_Contenido);
                    if (r == 0) {
                        System.out.println("No se Pudo Actualizar,Error: " + lista.get(i).getId());
                    }
                    //System.out.println("Actualizados: "+ lista.get(i).getId() + "-");     
                    //-------------------------------------------------------------                    
                    break;
                case 2://LineaProducto
                    //-------------------------------------------------------------                
                    TelefonoInformaiconDAO tidao2 = new TelefonoInformaiconDAO();
                    r = cdao.actualizaSoloIDs(tidao2.buscaIDTelefonosSegunIDLineProducto(Entidad_id), Id_Contenido);
                    if (r == 0) {
                        System.out.println("No se Pudo Actualizar,Error: " + lista.get(i).getId());
                    }
                    //System.out.println("Actualizados: "+ lista.get(i).getId() + "-");     
                    //-------------------------------------------------------------                  
                    break;
                case 3://Modelo
                    //-------------------------------------------------------------                
                    TelefonoInformaiconDAO tidao3 = new TelefonoInformaiconDAO();
                    r = cdao.actualizaSoloIDs(tidao3.buscaIDTelefonosSegunIDModelo(Entidad_id), Id_Contenido);
                    if (r == 0) {
                        System.out.println("No se Pudo Actualizar,Error: " + lista.get(i).getId());
                    }
                    //System.out.println("Actualizados: "+ lista.get(i).getId() + "-");     
                    //------------------------------------------------------------- 
                    break;
                case 4://Version
                    //-------------------------------------------------------------                
                    TelefonoInformaiconDAO tidao4 = new TelefonoInformaiconDAO();
                    r = cdao.actualizaSoloIDs(tidao4.buscaIDTelefonosSegunIDVersion(Entidad_id), Id_Contenido);
                    if (r == 0) {
                        System.out.println("No se Pudo Actualizar,Error: " + lista.get(i).getId());
                    }
                    //System.out.println("Actualizados: "+ lista.get(i).getId() + "-");     
                    //-------------------------------------------------------------          
                    break;

                default:
                    System.out.println("ERROR NADA**(" + c + ")-" + lista.get(i).getId());
            }
            System.out.println("Avance: " + c + "/" + lista.size());
        }
    }
    //------------------------------------------------------------------------------

    private String tipoArchivo(int id) {
        String resultado = null;

        if (id == 1) {
            resultado = "Pdf";
        }
        if (id == 2) {
            resultado = "Jpg";
        }
        if (id == 3) {
            resultado = "Png";
        }
        if (id == 4) {
            resultado = "Txt";
        }
        if (id == 5) {
            resultado = "Exe";
        }
        if (id == 6) {
            resultado = "Iso";
        }
        if (id == 7) {
            resultado = "Mp4";
        }
        return resultado;
    }

    public void muestraLogo(int id) {
        ImageIcon foto = dao.getlogo(id);//Llama al metodo mostrar foto
        if (foto != null) {
            //Crea un Nuevo icono y lo Re-Dimensiona al tamaño exacto del label.
            ImageIcon foto2 = new ImageIcon(foto.getImage().getScaledInstance(vp.label_logo.getWidth(), vp.label_logo.getHeight(), Image.SCALE_SMOOTH));
            vp.label_logo.setIcon(foto2);  //Carga la nueva imagen re-didimensionada al label    
        } else {
            vp.label_logo.setIcon(null);
        }
        vp.label_logo.updateUI();

    }

    public void muestraFotoPublicidad(int id) {
        ImageIcon foto = PublicidadDAO.getImagenmini(id);//Llama al Statico metodo mostrar foto
        if (foto != null) {
            //Crea un Nuevo icono y lo Re-Dimensiona al tamaño exacto del label.
            ImageIcon foto2 = new ImageIcon(foto.getImage().getScaledInstance(vp.labe_imagen_publicidad_mini.getWidth(), vp.labe_imagen_publicidad_mini.getHeight(), Image.SCALE_SMOOTH));
            vp.labe_imagen_publicidad_mini.setIcon(foto2);  //Carga la nueva imagen re-didimensionada al label    
        } else {
            vp.labe_imagen_publicidad_mini.setIcon(null);
        }
        vp.labe_imagen_publicidad_mini.updateUI();

    }
    
  
      
    private void abrirLink() {
        try {
            Desktop.getDesktop().browse(new URI(ling_web));
        } catch (Exception e) {
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vp.boton_1) {
            //Llama al metodo para mostrar Formulario de Fabricante
            VistaTipoFalla vtf = new VistaTipoFalla();
            ControladorTipoFalla ctf = new ControladorTipoFalla(vtf);
            ctf.inicia();

        }
        if (e.getSource() == vp.boton_2) {//Actualiza elContenido de forma Automatica

        }
        if (e.getSource() == vp.boton_3) {
            VistaModelo vm = new VistaModelo();
            ControladorModelo cm = new ControladorModelo(vm);
            cm.inicia();

        }
        if (e.getSource() == vp.boton_5) {
            VistaFalla vf = new VistaFalla();
            ControladorFalla cf = new ControladorFalla(vf);
            cf.inicia();
        }
        if (e.getSource() == vp.boton_6) {//CONTENIDO
            VistaContenido vc = new VistaContenido();
            ControladorContenido cc = new ControladorContenido(vc);
            cc.inicia();
        }
        if (e.getSource() == vp.boton_muestra_version) {//busqueda de Versiones

            limpiaBotonnesVersion();
            listrarVersiones();

        }
        if (e.getSource() == vp.boton_muestra_documentos) {//busqueda de Versiones

            limpiaBotonesAporteDocumentacionModelo();
            muestraContenidoDocumentacionPorModelo(); //Carga en Panel Dinamico los Botonres con la Documentacion del Mod   

        }
        if (e.getSource() == vp.boton_muestra_documento_f) {//busqueda de Versiones

            limpiaBotonesAporteDocumentacionFabricante();
            muestraContenidoDocumentacionPorFabricante(); //Carga en Panel Dinamico los Botonres con la Documentacion del Mod   

        }

        if (e.getSource() == vp.combo_area_hardware) {//****Evento Oyente del ComboBox tipo Falla
            AreaFalla areaf = (AreaFalla) vp.combo_area_hardware.getSelectedItem();
            id_area_falla = areaf.getId();//Asigna a la Variable local el ID del Area de Falla
            id_tipo_falla = 1;//Asingan el 1 que corresponde al tipo hardware.

            limpiaBotonesAporteHardware();
            muestraContenidoAportePorModeloHardware();//Metodo que muestra en LIST los aportes para dicho modelo

        }
            if (e.getSource() == vp.combo_area_software) {//****Evento Oyente del ComboBox tipo Falla
            AreaFalla areaf = (AreaFalla) vp.combo_area_software.getSelectedItem();
            id_area_falla = areaf.getId();//Asigna a la Variable local el ID del Area de Falla
            id_tipo_falla = 2;//Asingan el 2 que corresponde al tipo Software.
            limpiaBotonesAporteSoftwaare();
            muestraContenidoAportePorModeloSoftware();//Metodo que muestra en LIST los aportes para dicho modelo

        }    
        
//  boton_iniciar_sesion
        if (e.getSource() == vp.boton_registrarse) {//busqueda de Versiones

            vur.setVisible(true);
            vuc.setVisible(false);
            vp.panel_centro.add(vur);
            cur.inicia();
            vp.panel_centro.validate();//Actualiza el Contenedor
            desabilitarPanelesUsuario();

        }
        if (e.getSource() == vp.boton_iniciar_sesion) {//busqueda de Versiones

            vuc.setVisible(true);
            vur.setVisible(false);
            vp.panel_centro.add(vuc);
            cuc.inicia();
            vp.panel_centro.validate();//Actualiza el Contenedor
            desabilitarPanelesUsuario();
        }

        if (e.getSource() == vp.boton_bublicidad) {//busqueda de Versiones
            
                         
		if (!vpublic.isVisible()) {    
	    ControladorVistaPublicidad cvp = new ControladorVistaPublicidad(vpublic);
            cvp.inicial();//Comienza a mostrar el Formulario 
		} 
            
            
        }

    }

    //Clse qeu ejecuta un hilo para la publicadad
    public class Publicidad implements Runnable {

        PublicidadDAO pdao = new PublicidadDAO();
        int tiempoPorCadaPublicidad = 30;//En Segungos
        int durarion = 10; //Variables modificable para la publicidad
        int comientza = 5; //En segundos
        int sg = 0;
        int c_duracion = 0;
        //--------------------------   
        int n = 0;

        int c = 0; //Busca en Base de datos
        int reg = 0;// busca en Registro uno a uno
        int t_t_public = tiempoPorCadaPublicidad; //Timpor tramscurrido por casa publicidad

        @Override
        public void run() {
            boolean ejecutar = true;//Comienza el ciclo del hilo

            while (ejecutar) {
                //----------------------------------------    
                c++;
                if (c == 1) {//Buscando la lista en  BASE DE DATOS.
                    listaPublicidad = pdao.listarPorPaisVigente(pais_usuario);//OJO  
                }
                if (reg < listaPublicidad.size() && (tiempoPorCadaPublicidad == t_t_public)) { //Busca ID Y CARGA LA IMAGEN
                    int id_v = listaPublicidad.get(reg).getId();//Busca el Nu:1+ de la lista.++
                    muestraFotoPublicidad(id_v);//Metodo que carga la imagen en el label segun el ID
                        ling_web=listaPublicidad.get(reg).getUrl();
                        descripcion_publicidad=listaPublicidad.get(reg).getTelefono();
                        vp.label_inferior_contactos.setText(descripcion_publicidad);
                     //ling_web= PublicidadDAO.muestraLingWeb(id_v);//Metodo que carga el Link Web //Obsoleto
                    reg++;
                }
                if (reg == listaPublicidad.size()) {
                    reg = 0;
                    c = 0;
                }

                t_t_public--;

                if (t_t_public == 0) {//El Ciclo que esta mostrando

                    t_t_public = tiempoPorCadaPublicidad;
                }

                //---------------------------------------      
                sg++;
                if (sg > comientza) {
                    c_duracion++;
                    publicidad_activa = 1;
                    if (c_duracion == durarion) {
                        publicidad_activa = 0;
                        c_duracion = 0;
                        sg = 0;
                    }
                }
                //---------------------------------------    
                if (publicidad_activa == 1) {
                    vp.panel_publicitario_mini.setVisible(true);

                } else {
                    vp.panel_publicitario_mini.setVisible(false);

                }
                //----------------------------------------
                try {
                    sleep(1000);//Un Segundo Duerme
                } catch (InterruptedException ex) {
                    Logger.getLogger(ControladorInicial.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    public void muestraPanelFabricante(boolean a) {
        //Limpia el panel fabricante
        vp.label_logo.setIcon(null);
        vp.label_fabricante.setText("");
        vp.textA_historia.setText("");
        //-----Limpia Botone dinamicos----
        botones_linea.clear();//limpia lista
        //---------------------
        vp.panel_fabricante.setBackground(new Color(0, 0, 0, 30));
        vp.panel_fabricante.setVisible(a);

        //------------------------
    }

    public void muestraPanelModelo(boolean a) {
        //Limpia el panel Modelo
        vp.label_nombre_linea_producto.setText("");
        vp.label_gama.setText("");

        //-----Limpia Botone dinamicos----
        botones_modelo.clear();//limpia lista
        //---------------------
        mestraPanelCentral(a);
        vp.panel_modelos.setBackground(new Color(0, 0, 0, 0));//Cambia el Color porque esta sobre otro panel
        vp.panel_modelos.setVisible(a);

        //------------------------
    }

    public void mestraPanelCentral(boolean a) {

        vp.panel_centro.setBackground(new Color(0, 0, 0, 30));
        vp.panel_centro.setVisible(a);
     
        vp.panel_centro.validate();//Actualiza el Contenedor
        //-----------------------------------
        vp.label_nombre_linea_producto.setVisible(false);
        vp.label_gama.setVisible(false);
        vp.panel_modelos.setVisible(false);
        vp.panel_inferior_central.setVisible(false);
    }

    public void muestraPanesModelosVersion(boolean a) {
        //Limpia el panel Modelo          
        vp.label_nombre_modelo.setText("");
        vp.label_nombre_oficial.setText("");
        vp.label_año_lanza.setText("");
        vp.label_es_plus.setText("");
        //-----Limpia Botone dinamicos----
        // botones_version.clear();//limpia lista
        //--------------------- 

        vp.panel_modelo_individual.setBackground(new Color(0, 0, 0, 30));
        vp.panel_modelo_individual.setVisible(a);
    }

    public void muestraPanelRegistroUsuario(boolean a) {

        ControladorUsuarioRegistro cur = new ControladorUsuarioRegistro(vur);
        cur.inicia();
        vp.panel_centro.add(vur, BorderLayout.CENTER);
        mestraPanelCentral(a);

        vp.Scroll.setVisible(false);
        vp.panel.setVisible(false);
        vp.panel_inferior_central.setVisible(true);
    }

    public void muestraPanelCuentaUsuario(boolean a) {

        ControladorUsuarioCuenta cuc = new ControladorUsuarioCuenta(vuc);
        cuc.inicia();
        vp.panel_centro.add(vuc, BorderLayout.CENTER);
        mestraPanelCentral(a);
        vp.Scroll.setVisible(false);
        vp.panel.setVisible(false);
        vp.panel_inferior_central.setVisible(true);//Muestra el Panel inferiro y debe estar de ultimo

    }

    public void desabilitarPanelesUsuario() {
        if (vuc.isVisible()) {
            vp.boton_registrarse.setEnabled(true);
            vp.boton_iniciar_sesion.setEnabled(false);
        } else if (vur.isVisible()) {
            vp.boton_registrarse.setEnabled(false);
            vp.boton_iniciar_sesion.setEnabled(true);

        }

    }

    public void muestraBotonesEnVistaPrincipal(boolean a) {
        vp.boton_1.setVisible(a);//Carga tipo Falla
        vp.boton_2.setVisible(a);//Visible ??
        vp.boton_3.setVisible(a);// Modelos
        vp.boton_6.setVisible(a); //Contenido
        vp.boton_5.setVisible(a);// Fallas
        vp.boton_bublicidad.setVisible( a);
    }

    public void quitaPaneldeRegistroyAseseoyListaFabricantes() {
        if ((vp.panel_inferior_central.isVisible()) && (estado_sesion == 1)) {

            vp.label_nombre_usuario.setText("Bienvienido " + ControladorInicial.nombre_usuario);
            vp.panel_inferior_central.setVisible(false);
            mestraPanelCentral(false);

            listar();
        }
    }
    
    public void metodoClicFotoPublicidad() {
        vp.labe_imagen_publicidad_mini.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
             
                    abrirLink();
                }

            @Override
            public void mouseEntered(MouseEvent e) {
           
  
              
            }

            @Override
            public void mouseExited(MouseEvent e) {
             
            }


        });

    }

    public void metodoClicEtiqueta() {
        vp.label_imagen_fondo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            
                if (vp.panel_inferior_central.isVisible()) {

                } else {
                    imagenFondo(true);//Cambia la imagen de fondo
                    muestraPanelFabricante(false);//Oculta el Panel cuando se hace clic a imagen de fondo
                    muestraPanelModelo(false);
                    muestraPanesModelosVersion(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                quitaPaneldeRegistroyAseseoyListaFabricantes();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                quitaPaneldeRegistroyAseseoyListaFabricantes();
            }
        });

    }
    
    public void clicEtiquetaSesion(){
            vp.label_sesion.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {                             
            if (id_usuario==0 ) {
        } else {
                   
            cerrarsesion();
            
            }
                           
                              
          }

            @Override
            public void mouseEntered(MouseEvent e) {
           
  
              
            }

            @Override
            public void mouseExited(MouseEvent e) {
             
            }


        });
    }
    
    public void cerrarsesion(){
 


          
            u1.setId(id_usuario);
            u1.setEstado(1);//Se Actualiza a (1)Porque significa que sale del sistema
            u1.setPais(pais_usuario);
         
            int r = rudao.actualizaEstdoUsuarioAccess(u1) ;
            if (r == 1) {

               System.exit(0);//Sale
           
            } else {

                JOptionPane.showMessageDialog(vp, "Error, no se pudo Cerrar Sesion..");

           

        }
    }

    public void dasabilitarPanelesUsuario() {
        if (vur.isVisible()) {//Vista Registro
            vuc.setVisible(true);
            vur.setVisible(false);

        } else if (vuc.isVisible()) {//Vista Cuenta
            vuc.setVisible(false);
            vur.setVisible(true);
        }

    }

    public int chekeaUsuarioActivoenBaseDatosAcces() {
        int r = 0;
        List<Usuario> lista = urdao.listarUsuariosRegistradosAccess();//Carga los datos del cla clase Usuario

        if (lista.size() > 0) {//Si la lista tiene Registros entonces Busca el usuario de Estado Activo
            for (int i = 0; i < lista.size(); i++) {
                int estado = lista.get(i).getEstado();

                if (estado == 0) {//El usuario esta Activado "Abre el sistema sin Problema
                    r = 1;
                    id_usuario = lista.get(i).getId();
                    nombre_usuario=lista.get(i).getNombre_usuario();
                    vp.label_nombre_usuario.setText("Bienvenido  @'" + lista.get(i).getNombre_usuario() + "'");
                    pais_usuario = lista.get(i).getPais();

                
//objeto[0] = lista.get(i).getId();
                    //objeto[1] = lista.get(i).getNombre_usuario();
                } else {//El usuario Entro al sistema pero cerro sesion
                    r = 0;

                    //objeto[0] = lista.get(i).getId();
                    //objeto[1] = lista.get(i).getNombre_usuario();                                  
                }
                //objeto[0] = lista.get(i).getId();
                //objeto[1] = lista.get(i).getNombre_usuario();
            }

        } else { //NO HALLO NINGUN USUARIO EN BD ACCESS.ES UNA NUEVA APERTURA.
            r = 0;
        }
        return r;
    }
    public void imagenFondo(boolean a){
        String direcfoto="";
        if (a==true){
        direcfoto="/imagenes/Fondo_Letras.jpg";
        }else{
         direcfoto="/imagenes/Fondo_Letras_vacio.jpg";   
        }
        ImageIcon fotillo = new ImageIcon(getClass().getResource(direcfoto));
        ImageIcon icono = new ImageIcon(fotillo.getImage().getScaledInstance(vp.label_imagen_fondo.getWidth(), vp.label_imagen_fondo.getHeight(), Image.SCALE_DEFAULT));
        vp.label_imagen_fondo.setIcon(icono);
         vp.label_imagen_fondo.updateUI(); //Actualiza el Label.
    }

    public void inicia() {

        vp.setTitle("GiTaller Colaborador V-1.0");
       // vp.setIconImage(new ImageIcon(getClass().getResource("../imagenes/Logo_tentativo.png")).getImage() );
        vp.setBounds(0, 0, 1090, 640);
        vp.setLocationRelativeTo(null);
        vp.setResizable(false);
   
        //--------Variables de Botones Dinamicos-------------
        botones = new ArrayList<>();
        botones_linea = new ArrayList<>();
        botones_modelo = new ArrayList<>();
        botones_version = new ArrayList<>();
        botones_aporte = new ArrayList<>();
        botones_aporte_soft = new ArrayList<>();
        botones_Documentacion = new ArrayList<>();
        botones_Documentacion_fabricante = new ArrayList<>();
        botones_Documentacion_version = new ArrayList<>();
        indice = 0;
        indice_modelo = 0;
        indice_version = 0;

        //-------------------PUBLICIDAD---------------------------
        Conexion conectado=new Conexion();
        Connection  c = conectado.getConnection();
        if (c!=null){ //Revisa que el exita la coneccion
        Publicidad pub = new Publicidad();
        Thread HiloPublicidad = new Thread(pub);  //Luego, construye un hilo de ese objeto.    
        HiloPublicidad.start();
        }
   
        //--------------------------------------------------------
        int cheke =0; //chekeaUsuarioActivoenBaseDatosAcces();//OJO
        if (cheke == 1) { //Abre el Sistema sin Incomvenientes
            //El Chekeo dio "1" O se Si Abre todo.
            imagenFondo(true);//Cambia la imagen de fondo
            muestraPanelFabricante(false);
            muestraPanelModelo(false);
            muestraPanesModelosVersion(false);
            //muestraPanelRegistroUsuario(false);
            //muestraPanelCuentaUsuario(true);
            muestraBotonesEnVistaPrincipal(false);
            vp.boton_bublicidad.setVisible(false);
            listar();//llama al metodo para cargar la tabla en la pantalla
     
        } else {
 
            //El Chekeo dio "0" O se Nada No abrirá
            imagenFondo(true);//Cambia la imagen de fondo
            muestraPanelFabricante(false);
            muestraPanelModelo(false);
            muestraPanesModelosVersion(false);
            //muestraPanelRegistroUsuario(false);
            muestraPanelCuentaUsuario(true);
            desabilitarPanelesUsuario();
            muestraBotonesEnVistaPrincipal(false);
            

            //listar();//llama al metodo para cargar la tabla en la pantalla       
        }
        //------------------------
        metodoClicFotoPublicidad();
     
        metodoClicEtiqueta();
    
        clicEtiquetaSesion();
      
        vp.setVisible(true);
     

    }
}
