/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author User
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class FrCajeros extends javax.swing.JFrame {

    /**
     * Creates new form FrCajeros
     */
    public FrCajeros() {
        initComponents();
//         cargartabcajeros("");

        cargartabcajeros("");
        cargarDatos();

    }
    
    
    private String getCed(String ced) {
        System.out.println("CED: " + ced);
        ced = ced.replace('-', ' ').replaceAll(" ", "");
        System.out.println("ced1: " + ced);
        return ced;
    }
    
    
    
    private boolean verifCedula(String ced) {
        boolean verifica = false;
        int n = ced.length();
        int sumPar = 0, sumaImpar = 0, rpar, rimpar, sumTotal, deceSup, nVerif;
        String convn;
        if (n < 10 || n > 10) {
//            verifica = false;
//            JOptionPane.showMessageDialog(null, "La cédula debe tener 10 digitos");
//            System.out.println("cedula incorrecta");
        } else {
            String a = String.valueOf(ced.charAt(9));
            int nVerificador = Integer.valueOf(a);
//        System.out.println("numero verificador: "+nVerificador);
            for (int i = 0; i < 10; i += 2) {
                convn = String.valueOf(ced.charAt(i));
//                System.out.println("numero: "+convn);
                rpar = Integer.valueOf(convn) * 2;
//                System.out.println("rpar*2: "+rpar);
                if (rpar >= 10) {
                    rpar = rpar - 9;
                }
                sumPar += rpar;
            }
//            System.out.println("suma par: "+sumPar);
            for (int i = 1; i < 9; i += 2) {
                convn = String.valueOf(ced.charAt(i));
//                System.out.println("numero: "+convn);
                rimpar = Integer.valueOf(convn);
                sumaImpar += rimpar;
            }
//            System.out.println("suma impar: "+sumaImpar);
            sumTotal = sumPar + sumaImpar;
//            System.out.println("suma total: "+sumTotal);
            deceSup = ((int) sumTotal / 10) * 10 + 10;
            nVerif = deceSup - sumTotal;
//            System.out.println("num v: " + nVerif);
//            System.out.println(deceSup);
            if (nVerif == nVerificador || nVerif == 10) {
                verifica = true;
                //JOptionPane.showMessageDialog(null, "cedula correcta");
            }
        }
        if (!verifica) {
            JOptionPane.showMessageDialog(null, "Cedula incorrecta, Ingrese nueamente");
        }
        //        System.out.println("cedula es; " + verifica);
        return verifica;
    }
    
    
    void focoCedula(){
        String ced = txtced.getText();
        String ced1 = getCed(ced);

        if (!verifCedula(ced1)) {
            txtced.setText("");
            txtced.requestFocus();
        }
    }

    private void cargarDatos() {
        tblcajeros.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tblcajeros.getSelectedRow() != -1) {
                    int fila = tblcajeros.getSelectedRow();
                    txtced.setText(tblcajeros.getValueAt(fila, 0).toString().trim());
                    txtnombre.setText(tblcajeros.getValueAt(fila, 1).toString().trim());
                    txtape.setText(tblcajeros.getValueAt(fila, 2).toString().trim());
                    txtdir.setText(tblcajeros.getValueAt(fila, 3).toString());
                    jcbPerfil.setSelectedItem(tblcajeros.getValueAt(fila, 4).toString());
                }
            }
        });
    }

    DefaultTableModel modelo;

    public void cargartabcajeros(String Dato) {
        String titulos[] = {"CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "PERFIL"};
        String registros[] = new String[5];
        modelo = new DefaultTableModel(null, titulos);

        conexion cc = new conexion();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select * from CAJEROS where CI_CAJ like '%" + Dato + "%'";
        try {
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CI_CAJ");
                registros[1] = rs.getString("NOMBRE_CAJ");
                registros[2] = rs.getString("APELLIDO_CAJ");
                registros[3] = rs.getString("DIR_CAJ");
                registros[4] = rs.getString("PER_CAJ");

                modelo.addRow(registros);
            }
            tblcajeros.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void guardar() {
        if (txtced.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cedula");
            txtced.requestFocus();
        } else if (txtnombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre");
            txtnombre.requestFocus();
        } else if (txtape.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar apellido");
            txtape.requestFocus();
        } else if (txtdir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el direccion");
            txtdir.requestFocus();
        } else if (jcbPerfil.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el perfil");
            jcbPerfil.requestFocus();
        } else {

            conexion cc = new conexion();
            Connection cn = cc.conectar();

            String CI_CAJ, NOMBRE_CAJ, APELLIDO_CAJ, DIR_CAJ, PER_CAJ;
            String ced = txtced.getText().trim();
            String cedVe = getCed(ced);
            
            
            CI_CAJ = cedVe;//.trim().replace('-',' ' ).replaceAll(" ", "");
            NOMBRE_CAJ = txtnombre.getText();
            APELLIDO_CAJ = txtape.getText();
            DIR_CAJ = txtdir.getText();
            PER_CAJ = String.valueOf(jcbPerfil.getSelectedItem());

            String sql = "insert into CAJEROS(CI_CAJ,NOMBRE_CAJ,APELLIDO_CAJ,DIR_CAJ, PER_CAJ)VALUES(?,?,?,?,?)";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, CI_CAJ);
                psd.setString(2, NOMBRE_CAJ);
                psd.setString(3, APELLIDO_CAJ);
                psd.setString(4, DIR_CAJ);
                psd.setString(5, PER_CAJ);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Se inserto correctamente");
                    cargartabcajeros("");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void desbloqueartxt() {
        txtced.setEnabled(true);
        txtnombre.setEnabled(true);
        txtape.setEnabled(true);
        txtdir.setEnabled(true);
    }

    private void botoneslimpios() {
        btnnuevo.setEnabled(true);
        btnguardar.setEnabled(false);
//        btnmodificar.setEnabled(false);
//        jchbxVer.setEnabled(false);
//        btneliminar.setEnabled(false);
//        btncancelar.setEnabled(false);
        btnsalir.setEnabled(true);
    }

    public void limpiartxt() {
        txtced.setText("");
        txtnombre.setText("");
        txtape.setText("");
        txtdir.setText("");
    }

    public void borrar() {
        if (JOptionPane.showConfirmDialog(null, "SEGURO QUE QUIERE BORRAR", "BORRAR REGISTRO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String codigo = txtced.getText();
            String sql = " ";
            sql = "delete from CAJEROS WHERE CI_CAJ ='" + codigo + "'";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                int i = psd.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "REGISTRO BORRADO");
                    limpiartxt();
                    cargartabcajeros("");

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void botonactualizar() {
        conexion cc = new conexion();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "update CAJEROS set NOMBRE_CAJ='" + txtnombre.getText()
                + "',APELLIDO_CAJ='" + txtape.getText()
                + "',DIR_CAJ='" + txtdir.getText()
                + "' where CI_CAJ='" + txtced.getText().trim().replace('-', ' ').replaceAll(" ", "") + "'";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");
                limpiartxt();

                cargartabcajeros("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtape = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdir = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcajeros = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcbPerfil = new javax.swing.JComboBox();
        txtced = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CEDULA");

        jLabel2.setText("NOMBRE");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel3.setText("APELLIDO");

        jLabel4.setText("DIRECCION");

        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tblcajeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblcajeros);

        jButton1.setText("MODIFICAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ELIMINAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("CANCELAR");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Registro Cajeros");

        jLabel5.setText("PERFIL");

        jcbPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Perfil", "ADMINISTRADOR", "CAJERO" }));

        try {
            txtced.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtced.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcedFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(txtape)
                                            .addComponent(txtced, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(33, 33, 33)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jcbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel6)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnnuevo))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(btnguardar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3))
                    .addComponent(jLabel4))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jLabel5)
                    .addComponent(jcbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsalir)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
//        desbloqueartxt();
        limpiartxt();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        borrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        botonactualizar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtcedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedFocusLost
        focoCedula();
    }//GEN-LAST:event_txtcedFocusLost

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
            java.util.logging.Logger.getLogger(FrCajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCajeros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrCajeros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbPerfil;
    private javax.swing.JTable tblcajeros;
    private javax.swing.JTextField txtape;
    private javax.swing.JFormattedTextField txtced;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
