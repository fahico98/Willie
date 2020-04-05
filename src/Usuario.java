
/**
 * Clase modelo de Usuario, las instancias de esta clase representan un
 * registro de la tabla 'usuarios' de la base de datos, solo contiene un metodo
 * constructor y los respectivos metodos getters y setters de cada atributo.
 */
public class Usuario extends Persona {
   
   private String rol;
   private String usuario;
   private String contrasena;
   
   /**
    * Metodo constructor, recibe por parametro los campos de la tabla 'usuarios'
    * de la base de datos.
    */
   public Usuario(int id, String nombre, String apellido, String rol, String usuario, String contrasena){
      super(nombre, apellido, id);
      this.rol = rol;
      this.usuario = usuario;
      this.contrasena = contrasena;
   }

   /**
    * Retorna el rol de la instancia.
    */
   public String getRol() {
      return rol;
   }

   /**
    * Establece el rol de la instancia.
    */
   public void setRol(String rol) {
      this.rol = rol;
   }

   /**
    * Retorna el nombre de usuario de la instancia.
    */
   public String getUsuario() {
      return usuario;
   }

   /**
    * Establece el nombre de usuario de la instancia.
    */
   public void setUsuario(String usuario) {
      this.usuario = usuario;
   }

   /**
    * Retorna la contraseña de la instancia.
    */
   public String getContrasena() {
      return contrasena;
   }

   /**
    * Establece la contraseña de la instancia.
    */
   public void setContrasena(String contrasena) {
      this.contrasena = contrasena;
   }
}
