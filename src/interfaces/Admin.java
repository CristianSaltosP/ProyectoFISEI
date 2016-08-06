/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

//import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Admin extends javax.swing.JFrame {

//    Utilidades md5 = new Utilidades();

    public Admin() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtmensaje.setVisible(false);
        jpfPasswd.setEchoChar('•');
        
//        jPanel1.setBorder(new imagenfondo());
    }
@Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("Imagenes/logo.png"));
        return retValue;

    }
    private void mostrarPasswd() {
        //String ver=jpfPasswd.getText();
        if (jchbxVer.isSelected()) {
            jpfPasswd.setEchoChar((char) 0);
        } else {
            jpfPasswd.setEchoChar('•');

        }
    }

    private String getPasswd(JPasswordField pswd) {
        String pass = "";
        char[] passwd = pswd.getPassword();
        for (int i = 0; i < passwd.length; i++) {
            pass += passwd[i];
        }
        return pass;
    }

//    private void ok() {
//        try {
//            Conexion cc = new Conexion();
//            Connection cn = cc.conectar();
//            String sql = "";
//            sql = "select * from usuarios";
//            Statement psd = cn.createStatement();
//            ResultSet rs = psd.executeQuery(sql);
//            String var1 = txtusuario.getText();
//            //String var2=jpfPasswd.getText();
//            String var2 = md5.Encriptar(jpfPasswd.getText());
//            while (rs.next()) {
//                String var3 = rs.getString("usu_cedula");
//                String var4 = rs.getString("usu_clave");
//                if ((var1.equals(var3)) && (var2.equals(var4))) {
//                    if (rs.getString("usu_perfil").equals("ADMINISTRADOR")) {
//                        Menu mn = new Menu();
//                        mn.setVisible(true);
//                        this.dispose();
//                    }
//                    if (rs.getString("usu_perfil").equals("SUPERVISOR")) {
//                        Menu mn = new Menu();
//                        mn.setVisible(true);
////                        mn.mnreportes.setEnabled(false);
//                        mn.jMenuItem3.setEnabled(false);
//
//                        this.dispose();
//                    }
//                } else {
//                    txtmensaje.setVisible(true);
//                    txtusuario.setText("");
//                    jpfPasswd.setText("");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }

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
        btningresar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        txtmensaje = new javax.swing.JLabel();
        jpfPasswd = new javax.swing.JPasswordField();
        jchbxVer = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setIconImage(getIconImage());
        setResizable(false);

        jLabel1.setText("USUARIO");

        jLabel2.setText("CONTRASEÑA");

        btningresar.setBackground(new java.awt.Color(102, 255, 102));
        btningresar.setText("INGRESAR");
        btningresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btningresarMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btningresarMouseReleased(evt);
            }
        });
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        btningresar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btningresarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btningresarFocusLost(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(255, 102, 102));
        btncancelar.setText("CANCELAR");
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarMouseClicked(evt);
            }
        });
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtusuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusuarioFocusLost(evt);
            }
        });
        txtusuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtusuarioKeyTyped(evt);
            }
        });

        txtmensaje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtmensaje.setForeground(new java.awt.Color(204, 0, 0));
        txtmensaje.setText("USUARIO INCORRECTO");

        jchbxVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchbxVerActionPerformed(evt);
            }
        });

        jPanel2.setOpaque(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtmensaje))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                    .addComponent(jpfPasswd))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jchbxVer))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btningresar)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jpfPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jchbxVer))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btncancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtmensaje)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
new Menu().setVisible(true);//        ok();
    }//GEN-LAST:event_btningresarActionPerformed

    private void jchbxVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchbxVerActionPerformed
        mostrarPasswd();
    }//GEN-LAST:event_jchbxVerActionPerformed
    private void salir() {
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        System.out.println("valor: " + resp);
        if (resp == 0) {
            System.exit(0);
        }
    }
    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        salir();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btningresarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btningresarFocusGained
    }//GEN-LAST:event_btningresarFocusGained

    private void btningresarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btningresarFocusLost
// TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_btningresarFocusLost

    private void btningresarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_btningresarMouseReleased

    private void btningresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btningresarMouseClicked

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarMouseClicked
  private void soloNumeros(java.awt.event.KeyEvent evt) {                                    
        char c;
        c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            getToolkit().beep();
            evt.consume();
//            JOptionPane.showMessageDialog(null, "Ingresa Solo Numeros");
        }}
    private void txtusuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyTyped
       soloNumeros(evt);
    }//GEN-LAST:event_txtusuarioKeyTyped

    private void txtusuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusuarioFocusGained
    }//GEN-LAST:event_txtusuarioFocusGained

    private void txtusuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusuarioKeyPressed
    }//GEN-LAST:event_txtusuarioKeyPressed

//    private void verifUser() {
//        String cad = txtusuario.getText().trim();
//        if (cad.length() > 10 || cad.length() < 10) {
//            JOptionPane.showMessageDialog(null, "Ingrese usuario correctamente");
//            txtusuario.setText("");
//            txtusuario.requestFocus();
//        }
//    }
    private void txtusuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusuarioFocusLost
//        verifUser(); // TODO add your handling code here:
    }//GEN-LAST:event_txtusuarioFocusLost

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btningresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JCheckBox jchbxVer;
    private javax.swing.JPasswordField jpfPasswd;
    private javax.swing.JLabel txtmensaje;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
