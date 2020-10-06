/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.naming.NamingException;
import model.dao.BookDAO;
import model.entity.Book;

/**
 *
 * @author cda611
 */
public class beanSearch implements Serializable {
    
   List<Book> books;
    
    public beanSearch() {
      books = new ArrayList(); 
    }
     
    public List<Book> getAll() throws NamingException, SQLException{
        books = new BookDAO().getAll(); 
        
        return books; 
    }
    
    public List<Book> getByCategory(String category) throws NamingException, SQLException{
        books = new BookDAO().categorySearch(category); 
        
        return books; 
    }
    
    public List<Book> getByTitle(String title) throws NamingException, SQLException{
        books = new BookDAO().quickSearch(title); 
        
        return books; 
    }
    
    public List<Book> getByISBN(String isbn) throws NamingException, SQLException{
        books = new BookDAO().quickSearch(isbn); 
        
        return books; 
    }
    
    public List<Book> getByKeywords(String keyword) throws NamingException, SQLException{
        books = new BookDAO().quickSearch(keyword); 
        
        return books; 
    }
    
    public List<Book> getByPrice(Double priceS, Double priceE) throws NamingException, SQLException{
        books = new BookDAO().priceSearch(priceS, priceE); 
        
        return books; 
    }
    
    public List<Book> getByPriceMin(Double priceS) throws NamingException, SQLException{
        books = new BookDAO().priceSearchMin(priceS); 
        
        return books; 
    }
    
    public List<Book> getByPriceMax(Double priceS) throws NamingException, SQLException{
        books = new BookDAO().priceSearchMax(priceS); 
        
        return books; 
    }

   
}
