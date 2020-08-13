package projectoosd;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class GST extends invoice {
    //variables
    private double gst;
   
    //constructors
    GST(){}
    GST(String custF, String custL, int product_ID, String medicine_Name, String Date){
    super(custF,custL,product_ID,medicine_Name,Date);         
    }
    
    //get gst
    public double getGst(){
        gst = super.getTotalAmount() * 0.1;
        return gst; 
    }
    
    //get net amount
    public double getNetAmount(){
        return super.getTotalAmount() - getGst();     
    }
    
    
    
}
