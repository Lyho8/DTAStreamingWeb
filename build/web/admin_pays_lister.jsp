<%-- 
    Document   : admin_pays_lister
    Created on : 19 août 2015, 16:20:59
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    
    <head>
        <c:import url="_STYLESHEETS.jsp" />
        <c:import url="_JAVASCRIPTS.jsp" />
    </head>

    <body>
        
        <div class="menu">
            <c:import url="_MENU.jsp" />
        </div>
        
        <div class="contenu">
            <c:forEach items="${requestScope.mesPays}" var="monPays">
                ${monPays.id} <a href="pays_modifier?id=${monPays.id}">Modifier</a> <a href="pays_supprimer?id=${monPays.id}">Supprimer</a>
                <br>
            </c:forEach>
            <a href="pays_ajouter">Ajouter</a>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>