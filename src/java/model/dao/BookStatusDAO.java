package model.dao;

import db.Database;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.entity.BookStatus;

/**
 *
 * @author zvr
 */
public class BookStatusDAO implements DAO<BookStatus, Integer> {

    public final String TABLE_BOOK_STATUS = "BOOK_STATUS";
    public final String TABLE_BOOK = "BOOK";
    
    public final String QUERY_SELECT_ALL_BOOK_STATUS
            = "SELECT * FROM " + TABLE_BOOK_STATUS;
    public final String QUERY_SELECT_BOOK_STATUS
            = "SELECT * FROM " + TABLE_BOOK_STATUS + " "
            + "WHERE BOOK_STATUS_ID = ?";
    public final String QUERY_INSERT_BOOK_STATUS =
            "INSERT INTO " + TABLE_BOOK_STATUS
            + "(BOOK_STATUS_NAME, BOOK_STATUS_POST_IT)"
            + " values"
            + "(?,?)";   
    public final String QUERY_UPDATE_BOOK_STATUS =
            "UPDATE "+TABLE_BOOK_STATUS+" "
            + "SET BOOK_STATUS_NAME=?,"
            + "BOOK_STATUS_POST_IT=? "
            + "WHERE BOOK_STATUS_ID = ?";  
    public final String QUERY_DELETE_BOOK_STATUS =
            "DELETE FROM BOOK_STATUS WHERE BOOK_STATUS_ID = ?";
    
    final ImageIcon icon = new ImageIcon("icone.png");
    Image image2 = icon.getImage().getScaledInstance(32,32,0);
    
    @Override
    public void add(BookStatus object) throws NamingException, SQLException {
        
            Database database = Database.getInstance();
            Connection connection;
            PreparedStatement statement;
            connection = database.getConnection();
            
            statement = connection.prepareStatement(QUERY_INSERT_BOOK_STATUS);
            
            statement.setString(1, object.getName());
            statement.setString(2, object.getPostIt());

            statement.executeUpdate();
            
            statement.close();
            // This is not supposed to be here if we use MVC pattern
            // this code should go into a view element, maybe in controller
            JOptionPane.showMessageDialog(new JFrame(), "Nouveau livre enregistre dans BDD", "Livre insertion", 1, new ImageIcon(image2));
    }

    @Override
    public List<BookStatus> getAll() throws NamingException, SQLException {

        List<BookStatus> objects = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_ALL_BOOK_STATUS);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        BookStatus object = null;

        while (resultSet.next()) {

            object = new BookStatus();
            object.setId(resultSet.getInt(1));
            object.setName(resultSet.getString(2));
            object.setPostIt(resultSet.getString(3));
            objects.add(object);
        }

        statement.close();

        return objects;
    }

    @Override
    public BookStatus getById(Integer id) throws NamingException, SQLException {

        BookStatus bookStatus = new BookStatus();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_BOOK_STATUS);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            bookStatus = new BookStatus();
            bookStatus.setId(resultSet.getInt(1));
            bookStatus.setName(resultSet.getString(2));
        }

        statement.close();

        return bookStatus;
    }

    @Override
    public void update(BookStatus object) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();
        
        statement = connection.prepareStatement(QUERY_UPDATE_BOOK_STATUS);

        statement.setString(1, object.getName());
        statement.setString(2, object.getPostIt());
        statement.setInt(3, object.getId());

        statement.executeUpdate();

        statement.close();
    }

    @Override
    public void delete(BookStatus object) throws NamingException, SQLException {
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();

        statement = connection.prepareStatement(QUERY_DELETE_BOOK_STATUS);
        statement.setInt(1, object.getId());
        statement.executeUpdate();

        statement.close();
    }
}