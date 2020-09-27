package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.BookDAO;
import model.entity.Book;
import res.Values;

/**
 *
 * @author zvr
 */
@WebServlet(urlPatterns = {"/bookshop"})
public class ServletController extends HttpServlet {

    public final String HEAD = "/WEB-INF/fragment/head.jsp";
    public final String TAIL = "/WEB-INF/fragment/tail.jsp";

    public final String CART = "/WEB-INF/fragment/shoppingcart.jsp";
    public final String BOOK = "/WEB-INF/fragment/book.jsp";
    public final String RESULTS = "/WEB-INF/fragment/results.jsp";
    public final String LOGIN = "/WEB-INF/fragment/login.jsp";
    public final String REGISTER = "/WEB-INF/fragment/register.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // This is the "head" structure of any webpage, including menu
        request.getRequestDispatcher(HEAD).include(request, response);

        BookDAO bookDAO = new BookDAO();

        try {
            for (Book book : bookDAO.getAll()) {
                System.out.println(book);
            }
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // If there is no action 
        if (request.getParameter(Values.PARAM_ACTION) == null) {
            //request.getRequestDispatcher(HEAD).include(request, response);
        } else {
            // Creates a webpage according to the action and other params
            switch (request.getParameter(Values.PARAM_ACTION)) {

                case "login":
                    request.getRequestDispatcher(LOGIN).include(request, response);
                    break;
                case "catalog":
                    request.getRequestDispatcher(BOOK).include(request, response);
                    break;
                default:

                    break;
            }
        }

        // The closing body tag
        request.getRequestDispatcher(TAIL).include(request, response);
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

}
