
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class GeneradorPDF {
   
   private static Font
      titleFont = FontFactory.getFont(
         FontFactory.HELVETICA,
         16,
         Font.BOLD,
         BaseColor.BLACK
      ),
      headerFont = FontFactory.getFont(
         FontFactory.HELVETICA,
         14,
         Font.BOLD,
         BaseColor.BLACK
      ),
      footerFont = FontFactory.getFont(
         FontFactory.HELVETICA,
         16,
         Font.BOLDITALIC,
         BaseColor.BLACK
      );
   
   public static boolean generarFactura(int idCliente, String fechaStr){
      Document doc = new Document();
      Conexion conexion = new Conexion();
      try{
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
         Date fecha = formatter.parse(fechaStr);
         Cliente cliente = conexion.existeCliente(idCliente);
         if(cliente != null){
            ResultSet r = conexion.fechaFactura(idCliente, new java.sql.Date(fecha.getTime()));
            if(r != null){
               PdfWriter.getInstance(doc, new FileOutputStream(
                  "factura_" + cliente.getId() + "_" + formatter.format(fecha) + ".pdf")
               );
               String titulo = "Reporte de compra del cliente " + cliente.getNombre() + " " +
                  cliente.getApellido() + " con fecha " + formatter.format(fecha);
               doc.open();
               Paragraph p = new Paragraph(titulo, titleFont);
               p.setAlignment(Paragraph.ALIGN_CENTER);
               doc.add(p);
               doc.add(new Paragraph("\n"));
               doc.add(new Paragraph("\n"));
               PdfPTable tabla = new PdfPTable(4);
               tabla.setHeaderRows(1);
               tabla.addCell(new Paragraph("Id compra", headerFont));
               tabla.addCell(new Paragraph("Producto", headerFont));
               tabla.addCell(new Paragraph("Unidades", headerFont));
               tabla.addCell(new Paragraph("Costo de compra", headerFont));
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
               doc.add(tabla);
               doc.add(new Paragraph("\n"));
               doc.add(new Paragraph("\n"));
               p = new Paragraph(
                  "Gracias por comprar en el Minimercado Frutas y Verduras El Primo.",
                  footerFont
               );
               p.setAlignment(Paragraph.ALIGN_CENTER);
               doc.add(p);
               doc.close();
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>Factura almacenada con exito!<strong><html>",
                  null,
                  JOptionPane.INFORMATION_MESSAGE
               );
               return true;
            }else{
               JOptionPane.showMessageDialog(
                  null,
                  "<html><strong>El cliente no ha realizado compras aún!<strong><html>",
                  null,
                  JOptionPane.WARNING_MESSAGE
               );
            }
         }else{
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
      return false;
   }
   
   public static void generarInventario(){
      
   }

}
