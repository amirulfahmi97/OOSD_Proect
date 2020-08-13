/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectoosd;

import com.mysql.jdbc.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projectoosd.loginpackage.*;

/**
 *
 * @author Amirul Fahmi
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       
     JOptionPane.showMessageDialog(null, "WELCOME!");
     MenuSplit info = new MenuSplit();
     info.setVisible(true);
     //info.dispose();
        //Employee info = new Employee();
        //info.setVisible(true);
         //info.dispose();
        
        //Order info = new Order();
        //info.setVisible(true);
       // dispose();
    }
    public void Show_user()
    {
 
    }
}
