
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DashboardFrame extends javax.swing.JFrame {

   private Usuario login;
   private String nombreTitulo, apellidoTitulo, rolTitulo;
   private DefaultTableModel modeloProductos, modeloClientes;
   
   /**
    * Metodo constructor, recibe por parametro el usuario de la sesion iniciada.
    */
   public DashboardFrame(Usuario login){
      
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
      etiquetaTituloDashboard.setText("<html>" + rolTitulo + ": " + nombreTitulo + " " +
         apellidoTitulo + ".</html>");
      
      // Metodo para restaurar los campos del formulario.
      restaurar();
      
      // Se invoca al metodo para llenar las tablas de la ventana.
      llenarTablas();
   }
   
   /**
    * Se llenan los campos del formulario de la pestaña 'Cuenta' con los
    * datos del usuario logeado.
    */
   public void restaurar(){
      campoNombreCuenta.setText(login.getNombre());
      campoApellidoCuenta.setText(login.getApellido());
      campoRolCuenta.setText(login.getRol());
      campoUsuarioCuenta.setText(login.getUsuario());
   }
   
   /**
    * Metodo para llenar las tablas de las pestañas 'Clietnes' e 'Inventario'.
    */
   public void llenarTablas(){
      
      Conexion conexion = new Conexion();
      String[] array;
      int size;
      
      // Modelo para la tabla de productos.
      modeloProductos = new DefaultTableModel();
      
      // Se definen los titulos de la cabecera de la tabla de productos.
      modeloProductos.addColumn("<html>Id</html>");
      modeloProductos.addColumn("<html>Producto</html>");
      modeloProductos.addColumn("<html>Tipo</html>");
      modeloProductos.addColumn("<html>Cantidad por unidad</html>");
      modeloProductos.addColumn("<html>Unidad de medida</html>");
      modeloProductos.addColumn("<html>Precio unitario</html>");
      modeloProductos.addColumn("<html>Total unidades</html>");
      
      // Se agrega el modelo a la tabla de productos.
      this.tablaProductos.setModel(modeloProductos);
      
      // Se establecen la anchura, en pixeles, de las columnas de la tabla de
      // productos.
      tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(30);
      tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(150);
      tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(100);
      tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(150);
      tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(70);
      tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(120);
      tablaProductos.getColumnModel().getColumn(6).setPreferredWidth(60);
      
      // Se vacia la tabla de productos.
      ((DefaultTableModel)tablaProductos.getModel()).setNumRows(0);
      
      // Se obtienen la lista enlazada con los productos de la base de datos.
      LinkedList<Producto> productos = conexion.listaProductos();
      array = new String[7];
      size = productos.size();
      
      // Se recorre la lista enlazada de productos y se llenan las celdas de la
      // tabla de productos con los atributos de los objetos de tipo 'Producto'
      // en la lista enlazada, se van eliminando objetos de la lista a medida
      // que esta se recorre.
      for (int i = 0; i < size; i++) {
         Producto p = productos.poll();
         array[0] = p.getId() + "";
         array[1] = p.getNombre();
         array[2] = p.getTipo();
         array[3] = p.getCantidad() + "";
         array[4] = p.getUnidadesMedida() + "";
         array[5] = p.getPrecioUnitario() + "";
         array[6] = p.getTotalUnidades() + "";
         modeloProductos.addRow(array);
      }
      
      // Modelo para la tabla de clientes.
      modeloClientes = new DefaultTableModel();
      
      
      // Se definen los titulos de la cabecera de la tabla de clientes.
      modeloClientes.addColumn("<html>Id</html>");
      modeloClientes.addColumn("<html>Nombre</html>");
      modeloClientes.addColumn("<html>Apellido</html>");
      modeloClientes.addColumn("<html>Edad</html>");
      modeloClientes.addColumn("<html>Dirección</html>");
      modeloClientes.addColumn("<html>Teléfono</html>");
      
      // Se agrega el modelo a la tabla de clientes.
      this.tablaClientes.setModel(modeloClientes);
      
      // Se establecen la anchura, en pixeles, de las columnas de la tabla de
      // clientes.
      tablaClientes.getColumnModel().getColumn(0).setPreferredWidth(30);
      tablaClientes.getColumnModel().getColumn(1).setPreferredWidth(130);
      tablaClientes.getColumnModel().getColumn(2).setPreferredWidth(130);
      tablaClientes.getColumnModel().getColumn(3).setPreferredWidth(50);
      tablaClientes.getColumnModel().getColumn(4).setPreferredWidth(150);
      tablaClientes.getColumnModel().getColumn(5).setPreferredWidth(100);
      
      // Se vacia la tabla de clientes.
      ((DefaultTableModel)tablaClientes.getModel()).setNumRows(0);
      
      // Se obtienen la lista enlazada con los clientes de la base de datos.
      LinkedList<Cliente> clientes = conexion.listaClientes();
      array = new String[6];
      size = clientes.size();
      
      // Se recorre la lista enlazada de clientes y se llenan las celdas de la
      // tabla de clientes con los atributos de los objetos de tipo 'Cliente'
      // en la lista enlazada, se van eliminando objetos de la lista a medida
      // que esta se recorre.
      for (int i = 0; i < size; i++) {
         Cliente c = clientes.poll();
         array[0] = c.getId() + "";
         array[1] = c.getNombre();
         array[2] = c.getApellido();
         array[3] = c.getEdad() + "";
         array[4] = c.getDireccion();
         array[5] = c.getTelefono();
         modeloClientes.addRow(array);
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
      etiquetaTituloDashboard = new javax.swing.JLabel();
      jTabbedPane1 = new javax.swing.JTabbedPane();
      jPanel3 = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tablaProductos = new javax.swing.JTable();
      jPanel5 = new javax.swing.JPanel();
      jButton3 = new javax.swing.JButton();
      jButton4 = new javax.swing.JButton();
      jButton5 = new javax.swing.JButton();
      jLabel6 = new javax.swing.JLabel();
      jPanel4 = new javax.swing.JPanel();
      jScrollPane2 = new javax.swing.JScrollPane();
      tablaClientes = new javax.swing.JTable();
      jButton6 = new javax.swing.JButton();
      jButton7 = new javax.swing.JButton();
      jButton9 = new javax.swing.JButton();
      jButton10 = new javax.swing.JButton();
      jLabel7 = new javax.swing.JLabel();
      jPanel2 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      campoNombreCuenta = new javax.swing.JTextField();
      campoApellidoCuenta = new javax.swing.JTextField();
      campoRolCuenta = new javax.swing.JTextField();
      campoUsuarioCuenta = new javax.swing.JTextField();
      botonGuardarCuenta = new javax.swing.JButton();
      botonCambiarContrasenaCuenta = new javax.swing.JButton();
      botonRestaurarCuenta = new javax.swing.JButton();
      botonLimpiarCuenta = new javax.swing.JButton();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      etiquetaTituloDashboard.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
      etiquetaTituloDashboard.setForeground(new java.awt.Color(0, 0, 0));
      etiquetaTituloDashboard.setText("jLabel1");

      tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      )
      {public boolean isCellEditable(int row, int column){return false;}}
   );
   jScrollPane1.setViewportView(tablaProductos);

   jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones de inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
   jPanel5.setForeground(new java.awt.Color(255, 255, 255));

   jButton3.setForeground(new java.awt.Color(0, 0, 0));
   jButton3.setText("Registrar producto");
   jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton3ActionPerformed(evt);
      }
   });

   jButton4.setForeground(new java.awt.Color(0, 0, 0));
   jButton4.setText("Actualizar producto");
   jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton4ActionPerformed(evt);
      }
   });

   jButton5.setForeground(new java.awt.Color(0, 0, 0));
   jButton5.setText("Generar reporte");
   jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton5ActionPerformed(evt);
      }
   });

   javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
   jPanel5.setLayout(jPanel5Layout);
   jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
         .addContainerGap()
         .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addContainerGap())
   );
   jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
         .addContainerGap()
         .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jButton3)
            .addComponent(jButton5)
            .addComponent(jButton4))
         .addContainerGap(12, Short.MAX_VALUE))
   );

   jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
   jLabel6.setForeground(new java.awt.Color(0, 0, 0));
   jLabel6.setText("<html>Listado de productos del inventario</html>");

   javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
   jPanel3.setLayout(jPanel3Layout);
   jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addGap(187, 187, 187))
      .addGroup(jPanel3Layout.createSequentialGroup()
         .addContainerGap()
         .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addContainerGap())
   );
   jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addGap(18, 18, 18)
         .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
         .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addContainerGap())
   );

   jTabbedPane1.addTab("Inventario", jPanel3);

   tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
         {null, null, null, null},
         {null, null, null, null},
         {null, null, null, null},
         {null, null, null, null}
      },
      new String [] {
         "Title 1", "Title 2", "Title 3", "Title 4"
      }
   )
   {public boolean isCellEditable(int row, int column){return false;}}
   );
   jScrollPane2.setViewportView(tablaClientes);

   jButton6.setForeground(new java.awt.Color(0, 0, 0));
   jButton6.setText("Registrar cliente");
   jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton6ActionPerformed(evt);
      }
   });

   jButton7.setForeground(new java.awt.Color(0, 0, 0));
   jButton7.setText("Editar cliente");
   jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton7ActionPerformed(evt);
      }
   });

   jButton9.setForeground(new java.awt.Color(0, 0, 0));
   jButton9.setText("Factura de compra");
   jButton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton9ActionPerformed(evt);
      }
   });

   jButton10.setForeground(new java.awt.Color(0, 0, 0));
   jButton10.setText("Registrar compra");
   jButton10.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton10ActionPerformed(evt);
      }
   });

   jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
   jLabel7.setForeground(new java.awt.Color(0, 0, 0));
   jLabel7.setText("<html>Listado de clientes</html>");

   javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
   jPanel4.setLayout(jPanel4Layout);
   jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
               .addContainerGap()
               .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanel4Layout.createSequentialGroup()
                     .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                     .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
               .addGap(226, 226, 226)
               .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
         .addContainerGap(12, Short.MAX_VALUE))
   );
   jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
         .addContainerGap()
         .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
         .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addGap(18, 18, 18)
         .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jButton6)
            .addComponent(jButton7)
            .addComponent(jButton9)
            .addComponent(jButton10))
         .addGap(36, 36, 36))
   );

   jTabbedPane1.addTab("Clientes", jPanel4);

   jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
   jLabel1.setForeground(new java.awt.Color(0, 0, 0));
   jLabel1.setText("<html>Datos de usuario.</html>");

   jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
   jLabel2.setForeground(new java.awt.Color(0, 0, 0));
   jLabel2.setText("Nombre:");

   jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
   jLabel3.setForeground(new java.awt.Color(0, 0, 0));
   jLabel3.setText("Apellido:");

   jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
   jLabel4.setForeground(new java.awt.Color(0, 0, 0));
   jLabel4.setText("Rol:");

   jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
   jLabel5.setForeground(new java.awt.Color(0, 0, 0));
   jLabel5.setText("Nombre de usuario:");

   campoNombreCuenta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
   campoNombreCuenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         campoNombreCuentaActionPerformed(evt);
      }
   });

   campoApellidoCuenta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

   campoRolCuenta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

   campoUsuarioCuenta.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

   botonGuardarCuenta.setForeground(new java.awt.Color(0, 0, 0));
   botonGuardarCuenta.setText("Guardar");
   botonGuardarCuenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         botonGuardarCuentaActionPerformed(evt);
      }
   });

   botonCambiarContrasenaCuenta.setForeground(new java.awt.Color(0, 0, 0));
   botonCambiarContrasenaCuenta.setText("Cambiar contraseña");
   botonCambiarContrasenaCuenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         botonCambiarContrasenaCuentaActionPerformed(evt);
      }
   });

   botonRestaurarCuenta.setForeground(new java.awt.Color(0, 0, 0));
   botonRestaurarCuenta.setText("Restaurar");
   botonRestaurarCuenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         botonRestaurarCuentaActionPerformed(evt);
      }
   });

   botonLimpiarCuenta.setForeground(new java.awt.Color(0, 0, 0));
   botonLimpiarCuenta.setText("Limpiar campos");
   botonLimpiarCuenta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         botonLimpiarCuentaActionPerformed(evt);
      }
   });

   jButton1.setForeground(new java.awt.Color(0, 0, 0));
   jButton1.setText("Cerrar sesión");
   jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton1ActionPerformed(evt);
      }
   });

   jButton2.setForeground(new java.awt.Color(0, 0, 0));
   jButton2.setText("Eliminar cuenta");
   jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
         jButton2ActionPerformed(evt);
      }
   });

   javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
   jPanel2.setLayout(jPanel2Layout);
   jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
         .addGap(74, 74, 74)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(jPanel2Layout.createSequentialGroup()
               .addComponent(botonGuardarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(botonCambiarContrasenaCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
               .addComponent(botonRestaurarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(botonLimpiarCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
               .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
               .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel2)
                  .addComponent(jLabel4)
                  .addComponent(jLabel3)
                  .addComponent(jLabel5))
               .addGap(18, 18, 18)
               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(campoNombreCuenta)
                     .addComponent(campoApellidoCuenta)
                     .addComponent(campoRolCuenta)
                     .addComponent(campoUsuarioCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
         .addContainerGap(75, Short.MAX_VALUE))
   );
   jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
         .addGap(26, 26, 26)
         .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
         .addGap(38, 38, 38)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2)
            .addComponent(campoNombreCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGap(18, 18, 18)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3)
            .addComponent(campoApellidoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGap(18, 18, 18)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel4)
            .addComponent(campoRolCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGap(18, 18, 18)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel5)
            .addComponent(campoUsuarioCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
         .addGap(39, 39, 39)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(botonGuardarCuenta)
            .addComponent(botonCambiarContrasenaCuenta))
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonLimpiarCuenta)
            .addComponent(botonRestaurarCuenta))
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jButton1)
            .addComponent(jButton2))
         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
   );

   jTabbedPane1.addTab("Cuenta", jPanel2);

   javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
   jPanel1.setLayout(jPanel1Layout);
   jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
         .addContainerGap()
         .addComponent(etiquetaTituloDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addContainerGap())
      .addComponent(jTabbedPane1)
   );
   jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
         .addContainerGap()
         .addComponent(etiquetaTituloDashboard)
         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
         .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, Short.MAX_VALUE))
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

   private void campoNombreCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreCuentaActionPerformed
      // TODO add your handling code here:
   }//GEN-LAST:event_campoNombreCuentaActionPerformed

   private void botonGuardarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarCuentaActionPerformed
      
      // Boton Guardar !
      
      // Se obtienen y almacenan las cadenas de caracteres de los campos del
      // formulario de la pestaña 'Cuenta'.
      String nombre = campoNombreCuenta.getText();
      String apellido = campoApellidoCuenta.getText();
      String rol = campoRolCuenta.getText();
      String usuario = campoUsuarioCuenta.getText();
      
      // Se valida que ninguno de estos campos este vacio.
      if(nombre.compareTo("") == 0 || apellido.compareTo("") == 0
         || rol.compareTo("") == 0 || usuario.compareTo("") == 0){
         
         // Si alguno de los campos esta vacio se muestra un aviso de error de
         // validacion.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Ninguno de los campos debe estar vacio!<strong><html>",
            null,
            JOptionPane.ERROR_MESSAGE
         );
      }else{
         
         // Si ninguno de los campos esta vacio, se valida cuales valores de
         // estos campos son iguales su respectivo atributo del usuario logeado.
         if(nombre.compareTo(login.getNombre()) == 0 && apellido.compareTo(login.getApellido()) == 0
            && rol.compareTo(login.getRol()) == 0 && usuario.compareTo(login.getUsuario()) == 0){
            
            // Si todos son iguales se lanza un aviso al usuario donde se le
            // informa que no se han realizado cambios en sus datos.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>No se han realizado cambios en sus datos de usuario!<strong><html>",
               null,
               JOptionPane.WARNING_MESSAGE
            );
         }else{
            
            // Para la campos en los que se han realizado cambios, se actualizan
            // los datos del usuario con el valor ingresado en el campo y de ser
            // necesario tambien se actualiza el titulo de la ventana, esto es,
            // las variables 'nombreTitulo', 'apellidoTitulo' y 'rolTitulo'.
            Conexion conexion = new Conexion();
            if(nombre.compareTo(login.getNombre()) != 0){
               conexion.actualizarDatoUsuario(login.getId(), "nombre", nombre);
               String antiguoNombre = nombreTitulo;
               nombreTitulo = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
               etiquetaTituloDashboard.setText(
                  etiquetaTituloDashboard.getText().replace(antiguoNombre, nombreTitulo)
               );
            }
            if(apellido.compareTo(login.getApellido()) != 0){
               conexion.actualizarDatoUsuario(login.getId(), "apellido", apellido);
               String antiguoApellido = apellidoTitulo;
               apellidoTitulo = apellido.substring(0, 1).toUpperCase() + apellido.substring(1).toLowerCase();
               etiquetaTituloDashboard.setText(
                  etiquetaTituloDashboard.getText().replace(antiguoApellido, apellidoTitulo)
               );
            }
            if(rol.compareTo(login.getRol()) != 0){
               conexion.actualizarDatoUsuario(login.getId(), "rol", rol);
               String antiguoRol = rolTitulo;
               rolTitulo = rol.substring(0, 1).toUpperCase() + rol.substring(1).toLowerCase();
               etiquetaTituloDashboard.setText(
                  etiquetaTituloDashboard.getText().replace(antiguoRol, rolTitulo)
               );
            }
            if(usuario.compareTo(login.getUsuario()) != 0){
               conexion.actualizarDatoUsuario(login.getId(), "usuario", usuario);
            }
            
            // Se cierra la conexion con la base de datos.
            conexion.cerrarConexion();
            
            // Se muestra un aviso al usuario informandole que se han realizado
            // los cambios de forma exitosa.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Sus datos fueron actualizados satisfactoriamente!<strong><html>",
               null,
               JOptionPane.INFORMATION_MESSAGE
            );
         }
      }
      
   }//GEN-LAST:event_botonGuardarCuentaActionPerformed

   private void botonRestaurarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarCuentaActionPerformed
      
      // Boton Restaurar.
      
      // Metodo para restaurar los campos del formulario.
      restaurar();
      
   }//GEN-LAST:event_botonRestaurarCuentaActionPerformed

   private void botonLimpiarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarCuentaActionPerformed
      
      // Boton Limpiar campos.
      
      // Se establecen todas las cadenas de caracteres de los campos del
      // formulario en una cadena vacia "".
      campoNombreCuenta.setText("");
      campoApellidoCuenta.setText("");
      campoRolCuenta.setText("");
      campoUsuarioCuenta.setText("");
      
   }//GEN-LAST:event_botonLimpiarCuentaActionPerformed

   private void botonCambiarContrasenaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCambiarContrasenaCuentaActionPerformed
      
      // Boton Cambiar contraseña.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'PasswordChangeFrame'.
      dispose();
      new PasswordChangeFrame(login).setVisible(true);
      
   }//GEN-LAST:event_botonCambiarContrasenaCuentaActionPerformed

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
      // Boton Cerrar sesion.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'LoginFrame'.
      dispose();
      new LoginFrame().setVisible(true);
      
   }//GEN-LAST:event_jButton1ActionPerformed

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
      // Boton Eliminar cuenta.
      
      // Se le pregunta al usuario si esta seguro de eliminar su cuenta.
      int opcion = JOptionPane.showConfirmDialog(
         null,
         "<html><strong>" +
         "Esta seguro de desea eliminar su cuenta ?",
         null,
         JOptionPane.YES_NO_OPTION
      );
      
      // Si la respuesta del usuario es positiva, se llama al metodo de la
      // clase 'Conexion' pasandole por parametro el id del usuario logeado.
      if(opcion == 0){
         Conexion conexion = new Conexion();
         conexion.eliminarUsuario(login.getId());
         
         // Se le muestra al usuario un aviso de que su cuenta fue eliminada con
         // exito.
         JOptionPane.showMessageDialog(
            null,
            "<html><strong>Su cuenta fue elininada satisfactoriamente!<strong><html>",
            null,
            JOptionPane.INFORMATION_MESSAGE
         );
         
         // Se cierra la conexion con al base de datos.
         conexion.cerrarConexion();
         
         // Se cierra la ventana actual y se inicializa una nueva ventana de la
         // clase 'LoginFrame'.
         dispose();
         new LoginFrame().setVisible(true);
      }
      
   }//GEN-LAST:event_jButton2ActionPerformed

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
      // Boton Registrar producto.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'FormProductFrame'.
      new FormProductFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton3ActionPerformed

   private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
      // Boton Actualiza producto.
      
      Conexion conexion = new Conexion();
      String[] opciones = {"Id", "Nombre"};
      
      // Se le pregunta al usuario por medio de una ventana modal el criterio
      // por el cual desea buscar el producto a actualizar.
      String opcion = (String)JOptionPane.showInputDialog(
         null,
         "<html><strong>Seleccione el criterio de busqueda para el<br>producto que desea actualizar</strong></html>",
         null,
         JOptionPane.QUESTION_MESSAGE,
         null,
         opciones,
         opciones[0]
      );
      
      if(opcion.compareTo("Id") == 0){
         
         // Si el criterio es el id se el pide al usuario que ingrese el valor
         // de dicho id.
         String id = JOptionPane.showInputDialog(
            null,
            "<html><strong>Ingrese el id del producto:</strong></html>", 
            null,
            JOptionPane.QUESTION_MESSAGE
         );
         
         Pattern num = Pattern.compile("[0-9]+");
         Matcher matId = num.matcher(id);
         
         // Se valida que el valor del id no sea una cadena de caracteres vacia
         // y que solo contenga caracteres numericos.
         if(id.compareTo("") == 0 || !matId.matches()){
            
            // Si el id no cumple con la validacion se muestra al usuario un
            // mensaje de error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>El valor ingresado no es valido!<strong><html>",
               null,
               JOptionPane.ERROR_MESSAGE
            );
         }else{
            
            // Si el id cumple con la validacion se obtienen los datos de este
            // producto de la base de datos.
            Producto p = conexion.datosProductoId(Integer.parseInt(id));
            
            // Si el producto efectivamente se encuentra en la base de datos,
            // Se cierra la ventana actual y se inicializa una nueva ventana de
            // la clase 'FormProductFrame'.
            if(p != null){
               new FormProductFrame(login, p).setVisible(true);
               conexion.cerrarConexion();
               dispose();
            }else{
               
               // Si el producto no se encuentra en la base de datos, se muestra
               // al usuario un aviso de error.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>No se encontró ningun prducto con el Id ingresado!<strong><html>",
                  null,
                  JOptionPane.WARNING_MESSAGE
               );
            }
         }
      }else{
         
         // Si el criterio es el nombre se el pide al usuario que ingrese el
         // valor de dicho nombre.
         String nombre = JOptionPane.showInputDialog(
            null,
            "<html><strong>Ingrese el nombre del producto:</strong></html>", 
            null,
            JOptionPane.QUESTION_MESSAGE
         );
         
         Pattern alphaNum = Pattern.compile("[a-zA-Z0-9 ]+");
         Matcher matNombre = alphaNum.matcher(nombre);
         
         // Se valida que el valor del nombre no sea una cadena de caracteres
         // vacia y que solo contenga caracteres alfanumericos.
         if(nombre.compareTo("") == 0 || !matNombre.matches()){
            
            // Si el nombre no cumple con la validacion se muestra al usuario un
            // mensaje de error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>El valor ingresado no es valido!<strong><html>",
               null,
               JOptionPane.ERROR_MESSAGE
            );
         }else{
            
            // Si el nombre cumple con la validacion se obtienen los datos de
            // este producto de la base de datos.
            Producto p = conexion.datosProductoNombre(nombre);
            
            // Si el producto efectivamente se encuentra en la base de datos,
            // Se cierra la ventana actual y se inicializa una nueva ventana de
            // la clase 'FormProductFrame'.
            if(p != null){
               new FormProductFrame(login, p).setVisible(true);
               conexion.cerrarConexion();
               dispose();
            }else{
               
               // Si el producto no se encuentra en la base de datos, se muestra
               // al usuario un aviso de error.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>No se encontró ningun prducto con el nombre ingresado!<strong><html>",
                  null,
                  JOptionPane.WARNING_MESSAGE
               );
            }
         }
      }
      
   }//GEN-LAST:event_jButton4ActionPerformed

   private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
      // Boton Generar reporte.
      
      // Se llama al metodo 'generarInventario()' de la clase 'GeneradorPDF'.
      GeneradorPDF.generarInventario();
      
   }//GEN-LAST:event_jButton5ActionPerformed

   private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      
      // Boton Registrar cliente.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de
      // la clase 'FormClientFrame'.
      new FormClientFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton6ActionPerformed

   private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      
      // Boton Editar cliente.
      
      Conexion conexion = new Conexion();
      String[] opciones = {"Id", "Telefono"};
      
      // Se le pregunta al usuario por medio de una ventana modal el criterio
      // por el cual desea buscar el cliente a actualizar.
      String opcion = (String)JOptionPane.showInputDialog(
         null,
         "<html><strong>Seleccione el criterio de busqueda para el<br>cliente que desea editar:</strong></html>",
         null,
         JOptionPane.QUESTION_MESSAGE,
         null,
         opciones,
         opciones[0]
      );
      
      if(opcion.compareTo("Id") == 0){
         
         // Si el criterio es el id se el pide al usuario que ingrese el valor
         // de dicho id.
         String id = JOptionPane.showInputDialog(
            null,
            "<html><strong>Ingrese el id del cliente:</strong></html>", 
            null,
            JOptionPane.QUESTION_MESSAGE
         );
         
         Pattern num = Pattern.compile("[0-9]+");
         Matcher matId = num.matcher(id);
         
         // Se valida que el valor del id no sea una cadena de caracteres vacia
         // y que solo contenga caracteres numericos.
         if(id.compareTo("") == 0 || !matId.matches()){
            
            // Si el id no cumple con la validacion se muestra al usuario un
            // mensaje de error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>El valor ingresado no es valido!<strong><html>",
               null,
               JOptionPane.ERROR_MESSAGE
            );
         }else{
            
            // Si el id cumple con la validacion se obtienen los datos de este
            // cliente de la base de datos.
            Cliente c = conexion.datosClienteId(Integer.parseInt(id));
            
            // Si el cliente efectivamente se encuentra en la base de datos,
            // Se cierra la ventana actual y se inicializa una nueva ventana de
            // la clase 'FormClientFrame'.
            if(c != null){
               new FormClientFrame(login, c).setVisible(true);
               conexion.cerrarConexion();
               dispose();
            }else{
               
               // Si el cliente no se encuentra en la base de datos, se muestra
               // al usuario un aviso de error.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>No se encontró ningun cliente con el Id ingresado!<strong><html>",
                  null,
                  JOptionPane.WARNING_MESSAGE
               );
            }
         }
      }else{
         
         // Si el criterio es el telefono se el pide al usuario que ingrese el
         // valor de dicho telefono.
         String telefono = JOptionPane.showInputDialog(
            null,
            "<html><strong>Ingrese el telefono del cliente:</strong></html>", 
            null,
            JOptionPane.QUESTION_MESSAGE
         );
         
         Pattern alphaNum = Pattern.compile("[a-zA-Z0-9 ]+");
         Matcher matTelefono = alphaNum.matcher(telefono);
         
         // Se valida que el valor del telefono no sea una cadena de caracteres
         // vacia y que solo contenga caracteres alfanumericos.
         if(telefono.compareTo("") == 0 || !matTelefono.matches()){
            
            // Si el telefono no cumple con la validacion se muestra al usuario
            // un mensaje de error.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>El valor ingresado no es valido!<strong><html>",
               null,
               JOptionPane.ERROR_MESSAGE
            );
         }else{
            
            // Si el telefono cumple con la validacion se obtienen los datos de
            // este cliente de la base de datos.
            Cliente c = conexion.datosClienteTelefono(telefono);
            
            // Si el cliente efectivamente se encuentra en la base de datos,
            // Se cierra la ventana actual y se inicializa una nueva ventana de
            // la clase 'FormClientFrame'.
            if(c != null){
               new FormClientFrame(login, c).setVisible(true);
               conexion.cerrarConexion();
               dispose();
            }else{
               
               // Si el cliente no se encuentra en la base de datos, se muestra
               // al usuario un aviso de error.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>No se encontró ningun cliente con el telefono ingresado!<strong><html>",
                  null,
                  JOptionPane.WARNING_MESSAGE
               );
            }
         }
      }
      
   }//GEN-LAST:event_jButton7ActionPerformed

   private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
      
      // Boton Registrar compra.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'FormCompraFrame'.
      new RegCompraFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton10ActionPerformed

   private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      
      // Boton Factura de compra.
      
      // Se cierra la ventana actual y se inicializa una nueva ventana de la
      // clase 'ReporteVentasFrame'.
      new ReporteVentasFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton9ActionPerformed

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
         java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            //new DashboardFrame().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton botonCambiarContrasenaCuenta;
   private javax.swing.JButton botonGuardarCuenta;
   private javax.swing.JButton botonLimpiarCuenta;
   private javax.swing.JButton botonRestaurarCuenta;
   private javax.swing.JTextField campoApellidoCuenta;
   private javax.swing.JTextField campoNombreCuenta;
   private javax.swing.JTextField campoRolCuenta;
   private javax.swing.JTextField campoUsuarioCuenta;
   private javax.swing.JLabel etiquetaTituloDashboard;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton10;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JButton jButton4;
   private javax.swing.JButton jButton5;
   private javax.swing.JButton jButton6;
   private javax.swing.JButton jButton7;
   private javax.swing.JButton jButton9;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel jPanel3;
   private javax.swing.JPanel jPanel4;
   private javax.swing.JPanel jPanel5;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JTabbedPane jTabbedPane1;
   private javax.swing.JTable tablaClientes;
   private javax.swing.JTable tablaProductos;
   // End of variables declaration//GEN-END:variables
}
