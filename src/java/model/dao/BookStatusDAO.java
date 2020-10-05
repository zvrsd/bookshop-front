package model.dao;

import db.Database;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.entity.BookStatus;
import model.entity.Book;

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
    
    public final String QUERY_INSERT_BOOK_STATUS
        = "INSERT INTO " + TABLE_BOOK
        + "(BOOK_ISBN, PUBLISHER_ID, "
        + "VAT_ID, BOOK_TITLE, "
        + "BOOK_SUBTITLE, "
        + "BOOK_HT_PRICE, "
        + "BOOK_COVER_URL, "
        + "BOOK_SUMMARY, "
        + "BOOK_STOCK_QTY,"
        + "BOOK_SHELF, "
        + "BOOK_POST_IT)"
        + " values"
        + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, )";
    
    final ImageIcon icon = new ImageIcon("icone.png");
    Image image2 = icon.getImage().getScaledInstance(32,32,0);
    
    @Override
    public void add(BookStatus object) {
        try {
            Database database = Database.getInstance();
            Connection connection;
            PreparedStatement statement;
            ResultSet resultSet;
            connection = database.getConnection();
            
            statement = connection.prepareStatement(QUERY_INSERT_BOOK_STATUS);
            
            statement.setString(1, object.getIsbn());
            statement.setInt(2, object.getPublisher().getId());

            resultSet = statement.executeQuery();

            statement.close();
            connection.close();

            JOptionPane.showMessageDialog(new JFrame(), "Nouveau livre enregistre dans BDD", "Livre insertion", 1, new ImageIcon(image2));
    
        } catch (NamingException ex) {
            Logger.getLogger(BookStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookStatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
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
    public void update(BookStatus object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(BookStatus object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
