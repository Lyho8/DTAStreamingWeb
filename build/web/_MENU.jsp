<%-- 
    Document   : _MENU
    Created on : 19 août 2015, 15:54:49
    Author     : ETY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
    Cookie cookie = null;
    Cookie[] cookies = null;
    // Get an array of Cookies associated with this domain
    cookies = request.getCookies();
    Boolean b = true;
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if (cookie.getName().equals("login")) {
                b=false;
                out.println("<h3>" + cookie.getValue() + "</h3> <a href=\"login\">Log out</a><br />");

                if (cookie.getValue().equals("admin")) {
                    out.println("<a href=\"film_lister\">Films</a> <a href=\"genre_lister\">Genres</a> <a href=\"casting_lister\">Castings</a> <a href=\"pays_lister\">Pays</a>");
                    break;
                }
            }
        }
        
    } 
    if(b){            
        out.println("<a href=\"login\">Log in</a>");
    }
--%>

<%--<p><c:if test="${not empty cookie.login}">
    <c:if test="${cookie.login.value==''}">
        Bonjour invité  <a href="login">Log in</a>
    </c:if>
        
    <c:if test="${cookie.login.value!=''}">
        Bonjour ${cookie.login.value}    <a href="login">Log out</a>
    </c:if>
    
</c:if></p>

<p><c:if test="${empty cookie.login}">
    Bonjour invité  <a href="login">Log in</a>
</c:if></p>

<p><c:if test="${cookie.login.value=='admin'}">
    <a href="film_lister">Films</a> <a href="genre_lister">Genres</a> <a href="casting_lister">Castings</a> <a href="pays_lister">Pays</a>
</c:if></p>--%>

<p><c:if test="${not empty sessionScope.login}">
    <c:if test="${sessionScope.login==''}">
        Bonjour invité  <a href="login">Log in</a>
    </c:if>
        
    <c:if test="${sessionScope.login!=''}">
        Bonjour ${sessionScope.login}    <a href="login">Log out</a>
    </c:if>
    
</c:if></p>

<p><c:if test="${empty sessionScope.login}">
    Bonjour invité  <a href="login">Log in</a>
</c:if></p>

<p><c:if test="${sessionScope.login=='admin'}">
    <a href="film_lister">Films</a> <a href="genre_lister">Genres</a> <a href="casting_lister">Castings</a> <a href="pays_lister">Pays</a>
</c:if></p>


