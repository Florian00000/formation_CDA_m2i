<%@ page import="org.example.exercice6.model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/06/2024
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="products" type="java.util.ArrayList<org.example.exercice6.model.Product>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Liste des Produits</title>
</head>
<body>

<div class="container mt-4">
    <table class="table table-dark text-center">
        <caption><h2>Liste des produits</h2></caption>
        <tr>
            <th>Id</th>
            <th>marque</th>
            <th>reference</th>
            <th>prix</th>
            <th>stock</th>
            <th>Date Achat</th>
            <th>Actions</th>
        </tr>
        <% for (Product p : products) {%>
        <tr>
            <th><%= p.getId() %></th>
            <th><%= p.getBrand() %></th>
            <th><%= p.getReference() %></th>
            <th><%= p.getPrice() %></th>
            <th><%= p.getStock() %></th>
            <th><%= p.getDateOfPurchase() %></th>
            <th>
                <a href="new?id=<%= p.getId() %>" class="btn btn-info">Edit</a>
                <a href="delete?id=<%= p.getId() %>" class="btn btn-danger">Delete</a>
                <a href="details?id=<%= p.getId() %>" class="btn btn-primary">Detail</a>
            </th>
        </tr>
        <% }%>
    </table>

    <div>
        <a href="new">Ajouter un produit</a>
    </div>

</div>

</body>
</html>