<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : homePage.jsp
    Created on : 1 oct. 2020, 11:28:20
    Author     : Loïc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Bookshop - Bienvenue sur votre librairie en ligne !</title>
        <meta name="description" content="">
        <link rel="stylesheet" href="css/templatecss.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>

    <header><jsp:include page="headerJsp.jsp" /></header>
    

    <body>
            
        <section id="evenement">
             <h2>L'événement du moment</h2>
          
         <a href="/event?event=2"><img src='img/evtRentree.png'  alt="canard"/></a>
         
        
        <section id = présentation>
            <h2>Présentation</h2>
            <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
            <p>"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"</p>
        </section>
            
            <section id = "livres tendance">
                <h2>Les nouveautes: </h2>

            </section>
             
           <div class="container"> 
            <div class="row">  
               
                <c:forEach var="book" items="${books}">

                    <a href="book?isbn=${book.isbn}<img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                    <div class="col-sm-2"> 
                        <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                            <h3>  ${book.title}  </h3>
                            <p>   ${book.postIt} </p>     
                            
                            <p> Prix :  ${book.price}  Euros</p>
                            <br></br><br></br>
                            
                </div>
            </c:forEach>
        </div> 
    </div>          
             
     <br></br><br></br><br></br>      
        <footer><jsp:include page="footerJsp.jsp" /></footer>

</body>



</html>
