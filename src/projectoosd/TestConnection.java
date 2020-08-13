
package projectoosd;


import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TestConnection {

public static void main(String[] args) {

                Connection con = null;
        Statement st = null; 
        ResultSet rs = null;
        PreparedStatement ps = null;
        String s ;
       
        
             try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy_system","root","");
            st = (Statement) con.createStatement();
            //s = "select *from order_table";
            JOptionPane.showMessageDialog(null,"Succesfull connected");
            //rs = st.executeQuery(s);
     }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erorr");
        }
        
       

}


    
}
