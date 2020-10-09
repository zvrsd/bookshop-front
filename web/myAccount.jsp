<%-- 
    Document   : myAccount
    Created on : 30 sept. 2020, 12:19:09
    Author     : Loïc
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
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



        <div id="font"> 


            <section>


                <div id="llbienvenue">Bienvenue ${customer.customerFName} ${customer.customerLName}</div>

                <h2> <%--    --%>    
                  
                        Mes Commandes
                </h2>
                <ul>
                    <li><a href="/allOrder">Toutes mes commandes</a></li>
                    <li><a href="/orderStatusActive">Commandes en cours</a></li>
                </ul>
            </section>


            <section>
                <h2>Mes paramètres</h2>
                <ul>
                    <li><a href="id.jsp">Paramètres de sécurité et de connexion</a></li>
                    <li><a href="">Mes adresses de facturation</a></li>
                    <li><a href="">Mes adresses de livraison</a></li>
                </ul>
            </section>

            <br><br>
            <p><a href="login?action=logout">Déconnexion</a></p>




        </div>

        <footer><jsp:include page="footerJsp.jsp" /></footer>

    </body>



</html>
