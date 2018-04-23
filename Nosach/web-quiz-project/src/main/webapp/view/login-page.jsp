<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <title>Title</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/login-page.css">
</head>
<body>

<div class="account">
    <form name = "add" method="post" action="/login">
        <table>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass"></td>
            </tr>
        </table>
        <input type="submit" name="add" value="Send">
    </form>
</div>

</body>
</html>
