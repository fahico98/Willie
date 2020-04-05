
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FormClientFrame extends javax.swing.JFrame {

   private Usuario login;
   private Cliente cliente = null;
   private String nombreTitulo, apellidoTitulo, rolTitulo;
   
   /**
    * Metodo constructor, recibe por parametro el usuario de la sesion iniciada.
    */
   public FormClientFrame(Usuario login) {
      initComponents();
      this.login = login;
      etiquetaTitulo();
   }
   
   /**
    * Metodo constructor, recibe por parametro el usuario de la sesion iniciada
    * y una instancia de la clase 'Cliente'.
    */
   public FormClientFrame(Usuario login, Cliente cliente){
      initComponents();
      this.cliente = cliente;
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
      etiquetaTituloFormClient.setText("<html>" + rolTitulo + ": " + nombreTitulo + " " +
         apellidoTitulo + ".</html>");
   }
   
   /**
    * Metodo utilizado para llenar los campos del formulario con los datos del
    * objeto de tipo 'Cliente' que se le pasa por parametro a su metodo
    * constructor y que se convierte en un atributo de la instancia.
    */
   private void llenarFormulario(){
      campoNombreCliente.setText(cliente.getNombre());
      campoApellidoCliente.setText(cliente.getApellido());
      campoEdadCliente.setText(cliente.getEdad() + "");
      campoDireccionCliente.setText(cliente.getDireccion());
      campoTelefonoCliente.setText(cliente.getTelefono());
   }
   
   /**
    * Metodo de validacion del formulario.
    */
   private boolean validarFormulario(){
      
      // Se obtienen todos los valores ingresados por el usuario en los campos
      // del formulario.
      String nombre = campoNombreCliente.getText();
      String apellido = campoApellidoCliente.getText();
      String edad = campoEdadCliente.getText();
      String direccion = campoDireccionCliente.getText();
      String telefono = campoTelefonoCliente.getText();
      
      Pattern num = Pattern.compile("[0-9]+");
      Pattern alphaNum = Pattern.compile("[a-zA-Z0-9 ]+");
      Pattern alpha = Pattern.compile("[a-zA-Z ]+");
      
      // Se aplica un patron de validacion a cada campo del formulario
      // por medio de expresiones regulares.
      Matcher matNombre = alpha.matcher(nombre);
      Matcher matApellido = alpha.matcher(apellido);
      Matcher matEdad = num.matcher(edad);
      Matcher matDireccion = Pattern.compile("[a-zA-Z0-9#.\\- ]+").matcher(direccion);
      Matcher matTelefono = alphaNum.matcher(telefono);
      
      // Se valida si alguno de los valores de los campos del formulario son
      // cadenas de caracteres vacias.
      if(nombre.compareTo("") == 0 || apellido.compareTo("") == 0 || edad.compareTo("") == 0 ||
         direccion.compareTo("") == 0 || telefono.compareTo("") == 0){
         
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
         
         // Si el campo del nombre del cliente no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>El nombre del cliente solo debe contener letras!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matApellido.matches()){
         
         // Si el campo del apellido del cliente no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>El apellido del cliente solo debe contener letras!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matEdad.matches()){
         
         // Si el campo de la edad del cliente no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>La edad del cliente solo puede contener caracteres numéricos!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
         
      }else if(!matDireccion.matches()){
         
         // Si el campo de la direccion del cliente no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Caracteres invalidos en la direción del cliente!<strong><html>",
            null,
            JOptionPane.WARNING_MESSAGE
         );
         return false;
      }else if(!matTelefono.matches()){
         
         // Si el campo del telefono del cliente no cumple con el patron de
         // validacion se muestra al usuario un mensaje de error y el metodo
         // retorna 'false'.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>El telefono del cliente no debe contener caracteres especiales!<strong><html>",
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
      etiquetaTituloFormClient = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      campoNombreCliente = new javax.swing.JTextField();
      campoApellidoCliente = new javax.swing.JTextField();
      campoEdadCliente = new javax.swing.JTextField();
      campoDireccionCliente = new javax.swing.JTextField();
      campoTelefonoCliente = new javax.swing.JTextField();
      jLabel6 = new javax.swing.JLabel();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      etiquetaTituloFormClient.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
      etiquetaTituloFormClient.setForeground(new java.awt.Color(0, 0, 0));
      etiquetaTituloFormClient.setText("jLabel1");

      jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 0));
      jLabel1.setText("Nombre:");

      jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(0, 0, 0));
      jLabel2.setText("Apellido:");

      jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(0, 0, 0));
      jLabel3.setText("Edad:");

      jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel4.setForeground(new java.awt.Color(0, 0, 0));
      jLabel4.setText("Dirección:");

      jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel5.setForeground(new java.awt.Color(0, 0, 0));
      jLabel5.setText("Teléfono:");

      campoNombreCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoApellidoCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoEdadCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoDireccionCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoTelefonoCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel6.setForeground(new java.awt.Color(0, 0, 0));
      jLabel6.setText("Datos del cliente");

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
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(etiquetaTituloFormClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addContainerGap())
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                           .addComponent(jLabel1)
                           .addComponent(jLabel3)
                           .addComponent(jLabel2)
                           .addComponent(jLabel4)
                           .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(campoNombreCliente)
                           .addComponent(campoApellidoCliente)
                           .addComponent(campoEdadCliente)
                           .addComponent(campoDireccionCliente)
                           .addComponent(campoTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(237, 237, 237))))))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(94, 94, 94)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 94, Short.MAX_VALUE))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(etiquetaTituloFormClient)
            .addGap(44, 44, 44)
            .addComponent(jLabel6)
            .addGap(43, 43, 43)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(campoNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(campoApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(campoEdadCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(campoDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(campoTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(51, 51, 51)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton1)
               .addComponent(jButton2)
               .addComponent(jButton3))
            .addContainerGap(58, Short.MAX_VALUE))
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
      campoNombreCliente.setText("");
      campoApellidoCliente.setText("");
      campoEdadCliente.setText("");
      campoDireccionCliente.setText("");
      campoTelefonoCliente.setText("");
      
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
         String nombre = campoNombreCliente.getText();
         String apellido = campoApellidoCliente.getText();
         String edad = campoEdadCliente.getText();
         String direccion = campoDireccionCliente.getText();
         String telefono = campoTelefonoCliente.getText();
         
         if(cliente != null){
            
            // Si se paso por parametro al metodo constructor un objeto de tipo
            // 'Cliente', entonces se llama al metodo 'actualizarCliente()' de
            // la variable 'conexion' y se le pasa por parametro una nueva
            // instancia de la clase 'Cliente' con los datos ingresados en el
            // formulario y con el id del atributo 'cliente'.
            conexion.actualizarCliente(
               new Cliente(
                  cliente.getId(),
                  nombre,
                  apellido,
                  Integer.parseInt(edad),
                  direccion,
                  telefono
               )
            );
            
            // Se le muestra al usuario un aviso de que la actualizacion del
            // cliente fue realizada con exito.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Actualización de cliente exitosa!<strong><html>",
               null,
               JOptionPane.INFORMATION_MESSAGE
            );
         }else{
            
            // Si no se paso por parametro al metodo constructor un objeto de
            // tipo 'Cliente', entonces se llama al metodo 'agregarCliente()' de
            // la variable 'conexion' y se le pasa por parametro una nueva
            // instancia de la clase 'Cliente' con los datos ingresados en el
            // formulario y con el id igual a 0.
            conexion.agregarCliente(
               new Cliente(
                  0,
                  nombre,
                  apellido,
                  Integer.parseInt(edad),
                  direccion,
                  telefono
               )
            );
            
            // Se le muestra al usuario un aviso de que la insercion del
            // cliente fue realizada con exito.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Cliente registrado con exito!<strong><html>",
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
         java.util.logging.Logger.getLogger(FormClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(FormClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(FormClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(FormClientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new FormClientFrame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField campoApellidoCliente;
   private javax.swing.JTextField campoDireccionCliente;
   private javax.swing.JTextField campoEdadCliente;
   private javax.swing.JTextField campoNombreCliente;
   private javax.swing.JTextField campoTelefonoCliente;
   private javax.swing.JLabel etiquetaTituloFormClient;
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
   // End of variables declaration//GEN-END:variables
}
