/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas_usuarios;

/**
 *
 * @author naila
 */
public class VistaUsuarioContenido extends javax.swing.JFrame {

    /**
     * Creates new form VistaUsuarioContenido
     */
    public VistaUsuarioContenido() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContenedor = new javax.swing.JPanel();
        boton_enviar = new javax.swing.JButton();
        panelCentro = new javax.swing.JPanel();
        boton_archivo = new javax.swing.JButton();
        combo_tipo_documento = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label_detalles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelContenedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelContenedor.setLayout(new java.awt.BorderLayout());

        boton_enviar.setText("Enviar");
        panelContenedor.add(boton_enviar, java.awt.BorderLayout.PAGE_END);

        boton_archivo.setText("Archivo (PDF)");

        combo_tipo_documento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        combo_tipo_documento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Cover", "Desarme", "Diagrama de Bloque", "Diagrama Eléctrico", "Especificaciones", "Información de Board", "Informacion del Diseño", "Impedancias", "Manual de Servicio en Hardware", "Manual de Servicio en Software", "Manual de Usuario", "Layout", "Parte de Elementos", "Partes Eléctricas", "Planos Esquemáticos" }));

        jLabel2.setText("Seleccione el Tipo de Documento");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        label_detalles.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        label_detalles.setForeground(new java.awt.Color(51, 51, 255));
        label_detalles.setText("Marca>Linea de Produccion>Modelo>Version");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(label_detalles, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label_detalles)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelCentroLayout = new javax.swing.GroupLayout(panelCentro);
        panelCentro.setLayout(panelCentroLayout);
        panelCentroLayout.setHorizontalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_archivo)
                    .addComponent(combo_tipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelCentroLayout.setVerticalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_tipo_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_archivo)
                .addGap(27, 27, 27))
        );

        panelContenedor.add(panelCentro, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelContenedor, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarioContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarioContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarioContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaUsuarioContenido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaUsuarioContenido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_archivo;
    public javax.swing.JButton boton_enviar;
    public javax.swing.JComboBox<String> combo_tipo_documento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel label_detalles;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelContenedor;
    // End of variables declaration//GEN-END:variables
}
