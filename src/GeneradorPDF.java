
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GeneradorPDF {
   
   // Se inicializan las variables de tipo 'Font' con las caracteristicas de
   // los tipos de fuente que se utilizaran en los diversos metodos de la clase.
   private static Font
      titleFont = FontFactory.getFont(
         FontFactory.HELVETICA,
         16,
         Font.BOLD,
         BaseColor.BLACK
      ),
      headerFacturaFont = FontFactory.getFont(
         FontFactory.HELVETICA,
         14,
         Font.BOLD,
         BaseColor.BLACK
      ),
      headerInventarioFont = FontFactory.getFont(
         FontFactory.HELVETICA,
         12,
         Font.BOLD,
         BaseColor.BLACK
      ),
      footerFont = FontFactory.getFont(
         FontFactory.HELVETICA,
         16,
         Font.BOLDITALIC,
         BaseColor.BLACK
      );
   
   /**
    * Metodo estatico que se utiliza para generar la factura de un cliente,
    * recibe por parametro el id del cliente y la fecha de compra de la factura.
    */
   public static boolean generarFactura(int idCliente, String fechaStr){
      
      Document doc = new Document();
      Conexion conexion = new Conexion();
      
      try{
        
         // Formato para la fecha que se ingresa por parametro en una cadena de
         // caracteres.
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         
         // Se convierte la fecha en un objeto de tipo 'java.util.Date'.
         Date fecha = formatter.parse(fechaStr);
         
         // Se obtienen los datos del cliente por medio de la variable entera
         // 'idCliente'.
         Cliente cliente = conexion.existeCliente(idCliente);
         
         if(cliente != null){
            
            // Si el cliente existe en la base de datos se obtiene los datos de
            // compra de este cliente en la fecha ingresada por medio del metodo
            // 'fechaFactura()' del objeto 'conexion'.
            ResultSet r = conexion.fechaFactura(idCliente, new java.sql.Date(fecha.getTime()));
            
            if(r != null){
               
               // Si estos datos de compra existen, entonces se crea el
               // documento pdf donde se escribira la factura.
               PdfWriter.getInstance(doc, new FileOutputStream(
                  "factura_" + cliente.getId() + "_" + formatter.format(fecha) + ".pdf")
               );
               
               // Titulo del documento.
               String titulo = "Reporte de compra del cliente " + cliente.getNombre() + " " +
                  cliente.getApellido() + " con fecha " + formatter.format(fecha);
               
               // Se abre el documento.
               doc.open();
               
               // Parrafo del titulo.
               Paragraph p = new Paragraph(titulo, titleFont);
               p.setAlignment(Paragraph.ALIGN_CENTER);
               
               // Se agrega el titulo al documento.
               doc.add(p);
               
               // Se agregan dos interlineas.
               doc.add(new Paragraph("\n"));
               doc.add(new Paragraph("\n"));
               
               // Se crea una tabla de 4 columnas.
               PdfPTable tabla = new PdfPTable(4);
               
               // Se establece el encabezado de la tabla.
               tabla.setHeaderRows(1);
               tabla.addCell(new Paragraph("Id compra", headerFacturaFont));
               tabla.addCell(new Paragraph("Producto", headerFacturaFont));
               tabla.addCell(new Paragraph("Unidades", headerFacturaFont));
               tabla.addCell(new Paragraph("Costo de compra", headerFacturaFont));
               
               // Se recorren los registros con las compras del cliente en la
               // fecha ingresada y se van agregando los datos de estos
               // registros en las celdas de la tabla.
               r.first();
               do{
                  String idCompra = r.getInt(1) + "";
                  String nombreProducto = conexion.existeProducto(r.getInt(3)).getNombre();
                  String unidades = r.getInt(4) + "";
                  String costo = r.getInt(6) + "";
                  tabla.addCell(idCompra);
                  tabla.addCell(nombreProducto);
                  tabla.addCell(unidades);
                  tabla.addCell(costo);
               }while(r.next());
               
               // Se agrega la tabla al documento.
               doc.add(tabla);
               
               // Se agregan dos interlineas.
               doc.add(new Paragraph("\n"));
               doc.add(new Paragraph("\n"));
               
               // Nota de agradecimientos al cliente.
               p = new Paragraph(
                  "Gracias por comprar en el Minimercado Frutas y Verduras El Primo.",
                  footerFont
               );
               p.setAlignment(Paragraph.ALIGN_CENTER);
               
               // Se agrega la nota de agradecimientos.
               doc.add(p);
               
               // Se cierra el documento.
               doc.close();
               
               // Se cierra la conexion con la base de datos.
               conexion.cerrarConexion();
               
               // Se muestra al usuario un aviso informandole que la factura
               // se almaceno satisfactoriamente y el metodo retorna 'true'.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>Factura almacenada con exito!<strong><html>",
                  null,
                  JOptionPane.INFORMATION_MESSAGE
               );
               return true;
            }else{
               
               // Si no existen datos de compra para el cliente dado en la fecha
               // dada se muestra el usuario un aviso informandoselo.
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>El cliente no ha realizado compras aún!<strong><html>",
                  null,
                  JOptionPane.WARNING_MESSAGE
               );
            }
         }else{
            
            // Si el cliente no existe en la base de datos, entonces se muestra
            // un aviso de error al usuario.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Cliente no encontrado!<strong><html>",
               null,
               JOptionPane.ERROR_MESSAGE
            );
         }
      }catch(Exception e){
         System.out.println("Error from GeneradorPDF: " + e.getMessage());
      }
      
      // Finalmente el metodo retorna 'false'.
      return false;
   }
   
   /**
    * Metodo estatico para generar reporte de inventario. Genera un documento
    * pdf con la informacion actual del inventario de productos.
    */
   public static void generarInventario(){
      
      Document doc = new Document();
      Conexion conexion = new Conexion();
      
      try{
         
         // Se obtiene una lista enlazada con los datos de todos los productos
         // de la tabla 'productos' de la base de datos.
         LinkedList<Producto> productos = conexion.listaProductos();
         
         if(productos.size() != 0){
            
            // Si el tamaño de la lista enlazada es mayor que cero, entonces se
            // obtiene la fecha actual y se almacena en una variable de tipo
            // 'java.sql.Date'.
            java.sql.Date hoy = new java.sql.Date(System.currentTimeMillis());
            
            // Se crea el documento pdf donde se escribira el reporte del
            // inventario.
            PdfWriter.getInstance(doc, new FileOutputStream(
               "inventario_" + hoy.toString() + ".pdf")
            );
            
            // Titulo del documento.
            String titulo = "Reporte de inventario con fecha " + hoy.toString();
            
            // Parrafo del titulo.
            Paragraph p = new Paragraph(titulo, titleFont);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            
            // Se abre el documento.
            doc.open();
            
            // Se agrega el parrafo del titulo.
            doc.add(p);
            
            // Se agregan dos interlineas.
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            
            // Se crea una tabla de 7 columnas.
            PdfPTable tabla = new PdfPTable(7);
            
            // Se establece el encabezado de la tabla.
            tabla.setHeaderRows(1);
            tabla.addCell(new Paragraph("Id", headerInventarioFont));
            tabla.addCell(new Paragraph("Producto", headerInventarioFont));
            tabla.addCell(new Paragraph("Tipo", headerInventarioFont));
            tabla.addCell(new Paragraph("Cantidad\nunitaria", headerInventarioFont));
            tabla.addCell(new Paragraph("Unidad de\nmedida", headerInventarioFont));
            tabla.addCell(new Paragraph("Precio\nunitario", headerInventarioFont));
            tabla.addCell(new Paragraph("Unidades\ntotales", headerInventarioFont));
            
            // Se recorre la lista enlazada 'productos' y se van agregando los
            // datos de cada producto a las celdas de la tabla.
            int size = productos.size();
            for (int i = 0; i < size; i++){
               Producto temp = productos.poll();
               tabla.addCell(temp.getId() + "");
               tabla.addCell(temp.getNombre());
               tabla.addCell(temp.getTipo());
               tabla.addCell(temp.getCantidad() + "");
               tabla.addCell(temp.getUnidadesMedida());
               tabla.addCell(temp.getPrecioUnitario() + "");
               tabla.addCell(temp.getTotalUnidades() + "");
            }
            
            // Se agrega la tabla al documento.
            doc.add(tabla);
            
            // Se cierra el documento.
            doc.close();
            
            // Se cierra la conexion con la base de datos.
            conexion.cerrarConexion();
            
            // Se muestra al usuario un aviso informandole que la factura se
            // almaceno satisfactoriamente.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Registro de inventario almacenado con exito!<strong><html>",
               null,
               JOptionPane.INFORMATION_MESSAGE
            );
         }else{
            
            // Se muestra al usuario un aviso de error informandole que no
            // existen productos registrados en la base de datos.
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>No hay productos en el inventario!<strong><html>",
               null,
               JOptionPane.WARNING_MESSAGE
            );
         }
      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }

}
