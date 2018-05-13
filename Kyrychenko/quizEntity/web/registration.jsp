<%--
  Created by IntelliJ IDEA.
  User: olgag
  Date: 03.05.2018
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<form name="registrationForm" action="authentication" method="post">
    <input type="hidden" name="action" value="registration"/>
    Name:
    <input type="text" name="name" value=""><br/>
    Login:
    <input type="text" name="login" value=""/><br/>
    Password:
    <input type="password" name="password" value=""/><br/>
    ${wrongAction}
    ${loginExist}
    <br/>
    <input type="submit" value="Create An Account">
</form>
</body>
</html>
