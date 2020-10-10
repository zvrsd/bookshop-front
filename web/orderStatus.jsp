<%-- 
    Document   : orderStatus
    Created on : 9 oct. 2020, 11:46:44
    Author     : cda611
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.entity.Order"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statut order</title>
        <link rel="stylesheet" href="css/templatecss.css">
        <link rel="stylesheet" href="bouton.css">
    </head>
    <body>
          <%@include file="/headerJsp.jsp" %>   
   
        <h1>Vos commandes en cours</h1>
      
        
        <table>
            <thead>
            <td> Id</td><td> Date de commande</td><td> Date de livraison</td><td> Commentaire</td><td> Statut order</td>
            </thead>
            <tbody>
                <tr>
                    <td> ${orderId}</td>  <td> ${date}</td>  <td> ${timeLimite}</td><td> ${comment}</td><td> ${statut}</td>
                </tr>
                
            </tbody>
        </table>
                <br></br>   <br></br>   
                 <button class="bttn-unite" type="button"><a href="myAccount.jsp">Retour</a></button>
 
     <%@include file="/footerJsp.jsp" %>  
    </body>
</html>
