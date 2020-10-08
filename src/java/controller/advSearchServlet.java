/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.beanSearch;
import model.entity.Book;

/**
 *
 * @author Charlène
 */
@WebServlet(name = "advSearchServlet", urlPatterns = {"/advSearchServlet"})
public class advSearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
            Set books = new HashSet(); 
            beanSearch beanSearch = new beanSearch(); 
            //List<Book> books = new ArrayList(); 
            Set<Set<Book>> recueil = new HashSet(); 
            recueil.add( beanSearch.getByTitle((String) request.getParameter("title"))); 
            recueil.add(beanSearch.getByCategory((String) request.getParameter("category")));
            recueil.add(beanSearch.getByISBN((String) request.getParameter("isbn")));
            recueil.add(beanSearch.getByKeywords((String) request.getParameter("keywords")));
            
           /* if(request.getParameter("priceMin") != null) {
                  if (request.getParameter("priceMax") != null){
            Double min = Double.parseDouble(request.getParameter("priceMin")); 
            Double max = Double.parseDouble(request.getParameter("priceMax"));
             recueil.add( beanSearch.getByPrice(min , max));
            }*/
            
            recueil.stream().forEach((book) -> {
                book.stream().forEach((boo) -> {
                    books.add(boo);
            });
        });
            
             request.setAttribute("books", books);
             request.getRequestDispatcher("/advancedSearch.jsp").include(request, response);
           
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(advSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(advSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(advSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NamingException ex) {
            Logger.getLogger(advSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(advSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(advSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
