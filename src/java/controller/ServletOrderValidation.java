package controller;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.ShoppingCartBean;
import model.dao.BookDAO;
import model.entity.Book;
import res.Values;

/**
 *
 * @author zvr
 */
@WebServlet(urlPatterns = {"/ordervalidation"})
public class ServletOrderValidation extends HttpServlet {

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
        
        BookDAO bookDAO = new BookDAO();
        String isbn = "";
        String errorMessage = "";
        String message = "";
                
        HttpSession session = request.getSession();
        Collection<Book> books;
        
        // This bean contains the shopping carts ( books )
        ShoppingCartBean shoppingcartBean = (ShoppingCartBean) session.getAttribute(Values.BEAN_SHOPPING_CART_NAME);
        if (shoppingcartBean == null) {
            errorMessage = "Aucun livre disponible";
        }
        else{
            books = shoppingcartBean.getBooks();
        }
        
        request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
        request.setAttribute(Values.PARAM_MSG, message);
        
        request.getRequestDispatcher(Values.JSP_ORDER_VALIDATION).include(request, response);
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