<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/06/2024
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="product" type="org.example.exercice6.model.Product" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Produit <%= product.getId() %></title>
</head>
<body>
<div class="container d-flex flex-column justify-content-center h-100 w-50">
    <center>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title">Marque : <%= product.getBrand() %></h5>
                <p class="card-text"><%= product.getReference() %></p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item"><%= product.getPrice() %> €</li>
                <li class="list-group-item"><%= product.getStock() %></li>
                <li class="list-group-item"><%= product.getDateOfPurchase() %></li>
            </ul>
            <div class="card-body">
                <a href="list" class="btn btn-primary">Retour</a>
                <a href="delete?id=<%= product.getId() %>" class="btn btn-danger">Delete</a>
            </div>

        </div>
    </center>
</div>

</body>
</html>
