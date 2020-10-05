package BOVisual.Login;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author Cy
 */

/* This here is the Method that looks for the EmployeeLogin and EmployeePassword */
public class GetEmpLoginData {
    public static void main(String[] args) {

        Connection connexion= null;
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("sa");
            ds.setPassword("sa");
            ds.setServerName("localhost");
            ds.setPortNumber(1433);
            ds.setDatabaseName("BookShop");
            connexion= ds.getConnection();
        } catch (SQLServerException ex) {
            System.err.println("Oops:connexion:"+ ex.getMessage());
        }
        
        try {
            Statement stmt= connexion.createStatement( 
                 
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
                    );
            String query= "SELECT * FROM EMPLOYEE;";
            
            ResultSet rs= stmt.executeQuery(query);

            while( rs.next()) {
                System.out.println( rs.getInt("EMPLOYEE_ID"));
                System.out.println( rs.getString("EMPLOYEE_LOGIN"));
                System.out.println( rs.getString("EMPLOYEE_PASSWORD"));
                System.out.println("--");
            }
            System.out.println("******");
            while( rs.previous()) {
                System.out.println( rs.getString("EMPLOYEE_ID"));
                System.out.println( rs.getString("EMPLOYEE_LOGIN"));
                System.out.println( rs.getString("EMPLOYEE_PASSWORD"));
                System.out.println("--");
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Oops:SQL:"+ ex.getErrorCode()+"/"+ex.getMessage());
        }
        
        try {
            connexion.close();
        } catch (SQLException ex) {
            System.err.println("Oops:close:"+ ex.getMessage());
        }
        System.out.println("Done!");
    }

}