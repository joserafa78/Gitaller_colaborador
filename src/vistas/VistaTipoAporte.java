/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author naila
 */
public class VistaTipoAporte extends javax.swing.JFrame {

    /**
     * Creates new form VistaTipoAporte
     */
    public VistaTipoAporte() {
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

        panel_tipo_falla = new javax.swing.JPanel();
        combo_tipo_falla = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        text_id_tipo_falla = new javax.swing.JTextField();
        text_nombre_tipo_falla = new javax.swing.JTextField();
        boton_envia_tipo_falla = new javax.swing.JButton();
        panel_tipo_falla1 = new javax.swing.JPanel();
        combo_area_falla = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        text_id_area_falla = new javax.swing.JTextField();
        text_nombre_area_falla = new javax.swing.JTextField();
        boton_envia_area_falla = new javax.swing.JButton();
        panel_tipo_falla2 = new javax.swing.JPanel();
        combo_falla = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        text_id_falla = new javax.swing.JTextField();
        text_nombre__falla = new javax.swing.JTextField();
        boton_envia_falla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel_tipo_falla.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo Falla"));

        combo_tipo_falla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipo_fallaActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        text_id_tipo_falla.setEnabled(false);

        text_nombre_tipo_falla.setEnabled(false);

        boton_envia_tipo_falla.setText(">>");

        javax.swing.GroupLayout panel_tipo_fallaLayout = new javax.swing.GroupLayout(panel_tipo_falla);
        panel_tipo_falla.setLayout(panel_tipo_fallaLayout);
        panel_tipo_fallaLayout.setHorizontalGroup(
            panel_tipo_fallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tipo_fallaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_tipo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_id_tipo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_nombre_tipo_falla, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(boton_envia_tipo_falla))
        );
        panel_tipo_fallaLayout.setVerticalGroup(
            panel_tipo_fallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tipo_fallaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tipo_fallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_tipo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(text_id_tipo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nombre_tipo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_envia_tipo_falla))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panel_tipo_falla1.setBorder(javax.swing.BorderFactory.createTitledBorder("Area Falla"));

        combo_area_falla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_area_fallaActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        text_id_area_falla.setEnabled(false);

        text_nombre_area_falla.setEnabled(false);

        boton_envia_area_falla.setText(">>");

        javax.swing.GroupLayout panel_tipo_falla1Layout = new javax.swing.GroupLayout(panel_tipo_falla1);
        panel_tipo_falla1.setLayout(panel_tipo_falla1Layout);
        panel_tipo_falla1Layout.setHorizontalGroup(
            panel_tipo_falla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tipo_falla1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_area_falla, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_id_area_falla, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_nombre_area_falla)
                .addGap(18, 18, 18)
                .addComponent(boton_envia_area_falla))
        );
        panel_tipo_falla1Layout.setVerticalGroup(
            panel_tipo_falla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tipo_falla1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tipo_falla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_area_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(text_id_area_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nombre_area_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_envia_area_falla))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panel_tipo_falla2.setBorder(javax.swing.BorderFactory.createTitledBorder("Falla"));

        combo_falla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_fallaActionPerformed(evt);
            }
        });

        jLabel3.setText("ID:");

        text_id_falla.setEnabled(false);

        text_nombre__falla.setEnabled(false);

        boton_envia_falla.setText(">>");

        javax.swing.GroupLayout panel_tipo_falla2Layout = new javax.swing.GroupLayout(panel_tipo_falla2);
        panel_tipo_falla2.setLayout(panel_tipo_falla2Layout);
        panel_tipo_falla2Layout.setHorizontalGroup(
            panel_tipo_falla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tipo_falla2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(combo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_id_falla, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_nombre__falla)
                .addGap(18, 18, 18)
                .addComponent(boton_envia_falla))
        );
        panel_tipo_falla2Layout.setVerticalGroup(
            panel_tipo_falla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_tipo_falla2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_tipo_falla2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(text_id_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nombre__falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_envia_falla))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_tipo_falla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_tipo_falla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_tipo_falla2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_tipo_falla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_tipo_falla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_tipo_falla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_tipo_fallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipo_fallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipo_fallaActionPerformed

    private void combo_area_fallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_area_fallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_area_fallaActionPerformed

    private void combo_fallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_fallaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_fallaActionPerformed

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
            java.util.logging.Logger.getLogger(VistaTipoAporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaTipoAporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaTipoAporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaTipoAporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaTipoAporte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton boton_envia_area_falla;
    public javax.swing.JButton boton_envia_falla;
    public javax.swing.JButton boton_envia_tipo_falla;
    public javax.swing.JComboBox<String> combo_area_falla;
    public javax.swing.JComboBox<String> combo_falla;
    public javax.swing.JComboBox<String> combo_tipo_falla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panel_tipo_falla;
    private javax.swing.JPanel panel_tipo_falla1;
    private javax.swing.JPanel panel_tipo_falla2;
    public javax.swing.JTextField text_id_area_falla;
    public javax.swing.JTextField text_id_falla;
    public javax.swing.JTextField text_id_tipo_falla;
    public javax.swing.JTextField text_nombre__falla;
    public javax.swing.JTextField text_nombre_area_falla;
    public javax.swing.JTextField text_nombre_tipo_falla;
    // End of variables declaration//GEN-END:variables
}
