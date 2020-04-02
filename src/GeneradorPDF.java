
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class GeneradorPDF {
   
   
  
   public static void reporteInventario(){
      try{

         Document doc = new Document();
         PdfWriter.getInstance(doc, new FileOutputStream(
            "hello_world_document.pdf")
         );
         doc.open();
         Paragraph p = new Paragraph("Hello world...!");
         p.setAlignment(Paragraph.ALIGN_CENTER);
         doc.add(p);
         doc.close();

      }catch(Exception e){
         System.out.println("Error: " + e.getMessage());
      }
   }

}
