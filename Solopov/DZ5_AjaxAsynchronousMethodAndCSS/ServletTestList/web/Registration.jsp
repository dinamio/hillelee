<%--
  Created by IntelliJ IDEA.
  User: Username
  Date: 23.04.2018
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registation</title>
    <link href="styles.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="mainblock">
        <h2>Create new account</h2>

        <form action="reg" method="post">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="uname" required>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="psw" required>

            <button type="submit">Registration</button>
        </form>
    </div>
</div>
</body>
</html>
