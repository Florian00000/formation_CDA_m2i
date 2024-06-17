<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 17/06/2024
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h2>Register</h2>
<form action="signup" method="post">
    <div>
        <label for="name" >Nom</label>
        <input type="text" id="name" name="inputName">
    </div>
    <div>
        <label for="email" >Email</label>
        <input type="text" id="email" name="inputEmail">
    </div>
    <div>
        <label for="password" >password</label>
        <input type="password" id="password" name="inputPassword">
    </div>
    <button>Register</button>
</form>

</body>
</html>
