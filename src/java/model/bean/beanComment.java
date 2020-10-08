/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.beans.*;
import java.io.Serializable;
import java.sql.SQLException;
import model.dao.CommentDAO;

/**
 *
 * @author cda611
 */
public class beanComment implements Serializable {
    
    private boolean authComment; 
 
    public beanComment() {
       
    }
    
   public boolean autComment(String customerId) throws SQLException{
    //autorise le client à faire un commentaire 
    CommentDAO comment = new CommentDAO(); 
        authComment = comment.autorise(customerId);
   
   return authComment;  }

    public boolean isAuthComment() {
        return authComment;
    }

    public void setAuthComment(boolean authComment) {
        this.authComment = authComment;
    }
   
   
    
}
