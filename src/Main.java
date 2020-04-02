
public class Main {
   
   public static void main(String[] args) {
      
      //crearTablas();
      //llenarTablas();
      
      new LoginFrame().setVisible(true);
   }
   
   public static void crearTablas(){
      
      Conexion conexion = new Conexion();
      
      String query;
      
      query = "CREATE TABLE IF NOT EXISTS usuarios (" +
         "id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
         "nombre           VARCHAR(100) NOT NULL, " +
         "apellido         VARCHAR(100) NOT NULL, " +
         "rol              VARCHAR(50) NOT NULL, " +
         "usuario          VARCHAR(50) NOT NULL, " +
         "contraseña       VARCHAR(50) NOT NULL" +
      ")";
      conexion.realizarConsulta(query);
      
      query = "CREATE TABLE IF NOT EXISTS clientes (" +
         "id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
         "nombre           VARCHAR(100) NOT NULL, " +
         "apellido         VARCHAR(100) NOT NULL, " +
         "edad             INT NOT NULL, " +
         "direccion        VARCHAR(50) NOT NULL, " +
         "telefono         VARCHAR(50) NOT NULL" +
      ")";
      conexion.realizarConsulta(query);
      
      query = "CREATE TABLE IF NOT EXISTS productos (" +
         "id                     INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
         "nombre                 VARCHAR(100) NOT NULL, " +
         "tipo                   VARCHAR(100) NOT NULL, " +
         "cantidad               INT NOT NULL, " +
         "unidades_de_medida     VARCHAR(50) NOT NULL, " +
         "precio_unitario        INT NOT NULL, " +
         "total_unidades         INT NOT NULL" +
      ")";
      conexion.realizarConsulta(query);
      
      query = "CREATE TABLE IF NOT EXISTS compras (" +
         "id                     INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
         "cliente_id             INT NOT NULL, " +
         "producto_id            INT NOT NULL, " +
         "unidades               INT NOT NULL, " +
         "fecha                  DATE NOT NULL, " +
         "costo                  INT NOT NULL, " +
         "FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id), " +
         "FOREIGN KEY (producto_id) REFERENCES productos(producto_id)" +
      ")";
      conexion.realizarConsulta(query);
      
      conexion.cerrarConexion();
   }
   
   public static void llenarTablas(){
      
      Conexion conexion = new Conexion();
      
      String query;
      
      query = "INSERT INTO productos (" +
         "nombre, " +
         "tipo, " +
         "cantidad, " +
         "unidades_de_medida, " +
         "precio_unitario, " +
         "total_unidades" +
      ") VALUES " +
         "('deterjente liquido', 'aseo', 1000, 'ml', 5600, 72), " +
         "('crema dentrífica', 'aseo', 150, 'ml', 2200, 60), " +
         "('jabon de tocador', 'aseo', 125, 'g', 2500, 36), " +
         "('gaseosa', 'bebidas', 2500, 'ml', 4700, 42), " +
         "('papa pastusa', 'verduras', 1000, 'g', 6000, 120), " +
         "('remolacha', 'verduras', 1000, 'g', 7300, 65), " +
         "('arroz', 'granos', 1000, 'g', 3600, 50), " +
         "('champiñones', 'verduras', 400, 'g', 5700, 24), " +
         "('atun', 'enlatados', 300, 'g', 1500, 36), " +
         "('banano', 'frutas', 500, 'g', 2500, 16), " +
         "('aguacate', 'frutas', 500, 'g', 4100, 14), " +
         "('durazno', 'frutas', 500, 'g', 6600, 16)";
      conexion.realizarConsulta(query);
      
      query = "INSERT INTO clientes (" +
         "nombre, " +
         "apellido, " +
         "edad, " +
         "direccion, " +
         "telefono" +
      ") VALUES " +
         "('jose miguel', 'quintero fernandez', 53, 'calle 43 # 21 - 64', '32199843312'), " +
         "('ana maria', 'gomez lozano', 32, 'cra 112A # 32B - 33', '3209990204'), " +
         "('ricardo', 'sanchez lopez', 29, 'calle 5 sur # 23 - 98', '3119890011'), " +
         "('carlos fernando', 'rivas santiago', 31, 'cra 9 # 56 - 09', '3150987498'), " +
         "('juan camilo', 'dominguez castaño', 42, 'calle 12 # 54C - 16', '3109342213'), " +
         "('claudia patricia', 'londoño vargas', 55, 'cra 87 # 33 sur - 09', '3179894125')";
      conexion.realizarConsulta(query);
      
      String enc = Encriptador.encriptar("1234abcd");
      
      query = "INSERT INTO usuarios (" +
         "nombre, " +
         "apellido, " +
         "rol, " +
         "usuario, " +
         "contraseña" +
      ") VALUES " +
         "('david antonio', 'contreras rey', 'propietario', 'david77', '" + enc + "'), " +
         "('cristian camilo', 'lopez becerra', 'jefe de bodega', 'cris12', '" + enc + "'), " +
         "('raul enrique', 'polo triana', 'supervison', 'raule23', '" + enc + "'), " +
         "('susana maria', 'munevar flores', 'cajero', 'susan49', '" + enc + "'), " +
         "('leonardo enrique', 'moreno plata', 'cajero', 'leoenri65', '" + enc + "')";
      
      conexion.realizarConsulta(query);
   }
}
