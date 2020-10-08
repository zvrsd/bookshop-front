package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.bean.LoginBean;
import model.bean.OrderValidationBean;
import model.bean.ShoppingCartBean;
import model.dao.OrderDAO;
import model.entity.Book;
import model.entity.Customer;
import model.entity.Order;
import model.entity.Order_Row;
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
        
        String errorMessage = "";
        String message = "";
                
        HttpSession session = request.getSession();
        
        LoginBean loginBean = (LoginBean) session.getAttribute(Values.BEAN_LOGIN_NAME);
        ShoppingCartBean shoppingcartBean = (ShoppingCartBean) session.getAttribute(Values.BEAN_SHOPPING_CART_NAME);
        
        // If the user chooses to go back to cart
        if(Values.ACTION_GOTO_CART.equals(request.getParameter(Values.PARAM_ACTION))){
            response.sendRedirect("shoppingcart");
        }
        // If the cart is empty
        else if (shoppingcartBean == null || shoppingcartBean.isEmpty()) {
            errorMessage = "Aucun livre disponible";
            response.sendRedirect("shoppingcart");
            return;
        }
        // If the user is not logged in
        else if(loginBean == null || !loginBean.getIsLogged()){
            request.setAttribute(Values.PARAM_MSG, "Connectez-vous pour commander");
            session.setAttribute(Values.PARAM_ORIGIN, "ordervalidation");
            request.getRequestDispatcher("login").include(request, response);
            return;
        }
 
        OrderValidationBean orderValidationBean = (OrderValidationBean) session.getAttribute(Values.BEAN_ORDER_VALIDATION_NAME);
        if(orderValidationBean == null){
            orderValidationBean = new OrderValidationBean();
            session.setAttribute(Values.BEAN_ORDER_VALIDATION_NAME, orderValidationBean);
            orderValidationBean.setBooks(shoppingcartBean.getBooks());
            orderValidationBean.setValidated(false);
        }
        
        // If the user chooses to validate the order
        if(Values.ACTION_CREATE_ORDER.equals(request.getParameter(Values.PARAM_ACTION))){
            System.out.println((Customer) session.getAttribute(Values.PARAM_CUSTOMER));
            System.out.println("del : "+request.getParameter("delivery_address"));
            System.out.println("bil : "+request.getParameter("billing_address"));
            System.out.println();
            /*
            orderValidationBean.setCustomer((Customer) session.getAttribute(Values.PARAM_CUSTOMER));
            orderValidationBean.setBillingAddress(request.getAttribute(message));
            
            //validateOrder(orderValidationBean, shoppingcartBean);*/
        }
        // If the order has been validated already
        if(orderValidationBean.isValidated()){
            message = "commande deja validée";
        }
        
        request.setAttribute(Values.PARAM_ERROR_MSG, errorMessage);
        request.setAttribute(Values.PARAM_MSG, message);
        
        request.getRequestDispatcher(Values.JSP_ORDER_VALIDATION_FULL).include(request, response);
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

    private boolean validateOrder(OrderValidationBean orderBean, ShoppingCartBean cartBean) throws Exception{
        
        // Creates the order
        Order order = new Order();
        order.setCustomer(orderBean.getCustomer());
        order.setAdresseBilId(orderBean.getBillingAddress().getId());
        order.setAdresseLivId(orderBean.getDeliveryAddress().getId());
        order.setIpCustomer("0.0.0.0");
        order.setCommentaire("");
        // UNSAFE CAST !!
        order.setShippingId(Integer.parseInt(""+orderBean.getShippingOffer().getShippingOfferId()));
        order.setPriceTaxFree(orderBean.getShippingOffer().getShippingOfferHtPrice());
        
        // Adds the order into the DB
        new OrderDAO().add(order);
        
        Order_Row orderRow;
        // Creates an order row for each book
        for(Book book : orderBean.getBooks()){
            orderRow = new Order_Row();
            orderRow.setBookIsbn(book.getIsbn());
            orderRow.setOrderQuantity(book.getQuantity());
            // unsafe cast
            orderRow.setOrderRowPrice(Double.parseDouble(""+book.getTPrice()));
        }
        
        return false;
    }
}