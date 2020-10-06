<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <jsp:useBean id="bean_login" scope="session" class="model.bean.LoginBean" />
    <c:if test="${!bean_login.isLogged}" var="isLogged" scope="session">
        <jsp:forward page="WEB-INF/login.jsp" />
        
        </c:if>
    
    
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Bookshop - Mon compte</title>
        <meta name="description" content="">
        <link rel="stylesheet" href="css/templatecss.css">
    </head>
    
    
    <body>
        
        
       
        <header><jsp:include page="headerJsp.jsp" /></header>
       
             
        
            
        <section>
            <h2>Paramètres de sécurité et de connexion</h2>
            
            <span>
                Mes informations personnelles
            </span>
            
            <table>
                
                <tr>
                    <td>Nom</td>
                    <td>${customer.customerLName}</td>
                </tr>
                <tr>
                    <td>Prénom</td>
                    <td>${customer.customerFName}</td>
                </tr>
                <tr>
                    <td>Pseudonyme</td>
                    <td>${customer.customerUsername}</td>
                </tr>
                <tr>
                    <td>Adresse e-mail</td>
                    <td>${customer.customerEmail}</td>
                </tr>
                
                
            </table> 
               
            
            
            <section>
                
                <button type="button"><a href="idModif.jsp">Modifier</a></button>
                <br>
            <a href="myAccount.jsp">Précédent</a>
            </section>
        </section>
           
             
             
          
             
             
             
        <footer><jsp:include page="footerJsp.jsp" /></footer>
        
   <!-- Site web créé par la fine équipe -->
    </body>
        
</html>
