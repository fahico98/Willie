/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class LoginFrame extends javax.swing.JFrame {
   
   private Conexion conexion;
   
   /**
    * Creates new form LoginFrame
    */
   public LoginFrame() {
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

      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      etiquetaInformacion = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      campoLoginUsuario = new javax.swing.JTextField();
      campoLoginContrasena = new javax.swing.JPasswordField();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setPreferredSize(new java.awt.Dimension(600, 500));
      setResizable(false);

      jPanel1.setFocusCycleRoot(true);

      jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 0));
      jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      jLabel1.setText("<html><center>Minimercado, Frutas y Verduras El Primo</center></html>");

      etiquetaInformacion.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
      etiquetaInformacion.setForeground(new java.awt.Color(0, 0, 0));
      etiquetaInformacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      etiquetaInformacion.setText("<html>Por favor llene los campos para ingresar al sistema.</html>");

      jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(0, 0, 0));
      jLabel2.setText("<html>Nombre de usuario:</html>");

      jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(0, 0, 0));
      jLabel4.setText("<html>Contraseña:</html>");

      campoLoginUsuario.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoLoginContrasena.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
      jButton1.setForeground(new java.awt.Color(0, 0, 0));
      jButton1.setText("Ingresar");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
      jButton2.setForeground(new java.awt.Color(0, 0, 0));
      jButton2.setText("Salir");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(90, 90, 90)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(campoLoginContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(campoLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(65, 65, 65)
                  .addComponent(etiquetaInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(29, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(34, 34, 34)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(55, 55, 55)
            .addComponent(etiquetaInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(38, 38, 38)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(campoLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(campoLoginContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(49, 49, 49)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton1)
               .addComponent(jButton2))
            .addContainerGap(95, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
      String usuario = campoLoginUsuario.getText();
      String contrasena = campoLoginContrasena.getText();
      conexion = new Conexion();
      Usuario login = conexion.iniciarSesion(usuario, contrasena);
      if(login != null){
         new DashboardFrame(login).setVisible(true);
         dispose();
      }else{
         etiquetaInformacion.setText(
            "<html><font color='red'>Las credenciales ingresadas no son validas...!</font></html>"
         );
      }
      
   }//GEN-LAST:event_jButton1ActionPerformed

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
         java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new LoginFrame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPasswordField campoLoginContrasena;
   private javax.swing.JTextField campoLoginUsuario;
   private javax.swing.JLabel etiquetaInformacion;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables
}
