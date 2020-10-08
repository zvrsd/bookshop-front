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
    </head>

    <header><jsp:include page="headerJsp.jsp" /></header>


    <body>

        <div class="evtConteneur">    
            <section id="evenement">
                <h2>L'événement du moment</h2>

                <a href="/event?event=2"><img src='img/evtRentree.png'  alt="canard"/></a>
        </div>  
        <br></br>    <br></br>    <br></br>    <br></br>    <br></br>
        <div class="prezConteneur"> 

            <nav id="bor" class="prezConteneur">
                <jsp:include page="advancedSearch.html" />
            </nav>         


            <section id = présentation>
                <h2 class="titre">Présentation</h2>
                
                <p class="prezConteneur">"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
               
            </section>



        </div>  

        <div class="livreConteneur">
            <section id = "livres tendance" class="livreConteneur">
                <h2 class="titre">En tendance en ce moment</h2>
                 <table> 
        <tbody> 
            <tr>
                <td>
                    <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td>
                    <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td>
                    <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td> 
               <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td> 
               <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <br> </br>
                
       
            </tr>  
        </tbody>
    </table>
            </section>

            <section id = "livres tendance" class="livreConteneur">

                <h2 class="titre">Les nouveautés</h2>
                <table> 
        <tbody>
            <tr>
                <c:forEach var="book" items="${books}">
                    <td>
                        <a href="book?isbn=${book.isbn}<img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                        <div class="col-sm-2"> 
                            <figure>  <p><a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                                <h3>  ${book.title}  </h3>
                                <p>   ${book.postIt} </p>     

                                <p> Prix :  ${book.price}  Euros</p>
                                <br></br><br></br>
                        </div>
                    </td>
                </c:forEach>
                <br></br>      
            </tr>  
        </tbody>
    </table>
                
                
     
            </section>
            
            <section id = "livres tendance" class="livreConteneur">
                <h2 class="titre">Les plus commentés</h2>
                 <table> 
        <tbody> 
            <tr>
                <td>
                    <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td>
                    <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td>
                    <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td> 
               <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <td> 
               <figure>  <p><a href="book.html" title=""><img src ="img/furieBook.jpg" width="150" height="200"  alt= "" /></a>
                </td>
                <br> </br>
                    
            </tr>  
        </tbody>
    </table>
            </section>   
        </div>

        <footer><jsp:include page="footerJsp.jsp" /></footer>
    </body>
</html>
