<%-- 
    Document   : myAccount
    Created on : 30 sept. 2020, 12:19:09
    Author     : Loïc
--%>


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

        
        <jsp:useBean id="bean_login" scope="session" class="model.bean.LoginBean" />
    <c:if test="${!bean_login.isLogged}" var="isLogged" scope="session">
        <jsp:forward page="WEB-INF/login.jsp" />
        
        </c:if>
        
    <div id="font"> 


        <section>
            
                    
                <span id="llbienvenue">Bienvenue ${customer.customerFName} ${customer.customerLName}</span>
                
            <h2> <%--    --%>    
                  <form action="allOrder" method="post">
                <a href="/allOrder">Mes Commandes</a> 
                </form>
          </h2>
            <ul>
                <li><a href="">Commandes en cours</a></li>
                <li><a href="">Commandes archivées</a></li>
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