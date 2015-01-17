/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Connector {
    
    public Connection c;
    ResultSet rs;
    
    Connector()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdemo?zeroDateTimeBehavior=convertToNull","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public int prepare(String query)
    {
        int result=0;
        try {
            PreparedStatement p = c.prepareStatement(query);
            result=p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return result;
    }
    
    public void select(String query)
    {
        try {
            Statement s=c.createStatement();
            rs=s.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


