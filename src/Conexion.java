
import java.sql.*;

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
            salida = new Usuario(
               resultado.getInt(1),
               resultado.getString(2),
               resultado.getString(3),
               resultado.getString(4),
               resultado.getString(5),
               resultado.getString(6)
            );
         }
         conexion.close();
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
      return salida;
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
