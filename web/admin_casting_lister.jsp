<%-- 
    Document   : admin_casting_lister
    Created on : 19 août 2015, 16:23:15
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
            <c:forEach items="${requestScope.mesCastings}" var="monCasting">
                ${monCasting.nom} <a href="casting_modifier?id=${monCasting.id}">Modifier</a> <a href="casting_supprimer?id=${monCasting.id}">Supprimer</a>
                <br>
            </c:forEach>
            <a href="casting_ajouter">Ajouter</a>
        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>
