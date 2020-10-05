
package model.dao.BO;

import db.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.dao.DAO;
import model.dao.DatabaseException;
import model.entity.BO.Employee;


/**
 *
 * @author cy
 */
public class EmployeeDAO implements DAO<Employee, Integer>{
    public final String TABLE_EMPLOYEE = "EMPLOYEE";
    
    public final String QUERY_INSERT_EMPLOYEE =
            "INSERT INTO " + TABLE_EMPLOYEE
            + "(EMPLOYEE_LOGIN, EMPLOYEE_PASSWORD, EMPLOYEE_DATE_START, EMPLOYEE_DATE_END)"
            + " values"
            + "(?,?,?,?)";
    
    public final String QUERY_SELECT_ALL_EMPLOYEE = "SELECT * FROM EMPLOYEE";
    
    public final String QUERY_SELECT_EMPLOYEE = 
            "SELECT * FROM EMPLOYEE "
            + "WHERE EMPLOYEE_ID = ?";
    
    public final String QUERY_UPDATE_EMPLOYEE =
            "UPDATE EMPLOYEE "
            + "SET EMPLOYEE_LOGIN=?, "
            + " EMPLOYEE_PASSWORD=?, "
            + " EMPLOYEE_DATE_START=?, "
            + " EMPLOYEE_DATE_END=? "
            + "WHERE EMPLOYEE_ID = ?";
    
    public final String QUERY_DELETE_EMPLOYEE = 
            "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
    
    public final String QUERY_LOGIN_PROCESS = 
            "SELECT * FROM EMPLOYEE "
            + " WHERE EMPLOYEE_LOGIN = ? AND EMPLOYEE_PASSWORD = ?";
    
    @Override
    public void add(Employee object) throws DatabaseException {
        
        try{
            
            Database database = Database.getInstance();
            Connection connection;
            PreparedStatement statement;
            int result = -1;
            
            connection = database.getConnection();
            
            try{
                statement = connection.prepareStatement(QUERY_INSERT_EMPLOYEE);
                
                statement.setString(1, object.getEmployeeLogin());
                statement.setString(2, object.getEmployeePassword());
                statement.setString(3, object.getEmployeeDateStart());
                statement.setString(4, object.getEmployeeDateEnd());
                
                result = statement.executeUpdate();
                
                statement.close();
                connection.close();
                
            }catch(SQLException ex){
                throw new DatabaseException(ex.getMessage());
            }
        }catch(NamingException ex){
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Employee object) throws DatabaseException {

        
        
        try{
            
            Database database = Database.getInstance();
            Connection connection;
            PreparedStatement statement;
            ResultSet resultSet;
            
            connection = database.getConnection();
            
            try{
            statement = connection.prepareStatement(QUERY_UPDATE_EMPLOYEE);

            statement.setString(1, object.getEmployeeLogin());
            statement.setString(2, object.getEmployeePassword());
            statement.setString(3, object.getEmployeeDateStart());
            statement.setString(4, object.getEmployeeDateEnd());
            statement.setInt(5, object.getEmployeeId());
            resultSet = statement.executeQuery();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
        }catch(NamingException ex){
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Employee object) throws DatabaseException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

       @Override
    public List<Employee> getAll() throws DatabaseException {
     Employee object = null;    
        try {
            List<Employee> objects = new ArrayList<>();
            
            Database database = Database.getInstance();
            Connection connection;
            PreparedStatement statement;
            ResultSet resultSet;
            connection = database.getConnection();
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_ALL_EMPLOYEE);
            resultSet = statement.executeQuery();
               
            // Creates objects based on the query results
           
            
            while(resultSet.next()){
                
                object = new Employee();
                object.setEmployeeId(resultSet.getInt(1));
                object.setEmployeeLogin(resultSet.getString(2));
                object.setEmployeePassword(resultSet.getString(3));
                object.setEmployeeDateStart(resultSet.getString(4));
                object.setEmployeeDateEnd(resultSet.getString(5));
                
                objects.add(object);
            }
            
            statement.close();
            connection.close();
        } catch (NamingException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } return employee;
                
    
    }

    public Employee get(Integer employeeId) throws DatabaseException {
        
            
        Employee employee = new Employee();
        
        // SQL server connection creation
            Database database = Database.getInstance();
            Connection connection;
            PreparedStatement statement;
            ResultSet resultSet;
            connection = database.getConnection();  
        
            return employee;
        }

        try{
            // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_SELECT_EMPLOYEE);
            statement.setInt(1, (int)employeeId);
            resultSet = statement.executeQuery();
            
            // Creates objects based on the query results
            while(resultSet.next()){
                
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt(1));
                employee.setEmployeeLogin(resultSet.getString(2));
                employee.setEmployeePassword(resultSet.getString(3));
                employee.setEmployeeDateStart(resultSet.getString(4));
                employee.setEmployeeDateEnd(resultSet.getString(5));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return employee;
    }
    
   public Employee getLogin(Employee employee) throws DatabaseException {
        
        Employee em = new Employee();
        try{
            
            Database database = Database.getInstance();
            Connection connection;
            PreparedStatement statement;
            ResultSet resultSet;
            int result = -1;
            
            try {
                connection = database.getConnection();
            } catch (NamingException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        return em;
        
        // Prepares and execute the query
            statement = connection.prepareStatement(QUERY_LOGIN_PROCESS);
//                    ResultSet.TYPE_SCROLL_SENSITIVE,
//                    ResultSet.CONCUR_READ_ONLY);
                    
                statement.setString(1, employee.getEmployeeLogin());
                statement.setString(2, employee.getEmployeePassword());
//            statement.getResultSet();
            resultSet = statement.executeQuery();
                        
            // Creates objects based on the query results
            while(resultSet.next()){
                
                em = new Employee();
                em.setEmployeeId(resultSet.getInt("EMPLOYEE_ID"));
                em.setEmployeeLogin(resultSet.getString("EMPLOYEE_LOGIN"));
                em.setEmployeePassword(resultSet.getString("EMPLOYEE_PASSWORD"));
                em.setEmployeeDateStart(resultSet.getString("EMPLOYEE_DATE_START"));
                em.setEmployeeDateEnd(resultSet.getString("EMPLOYEE_DATE_END"));
            }
            
            statement.close();
            connection.close();

        }catch(SQLException exe){
            System.out.println(exe.getMessage());
            return em;
        }
        
        return em;
    }

    @Override
    public Employee getById(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
