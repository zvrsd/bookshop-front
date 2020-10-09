<%-- 
    Document   : jspOrderSearch
    Created on : 4 oct. 2020, 16:58:33
    Author     : Charlène
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="model.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <link rel="stylesheet" href="templatecss.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche commande </title>
    </head>
    <body>
           <%@include file="headerJsp.jsp" %>   
        <h1>Résultats de votre recherche !</h1>
        
        <div class="container"> 
            <div class="row">  



                <c:forEach var="book" items="${books}">

                    <div class="col-sm-4"> 
                        <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                            <h3>  ${book.title}  </h3>

                            <p>   ${book.postIt} </p>
                            <p>  ${book.price}  Euros</p>

                            <br></br><br></br>
                    </div> 
                </div>
                             </c:forEach>
            
             <%@include file="footerJsp.jsp" %>   
    </body>
</html>
