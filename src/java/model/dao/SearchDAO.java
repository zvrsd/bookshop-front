package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Cy
 */
public class SearchDAO {
    
    public final String QUICK_SEARCH_WORD_HEATHER
            = "SELECT book.*,AUTHOR_F_NAME,AUTHOR_L_NAME,KEYWORD_NAME\n"
            + "FROM KEYWORD inner join\n" 
            + "ASSOC_BOOK_KEYWORD on KEYWORD.KEYWORD_ID = ASSOC_BOOK_KEYWORD.KEYWORD_ID inner join\n"
            + "BOOK on ASSOC_BOOK_KEYWORD.BOOK_ISBN = BOOK.BOOK_ISBN \n"
            + "inner join \n"
            + "ASSOC_BOOK_AUTHOR on BOOK.BOOK_ISBN=ASSOC_BOOK_AUTHOR.BOOK_ISBN\n"
            + "INNER JOIN \n"
            + "AUTHOR ON ASSOC_BOOK_AUTHOR.AUTHOR_ID=AUTHOR.AUTHOR_ID\n"
            + "WHERE BOOK_TITLE like '%?%'"
            + "OR AUTHOR_L_NAME like '%?%'"
            + "OR AUTHOR_F_NAME like '%?%'"
            + "OR BOOK_SUBTITLE like '%?%'"
            + "OR KEYWORD_NAME like '%?%'"
            + "OR BOOK.BOOK_ISBN like '%?%'";

/*
    Code in progress: 
    */
public List<SearchResults> getAll() throws NamingException, SQLException {
    
// creating a list of objects of the results    
        List<SearchResults> = new ArrayList<>();
    
        String query;
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        int result = -1;
 
        connection = database.getConnection();
        statement = connection.prepareStatement(QUICK_SEARCH_WORD_HEATHER);
        
        statement.setString(1, query.getRecherche());
        statement.setString(2, query.getRecherche());
        statement.setString(3, query.getRecherche());
        statement.setString(4, query.getRecherche());
        statement.setString(5, query.getRecherche());
        statement.setString(6, query.getRecherche());
        
        result = statement.executeUpdate();
        
        
        
        SearchResult object = null;
        
        
        while(resultSet.next()){
            object 
        }
        
        statement.close();
        connection.close();
}
    
    
}
