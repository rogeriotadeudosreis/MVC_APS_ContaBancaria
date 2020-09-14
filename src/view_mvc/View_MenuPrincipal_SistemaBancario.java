/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_mvc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roger
 */
public class View_MenuPrincipal_SistemaBancario extends javax.swing.JFrame {

    /**
     * Creates new form View_MVC_SistemaBancario
     */
    public View_MenuPrincipal_SistemaBancario() {
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

        jDesktopSistemaBancarioMVC = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadContas = new javax.swing.JMenu();
        jMenuItemContas = new javax.swing.JMenuItem();
        jMenuCadClientes = new javax.swing.JMenu();
        jMenuItemClientes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Bancário - MVC_Rogério Tadeu dos Reis");
        setFont(new java.awt.Font("Agency FB", 0, 12)); // NOI18N
        setResizable(false);

        javax.swing.GroupLayout jDesktopSistemaBancarioMVCLayout = new javax.swing.GroupLayout(jDesktopSistemaBancarioMVC);
        jDesktopSistemaBancarioMVC.setLayout(jDesktopSistemaBancarioMVCLayout);
        jDesktopSistemaBancarioMVCLayout.setHorizontalGroup(
            jDesktopSistemaBancarioMVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        jDesktopSistemaBancarioMVCLayout.setVerticalGroup(
            jDesktopSistemaBancarioMVCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuCadContas.setText("Abertura de Conta   -");
        jMenuCadContas.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItemContas.setText("Contas");
        jMenuItemContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContasActionPerformed(evt);
            }
        });
        jMenuCadContas.add(jMenuItemContas);

        jMenuBar1.add(jMenuCadContas);

        jMenuCadClientes.setText("Cadastro de Clientes");
        jMenuCadClientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMenuItemClientes.setText("Clientes");
        jMenuItemClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemClientesActionPerformed(evt);
            }
        });
        jMenuCadClientes.add(jMenuItemClientes);

        jMenuBar1.add(jMenuCadClientes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopSistemaBancarioMVC)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopSistemaBancarioMVC)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemClientesActionPerformed
        // TODO add your handling code here:
         try {

            new View_Cad_Clientes(this, true).setVisible(true);
            this.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(View_MenuPrincipal_SistemaBancario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemClientesActionPerformed

    private void jMenuItemContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContasActionPerformed
        try {

            new View_Abertura_Conta(this, true).setVisible(true);
            this.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(View_MenuPrincipal_SistemaBancario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItemContasActionPerformed

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
            java.util.logging.Logger.getLogger(View_MenuPrincipal_SistemaBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_MenuPrincipal_SistemaBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_MenuPrincipal_SistemaBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_MenuPrincipal_SistemaBancario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_MenuPrincipal_SistemaBancario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopSistemaBancarioMVC;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadClientes;
    private javax.swing.JMenu jMenuCadContas;
    private javax.swing.JMenuItem jMenuItemClientes;
    private javax.swing.JMenuItem jMenuItemContas;
    // End of variables declaration//GEN-END:variables
}