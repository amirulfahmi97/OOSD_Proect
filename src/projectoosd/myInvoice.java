package projectoosd;

import javax.swing.JOptionPane;

public class myInvoice extends javax.swing.JFrame {
    //declearation
    GST invoiceArray[] = new GST[1000]; 
    GST g; 
    int numOfInvoice = 0; 
    
    
    public void emptyTextBoxes()
    {
        txtFName.setText(""); 
        txtLName.setText("");
        txtID.setText(""); 
        txtmedicine_Name.setText("");
        txtDate.setText("");
        txtUnitPrice.setText("");
        txtQuantity.setText("");
        txtTotalAmount.setText(""); 
        txtNetAmount.setText("");
        
    }
    
    
    //validator for textbox of names
    public boolean nameValidator(String fn, String ln)
    {
        if (fn.equals("") || ln.equals(""))
        {
            JOptionPane.showMessageDialog(null,  "Can't perform action! There is no value in either first name or last name textbox",
                                              "alert", JOptionPane.OK_OPTION);             
          return false;   
        }
        
        if(containsNumber(fn)==true|| containsNumber(ln)==true)
        {
            int j = JOptionPane.showConfirmDialog(null,  "There is NUMBER in either first name or last name textbox"
                                                   +"DO YOU STILL WANT TO PERFORM?","alert", JOptionPane.YES_NO_OPTION);
            //if user selects ok then return true
            if(j ==0) 
            {
                return true; 
            }
            else if (j==1)
            {
                return false; 
            }          
        }
        
        //return defalut value
        return true; 
    }
    //validator for unit price and quantity
    public boolean priceQuanValidator(String p, String q)
    {
         if (p.equals("") || q.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Can't add product! "
                                                + "There is no value in either unit price textbox "
                                                + "or quantity textbox",
                                              "alert", JOptionPane.OK_OPTION); 
          return false; 
        }
        
        try{
            Double.parseDouble(p);
            Integer.parseInt(q); 
        }
        catch(Exception e)
       {
          JOptionPane.showMessageDialog(null, "Can't add product! "
                                                + "type mismatched! Unit price must be in a type of double or integer "
                                                + "And quantity must be in an integer type",                                                
                                                "alert", JOptionPane.OK_OPTION);   
          return false; 
       }
        return true; 
    }
    
    //function checks if a string contains number
   public boolean containsNumber(String s)
   {
  try{
       //convert a string into a char array
       char cArray[];        
       int sLength = s.length(); 
       cArray = s.toCharArray(); 
       
       //check each char in array, if it contains digits, then return true, else return false
       for(int i = 0; i<sLength; i++)
        {
           if(Character.isDigit(cArray[i]) == true)
           {
                
               return true; 
               
           }
           if(i == sLength - 1)
           {
               return false; 
           }
           
        }
      }
   catch(ArrayIndexOutOfBoundsException e)
      {
      JOptionPane.showMessageDialog(null, "Exception catched in containsNumber function!",
        "alert", JOptionPane.OK_OPTION); 
          
      }
  
  //return default value
  return false; 
   }
    
    /** Creates new form myInvoice */
    public myInvoice() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtLName = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtmedicine_Name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtNetAmount = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), null));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("MyPharmacy");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Invoice");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Customer details"));

        txtLName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtFName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("First name: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Last name: ");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.setEnabled(false);
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Product detail"));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("ID");

        txtID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Medicine");

        txtmedicine_Name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Date");

        txtDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmedicine_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(257, 257, 257))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDate, txtID, txtmedicine_Name});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmedicine_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDate, txtID, txtmedicine_Name});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtFName, txtLName});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreate, btnDelete, btnFind, btnUpdate});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtFName, txtLName});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreate, btnDelete, btnFind, btnUpdate});

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Unit price: ");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Quantity: ");

        txtUnitPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtTotalAmount.setEditable(false);
        txtTotalAmount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAmountActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Total amount: ");

        txtQuantity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Net amount:");

        txtNetAmount.setEditable(false);
        txtNetAmount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnAdd.setText("Add product");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel15)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(68, 68, 68)
                                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtNetAmount, txtQuantity, txtTotalAmount, txtUnitPrice});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnExit});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(40, 40, 40)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(txtNetAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnExit});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
    // TODO add your handling code here:
    
    //get text from screen
     String firstName = txtFName.getText(); 
        String lastName = txtLName.getText();
        double price;
        int numOfItems;
        
        //validation
        if (nameValidator(firstName,lastName) == false) {return; } 
        if (priceQuanValidator(txtUnitPrice.getText(), txtQuantity.getText()) == false){return; }
        else{price = Double.parseDouble(txtUnitPrice.getText()); 
                numOfItems = Integer.parseInt(txtQuantity.getText());}
       
 try{   
        //finding invoice in existing array, if invoice exists, then add product
    for(int j = 0; j< numOfInvoice; j++)
     {
        if(firstName.equals(invoiceArray[j].getCustomerFName() )&& lastName.equals(invoiceArray[j].getCustomerLName()))
        {
            invoiceArray[j].addProduct(price, numOfItems);
            
            txtTotalAmount.setText(Double.toString(invoiceArray[j].getTotalAmount()));
            txtNetAmount.setText(Double.toString(invoiceArray[j].getNetAmount()));
        }  
        
     }
   }
 catch(ArrayIndexOutOfBoundsException e)
   {
      JOptionPane.showMessageDialog(null, "Can't add product, array reaches maximum limit",
        "alert", JOptionPane.OK_OPTION); 
          
   }
catch(Exception e)
{
    JOptionPane.showMessageDialog(null, "Can't add product, Exception catched!",
        "alert", JOptionPane.OK_OPTION); 
}

    
    
}//GEN-LAST:event_btnAddActionPerformed

private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed

    //get text from screen    
    String firstName = txtFName.getText(); 
    String lastName = txtLName.getText();    
    int ID;
 
    
    
    //validation
    if (nameValidator(firstName,lastName) == false) {return; } 
    
    if(containsNumber(txtmedicine_Name.getText()) 
          )
    {
        if(JOptionPane.showConfirmDialog(null, "Can't perform action! "
                + "There is number in medicine name input box!"
                + "Do you still want to perform?","alert", JOptionPane.YES_NO_OPTION)  ==  1)
        {
            return; 
        }
    }
    
    try{
        ID = Integer.parseInt(txtID.getText());
     
    
    }
    catch (Exception e)
    {
        JOptionPane.showMessageDialog(null, "Can't create customer! Data type mismatched! "
                + "Product ID must in integer type",
        "alert", JOptionPane.OK_OPTION); 
        
        return; 
    }
     
    
    
   try{  
    //checks customer name in invoice array, if it already exists,return
    //else create new instance
    int i;
    for(i = 0;i<numOfInvoice; i++)
    { 
        if(firstName.equals(invoiceArray[i].getCustomerFName()) && lastName.equals(invoiceArray[i].getCustomerLName()))
        {
             JOptionPane.showMessageDialog(null, "Can't add customer, customer already exists!",
        "alert", JOptionPane.OK_OPTION); 
            return;            
        }        
    }   
    //when no invoice has been created or can't find name in array, add customer 
    if (numOfInvoice == 0 || i == numOfInvoice)
    {
        if(firstName.equals("")&&lastName.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Can't add customer, customer name can't be empty value",
        "alert", JOptionPane.OK_OPTION); 
        }
        else 
        {
        g  = new GST(firstName, lastName, ID, txtmedicine_Name.getText(), txtDate.getText());
        invoiceArray[numOfInvoice] = g; 
        numOfInvoice++; 
               
        }
    } 
    //empty product textboxes for unit price, quantity, amount, net amount 
        txtUnitPrice.setText("");
        txtQuantity.setText("");
        txtTotalAmount.setText(""); 
        txtNetAmount.setText("");
        
    //enable buttons
    btnFind.setEnabled(true); 
    btnDelete.setEnabled(true); 
    btnUpdate.setEnabled(true); 
    btnAdd.setEnabled(true);
    
    
}
catch(ArrayIndexOutOfBoundsException e)
   {
      JOptionPane.showMessageDialog(null, "Can't add customer, array reaches maximum limit",
        "alert", JOptionPane.OK_OPTION); 
          
   }
catch(Exception e)
 {
    JOptionPane.showMessageDialog(null, "Can't add customer, Exception catched!",
        "alert", JOptionPane.OK_OPTION); 
 }

}//GEN-LAST:event_btnCreateActionPerformed



    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
     
        //get text from screen
        String firstName = txtFName.getText(); 
        String lastName = txtLName.getText();
        
        //validation
    if (nameValidator(firstName,lastName) == false) {return; } 
    
   try{    
        //finding name in existing array
    for(int j = 0; j< numOfInvoice; j++)
    {
        if(firstName.equals(invoiceArray[j].getCustomerFName() )&& lastName.equals(invoiceArray[j].getCustomerLName()))
        {
            txtID.setText(Integer.toString(invoiceArray[j].getProductID())); 
            txtmedicine_Name.setText(invoiceArray[j]. getMedicineName());
            txtDate.setText(invoiceArray[j].getDate()); 
            txtUnitPrice.setText(""); 
            txtQuantity.setText("");
            txtTotalAmount.setText(Double.toString(invoiceArray[j].getTotalAmount())); 
            txtNetAmount.setText(Double.toString(invoiceArray[j].getNetAmount())); 
             
            //enable add product button
            btnAdd.setEnabled(true);
            break;
        }  
       if(j==numOfInvoice - 1) 
       {
           emptyTextBoxes(); 
           JOptionPane.showMessageDialog(null, "Can't find customer in database!",
        "alert", JOptionPane.OK_OPTION);
       }
    }
}
catch(ArrayIndexOutOfBoundsException e)
   {
      JOptionPane.showMessageDialog(null, "Customer array reaches maximum limit",
        "alert", JOptionPane.OK_OPTION); 
          
   }
catch(Exception e)
{
    JOptionPane.showMessageDialog(null, "Exception catched!",
        "alert", JOptionPane.OK_OPTION); 
}
    
    
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        String firstName = txtFName.getText(); 
        String lastName = txtLName.getText();  
        
          //validation
    if (nameValidator(firstName,lastName) == false) {return; } 
    
    if(containsNumber(txtmedicine_Name.getText())
        )
    {
        if(JOptionPane.showConfirmDialog(null, "Can't perform action! "
                + "There is number in medicine name input box!"
                + "Do you still want to perform?","alert", JOptionPane.YES_NO_OPTION)  ==  1)
        {
            return; 
        }
    }    
    
try{
    for(int j = 0; j< numOfInvoice; j++)
    {
        if(firstName.equals(invoiceArray[j].getCustomerFName() )&& lastName.equals(invoiceArray[j].getCustomerLName()))
        {
            invoiceArray[j].setProductID(Integer.parseInt(txtID.getText()));
           invoiceArray[j].setMedicineName(txtmedicine_Name.getText());
           invoiceArray[j].setDate(txtDate.getText());
            
           //enable add product button
            btnAdd.setEnabled(true);
            break;
        }
        
        if(j==numOfInvoice - 1) 
       {
           
           JOptionPane.showMessageDialog(null, "Can't update, can't find customer name in database!",
        "alert", JOptionPane.OK_OPTION);
       }
        
    }
    
}
catch(ArrayIndexOutOfBoundsException e)
   {
      JOptionPane.showMessageDialog(null, "Customer array reaches maximum limit",
        "alert", JOptionPane.OK_OPTION); 
          
   }
catch(Exception e)
{
    JOptionPane.showMessageDialog(null, "Exception catched!",
        "alert", JOptionPane.OK_OPTION); 
}


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        String firstName = txtFName.getText(); 
        String lastName = txtLName.getText();
        
          //validation
    if (nameValidator(firstName,lastName) == false) {return; } 
        
try{
        //find specific index from array, 
        int j;
    for( j= 0; j< numOfInvoice; j++)
    {
        if(firstName.equals(invoiceArray[j].getCustomerFName() )&& lastName.equals(invoiceArray[j].getCustomerLName()))
        {
           break; 
        }         
    }
    //delete specific invoice and then push invoices one step forward
    if (numOfInvoice >=1)
    {
        //starts at the invoice you wanted to delete
        for(int k = j; k<numOfInvoice-1; k++)
        {
            invoiceArray[k] = invoiceArray[k+1];
        }
        
        //clear the last invoice in array
        g = new GST(); 
        invoiceArray[numOfInvoice - 1] = g;             
    }//GEN-LAST:event_btnDeleteActionPerformed
    else 
     {
        JOptionPane.showMessageDialog(null, "Can't delete invoice, database is empty",
        "alert", JOptionPane.OK_OPTION);  
     }
    
    emptyTextBoxes();
}
catch(ArrayIndexOutOfBoundsException e)
   {
      JOptionPane.showMessageDialog(null, "Customer array reaches maximum limit",
        "alert", JOptionPane.OK_OPTION); 
          
   }
catch(Exception e)
{
    JOptionPane.showMessageDialog(null, "Exception catched!",
        "alert", JOptionPane.OK_OPTION); 
}
    
    
    }
private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed

    System.exit(0);
}//GEN-LAST:event_btnExitActionPerformed

private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
// TODO add your handling code here:\
    //clear textboxes
    emptyTextBoxes();
    
    
    
}//GEN-LAST:event_btnClearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          this.dispose();
        Cashier.main(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAmountActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed
 
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
            java.util.logging.Logger.getLogger(myInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myInvoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new myInvoice().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtNetAmount;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTotalAmount;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtmedicine_Name;
    // End of variables declaration//GEN-END:variables
}
