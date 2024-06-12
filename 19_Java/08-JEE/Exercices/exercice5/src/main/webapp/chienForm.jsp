<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2024
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="idChien" type="java.lang.Integer" scope="request"/>
<jsp:useBean id="chien" type="org.example.exercice5.entities.Chien" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>
<div class="container">
    <h2><%= (idChien < 0 ? " Ajouter des Chiens" : "Informations")%> </h2>


    <form method="post" action="${pageContext.request.contextPath}/chiens">

        <div>
            <label for="nom" class="form-label mt-4">Nom</label>
            <% if (idChien < 0) { %>
                <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom du chien" required >
            <% } else { %>
                <input type="text" class="form-control" name="nom" id="nom" value="<%=chien.getNom()%>" readonly >
            <% }%>
        </div>

        <div>
            <label for="race" class="form-label mt-4">Race</label>
            <% if (idChien < 0) { %>
            <input type="text" class="form-control" name="race" id="race" placeholder="Race du chien" >
            <% } else { %>
            <input type="text" class="form-control" name="race" id="race" value="<%=chien.getRace()%>" readonly >
            <% }%>
        </div>

        <div>
            <label for="dateNaissance" class="form-label mt-4">Date de naissance</label>
            <% if (idChien < 0) { %>
            <input type="date" class="form-control" name="dateNaissance" id="dateNaissance" >
            <% } else { %>
            <input type="date" class="form-control" name="dateNaissance" id="dateNaissance" value="<%=chien.getDateNaissance()%>" readonly >
            <% }%>
        </div>

        <%if (idChien < 0) { %>
            <div>
                <button class="btn btn-outline-secondary">Ajouter</button>
            </div>

        <% } else{ %>
            <div>
                <a href="${pageContext.request.contextPath}/chiens" class="btn btn-outline-info mt-3">Retour</a>
            </div>
        <% } %>
    </form>
</div>

</body>
</html>
