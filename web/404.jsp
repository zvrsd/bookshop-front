<%-- 
    Document   : 404
    Created on : 2 oct. 2020, 00:27:09
    Author     : Loïc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookshop - page inconnue</title>
        <meta name="description" content="">
        <link rel="stylesheet" href="css/templatecss.css">
    </head>
    
    
    <body>
        <header>
            <jsp:include page="headerJsp.jsp" />
        </header>
        
        <section>
            <h1>Erreur 404</h1>
            
        <p>La page demandée n'existe pas !<br />
            Vous pouvez poursuivre la navigation sur le site en cliquant sur l'un des liens suivants...</p>
        <ul>
            <li><a onclick="goBack()">Précédent</a></li>
            <script>
                function goBack() {
                window.history.back();
                }
            </script>
            
            <li><a href="homePageJsp.jsp">Page d'accueil</a></li>
            
        </ul>
        </section>
        
        <footer>
            <jsp:include page="footerJsp.jsp" />
        </footer>
        
    </body>
</html>
