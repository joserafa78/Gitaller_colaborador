package vistas;

import controlador.ControladorInicial;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modelo.Fabricante;

public class VistaPrincipal extends javax.swing.JFrame {
//Variables de la Clase

    public VistaPrincipal() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_contenedor = new javax.swing.JPanel();
        panel_centro = new javax.swing.JPanel();
        panel_modelos = new javax.swing.JPanel();
        scroll_modelo = new javax.swing.JScrollPane();
        panel_modelos_todos = new javax.swing.JPanel();
        label_nombre1 = new javax.swing.JLabel();
        label_nombre2 = new javax.swing.JLabel();
        label_nombre3 = new javax.swing.JLabel();
        label_nombre_linea_producto = new javax.swing.JLabel();
        label_gama = new javax.swing.JLabel();
        panel_inferior_central = new javax.swing.JPanel();
        boton_registrarse = new javax.swing.JButton();
        boton_iniciar_sesion = new javax.swing.JButton();
        panel_fabricante = new javax.swing.JPanel();
        label_fabricante = new javax.swing.JLabel();
        label_historia = new javax.swing.JLabel();
        label_logo = new javax.swing.JLabel();
        jPanel_Fabricante = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        label_nombre = new javax.swing.JLabel();
        scroll_textA_historia = new javax.swing.JScrollPane();
        textA_historia = new javax.swing.JTextArea();
        scroll_linea_producto = new javax.swing.JScrollPane();
        panel_linea_producto = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        boton_muestra_documento_f = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        panel_documentacion_fabricante = new javax.swing.JPanel();
        panel_modelo_individual = new javax.swing.JPanel();
        label_nombre_modelo = new javax.swing.JLabel();
        label_nombre_oficial = new javax.swing.JLabel();
        label_año_lanza = new javax.swing.JLabel();
        label_es_plus = new javax.swing.JLabel();
        label_nombre_oficial1 = new javax.swing.JLabel();
        label_año_lanza1 = new javax.swing.JLabel();
        Jtabbed = new javax.swing.JTabbedPane();
        jPanel_hardware = new javax.swing.JPanel();
        combo_area_hardware = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        panel_aportes = new javax.swing.JPanel();
        Jpanel_software = new javax.swing.JPanel();
        combo_area_software = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        panel_aportes_soft = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scroll_versiones = new javax.swing.JScrollPane();
        panel_versiones = new javax.swing.JPanel();
        boton_muestra_version = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        panel_documentacion_v = new javax.swing.JPanel();
        label_nombre_version = new javax.swing.JLabel();
        label_version = new javax.swing.JLabel();
        label_version1 = new javax.swing.JLabel();
        label_capacidad = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_documentacion = new javax.swing.JPanel();
        boton_muestra_documentos = new javax.swing.JButton();
        Scroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        boton_1 = new javax.swing.JButton();
        boton_5 = new javax.swing.JButton();
        boton_2 = new javax.swing.JButton();
        boton_6 = new javax.swing.JButton();
        boton_3 = new javax.swing.JButton();
        boton_bublicidad = new javax.swing.JButton();
        label_nombre_usuario = new javax.swing.JLabel();
        panel_publicitario_mini = new javax.swing.JPanel();
        label_inferior_contactos = new javax.swing.JLabel();
        labe_imagen_publicidad_mini = new javax.swing.JLabel();
        label_sesion = new javax.swing.JLabel();
        label_imagen_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));

        panel_contenedor.setBackground(new java.awt.Color(0, 102, 102));
        panel_contenedor.setLayout(null);

        panel_centro.setBackground(new java.awt.Color(138, 181, 216));
        panel_centro.setLayout(new java.awt.BorderLayout());

        panel_modelos.setBackground(new java.awt.Color(138, 181, 216));

        panel_modelos_todos.setLayout(new java.awt.GridLayout(0, 1));
        scroll_modelo.setViewportView(panel_modelos_todos);

        label_nombre1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre1.setText("Serie Selecionada:");

        label_nombre2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre2.setText("Gama");

        label_nombre3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_nombre3.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre3.setText("Modelos Disponibles:");

        label_nombre_linea_producto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_nombre_linea_producto.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre_linea_producto.setText("xxxxxxxx");

        label_gama.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_gama.setForeground(new java.awt.Color(255, 255, 255));
        label_gama.setText("xxxxxxxx");

        javax.swing.GroupLayout panel_modelosLayout = new javax.swing.GroupLayout(panel_modelos);
        panel_modelos.setLayout(panel_modelosLayout);
        panel_modelosLayout.setHorizontalGroup(
            panel_modelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_modelosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_modelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scroll_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nombre3)
                    .addGroup(panel_modelosLayout.createSequentialGroup()
                        .addComponent(label_nombre1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_nombre_linea_producto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_modelosLayout.createSequentialGroup()
                        .addComponent(label_nombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_gama, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        panel_modelosLayout.setVerticalGroup(
            panel_modelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_modelosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_modelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre1)
                    .addComponent(label_nombre_linea_producto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_modelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre2)
                    .addComponent(label_gama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_nombre3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_modelo, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_centro.add(panel_modelos, java.awt.BorderLayout.CENTER);

        boton_registrarse.setText("Registrarse");
        panel_inferior_central.add(boton_registrarse);

        boton_iniciar_sesion.setText("Iniciar ");
        panel_inferior_central.add(boton_iniciar_sesion);

        panel_centro.add(panel_inferior_central, java.awt.BorderLayout.PAGE_END);

        panel_contenedor.add(panel_centro);
        panel_centro.setBounds(220, 10, 340, 470);

        panel_fabricante.setBackground(new java.awt.Color(138, 181, 216));

        label_fabricante.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label_fabricante.setForeground(new java.awt.Color(255, 255, 255));
        label_fabricante.setText("Fabri..");

        label_historia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_historia.setForeground(new java.awt.Color(255, 255, 255));
        label_historia.setText("Historia:");

        label_logo.setBackground(new java.awt.Color(204, 204, 255));

        label_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_nombre.setForeground(new java.awt.Color(102, 102, 102));
        label_nombre.setText("Series de Telefos:");

        textA_historia.setColumns(20);
        textA_historia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textA_historia.setLineWrap(true);
        textA_historia.setRows(5);
        textA_historia.setText("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        textA_historia.setWrapStyleWord(true);
        scroll_textA_historia.setViewportView(textA_historia);

        panel_linea_producto.setLayout(new java.awt.GridLayout(3, 0));
        scroll_linea_producto.setViewportView(panel_linea_producto);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll_linea_producto)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(label_nombre)
                .addGap(0, 55, Short.MAX_VALUE))
            .addComponent(scroll_textA_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(scroll_textA_historia, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_linea_producto, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
        );

        jPanel_Fabricante.addTab("Historia", jPanel4);

        boton_muestra_documento_f.setText("Mostrar");

        panel_documentacion_fabricante.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane3.setViewportView(panel_documentacion_fabricante);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(boton_muestra_documento_f)
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boton_muestra_documento_f)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel_Fabricante.addTab("Documentacion", jPanel5);

        javax.swing.GroupLayout panel_fabricanteLayout = new javax.swing.GroupLayout(panel_fabricante);
        panel_fabricante.setLayout(panel_fabricanteLayout);
        panel_fabricanteLayout.setHorizontalGroup(
            panel_fabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fabricanteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_fabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_fabricanteLayout.createSequentialGroup()
                        .addGroup(panel_fabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_fabricanteLayout.createSequentialGroup()
                                .addComponent(jPanel_Fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panel_fabricanteLayout.createSequentialGroup()
                                .addComponent(label_historia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel_fabricanteLayout.createSequentialGroup()
                        .addComponent(label_fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panel_fabricanteLayout.setVerticalGroup(
            panel_fabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fabricanteLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(label_fabricante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_fabricanteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_historia)
                    .addComponent(label_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_Fabricante)
                .addGap(22, 22, 22))
        );

        panel_contenedor.add(panel_fabricante);
        panel_fabricante.setBounds(10, 10, 210, 470);

        panel_modelo_individual.setBackground(new java.awt.Color(138, 181, 216));

        label_nombre_modelo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        label_nombre_modelo.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre_modelo.setText("Samsung Galaxys S8");

        label_nombre_oficial.setFont(new java.awt.Font("Arial", 3, 10)); // NOI18N
        label_nombre_oficial.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre_oficial.setText("Nombre Oficial");

        label_año_lanza.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        label_año_lanza.setForeground(new java.awt.Color(255, 255, 255));
        label_año_lanza.setText("Año");

        label_es_plus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_es_plus.setForeground(new java.awt.Color(255, 255, 255));
        label_es_plus.setText("Es Plus");

        label_nombre_oficial1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_nombre_oficial1.setForeground(new java.awt.Color(255, 255, 255));
        label_nombre_oficial1.setText("Nombre Oficial:");

        label_año_lanza1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_año_lanza1.setForeground(new java.awt.Color(255, 255, 255));
        label_año_lanza1.setText("Año de Lanzamiento:");

        panel_aportes.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane2.setViewportView(panel_aportes);

        javax.swing.GroupLayout jPanel_hardwareLayout = new javax.swing.GroupLayout(jPanel_hardware);
        jPanel_hardware.setLayout(jPanel_hardwareLayout);
        jPanel_hardwareLayout.setHorizontalGroup(
            jPanel_hardwareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_hardwareLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_hardwareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(jPanel_hardwareLayout.createSequentialGroup()
                        .addComponent(combo_area_hardware, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_hardwareLayout.setVerticalGroup(
            jPanel_hardwareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_hardwareLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_area_hardware, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        Jtabbed.addTab("Hardware", jPanel_hardware);

        panel_aportes_soft.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane5.setViewportView(panel_aportes_soft);

        javax.swing.GroupLayout Jpanel_softwareLayout = new javax.swing.GroupLayout(Jpanel_software);
        Jpanel_software.setLayout(Jpanel_softwareLayout);
        Jpanel_softwareLayout.setHorizontalGroup(
            Jpanel_softwareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_softwareLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Jpanel_softwareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Jpanel_softwareLayout.createSequentialGroup()
                        .addComponent(combo_area_software, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
                .addContainerGap())
        );
        Jpanel_softwareLayout.setVerticalGroup(
            Jpanel_softwareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel_softwareLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_area_software, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        Jtabbed.addTab("Software", Jpanel_software);

        panel_versiones.setLayout(new java.awt.GridLayout(0, 1));
        scroll_versiones.setViewportView(panel_versiones);

        boton_muestra_version.setText("Mostrar");

        panel_documentacion_v.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane4.setViewportView(panel_documentacion_v);

        label_nombre_version.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        label_nombre_version.setForeground(new java.awt.Color(153, 0, 51));
        label_nombre_version.setText("Documentos de Cada Version");

        label_version.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        label_version.setForeground(new java.awt.Color(153, 0, 51));
        label_version.setText("Documentos de Cada Version");

        label_version1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        label_version1.setForeground(new java.awt.Color(153, 0, 51));
        label_version1.setText("Gb:");

        label_capacidad.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        label_capacidad.setForeground(new java.awt.Color(153, 0, 51));
        label_capacidad.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boton_muestra_version, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(scroll_versiones))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(label_nombre_version, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_version, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_version1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nombre_version)
                    .addComponent(boton_muestra_version))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_version)
                            .addComponent(label_version1)
                            .addComponent(label_capacidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                    .addComponent(scroll_versiones))
                .addContainerGap())
        );

        Jtabbed.addTab("Versiones", jPanel2);

        panel_documentacion.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(panel_documentacion);

        boton_muestra_documentos.setText("Mostrar Docuemtos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(boton_muestra_documentos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(boton_muestra_documentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        Jtabbed.addTab("Documentacion", jPanel3);

        javax.swing.GroupLayout panel_modelo_individualLayout = new javax.swing.GroupLayout(panel_modelo_individual);
        panel_modelo_individual.setLayout(panel_modelo_individualLayout);
        panel_modelo_individualLayout.setHorizontalGroup(
            panel_modelo_individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_modelo_individualLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel_modelo_individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jtabbed)
                    .addGroup(panel_modelo_individualLayout.createSequentialGroup()
                        .addGroup(panel_modelo_individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_modelo_individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_modelo_individualLayout.createSequentialGroup()
                                    .addComponent(label_nombre_oficial1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label_nombre_oficial, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel_modelo_individualLayout.createSequentialGroup()
                                    .addComponent(label_año_lanza1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(label_año_lanza, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(label_es_plus)))
                            .addComponent(label_nombre_modelo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_modelo_individualLayout.setVerticalGroup(
            panel_modelo_individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_modelo_individualLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label_nombre_modelo)
                .addGap(31, 31, 31)
                .addGroup(panel_modelo_individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre_oficial1)
                    .addComponent(label_nombre_oficial))
                .addGap(6, 6, 6)
                .addGroup(panel_modelo_individualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_año_lanza1)
                    .addComponent(label_año_lanza)
                    .addComponent(label_es_plus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Jtabbed)
                .addContainerGap())
        );

        panel_contenedor.add(panel_modelo_individual);
        panel_modelo_individual.setBounds(560, 10, 510, 470);

        panel.setLayout(new java.awt.GridLayout(1, 0));
        Scroll.setViewportView(panel);

        panel_contenedor.add(Scroll);
        Scroll.setBounds(10, 520, 620, 70);

        boton_1.setText("Cargar Tipo Falla");
        panel_contenedor.add(boton_1);
        boton_1.setBounds(230, 490, 120, 23);

        boton_5.setText("Fallas");
        boton_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_5ActionPerformed(evt);
            }
        });
        panel_contenedor.add(boton_5);
        boton_5.setBounds(10, 490, 80, 23);

        boton_2.setText("Visible");
        panel_contenedor.add(boton_2);
        boton_2.setBounds(160, 490, 70, 23);

        boton_6.setText("Contenido");
        boton_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_6ActionPerformed(evt);
            }
        });
        panel_contenedor.add(boton_6);
        boton_6.setBounds(90, 490, 70, 23);

        boton_3.setText("Carga Modelos");
        panel_contenedor.add(boton_3);
        boton_3.setBounds(350, 490, 120, 23);

        boton_bublicidad.setBackground(new java.awt.Color(255, 221, 28));
        boton_bublicidad.setText("Crea Tu Publicidad");
        panel_contenedor.add(boton_bublicidad);
        boton_bublicidad.setBounds(490, 490, 140, 23);

        label_nombre_usuario.setFont(new java.awt.Font("Times New Roman", 3, 16)); // NOI18N
        label_nombre_usuario.setForeground(new java.awt.Color(204, 204, 255));
        label_nombre_usuario.setText("Bienvenido...");
        panel_contenedor.add(label_nombre_usuario);
        label_nombre_usuario.setBounds(10, 10, 270, 19);

        panel_publicitario_mini.setLayout(new java.awt.BorderLayout());

        label_inferior_contactos.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        label_inferior_contactos.setForeground(new java.awt.Color(255, 0, 51));
        label_inferior_contactos.setText("Publica Aqui a Bajo Costo y a Nivel nacional...");
        panel_publicitario_mini.add(label_inferior_contactos, java.awt.BorderLayout.PAGE_END);

        labe_imagen_publicidad_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Git_taller_anuncio_System.jpg"))); // NOI18N
        panel_publicitario_mini.add(labe_imagen_publicidad_mini, java.awt.BorderLayout.CENTER);

        panel_contenedor.add(panel_publicitario_mini);
        panel_publicitario_mini.setBounds(640, 480, 420, 110);

        label_sesion.setForeground(new java.awt.Color(255, 255, 51));
        label_sesion.setText("Cerrar Sesion..");
        panel_contenedor.add(label_sesion);
        label_sesion.setBounds(970, 0, 100, 30);

        label_imagen_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo_Letras.jpg"))); // NOI18N
        panel_contenedor.add(label_imagen_fondo);
        label_imagen_fondo.setBounds(0, 0, 1080, 610);

        getContentPane().add(panel_contenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_5ActionPerformed

    private void boton_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_6ActionPerformed

    public static void main(String args[]) {


   
                   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
     
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Jpanel_software;
    private javax.swing.JTabbedPane Jtabbed;
    public javax.swing.JScrollPane Scroll;
    public javax.swing.JButton boton_1;
    public javax.swing.JButton boton_2;
    public javax.swing.JButton boton_3;
    public javax.swing.JButton boton_5;
    public javax.swing.JButton boton_6;
    public javax.swing.JButton boton_bublicidad;
    public javax.swing.JButton boton_iniciar_sesion;
    public javax.swing.JButton boton_muestra_documento_f;
    public javax.swing.JButton boton_muestra_documentos;
    public javax.swing.JButton boton_muestra_version;
    public javax.swing.JButton boton_registrarse;
    public javax.swing.JComboBox<String> combo_area_hardware;
    public javax.swing.JComboBox<String> combo_area_software;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JTabbedPane jPanel_Fabricante;
    public javax.swing.JPanel jPanel_hardware;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JLabel labe_imagen_publicidad_mini;
    public javax.swing.JLabel label_año_lanza;
    public javax.swing.JLabel label_año_lanza1;
    public javax.swing.JLabel label_capacidad;
    public javax.swing.JLabel label_es_plus;
    public javax.swing.JLabel label_fabricante;
    public javax.swing.JLabel label_gama;
    private javax.swing.JLabel label_historia;
    public javax.swing.JLabel label_imagen_fondo;
    public javax.swing.JLabel label_inferior_contactos;
    public javax.swing.JLabel label_logo;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_nombre1;
    private javax.swing.JLabel label_nombre2;
    private javax.swing.JLabel label_nombre3;
    public javax.swing.JLabel label_nombre_linea_producto;
    public javax.swing.JLabel label_nombre_modelo;
    public javax.swing.JLabel label_nombre_oficial;
    public javax.swing.JLabel label_nombre_oficial1;
    public javax.swing.JLabel label_nombre_usuario;
    public javax.swing.JLabel label_nombre_version;
    public javax.swing.JLabel label_sesion;
    public javax.swing.JLabel label_version;
    public javax.swing.JLabel label_version1;
    public javax.swing.JPanel panel;
    public javax.swing.JPanel panel_aportes;
    public javax.swing.JPanel panel_aportes_soft;
    public javax.swing.JPanel panel_centro;
    public javax.swing.JPanel panel_contenedor;
    public javax.swing.JPanel panel_documentacion;
    public javax.swing.JPanel panel_documentacion_fabricante;
    public javax.swing.JPanel panel_documentacion_v;
    public javax.swing.JPanel panel_fabricante;
    public javax.swing.JPanel panel_inferior_central;
    public javax.swing.JPanel panel_linea_producto;
    public javax.swing.JPanel panel_modelo_individual;
    public javax.swing.JPanel panel_modelos;
    public javax.swing.JPanel panel_modelos_todos;
    public javax.swing.JPanel panel_publicitario_mini;
    public javax.swing.JPanel panel_versiones;
    private javax.swing.JScrollPane scroll_linea_producto;
    private javax.swing.JScrollPane scroll_modelo;
    private javax.swing.JScrollPane scroll_textA_historia;
    private javax.swing.JScrollPane scroll_versiones;
    public javax.swing.JTextArea textA_historia;
    // End of variables declaration//GEN-END:variables
}
