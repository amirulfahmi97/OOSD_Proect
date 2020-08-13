/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoosd;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Phamarcist extends javax.swing.JFrame{
    public String drugname;
            Connection con = null;
        Statement st = null; 
        ResultSet rs = null;
        PreparedStatement ps = null;
        String s ;
 public Phamarcist() {
        initComponents();
    }
 
    public void GetOrder(){
        String inputteduserid = orderidtextfield.getText();
        s = inputteduserid;
        try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");
           
           String query = " select *from order_table where orderid =  ?";
           ps = con.prepareStatement(query);
           ps.setString(1, s);
           rs = ps.executeQuery();
           while(rs.next())
           {
               String drugname = rs.getString("drugname");
               String quantity = rs.getString("quantity");
               String price = rs.getString("price");
               String order_date = rs.getString("orderdate");
              
               //JOptionPane.showMessageDialog(null,order_date);
               drugnametextfield.setText(drugname);
               quantitytextfield.setText(quantity);
               pricetextfield.setText(price);
               orderdatetextfield.setText(order_date);
               
           }
           
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRRO");
        }
        
        
        
    }    
    
    public void GetDoctorPrescription()
    {
         //String Searching = orderidtextfield.getText();
         String inputteduserid = orderidtextfield.getText();
        s = inputteduserid;
        try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");
           
           String query = " select * from order_table where orderid =  ?";
           ps = con.prepareStatement(query);
           ps.setString(1, s);
           rs = ps.executeQuery();
           while(rs.next())
           {
              
               String doctor_pre = rs.getString("doctorprescription");
               String dp_status = rs.getString("dp_status");

                dptextfield.setText(doctor_pre);
                dpstatustextfield.setText(dp_status);
           }
           
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRRO");
        }
        

    }
    
    public void ApprovedOrder()
    {  
        String inputteduserid = orderidtextfield.getText() ;
        s = inputteduserid;
        String Approved = "Approve";
        try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");
        
           String query = "update order_table set dp_status = ? where orderid=? ";
           ps = con.prepareStatement(query);
           ps.setString(1, "Approve");
           ps.setString(2, s);
           int rows = ps.executeUpdate();
         //  JOptionPane.showMessageDialog(null,"test");
           while(rs.next())
           {    dpstatustextfield.update(dpstatustextfield.getGraphics());
            String dp_status = rs.getString("dp_status");
             String orderid1 = rs.getString("orderid");
           }
           if ( rows > 0)
           {
               
                JOptionPane.showMessageDialog(null,"The Order has been approve");
                dpstatustextfield.setText("Approved");  
               TransferingOrder();
           }
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       
    }
    
    
    public void TransferingOrder()
    { 
       String inputteduserid = orderidtextfield.getText();
        s = inputteduserid;
     //   JOptionPane.showMessageDialog(null,"lalala");
        try{
        
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");

             String query2 = "insert into approved_order_table1 select *from order_table where orderid = ? ";
             ps = con.prepareStatement(query2);
             ps.setString(1, s);
             int rows = ps.executeUpdate();
                         

             if(rows > 0)
             {
                JOptionPane.showMessageDialog(null,"successfulll transfer");
                DeleteOrder();
             }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
           // JOptionPane.showMessageDialog(this, e);
        }
        
    }
   public void DeleteOrder()
   {
         String inputteduserid = orderidtextfield.getText() ;
        s = inputteduserid;
         try{
       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");

          String query3 = "delete from order_table where orderid=?";
           ps = con.prepareStatement(query3);
           ps.setString(1, s);
         //  ps.executeQuery(query2);
               int rows = ps.executeUpdate();
             if(rows > 0)
             {
                JOptionPane.showMessageDialog(null,"successfulll delete");
             }
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERRRO delete");
        }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        orderidtextfield = new javax.swing.JTextField();
        drugnametextfield = new javax.swing.JTextField();
        pricetextfield = new javax.swing.JTextField();
        quantitytextfield = new javax.swing.JTextField();
        orderid = new javax.swing.JLabel();
        dpstatustextfield = new javax.swing.JTextField();
        drugnamelabel = new javax.swing.JLabel();
        dptextfield = new javax.swing.JTextField();
        quantitylabel = new javax.swing.JLabel();
        orderdatetextfield = new javax.swing.JTextField();
        pricelabel = new javax.swing.JLabel();
        orderdatelabel = new javax.swing.JLabel();
        dplabel = new javax.swing.JLabel();
        dpstatuslabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        orderidtextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderidtextfieldActionPerformed(evt);
            }
        });

        drugnametextfield.setEditable(false);
        drugnametextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drugnametextfieldActionPerformed(evt);
            }
        });

        pricetextfield.setEditable(false);
        pricetextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetextfieldActionPerformed(evt);
            }
        });

        quantitytextfield.setEditable(false);
        quantitytextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitytextfieldActionPerformed(evt);
            }
        });

        orderid.setText("Order ID");

        dpstatustextfield.setEditable(false);
        dpstatustextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpstatustextfieldActionPerformed(evt);
            }
        });

        drugnamelabel.setText("Drug Name");

        dptextfield.setEditable(false);
        dptextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dptextfieldActionPerformed(evt);
            }
        });

        quantitylabel.setText("Quantity");

        orderdatetextfield.setEditable(false);
        orderdatetextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderdatetextfieldActionPerformed(evt);
            }
        });

        pricelabel.setText("Price");

        orderdatelabel.setText("Order Date");

        dplabel.setText("Doctor Prescription");

        dpstatuslabel.setText("Doctor Prescription Status");

        jButton1.setText("Get Order Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Order List");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Get Doctor Prescription");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Approve the order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Notify Expired Medicine");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orderid)
                            .addComponent(drugnamelabel)
                            .addComponent(quantitylabel)
                            .addComponent(pricelabel)
                            .addComponent(orderdatelabel))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pricetextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantitytextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(drugnametextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(orderidtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderdatetextfield))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dpstatuslabel)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addGap(57, 57, 57)
                                .addComponent(dpstatustextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dplabel)
                                .addGap(18, 18, 18)
                                .addComponent(dptextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dplabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dptextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpstatuslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpstatustextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(drugnamelabel))
                            .addComponent(drugnametextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(orderdatetextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50)
                .addComponent(jButton3)
                .addGap(48, 48, 48)
                .addComponent(jButton4)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderid)
                    .addComponent(orderidtextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton1)
                .addContainerGap(122, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Show_Order info = new Show_Order();
       info.setVisible(true);
      // dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //get order button.
       GetOrder();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
               
      GetDoctorPrescription();
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      ApprovedOrder();
       
          
       
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Phamarcist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Phamarcist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Phamarcist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Phamarcist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Phamarcist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dplabel;
    private javax.swing.JLabel dpstatuslabel;
    private javax.swing.JTextField dpstatustextfield;
    private javax.swing.JTextField dptextfield;
    private javax.swing.JLabel drugnamelabel;
    private javax.swing.JTextField drugnametextfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
