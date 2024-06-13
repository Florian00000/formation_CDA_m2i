<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 13/06/2024
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>

    <main class="container">
        <h1><%=mode.equals("login") ? "Connexion" : "Inscription"%></h1>


        <form method="post" action="${pageContext.request.contextPath}<%=mode.equals("login") ? "/user/login" : "/user/signup"%>">

            <% if (mode.equals("signup")) { %>
            <div>
                <label for="name" class="form-label mt-4">Nom</label>
                <input type="text" class="form-control" name="name" id="name" placeholder="Nom" required >
            </div>
            <% } %>

            <div>
                <label for="mail" class="form-label mt-4">Email</label>
                <input type="email" class="form-control" name="mail" id="mail" placeholder="email@email.com" required >
            </div>

            <div>
                <label for="password" class="form-label mt-4">Mot de passe</label>
                <input type="password" class="form-control" name="password" id="password" required >
            </div>



            <div>
                <button class="btn btn-outline-secondary mt-3"><%=mode.equals("login") ? "Connexion" : "Inscription"%></button>
            </div>
        </form>

        <% if (mode.equals("login")) { %>
        <a href="${pageContext.request.contextPath}/user/signup">Pas encore de compte?</a>
        <% } else { %>
        <a href="${pageContext.request.contextPath}/user/login">Déjà un compte?</a>
        <% } %>
    </main>





</body>
</html>
