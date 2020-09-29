package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Customer;
/**
 *
 * @author zvr
 */
public class CustomerDAO implements DAO<Customer,Long> {

    public final String TABLE_CUSTOMER = "CUSTOMER";

    public final String QUERY_SELECT_ALL_CUSTOMER
            = "SELECT * FROM " + TABLE_CUSTOMER;
    public final String QUERY_SELECT_CUSTOMER
            = "SELECT * FROM " + TABLE_CUSTOMER + " "
            + "WHERE CUSTOMER_ID = ?";
    public final String QUERY_SELECT_CUSTOMER_FROM_USERNAME
            = "SELECT * FROM " + TABLE_CUSTOMER + " "
            + "WHERE CUSTOMER_USERNAME = ? AND "
            + " AND CUSTOMER_PASSWORD = ?";
    
    @Override
    public void add(Customer object){
        
    }

    @Override
    public List<Customer> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Customer getById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Customer object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Customer object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Customer getByUsername(String username, String password) throws NamingException, SQLException{
        
        Customer customer = new Customer();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_CUSTOMER_FROM_USERNAME);
        statement.setString(1, username);
        statement.setString(2, password);
        
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            customer.setCustomerId(resultSet.getLong(1));
            customer.setCustomerLName(resultSet.getString(2));
            customer.setCustomerFName(resultSet.getString(3));
            customer.setCustomerEmail(resultSet.getString(4));
            customer.setCustomerUsername(resultSet.getString(5));
            customer.setCustomerPassword(resultSet.getString(6));
        }

        statement.close();

        return customer;
    }
}
