package interfaces;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nancy
 */
public class FrClientes extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public FrClientes() {
        initComponents();
        cargartabclientes("");
        cargarDatos();
        bloquearCampos();
        bloquearBotones();
    }
    
    private void bloquearCampos(){
        txtced.setEnabled(false);
        txtnombre.setEnabled(false);
        txtape.setEnabled(false);
        txtdir.setEnabled(false);
        txttel.setEnabled(false);
    }
    
    private void desbloquearCampos(){
        txtced.setEnabled(true);
        txtnombre.setEnabled(true);
        txtape.setEnabled(true);
        txtdir.setEnabled(true);
        txttel.setEnabled(true);
    }
    
    private void bloquearBotones(){
        btnguardar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnnuevo.setEnabled(true);
        
    }
    private void desbloquearNuevo(){
        btnguardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnsalir.setEnabled(true);
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
   
     private void cargarDatos() {
        tabclientes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tabclientes.getSelectedRow() != -1) {
                    int fila = tabclientes.getSelectedRow();
                     txtced.setText(tabclientes.getValueAt(fila, 0).toString().trim());
                     txtnombre.setText(tabclientes.getValueAt(fila, 1).toString().trim());
                    txtape.setText(tabclientes.getValueAt(fila, 2).toString().trim());
                    txtdir.setText(tabclientes.getValueAt(fila, 3).toString());
                    txttel.setText(tabclientes.getValueAt(fila, 4).toString().trim());
                     desbloquearCampos();
                     desboqTab();
                     
                }
            }
        });
    } 
       private void desboqTab(){
           btnnuevo.setEnabled(false);
           btnguardar.setEnabled(false);
           btnModificar.setEnabled(true);
           btnEliminar.setEnabled(true);
           btnsalir.setEnabled(true);
           btnCancelar.setEnabled(true);
       }
    
     public void keyTyped(KeyEvent ke) { 
            char c=ke.getKeyChar(); 
             if(Character.isDigit(c)) { 
              getToolkit().beep(); 
              ke.consume();   
          JOptionPane.showMessageDialog(null, "solo letras");    
          }             
        } 
    private void botonactualizar() {
        conexion cc = new conexion();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "update clientes set NOM_CLI='" + txtnombre.getText() + 
                "',APE_CLI='" + txtape.getText() + 
                "',DIR_CLI='" + txtdir.getText() +
                "',TEL_CLI='" + txttel.getText() +
             "' where CI_CLI='" + txtced.getText().trim().replace('-',' ').replaceAll(" ","") + "'";
        try {
            PreparedStatement psd = cn.prepareStatement(sql);
            int n = psd.executeUpdate();
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO");
                limpiartxt();
                cargartabclientes("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }        
    }
     void focoCedula(){
        String ced = txtced.getText();
        String ced1 = getCed(ced);

        if (!verifCedula(ced1)) {
            txtced.setText("");
            txtced.requestFocus();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtape = new javax.swing.JTextField();
        txtdir = new javax.swing.JTextField();
        txttel = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtced = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabclientes = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("CEDULA");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("APELLIDO");

        jLabel4.setText("DIRECCION");

        jLabel5.setText("TELEFONO");

        txtape.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapeKeyTyped(evt);
            }
        });

        txtdir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdirKeyTyped(evt);
            }
        });

        txttel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelKeyTyped(evt);
            }
        });

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

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
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtdir)
                    .addComponent(txttel, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(txtape)
                    .addComponent(txtnombre)
                    .addComponent(txtced, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(41, Short.MAX_VALUE))
        );

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

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(btnnuevo)
                    .addGap(12, 12, 12)
                    .addComponent(btnguardar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnModificar)
                    .addGap(6, 6, 6)
                    .addComponent(btnCancelar)
                    .addGap(9, 9, 9)
                    .addComponent(btnEliminar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnsalir)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Registro de Clientes");

        tabclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabclientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabclientes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void limpiartxt() {
        txtced.setText("");
        txtnombre.setText("");
        txtape.setText("");
        txtdir.setText("");
        txttel.setText("");
    }
private void botonnuevo(){
    limpiartxt();    
}
  public void borrar() {
        if (JOptionPane.showConfirmDialog(null, "SEGURO QUE QUIERE BORRAR", "BORRAR REGISTRO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String codigo = txtced.getText();
            String sql = " ";
            sql = "delete from clientes WHERE CI_CLI ='" + codigo + "'";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                int i = psd.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "REGISTRO BORRADO");
                    limpiartxt();
                    cargartabclientes("");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
DefaultTableModel modelo;
    public void cargartabclientes(String Dato) {
        String titulos[] = {"CEDULA", "NOMBRE", "APELLIDO", "DIRECCION", "TELEFONO"};
        String registros[] = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        
        conexion cc = new conexion();
        Connection cn = cc.conectar();
        String sql = "";
        sql = "select * from clientes where CI_CLI like '%" + Dato + "%'";
        try {
            Statement psd = cn.createStatement();
            ResultSet rs = psd.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("CI_CLI");
                registros[1] = rs.getString("NOM_CLI");
                registros[2] = rs.getString("APE_CLI");
                registros[3] = rs.getString("DIR_CLI");
                registros[4] = rs.getString("TEL_CLI");     
                modelo.addRow(registros);
            }
            tabclientes.setModel(modelo);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    private void guardar() {
        if (txtced.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar laced");
            txtced.requestFocus();
        } else if (txtnombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar nombre");
            txtape.requestFocus();
        } else if (txtape.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar apellido");
            txtape.requestFocus();
        } else if (txtdir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el dir");
            txtdir.requestFocus();
        } else if (txttel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el tele");
            txttel.requestFocus();
        } else {
            conexion cc = new conexion();
            Connection cn = cc.conectar();
            String CI_CLI, NOM_CLI, APE_CLI, DIR_CLI, TEL_CLI;
            String ced = txtced.getText().trim();
            String cedVer = getCed(ced);
            CI_CLI = cedVer;//.trim().replace('-',' ' ).replaceAll(" ", "");
//            CI_CLI = txtced.getText();//.trim().replace('-',' ' ).replaceAll(" ", "");
            NOM_CLI = txtnombre.getText();
            APE_CLI = txtape.getText();
            DIR_CLI = txtdir.getText();
            TEL_CLI = txttel.getText();
            String sql = "insert into clientes(CI_CLI,NOM_CLI,APE_CLI,DIR_CLI,TEL_CLI)VALUES(?,?,?,?,?)";
            try {
                PreparedStatement psd = cn.prepareStatement(sql);
                psd.setString(1, CI_CLI);
                psd.setString(2, NOM_CLI);
                psd.setString(3, APE_CLI);
                psd.setString(4, DIR_CLI);
                psd.setString(5, TEL_CLI);
                int n = psd.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "se inserto crrectamente");
                    cargartabclientes("");
                    limpiartxt();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        desbloquearCampos();
        desbloquearNuevo();
        limpiartxt();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        botonactualizar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        borrar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
         char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep();  
              evt.consume();     
          } 
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtdirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdirKeyTyped
          
    }//GEN-LAST:event_txtdirKeyTyped

    private void txttelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelKeyTyped
        char c=evt.getKeyChar(); 
          if(Character.isLetter(c)) { 
              getToolkit().beep(); 
              evt.consume(); 
          }
    }//GEN-LAST:event_txttelKeyTyped

    private void txtapeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapeKeyTyped
char c=evt.getKeyChar(); 
          if(Character.isDigit(c)) { 
              getToolkit().beep();  
              evt.consume();     
          }        // TODO add your handling code here:
    }//GEN-LAST:event_txtapeKeyTyped

    private void txtcedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedFocusLost
        focoCedula();
    }//GEN-LAST:event_txtcedFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
      limpiartxt();
       bloquearCampos();
       bloquearBotones();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tabclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabclientesMouseClicked
      
    }//GEN-LAST:event_tabclientesMouseClicked

   
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
            java.util.logging.Logger.getLogger(FrClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabclientes;
    private javax.swing.JTextField txtape;
    private javax.swing.JFormattedTextField txtced;
    private javax.swing.JTextField txtdir;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttel;
    // End of variables declaration//GEN-END:variables
}
