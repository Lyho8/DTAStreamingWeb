<%-- 
    Document   : admin_film_ajouter
    Created on : 20 août 2015, 09:54:04
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
            
            <form method="post">
                <!--<label>Id</label> <input name="id" /><br />-->
                <label>Titre</label><input name="titre" /><br />
                <label>Année</label><input name="annee" /><br />
                <label>Durée</label><input name="duree" /><br />
                <label>Résumé</label><input name="resume" /><br />
                <label>Pays</label>
                <select name="pays">
                    <c:forEach items="${requestScope.mesPays}" var="monPays">
                        <option value="${monPays.id}">${monPays.id}</option>
                    </c:forEach>
                </select><br />
                <label>Genre</label><select name="genre">
                    <c:forEach items="${requestScope.mesGenres}" var="monGenre">
                        <option value="${monGenre.id}">${monGenre.id}</option>
                    </c:forEach>
                </select><br />
                <label>Casting</label><input name="casting" /> <label>Rôle</label> <select name="role">
                        <option value="acteur">Acteur</option>
                        <option value="realisateur">Réalisateur</option>
                </select><br />
                <input type="submit" value="Ajouter" />
            </form>

        </div>
        
        <div class="pied">
            <c:import url="_PIED.jsp" />
        </div>
        
    </body>
    
</html>
