/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.entity.Address;
import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author jabar
 */
public class adresseDao {
      public static final String viewAddressDelivryByIdCustomer="select * from ADDRESS inner join\n" +
        "ASSOC_CUSTOMER_DELIVERY_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID\n" +
        "where ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=? and ADDRESS_PHONE_EXTRA='active'";
      public static List<Address> listAddressDelivryByIdCustomer(int a) throws SQLException, NamingException {
       List<Address> result = new ArrayList<Address>(); 
          Database database = Database.getInstance();
          Connection connection;
            connection = database.getConnection();
            PreparedStatement statement=connection.prepareStatement(viewAddressDelivryByIdCustomer);
            statement.setInt(1, a);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
              Address address=new Address(
                rs.getInt("ADDRESS_ID"),      
                rs.getString("ADDRESS_COMPANY_NAME"),
                rs.getString("ADDRESS_L_NAME"),
                rs.getString("ADDRESS_F_NAME"),
                rs.getString("ADDRESS_STREET"),
                rs.getString("ADDRESS_STREET_EXTRA"),
                rs.getString("ADDRESS_POSTCODE"),
                rs.getString("ADDRESS_CITY"),
                rs.getString("ADDRESS_PHONE"),
                rs.getString("ADDRESS_PHONE_EXTRA"));
              result.add(address);
            }          
return result;
}
      public static final String viewAddressBillingByIdCustomer="select * from ADDRESS inner join\n" +
        "ASSOC_CUSTOMER_BILLING_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_BILLING_ADDRESS.ADDRESS_ID\n" +
        "where ASSOC_CUSTOMER_BILLING_ADDRESS.CUSTOMER_ID=? and ADDRESS_PHONE_EXTRA='active'";
      public static List<Address> listAddressBillingByIdCustomer(int a) throws SQLException, NamingException {
       List<Address> result = new ArrayList<Address>(); 
          Database database = Database.getInstance();
          Connection connection;
            connection = database.getConnection();
            PreparedStatement statement=connection.prepareStatement(viewAddressBillingByIdCustomer);
            statement.setInt(1, a);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
              Address address=new Address(
                rs.getInt("ADDRESS_ID"),      
                rs.getString("ADDRESS_COMPANY_NAME"),
                rs.getString("ADDRESS_L_NAME"),
                rs.getString("ADDRESS_F_NAME"),
                rs.getString("ADDRESS_STREET"),
                rs.getString("ADDRESS_STREET_EXTRA"),
                rs.getString("ADDRESS_POSTCODE"),
                rs.getString("ADDRESS_CITY"),
                rs.getString("ADDRESS_PHONE"),
                rs.getString("ADDRESS_PHONE_EXTRA"));
              result.add(address);
            }          
return result;
}
      public static final String viewAddressByIdCustomer="select address.* from ASSOC_CUSTOMER_BILLING_ADDRESS right join\n" +
      "ADDRESS on ASSOC_CUSTOMER_BILLING_ADDRESS.ADDRESS_ID=ADDRESS.ADDRESS_ID left join\n" +
      "ASSOC_CUSTOMER_DELIVERY_ADDRESS on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID\n"+        
      "where ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=5 or ASSOC_CUSTOMER_BILLING_ADDRESS.CUSTOMER_ID=5 and ADDRESS_PHONE_EXTRA='active'";
      public static List<Address> listAddressByIdCustomer(int a) throws SQLException, NamingException {
       List<Address> result = new ArrayList<Address>(); 
          Database database = Database.getInstance();
          Connection connection;
            connection = database.getConnection();
            PreparedStatement statement=connection.prepareStatement(viewAddressByIdCustomer);
            statement.setInt(1, a);
            ResultSet rs=statement.executeQuery();
            while (rs.next()){
              Address address=new Address(
                rs.getInt("ADDRESS_ID"),      
                rs.getString("ADDRESS_COMPANY_NAME"),
                rs.getString("ADDRESS_L_NAME"),
                rs.getString("ADDRESS_F_NAME"),
                rs.getString("ADDRESS_STREET"),
                rs.getString("ADDRESS_STREET_EXTRA"),
                rs.getString("ADDRESS_POSTCODE"),
                rs.getString("ADDRESS_CITY"),
                rs.getString("ADDRESS_PHONE"),
                rs.getString("ADDRESS_PHONE_EXTRA"));
              result.add(address);
            }          
return result;
}      
     public static final String insertion="insert into ADDRESS (ADDRESS_COMPANY_NAME,ADDRESS_L_NAME,ADDRESS_F_NAME,ADDRESS_STREET,ADDRESS_STREET_EXTRA,ADDRESS_POSTCODE,ADDRESS_CITY,ADDRESS_PHONE,ADDRESS_PHONE_EXTRA)\n" +
         "values(?,?,?,?,?,?,?,?,?)";
     public static void insertAddress(String a,String b,String c,String d,String e,String f,String g,String h,String i)throws SQLException, NamingException{
      Database database = Database.getInstance();
      Connection connection = database.getConnection();
            PreparedStatement pstmt = connection.prepareStatement( insertion);
            
            pstmt.setString(1,a);
            pstmt.setString(2,b);
            pstmt.setString(3,c);
            pstmt.setString(4,d);
            pstmt.setString(5,e);
            pstmt.setString(6,f);
            pstmt.setString(7,g);
            pstmt.setString(8,h);
            pstmt.setString(9,i);
            pstmt.executeUpdate();
              
 } 
     public static final String insertionAssocDelivry="insert into ASSOC_CUSTOMER_DELIVERY_ADDRESS\n" +
         "values(?,?)";
     public static void insertAddressDelivry(String idCustomer,String idAddress)throws SQLException, NamingException{
      Database database = Database.getInstance();
      Connection connection = database.getConnection();
            PreparedStatement pstmt = connection.prepareStatement( insertionAssocDelivry);
            
            pstmt.setString(1,idCustomer);
            pstmt.setString(2,idAddress);
            pstmt.executeUpdate();
              
 }
     public static final String insertionAssocBilling="insert into ASSOC_CUSTOMER_BILLING_ADDRESS\n" +
         "values(?,?)";
     public static void insertAddressBilling(String idCustomer,String idAddress)throws SQLException, NamingException{
      Database database = Database.getInstance();
      Connection connection = database.getConnection();
            PreparedStatement pstmt = connection.prepareStatement( insertionAssocBilling);
            
            pstmt.setString(1,idCustomer);
            pstmt.setString(2,idAddress);
            pstmt.executeUpdate();
              
 }     
      public static  int LastId() throws SQLException, NamingException {
       int result=-1; 
      String viewLastID="select @@IDENTITY";
          Database database = Database.getInstance();
          Connection connection;
            connection = database.getConnection();
            PreparedStatement statement=connection.prepareStatement(viewLastID);
            ResultSet rs=statement.executeQuery();
            while (rs.next())
             result=rs.getInt(1);
                      
return result;
}
      public static final String desactivationDelivryAddress="update ADDRESS set ADDRESS_PHONE_EXTRA='inactive' from ADDRESS\n" +
    "inner join ASSOC_CUSTOMER_DELIVERY_ADDRESS \n" +
    "on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_DELIVERY_ADDRESS.ADDRESS_ID\n" +
    "where ASSOC_CUSTOMER_DELIVERY_ADDRESS.CUSTOMER_ID=?;";   
public static void desactivateDelivryAddressByIdCustomer(int customerId) throws SQLException, NamingException{
          Database database = Database.getInstance();
          Connection connection = database.getConnection();
            PreparedStatement pstmt = connection.prepareStatement( desactivationDelivryAddress);
            pstmt.setInt(1,customerId);
            pstmt.executeUpdate();
}
      public static final String desactivationBillingAddress="update ADDRESS set ADDRESS_PHONE_EXTRA='inactive' from ADDRESS\n" +
        "inner join ASSOC_CUSTOMER_BILLING_ADDRESS \n" +
        "on ADDRESS.ADDRESS_ID=ASSOC_CUSTOMER_BILLING_ADDRESS.ADDRESS_ID\n" +
        "where ASSOC_CUSTOMER_BILLING_ADDRESS.CUSTOMER_ID=?;";   
      public static void desactivateBillingAddressByIdCustomer(int customerId) throws SQLException, NamingException{
          Database database = Database.getInstance();
          Connection connection = database.getConnection();
            PreparedStatement pstmt = connection.prepareStatement( desactivationBillingAddress);
            pstmt.setInt(1,customerId);
            pstmt.executeUpdate();
}
}
