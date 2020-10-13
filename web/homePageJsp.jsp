
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="res.Values"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

    <head>

        <title>Bookshop - Bienvenue sur votre librairie en ligne !</title>
        <meta name="description" content="">   
        <link rel="stylesheet" type="text/css" href="css/templatecss.css"/>
        <link rel="stylesheet" type="text/css" href="bouton.css" />

    </head> 


    <jsp:include page="headerJsp.jsp" />


    <body>
        <br>
        <div class="evtConteneur">    
            <section id="evenement">
                <h2>L'événement du moment</h2>

                <a href="/event?event=2"><img src='img/evtRentree.png'  alt="canard" class="imgClic"/></a>
        </div>  
        <br></br>    <br></br>    <br></br>    <br></br>    <br></br>
        <div class="prezConteneur"> 

            <nav  class="prezConteneur">

                <jsp:include page="advancedSearch.html" />
            </nav>         


            <section id = "présentation" class="bookResult">
                <h2 class="titre">Présentation</h2>

                <p class="prezConteneur">"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>

            </section>


        </div>  

        <div class="livreConteneur">


            <!-- bean used to round up price -->
            <jsp:useBean id="bookBean" scope="application" class="model.bean.BookBean" />


            <section id = "livres tendance" class="livreConteneur">
                <h2 class="titre">Les nouveautés</h2>
                <table>
                    <tbody>
                        <tr>
                    <table class="bookResult">
                        <tr>
                            <c:forEach var="book" items="${books}">
                                <jsp:setProperty name="bookBean" property="book" value="${book}" />
                                <td style="width: 20%">
                                    <a href="book?isbn=${book.isbn}<img src ="${book.coverURL}" width="150" height="200"  alt= ""/></a>
                                    <div> 
                                        <figure> <a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" class="imgClic" /></a> 
                                            <h3><a href="book?isbn=${book.isbn}"> ${book.title} </a></h3>
                                            ${book.subTitle}<br/><h4>${book.authors.size() == 0 ? "Inconnu" : book.authors.get(0)}</h4>
                                            <p> Prix : ${bookBean.fullPriceText} Euros</p>
                                        </figure>
                                        <br></br><br></br>
                                    </div>
                                </td>
                            </c:forEach>
                        </tr>

                        <br></br>


                        </tr>  
                    </table>
                    </tbody>
                </table>
            </section>


            <section id = "livres tendance" class="livreConteneur">
                <h2 class="titre">Meilleures ventes</h2>
                <table>
                    <tbody>
                        <tr>
                    <table class="bookResult">
                        <tr>
                            <c:forEach var="book" items="${best_sales_books}" begin="0" end="4">
                                <jsp:setProperty name="bookBean" property="book" value="${book}" />
                                <td style="width: 20%">
                                    <a href="book?isbn=${book.isbn}<img src ="${book.coverURL}" width="150" height="200"  alt= "" /></a>
                                    <div> 
                                        <figure> <a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= "" class="imgClic"/></a> 
                                            <h3><a href="book?isbn=${book.isbn}"> ${book.title} </a></h3>
                                            ${book.subTitle}<br/><h4>${book.authors.size() == 0 ? "Inconnu" : book.authors.get(0)}</h4>
                                            <p> ${book.soldQuantity} exemplaires vendus</p>
                                            <p> Prix :  ${bookBean.fullPriceText}  Euros</p>
                                        </figure>
                                        <br></br><br></br>
                                    </div>
                                </td>
                            </c:forEach>
                        </tr>
                    </table>
                    <br></br>      
                    </tr>  
                    </tbody>
                </table>
            </section> 


            <section id = "livres tendance" class="livreConteneur">
                <h2 class="titre">Consultés récemment</h2>
                <table> 
                    <tbody>
                        <tr>
                    <table class="bookResult">
                        <tr>
                            <c:forEach var="book" items="${last_seen_books}">
                                <td style="width: 20%">
                                    <c:if test="${not empty book}">
                                        <jsp:setProperty name="bookBean" property="book" value="${book}" />
                                        <a href="book?isbn=${book.isbn}<img src ="${book.coverURL}" width="150" height="200"  alt= ""/></a>
                                        <div> 
                                            <figure> <a href="book?isbn=${book.isbn} "><img src ="${book.coverURL}" width="150" height="200"  alt= ""  class="imgClic"/></a> 
                                                <h3><a href="book?isbn=${book.isbn}"> ${book.title} </a></h3>
                                                ${book.subTitle}<br/><h4>${book.authors.size() == 0 ? "Inconnu" : book.authors.get(0)}</h4>
                                                <p> Prix :  ${bookBean.fullPriceText}  Euros</p>
                                            </figure>
                                            <br></br><br></br>
                                        </div>
                                    </c:if>
                                </td>
                            </c:forEach>
                        </tr>
                    </table>
                    <br></br>      
                    </tr>  
                    </tbody>
                </table>
            </section> 

        </div>

        <footer><jsp:include page="footerJsp.jsp" /></footer>

    </body>
</html>
