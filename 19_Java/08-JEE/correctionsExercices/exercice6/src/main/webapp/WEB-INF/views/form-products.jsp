<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/06/2024
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'un produit</title>
</head>
<body>
<form method="post" action="insert">
    <div>
        <label for="marque" >Marque</label>
        <input type="text" id="marque" name="marque">
    </div>
    <div>
        <label for="reference" >Reference</label>
        <input type="text" id="reference" name="reference">
    </div>
    <div>
        <label for="stock" >Stock</label>
        <input type="number" id="stock" name="stock">
    </div>
    <div>
        <label for="prix" >Prix</label>
        <input type="number" id="prix" name="prix">
    </div>
    <div>
        <label for="dateAchat" >Prix</label>
        <input type="date" id="dateAchat" name="dateAchat">
    </div>

    <button>Validation</button>

</form>

</body>
</html>
