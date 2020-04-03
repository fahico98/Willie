
import java.sql.*;
import java.util.LinkedList;

public class Conexion {
   
   private String contrasena;
   private String nombreUsuario;
   private String nombreBD;
   private Connection conexion;
   private Statement sentencia;
   
   public Conexion(){
      nombreBD = "poo_database";
      nombreUsuario = "root";
      contrasena = "";
      String temp = "jdbc:mysql://localhost:3306/" + nombreBD + "?user=" +
         nombreUsuario + "&password=" + contrasena + "&useSSL=false&serverTimezone=UTC";
      try{
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
   
   public void actualizarDatoUsuario(int id, String campo, String valor){
      String query = "UPDATE usuarios SET " + campo + " = '" + valor + "' WHERE id = " + id;
      realizarConsulta(query);
   }
   
   public Producto datosProductoId(int id){
      String prepQuery = "SELECT * FROM productos WHERE id = ?";
      Producto p = null;
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, id);
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
   
   public Producto datosProductoNombre(String nombre){
      String prepQuery = "SELECT * FROM productos WHERE nombre = ?";
      Producto p = null;
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setString(1, nombre);
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
   
   public void actualizarProducto(Producto p){
      String prepQuery = "UPDATE productos SET nombre = ?, tipo = ?, cantidad = ?, unidades_de_medida = ?," +
         " precio_unitario = ?, total_unidades = ? WHERE id = ?";
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setString(1, p.getNombre());
         prepStatement.setString(2, p.getTipo());
         prepStatement.setInt(3, p.getCantidad());
         prepStatement.setString(4, p.getUnidadesMedida());
         prepStatement.setInt(5, p.getPrecioUnitario());
         prepStatement.setInt(6, p.getTotalUnidades());
         prepStatement.setInt(7, p.getId());
         prepStatement.executeUpdate();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   public Cliente datosClienteId(int id){
      String prepQuery = "SELECT * FROM clientes WHERE id = ?";
      Cliente c = null;
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, id);
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
   
   public Cliente datosClienteTelefono(String telefono){
      String prepQuery = "SELECT * FROM clientes WHERE telefono = ?";
      Cliente c = null;
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setString(1, telefono);
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
   
   public void actualizarCliente(Cliente c){
      String prepQuery = "UPDATE clientes SET nombre = ?, apellido = ?, edad = ?, " +
         "direccion = ?, telefono = ? WHERE id = ?";
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setString(1, c.getNombre());
         prepStatement.setString(2, c.getApellido());
         prepStatement.setInt(3, c.getEdad());
         prepStatement.setString(4, c.getDireccion());
         prepStatement.setString(5, c.getTelefono());
         prepStatement.setInt(6, c.getId());
         prepStatement.executeUpdate();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   public void agregarProducto(Producto p){
      String prepQuery = "INSERT INTO productos (nombre, tipo, cantidad, unidades_de_medida, " +
         "precio_unitario, total_unidades) VALUES (?, ?, ?, ?, ?, ?)";
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setString(1, p.getNombre());
         prepStatement.setString(2, p.getTipo());
         prepStatement.setInt(3, p.getCantidad());
         prepStatement.setString(4, p.getUnidadesMedida());
         prepStatement.setInt(5, p.getPrecioUnitario());
         prepStatement.setInt(6, p.getTotalUnidades());
         prepStatement.executeUpdate();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   public void agregarCliente(Cliente c){
      String prepQuery = "INSERT INTO clientes (nombre, apellido, edad, direccion, " +
         "telefono) VALUES (?, ?, ?, ?, ?)";
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setString(1, c.getNombre());
         prepStatement.setString(2, c.getApellido());
         prepStatement.setInt(3, c.getEdad());
         prepStatement.setString(4, c.getDireccion());
         prepStatement.setString(5, c.getTelefono());
         prepStatement.executeUpdate();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }
   
   public void actualizarContrasenaUsuario(int id, String contrasena){
      String encCont = Encriptador.encriptar(contrasena);
      String query = "UPDATE usuarios SET contraseña  = '" + encCont + "' WHERE id = " + id;
      realizarConsulta(query);
   }
   
   public void eliminarUsuario(int id){
      String query = "DELETE FROM usuarios WHERE id = " + id;
      realizarConsulta(query);
   }
   
   public LinkedList<Producto> listaProductos(){
      LinkedList<Producto> salida = new LinkedList();
      String query = "SELECT * FROM productos";
      try{
         ResultSet r = sentencia.executeQuery(query);
         while(r.next()){
            Producto p = new Producto(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getInt(6), r.getInt(7));
            salida.offer(p);
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return salida;
   }
   
   public LinkedList<Cliente> listaClientes(){
      LinkedList<Cliente> salida = new LinkedList();
      String query = "SELECT * FROM clientes";
      try{
         ResultSet r = sentencia.executeQuery(query);
         while(r.next()){
            Cliente c = new Cliente(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4),
               r.getString(5), r.getString(6));
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
    * el metodo retornará una instancia de la clase Usuario con los datos de
    * este registro.
    */
   public Usuario iniciarSesion(String usuario, String contrasena){
      String contrasenaEnc = Encriptador.encriptar(contrasena);
      String prepQuery = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
      Usuario salida = null;
      try{
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setString(1, usuario);
         prepStatement.setString(2, contrasenaEnc);
         ResultSet resultado = prepStatement.executeQuery();
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
   
   public String compraPosible(int idCliente, int idProducto, int cantidad){
      String prepQuery;
      PreparedStatement prepStatement;
      ResultSet r;
      try{
         if(existeCliente(idCliente) == null){
            return "client not found";
         }
         Producto p = existeProducto(idProducto);
         if(p != null){
            if(p.getTotalUnidades() < cantidad){
               return "sold out";
            }
         }else{
            return "product not found";
         }
      }catch(Exception e){
         System.out.println("Error from compraPosible: " + e.getMessage());
      }
      return "true";
   }
   
   public void efectuarCompra(int idCliente, int idProducto, int cantidad){
      String prepQuery;
      PreparedStatement prepStatement;
      Date hoy = new Date(System.currentTimeMillis());
      ResultSet r;
      try{
         prepQuery = "SELECT * FROM productos WHERE id = ?";
         prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idProducto);
         r = prepStatement.executeQuery();
         r.first();
         int costoUnitario = r.getInt(6);
         int unidadesProducto = r.getInt(7);
         int costoCompra = costoUnitario * cantidad;
         
         prepQuery = "INSERT INTO compras (cliente_id, producto_id, unidades, fecha, costo)" +
            "VALUES (?, ?, ?, ?, ?)";
         prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idCliente);
         prepStatement.setInt(2, idProducto);
         prepStatement.setInt(3, cantidad);
         prepStatement.setDate(4, hoy);
         prepStatement.setInt(5, costoCompra);
         prepStatement.executeUpdate();
         
         prepQuery = "UPDATE productos SET total_unidades = " + (unidadesProducto - cantidad) +
            " WHERE id = ?";
         prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idProducto);
         prepStatement.executeUpdate();
         
      }catch(Exception e){
         System.out.println("Error from efectuarCompra: " + e.getMessage());
      }
   }
   
   public Cliente existeCliente(int idCliente){
      try{
         String prepQuery = "SELECT * FROM clientes WHERE id = ?";
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idCliente);
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
   
   public Producto existeProducto(int idProducto){
      try{
         String prepQuery = "SELECT * FROM productos WHERE id = ?";
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idProducto);
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
   
   public ResultSet fechaFactura(int idCliente, java.sql.Date fecha){
      try{
         String prepQuery = "SELECT * FROM compras WHERE cliente_id = ? AND fecha = ?";
         PreparedStatement prepStatement = conexion.prepareStatement(prepQuery);
         prepStatement.setInt(1, idCliente);
         prepStatement.setDate(2, fecha);
         ResultSet r = prepStatement.executeQuery();
         r.last();
         if(r.first()){
            return r;
         }
      }catch(Exception e){
         System.out.println("Error from fechaFactura: " + e.getMessage());
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
