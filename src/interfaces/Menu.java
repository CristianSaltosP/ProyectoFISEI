/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Image;
import java.awt.Toolkit;
//import java.beans.PropertyVetoException;
//import java.sql.Connection;
//import javax.swing.JButton;
//import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JRViewer;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
      // jDesktopPane1.setBorder(new imagenfondo());
        this.setExtendedState(MAXIMIZED_BOTH);

    }

//@Override
//    @Override
//    public Image getIconImage() {
//        Image retValue = Toolkit.getDefaultToolkit().
//                getImage(ClassLoader.getSystemResource("Imagenes/logo.png"));
//        return retValue;
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU");
        setIconImage(getIconImage());

        jMenu1.setText("Interfaces");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Usuarios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Cerrar Sesión");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Salir");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        mnreportes.setText("Reportes");

        jMenuItem2.setText("Reporte Autos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnreportes.add(jMenuItem2);

        jMenuItem6.setText("viajes ");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        mnreportes.add(jMenuItem6);

        jMenuItem7.setText("Solo Autos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnreportes.add(jMenuItem7);

        jMenuBar1.add(mnreportes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static boolean cerrarAuto = false;
    public static boolean cerrarUsuario = false;
    public static boolean cerrarReportAut = false;
    public static boolean cerrarReportViaje = false;
    public static boolean cerrarReport = false;

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//        FrmAutos aut = new FrmAutos();
//        if (cerrarAuto == false) {
//            try {
//                // TODO add your handling code here:
//                jDesktopPane1.add(aut); //para añadir al panel la intefas de auto
//                aut.setMaximum(true);
//                aut.setMaximizable(true);
//                aut.show();
//            } catch (PropertyVetoException ex) {
//                JOptionPane.showMessageDialog(null, "no se pudo mostrar la ventana");
//            }
//            cerrarAuto = true;
//        } else {
//            JOptionPane.showMessageDialog(null, "Ventana abierta");
//            cerrarAuto = false;
//        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public void reporteAutoxMarca() {
//        ReportesAutosxMarca ra = new ReportesAutosxMarca();
//        if (ra.isShowing()) {
//            JOptionPane.showMessageDialog(null, "Ventana Activa");
//        } else {
//            jDesktopPane1.add(ra);
//            ra.show();
//        }
    }

    public void reporteViaje() {
////        ReportesViajes rv = new ReportesViajes();
////        if (rv.isShowing()) {
////            JOptionPane.showMessageDialog(null, "Ventana Activa");
////        } else {
////            jDesktopPane1.add(rv);
////            rv.show();
////        }
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        if (cerrarReportAut == false) {
//            reporteAutoxMarca();
//            cerrarReportAut = true;
//        } else {
//            JOptionPane.showMessageDialog(null, "Ventana abierta");
//            cerrarReportAut = false;
//        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed
    private void openUser() {
        FrCajeros usu = new FrCajeros();
        if (cerrarUsuario != true) {
            try {
                jDesktopPane1.add(usu); //para añadir al panel la intefas de auto
//                usu.setMaximum(true);
                usu.show();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "no se pudo mostrar la ventana");
            }
            cerrarUsuario = true;
        } else {
            cerrarUsuario = false;
            JOptionPane.showMessageDialog(null, "Ventana abierta");
        }
    }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        openUser();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    private void cerrarsesion() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Cerrar Sesión!", JOptionPane.YES_NO_OPTION);
        System.out.println("valor: " + resp);
        if (resp == 0) {
            this.dispose();
            Admin us = new Admin();
            us.show();
        }
    }

    private void salir() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "SALIR!", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            System.exit(0);
        }
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        cerrarsesion();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        salir();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    if (cerrarReportViaje == false) {
        reporteViaje();
        cerrarReportViaje = true;
    } else {
        JOptionPane.showMessageDialog(null, "Ventana abierta");
        cerrarReportViaje = false;
    }


}//GEN-LAST:event_jMenuItem6ActionPerformed

private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
    if (cerrarReport == false) {
        reporteAuto();
        cerrarReport = true;
    } else {
        JOptionPane.showMessageDialog(null, "Ventana abierta");
        cerrarReport = false;
    }
}//GEN-LAST:event_jMenuItem7ActionPerformed

    public void reporteAuto() {
//        try {
            //Autos
//            Conexion cc = new Conexion();
//            Connection cn = cc.getConexion();
//            JasperReport reporte = JasperCompileManager.compileReport("C:\\reportes\\R_Autos.jrxml");
//            JasperPrint print = JasperFillManager.fillReport(reporte, null, cn);
//            //JasperViewer.viewReport(print, false);
//            JInternalFrame frame = new JInternalFrame("Report");
//            frame.getContentPane().add(new JRViewer(print));
//            Menu.jDesktopPane1.add(frame);
//            frame.pack();
////            JButton btn =new JButton("Cerrar");
////            btn.setBounds(0, 0, 30, 20);
////            btn.doClick();
////            frame.add(btn);
//            frame.setClosable(true);
//            frame.setResizable(true);
//            frame.setIconifiable(true);
//            frame.setVisible(true);
//            frame.setSize(1270, 750);
//        } catch (JRException ex) {
//            JOptionPane.showMessageDialog(null, "No se cargo reporte");
//        }
    }
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static final javax.swing.JDesktopPane jDesktopPane1 = new javax.swing.JDesktopPane();
    public javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    public final javax.swing.JMenu mnreportes = new javax.swing.JMenu();
    // End of variables declaration//GEN-END:variables
}
