
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.BookDAO;
import model.entity.Book;

/**
 *
 * @author Cy
 */


/* 
    Servlet qui remplace et appele la page d'accueil!
    
    Ajoutez ici toutes les methodes necessaires pour modifier la HomePage!

*/


@WebServlet(name = "HomePage", urlPatterns = {"/HomePage"})
public class ServletHomePage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = "homePageJsp.jsp";
            
            // Gets the last 5 books from DB
            ArrayList<Book> allBooks = (ArrayList<Book>) new BookDAO().getAll();
            List<Book> lastBooks = new ArrayList<Book>();
            for(int i = allBooks.size() - 1; i > allBooks.size() - 6; i--){
                lastBooks.add(allBooks.get(i));
            }
            // Displays books
            for(Book book : lastBooks){
                System.out.println(book);
                
            }
            request.setAttribute("books", lastBooks);
         
                
                request.getRequestDispatcher("homePageJsp.jsp").include(request, response);   
            
        } catch (NamingException ex) {
            Logger.getLogger(ServletHomePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServletHomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
