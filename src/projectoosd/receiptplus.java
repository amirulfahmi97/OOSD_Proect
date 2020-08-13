package projectoosd;


public class receiptplus {
     private double price; 
    private int quantity; 
    private double total;
    
       //functions
    public void addProduct(double uPrice, int Quantity){
    price = uPrice; 
    quantity = Quantity; 
    total = total + (price*quantity); 
    }
}
