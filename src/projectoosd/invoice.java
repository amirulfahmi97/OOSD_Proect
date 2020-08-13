package projectoosd;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class invoice {
    //variables declearation 
    //private int customer_Id; 
    private String customer_FName;
    private String customer_LName; 
    private int product_id; 
    private String medicine_name; 
    private String date; 
    
    private double unitPrice; 
    private int quantity; 
    private double totalAmount; 
    
    //constructors
    invoice(){}    
    invoice(String custF, String custL, int product_ID, String medicine_Name, String Date){
    //customer_Id = cust_Id; 
    customer_FName = custF; 
    customer_LName =  custL;
    product_id = product_ID; 
    medicine_name = medicine_Name;
    date =  Date;
}
    //getter & setter
    /*public int getCustomerId(){
    return customer_Id; 
    }
    public void setCustomerId(int id){
    customer_Id = id; 
    }
    */
    
    public String getCustomerFName(){
    return customer_FName; 
    }
    public void setCustomerFName(String fName){
    customer_FName = fName; 
    }
    
    public String getCustomerLName(){
    return customer_LName; 
    } 
    public void setCustomerLName(String lName){
    customer_LName = lName; 
    }
    
    public int getProductID(){
    return product_id; 
    } 
    public void setProductID(int product){
    product_id = product; 
    }
    
    public String getMedicineName(){
    return medicine_name; 
    } 
    public void setMedicineName(String medicine){
    medicine_name = medicine;     
    }
    
    public String getDate(){
    return date; 
    } 
    public void setDate(String date){
    date = date; 
    }
    
    //total amount
    public double getTotalAmount(){
    return totalAmount; 
    }
    
    //functions
    public void addProduct(double uPrice, int Quantity){
    unitPrice = uPrice; 
    quantity = Quantity; 
    totalAmount = totalAmount + (unitPrice*quantity); 
    }
    
}
