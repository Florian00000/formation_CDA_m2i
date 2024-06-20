<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 20/06/2024
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PatientForm</title>
    <%@include file="/WEB-INF/linkBootstrap.html" %>
</head>
<body>

<%@include file="/WEB-INF/header.html" %>

<main class="container">
    <h1>Ajouter Patient</h1>


    <form method="post" action="${pageContext.request.contextPath}/patient/add" enctype="multipart/form-data">

        <div>
            <label for="name" class="form-label mt-4">Nom</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Nom" required>
        </div>


        <div>
            <label for="firstname" class="form-label mt-4">Prénom</label>
            <input type="text" class="form-control" name="firstname" id="firstname" placeholder="prénom" required>
        </div>

        <div>
            <label for="birthdate" class="form-label mt-4">Date de Naissance</label>
            <input type="date" class="form-control" name="birthdate" id="birthdate" required>
        </div>

        <div>
            <label for="photoFile" class="form-label mt-4">Ajouter une photo</label>
            <input class="form-control" type="file" id="photoFile" name="photoFile" required>
        </div>


        <div>
            <button class="btn btn-outline-secondary mt-3">Ajouter</button>
        </div>
    </form>
</main>
</body>
</html>
