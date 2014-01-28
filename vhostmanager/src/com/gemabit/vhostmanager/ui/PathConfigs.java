/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gemabit.vhostmanager.ui;

/**
 *
 * @author lsoares
 */
public class PathConfigs extends javax.swing.JDialog {

    /**
     * Creates new form PathConfigs
     */
    public PathConfigs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        lblApachePath = new javax.swing.JLabel();
        txtApachePath = new javax.swing.JTextField();
        btnChooseApachePath = new javax.swing.JButton();
        btnChooseSitesAvailablePath = new javax.swing.JButton();
        lblSitesAvailablePath = new javax.swing.JLabel();
        txtSitesAvailabePath = new javax.swing.JTextField();
        btnChooseHootsPath = new javax.swing.JButton();
        lblHostsPath = new javax.swing.JLabel();
        txtHostsPath = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblApachePathValidation = new javax.swing.JLabel();
        lblSitesAvailablePathValidation = new javax.swing.JLabel();
        lblHostsPathValidation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblApachePath.setText("Apache:");

        btnChooseApachePath.setText("Choose");
        btnChooseApachePath.setSize(new java.awt.Dimension(90, 30));
        btnChooseApachePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseApachePathActionPerformed(evt);
            }
        });

        btnChooseSitesAvailablePath.setText("Choose");
        btnChooseSitesAvailablePath.setSize(new java.awt.Dimension(90, 30));

        lblSitesAvailablePath.setText("Sites Available:");

        btnChooseHootsPath.setText("Choose");
        btnChooseHootsPath.setPreferredSize(new java.awt.Dimension(90, 30));
        btnChooseHootsPath.setSize(new java.awt.Dimension(90, 30));

        lblHostsPath.setText("Hosts:");

        btnSave.setText("Save");
        btnSave.setSize(new java.awt.Dimension(90, 30));

        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCancel.setSize(new java.awt.Dimension(90, 30));

        lblApachePathValidation.setForeground(new java.awt.Color(255, 0, 0));
        lblApachePathValidation.setText("Validation label");

        lblSitesAvailablePathValidation.setForeground(new java.awt.Color(255, 0, 0));
        lblSitesAvailablePathValidation.setText("Validation label");

        lblHostsPathValidation.setForeground(new java.awt.Color(255, 0, 0));
        lblHostsPathValidation.setText("Validation label");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(txtApachePath)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnChooseApachePath))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(lblApachePath)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(lblApachePathValidation))
                                    .add(layout.createSequentialGroup()
                                        .add(lblSitesAvailablePath)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(lblSitesAvailablePathValidation))
                                    .add(layout.createSequentialGroup()
                                        .add(lblHostsPath)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(lblHostsPathValidation)))
                                .add(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(txtHostsPath)
                                    .add(txtSitesAvailabePath))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(layout.createSequentialGroup()
                                .add(111, 111, 111)
                                .add(btnSave)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 153, Short.MAX_VALUE)))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(btnChooseSitesAvailablePath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .add(btnChooseHootsPath, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(btnCancel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblApachePath)
                    .add(lblApachePathValidation))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtApachePath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChooseApachePath))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblSitesAvailablePath)
                    .add(lblSitesAvailablePathValidation))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtSitesAvailabePath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChooseSitesAvailablePath))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblHostsPath)
                    .add(lblHostsPathValidation))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtHostsPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnChooseHootsPath, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnSave))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseApachePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseApachePathActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_btnChooseApachePathActionPerformed

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
            java.util.logging.Logger.getLogger(PathConfigs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PathConfigs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PathConfigs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PathConfigs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PathConfigs dialog = new PathConfigs(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChooseApachePath;
    private javax.swing.JButton btnChooseHootsPath;
    private javax.swing.JButton btnChooseSitesAvailablePath;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblApachePath;
    private javax.swing.JLabel lblApachePathValidation;
    private javax.swing.JLabel lblHostsPath;
    private javax.swing.JLabel lblHostsPathValidation;
    private javax.swing.JLabel lblSitesAvailablePath;
    private javax.swing.JLabel lblSitesAvailablePathValidation;
    private javax.swing.JTextField txtApachePath;
    private javax.swing.JTextField txtHostsPath;
    private javax.swing.JTextField txtSitesAvailabePath;
    // End of variables declaration//GEN-END:variables
}