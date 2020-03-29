
public class Persona {
   
   private String nombre;
   private String apellido;
   private int id;

   public Persona(String nombre, String apellido, int id) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.id = id;
   }

   /**
    * Retorna el nombre de la instancia.
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * Establece el nombre de la instancia.
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * Retorna el apellido de la instancia.
    */
   public String getApellido() {
      return apellido;
   }

   /**
    * Establece el apellido de la instancia.
    */
   public void setApellido(String apellido) {
      this.apellido = apellido;
   }

   /**
    * Retorna el id de la instancia.
    */
   public int getId() {
      return id;
   }

   /**
    * Establece el id de la instancia.
    */
   public void setId(int id) {
      this.id = id;
   }
}
