<%-- 
    Document   : jspOrderSearch
    Created on : 4 oct. 2020, 16:58:33
    Author     : Charlène
--%>
<%@page import="java.util.List"%>
<%@page import="model.entity.Book"%>
<%@page import="res.Values"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Order</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templatecss.css">
        <meta charset="UTF-8">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
        <title>Recherche commande </title>
    </head>
    <body>

        <%@include file="headerJsp.jsp" %>  

        <h1>Résultats de votre recherche !</h1>

     
        <div class="container"> 
            <div class="row">  


                <br></br><br></br><br></br><br></br><br></br><br></br>


                <c:forEach var="book" items="${list}">

                    <div class="col-sm-4"> 
                        <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                            <h3>  ${book.title}  </h3>

                            <p>   ${book.postIt} </p>
                            <p>  ${book.price}  Euros</p>

                            <br></br><br></br>

                        </c:forEach> 

                </div> 
            </div>
        </div>
        <%@include file="footerJsp.jsp" %>  
    </body>
</html>
