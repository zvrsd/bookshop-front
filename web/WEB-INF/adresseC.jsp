<%-- 
    Document   : adresseC
    Created on : 5 oct. 2020, 19:56:37
    Author     : jabar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/css/adresse.css">  
        <link rel="stylesheet" href="/css/templatecss.css">
    </head>

    <header><jsp:include page="/headerJsp.jsp" /></header>

    <body>

        <div id="font">

            <h2>Adresses de livraison</h2>
            <div id="containerLiv">
                <c:forEach items="${addressLiv}" var="adresseLiv" begin="0" end="0">
                    <div id="liv1">${adresseLiv.companyName}<br> ${adresseLiv.lastName} ${adresseLiv.firstName}<br>${adresseLiv.street}<br>${adresseLiv.streetExtra}<br>${adresseLiv.postcode}<br>${adresseLiv.city}<br>${adresseLiv.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressLiv}" var="adresseLiv" begin="1" end="1">
                    <div id="liv2">${adresseLiv.companyName}<br> ${adresseLiv.lastName} ${adresseLiv.firstName}<br>${adresseLiv.street}<br>${adresseLiv.streetExtra}<br>${adresseLiv.postcode}<br>${adresseLiv.city}<br>${adresseLiv.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressLiv}" var="adresseLiv" begin="2" end="2">
                    <div id="liv3">${adresseLiv.companyName}<br> ${adresseLiv.lastName} ${adresseLiv.firstName}<br>${adresseLiv.street}<br>${adresseLiv.streetExtra}<br>${adresseLiv.postcode}<br>${adresseLiv.city}<br>${adresseLiv.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressLiv}" var="adresseLiv" begin="3" end="3">
                    <div id="liv4">${adresseLiv.companyName}<br> ${adresseLiv.lastName} ${adresseLiv.firstName}<br>${adresseLiv.street}<br>${adresseLiv.streetExtra}<br>${adresseLiv.postcode}<br>${adresseLiv.city}<br>${adresseLiv.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressLiv}" var="adresseLiv" begin="4" end="4">
                    <div id="liv5">${adresseLiv.companyName}<br> ${adresseLiv.lastName} ${adresseLiv.firstName}<br>${adresseLiv.street}<br>${adresseLiv.streetExtra}<br>${adresseLiv.postcode}<br>${adresseLiv.city}<br>${adresseLiv.phone}</div>
                    </c:forEach>
                <div id="liv6"><form method="get" action="adresse"><button class="button" type="submit" name="action" value="livraison"><h3>Ajouter adresse de livraison</h3></button></form></div> 
            </div>
            <h2 id="fac">Adresses de facturation</h2>
            <div id="containerFac">
                <c:forEach items="${addressBil}" var="adresseBil" begin="0" end="0">    
                    <div id="fac1">${adresseBil.companyName}<br> ${adresseBil.lastName} ${adresseBil.firstName}<br>${adresseBil.street}<br>${adresseBil.streetExtra}<br>${adresseBil.postcode}<br>${adresseBil.city}<br>${adresseBil.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressBil}" var="adresseBil" begin="1" end="1">
                    <div id="fac2">${adresseBil.companyName}<br> ${adresseBil.lastName} ${adresseBil.firstName}<br>${adresseBil.street}<br>${adresseBil.streetExtra}<br>${adresseBil.postcode}<br>${adresseBil.city}<br>${adresseBil.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressBil}" var="adresseBil" begin="2" end="2">
                    <div id="fac3">${adresseBil.companyName}<br> ${adresseBil.lastName} ${adresseBil.firstName}<br>${adresseBil.street}<br>${adresseBil.streetExtra}<br>${adresseBil.postcode}<br>${adresseBil.city}<br>${adresseBil.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressBil}" var="adresseBil" begin="3" end="3">    
                    <div id="fac4">${adresseBil.companyName}<br> ${adresseBil.lastName} ${adresseBil.firstName}<br>${adresseBil.street}<br>${adresseBil.streetExtra}<br>${adresseBil.postcode}<br>${adresseBil.city}<br>${adresseBil.phone}</div>
                    </c:forEach>
                    <c:forEach items="${addressBil}" var="adresseBil" begin="4" end="4">    
                    <div id="fac5">${adresseBil.companyName}<br> ${adresseBil.lastName} ${adresseBil.firstName}<br>${adresseBil.street}<br>${adresseBil.streetExtra}<br>${adresseBil.postcode}<br>${adresseBil.city}<br>${adresseBil.phone}</div>
                    </c:forEach>
                <div id="fac6"><form method="get" action="adresse"><button class="button" type="submit" name="action" value="facturation"><h3>Ajouter adresse de facturation</h3></button></form></div> 
            </div>

        </div>

        <footer><jsp:include page="/footerJsp.jsp" /></footer>

    </body>
</html>
