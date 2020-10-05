package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.entity.Author;

/**
 *
 * @author zvr
 */
public class AuthorDAO implements DAO<Author, Integer> {

    
    // added Other Methods to AuthorDAO:
    
    public final String TABLE_AUTHOR = "AUTHOR";
    
    public final String QUERY_INSERT_AUTHOR =
            "INSERT INTO " + TABLE_AUTHOR
            + "(AUTHOR_F_NAME, AUTHOR_L_NAME, AUTHOR_POST_IT)"
            + " values"
            + "(?,?,?)";
    
    public final String QUERY_SELECT_ALL_AUTHOR = "SELECT * FROM AUTHOR";
    public final String QUERY_SELECT_AUTHOR = 
            "SELECT * FROM AUTHOR "
            + "WHERE AUTHOR_ID = ?";
    public final String QUERY_UPDATE_AUTHOR =
            "UPDATE KEYWORD "
            + "SET AUTHOR_F_NAME=?, "
            + "SET AUTHOR_L_NAME=?, "
            + "SET AUTHOR_POST_IT=? "
            + "WHERE AUTHOR_ID = ?";
    public final String QUERY_DELETE_AUTHOR = 
            "DELETE FROM AUTHOR WHERE AUTHOR_ID = ?";


    @Override
    public void add(Author object) throws Exception {
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        try{
            statement = connection.prepareStatement(QUERY_INSERT_AUTHOR);

            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getPostIt());

            resultSet = statement.executeQuery();
            
            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }
    
    @Override
    public List<Author> getAll() throws NamingException, SQLException {
        List<Author> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_AUTHOR);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        Author object = null;

        while (resultSet.next()) {

            object = new Author();
            object.setId(resultSet.getInt(1));
            object.setFirstName(resultSet.getString(2));
            object.setLastName(resultSet.getString(3));
            object.setPostIt(resultSet.getString(4));

            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public Author getById(Integer id) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        Author author = new Author();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_AUTHOR);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            author = new Author();
            author.setId(resultSet.getInt(1));
            author.setFirstName(resultSet.getString(2));
            author.setLastName(resultSet.getString(3));
            author.setPostIt(resultSet.getString(4));
        }

        statement.close();
        
        return author;
    }

    @Override
    public void update(Author object) throws Exception {

        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        try{
            statement = connection.prepareStatement(QUERY_UPDATE_AUTHOR);

            statement.setString(1, object.getFirstName());
            statement.setString(2, object.getLastName());
            statement.setString(3, object.getPostIt());
            statement.setInt(4, object.getId());

            resultSet = statement.executeQuery();

            statement.close();
            connection.close();

        }catch(SQLException ex){
            throw new DatabaseException(ex.getMessage());
        }
    }

    @Override
    public void delete(Author object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    public Author get(Integer id) throws DatabaseException {
            
    Author author = new Author();
            try{
                
                Database database = Database.getInstance();
                Connection connection = null;
                PreparedStatement statement;
                ResultSet resultSet;
                
        try {
            connection = database.getConnection();
        } catch (NamingException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                    // Prepares and execute the query
                    statement = connection.prepareStatement(QUERY_SELECT_AUTHOR);
                    statement.setInt(1, (int)id);
                    resultSet = statement.executeQuery();
                    
                    // Creates objects based on the query results
                    while(resultSet.next()){
                        
                        author = new Author();
                        author.setId(resultSet.getInt(1));
                        author.setFirstName(resultSet.getString(2));
                        author.setLastName(resultSet.getString(3));
                        author.setPostIt(resultSet.getString(4));
                    }
                    
                    statement.close();
                    connection.close();
                    
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
        return author;
                
    }
}
