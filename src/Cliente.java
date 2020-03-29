
public class Cliente extends Persona{
   
   private int edad;
   private String direccion;
   private String telefono;
   
   public Cliente(String nombre, String apellido, int id, int edad, String direccion, String telefono) {
      super(nombre, apellido, id);
      this.edad = edad;
      this.direccion = direccion;
      this.telefono = telefono;
   }

   /**
    * Retorna la edad de la instancia.
    */
   public int getEdad() {
      return edad;
   }

   /**
    * Establece la edad de la instancia.
    */
   public void setEdad(int edad) {
      this.edad = edad;
   }

   /**
    * Retorna la direccion de la instancia.
    */
   public String getDireccion() {
      return direccion;
   }

   /**
    * Establece la edad de la instancia.
    */
   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   /**
    * Retorna el telefono de la instancia.
    */
   public String getTelefono() {
      return telefono;
   }

   /**
    * Establece la edad de la instancia.
    */
   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }
}
