
package projectoosd;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Stock extends javax.swing.JFrame {
            Connection con = null;
        Statement st = null; 
        ResultSet rs = null;
           PreparedStatement ps = null;
        String s ; 
        
    private String productid;
    private String productname;
    private String producttype;
    private String productdescription;
    private String productcategory;
    private String quantity;
    private String purchasedate;
    private String expireddate;
    private String manufacture;
    private String supplierid;
    private String suppliername;

    public Stock(
            String productid,
            String productname, 
            String producttype, 
            String productdescription,
            String productcategory, 
            String quantity,
            String purchasedate, 
            String expireddate,
            String supplierid, 
            String suppliername,
            String manufacture)
    {
        this.productid = productid;
        this.productname = productname;
        this.quantity = quantity;
        this.expireddate = expireddate;
        this.purchasedate = purchasedate;
        this.supplierid = supplierid;
        this.suppliername = suppliername;
       this.manufacture = manufacture;
       this.productcategory = productcategory;
       this.productdescription = productdescription;
       this.producttype = producttype;
        
    }
     public String getproducttypen()
    {
        return producttype ;
    }
     public String getproductdescription()
    {
        return productdescription ;
    }
    
    public String getproductcategory()
    {
        return productcategory ;
    }
    public String getproductID()
    {
        return productid;
    }
    
    public String getproductname()
    {
        return productname;
    }
    public String getquantity()
    {
        return quantity;
    }
    
    public String getexpireddate()
    {
        return expireddate;
    }
    
    public String getpurchasedate()
    {
        return purchasedate;
    }
    
    public String getmanufacture()
    {
        return manufacture;
    }
    
    public String getsupplierid()
    {
        return supplierid;
    }
    
    public String getsuppliername()
    {
        return suppliername;
    }
    
    public Stock() {
        initComponents();
          // Insert this line into your code
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
     jTable1.getColumnModel().getColumn(1).setPreferredWidth(140);
     jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
    jTable1.setRowHeight(30);

    }

public ArrayList<Stock> ShowStock(){
    ArrayList<Stock>  ShowStock = new ArrayList<>();
    
    try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");
    String query = " SELECT *from stock";
    st =    (Statement) con.createStatement();
    rs = st.executeQuery(query);
    Stock stock;
    while(rs.next())
    {
        stock = new Stock(rs.getString("productid")
                ,rs.getString("productname"),
                rs.getString("typeofproduct"),
                rs.getString("productdescription"),
                rs.getString("productcategory"),
                rs.getString("quantity"),
                rs.getString("purchase_date"),
                rs.getString("expired_date"),
                rs.getString("supplierid"),
                rs.getString("suppliername"),
                rs.getString("manufacturer")
        );
     ShowStock.add(stock);
                //   order = new Order(rs.getInt("orderid"),rs.getString("drugname"),rs.getInt("quantity"),rs.getInt("price"),rs.getDate("orderdate"), rs.getString("doctorprescription"),rs.getString("dp_status"),rs.getInt("total_price"));
    }
 
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
        return ShowStock;
    
}
public void showstock()
{
    //JOptionPane.showMessageDialog(null,"test");
    ArrayList<Stock> list = ShowStock();
   // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       Object[] row = new Object[11];
       for(int i = 0 ; i < list.size(); i++ )
       {
            row[0] = list.get(i).getproductID();
            row[1] = list.get(i).getproductname();
            row[2] = list.get(i).getproducttypen();
           row[3] = list.get(i).getproductdescription();
             row[4] = list.get(i).getproductcategory();
            row[5] = list.get(i).getquantity();
            row[6] = list.get(i).getpurchasedate();
            row[7] = list.get(i).getexpireddate();
            row[8] = list.get(i).getmanufacture();
           row[9] = list.get(i).getsupplierid();
            row[10] = list.get(i).getsuppliername();
            model.addRow(row);
             //JOptionPane.showMessageDialog(null,"test");
       }




}
    
public void addStock()
{
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   
   productid = jTextField1.getText();
   productname = jTextField2.getText();
   producttype = jTextField4.getText();
    productdescription  = jTextField9.getText();
    productcategory = jTextField5.getText();
   quantity = jTextField3.getText();
    purchasedate = dateFormat.format(jDateChooser1.getDate());
     expireddate = dateFormat.format(jDateChooser2.getDate());

     manufacture    = jTextField6.getText();
     supplierid= jTextField7.getText();
     suppliername= jTextField8.getText();
     
     try{
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oosd","root","");

     String query = "insert into"
             + " stock(productname,"
             + "typeofproduct,productdescription,productcategory,"
             + "quantity,purchase_date,expired_date,"
             + "manufacturer,supplierid,suppliername"
             + ") "
             + "values(?,?,?,?,?,?,?,?,?,?)";
     
     ps = con.prepareStatement(query);
     ps.setString(1,productname);
     ps.setString(2,producttype);
     ps.setString(3,productdescription);
     ps.setString(4,productcategory);
     ps.setString(5,quantity);
     ps.setString(6,purchasedate);
     ps.setString(7,expireddate);
     ps.setString(8,manufacture);
     ps.setString(9,supplierid);
     ps.setString(10,suppliername);
     int rows = ps.executeUpdate();
     if(rows > 0)
     {
         JOptionPane.showMessageDialog(null, "Add success");
     }
     
     }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
     
     
     
     
    //JOptionPane.showMessageDialog(null, productid);
}
   public void updatestock()
   {

           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   productid = jTextField1.getText();
   productname = jTextField2.getText();
   producttype = jTextField4.getText();
    productdescription  = jTextField9.getText();
    productcategory = jTextField5.getText();
   quantity = jTextField3.getText();
    purchasedate = dateFormat.format(jDateChooser1.getDate());
     expireddate = dateFormat.format(jDateChooser2.getDate());

     manufacture    = jTextField6.getText();
     supplierid= jTextField7.getText();
     suppliername= jTextField8.getText();
     
        try{
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");
         String queryupdate = "update stock set productname = ?,typeofproduct = ?,productdescription = ?,"
                 + "productcategory = ?,quantity = ?,purchase_date = ?,expired_date = ?,manufacturer = ?,supplierid = ?,suppliername = ? where productid = ?";
       ps = con.prepareStatement(queryupdate);
     ps.setString(1,productname);
     ps.setString(2,producttype);
     ps.setString(3,productdescription);
     ps.setString(4,productcategory);
     ps.setString(5,quantity);
     ps.setString(6,purchasedate);
     ps.setString(7,expireddate);
     ps.setString(8,manufacture);
     ps.setString(9,supplierid);
     ps.setString(10,suppliername);
     ps.setString(11, productid);
     
      int rows = ps.executeUpdate();
      
      if(rows > 0 )
      {
           JOptionPane.showMessageDialog(null,"succesfull update");
      }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
       
   }
public void deletestock()
    {
        String inpputedproductid = null;
        
       inpputedproductid= JOptionPane.showInputDialog(null,"Insert Product ID");
        
        //JOptionPane.showMessageDialog(null, inpputedproductid);
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");
        
        String deletequery = "delete from stock where productid=?";
        ps = con.prepareStatement(deletequery);
        ps.setString(1,inpputedproductid );
        int rows = ps.executeUpdate();
        if ( rows > 0 )
        {
            JOptionPane.showMessageDialog(null, "Successfull Delete");
        }
     
     
     
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR");
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Product Name", "Product Type", "Description", "Category", "Quantity", "Purchase Date", "Expired Date", "Manufacture", "Supplier Id", "Supplier Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("REFRESH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Product ID");

        jLabel2.setText("Product Name");

        jLabel3.setText("Expired Date");

        jLabel4.setText("Purchase Date");

        jLabel5.setText("Quantity");

        jLabel6.setText("Manufacture");

        jLabel7.setText("Supplier ID");

        jTextField1.setEditable(false);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Supplier Name");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Product Type");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel10.setText("Description");

        jLabel11.setText("Category");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jButton5.setText("Edit");
        jButton5.setActionCommand("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addGap(53, 53, 53)
                .addComponent(jButton2)
                .addGap(58, 58, 58)
                .addComponent(jButton3)
                .addGap(56, 56, 56)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField4)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 4, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1418, Short.MAX_VALUE)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(227, 227, 227))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(22, 22, 22))
        );

        jButton5.getAccessibleContext().setAccessibleName("Edit");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        addStock();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        showstock();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        
        deletestock();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updatestock();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    //     purchasedate = dateFormat.format(jDateChooser1.getDate());
                    //expireddate = dateFormat.format(jDateChooser2.getDate());
                    
                    DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                    int row = jTable1.getSelectedRow();
                    String productid1 = (String) model.getValueAt(row,0);
                    String productname1 = (String) model.getValueAt(row, 1);
                    String producttype1 = (String) model.getValueAt(row, 2);
                    String productdescription1 = (String) model.getValueAt(row, 3);
                    String productcategory1 = (String) model.getValueAt(row, 4);
                    String quantity1 = (String) model.getValueAt(row, 5);
                    String purchasedate1 = (String) model.getValueAt(row, 6);
                    String expireddate1 = (String) model.getValueAt(row, 7);
                    String manufacture1 = (String) model.getValueAt(row, 8);
                    String supplierid1 = (String) model.getValueAt(row, 9);
                    String suppliername1 = (String) model.getValueAt(row, 10);
                    // Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(purchasedate1);
                    // Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse(expireddate1);
                    Date date = dateFormat.parse(purchasedate1);
                    Date date2 = dateFormat.parse(expireddate1);
                    jTextField1.setText(productid1);
                    jTextField2.setText(productname1);
                    jTextField4.setText(producttype1);
                    jTextField9.setText(productdescription1);
                    jTextField5.setText(productcategory1);
                    jTextField3.setText(quantity1);
                    jDateChooser1.setDate(date);
                    
                    jDateChooser2.setDate(date2);
                    
                    jTextField6.setText(manufacture1);
                    
                    jTextField7.setText(supplierid1);
                    jTextField8.setText(suppliername1);
                    
     
                } catch (ParseException ex) {
                    Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
                }

               
               
    }//GEN-LAST:event_jButton5ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    public com.toedter.calendar.JDateChooser jDateChooser1;
    public com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    public javax.swing.JTextField jTextField8;
    public javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
