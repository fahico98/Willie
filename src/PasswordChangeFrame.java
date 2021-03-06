
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class PasswordChangeFrame extends javax.swing.JFrame {

   private Usuario login;
   private String nombreTitulo, apellidoTitulo, rolTitulo;
   
   /**
    * Metodo constructor que recibe por parametro el usuario que esta logeado
    * en el momento.
    */
   public PasswordChangeFrame(Usuario login){
      
      initComponents();
      
      this.login = login;
      
      // Se le asignan a las variables 'nombreTitulo', 'apellidoTitulo' y
      // 'rolTitulo' los respectivos valores del usuario 'login'.
      nombreTitulo = login.getNombre().substring(0, 1).toUpperCase() +
         login.getNombre().substring(1).toLowerCase();
      apellidoTitulo = login.getApellido().substring(0, 1).toUpperCase() +
         login.getApellido().substring(1).toLowerCase();
      rolTitulo = login.getRol().substring(0, 1).toUpperCase() +
         login.getRol().substring(1).toLowerCase();
      
      // Se establece el titulo de la ventana en la variable
      // 'etiquetaTituloDashboard'.
      etiquetaTituloPasswordChange.setText("<html>" + rolTitulo + ": " + nombreTitulo + " " +
         apellidoTitulo + ".</html>");
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      etiquetaTituloPasswordChange = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      campoNuevaContrasena = new javax.swing.JPasswordField();
      campoReNuevaContrasena = new javax.swing.JPasswordField();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      etiquetaTituloPasswordChange.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
      etiquetaTituloPasswordChange.setForeground(new java.awt.Color(0, 0, 0));
      etiquetaTituloPasswordChange.setText("jLabel1");

      jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 0));
      jLabel1.setText("<html>Cambio de contraseña.</html>");

      jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(0, 0, 0));
      jLabel2.setText("Nueva contaseña:");

      jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(0, 0, 0));
      jLabel3.setText("Repita la nueva contraseña:");

      jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
      jButton1.setForeground(new java.awt.Color(0, 0, 0));
      jButton1.setText("Guardar");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
      jButton2.setForeground(new java.awt.Color(0, 0, 0));
      jButton2.setText("Cancelar");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      campoNuevaContrasena.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoReNuevaContrasena.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(etiquetaTituloPasswordChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(226, 226, 226))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(42, 42, 42)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel2)
                     .addComponent(jLabel3))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(campoNuevaContrasena)
                     .addComponent(campoReNuevaContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(144, 144, 144)
                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(49, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(etiquetaTituloPasswordChange)
            .addGap(34, 34, 34)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(42, 42, 42)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(campoNuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(campoReNuevaContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton1)
               .addComponent(jButton2))
            .addGap(60, 60, 60))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
      // Boton Guardar
      
      Conexion conexion = new Conexion();
      
      // Se obtienen y almacenan los valores de los campos del formulario.
      String contrasena = campoNuevaContrasena.getText();
      String reContrasena = campoReNuevaContrasena.getText();
      
      if(contrasena.compareTo("") != 0 && reContrasena.compareTo("") != 0){
         
         // Si ninguno de los campos es una cadena de caracteres vacia, se
         // procede a validar el contenido de cada campo por medio de
         // expresiones regulares.
         Pattern p = Pattern.compile("[^$%&/*ñ-]+");
         Matcher matCont = p.matcher(contrasena);
         Matcher matReCont = p.matcher(reContrasena);
         
         if(matCont.matches() && matReCont.matches()){
            
            // Si ambos campos superan la validacion se comparan los contenidos
            // de los campos 'camposNuevaContrasena' y 'campoReNuevaContrasena'
            if(contrasena.compareTo(reContrasena) == 0){
               
               // Si son iguales se llama al metodo
               // 'actualizarContrasenaUsuario' del objeto 'conexion' pasandole
               // por parametro el id del usuario y la nueva contraseña.
               conexion.actualizarContrasenaUsuario(login.getId(), contrasena);
               
               // Se muestra un aviso al usuario informandole que la contraseña
               // fue alcualizada con exito.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>Contraseña actualizada con exito!<strong><html>",
                  null,
                  JOptionPane.INFORMATION_MESSAGE
               );
               
               // Se cierra la ventana actual y se inicializa una nueva ventana
               // de la clase 'DashboardFrame'.
               new DashboardFrame(login).setVisible(true);
               dispose();
            }else{
               
               // Si los campos 'camposNuevaContrasena' y
               // 'campoReNuevaContrasena' no contienen la misma cadena de
               // caracteres se muestra un mensaje de error.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>Error de validación: Las contraseñas no coinciden!<strong><html>",
                  null,
                  JOptionPane.ERROR_MESSAGE
               );
            }
         }else{
            
            // Si los campos del formulario no superan la validacion por
            // expresiones regulares se muestra un mensaje de error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Asegurece de que su contraseña no contenga caracteres especiales!<strong><html>",
               null,
               JOptionPane.WARNING_MESSAGE
            );
         }
      }else{
         
         // Si alguno de los campos del formulario esta vacio, se muestra un 
         // mensaje de error.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Error de validación: Ninguno de los campos debe estar vacío!<strong><html>",
            null,
            JOptionPane.ERROR_MESSAGE
         );
      }
      
      // Se cierra la conexion con la base de datos.
      conexion.cerrarConexion();
      
   }//GEN-LAST:event_jButton1ActionPerformed

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
      // Boton Cancelar.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'DashboardFrame'.
      new DashboardFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton2ActionPerformed

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
         java.util.logging.Logger.getLogger(PasswordChangeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(PasswordChangeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(PasswordChangeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(PasswordChangeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            // new PasswordChangeFrame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPasswordField campoNuevaContrasena;
   private javax.swing.JPasswordField campoReNuevaContrasena;
   private javax.swing.JLabel etiquetaTituloPasswordChange;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables
}
