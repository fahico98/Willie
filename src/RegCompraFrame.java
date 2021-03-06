
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class RegCompraFrame extends javax.swing.JFrame {

   private Usuario login;
   private String nombreTitulo, apellidoTitulo, rolTitulo;
   
   /**
    * Metodo constructor, recibe por parametro el usuario de la sesion iniciada.
    */
   public RegCompraFrame(Usuario login){
      initComponents();
      this.login = login;
      etiquetaTitulo();
   }
   
   /**
    * Metodo que asigna a las variables 'nombreTitulo', 'apellidoTitulo' y
    * 'rolTitulo' los respectivos valores del usuario 'login'.
    */
   private void etiquetaTitulo(){
      nombreTitulo = login.getNombre().substring(0, 1).toUpperCase() +
         login.getNombre().substring(1).toLowerCase();
      apellidoTitulo = login.getApellido().substring(0, 1).toUpperCase() +
         login.getApellido().substring(1).toLowerCase();
      rolTitulo = login.getRol().substring(0, 1).toUpperCase() +
         login.getRol().substring(1).toLowerCase();
      
      // Se establece el titulo de la ventana en la variable
      // 'etiquetaTituloFormClient'.
      etiquetaTituloRegCompra.setText("<html>" + rolTitulo + ": " + nombreTitulo + " " +
         apellidoTitulo + ".</html>");
   }

   /**
    * Metodo de validacion del formulario.
    */
   private boolean validarFormulario(){
      
      Conexion conexion = new Conexion();
      
      // Se obtienen y almacenan los valores de los campos del formulario.
      String idCliente = campoIdCliente.getText();
      String idProducto = campoIdProducto.getText();
      String cantidadCompra = campoCantidadCompra.getText();
      
      Pattern num = Pattern.compile("[0-9]+");
      
      // Se aplica un patron de validacion a cada campo del formulario
      // por medio de expresiones regulares.
      Matcher matIdCliente = num.matcher(idCliente);
      Matcher matIdProducto = num.matcher(idProducto);
      Matcher matCantCompra = num.matcher(cantidadCompra);
      
      // Se llama al metodo 'compraPosible()' del objeto 'conexion' pasandole
      // por parametros el id del cliente, el id del producto y la cantidad de
      // producto que se desea comprar.
      String compraPosible = conexion.compraPosible(
         Integer.parseInt(idCliente),
         Integer.parseInt(idProducto),
         Integer.parseInt(cantidadCompra)
      );
      
      // Se cierra la conexion con la base de datos.
      conexion.cerrarConexion();
      
      if(idCliente.compareTo("") == 0 || idProducto.compareTo("") == 0 || cantidadCompra.compareTo("") == 0){
         
         // Si alguno de los campos del formulario esta vacio se muestra al
         // usuario un aviso de error y el metodo retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Ninguno de los campos debe estar vacio!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
         
      }else if(!matIdCliente.matches() || !matIdProducto.matches() || !matCantCompra.matches()){
         
         // Si alguna de las cadenas contenidas en los campos del formulario
         // no supera la validacion por expresiones regulares se muestra un
         // aviso de error al usuario y el metodo retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Este formulario solo recibe caracteres numéricos!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
         
      }else if(compraPosible.compareTo("true") != 0){
         
         if(compraPosible.compareTo("client not found") == 0){
            
            // Si el metodo 'compraPosible()' retorna la cadena
            // "client not found", entonces se muestra al usuario un aviso de
            // error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Cliente no encontrado!<strong><html>",
               null,
               JOptionPane.ERROR_MESSAGE
            );
            
         }else if(compraPosible.compareTo("product not found") == 0){
            
            // Si el metodo 'compraPosible()' retorna la cadena
            // "product not found", entonces se muestra al usuario un aviso de
            // error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Producto no encontrado!<strong><html>",
               null,
               JOptionPane.ERROR_MESSAGE
            );
            
         }else if(compraPosible.compareTo("sold out") == 0){
            
            // Si el metodo 'compraPosible()' retorna la cadena
            // "sold out", entonces se muestra al usuario un aviso de error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>La cantidad de producto en el inventario no es suficiente<br>" +
                  "para efectuar la compra!<strong><html>",
               null,
               JOptionPane.WARNING_MESSAGE
            );
            
         }
         
         // El metodo retorna 'false'.
         return false;
         
      }else{
         
         // Si los campos pasan todas las validaciones el metodo retorna 'true'.
         return true;
      }
   }
   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      etiquetaTituloRegCompra = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      campoIdCliente = new javax.swing.JTextField();
      campoIdProducto = new javax.swing.JTextField();
      campoCantidadCompra = new javax.swing.JTextField();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      etiquetaTituloRegCompra.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
      etiquetaTituloRegCompra.setForeground(new java.awt.Color(0, 0, 0));
      etiquetaTituloRegCompra.setText("jLabel1");

      jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 0));
      jLabel1.setText("Datos de la compra");

      jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(0, 0, 0));
      jLabel2.setText("Id del cliente:");

      jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(0, 0, 0));
      jLabel3.setText("Id del producto:");

      jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(0, 0, 0));
      jLabel4.setText("Candidad de compra:");

      campoIdCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoIdProducto.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoCantidadCompra.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
      jButton1.setForeground(new java.awt.Color(0, 0, 0));
      jButton1.setText("Aceptar");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
      jButton2.setForeground(new java.awt.Color(0, 0, 0));
      jButton2.setText("Limpiar campos");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      jButton3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
      jButton3.setForeground(new java.awt.Color(0, 0, 0));
      jButton3.setText("Cancelar");
      jButton3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(etiquetaTituloRegCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addContainerGap())
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel2)
                     .addComponent(jLabel3)
                     .addComponent(jLabel4))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(campoIdCliente)
                     .addComponent(campoIdProducto)
                     .addComponent(campoCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(116, 116, 116))))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(233, 233, 233)
            .addComponent(jLabel1)
            .addGap(0, 0, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(88, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(78, 78, 78))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(etiquetaTituloRegCompra)
            .addGap(35, 35, 35)
            .addComponent(jLabel1)
            .addGap(39, 39, 39)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(campoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(campoIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(campoCantidadCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(40, 40, 40)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton2)
               .addComponent(jButton1)
               .addComponent(jButton3))
            .addContainerGap(50, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      // Boton Aceptar.
      
      Conexion conexion = new Conexion();
      
      if(validarFormulario()){
         
         // Si el metodo 'validarFormulario()' retorna 'true', entonces se llama
         // al metodo 'compraPosible()' del objeto 'conexion'.
         String compraPosible = conexion.compraPosible(
            Integer.parseInt(campoIdCliente.getText()),
            Integer.parseInt(campoIdProducto.getText()),
            Integer.parseInt(campoCantidadCompra.getText())
         );
         
         if(compraPosible.compareTo("true") == 0){
            
            // Si 'compraPosible()' retorna 'true', entonces se llama al metodo
            // 'efectuarCompra()' del objeto 'conexion'.
            conexion.efectuarCompra(
               Integer.parseInt(campoIdCliente.getText()),
               Integer.parseInt(campoIdProducto.getText()),
               Integer.parseInt(campoCantidadCompra.getText())
            );
         }
      }
      
      // Se cierra la conexion con la base de datos.
      conexion.cerrarConexion();
      
      // Se muestra un aviso al usuario para informarle que la compra se
      // registro con exito.
      JOptionPane.showMessageDialog(
         null,
         "<html><strong>Compra registrada con exito!<strong><html>",
         null,
         JOptionPane.INFORMATION_MESSAGE
      );
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'DashboardFrame'.
      new DashboardFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton1ActionPerformed

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
      // Boton Limpiar campos.
      
      // Se establecen todas las cadenas de caracteres de los campos del
      // formulario en una cadena vacia "".
      campoIdCliente.setText("");
      campoIdProducto.setText("");
      campoCantidadCompra.setText("");
      
   }//GEN-LAST:event_jButton2ActionPerformed

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
      // Boton Cancelar.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'DashboardFrame'.
      new DashboardFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton3ActionPerformed

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
         java.util.logging.Logger.getLogger(RegCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(RegCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(RegCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(RegCompraFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new RegCompraFrame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField campoCantidadCompra;
   private javax.swing.JTextField campoIdCliente;
   private javax.swing.JTextField campoIdProducto;
   private javax.swing.JLabel etiquetaTituloRegCompra;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables
}
