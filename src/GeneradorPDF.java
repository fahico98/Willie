
import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GeneradorPDF {
   
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
               tabla.addCell(new Paragraph("Id compra", headerFacturaFont));
               tabla.addCell(new Paragraph("Producto", headerFacturaFont));
               tabla.addCell(new Paragraph("Unidades", headerFacturaFont));
               tabla.addCell(new Paragraph("Costo de compra", headerFacturaFont));
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
               conexion.cerrarConexion();
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
      Document doc = new Document();
      Conexion conexion = new Conexion();
      try{
         LinkedList<Producto> productos = conexion.listaProductos();
         if(productos.size() != 0){
            java.sql.Date hoy = new java.sql.Date(System.currentTimeMillis());
            PdfWriter.getInstance(doc, new FileOutputStream(
               "inventario_" + hoy.toString() + ".pdf")
            );
            String titulo = "Reporte de inventario con fecha " + hoy.toString();
            Paragraph p = new Paragraph(titulo, titleFont);
            p.setAlignment(Paragraph.ALIGN_CENTER);
            doc.open();
            doc.add(p);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            PdfPTable tabla = new PdfPTable(7);
            tabla.setHeaderRows(1);
            tabla.addCell(new Paragraph("Id", headerInventarioFont));
            tabla.addCell(new Paragraph("Producto", headerInventarioFont));
            tabla.addCell(new Paragraph("Tipo", headerInventarioFont));
            tabla.addCell(new Paragraph("Cantidad\nunitaria", headerInventarioFont));
            tabla.addCell(new Paragraph("Unidad de\nmedida", headerInventarioFont));
            tabla.addCell(new Paragraph("Precio\nunitario", headerInventarioFont));
            tabla.addCell(new Paragraph("Unidades\ntotales", headerInventarioFont));
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
            doc.add(tabla);
            doc.close();
            conexion.cerrarConexion();
            JOptionPane.showMessageDialog(
               null,
               "<html><strong>Registro de inventario almacenado con exito!<strong><html>",
               null,
               JOptionPane.INFORMATION_MESSAGE
            );
         }else{
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
