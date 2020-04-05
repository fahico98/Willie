
import java.sql.*;
import java.util.Calendar;
import java.util.LinkedList;

/**
 * Clase Conexion que contiene los metodos necesarios para gestionar la
 * conexion y las consultas necesarias a la base de datos.
 */
public class Conexion {
   
   private String contrasena; // Contraseña del sistema de gestion de BBDD.
   private String nombreUsuario; // Usuarios del sistema de gestion de BBDD.
   private String nombreBD; // Nombre de la base de datos.
   private Connection conexion; // Objeto de tipo Conexion.
   private Statement sentencia; // Sentencia para las consultas sql.
   
   /**
    * Metodo constructor que establece los parametros necesarios para la
    * conexion con la base de datos.
    */
   public Conexion(){
      nombreBD = "poo_database";
      nombreUsuario = "root";
      contrasena = "";
      
      /**
       * Cadena de caracteres que contiene la url y demas parametros necesarios
       * para establecer la conexion con la base de datos.
       */
      String temp = "jdbc:mysql://localhost:3306/" + nombreBD + "?user=" +
         nombreUsuario + "&password=" + contrasena + "&useSSL=false&serverTimezone=America/Bogota";
      try{
         /**
          * Se establece la conexion con el metodo 'getConnection()' de la clase
          * DriverManager y se inicia la sentencia para las consultas llamando
          * al metodo 'createStatement()' de la instancia de la clase Connection
          * que retorna 'getConnection()'.
          */
         conexion = DriverManager.getConnection(temp);
         sentencia = conexion.createStatement();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   /**
    * Recibe por parametro una cadena de caracteres que contiene la consulta sql
    * a realizar, este método solo realiza consultas que no retornen ningun
    * registro de la base de datos, es decir, consultas de tipo 'UPDATE',
    * 'DELETE' e 'INSERT'.
    */
   public void realizarConsulta(String query){
      try{
         sentencia.execute(query);
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   /**
    * Metodo que actualiza un campo de un registro de la tabla usuarios en la
    * base de datos, recibe por parametro el id del usuario a actualizar, el
    * campo que se va a actualizar y el nuevo valor de este campo.
    */
   public void actualizarDatoUsuario(int id, String campo, String valor){
      
      String query = "UPDATE usuarios SET " + campo + " = '" + valor + "' WHERE id = " + id;
      
      // Se llama al metodo 'realizarConsulta()' pasandole por parametro la
      // consulta de la cadena de caracteres 'query'.
      realizarConsulta(query);
   }
   
   /**
    * Metodo que retorna una instancia de la clase Producto, recibe por
    * parametro el id del registro cuyos valores estaran representados en los
    * atributos del objeto Producto que retorna, si no existe ningun producto
    * con este id retorna un objeto nulo.
    */
   public Producto datosProductoId(int id){
      String prepQuery = "SELECT * FROM productos WHERE id = ?";
      Producto p = null;
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asigna el valor de la variable 'id' al parametro de la consulta
         // preparada.
         prepStatement.setInt(1, id);
         
         // Se almacenan los campos del registro retornado en los atributos del
         // objeto p.
         ResultSet r = prepStatement.executeQuery();
         if(r.first()){
            p = new Producto(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getInt(6), r.getInt(7));
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return p;
   }
   
   /**
    * Metodo que retorna una instancia de la clase Producto, recibe por
    * parametro el nombre del registro cuyos valores estaran representados en
    * los atributos del objeto Producto que retorna, si no existe ningun
    * producto con este nombre retorna un objeto nulo.
    */
   public Producto datosProductoNombre(String nombre){
      String prepQuery = "SELECT * FROM productos WHERE nombre = ?";
      Producto p = null;
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asigna el valor de la variable 'nombre' al parametro de la
         // consulta preparada.
         prepStatement.setString(1, nombre);
         
         // Se almacenan los campos del registro retornado en los atributos del
         // objeto p.
         ResultSet r = prepStatement.executeQuery();
         if(r.first()){
            p = new Producto(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getInt(6), r.getInt(7));
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return p;
   }
   
   /**
    * Metodo que actualiza los datos de un registro de la tabla 'productos' de
    * la base de datos, recibe por parametro un objeto de tipo Producto con los
    * datos que contendra el producto con el id de dicho objeto.
    */
   public void actualizarProducto(Producto p){
      String prepQuery = "UPDATE productos SET nombre = ?, tipo = ?, cantidad = ?, unidades_de_medida = ?," +
         " precio_unitario = ?, total_unidades = ? WHERE id = ?";
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asignan los atributos del objeto p a los parametro de la consulta
         // preparada denotados por '?'.
         prepStatement.setString(1, p.getNombre());
         prepStatement.setString(2, p.getTipo());
         prepStatement.setInt(3, p.getCantidad());
         prepStatement.setString(4, p.getUnidadesMedida());
         prepStatement.setInt(5, p.getPrecioUnitario());
         prepStatement.setInt(6, p.getTotalUnidades());
         prepStatement.setInt(7, p.getId());
         
         // Se ejecuta la consulta.
         prepStatement.executeUpdate();
         
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   /**
    * Metodo que retorna un objeto de tipo 'Cliente' con los datos del registro
    * que coincide con el valor del entero 'id' que recibe por parametro, si no
    * existe ningun cliente con este id el metodo retorna un objeto nulo.
    */
   public Cliente datosClienteId(int id){
      String prepQuery = "SELECT * FROM clientes WHERE id = ?";
      Cliente c = null;
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asigna el valor de la variable 'id' al parametro de la consulta
         // preparada.
         prepStatement.setInt(1, id);
         
         // Se establecen los atributos del objeto 'c' con los valores
         // retornados por la consulta.
         ResultSet r = prepStatement.executeQuery();
         if(r.first()){
            c = new Cliente(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getString(6));
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return c;
   }
   
   /**
    * Metodo que retorna una instancia de la clase 'Cliente', recibe por
    * parametro el telefono del registro cuyos valores estaran representados en
    * los atributos del objeto 'Cliente' que retorna, si no existe ningun
    * cliente con este telefono retorna un objeto nulo.
    */
   public Cliente datosClienteTelefono(String telefono){
      String prepQuery = "SELECT * FROM clientes WHERE telefono = ?";
      Cliente c = null;
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asigna el valor de la variable 'telefono' al parametro de la
         // consulta preparada.
         prepStatement.setString(1, telefono);
         
         // Se establecen los atributos del objeto 'c' con los valores
         // retornados por la consulta.
         ResultSet r = prepStatement.executeQuery();
         if(r.first()){
            c = new Cliente(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getString(6));
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return c;
   }
   
   /**
    * Metodo que actualiza los datos de un registro de la tabla 'clientes' de
    * la base de datos, recibe por parametro un objeto de tipo 'Cliente' con los
    * datos que contendra el cliente con el id de dicho objeto.
    */
   public void actualizarCliente(Cliente c){
      String prepQuery = "UPDATE clientes SET nombre = ?, apellido = ?, edad = ?, " +
         "direccion = ?, telefono = ? WHERE id = ?";
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asignan los atributos del objeto 'c' a los parametro de la
         // consulta preparada denotados por '?'.
         prepStatement.setString(1, c.getNombre());
         prepStatement.setString(2, c.getApellido());
         prepStatement.setInt(3, c.getEdad());
         prepStatement.setString(4, c.getDireccion());
         prepStatement.setString(5, c.getTelefono());
         prepStatement.setInt(6, c.getId());
         
         // Se ejecuta la consulta.
         prepStatement.executeUpdate();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   /**
    * Metodo que agrega un registro a la tabla 'productos' de la base de datos,
    * recibe por parametro un objeto de tipo 'Producto' con los datos que
    * contendra el prducto que se agregara.
    */
   public void agregarProducto(Producto p){
      String prepQuery = "INSERT INTO productos (nombre, tipo, cantidad, unidades_de_medida, " +
         "precio_unitario, total_unidades) VALUES (?, ?, ?, ?, ?, ?)";
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asignan los atributos del objeto 'p' a los parametro de la
         // consulta preparada denotados por '?'.
         prepStatement.setString(1, p.getNombre());
         prepStatement.setString(2, p.getTipo());
         prepStatement.setInt(3, p.getCantidad());
         prepStatement.setString(4, p.getUnidadesMedida());
         prepStatement.setInt(5, p.getPrecioUnitario());
         prepStatement.setInt(6, p.getTotalUnidades());
         
         // Se ejecuta la consulta.
         prepStatement.executeUpdate();
         
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   /**
    * Metodo que agrega un registro a la tabla 'clientes' de la base de datos,
    * recibe por parametro un objeto de tipo 'Cliente' con los datos que
    * contendra el cliente que se agregara.
    */
   public void agregarCliente(Cliente c){
      String prepQuery = "INSERT INTO clientes (nombre, apellido, edad, direccion, " +
         "telefono) VALUES (?, ?, ?, ?, ?)";
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asignan los atributos del objeto 'c' a los parametro de la
         // consulta preparada denotados por '?'.
         prepStatement.setString(1, c.getNombre());
         prepStatement.setString(2, c.getApellido());
         prepStatement.setInt(3, c.getEdad());
         prepStatement.setString(4, c.getDireccion());
         prepStatement.setString(5, c.getTelefono());
         
         // Se ejecuta la consulta.
         prepStatement.executeUpdate();
         
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   /**
    * Metodo que actualiza la contraseña de un registro de la tabla 'usuarios'
    * de la base de datos, recibe por parametro el id del usuario cuya
    * contraseña sera actualizada y el id de este usuario.
    */
   public void actualizarContrasenaUsuario(int id, String contrasena){
      
      // Encripta la contraseña antes de actualizarla.
      String encCont = Encriptador.encriptar(contrasena);
      
      // Consulta sql de topo UPDATE.
      String query = "UPDATE usuarios SET contraseña  = '" + encCont + "' WHERE id = " + id;
      
      // Se ejecuta la consulta.
      realizarConsulta(query);
   }
   
   /**
    * Elimina el registro de la tabla 'usuarios' que coincide con el parametro
    * 'id' del metodo.
    */
   public void eliminarUsuario(int id){
      
      // Consulta sql de tipo DELETE.
      String query = "DELETE FROM usuarios WHERE id = " + id;
      
      // Se ejecuta la consulta.
      realizarConsulta(query);
   }
   
   /**
    * Metodo que retorna una lista enlazada de objetos de tipo 'Producto' que
    * contiene los datos de todos los registros de la tabla 'productos' de la
    * base de datos.
    */
   public LinkedList<Producto> listaProductos(){
      LinkedList<Producto> salida = new LinkedList();
      
      // Consulta sql que selecciona todos los registros de la tabla 'productos'.
      String query = "SELECT * FROM productos";
      try{
         ResultSet r = sentencia.executeQuery(query);
         
         // Se recorren todos los registros obtenidos en la consulta.
         while(r.next()){
            
            // Se crea un objeto de tipo 'Producto' con los datos de cada
            // registro.
            Producto p = new Producto(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getInt(6), r.getInt(7));
            
            // Se agrega el objeto a la lista.
            salida.offer(p);
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return salida;
   }
   
   /**
    * Metodo que retorna una lista enlazada de objetos de tipo 'Cliente' que
    * contiene los datos de todos los registros de la tabla 'clientes' de la
    * base de datos.
    */
   public LinkedList<Cliente> listaClientes(){
      LinkedList<Cliente> salida = new LinkedList();
      
      // Consulta sql que selecciona todos los registros de la tabla 'clientes'.
      String query = "SELECT * FROM clientes";
      try{
         ResultSet r = sentencia.executeQuery(query);
         
         // Se recorren todos los registros obtenidos en la consulta.
         while(r.next()){
            
            // Se crea un objeto de tipo 'Cliente' con los datos de cada
            // registro.
            Cliente c = new Cliente(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getString(6));
            
             // Se agrega el objeto a la lista.
            salida.offer(c);
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return salida;
   }
   
   /**
    * Metodo de inicio de sesión, si se encuentra un registro de usuario con los
    * valores de 'usuario' y 'contrasena' que se pasan por parametro, entonces
    * el metodo retornará una instancia de la clase 'Usuario' con los datos de
    * este registro.
    */
   public Usuario iniciarSesion(String usuario, String contrasena){
      String contrasenaEnc = Encriptador.encriptar(contrasena);
      String prepQuery = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
      Usuario salida = null;
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asignan los valores de las variables 'usuario' y 'contrasena' a
         // los parametros de la consulta preparada.
         prepStatement.setString(1, usuario);
         prepStatement.setString(2, contrasenaEnc);
         ResultSet resultado = prepStatement.executeQuery();
         
         // Si el resultado de la consulta no es un valor nulo, se asignan los
         // datos de los campos a los atributos del objeto 'salida' para su
         // posterior retorno.
         if(resultado.next()){
            salida = new Usuario(resultado.getInt(1), resultado.getString(2), resultado.getString(3),
               resultado.getString(4), resultado.getString(5), resultado.getString(6));
         }
         conexion.close();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return salida;
   }
   
   /**
    * Metodo que determina si es posible realizar una compra, recibe por
    * parametro el id del cliente que realiza la compra, el id del producto que
    * se desea comprar y la cantidad de producto que se quiere comprar. Retorna
    * una cadena de caracteres que define la posibilidad de la compra.
    */
   public String compraPosible(int idCliente, int idProducto, int cantidad){
      
      // Si el cliente que realiza la compra no exite retorna la cadena "client
      // not found".
      if(existeCliente(idCliente) == null){
         return "client not found";
      }
      
      Producto p = existeProducto(idProducto);
      
      // Si el producto que se quiere comprar no existe retorna la cadena
      // "product not found".
      if(p != null){
         
         // Si la cantidad de producto que se quiere comprar es mayor a la
         // cantidad de producto almacenado en el inventario retorna la cadena
         // "sold out".
         if(p.getTotalUnidades() < cantidad){
            return "sold out";
         }
      }else{
         return "product not found";
      }
      
      // Si la compra es posible retorna la cadena "true".
      return "true";
   }
   
   /**
    * Metodo que efectua una compra, recibe por parametro el id del cliente que
    * realiza la compra, el id del producto que se desea comprar y la cantidad
    * de producto que se quiere comprar. Retorna una cadena de caracteres que
    * define la posibilidad de la compra.
    */
   public void efectuarCompra(int idCliente, int idProducto, int cantidad){
      String prepQuery;
      PreparedStatement prepStatement;
      try{
         
         // Se establece la fecha de hoy como fecha de compra.
         java.sql.Date hoy = new java.sql.Date(Calendar.getInstance().getTime().getTime());
         ResultSet r;
         
         // Se realiza una consulta a la base de datos para seleccionar los
         // valores de la tabla 'productos' que coinciden con el valor de la
         // variable 'idProducto' pasado por parametro al metodo.
         prepQuery = "SELECT * FROM productos WHERE id = ?";
         prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idProducto);
         r = prepStatement.executeQuery();
         r.first();
         
         // Se almacena el costo unitario del producto en la variable
         // 'costoUnitario', las unidades disponibles de producto ne la variable
         // 'unidadesProducto' y costo total de la compra en la variable
         // 'costoCompra'.
         int costoUnitario = r.getInt(6);
         int unidadesProducto = r.getInt(7);
         int costoCompra = costoUnitario * cantidad;
         
         // Se inserta un nuevo registro en la tabla 'compras' usando una
         // consulta preparada para evitar la inyeccion sql en la base de datos.
         prepQuery = "INSERT INTO compras (cliente_id, producto_id, unidades, fecha, costo)" +
            "VALUES (?, ?, ?, ?, ?)";
         prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asignan los valores necesarios para la nueva compra por medio de
         // los parametros de la consulta preparada denotados por '?'.
         prepStatement.setInt(1, idCliente);
         prepStatement.setInt(2, idProducto);
         prepStatement.setInt(3, cantidad);
         prepStatement.setDate(4, hoy);
         prepStatement.setInt(5, costoCompra);
         
         // Se ejecuta la consulta.
         prepStatement.executeUpdate();
         
         // Se realiza una ultima consulta preparada para actualizar el valor de
         // la nueva cantidad de producto de la compra, esto es, se resta la
         // cantidad de producto que fue extraido del inventario.
         prepQuery = "UPDATE productos SET total_unidades = " + (unidadesProducto - cantidad) +
            " WHERE id = ?";
         prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idProducto);
         prepStatement.executeUpdate();
         
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   /**
    * Metodo que retorna un objeto de tipo 'Cliente' con los datos del registro
    * que coincide con el valor del entero 'idCliente' que recibe por parametro,
    * si no existe ningun cliente con este id el metodo retorna un objeto nulo.
    */
   public Cliente existeCliente(int idCliente){
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // datos.
         String prepQuery = "SELECT * FROM clientes WHERE id = ?";
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asigna el valor de la variable 'id' al parametro de la consulta
         // preparada.
         prepStatement.setInt(1, idCliente);
         
         // Se establecen los atributos un objeto con los valores retornados por
         // la consulta.
         ResultSet r = prepStatement.executeQuery();
         if(r.first()){
            return new Cliente(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getString(6));
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return null;
   }
   
   /**
    * Metodo que retorna un objeto de tipo 'Producto' con los datos del registro
    * que coincide con el valor del entero 'idProducto' que recibe por
    * parametro, si no existe ningun producto con este id el metodo retorna un
    * objeto nulo.
    */
   public Producto existeProducto(int idProducto){
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // datos.
         String prepQuery = "SELECT * FROM productos WHERE id = ?";
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se asigna el valor de la variable 'idProducto' al parametro de la
         // consulta preparada.
         prepStatement.setInt(1, idProducto);
         
         // Se establecen los atributos un objeto con los valores retornados por
         // la consulta.
         ResultSet r = prepStatement.executeQuery();
         if(r.first()){
            return new Producto(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getInt(6), r.getInt(7));
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return null;
   }
   
   /**
    * Metodo que retorna un objeto de tipo 'ResultSet' con los registros de la
    * tabla 'compras' que coinciden con el valor de la variable 'idCliente'
    */
   public ResultSet fechaFactura(int idCliente, java.sql.Date fecha){
      try{
         
         // Se usa una consulta preparada para evitar inyeccion sql en la base
         // de datos.
         String prepQuery = "SELECT * FROM compras WHERE cliente_id = ? AND fecha = ?";
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         
         // Se establecen los valores del id del cliente que realizo la compra y
         // la fecha de la misma por medio de los parametros de la consulta
         // preparada denotados por '?'.
         prepStatement.setInt(1, idCliente);
         prepStatement.setDate(2, fecha);
         ResultSet r = prepStatement.executeQuery();
         r.last();
         
         // Si se obtiene algún resultado de la consulta se retorna, de no ser
         // así se retorna un objeto nulo.
         if(r.first()){
            return r;
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return null;
   }
   
   /**
    * Se cierra la conexion con la base de datos.
    */
   public void cerrarConexion(){
      try{
      conexion.close();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
}
