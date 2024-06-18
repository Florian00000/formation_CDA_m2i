<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/06/2024
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="product" type="org.example.exercice6.model.Product" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Ajout d'un produit</title>
</head>
<body>
<div class="container mt-4">
    <% if (product.getId() > 0) {%>
    <h2>Modifier un Produit</h2>
    <% } else {%>
    <h2>Ajouter un Produit</h2>
    <% }%>
    <div>
        <form action="<%= (product.getId() > 0) ? "update?id="+product.getId() : "insert" %>" method="post" >
            <div class="form-row">

                <div class="form-group col-md-6">
                    <label for="inputEmail4">Marque</label>
                    <input type="text" class="form-control" id="inputEmail4" name="marque" value="<%=
                    (product.getId() > 0) ? product.getBrand() : "" %>" >
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Reference</label>
                    <input type="text" class="form-control" id="inputPassword4" name="reference" value="<%=
                    (product.getId() > 0) ? product.getReference() : "" %>"  >
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputAddress">Prix</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="12" name="prix" value="<%=
                    (product.getId() > 0) ? product.getPrice() : "" %>"  >
                </div>
                <div class="form-group col-md-4">
                    <label for="inputAddress2">Stock</label>
                    <input type="text" class="form-control" id="inputAddress2" placeholder="50" name="stock" value="<%=
                    (product.getId() > 0) ? product.getStock() : "" %>" >
                </div>
                <div class="form-group col-md-4">
                    <label for="inputAddress3">Stock</label>
                    <input type="date" class="form-control" id="inputAddress3" placeholder="50" name="dateAchat" value="<%=
                    (product.getId() > 0) ? product.getDateOfPurchase() : "" %>"  >
                </div>
            </div>
            <% if (product.getId() > 0) {%>
            <button type="submit" class="btn btn-primary">Modifier</button>
            <% } else {%>
            <button type="submit" class="btn btn-primary">Ajouter</button>
            <% }%>

            <a href="list" class="btn btn-primary">Annuler</a>
        </form>
    </div>
</div>

</body>
</html>