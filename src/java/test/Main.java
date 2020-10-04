package test;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import model.dao.CustomerDAO;
import model.entity.Customer;

/**
 *
 * @author zvr
 */
public class Main {
    
    public static void main(String [] a){
        
        testMap();
    }
    
    private static void testMap(){

       HashMap<String, String> hashmap = new HashMap<String, String>();
       
       hashmap.put("aaa", "apple" );
       hashmap.put("pab", "lemon" );
       hashmap.put("aac", "orange" );
       hashmap.put("aad", "banana" );
       hashmap.put("zae", "litchi" );
       hashmap.put("aazeaze48848aa", "mango" );
       hashmap.put("qsaa", "papaya" );

       System.out.println(hashmap.size());

       for (String key : hashmap.values()) {
           System.out.println(key);
       }
   }

}