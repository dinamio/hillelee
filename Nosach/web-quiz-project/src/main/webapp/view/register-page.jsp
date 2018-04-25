<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/register.css">
</head>
<body>

<div class="register">
    <form name = "add" method="post" action="/register">
        <table>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass"></td>
            </tr>
            <tr>
                <td>email</td>
                <td><input type="text" name="email"></td>
            </tr>
        </table>
        <input type="submit" name="signin" value="Register me">
    </form>

</div>

</body>
</html>
