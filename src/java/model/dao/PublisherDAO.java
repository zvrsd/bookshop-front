package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Publisher;

/**
 *
 * @author zvr
 */
public class PublisherDAO implements DAO<Publisher,Integer>{

    public final String TABLE_PUBLISHER = "PUBLISHER";
    public final String TABLE_ASSOC_ADDRESS_PUBLISHER = "ASSOC_ADDRESS_PUBLISHER";
    
    public final String QUERY_INSERT_PUBLISHER =
            "INSERT INTO " + TABLE_PUBLISHER
            + "(PUBLISHER_NAME, PUBLISHER_POST_IT)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_INSERT_ASSOC_ADDRESS_PUBLISHER =
            "INSERT INTO " + TABLE_PUBLISHER
            + "(ADDRESS_ID, PUBLISHER_ID)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_SELECT_ALL_PUBLISHER = "SELECT * FROM PUBLISHER";
    
    public final String QUERY_SELECT_PUBLISHER = 
            "SELECT * FROM PUBLISHER "
            + "WHERE PUBLISHER_ID = ?";
    
    public final String QUERY_UPDATE_PUBLISHER =
            "UPDATE PUBLISHER "
            + "SET PUBLISHER_NAME=?,"
            + "PUBLISHER_POST_IT=? "
            + "WHERE PUBLISHER_ID = ?";
    
    public final String QUERY_DELETE_PUBLISHER =
        "DELETE FROM PUBLISHER WHERE PUBLISHER_ID = ?";
    
    public final String QUERY_DELETE_ASSOC_ADDRESS_PUBLISHER =
        "DELETE FROM "+TABLE_ASSOC_ADDRESS_PUBLISHER+" WHERE PUBLISHER_ID = ?";
    
    
    @Override
    public void add(Publisher object) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();

        statement = connection.prepareStatement(QUERY_INSERT_PUBLISHER);
        statement.setString(1, object.getName());
        statement.setString(2, object.getPostIt());
        statement.executeUpdate();

        statement.close();
    }

    @Override
    public List<Publisher> getAll() throws NamingException, SQLException {
  
        List<Publisher> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_PUBLISHER);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Publisher object = null;

        while (resultSet.next()) {

            object = new Publisher();
            object.setId(resultSet.getInt(1));
            object.setName(resultSet.getString(2));
            object.setPostIt(resultSet.getString(3));

            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public Publisher getById(Integer id) throws NamingException, SQLException {

        Publisher publisher = new Publisher();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_PUBLISHER);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            publisher = new Publisher();
            publisher.setId(resultSet.getInt(1));
            publisher.setName(resultSet.getString(2));
            publisher.setPostIt(resultSet.getString(3));
        }

        statement.close();

        return publisher;
    }

    @Override
    public void update(Publisher object) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();

        statement = connection.prepareStatement(QUERY_UPDATE_PUBLISHER);
        statement.setString(1, object.getName());
        statement.setString(2, object.getPostIt());
        statement.setInt(3, object.getId());
        statement.executeUpdate();

        statement.close();
    }

    @Override
    public void delete(Publisher object) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();

        statement = connection.prepareStatement(QUERY_DELETE_ASSOC_ADDRESS_PUBLISHER);
        statement.setInt(1, object.getId());
        statement.executeUpdate();

        statement = connection.prepareStatement(QUERY_DELETE_PUBLISHER);
        statement.setInt(1, object.getId());
        statement.executeUpdate();

        statement.close();
    }
}