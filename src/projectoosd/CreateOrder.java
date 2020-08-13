package projectoosd;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class CreateOrder extends Order  {
        Connection con = null;
        Statement st = null; 
        ResultSet rs = null;
         PreparedStatement ps = null;
        String s ;
   
         public void Create_Order(){
          Order order = new Order();
            String myString = "1234";
            String pricestring = pricetextfield.getText();
            String quantityString = quantitytextfield.getText();
            int priceint = Integer.parseInt(pricestring) ;
            int quantityint =Integer.parseInt(quantityString);
            int total_priceint = priceint * quantityint;
            
           String total_price2 = Integer.toString(total_priceint);
           
       //   JOptionPane.showMessageDialog(null, orderid1);
                   try{
                      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");

                String query = " insert into order_table values(?,?,?,?,?,?,?,?)";    
                    
                    ps = con.prepareStatement(query);
                    ps.setString(1, orderidtextfield.getText());
                    ps.setString(2,drugnametextfield.getText());
                    ps.setString(3,quantitytextfield.getText());
                    ps.setString(4,pricetextfield.getText());
                    ps.setString(5,orderdatetextfield.getText());
                    ps.setString(6,dptextfield.getText());
                    ps.setString(7,dpstatustextfield.getText());
                    ps.setString(8,total_price2);
                    int rows = ps.executeUpdate();
                       if(rows > 0)
     {
         JOptionPane.showMessageDialog(null, "Add success");
     }
                   }catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
                   
                   
                   
                   
       }
    
        
         public CreateOrder() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderid = new javax.swing.JLabel();
        drugnamelabel = new javax.swing.JLabel();
        quantitylabel = new javax.swing.JLabel();
        pricelabel = new javax.swing.JLabel();
        orderdatelabel = new javax.swing.JLabel();
        dplabel = new javax.swing.JLabel();
        dpstatuslabel = new javax.swing.JLabel();
        orderidtextfield = new javax.swing.JTextField();
        drugnametextfield = new javax.swing.JTextField();
        pricetextfield = new javax.swing.JTextField();
        quantitytextfield = new javax.swing.JTextField();
        dpstatustextfield = new javax.swing.JTextField();
        dptextfield = new javax.swing.JTextField();
        orderdatetextfield = new javax.swing.JTextField();
        addbutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        orderid.setText("Order ID");

        drugnamelabel.setText("Drug Name");

        quantitylabel.setText("Quantity");

        pricelabel.setText("Price");

        orderdatelabel.setText("Order Date");

        dplabel.setText("Doctor Prescription");

        dpstatuslabel.setText("Doctor Prescription Status");

        orderidtextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderidtextfieldActionPerformed(evt);
            }
        });

        drugnametextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drugnametextfieldActionPerformed(evt);
            }
        });

        pricetextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetextfieldActionPerformed(evt);
            }
        });

        quantitytextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitytextfieldActionPerformed(evt);
            }
        });

        dpstatustextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpstatustextfieldActionPerformed(evt);
            }
        });

        dptextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dptextfieldActionPerformed(evt);
            }
        });

        orderdatetextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderdatetextfieldActionPerformed(evt);
            }
        });

        addbutton.setText("ADD");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        jButton1.setText("BACK");
        jButton1.setActionCommand("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderid)
                    .addComponent(drugnamelabel)
                    .addComponent(quantitylabel)
                    .addComponent(pricelabel)
                    .addComponent(orderdatelabel)
                    .addComponent(dplabel)
                    .addComponent(dpstatuslabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pricetextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantitytextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dptextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderdatetextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpstatustextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(drugnametextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderidtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(addbutton)
                .addGap(70, 70, 70)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderid)
                    .addComponent(orderidtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(drugnamelabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(drugnametextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantitylabel)
                            .addComponent(quantitytextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pricelabel)
                            .addComponent(pricetextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(orderdatelabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(orderdatetextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dplabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dptextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpstatuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpstatustextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addbutton)
                    .addComponent(jButton1))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void orderidtextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderidtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderidtextfieldActionPerformed

    private void drugnametextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drugnametextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drugnametextfieldActionPerformed

    private void pricetextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetextfieldActionPerformed

    private void quantitytextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitytextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitytextfieldActionPerformed

    private void dpstatustextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpstatustextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpstatustextfieldActionPerformed

    private void dptextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dptextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dptextfieldActionPerformed

    private void orderdatetextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderdatetextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderdatetextfieldActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        Create_Order();
    }//GEN-LAST:event_addbuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Order info = new Order();
        info.setVisible(true);
        dispose();
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
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateOrder().setVisible(true);
            }
        });
        
        
        //Show_Order();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JLabel dplabel;
    private javax.swing.JLabel dpstatuslabel;
    private javax.swing.JTextField dpstatustextfield;
    private javax.swing.JTextField dptextfield;
    private javax.swing.JLabel drugnamelabel;
    private javax.swing.JTextField drugnametextfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel orderdatelabel;
    private javax.swing.JTextField orderdatetextfield;
    private javax.swing.JLabel orderid;
    private javax.swing.JTextField orderidtextfield;
    private javax.swing.JLabel pricelabel;
    private javax.swing.JTextField pricetextfield;
    private javax.swing.JLabel quantitylabel;
    private javax.swing.JTextField quantitytextfield;
    // End of variables declaration//GEN-END:variables
}
