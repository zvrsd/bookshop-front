package model.dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import model.entity.Category;

/**
 *
 * @author zvr
 */
public class CategoryDAO implements DAO<Category, Integer> {
    
    public final String TABLE_CATEGORY = "CATEGORY";
    public final String TABLE_ASSOC_CATEGORY_CATEGORY = "ASSOC_CATEGORY_CATEGORY";

    public final String QUERY_SELECT_LAST_ID = "SELECT @@IDENTITY as ID";
    
    public final String QUERY_INSERT_CATEGORY =
            "INSERT INTO " + TABLE_CATEGORY
            + "(CATEGORY_NAME)"
            + " values"
            + "(?)";
    
    public final String QUERY_INSERT_ASSOC_CATEGORY_CATEGORY =
            "INSERT INTO " + TABLE_ASSOC_CATEGORY_CATEGORY
            + "(CATEGORY_PARENT_ID, CATEGORY_CHILD_ID)"
            + " values"
            + "(?,?)";
    
    public final String QUERY_SELECT_ALL_CATEGORY = "SELECT * FROM CATEGORY";
    
    public final String QUERY_SELECT_CATEGORY = 
            "SELECT * FROM CATEGORY "
            + "WHERE CATEGORY_ID = ?";
    
    public final String QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY = 
            "SELECT * FROM "+TABLE_ASSOC_CATEGORY_CATEGORY;
    
    public final String QUERY_SELECT_ALL_ASSOC_WHERE_ID = 
            QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY+" "
            + "WHERE CATEGORY_PARENT_ID = ?";
    
    public final String QUERY_CHECK_ASSOC =
            "SELECT 1 FROM ASSOC_CATEGORY_CATEGORY WHERE "
            + "CATEGORY_PARENT_ID = ? AND "
            + "CATEGORY_CHILD_ID = ?";
    
    public final String QUERY_UPDATE_CATEGORY =
            "UPDATE CATEGORY SET CATEGORY_NAME=? WHERE CATEGORY_ID = ?";
    
    public final String QUERY_DELETE_CATEGORY = 
            "DELETE FROM CATEGORY WHERE CATEGORY_ID = ?";
    
    public final String QUERY_DELETE_ASSOC_CATEGORY_CATEGORY = 
            "DELETE FROM "+TABLE_ASSOC_CATEGORY_CATEGORY+" WHERE "
            + "CATEGORY_PARENT_ID = ? AND "
            + "CATEGORY_CHILD_ID = ?";

    
    @Override
    public void add(Category object) throws Exception {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        int elementID = -1;
        
        connection = database.getConnection();
        
        statement = connection.prepareStatement(QUERY_INSERT_CATEGORY);
        statement.setString(1, object.getName());
        statement.executeUpdate();

        // Get the ID of the element we've just inserted
        statement = connection.prepareStatement(QUERY_SELECT_LAST_ID);
        resultSet = statement.executeQuery();
        resultSet.next();
        elementID = resultSet.getInt(1);
        
        object.setId(elementID);

        addAssociations(object);

        statement.close();
    }

    @Override
    public List<Category> getAll() throws NamingException, SQLException {
        
        List<Category> categories = new ArrayList<>();
        List<int[]> associations = new ArrayList<>();

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();

        statement = connection.prepareStatement(QUERY_SELECT_ALL_CATEGORY);
        resultSet = statement.executeQuery();

        Category category = null;
        while (resultSet.next()) {

            category = new Category();
            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));

            categories.add(category);
        }

        statement = connection.prepareStatement(
                QUERY_SELECT_ALL_ASSOC_CATEGORY_CATEGORY
        );
        resultSet = statement.executeQuery();

        while (resultSet.next()) {

            int[] association = new int[2];
            association[0] = resultSet.getInt(1);
            association[1] = resultSet.getInt(2);

            associations.add(association);
        }

        // Builds all the subcategories tree
        for (int[] association : associations) {
            for (Category cParent : categories) {
                if (cParent.getId() == association[0]) {
                    for (Category cEnfant : categories) {
                        if (cEnfant.getId() == association[1]) {
                            cParent.getCategories().add(cEnfant);
                        }
                    }
                }
            }
        }

        statement.close();

        return categories;
    }

    @Override
    public Category getById(Integer id) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        Category category = new Category();

        connection = database.getConnection();

        // Prepares and execute the query
        statement = connection.prepareStatement(QUERY_SELECT_CATEGORY);
        statement.setInt(1, (int) id);
        resultSet = statement.executeQuery();

        // Creates objects based on the query results
        if (resultSet.next()) {

            category = new Category();
            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
        }

        statement.close();

        return category;
    }

    @Override
    public void update(Category object) throws NamingException, SQLException {
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();
        
        statement = connection.prepareStatement(QUERY_UPDATE_CATEGORY);

        statement.setString(1, object.getName());
        statement.setInt(2, object.getId());
        statement.executeUpdate();

        addAssociations(object);
        removeAssociations(object);

        statement.close();
    }

    @Override
    public void delete(Category object) throws NamingException, SQLException {

        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;

        connection = database.getConnection();
        
        statement = connection.prepareStatement(QUERY_DELETE_CATEGORY);
        statement.setInt(1, object.getId());
        statement.executeUpdate();

        statement.close();
    }

    /**
     * Checks if the specified object is associated to another in the database
     * 
     * @param object
     * @return
     * @throws SQLException 
     */
    private boolean hasAssociation(Category object, Category subCategory) throws NamingException, SQLException {
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        // Check if the association already exists
        statement = connection.prepareStatement(QUERY_CHECK_ASSOC);
        statement.setInt(1, object.getId());
        statement.setInt(2, subCategory.getId());
        resultSet = statement.executeQuery();

        statement.close();
        
        // Returns true if there is a an association
        return resultSet.next();
    }
    
    private void addAssociations(Category object) throws NamingException, SQLException {
          
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        
        connection = database.getConnection();
        
        // For each subcatory of object
        for(Category subCategory : object.getCategories()){
            
            if(!hasAssociation(object, subCategory)){
                
                statement = connection.prepareStatement(QUERY_INSERT_ASSOC_CATEGORY_CATEGORY);
                statement.setInt(1, object.getId());
                statement.setInt(2, subCategory.getId());
                statement.executeUpdate();
            }
        }
    }
    
    /**
     * Removes unwanted categories associations
     * 
     * @param object
     * @throws SQLException 
     */
    private void removeAssociations(Category object) throws NamingException, SQLException {
        
        Database database = Database.getInstance();
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;

        connection = database.getConnection();
        
        statement = connection.prepareStatement(QUERY_SELECT_ALL_ASSOC_WHERE_ID);
        statement.setInt(1, object.getId());
        resultSet = statement.executeQuery();

        while (resultSet.next()) {

            boolean isValid = false;
            
            for (Category subCategory : object.getCategories()) {

                if (resultSet.getInt(2) == subCategory.getId()) {
                    isValid = true;
                }
            }
            if(!isValid){
                statement = connection.prepareStatement(QUERY_DELETE_ASSOC_CATEGORY_CATEGORY);
                statement.setInt(1, object.getId());
                statement.setInt(2, resultSet.getInt(2));
                statement.executeUpdate();
            }
        }
    }
}
