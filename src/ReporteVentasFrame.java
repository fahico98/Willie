
import com.placeholder.PlaceHolder;
import java.awt.Color;

public class ReporteVentasFrame extends javax.swing.JFrame {
   
   private Usuario login;
   private String nombreTitulo, apellidoTitulo, rolTitulo;

   public ReporteVentasFrame(Usuario login) {
      initComponents();
      this.login = login;
      etiquetaTitulo();
      //PlaceHolder ph = new PlaceHolder(campoFechaFactura, "aaaa-mm-dd");
      PlaceHolder ph = new PlaceHolder(
         campoFechaFactura,
         new Color(189, 189, 189),
         Color.BLACK,
         "aaaa-mm-dd",
         false,
         "sansserif",
         14
      );
   }
   
   private void etiquetaTitulo(){
      nombreTitulo = login.getNombre().substring(0, 1).toUpperCase() +
         login.getNombre().substring(1).toLowerCase();
      apellidoTitulo = login.getApellido().substring(0, 1).toUpperCase() +
         login.getApellido().substring(1).toLowerCase();
      rolTitulo = login.getRol().substring(0, 1).toUpperCase() +
         login.getRol().substring(1).toLowerCase();
      etiquetaTituloRepVentas.setText("<html>" + rolTitulo + ": " + nombreTitulo + " " +
         apellidoTitulo + ".</html>");
   }
   
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      etiquetaTituloRepVentas = new javax.swing.JLabel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      campoIdCliente = new javax.swing.JTextField();
      campoFechaFactura = new javax.swing.JTextField();
      jButton1 = new javax.swing.JButton();
      jButton2 = new javax.swing.JButton();
      jButton3 = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      etiquetaTituloRepVentas.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
      etiquetaTituloRepVentas.setForeground(new java.awt.Color(0, 0, 0));
      etiquetaTituloRepVentas.setText("jLabel1");

      jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel1.setForeground(new java.awt.Color(0, 0, 0));
      jLabel1.setText("ID del cliente:");

      jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel2.setForeground(new java.awt.Color(0, 0, 0));
      jLabel2.setText("Fecha de factura:");

      jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
      jLabel3.setForeground(new java.awt.Color(0, 0, 0));
      jLabel3.setText("Datos de la factura");

      campoIdCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      campoFechaFactura.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N

      jButton1.setText("Generar factura");
      jButton1.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
         }
      });

      jButton2.setText("Limpiar campos");
      jButton2.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
         }
      });

      jButton3.setText("Cancelar");
      jButton3.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(etiquetaTituloRepVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addGap(236, 236, 236))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(110, 110, 110)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(jLabel2)
               .addComponent(jLabel1))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addComponent(campoIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
               .addComponent(campoFechaFactura))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(83, 83, 83)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(80, 80, 80))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(etiquetaTituloRepVentas)
            .addGap(40, 40, 40)
            .addComponent(jLabel3)
            .addGap(41, 41, 41)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel1)
               .addComponent(campoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(campoFechaFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(46, 46, 46)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jButton1)
               .addComponent(jButton2)
               .addComponent(jButton3))
            .addContainerGap(66, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
      new DashboardFrame(login).setVisible(true);
      dispose();
      
   }//GEN-LAST:event_jButton3ActionPerformed

   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
      campoIdCliente.setText("");
      campoFechaFactura.setText("");
      
   }//GEN-LAST:event_jButton2ActionPerformed

   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
      if(GeneradorPDF.generarFactura(Integer.parseInt(campoIdCliente.getText()), campoFechaFactura.getText())){
         new DashboardFrame(login).setVisible(true);
         dispose();
      }
      
   }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               //new ReporteVentasFrame().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField campoFechaFactura;
   private javax.swing.JTextField campoIdCliente;
   private javax.swing.JLabel etiquetaTituloRepVentas;
   private javax.swing.JButton jButton1;
   private javax.swing.JButton jButton2;
   private javax.swing.JButton jButton3;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JPanel jPanel1;
   // End of variables declaration//GEN-END:variables

}
