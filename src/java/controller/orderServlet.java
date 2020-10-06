/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.bean.beanOrder;
import model.entity.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Customer;
import res.Values;

/**
 *
 * @author Charlène
 */
@WebServlet(name = "orderServlet", urlPatterns = {"/orderServlet"})
public class orderServlet extends HttpServlet {

    String ci;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, NamingException {
        response.setContentType("text/html;charset=UTF-8");
// Code to show book that have been ordered
        
        if (request.getParameter("inputOrder") !=null){
            beanOrder beanO = new beanOrder(); 
            String i = request.getParameter("inputOrder");
            List<Book> books; 
            books = (List<Book>) beanO.getListById(i);
            
              if(books == null){
            request.setAttribute(Values.PARAM_ERROR_MSG, Values.ERROR_NO_ORDER);
            request.getRequestDispatcher("/error.jsp").include(request, response);
            
            }
            
           
           request.setAttribute("list", books );
       
           this.getServletContext().getRequestDispatcher("/jspOrderSearch.jsp").include(request, response);
            
        }



// Code Below works: 
        try {
           HttpSession session = request.getSession();

            if (session.getAttribute(Values.PARAM_CUSTOMER) == null){
                request.setAttribute(Values.PARAM_ERROR_MSG, Values.ERROR_NOT_LOGIN);
                request.getRequestDispatcher(Values.JSP_NOTLOG).include(request, response);
                return;     
            }else{
        
                
            
            Customer custid = (Customer) session.getAttribute(Values.PARAM_CUSTOMER);
            beanOrder beanPast = new beanOrder();

            List<Book> book = beanPast.allOrder(custid.getCustomerId());
            
            if(book == null){
            request.setAttribute(Values.ERROR_NO_ORDER, Values.ERROR_NO_ORDER);
            this.getServletContext().getRequestDispatcher("/jspOrder.jsp").include(request, response);
            
            }
            List<Book> Abook = (List<Book>) beanPast.pastOrder(custid.getCustomerId());
            List<Book> Bbook = (List<Book>) beanPast.orderSixMonth(custid.getCustomerId());
            List<Book> Cbook = (List<Book>) beanPast.orderLastMonth(custid.getCustomerId());
            
            if (Cbook != null){
            request.setAttribute(Values.ORDER_LASTMONTH, Cbook);
            }
            
            if(Bbook != null){
            request.setAttribute(Values.ORDER_SIXMONTH, Bbook);
            }
            
            if(Abook != null){
            request.setAttribute(Values.ORDER_PAST, Abook);
            }
            
            //request.setAttribute("books", book);
            this.getServletContext().getRequestDispatcher("/jspOrder.jsp").include(request, response);
            }     //request.getRequestDispatcher("/jspOrder.jsp").include(request, response);
        } catch (SQLException | NamingException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
                
            
    }

        
        
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(orderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Servlet Order";
    }

}
