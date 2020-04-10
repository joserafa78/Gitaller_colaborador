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
package controladorUsuarios;

import controlador.ControladorInicial;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modeloConsultas.Publicidad;
import modeloConsultas.PublicidadDAO;
import vistas_usuarios.JpanelPublicidadDos;
import vistas_usuarios.JpanelPublicidadTres;
import vistas_usuarios.JpanelPublicidadUno;
import vistas_usuarios.VistaPublicidad;

public class ControladorVistaPublicidad implements ActionListener {
    //Variables de la Clase

    private ArrayList<JButton> botones_publicidad;

    VistaPublicidad vpubli = new VistaPublicidad();
    //--------------------------------------------------
    JpanelPublicidadUno jpUno = new JpanelPublicidadUno();
    ControladorJpanelPublicidadUno cjpUno = new ControladorJpanelPublicidadUno(jpUno);
    //--------------------------------------------------  
    //--------------------------------------------------
    JpanelPublicidadDos jpDos = new JpanelPublicidadDos();
    ControladorJpanelPublicidadDos cjpDos = new ControladorJpanelPublicidadDos(jpDos);
    //--------------------------------------------------   
    JpanelPublicidadTres jpTres = new JpanelPublicidadTres();
    ControladorJpanelPublicidadTres cjpTres = new ControladorJpanelPublicidadTres(jpTres);
    //--------------------------------------------------      
    PublicidadDAO pdao = new PublicidadDAO();

    //Mas variables
    private int Cant_Publicaion_Activa;
    private int Cant_Publicaion_Espera;
    private int Cant_Publicaion_Total;

    //Constructor 
    public ControladorVistaPublicidad(VistaPublicidad vpubli) {
        this.vpubli = vpubli;
        //Botones
        vpubli.boton_uno.addActionListener(this);
        vpubli.boton_dos.addActionListener(this);
        vpubli.boton_tres.addActionListener(this);
        vpubli.boton_enviar.addActionListener(this);
    }

    public void listarPublicidad() {//Este Metodo 
        int total = 0;
        int activo = 0;
        int espera = 0;
        List<Publicidad> lista = pdao.listar(ControladorInicial.id_usuario);//Carga los datos del cla clase FabricanteDao a la LISTA
        limpiaBotonesPublicacion();
        for (int i = 0; i < lista.size(); i++) {
            total++;
            if (lista.get(i).getVigente() == 0) {//Chekea que la publiccion este en Espera. y Cuenta (1)
                espera++;
            }
            if (lista.get(i).getVigente() == 1) {//Chekea que la publiccion este en Activo. y Cuenta (1)
                activo++;
            }

            //-----------------------------------
            int numero = lista.get(i).getId();
            String nombre = lista.get(i).getTitulo();
            int vigente = lista.get(i).getVigente();
            creaBotonDinamicoPublicidad(numero, nombre, vigente);//Llama al METODO para Crear Boton Dinamico
            //----------------------------------
        }

        //-----------------------------------
        Cant_Publicaion_Activa = activo;
        Cant_Publicaion_Espera = espera;
        Cant_Publicaion_Total = total;
        vpubli.Label_activas.setText("Activa: " + String.valueOf(activo));
        vpubli.Label_espera.setText("Espera: " + String.valueOf(espera));
        vpubli.label_total.setText("Total: " + String.valueOf(total));

    }

    public void Agregar() {//Carga la Publicidad

        int v1 = cjpUno.validarCampos();
        int v2 = cjpDos.validarCampos();
        int v3 = cjpTres.validarCampos();

        if ((v1 == 0) && (v2 == 0) && (v3 == 0)) {//){ 
            Publicidad p = new Publicidad();

            p.setId(1);
            p.setTitulo(jpUno.text_titulo.getText());
            p.setImagen_uno(ControladorJpanelPublicidadUno.fis1);
            //p.setImagen_dos(fis2); 
            p.setTelefono(jpUno.text_telefono.getText());
            p.setUrl(jpUno.text_url.getText());
            p.setDuracion(24);
            p.setTiempo(0);
            p.setPais(jpUno.combo_pais.getSelectedItem().toString());
            p.setVigente(0);
            p.setForma_pago(jpTres.combo_forma_pago.getSelectedItem().toString());
            p.setCod_pago(jpTres.text_codigo_pago.getText());
            //p.setFecha() ;
            p.setUsuario_id(ControladorInicial.id_usuario);

            int r = pdao.agregar(p);// Aqui se envia los Datotos a la funcion Agregar y luego envia un entero   
            if (r == 1) {
                JOptionPane.showMessageDialog(vpubli, "Publicidad Enviada(Usted Cuenta con 24 despues de Aprobarla).");
                limpiaLosTresJPnael();
                //cjpUno.bloquear(false);                                     
                cjpTres.bloquear(false);
                limpiaBotonesPublicacion();
                listarPublicidad();//Muestra la Publicidad del usuario

            } else {
                JOptionPane.showMessageDialog(vpubli, "Error no se Pudo, Revisar");
            }
        }
    }

    public void desabilitarBotonesPaneles() {//vpubli.boton_uno

        if (jpUno.isVisible()) {
            vpubli.boton_uno.setVisible(true);
            vpubli.boton_dos.setVisible(true);
            vpubli.boton_tres.setVisible(true);
            //-----------------------------------
            vpubli.boton_uno.setBackground(Color.CYAN);
            vpubli.boton_dos.setBackground(Color.GRAY);
            vpubli.boton_tres.setBackground(Color.GRAY);

        } else if (jpDos.isVisible()) {
            vpubli.boton_uno.setVisible(true);
            vpubli.boton_dos.setVisible(true);
            vpubli.boton_tres.setVisible(true);
            //-----------------------------------
            vpubli.boton_uno.setBackground(Color.GRAY);
            vpubli.boton_dos.setBackground(Color.CYAN);
            vpubli.boton_tres.setBackground(Color.GRAY);

        } else if (jpTres.isVisible()) {
            vpubli.boton_uno.setVisible(true);
            vpubli.boton_dos.setVisible(true);
            vpubli.boton_tres.setVisible(true);
            //-----------------------------------
            vpubli.boton_uno.setBackground(Color.GRAY);
            vpubli.boton_dos.setBackground(Color.GRAY);
            vpubli.boton_tres.setBackground(Color.CYAN);

        }

    }

    public void creaBotonDinamicoPublicidad(int id, String nombre, int vigente) {
        JButton boton_p = new JButton(nombre); //Creo un boton

        //---------------------------------------------
        String val = String.valueOf(id);
        boton_p.setToolTipText(val);//Carga el Id AL Boton y lo Muestra cuando el cursor se Posiciona encima

        if (vigente == 1) {//Chekea que la publiccion este en Activo. y Agrega color
            boton_p.setBackground(Color.green);
        }

//---------------------------------------------       
        vpubli.panel_dinamico_publicidad.add(boton_p); //Agrego al panel el boton
        botones_publicidad.add(boton_p);//Agrego a la lista
        //---------Agrega evento a cada boton creado
        boton_p.addActionListener(new ActionListener() {//Agrega Evento a cada Boton Creado
            @Override
            public void actionPerformed(ActionEvent e) {

                int id_publi = Integer.parseInt(boton_p.getToolTipText());// Asigna a la Variabel el Valor de ID

                //limpiaBotonesLineaProducto();
                //listarLineaProducto();//Llama al metodo para mostrar la liena segun el Fabricante seleccionado
                //limpiaBotonesAporteDocumentacionFabricante();
            }
        });

        //----------------------------------
        vpubli.panel_dinamico_publicidad.updateUI();
    }

    public void limpiaBotonesPublicacion() {
        botones_publicidad.clear();//limpia list

        vpubli.panel_dinamico_publicidad.removeAll();
        vpubli.panel_dinamico_publicidad.updateUI();//actualiza panel 

    }

    public void limpiaLosTresJPnael() {
        cjpUno.limpiar();
        cjpDos.limpiar();
        cjpTres.limpiar();
    }

    public boolean ValidaCantidaddePublicaciones() {
        String nomb = ControladorInicial.nombre_usuario;
        int Cant_Public = 10; //OJO CAMBIAR A 
        boolean respuesta = false;
        int CostoDolares = 5;
        if (Cant_Publicaion_Total >= Cant_Public) {

            JOptionPane.showMessageDialog(vpubli, "Apreciado Tecnico: (" + nomb + ") Su Cuenta Ya supero la Cantidad de Publicaciones ", "Notificacion",
                    JOptionPane.WARNING_MESSAGE);
            vpubli.lablel_superior.setText("Usuario:" + nomb + " No Puede Cargar mas Publicaciones ");
            respuesta = false;

        } else {
            vpubli.lablel_superior.setText("Usuario:" + nomb + " Dispone de (" + Cant_Public + ") Publicacion por costo de " + CostoDolares + " Dolares ");
            respuesta = true;
        }
      

        return respuesta;

    }

    @Override //EVENTOS
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vpubli.boton_uno) {//****Evento Oyente Boton Uno
            boolean p = ValidaCantidaddePublicaciones();
            if (p == true) {//Valida que tenga permisos por la aplicacion para hacer mas publicaciones
        System.out.println("Entra a la condicion y Cambia el jpanel.y sus colores"); 
                vpubli.boton_uno.setBackground(Color.CYAN);
                vpubli.boton_dos.setBackground(Color.GRAY);
                vpubli.boton_tres.setBackground(Color.GRAY);
//-------------------------------------------  
                vpubli.boton_enviar.setVisible(false);//Muestra el boton Enviar
                //-------------------------------------------              
                jpUno.setVisible(true);
                jpDos.setVisible(false);
                jpTres.setVisible(false);
                vpubli.panel_contenedor.add(jpUno);
                vpubli.panel_contenedor.validate();//Actualiza el Contenedor
                desabilitarBotonesPaneles();
            }
        }
        if (e.getSource() == vpubli.boton_dos) {//****Evento Oyente Boton Dos
            boolean p = ValidaCantidaddePublicaciones();
            if (p == true) {//Valida que tenga permisos por la aplicacion para hacer mas publicaciones
                int v = cjpUno.validarCampos();//Valida Campo
                if (v == 0) {//Si no hay ningun error entonces pasa a la siguente pagina

                    vpubli.boton_uno.setBackground(Color.GRAY);
                    vpubli.boton_dos.setBackground(Color.CYAN);
                    vpubli.boton_tres.setBackground(Color.GRAY);
//-------------------------------------------  
                    vpubli.boton_enviar.setVisible(false);//Muestra el boton Enviar
                    //-------------------------------------------           
                    jpUno.setVisible(false);
                    jpDos.setVisible(true);
                    jpTres.setVisible(false);
                    vpubli.panel_contenedor.add(jpDos);
                    vpubli.panel_contenedor.validate();//Actualiza el Contenedor
                    desabilitarBotonesPaneles();
                }

            }
        }
        if (e.getSource() == vpubli.boton_tres) {//****Evento Oyente Boton Tres

            boolean p = ValidaCantidaddePublicaciones();
            if (p == true) {//Valida que tenga permisos por la aplicacion para hacer mas publicaciones
                int v1 = cjpUno.validarCampos();//Valida Campo
                int v = cjpDos.validarCampos();//Valida Campo   
                if (v == 0 && v1 == 0) {//Si no hay ningun error entonces pasa a la siguente pagina

                    vpubli.boton_uno.setBackground(Color.GRAY);
                    vpubli.boton_dos.setBackground(Color.CYAN);
                    vpubli.boton_tres.setBackground(Color.GRAY);
//-------------------------------------------  
                    vpubli.boton_enviar.setVisible(true);//Muestra el boton Enviar
                    //-------------------------------------------                
                    jpUno.setVisible(false);
                    jpDos.setVisible(false);
                    jpTres.setVisible(true);
                    vpubli.panel_contenedor.add(jpTres);
                    vpubli.panel_contenedor.validate();//Actualiza el Contenedor
                    desabilitarBotonesPaneles();
                }
            }
        }
        if (e.getSource() == vpubli.boton_enviar) {//Boton envia los datos al SErvidor.

            boolean p = ValidaCantidaddePublicaciones();
            if (p == true) {//Valida que tenga permisos por la aplicacion para hacer mas publicaciones
                int v3 = cjpTres.validarCampos();

                if (v3 == 0) {//Verifica que en el Paso 3 todo este bien lleando

                    int resp = JOptionPane.showConfirmDialog(null, "¿Usted a Selecionado ? (" + jpTres.combo_forma_pago.getSelectedItem().toString()
                            + ") Como Forma de Pago,Desea Continuar.", "Mensaje de Confirmacion de Pago", JOptionPane.YES_NO_OPTION);
                    if (resp == 0) {//Respuesta es igual a Si = 0
                        Agregar();
                    }

                }

            }

        }

    }

    public void inicial() {
        vpubli.setTitle("Publicidad");
        //vpubli.setIconImage(new ImageIcon(getClass().getResource("../Imagenes/Logo_tentativo.png")).getImage());
        vpubli.setBounds(0, 0, 560, 550);
        vpubli.setLocationRelativeTo(null);

        botones_publicidad = new ArrayList<>();
        //------------------------------------- 

        vpubli.panel_contenedor.add(jpUno);
        cjpUno.inicial();
        vpubli.panel_contenedor.updateUI();
        desabilitarBotonesPaneles();
        //------------------------------------- 
        vpubli.boton_enviar.setVisible(false);//Oculta el boton
        listarPublicidad();//Muestra la Publicidad del usuario
        ValidaCantidaddePublicaciones();
        vpubli.setVisible(true);

    }

}
