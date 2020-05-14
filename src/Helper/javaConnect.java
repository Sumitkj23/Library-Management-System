package Helper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumit Kumar
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class javaConnect {
    
    Connection conn;
    
    public static Connection ConnectDb()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:sqlite:src\\library.sqlite");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
