
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {
     protected Connection connection;

    public DBContext() {
        try {
            String user = "sa";
            String pass = "sa";   
            String url = "jdbc:sqlserver://localhost:1433;databaseName=DB_4Food";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        DBContext db = new DBContext();
        System.out.println("Connected: " + (db.connection != null));
    }
}
