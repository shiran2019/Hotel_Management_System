
package Classes;

import static Classes.DBCredentials.connectString;
import static Classes.DBCredentials.password;
import static Classes.DBCredentials.username;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CustomerIdComboGenerator {

public static void loadCustomerID(JComboBox comboBox){
    Connection con = null;
    try {
           con = DriverManager.getConnection(connectString, username, password);
            
            Statement statement;
            statement = con.createStatement();
            
            
            ResultSet rs = statement.executeQuery("SELECT Customer_ID  FROM hotelmanagementsystem.customer ORDER BY Customer_ID Asc;");
          
            
            while(rs.next()){
        String cusID = rs.getString(1);
        comboBox.addItem(cusID);
}   
            con.close();
        
    } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); 
    }
  

    
}

public static void loadCustomerIDStaffAssign(JComboBox comboBox){
    Connection con = null;
    try {
           con = DriverManager.getConnection(connectString, username, password);
            
            Statement statement;
            statement = con.createStatement();
            
            
            ResultSet rs = statement.executeQuery("SELECT Distinct Customer_ID  FROM hotelmanagementsystem.bil_selected_packages ORDER BY Customer_ID Asc;");
          
            
            while(rs.next()){
        String cusID = rs.getString(1);
        comboBox.addItem(cusID);
}   
            con.close();
        
    } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); 
    }
  

    
}

public static void loadCustomerName(JTextField customerNameTxtField,String custID){
    Connection con = null; 
    try {
           con = DriverManager.getConnection(connectString, username, password);
            
            Statement statement;
            statement = con.createStatement();
 
            ResultSet rs = statement.executeQuery("SELECT  First_Name,Last_Name FROM hotelmanagementsystem.customer WHERE Customer_ID = '"+custID+"';");

            while(rs.next()){
        String custName = rs.getString(1)+ " " + rs.getString(2);
        customerNameTxtField.setText(custName);
        System.out.println(custName);
           
}       
     
    } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); 
        
    }
  
}





//loads customer address to the bill page text area 
public static void loadCustomerInfoToTxtArea(JTextArea customerLabelTxt,String custID){
    Connection con = null; 
    try {
           con = DriverManager.getConnection(connectString, username, password);
            
            Statement statement;
            statement = con.createStatement();
 
            ResultSet rs = statement.executeQuery("SELECT  full_name, Address, Country, Email, Contact_number FROM hotelmanagementsystem.basic_customer_contact_info WHERE Customer_ID = '"+custID+"' limit 1 ;");

            while(rs.next()){
        String custDetails = rs.getString(1)+ "\n" + rs.getString(2) + "\n"+rs.getString(3) +"\nE-Mail : "+ rs.getString(4) +"\nPhone No : "+ rs.getString(5);
        customerLabelTxt.setText(custDetails);
        System.out.println(custDetails);
           
}       
     
    } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Exception occured : "+ e,"SQL exception",JOptionPane.ERROR_MESSAGE); 
        
    }
  
}

}
/*
       try {
String sql=???SELECT * FROM userinfo???;
pst=conn.prepareStatement(sql);
rs = pst.executeQuery(sql);
while(rs.next()){
String fname = rs.getString(???FirstName???);
String lname = rs.getString(???LastName???);
String name = fname + ??? ??? + lname;
jComboBox1.addItem(name);
}
}catch(SQLException e) {
JOptionPane.showMessageDialog(this, e.getMessage());
}
*/