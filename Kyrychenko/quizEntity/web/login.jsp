<%--
  Created by IntelliJ IDEA.
  User: olgag
  Date: 03.05.2018
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentication page</title>
</head>
<body>
    <form name="loginForm" method="post">
        <input type="hidden" value="login"/>
        Login: <br/>
        <input type="text" name="login" value=""/>
        <br/> Password: <br/>
        <input type="password" name="password" value=""/>
        <br/>
            ${wrongAction}
            ${errorLoginPassMessage}
        <br/>
        <input type="submit" onclick="window.location='/authentication'" value="Log in">
        <input type="button" onclick="window.location='/registration'"  value="Sign up">
    </form>
</body>
</html>
