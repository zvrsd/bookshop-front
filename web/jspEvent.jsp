
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : jspEvent
    Created on : 29 sept. 2020, 15:47:40
    Author     : cda611
--%>


<%@page import="model.entity.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;>
        <title>JSP Event</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="templatecss.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <hr>


    <%@include file="headerJsp.jsp" %>   


    <p>
  <canvas id="canvas" width="1300" height="200"></canvas>
        <script src="evtImg.js"></script>       
    </p>


    <br> </br><br></br>
    <div class="jumbotron text-center">
        <h1>Les livres sélectionnés pour l'évenement </h1>

    </div>
    <div>
        <!-- Le container -->



        <div class="container"> 
            <div class="row">  
                
              <c:forEach var="book" items="${book}">

                    <a href="book?isbn=${book.isbn}<img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                    <div class="col-sm-4"> 
                        <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                            <h3>  ${book.title}  </h3>
                            <p>   ${book.postIt} </p>
                            <c:set  var="remise" value="${remise}"/>
                            
                   <!--   <fmt:formatNumber var="discount" minIntegerDigits="2" value="${remise * (book.priceT /100)}"/> -->
                            
                            <p> Ancien prix : ${book.priceT} Euros</p><p> Nouveau prix : <c:set var="discount"value="${remise * (book.priceT /100)}" />  ${discount} Euros</p>
                                                                                    
                            <br></br><br></br><%----%>
                   
                </div>
            </c:forEach>
        </div> 
    </div>


    <br></br><br></br><br></br>
    <%@include file="footerJsp.jsp" %>      
</body>
</html>

