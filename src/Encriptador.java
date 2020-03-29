
public class Encriptador {
  
   /**
    * Metodo de enciptacion: recibe por parametro una cadena de caracteres que
    * representa una contraseña y retorna la misma cadena encriptada utilizando
    * un metodo de encriptacion sencillo.
    */
   public static String encriptar(String str){
      byte[] bytesStr = str.getBytes();
      byte[] enc = new byte[bytesStr.length];
      for (int i = 0; i < bytesStr.length; i++) {
         enc[i] = (byte)(i % 2 == 0 ? bytesStr[i] + 1 : bytesStr[i] - 1); 
      }
      return new String(enc);
   }
   
   /**
    * Metodo de desenciptacion: recibe por parametro una cadena de caracteres
    * que representa una contraseña encriptada y retorna la misma cadena
    * desencriptada utilizando de forma inversa el mismo algoritmo que se uso
    * para encriptarla.
    */
   public static String desencriptar(String str){
      byte[] bytesStr = str.getBytes();
      byte[] des = new byte[bytesStr.length];
      for (int i = 0; i < bytesStr.length; i++) {
         des[i] = (byte)(i % 2 == 0 ? bytesStr[i] - 1 : bytesStr[i] + 1); 
      }
      return new String(des);
   }
}