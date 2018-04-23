<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form method="POST" action="quiz">
    <table border="0">

        <tr>
            <td><input type="text" name="login" size="65"/></td>
            <td><input type="text" name="pwd" size="65"/></td>
            <td><input type="submit" name="submit" value="Sign in"/></td>
            <td> or </td>
            <td><input type="submit" onclick="<%session.setAttribute("login", request.getParameter("login"));
                                              session.setAttribute("pwd", request.getParameter("pwd"));%>
                                            " value="Sign up"/></td>
        </tr>
    </table>
</form>
</body>
</html>