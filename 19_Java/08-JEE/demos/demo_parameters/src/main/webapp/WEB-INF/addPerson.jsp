<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 11/06/2024
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulaire</title>
</head>
<body>

<form method="post" action="form">
    <div>
        <label for="firstname">  FirstName :</label>
        <input type="text" name="firstname" id="firstname">
    </div>
    <div>
        <label for="lastname">  LastName :</label>
        <input type="text" name="lastname" id="lastname">
    </div>
    <div>
        <label for="age">  Age :</label>
        <input type="number"  name="age" id="age">
    </div>

    <% if (mode.equals("modif")) { %>
            <button>Modifier</button>
    <%  } else { %>
    <button>Ajouter</button>
    <% } %>

</form>

</body>
</html>
