
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
    Document   : advancedSearch
    Created on : 3 oct. 2020, 23:50:00
    Author     : Charlène
--%>




<%@page import="model.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> --%>
        <title>JSP Event</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templatecss.css">


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <hr>

    <%@include file="/headerJsp.jsp" %>   




    <br> </br><br></br>
    <div class="jumbotron text-center">
        <h1> Résultats recherche </h1>

    </div>
    <div>
       

        <div class="container"> 
            <div class="row">  
               
                <c:forEach var="book" items="${books}">

                    <a href="book?isbn=${book.isbn}<img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                    <div class="col-sm-4"> 
                        <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                            <h3>  ${book.title}  </h3>
                            <p>   ${book.postIt} </p>     
                            
                            <p> Prix :  ${book.priceT}  Euros</p>
                            <br></br><br></br>
                   
                </div>
            </c:forEach>
        </div> 
    </div>
    <br></br><br></br><br></br>
    <%@include file="/footerJsp.jsp" %>      
</body>
</html>
