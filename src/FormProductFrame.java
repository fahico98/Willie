
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FormProductFrame extends javax.swing.JFrame {

   private Usuario login;
   private Producto prod = null;
   private String nombreTitulo, apellidoTitulo, rolTitulo;
   
   /**
    * Metodo constructor, recibe por parametro el usuario de la sesion iniciada.
    */
   public FormProductFrame(Usuario login){
      initComponents();
      this.login = login;
      etiquetaTitulo();
   }
   
   /**
    * Metodo constructor, recibe por parametro el usuario de la sesion iniciada
    * y una instancia de la clase 'Producto'.
    */
   public FormProductFrame(Usuario login, Producto prod){
      initComponents();
      this.prod = prod;
      this.login = login;
      etiquetaTitulo();
      llenarFormulario();
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
      etiquetaTituloFormProduct.setText("<html>" + rolTitulo + ": " + nombreTitulo + " " +
         apellidoTitulo + ".</html>");
   }
   
   /**
    * Metodo utilizado para llenar los campos del formulario con los datos del
    * objeto de tipo 'Producto' que se le pasa por parametro a su metodo
    * constructor y que se convierte en un atributo de la instancia.
    */
   private void llenarFormulario(){
      campoNombreProducto.setText(prod.getNombre());
      campoTipo.setText(prod.getTipo());
      campoCantidad.setText(prod.getCantidad() + "");
      campoUnidadMedida.setText(prod.getUnidadesMedida());
      campoPrecio.setText(prod.getPrecioUnitario() + "");
      campoTotalUnidades.setText(prod.getTotalUnidades() + "");
   }
   
   /**
    * Metodo de validacion del formulario.
    */
   private boolean validarFormulario(){
      
      // Se obtienen todos los valores ingresados por el usuario en los campos
      // del formulario.
      String nombre = campoNombreProducto.getText();
      String tipo = campoTipo.getText();
      String cantidad = campoCantidad.getText();
      String unidadMedida = campoUnidadMedida.getText();
      String precio = campoPrecio.getText();
      String unidades = campoTotalUnidades.getText();
      
      Pattern num = Pattern.compile("[0-9]+");
      Pattern alphaNum = Pattern.compile("[a-zA-Z0-9 ]+");
      
      // Se aplica un patron de validacion a cada campo del formulario
      // por medio de expresiones regulares.
      Matcher matNombre = alphaNum.matcher(nombre);
      Matcher matTipo = alphaNum.matcher(tipo);
      Matcher matCant = num.matcher(cantidad);
      Matcher matUnidMed = alphaNum.matcher(unidadMedida);
      Matcher matPrecio = num.matcher(precio);
      Matcher matUnid = num.matcher(unidades);
      
      // Se valida si alguno de los valores de los campos del formulario son
      // cadenas de caracteres vacias.
      if(nombre.compareTo("") == 0 || tipo.compareTo("") == 0 || cantidad.compareTo("") == 0 ||
         unidadMedida.compareTo("") == 0 || precio.compareTo("") == 0 || unidades.compareTo("") == 0){
         
         // Si alguno de los campos esta vacio se muestra al usuarios un aviso
         // de error y el metodo retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Ninguno de los campos debe estar vacio!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matNombre.matches()){
         
         // Si el campo del nombre del producto no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>El nombre del producto no debe contener caracteres especiales!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matTipo.matches()){
         
         // Si el campo del tipo del producto no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>El tipo del producto no debe contener caracteres especiales!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matCant.matches()){
         
         // Si el campo de la cantidad del producto no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>La cantidad de producto debe ser un número entero!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
         
      }else if(!matUnidMed.matches()){
         
         // Si el campo de las unidades de medida del producto no cumple con el
         // patron de validacion se muestra al usuario un mensaje de error y el
         // metodo retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Las unidades del producto no deben contener caracteres especiales!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matPrecio.matches()){
         
         // Si el campo del precio del producto no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>El precio del producto debe ser un número entero!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matUnid.matches()){
         
         // Si el campo de las unidades totales del producto no cumple con el
         // patron de validacion se muestra al usuario un mensaje de error y el
         // metodo retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Las unidades del producto deben ser un número entero!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else{
         
         // Si todas las validaciones se cumplen entonces el metodo retorna
         // 'true'
         return true;
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
      etiquetaTituloFormProduct = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      jLabel6 = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      campoNombreProducto = new javax.swing.JTextField();
      campoTipo = new javax.swing.JTextField();
      campoCantidad = new javax.swing.JTextField();
      campoUnidadMedida = new javax.swing.JTextField();
      campoPrecio = new javax.swing.JTextField();
      campoTotalUnidades = new javax.swing.JTextField();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      etiquetaTituloFormProduct.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
      etiquetaTituloFormProduct.setForeground(new java.awt.Color(0, 0, 0));
      etiquetaTituloFormProduct.setText("jLabel1");

      jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 0));
      jLabel1.setText("Datos del producto");

      jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(0, 0, 0));
      jLabel2.setText("Nombre del producto:");

      jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(0, 0, 0));
      jLabel3.setText("Tipo:");

      jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(0, 0, 0));
      jLabel4.setText("Cantidad de producto por unidad:");

      jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel5.setForeground(new java.awt.Color(0, 0, 0));
      jLabel5.setText("Unidad de medída:");

      jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel6.setForeground(new java.awt.Color(0, 0, 0));
      jLabel6.setText("Precio unitario:");

      jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel7.setForeground(new java.awt.Color(0, 0, 0));
      jLabel7.setText("Total unidades:");

      campoNombreProducto.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoTipo.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoCantidad.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoUnidadMedida.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoPrecio.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoTotalUnidades.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      jButton1.setForeground(new java.awt.Color(0, 0, 0));
      jButton1.setText("Guardar");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setForeground(new java.awt.Color(0, 0, 0));
      jButton2.setText("Limpiar campos");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

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
            .addComponent(etiquetaTituloFormProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addContainerGap())
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addGap(229, 229, 229))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(27, 27, 27)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel7)
                     .addComponent(jLabel6)
                     .addComponent(jLabel5)
                     .addComponent(jLabel4)
                     .addComponent(jLabel3)
                     .addComponent(jLabel2))
                  .addGap(18, 18, 18)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(campoUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(campoTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(105, 105, 105)
                  .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(etiquetaTituloFormProduct)
            .addGap(30, 30, 30)
            .addComponent(jLabel1)
            .addGap(47, 47, 47)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(campoNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(campoUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel6)
               .addComponent(campoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel7)
               .addComponent(campoTotalUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton1)
               .addComponent(jButton2)
               .addComponent(jButton3))
            .addGap(44, 44, 44))
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

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
      // Boton Limpiar campos.
      
      // Se establecen todas las cadenas de caracteres de los campos del
      // formulario en una cadena vacia "".
      campoNombreProducto.setText("");
      campoTipo.setText("");
      campoCantidad.setText("");
      campoUnidadMedida.setText("");
      campoPrecio.setText("");
      campoTotalUnidades.setText("");
      
   }//GEN-LAST:event_jButton2ActionPerformed

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
      // Boton Cancelar.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'DashboardFrame'.
      new DashboardFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton3ActionPerformed

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

      // Boton Guardar.
      
      if(validarFormulario()){
         
         // Si el metodo 'validarFormulario()' retorna 'true', entonces se
         // crea una instancia de la clase 'Conexion'.
         Conexion conexion = new Conexion();
         
         // Se obtienen y almacenan todas las cadenas de caracteres de los
         // campos del formulario.
         String nombre = campoNombreProducto.getText();
         String tipo = campoTipo.getText();
         String cantidad = campoCantidad.getText();
         String unidadMedida = campoUnidadMedida.getText();
         String precio = campoPrecio.getText();
         String unidades = campoTotalUnidades.getText();
         
         if(prod != null){
            
            // Si se paso por parametro al metodo constructor un objeto de tipo
            // 'Producto', entonces se llama al metodo 'actualizarProducto()' de
            // la variable 'conexion' y se le pasa por parametro una nueva
            // instancia de la clase 'Producto' con los datos ingresados en el
            // formulario y con el id del atributo 'prod'.
            conexion.actualizarProducto(
               new Producto(
                  prod.getId(),
                  nombre,
                  tipo,
                  Integer.parseInt(cantidad),
                  unidadMedida,
                  Integer.parseInt(precio),
                  Integer.parseInt(unidades)
               )
            );
            
            // Se le muestra al usuario un aviso de que la actualizacion del
            // producto fue realizada con exito.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Actualización de producto exitosa!<strong><html>",
               null,
               JOptionPane.INFORMATION_MESSAGE
            );
         }else{
            
            // Si no se paso por parametro al metodo constructor un objeto de
            // tipo 'Producto', entonces se llama al metodo 'agregarProducto()'
            // de la variable 'conexion' y se le pasa por parametro una nueva
            // instancia de la clase 'Producto' con los datos ingresados en el
            // formulario y con el id igual a 0.
            conexion.agregarProducto(
               new Producto(
                  0,
                  nombre,
                  tipo,
                  Integer.parseInt(cantidad),
                  unidadMedida,
                  Integer.parseInt(precio),
                  Integer.parseInt(unidades)
               )
            );
            
            // Se le muestra al usuario un aviso de que la insercion del
            // producto fue realizada con exito.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Producto registrado con exito!<strong><html>",
               null,
               JOptionPane.INFORMATION_MESSAGE
            );
         }
         
         // Se cierra la conexion con la base de datos.
         conexion.cerrarConexion();
         
         // Se cierra la ventana actual y se inicializa una nueva ventana de la
         // clase 'DashboardFrame'.
         new DashboardFrame(login).setVisible(true);
         dispose();
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
         java.util.logging.Logger.getLogger(FormProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(FormProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(FormProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(FormProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new FormProductFrame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField campoCantidad;
   private javax.swing.JTextField campoNombreProducto;
   private javax.swing.JTextField campoPrecio;
   private javax.swing.JTextField campoTipo;
   private javax.swing.JTextField campoTotalUnidades;
   private javax.swing.JTextField campoUnidadMedida;
   private javax.swing.JLabel etiquetaTituloFormProduct;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables
}
