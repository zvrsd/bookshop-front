/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.dao.adresseDao;
import model.entity.Address;
import test.testing;

/**
 *
 * @author jabar
 */
@WebServlet(name = "adresse", urlPatterns = {"/adresse"})
public class adresse extends HttpServlet {

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
            throws ServletException, IOException, SQLException, NamingException {

            try{
             adresseDao.insertAddress(request.getParameter("societe"), request.getParameter("nom"), request.getParameter("prenom"), request.getParameter("rue"), request.getParameter("rue1"), request.getParameter("codepostal"), request.getParameter("ville"), request.getParameter("portable"),"active");   
             
             String lastId = ""+adresseDao.LastId();
             adresseDao.insertAddressDelivry("10",lastId);
             adresseDao.insertAddressBilling("10",lastId);
                    } catch (SQLException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NamingException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
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
      this.getServletContext().getRequestDispatcher("/WEB-INF/ajoutadresse.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(adresse.class.getName()).log(Level.SEVERE, null, ex);
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
