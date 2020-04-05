
/**
 * Clase modelo de Cliente, las instancias de esta clase representan un
 * registro de la tabla 'clientes' de la base de datos, solo contiene un metodo
 * constructor y los respectivos metodos getters y setters de cada atributo.
 */
public class Cliente extends Persona{
   
   private int edad;
   private String direccion;
   private String telefono;
   
   /**
    * Metodo constructor, recibe por parametro los campos de la tabla 'clientes'
    * de la base de datos.
    */
   public Cliente(int id, String nombre, String apellido,  int edad, String direccion, String telefono) {
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
    * Establece la direccion de la instancia.
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
    * Establece el telefono de la instancia.
    */
   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }
}
