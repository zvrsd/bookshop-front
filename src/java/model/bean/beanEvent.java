/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import model.entity.Book;
import model.entity.Event;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import controller.eventServlet;

/**
 *
 * @author cda611
 */
public class beanEvent implements Serializable {
    
    List<Book> eventList = null;
    
    public beanEvent() {
        this.eventList = new ArrayList();
      
    }
    
    
    
    public List<Book> returnlBook() throws SQLException, NamingException {
    eventList = new eventServlet().getList();
    
    
        return eventList;
    }
    
    public double getRemise(){
       //doit retourner ou une remise ou le prix du livre à déterminer. 
        
        return 0.0;
    }
    
    public Event getEvent(){
        
        return new Event();
    }
}
