
public class Producto {
   
   private int id, cantidad, precioUnitario, totalUnidades;
   private String nombre, tipo, unidadesMedida;

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
    * @return the id
    */
   public int getId() {
      return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(int id) {
      this.id = id;
   }

   /**
    * @return the cantidad
    */
   public int getCantidad() {
      return cantidad;
   }

   /**
    * @param cantidad the cantidad to set
    */
   public void setCantidad(int cantidad) {
      this.cantidad = cantidad;
   }

   /**
    * @return the precioUnitario
    */
   public int getPrecioUnitario() {
      return precioUnitario;
   }

   /**
    * @param precioUnitario the precioUnitario to set
    */
   public void setPrecioUnitario(int precioUnitario) {
      this.precioUnitario = precioUnitario;
   }

   /**
    * @return the totalUnidades
    */
   public int getTotalUnidades() {
      return totalUnidades;
   }

   /**
    * @param totalUnidades the totalUnidades to set
    */
   public void setTotalUnidades(int totalUnidades) {
      this.totalUnidades = totalUnidades;
   }

   /**
    * @return the nombre
    */
   public String getNombre() {
      return nombre;
   }

   /**
    * @param nombre the nombre to set
    */
   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   /**
    * @return the tipo
    */
   public String getTipo() {
      return tipo;
   }

   /**
    * @param tipo the tipo to set
    */
   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   /**
    * @return the unidadesMedida
    */
   public String getUnidadesMedida() {
      return unidadesMedida;
   }

   /**
    * @param unidadesMedida the unidadesMedida to set
    */
   public void setUnidadesMedida(String unidadesMedida) {
      this.unidadesMedida = unidadesMedida;
   }
}
