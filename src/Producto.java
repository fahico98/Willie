
/**
 * Clase modelo Producto, las instancias de esta clase representan un registro
 * de la tabla 'productos' de la base de datos, solo contiene un metodo
 * constructor y los respectivos metodos getters y setters de cada atributo.
 */
public class Producto {
   
   private int id, cantidad, precioUnitario, totalUnidades;
   private String nombre, tipo, unidadesMedida;

   /**
    * Metodo constructor, recibe por parametro los campos de la tabla
    * 'productos' de la base de datos.
    */
   public Producto(int id, String nombre, String tipo, int cantidad, String unidadesMedida,
      int precioUnitario, int totalUnidades){
      this.id = id;
      this.cantidad = cantidad;
      this.precioUnitario = precioUnitario;
      this.totalUnidades = totalUnidades;
      this.nombre = nombre;
      this.tipo = tipo;
      this.unidadesMedida = unidadesMedida;
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

   /**
    * Retorna la cantidad de la instancia.
    */
   public int getCantidad() {
      return cantidad;
   }

   /**
    * Establece la cantidad de la instancia.
    */
   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }

   /**
    * Retorna el precio unitario de la instancia.
    */
   public int getPrecioUnitario() {
      return precioUnitario;
   }

   /**
    * Establece el precio unitario de la instancia.
    */
   public void setPrecioUnitario(int precioUnitario) {
      this.precioUnitario = precioUnitario;
   }

   /**
    * Retorna el total de unidades de la instancia.
    */
   public int getTotalUnidades() {
      return totalUnidades;
   }

   /**
    * Establece el total de unidades de la instancia.
    */
   public void setTotalUnidades(int totalUnidades) {
      this.totalUnidades = totalUnidades;
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
    * Retorna el tipo de la instancia.
    */
   public String getTipo() {
      return tipo;
   }

   /**
    * Establece el tipo de la instancia.
    */
   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   /**
    * Retorna las unidades de medida de la instancia.
    */
   public String getUnidadesMedida() {
      return unidadesMedida;
   }

   /**
    * Establece las unidades de medida de la instancia.
    */
   public void setUnidadesMedida(String unidadesMedida) {
      this.unidadesMedida = unidadesMedida;
   }
}
