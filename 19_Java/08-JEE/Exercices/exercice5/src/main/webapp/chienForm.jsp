<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2024
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="idChien" type="java.lang.Integer" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>
<div class="container">
    <h2>Ajouter des Chiens</h2>
    <p><%=idChien%> </p>


    <form method="post" action="${pageContext.request.contextPath}/chiens">

        <div>
            <label for="nom" class="form-label mt-4">Nom</label>
            <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom du chien" required>
        </div>

        <div>
            <label for="race" class="form-label mt-4">Race</label>
            <input type="text" class="form-control" name="race" id="race" placeholder="Race du chien" >
        </div>

        <div>
            <label for="dateNaissance" class="form-label mt-4">Date de naissance</label>
            <input type="date" class="form-control" name="dateNaissance" id="dateNaissance" >
        </div>

        <div>
            <button class="btn btn-outline-secondary">Ajouter</button>
        </div>



    </form>
</div>

</body>
</html>
