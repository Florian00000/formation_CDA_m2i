<%@ page import="org.example.exercice4.entities.Chat" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="chats" type="java.util.ArrayList<org.example.exercice4.entities.Chat>" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>
<div class="container">
    <h1>Exercice 4 : Des chats, des chats, des chats!!</h1>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Nom</th>
            <th scope="col">Race</th>
            <th scope="col">Repas favoris</th>
            <th scope="col">Date de naissance</th>
        </tr>
        </thead>
        <tbody>
        <% for ( Chat c : chats) { %>
        <tr class="table-secondary">
            <th scope="row">#</th>
            <td><%= c.getNom() %> </td>
            <td><%= c.getRace() %></td>
            <td><%= c.getRepasFavoris() %></td>
            <td><%= c.getDateNaissance().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) %></td>
        </tr>
        <% }%>

        </tbody>
    </table>

    <h2>Ajouter des Chats</h2>

    <form method="post" action="${pageContext.request.contextPath}/exercice4">

        <div>
            <label for="nom" class="form-label mt-4">Nom</label>
            <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom du chat" required>
        </div>

        <div>
            <label for="race" class="form-label mt-4">Race</label>
            <input type="text" class="form-control" name="race" id="race" placeholder="Race du chat" >
        </div>

        <div>
            <label for="repasFavoris" class="form-label mt-4">Repas Favoris</label>
            <input type="text" class="form-control" name="repasFavoris" id="repasFavoris" placeholder="Repas favoris du chat" required>
        </div>

        <div>
            <label for="dateNaissance" class="form-label mt-4">Nom</label>
            <input type="date" class="form-control" name="dateNaissance" id="dateNaissance" >
        </div>
        <div>
            <button class="btn btn-outline-secondary">Ajouter</button>

        </div>

    </form>

</div>


</body>
</html>
